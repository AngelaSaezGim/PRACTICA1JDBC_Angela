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
    private DataAccessManager() {

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
    private PedidoDAO pedidoDAO;
    private ArticuloFabricaDAO articuloFabricaDAO;
    private DireccionEnvioDAO direccionEnvioDAO;
    private FabricaAlternativaDAO fabricaAlternativaDAO;
    private LineaPedidoDAO lineaPedidoDAO;

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
                    .append("\t- Que la base de datos Jardineri está instalada.\n")
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
}
