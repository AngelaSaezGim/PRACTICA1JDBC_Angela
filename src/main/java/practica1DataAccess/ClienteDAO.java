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
import practica1Objetos.Cliente;

/**
 *
 * @author angsaegim
 */
public class ClienteDAO extends DataAccessObject {

    ClienteDAO(Connection cnt) {
        super(cnt);
    }

    private class ClienteTableColumns {

        private final static String COLUMN_IDCLIENTE = "idCliente";
        private final static String COLUMN_SALDO = "saldo";
        private final static String COLUMN_LIMITECREDITO = "limiteCredito";
        private final static String COLUMN_DESCUENTO = "descuento";
    }

    private static Cliente readClienteFromResultSet(ResultSet rs) throws SQLException {

        int idCliente = rs.getInt(ClienteDAO.ClienteTableColumns.COLUMN_IDCLIENTE);
        Double saldo = rs.getDouble(ClienteDAO.ClienteTableColumns.COLUMN_SALDO);
        Double limiteCredito = rs.getDouble(ClienteDAO.ClienteTableColumns.COLUMN_LIMITECREDITO);
        Double descuento = rs.getDouble(ClienteDAO.ClienteTableColumns.COLUMN_DESCUENTO);

        Cliente cliente = new Cliente(idCliente, saldo, limiteCredito, descuento);
        return cliente;
    }

    protected List<Cliente> loadAllClientes() throws SQLException {

        List<Cliente> clientes = new ArrayList<>();
        try ( PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Cliente");  ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                Cliente cliente = readClienteFromResultSet(result);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar clientes: " + e.getMessage());
        }
        return clientes;
    }

    protected List<Cliente> loadClienteContaining(String content) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Cliente WHERE idCliente LIKE ?");
        stmt.setString(1, content);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            clientes.add(readClienteFromResultSet(result));
        }
        return clientes;
    }

    protected int insertCliente(Cliente cliente) throws SQLException {
        int filasAfectadas = 0;

        String sentenciaSQL = "INSERT INTO Cliente ("
                + ClienteTableColumns.COLUMN_IDCLIENTE + ", "
                + ClienteTableColumns.COLUMN_SALDO + ", "
                + ClienteTableColumns.COLUMN_LIMITECREDITO + ", "
                + ClienteTableColumns.COLUMN_DESCUENTO + ") "
                + "VALUES (?, ?, ?, ?)";

        try ( PreparedStatement stmt = cnt.prepareStatement(sentenciaSQL)) {

            int idCliente = obtenerMaxId() + 1;
            stmt.setInt(1, idCliente);
            stmt.setDouble(2, cliente.getSaldo());
            stmt.setDouble(3, cliente.getLimiteCredito());
            stmt.setDouble(4, cliente.getDescuento());

            filasAfectadas = stmt.executeUpdate();
            cliente.setIdCliente(idCliente);
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la sentencia SQL: " + e.getMessage());
            throw e;
        }

        return filasAfectadas;
    }

    private Integer obtenerMaxId() throws SQLException {

        PreparedStatement stmt = cnt.prepareStatement("SELECT max(idCliente) FROM Cliente");
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            return result.getInt(1);
        } else {
            return 0;
        }
    }

    protected int deleteCliente(String idCliente) {

        int filasAfectadas = 0;

        try ( PreparedStatement stmt = cnt.prepareStatement("DELETE FROM Cliente WHERE idCliente = ?")) {
            stmt.setString(1, idCliente);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }

        return filasAfectadas;
    }

    protected Cliente loadClienteByCode(String idCliente) throws SQLException {
        Cliente cliente = null;

        String sql = "SELECT * FROM Cliente WHERE idCliente = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setString(1, idCliente);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                cliente = readClienteFromResultSet(result);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar el cliente con ID " + idCliente + ": " + e.getMessage());
        }
        return cliente;
    }

    protected int updateCliente(String idCliente, Cliente clienteActualizar) throws SQLException {
        int filasAfectadas = 0;

        String sql = "UPDATE Cliente SET saldo = ?, limiteCredito = ?, descuento = ? WHERE idCliente = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setDouble(1, clienteActualizar.getSaldo());
            stmt.setDouble(2, clienteActualizar.getLimiteCredito());
            stmt.setDouble(3, clienteActualizar.getDescuento());
            stmt.setString(4, idCliente);

            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar el cliente con ID " + idCliente + ": " + e.getMessage());
        }
        return filasAfectadas;
    }

    //METODO 1
    protected double sacarDescuento(String idCliente) throws SQLException {

        double descuentoCliente = 0;

        String query = "SELECT descuento FROM Cliente WHERE idCliente = ?";
        PreparedStatement stmt = cnt.prepareStatement(query);
        stmt.setString(1, idCliente);

        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            descuentoCliente = result.getDouble("descuento");
        }

        return descuentoCliente;
    }

}
