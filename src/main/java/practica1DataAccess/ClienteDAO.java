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
        
        Cliente cliente = new Cliente(idCliente,saldo,limiteCredito,descuento);
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
    
}
