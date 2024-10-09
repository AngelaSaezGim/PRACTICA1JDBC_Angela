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

    protected List<Fabrica> loadAllFabricas() throws SQLException {

        List<Fabrica> fabricas = new ArrayList<>();
        try (PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Fabrica"); ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                Fabrica fabrica = readFabricaFromResultSet(result);
                fabricas.add(fabrica);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar las fabricas: " + e.getMessage());
        }
        return fabricas;
    }

    protected List<Fabrica> loadFabricasContaining(String content) throws SQLException {
        List<Fabrica> fabricas = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Fabrica WHERE idFabrica LIKE ?");
        stmt.setString(1, content);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            fabricas.add(readFabricaFromResultSet(result));
        }
        return fabricas;
    }

    protected int insertFabrica(Fabrica fabrica) throws SQLException {
        int filasAfectadas = 0;

        String sentenciaSQL = "INSERT INTO Fabrica ("
                + FabricaTableColumns.COLUMN_IDFABRICA + ", "
                + FabricaTableColumns.COLUMN_TELEFONOCONTACTO + ") "
                + "VALUES (?, ?)";

        try (PreparedStatement stmt = cnt.prepareStatement(sentenciaSQL)) {
            int idFabrica = obtenerMaxId() + 1;
            stmt.setInt(1, idFabrica);
            stmt.setString(2, fabrica.getTelefonoContacto());

            filasAfectadas = stmt.executeUpdate();
            fabrica.setIdFabrica(idFabrica);
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la sentencia SQL: " + e.getMessage());
            throw e;
        }

        return filasAfectadas;
    }

    private Integer obtenerMaxId() throws SQLException {

        PreparedStatement stmt = cnt.prepareStatement("SELECT max(idFabrica) FROM Fabrica");
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            return result.getInt(1);
        } else {
            return 0;
        }
    }

    protected int deleteFabrica(String idFabrica) {

        int filasAfectadas = 0;

        try (PreparedStatement stmt = cnt.prepareStatement("DELETE FROM Fabrica WHERE idFabrica = ?")) {
            stmt.setString(1, idFabrica);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }

        return filasAfectadas;
    }

    protected Fabrica loadFabricaByCode(String idFabrica) throws SQLException {
        Fabrica fabrica = null;
        String sql = "SELECT * FROM Fabrica WHERE idFabrica = ?";

        try (PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setString(1, idFabrica);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                fabrica = readFabricaFromResultSet(result);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar la fábrica con ID " + idFabrica + ": " + e.getMessage());
        }

        return fabrica;
    }

    protected int updateFabrica(String idFabrica, Fabrica fabricaActualizar) throws SQLException {
        int filasAfectadas = 0;

        String sql = "UPDATE Fabrica SET telefonoContacto = ? WHERE idFabrica = ?";
        try (PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setString(1, fabricaActualizar.getTelefonoContacto());
            stmt.setString(2, idFabrica);

            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar la fábrica con ID " + idFabrica + ": " + e.getMessage());
        }

        return filasAfectadas;
    }

}
