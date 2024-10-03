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

    protected List<LineaPedido> loadAllLineaPedido() throws SQLException {

        List<LineaPedido> lineasPedido = new ArrayList<>();
        try (PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM LineaPedido"); ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                LineaPedido lineaPedido = readLineaPedidoFromResultSet(result);
                lineasPedido.add(lineaPedido);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar las lineas del pedido: " + e.getMessage());
        }
        return lineasPedido;
    }

    protected List<LineaPedido> loadLineaPedidoContaining(String content) throws SQLException {
        List<LineaPedido> lineasPedidos = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM LineaPedido WHERE idLineaPedido LIKE ?");
        stmt.setString(1, content);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            lineasPedidos.add(readLineaPedidoFromResultSet(result));
        }
        return lineasPedidos;
    }
    
}
