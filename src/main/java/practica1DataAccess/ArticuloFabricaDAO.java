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
import practica1Objetos.ArticuloFabrica;

/**
 *
 * @author angsaegim
 */
public class ArticuloFabricaDAO extends DataAccessObject {

    ArticuloFabricaDAO(Connection cnt) {
        super(cnt);
    }

    private class ArticuloFabricaTableColumns {

        private final static String COLUMN_IDARTICULO = "idArticulo";
        private final static String COLUMN_IDFABRICA = "idFabrica";
        private final static String COLUMN_EXISTENCIAS = "existencias";
        private final static String COLUMN_PRECIO = "precio";
    }

    private static ArticuloFabrica readArticuloFabricaFromResultSet(ResultSet rs) throws SQLException {
        int idArticulo = rs.getInt(ArticuloFabricaDAO.ArticuloFabricaTableColumns.COLUMN_IDARTICULO);
        int idFabrica = rs.getInt(ArticuloFabricaDAO.ArticuloFabricaTableColumns.COLUMN_IDFABRICA);
        int existencias = rs.getInt(ArticuloFabricaDAO.ArticuloFabricaTableColumns.COLUMN_EXISTENCIAS);
        double precio = rs.getDouble(ArticuloFabricaDAO.ArticuloFabricaTableColumns.COLUMN_PRECIO);
        ArticuloFabrica articuloFabrica = new ArticuloFabrica(idArticulo, idFabrica, existencias, precio);
        return articuloFabrica;
    }

    protected List<ArticuloFabrica> loadAllArticulosFabricas() throws SQLException {

        List<ArticuloFabrica> articulosFabrica = new ArrayList<>();
        try (PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM ArticuloFabrica"); ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                ArticuloFabrica articuloFabrica = readArticuloFabricaFromResultSet(result);
                articulosFabrica.add(articuloFabrica);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar articulos de las fabricas: " + e.getMessage());
        }
        return articulosFabrica;
    }

    protected List<ArticuloFabrica> loadAllArticulosFabricaContaining(String content1, String content2) throws SQLException {
        List<ArticuloFabrica> articulosFabrica = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM ArticuloFabrica WHERE idArticulo = ? AND idFabrica = ?");
        stmt.setString(1, content1);
        stmt.setString(2, content2);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            articulosFabrica.add(readArticuloFabricaFromResultSet(result));
        }

        return articulosFabrica;
    }

    protected int insertArticuloFabrica(ArticuloFabrica articuloFabrica) throws SQLException {

        int filasAfectadas = 0;

        String sentenciaSQL = "INSERT INTO ArticuloFabrica ("
                + ArticuloFabricaTableColumns.COLUMN_IDARTICULO + ", "
                + ArticuloFabricaTableColumns.COLUMN_IDFABRICA + ", "
                + ArticuloFabricaTableColumns.COLUMN_EXISTENCIAS + ", "
                + ArticuloFabricaTableColumns.COLUMN_PRECIO + ") "
                + "VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = cnt.prepareStatement(sentenciaSQL)) {
            int idArticulo = obtenerMaxId() + 1;
            stmt.setInt(1, idArticulo);
            stmt.setInt(2, articuloFabrica.getIdFabrica());
            stmt.setInt(3, articuloFabrica.getExistencias());
            stmt.setDouble(4, articuloFabrica.getPrecio());

            filasAfectadas = stmt.executeUpdate();
            articuloFabrica.setIdArticulo(idArticulo);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Error al insertar");
        }

        return filasAfectadas;
    }
    // Método para verificar si la fábrica a la que vamos a insertar existe
    protected boolean fabricaExiste(int idFabrica) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Fabrica WHERE idFabrica = ?";
        try (PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setInt(1, idFabrica);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    private Integer obtenerMaxId() throws SQLException {

        PreparedStatement stmt = cnt.prepareStatement("SELECT max(idArticulo) FROM ArticuloFabrica");
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            return result.getInt(1);
        } else {
            return 0; //no hay datos en la tabla
        }
    }

    protected int deleteArticuloFabrica(String idArticulo, String idFabrica) {

        int filasAfectadas = 0;

        try ( PreparedStatement stmt = cnt.prepareStatement("DELETE FROM Articulo WHERE idArticulo = ?")) {
            stmt.setString(1, idArticulo);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }

        return filasAfectadas;
    }

}
