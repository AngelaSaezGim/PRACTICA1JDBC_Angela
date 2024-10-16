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

    private static FabricaAlternativa readFabricasAlternativaFromResultSet(ResultSet rs) throws SQLException {

        int idFabricaPrincipal = rs.getInt(FabricaAlternativaDAO.FabricaAlternativaTableColumns.COLUMN_IDFABRICAPRINCIPAL);
        int idFabricaAlternativa = rs.getInt(FabricaAlternativaDAO.FabricaAlternativaTableColumns.COLUMN_IDFABRICAALTERNATIVA);

        FabricaAlternativa fabricaAlternativa = new FabricaAlternativa(idFabricaPrincipal, idFabricaAlternativa);
        return fabricaAlternativa;
    }

    protected List<FabricaAlternativa> loadAllFabricasAlternativas() throws SQLException {

        List<FabricaAlternativa> fabricasAlternativas = new ArrayList<>();
        try ( PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM FabricaAlternativa");  ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                FabricaAlternativa fabricaAlternativa = readFabricasAlternativaFromResultSet(result);
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
            fabricasAlternativas.add(readFabricasAlternativaFromResultSet(result));
        }
        return fabricasAlternativas;
    }

    protected int insertFabricaAlternativa(FabricaAlternativa fabricaAlternativa) throws SQLException {
        int filasAfectadas = 0;

        String sentenciaSQL = "INSERT INTO FabricaAlternativa ("
                + FabricaAlternativaTableColumns.COLUMN_IDFABRICAPRINCIPAL + ", "
                + FabricaAlternativaTableColumns.COLUMN_IDFABRICAALTERNATIVA + ") "
                + "VALUES (?, ?)";

        try ( PreparedStatement stmt = cnt.prepareStatement(sentenciaSQL)) {
            stmt.setInt(1, fabricaAlternativa.getIdFabricaPrincipal());
            stmt.setInt(2, fabricaAlternativa.getIdFabricaAlternativa());

            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la sentencia SQL: " + e.getMessage());
            throw e;
        }

        return filasAfectadas;
    }

    protected int deleteFabricaAlternativa(String idFabricaPrincipal, String idFabricaAlternativa) {

        int filasAfectadas = 0;

        try ( PreparedStatement stmt = cnt.prepareStatement("DELETE FROM FabricaAlternativa WHERE idFabricaPrincipal = ? AND idFabricaAlternativa=?")) {
            stmt.setString(1, idFabricaPrincipal);
            stmt.setString(2, idFabricaAlternativa);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }

        return filasAfectadas;
    }

    protected FabricaAlternativa loadFabricaAlternativaByCode(String idFabricaPrincipal, String idFabricaAlternativa) throws SQLException {
        FabricaAlternativa fabricaAlternativa = null;

        String sql = "SELECT * FROM FabricaAlternativa WHERE idFabricaPrincipal = ? AND idFabricaAlternativa = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setString(1, idFabricaPrincipal);
            stmt.setString(2, idFabricaAlternativa);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                fabricaAlternativa = readFabricasAlternativaFromResultSet(result);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar la fábrica alternativa con ID principal " + idFabricaPrincipal + " y alternativa " + idFabricaAlternativa + ": " + e.getMessage());
        }
        return fabricaAlternativa;
    }

    protected int updateFabricaAlternativa(String idFabricaPrincipal, String idFabricaAlternativa, FabricaAlternativa fabricaAlternativaActualizar) throws SQLException {
        int filasAfectadas = 0;

        String sql = "UPDATE FabricaAlternativa SET idFabricaPrincipal = ?, idFabricaAlternativa=? WHERE idFabricaPrincipal = ? AND idFabricaAlternativa = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setInt(1, fabricaAlternativaActualizar.getIdFabricaPrincipal());
            stmt.setInt(2, fabricaAlternativaActualizar.getIdFabricaAlternativa());
            stmt.setString(3, idFabricaPrincipal);
            stmt.setString(4, idFabricaAlternativa);

            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar la fábrica alternativa con ID principal " + idFabricaPrincipal + " y alternativa " + idFabricaAlternativa + ": " + e.getMessage());
        }
        return filasAfectadas;
    }

    public boolean fabricaAlternativaExiste(String idFabricaPrincipal, String idFabricaAlternativa) throws SQLException {
        String query = "SELECT COUNT(*) FROM fabricaAlternativa WHERE idFabricaPrincipal = ? AND idFabricaAlternativa = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(query)) {
            stmt.setString(1, idFabricaPrincipal);
            stmt.setString(2, idFabricaAlternativa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

}
