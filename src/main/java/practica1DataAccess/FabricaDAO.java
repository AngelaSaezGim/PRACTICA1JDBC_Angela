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
import practica1Objetos.FabricaAlternativa;

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
         private final static String COLUMN_TOTALARTICULOS = "totalArticulos";
    }

    private static Fabrica readFabricaFromResultSet(ResultSet rs) throws SQLException {

        int idFabrica = rs.getInt(FabricaDAO.FabricaTableColumns.COLUMN_IDFABRICA);
        String telefonoContacto = rs.getString(FabricaDAO.FabricaTableColumns.COLUMN_TELEFONOCONTACTO);
        int totalArticulos = rs.getInt(FabricaDAO.FabricaTableColumns.COLUMN_TOTALARTICULOS);

        Fabrica fabrica = new Fabrica(idFabrica, telefonoContacto, totalArticulos);
        return fabrica;
    }

    protected List<Fabrica> loadAllFabricas() throws SQLException {

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

        try ( PreparedStatement stmt = cnt.prepareStatement(sentenciaSQL)) {
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

    protected int deleteFabrica(String idFabrica) throws SQLException {

        int filasAfectadas = 0;

        // Primero eliminar las fábricas alternativas relacionadas
        //SOLUCIONAR DEPENDENCIA FABRICA ALTERNATIVA
        FabricaAlternativaDAO fabricaAlternativaDAO = new FabricaAlternativaDAO(cnt);
        List<FabricaAlternativa> fabricasAlternativas = fabricaAlternativaDAO.loadFabricaAlternativaContaining(idFabrica, "%");

        for (FabricaAlternativa alternativa : fabricasAlternativas) {
            fabricaAlternativaDAO.deleteFabricaAlternativa(
                    String.valueOf(alternativa.getIdFabricaPrincipal()),
                    String.valueOf(alternativa.getIdFabricaAlternativa())
            );
        }

        try ( PreparedStatement stmt = cnt.prepareStatement("DELETE FROM Fabrica WHERE idFabrica = ?")) {
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

        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
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
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setString(1, fabricaActualizar.getTelefonoContacto());
            stmt.setString(2, idFabrica);

            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar la fábrica con ID " + idFabrica + ": " + e.getMessage());
        }

        return filasAfectadas;
    }

    //USO VISTA - SE DESEAN SABER CUANTOS ARTICULOS EN TOTAL PROVEE LA FABRICA
    protected List<Fabrica> getTotalArticulosPorFabrica() throws SQLException {
        List<Fabrica> ListaTotalArticulosfabricas = new ArrayList<>();
        String sql = "SELECT idFabrica, totalArticulos FROM ArticuloPorFabrica"; 

        try (PreparedStatement stmt = cnt.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idFabrica = rs.getInt("idFabrica");
                int totalArticulos = rs.getInt("totalArticulos");

                Fabrica fabrica = new Fabrica(idFabrica, totalArticulos);
                System.out.println("Total de artículos en la fábrica " + idFabrica + ": " + totalArticulos);
                ListaTotalArticulosfabricas.add(fabrica);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener artículos por fábrica: " + e.getMessage());
        }
        return ListaTotalArticulosfabricas;
    }

    //METODO 2
    protected int borrarFabricasSinArticulosAsociadosAPedido(List<String> fabricasSinPedidos) throws SQLException {

        int numFabricasBorradas = 0;
        //  SOLUCIONAR DEPENDENCIA FABRICA ALTERNATIVA
        FabricaAlternativaDAO fabricaAlternativaDAO = new FabricaAlternativaDAO(cnt);

        try {
            //Para cada fábrica que borramos, primero eliminanamos todas las relaciones de artículos que tiene la fábrica;
            try ( PreparedStatement stmtArticuloFabrica = cnt.prepareStatement("DELETE FROM ArticuloFabrica WHERE idFabrica = ?")) {
                try ( PreparedStatement stmtFabrica = cnt.prepareStatement("DELETE FROM Fabrica WHERE idFabrica = ?")) {

                    for (String idFabrica : fabricasSinPedidos) {
                        stmtArticuloFabrica.setString(1, idFabrica); 
                        stmtArticuloFabrica.executeUpdate();

                        // Borrar fábricas alternativas dependientes 
                        List<FabricaAlternativa> fabricasAlternativas = fabricaAlternativaDAO.loadFabricaAlternativaContaining(idFabrica, "%");
                        // Para cada fábrica alternativa relacionada... 
                        for (FabricaAlternativa alternativa : fabricasAlternativas) {
                            fabricaAlternativaDAO.deleteFabricaAlternativa(
                                    String.valueOf(alternativa.getIdFabricaPrincipal()),
                                    String.valueOf(alternativa.getIdFabricaAlternativa())
                            );
                        }
                        
                        stmtFabrica.setString(1, idFabrica);
                        numFabricasBorradas += stmtFabrica.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al borrar fábricas sin artículos asociados a pedidos: " + e.getMessage());
        }
        
        return numFabricasBorradas;
    }

}
