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
import practica1Objetos.Fabrica;

/**
 *
 * @author angsaegim
 */
public class FabricaDAO extends DataAccessObject {
    
    FabricaDAO(Connection cnt) {
        super(cnt);
    }
    
    private class FabricaTableColumns {

        private final static String COLUMN_IDFABRICA = "idFabrica";
        private final static String COLUMN_TELEFONOCONTACTO = "telefonoContacto";
    }
    
    private static Fabrica readFabricaFromResultSet(ResultSet rs) throws SQLException {

        int idFabrica = rs.getInt(FabricaDAO.FabricaTableColumns.COLUMN_IDFABRICA);
        String telefonoContacto = rs.getString(FabricaDAO.FabricaTableColumns.COLUMN_TELEFONOCONTACTO);

        Fabrica fabrica = new Fabrica(idFabrica, telefonoContacto);
        return fabrica;
    }
    
    
    protected List<Fabrica> loadAllFabrica() throws SQLException {

        List<Fabrica> fabricas = new ArrayList<>();
        try ( PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Fabrica");  ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                Fabrica fabrica = readFabricaFromResultSet(result);
                fabricas.add(fabrica);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar las fabricas: " + e.getMessage());
        }
        return fabricas;
    }
    
    
    protected List<Fabrica> loadFabricaContaining(String content) throws SQLException {
        List<Fabrica> fabricas = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Fabrica WHERE idFabrica LIKE ?");
        stmt.setString(1, content);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            fabricas.add(readFabricaFromResultSet(result));
        }
        return fabricas;
    }

}
