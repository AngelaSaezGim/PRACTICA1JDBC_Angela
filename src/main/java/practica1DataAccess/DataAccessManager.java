/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1DataAccess;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import static practica1DataAccess.Constans.*;
import practica1Objetos.Articulo;
import practica1Objetos.Cliente;
import practica1Objetos.Fabrica;
import practica1Objetos.Pedido;
import practica1Objetos.ArticuloFabrica;
import practica1Objetos.DireccionEnvio;
import practica1Objetos.FabricaAlternativa;
import practica1Objetos.LineaPedido;

/**
 *
 * @author angsaegim
 */
public class DataAccessManager implements AutoCloseable {

    /**
     * ************************ PARTE ESTÁTICA ****************************
     */
    private static String dataBaseUser = DEFAULT_DATA_BASE__USER;
    private static String dataBasePwd = DEFAULT_DATA_BASE__PWD;
    private static String dataBaseURL = DEFAULT_DATA_BASE__URL;

    private static DataAccessManager singleton;

    // Instanciamos un único objeto DataAccessManager - SINGLETON
    protected DataAccessManager() {

    }

    /**
     * Los métodos de acceso a datos se pueden ejecutar con el objeto devuelto
     * por esta función
     *
     * @return el mánager de acceso a datos con todas las sentencias embebidas
     */
    public static DataAccessManager getInstance() {
        if (singleton == null) {
            loadDataBaseParams();
            singleton = new DataAccessManager();
            try {
                singleton.cnx = createConnection();
                singleton.clienteDAO = new ClienteDAO(singleton.cnx);
                singleton.articuloDAO = new ArticuloDAO(singleton.cnx);
                singleton.fabricaDAO = new FabricaDAO(singleton.cnx);
                singleton.articuloFabricaDAO = new ArticuloFabricaDAO(singleton.cnx);
                singleton.direccionEnvioDAO = new DireccionEnvioDAO(singleton.cnx);
                singleton.fabricaAlternativaDAO = new FabricaAlternativaDAO(singleton.cnx);
                singleton.lineaPedidoDAO = new LineaPedidoDAO(singleton.cnx);
                singleton.pedidoDAO = new PedidoDAO(singleton.cnx);

            } catch (Exception e) {
                singleton = null;
                throw new RuntimeException(e);
            }

        }
        return singleton;
    }

    /**
     * Para saber si la inicialización del objeto singleton ha funcionado con
     * éxito
     *
     * @return
     */
    public static boolean connectionEnabled() {
        return singleton != null;
    }

