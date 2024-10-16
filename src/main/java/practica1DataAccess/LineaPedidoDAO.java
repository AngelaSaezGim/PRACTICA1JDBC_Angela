/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import practica1Objetos.LineaPedido;
import practica1Objetos.Pedido;

/**
 *
 * @author angsaegim
 */
public class LineaPedidoDAO extends DataAccessObject {

    LineaPedidoDAO(Connection cnt) {
        super(cnt);
    }

    private class LineaPedidoTableColumns {

        private final static String COLUMN_IDLINEAPEDIDO = "idLineaPedido";
        private final static String COLUMN_IDPEDIDO = "idPedido";
        private final static String COLUMN_IDARTICULO = "idArticulo";
        private final static String COLUMN_CANTIDAD = "cantidad";
    }

    private static LineaPedido readLineaPedidoFromResultSet(ResultSet rs) throws SQLException {

        int idLineaPedido = rs.getInt(LineaPedidoDAO.LineaPedidoTableColumns.COLUMN_IDLINEAPEDIDO);
        int idPedido = rs.getInt(LineaPedidoDAO.LineaPedidoTableColumns.COLUMN_IDPEDIDO);
        int idArticulo = rs.getInt(LineaPedidoDAO.LineaPedidoTableColumns.COLUMN_IDARTICULO);
        int cantidad = rs.getInt(LineaPedidoDAO.LineaPedidoTableColumns.COLUMN_CANTIDAD);

        LineaPedido lineaPedido = new LineaPedido(idLineaPedido, idPedido, idArticulo, cantidad);
        return lineaPedido;
    }

    protected List<LineaPedido> loadAllLineasPedido() throws SQLException {

        List<LineaPedido> lineasPedido = new ArrayList<>();
        try ( PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM LineaPedido");  ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                LineaPedido lineaPedido = readLineaPedidoFromResultSet(result);
                lineasPedido.add(lineaPedido);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar las lineas del pedido: " + e.getMessage());
        }
        return lineasPedido;
    }

