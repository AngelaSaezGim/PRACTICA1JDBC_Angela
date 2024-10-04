/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import practica1Objetos.Pedido;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angsaegim
 */
public class PedidoDAO extends DataAccessObject {

    PedidoDAO(Connection cnt) {
        super(cnt);
    }

    private class PedidoTableColumns {

        private final static String COLUMN_IDPEDIDO = "idPedido";
        private final static String COLUMN_FECHA = "fecha";
        private final static String COLUMN_NUMEROCOMANDA = "numeroComanda";
        private final static String COLUMN_IDCLIENTE = "idCliente";
        private final static String COLUMN_IDDIRECCION = "idDireccion";
    }
    
       private static Pedido readPedidoFromResultSet(ResultSet rs) throws SQLException {

        int idPedido = rs.getInt(PedidoDAO.PedidoTableColumns.COLUMN_IDPEDIDO);
        Timestamp fecha = rs.getTimestamp(PedidoDAO.PedidoTableColumns.COLUMN_FECHA);
        int numeroComanda = rs.getInt(PedidoDAO.PedidoTableColumns.COLUMN_NUMEROCOMANDA);
        int idCliente = rs.getInt(PedidoDAO.PedidoTableColumns.COLUMN_IDCLIENTE);
        int idDireccion = rs.getInt(PedidoDAO.PedidoTableColumns.COLUMN_IDDIRECCION);
        
        Pedido pedido = new Pedido(idPedido, fecha, numeroComanda, idCliente, idDireccion);
        return pedido;
    }
       
       
    protected List<Pedido> loadAllPedidos() throws SQLException {

        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Pedido"); ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                Pedido pedido = readPedidoFromResultSet(result);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar los pedidos: " + e.getMessage());
        }
        return pedidos;
    }
    
    
    protected List<Pedido> loadPedidosContaining(String content) throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Pedido WHERE idPedido LIKE ?");
        stmt.setString(1, content);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            pedidos.add(readPedidoFromResultSet(result));
        }
        return pedidos;
    }

}