    /**
     * Carga las credenciales y URL de acceso a datos de un fichero de
     * configuración situado en {@link Constants#DB_CONFIG__FILE_NAME} . En caso
     * de IOException, se usan las credenciales por defecto
     */
    private static void loadDataBaseParams() {

        Properties pDataBaseConfiguration = null;
        FileReader dbReaderStream = null;
        try {
            dbReaderStream = new FileReader(DB_CONFIG__FILE_NAME);
            pDataBaseConfiguration = new Properties();
            pDataBaseConfiguration.load(dbReaderStream);
        } catch (IOException e) {
            System.out.println("Error en la carga de la configuración de la base de datos. Se sigue adelante con la ejecución por defecto. " + e.getMessage());

        } finally {
            try {
                if (dbReaderStream != null) {
                    dbReaderStream.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error al cerrar el flujo de lectura del fichero de configuración. Se ignora el error. " + ioe.getMessage());
            }
        }
        //si se han cargado las properties, se asignan a las propiedades estáticas de los parámetros configurados
        if (pDataBaseConfiguration != null) {
            if (pDataBaseConfiguration.getProperty(DB_CONFIG__USER_PROPERTY) != null) {
                dataBaseUser = pDataBaseConfiguration.getProperty(DB_CONFIG__USER_PROPERTY);
            }
            if (pDataBaseConfiguration.getProperty(DB_CONFIG__PWD_PROPERTY) != null) {
                dataBasePwd = pDataBaseConfiguration.getProperty(DB_CONFIG__PWD_PROPERTY);
            }
            if (pDataBaseConfiguration.getProperty(DB_CONFIG__URL_PROPERTY) != null) {
                dataBaseURL = pDataBaseConfiguration.getProperty(DB_CONFIG__URL_PROPERTY);
            }
        }
    }

    /**
     * ************************ PARTE DINÁMICA ****************************
     */
    //para conectar y ejecutar las SQL en la bbdd
    private Connection cnx;

    private ArticuloDAO articuloDAO;
    private ClienteDAO clienteDAO;
    private FabricaDAO fabricaDAO;
    private ArticuloFabricaDAO articuloFabricaDAO;
    private DireccionEnvioDAO direccionEnvioDAO;
    private FabricaAlternativaDAO fabricaAlternativaDAO;
    private LineaPedidoDAO lineaPedidoDAO;
    private PedidoDAO pedidoDAO;

    private static Connection createConnection() {

        try {
            Class.forName(MYSQL_DB_DRIVER__CLASS_NAME);
            Connection cnt = DriverManager.getConnection(dataBaseURL, dataBaseUser, dataBasePwd);
            cnt.setAutoCommit(true);
            return cnt;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("No se ha encontrado el driver. Revise la carpeta lib en busca del driver jdbc de MySQL. " + cnfe.getMessage());
            return null;
        } catch (SQLException sqle) {
            StringBuilder sb = new StringBuilder()
                    .append("Existe un problema de conexión a la base de datos. ")
                    .append("Revise: \n")
                    .append("\t- Que tiene levantado el servidor de MySQL.\n")
                    .append("\t- Que la base de datos Practica1 está instalada.\n")
                    .append("\t- Que la configuración del fichero resources/db.properties es corecta.\n")
                    .append("Error: ")
                    .append(sqle.getMessage());
            System.out.println(sb.toString());
            return null;
        }

    }

    @Override
    public void close() {
        try {
            if (cnx != null && !cnx.isClosed()) {
                cnx.close();
                cnx = null;
                articuloDAO = null;
                clienteDAO = null;
                fabricaDAO = null;
                pedidoDAO = null;
            }
        } catch (SQLException sqe) {
            System.out.println("Error al cerrar la conexión a datos. " + sqe.getMessage());
        } finally {
            singleton = null;
        }
    }

    /* FUNCIONES CON DATOS */
 /*--------------SELECT - TODO*------------------------*/
    public List<Articulo> loadAllArticulos() throws SQLException {

        return this.articuloDAO.loadAllArticulos();
    }

    public List<Cliente> loadAllClientes() throws SQLException {

        return this.clienteDAO.loadAllClientes();
    }

    public List<ArticuloFabrica> loadAllArticulosFabrica() throws SQLException {

        return this.articuloFabricaDAO.loadAllArticulosFabricas();
    }

    public List<Cliente> loadAllClientesFabrica() throws SQLException {

        return this.clienteDAO.loadAllClientes();
    }

    public List<DireccionEnvio> loadAllDireccionesEnvio() throws SQLException {

        return this.direccionEnvioDAO.loadAllDireccionesEnvio();

    }

    public List<FabricaAlternativa> loadAllFabricasAlternativas() throws SQLException {

        return this.fabricaAlternativaDAO.loadAllFabricasAlternativas();

    }

    public List<Fabrica> loadAllFabricas() throws SQLException {

        return this.fabricaDAO.loadAllFabricas();

    }

    public List<LineaPedido> loadAllLineasPedido() throws SQLException {

        return this.lineaPedidoDAO.loadAllLineasPedido();

    }

    public List<Pedido> loadAllPedidos() throws SQLException {

        return this.pedidoDAO.loadAllPedidos();

    }

    /*----------------------------------------------------------*/

 /*--------------SELECT - CONTAINING *------------------------*/
    public List<Articulo> loadArticulosContaining(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.articuloDAO.loadArticulosContaining(content);
    }

    public List<ArticuloFabrica> loadArticulosFabricaContaining(String content, String content2) throws SQLException {
        // Verificación de los parámetros antes de la consulta
        if (content == null || content.isEmpty() || content2 == null || content2.isEmpty()) {
            throw new IllegalArgumentException("Los valores de idArticulo o idFabrica son vacíos o nulos.");
        }

        return this.articuloFabricaDAO.loadAllArticulosFabricaContaining(content, content2);
    }

    public List<Cliente> loadClientesContaining(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.clienteDAO.loadClienteContaining(content);
    }

    public List<DireccionEnvio> loadDireccionEnvioContaining(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.direccionEnvioDAO.loadDireccionEnvioContaining(content);
    }

    public List<FabricaAlternativa> loadFabricaAlternativaContaining(String content, String content2) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        if (content2 == null || content2.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.fabricaAlternativaDAO.loadFabricaAlternativaContaining(content, content2);
    }

    public List<Fabrica> loadFabricasContaining(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.fabricaDAO.loadFabricasContaining(content);
    }

    public List<LineaPedido> loadLineasPedidoContaining(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.lineaPedidoDAO.loadLineasPedidoContaining(content);
    }

    public List<Pedido> loadPedidosContaining(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.pedidoDAO.loadPedidosContaining(content);
    }

    /*----------------------------------------------------------*/
 /*-------------------------INSERT---------------------------------*/
    public int insertarArticulo(Articulo articulo) throws SQLException {
        return this.articuloDAO.insertArticulo(articulo);
    }

    public int insertarArticuloFabrica(ArticuloFabrica articuloFabrica) throws SQLException {
        return this.articuloFabricaDAO.insertArticuloFabrica(articuloFabrica);
    }

    // PARA ARTICULO FABRICA Y FABRICA ALTERNATIVA
    public boolean fabricaExiste(int idFabrica) throws SQLException {
        return this.articuloFabricaDAO.fabricaExiste(idFabrica);
    }

    public int insertarCliente(Cliente cliente) throws SQLException {
        return this.clienteDAO.insertCliente(cliente);
    }

    public int insertarDireccionEnvio(DireccionEnvio direccion) throws SQLException {
        return this.direccionEnvioDAO.insertDireccionEnvio(direccion);
    }

    // PARA DIRECCION ENVIO Y PEDIDO
    public boolean clienteExiste(int idCliente) throws SQLException {
        return this.direccionEnvioDAO.clienteExiste(idCliente);
    }

    public int insertarFabricaAlternativa(FabricaAlternativa fabricaAlternativa) throws SQLException {
        return this.fabricaAlternativaDAO.insertFabricaAlternativa(fabricaAlternativa);
    }

    public int insertarFabrica(Fabrica fabrica) throws SQLException {
        return this.fabricaDAO.insertFabrica(fabrica);
    }

    public int insertarLineaPedido(LineaPedido lineaPedido) throws SQLException {
        return this.lineaPedidoDAO.insertLineaPedido(lineaPedido);
    }

    public boolean pedidoExiste(int idPedido) throws SQLException {
        return this.lineaPedidoDAO.pedidoExiste(idPedido);
    }

    public boolean articuloExiste(int idArticulo) throws SQLException {
        return this.lineaPedidoDAO.articuloExiste(idArticulo);
    }

    public int insertarPedido(Pedido pedido) throws SQLException {
        return this.pedidoDAO.insertPedido(pedido);
    }

    public boolean direccionExiste(int idDireccion) throws SQLException {
        return this.pedidoDAO.direccionExiste(idDireccion);
    }

    //DELETE
    public int borrarArticulo(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.articuloDAO.deleteArticulo(content);
    }

    public int borrarArticuloFabrica(String content, String content2) throws SQLException {
        if ((content == null || content.length() == 0) && (content2 == null || content2.length() == 0)) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.articuloFabricaDAO.deleteArticuloFabrica(content, content2);
    }

    public int borrarCliente(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.clienteDAO.deleteCliente(content);
    }

    public int borrarDireccionEnvio(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.direccionEnvioDAO.deleteDireccion(content);
    }

    public int borrarFabricaAlternativa(String content, String content2) throws SQLException {
        if ((content == null || content.length() == 0) && (content2 == null || content2.length() == 0)) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.fabricaAlternativaDAO.deleteFabricaAlternativa(content, content2);
    }

    public int borrarFabrica(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.fabricaDAO.deleteFabrica(content);
    }

    public int borrarLineaPedido(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.lineaPedidoDAO.deleteLineaPedido(content);
    }

    public int borrarPedido(String content) throws SQLException {
        if (content == null || content.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }

        return this.pedidoDAO.deletePedido(content);
    }

    /**
     * UPDATE*
     */
    public Articulo loadArticuloByCode(String idArticulo) throws SQLException {
        if (idArticulo == null || idArticulo.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.articuloDAO.loadArticuloByCode(idArticulo);
    }

    public int updateArticulo(String idArticulo, Articulo articuloActualizar) throws SQLException {
        if (idArticulo == null || articuloActualizar == null) {
            throw new IllegalArgumentException("El id del articulo y el articulo a actualizar no deben ser nulos.");
        }
        return this.articuloDAO.updateArticulo(idArticulo, articuloActualizar);
    }

    public ArticuloFabrica loadArticuloFabricaByCode(String idArticulo, String idFabrica) throws SQLException {
        if ((idArticulo == null || idArticulo.length() == 0) || (idFabrica == null || idFabrica.length() == 0)) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.articuloFabricaDAO.loadArticuloFabricaByCode(idArticulo, idFabrica);
    }

    public int updateArticuloFabrica(String idArticulo, String idFabrica, ArticuloFabrica articuloFabricaActualizar) throws SQLException {
        if (idArticulo == null || idFabrica == null || articuloFabricaActualizar == null) {
            throw new IllegalArgumentException("El id del articulo, el id de la fabrica y el articulo fabrica a actualizar no deben ser nulos.");
        }
        return this.articuloFabricaDAO.updateArticuloFabrica(idArticulo, idFabrica, articuloFabricaActualizar);
    }

    public Cliente loadClienteByCode(String idCliente) throws SQLException {
        if ((idCliente == null || idCliente.length() == 0)) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.clienteDAO.loadClienteByCode(idCliente);
    }

    public int updateCliente(String idCliente, Cliente clienteActualizar) throws SQLException {
        if (idCliente == null || clienteActualizar == null) {
            throw new IllegalArgumentException("El id del cliente y el cliente a actualizar no deben ser nulos.");
        }
        return this.clienteDAO.updateCliente(idCliente, clienteActualizar);
    }

    public DireccionEnvio loadDireccionEnvioByCode(String idDireccionEnvio) throws SQLException {
        if ((idDireccionEnvio == null || idDireccionEnvio.length() == 0)) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.direccionEnvioDAO.loadDireccionEnvioByCode(idDireccionEnvio);
    }

    public int updateDireccionEnvio(String idDireccionEnvio, DireccionEnvio direccionEnvioActualizar) throws SQLException {
        if (idDireccionEnvio == null || direccionEnvioActualizar == null) {
            throw new IllegalArgumentException("El id de la direccion y la direccion a actualizar no deben ser nulos.");
        }
        return this.direccionEnvioDAO.updateDireccionEnvio(idDireccionEnvio, direccionEnvioActualizar);
    }

    public FabricaAlternativa loadFabricaAlternativaByCode(String idFabricaPrincipal, String idFabricaAlternativa) throws SQLException {
        if (idFabricaPrincipal == null || idFabricaPrincipal.isEmpty()
                || idFabricaAlternativa == null || idFabricaAlternativa.isEmpty()) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.fabricaAlternativaDAO.loadFabricaAlternativaByCode(idFabricaPrincipal, idFabricaAlternativa);
    }

    public int updateFabricaAlternativa(String idFabricaPrincipal, String idFabricaAlternativa, FabricaAlternativa fabricaAlternativaActualizar) throws SQLException {
        if (idFabricaPrincipal == null || idFabricaAlternativa == null || fabricaAlternativaActualizar == null) {
            throw new IllegalArgumentException("El ID de la fábrica principal, el ID de la fábrica alternativa y el objeto a actualizar no deben ser nulos.");
        }
        return this.fabricaAlternativaDAO.updateFabricaAlternativa(idFabricaPrincipal, idFabricaAlternativa, fabricaAlternativaActualizar);
    }

    public boolean fabricaAlternativaExiste(String idFabricaPrincipal, String idFabricaAlternativa) throws SQLException {
        return this.fabricaAlternativaDAO.fabricaAlternativaExiste(idFabricaPrincipal, idFabricaPrincipal);
    }

    public Fabrica loadFabricaByCode(String idFabrica) throws SQLException {
        if (idFabrica == null || idFabrica.isEmpty()) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.fabricaDAO.loadFabricaByCode(idFabrica);
    }

    public int updateFabrica(String idFabrica, Fabrica fabricaActualizar) throws SQLException {
        if (idFabrica == null || fabricaActualizar == null) {
            throw new IllegalArgumentException("El ID de la fábrica y el objeto a actualizar no deben ser nulos.");
        }
        return this.fabricaDAO.updateFabrica(idFabrica, fabricaActualizar);
    }

    public LineaPedido loadLineaPedidoByCode(String idLineaPedido) throws SQLException {
        if (idLineaPedido == null || idLineaPedido.isEmpty()) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.lineaPedidoDAO.loadLineaPedidoByCode(idLineaPedido);
    }

    public int updateLineaPedido(String idLineaPedido, LineaPedido lineaPedidoActualizar) throws SQLException {
        if (idLineaPedido == null || lineaPedidoActualizar == null) {
            throw new IllegalArgumentException("El ID de la linea de pedido y el objeto Linea Pedido no deben ser nulos.");
        }
        return this.lineaPedidoDAO.updateLineaPedido(idLineaPedido, lineaPedidoActualizar);
    }

    public Pedido loadPedidoByCode(String idPedido) throws SQLException {
        if (idPedido == null || idPedido.isEmpty()) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.pedidoDAO.loadPedidoByCode(idPedido);
    }

    public int updatePedido(String idPedido, Pedido pedidoActualizar) throws SQLException {
        if (idPedido == null || idPedido.isEmpty() || pedidoActualizar == null) {
            throw new IllegalArgumentException("El ID del pedido no debe ser nulo ni vacío y el objeto Pedido no debe ser nulo.");
        }
        return this.pedidoDAO.updatePedido(idPedido, pedidoActualizar);
    }

    public List<Fabrica> getTotalArticulosPorFabrica() throws SQLException {
        return this.fabricaDAO.getTotalArticulosPorFabrica();
    }

    //METODO 1 

    public List<Pedido> listarPedidosCliente(String idCliente) throws SQLException {
        if (idCliente == null || idCliente.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.pedidoDAO.listarPedidosCliente(idCliente);
    }


    public List<LineaPedido> filtrarPedidos(List<Pedido> pedidosCliente) throws SQLException {
        if (pedidosCliente == null) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.lineaPedidoDAO.filtrarPedidos(pedidosCliente);
    }


    public double sacarPrecioArticulo(String idArticulo) throws SQLException {
        if (idArticulo == null || idArticulo.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return articuloFabricaDAO.sacarPrecioArticulo(idArticulo);
    }


    public double sacarDescuento(String idCliente) throws SQLException {
        if (idCliente == null || idCliente.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return clienteDAO.sacarDescuento(idCliente);
    }

    //METODO 2
    public List<String> filtrarFabricasSinPedido() throws SQLException {
        return this.articuloFabricaDAO.filtrarFabricasSinPedido();
    }

    public int borrarFabricasSinArticulosAsociadosAPedido(List<String> fabricasSinPedido) throws SQLException {
        if (fabricasSinPedido == null || fabricasSinPedido.isEmpty()) {
            System.out.println("No se encontraron fábricas sin artículos asociados a pedidos.");
        }
        return this.fabricaDAO.borrarFabricasSinArticulosAsociadosAPedido(fabricasSinPedido);
    }

    //METODO 3
    public List<Pedido> listarPedidosPorAño(int inputAño) throws SQLException {
        if (inputAño == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.pedidoDAO.listarPedidosPorAño(inputAño);
    }

    public List<LineaPedido> filtrarLineasPedidosIdPedido(String idPedidoStr) throws SQLException {
        if (idPedidoStr == null || idPedidoStr.length() == 0) {
            throw new IllegalArgumentException("Debe indicar el filtro de búsqueda");
        }
        return this.lineaPedidoDAO.filtrarLineasPedidosIdPedido(idPedidoStr);
    }

}
