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
import practica1Objetos.FabricaAlternativa;

/**
 *
 * @author angsaegim
 */
public class FabricaAlternativaDAO extends DataAccessObject {

    FabricaAlternativaDAO(Connection cnt) {
        super(cnt);
    }

    private class FabricaAlternativaTableColumns {

        private final static String COLUMN_IDFABRICAPRINCIPAL = "idFabricaPrincipal";
        private final static String COLUMN_IDFABRICAALTERNATIVA = "idFabricaAlternativa";

    }

    private static FabricaAlternativa readFabricaAlternativaFromResultSet(ResultSet rs) throws SQLException {

        int idFabricaPrincipal = rs.getInt(FabricaAlternativaDAO.FabricaAlternativaTableColumns.COLUMN_IDFABRICAPRINCIPAL);
        int idFabricaAlternativa = rs.getInt(FabricaAlternativaDAO.FabricaAlternativaTableColumns.COLUMN_IDFABRICAALTERNATIVA);

        FabricaAlternativa fabricaAlternativa = new FabricaAlternativa(idFabricaPrincipal, idFabricaAlternativa);
        return fabricaAlternativa;
    }

    protected List<FabricaAlternativa> loadAllFabricaAlternativa() throws SQLException {

        List<FabricaAlternativa> fabricasAlternativas = new ArrayList<>();
        try ( PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM FabricaAlternativa");  ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                FabricaAlternativa fabricaAlternativa = readFabricaAlternativaFromResultSet(result);
                fabricasAlternativas.add(fabricaAlternativa);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar las fabricas alternativas: " + e.getMessage());
        }
        return fabricasAlternativas;
    }

    protected List<FabricaAlternativa> loadFabricaAlternativaContaining(String content1, String content2) throws SQLException {
        List<FabricaAlternativa> fabricasAlternativas = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM FabricaAlternativa WHERE idFabricaPrincipal LIKE ? AND idFabricaAlternativa LIKE ?");
        stmt.setString(1, content1);
        stmt.setString(2, content2);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            fabricasAlternativas.add(readFabricaAlternativaFromResultSet(result));
        }
        return fabricasAlternativas;
    }

}