    protected List<LineaPedido> loadLineasPedidoContaining(String content) throws SQLException {
        List<LineaPedido> lineasPedidos = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM LineaPedido WHERE idLineaPedido LIKE ?");
        stmt.setString(1, content);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            lineasPedidos.add(readLineaPedidoFromResultSet(result));
        }
        return lineasPedidos;
    }

    protected int insertLineaPedido(LineaPedido lineaPedido) throws SQLException {
        int filasAfectadas = 0;

        // Consulta SQL para insertar una nueva línea de pedido
        String sentenciaSQL = "INSERT INTO LineaPedido ("
                + LineaPedidoTableColumns.COLUMN_IDLINEAPEDIDO + ", "
                + LineaPedidoTableColumns.COLUMN_IDPEDIDO + ", "
                + LineaPedidoTableColumns.COLUMN_IDARTICULO + ", "
                + LineaPedidoTableColumns.COLUMN_CANTIDAD + ") "
                + "VALUES (?, ?, ?, ?)";

        try ( PreparedStatement stmt = cnt.prepareStatement(sentenciaSQL)) {

            // Generar el nuevo id para la línea de pedido (puedes usar una función similar a obtenerMaxId())
            int idLineaPedido = obtenerMaxId() + 1;
            stmt.setInt(1, idLineaPedido);
            stmt.setInt(2, lineaPedido.getIdPedido());
            stmt.setInt(3, lineaPedido.getIdArticulo());
            stmt.setInt(4, lineaPedido.getCantidad());

            // Ejecutar la consulta
            filasAfectadas = stmt.executeUpdate();

            // Establecer el nuevo ID a la línea de pedido
            lineaPedido.setIdLineaPedido(idLineaPedido);
        } catch (SQLException e) {
            System.err.println("Error al insertar la línea de pedido: " + e.getMessage());
            throw e;
        }

        return filasAfectadas;
    }

    private Integer obtenerMaxId() throws SQLException {

        PreparedStatement stmt = cnt.prepareStatement("SELECT max(idLineaPedido) FROM LineaPedido");
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            return result.getInt(1);
        } else {
            return 0;
        }
    }

    protected boolean pedidoExiste(int idPedido) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Pedido WHERE idPedido = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    protected boolean articuloExiste(int idArticulo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Articulo WHERE idArticulo = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setInt(1, idArticulo);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    protected int deleteLineaPedido(String idLineaPedido) {

        int filasAfectadas = 0;

        try ( PreparedStatement stmt = cnt.prepareStatement("DELETE FROM LineaPedido WHERE idLineaPedido = ?")) {
            stmt.setString(1, idLineaPedido);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }

        return filasAfectadas;
    }

    protected LineaPedido loadLineaPedidoByCode(String idLineaPedido) throws SQLException {
        LineaPedido lineaPedido = null;
        String sql = "SELECT * FROM LineaPedido WHERE idLineaPedido = ?";

        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setString(1, idLineaPedido);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                lineaPedido = readLineaPedidoFromResultSet(result);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar la línea de pedido con ID " + idLineaPedido + ": " + e.getMessage());
        }

        return lineaPedido;
    }

    protected int updateLineaPedido(String idLineaPedido, LineaPedido lineaPedidoActualizar) throws SQLException {
        int filasAfectadas = 0;

        String sql = "UPDATE LineaPedido SET idPedido = ?, idArticulo = ?, cantidad = ? WHERE idLineaPedido = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setInt(1, lineaPedidoActualizar.getIdPedido());
            stmt.setInt(2, lineaPedidoActualizar.getIdArticulo());
            stmt.setInt(3, lineaPedidoActualizar.getCantidad());
            stmt.setString(4, idLineaPedido);

            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar la línea de pedido con ID " + idLineaPedido + ": " + e.getMessage());
        }

        return filasAfectadas;
    }

    //METODO 1 
    protected List<LineaPedido> filtrarPedidos(List<Pedido> pedidosFilteredByClient) throws SQLException {

        List<LineaPedido> listaLineasPedidoCliente = new ArrayList<>();

        if (pedidosFilteredByClient == null || pedidosFilteredByClient.isEmpty()) {
            System.out.println("La lista de pedidos esta vacía");
            return listaLineasPedidoCliente;
        }
        // IN - busca TODAS las líneas de pedido (varias) cuyo idPedido se encuentre en una lista de pedidos
        StringBuilder query = new StringBuilder("SELECT * FROM LineaPedido WHERE idPedido IN (");
        
        //CONSTRUCCION DE LA QUERY
        // PLACEHOLDER ? por cada pedido en la lista pedidosFilteredByClient 
        for (int i = 0; i < pedidosFilteredByClient.size(); i++) {
            query.append("?");
            if (i < pedidosFilteredByClient.size() - 1) {
                query.append(", ");
            }
        }
        query.append(")");
        //FIN DE CONSTRUCCION DE LA QUERY
        
        PreparedStatement stmt = cnt.prepareStatement(query.toString()); //Aplicamos la query en los datos

        // unir valores de idPedido a los placeholders 
        for (int i = 0; i < pedidosFilteredByClient.size(); i++) {
            stmt.setInt(i + 1, pedidosFilteredByClient.get(i).getIdPedido());
        }
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            listaLineasPedidoCliente.add(readLineaPedidoFromResultSet(result));
        }

        return listaLineasPedidoCliente;
    }

    //METODO 3
    // Obtener todas las líneas de pedido asociadas a estos pedidos
    protected List<LineaPedido> filtrarLineasPedidosIdPedido(String idPedidoStr) throws SQLException {
        List<LineaPedido> listaLineasPedido = new ArrayList<>();

        String sql = "SELECT * FROM LineaPedido WHERE idPedido = ?";

        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setString(1, idPedidoStr);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                int idLineaPedido = result.getInt("idLineaPedido");
                int idArticulo = result.getInt("idArticulo");
                int cantidad = result.getInt("cantidad");

                int idPedido = Integer.parseInt(idPedidoStr);

                LineaPedido linea = new LineaPedido(idLineaPedido, idPedido, idArticulo, cantidad);
                listaLineasPedido.add(linea);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al listar las líneas del pedido con ID " + idPedidoStr + ": " + e.getMessage());
        }

        return listaLineasPedido;
    }

}
