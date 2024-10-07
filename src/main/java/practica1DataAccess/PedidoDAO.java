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

    protected int insertPedido(Pedido pedido) throws SQLException {
        int filasAfectadas = 0;

        String sentenciaSQL = "INSERT INTO Pedido ("
                + PedidoTableColumns.COLUMN_IDPEDIDO + ", "
                + PedidoTableColumns.COLUMN_FECHA + ", "
                + PedidoTableColumns.COLUMN_NUMEROCOMANDA + ", "
                + PedidoTableColumns.COLUMN_IDCLIENTE + ", "
                + PedidoTableColumns.COLUMN_IDDIRECCION + ") "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = cnt.prepareStatement(sentenciaSQL)) {

            int idPedido = obtenerMaxId() + 1;
            stmt.setInt(1, idPedido);
            stmt.setTimestamp(2, pedido.getFecha());
            stmt.setInt(3, pedido.getNumeroComanda());
            stmt.setInt(4, pedido.getIdCliente());
            stmt.setInt(5, pedido.getIdDireccion());

            filasAfectadas = stmt.executeUpdate();

            pedido.setIdPedido(idPedido);

        } catch (SQLException e) {
            throw new SQLException("Error al insertar el pedido: " + e.getMessage());
        }

        return filasAfectadas;
    }

    private Integer obtenerMaxId() throws SQLException {

        PreparedStatement stmt = cnt.prepareStatement("SELECT max(idPedido) FROM Pedido");
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            return result.getInt(1);
        } else {
            return 0;
        }
    }

    protected boolean direccionExiste(int idDireccion) throws SQLException {
        String sql = "SELECT COUNT(*) FROM DireccionEnvio WHERE idDireccion = ?";
        try (PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setInt(1, idDireccion);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }
    
    protected int deletePedido(String idPedido) {

        int filasAfectadas = 0;

        try ( PreparedStatement stmt = cnt.prepareStatement("DELETE FROM Pedido WHERE idPedido = ?")) {
            stmt.setString(1, idPedido);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }

        return filasAfectadas;
    }

}
