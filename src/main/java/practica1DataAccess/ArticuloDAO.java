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
import practica1Objetos.Articulo;

/**
 *
 * @author angsaegim
 */
public class ArticuloDAO extends DataAccessObject {

    ArticuloDAO(Connection cnt) {
        super(cnt);
    }

    private class ArticuloTableColumns {

        private final static String COLUMN_IDARTICULO = "idArticulo";
        private final static String COLUMN_DESCRIPCION = "descripcion";
    }

    private static Articulo readArticuloFromResultSet(ResultSet rs) throws SQLException {
        int idArticulo = rs.getInt(ArticuloTableColumns.COLUMN_IDARTICULO);
        String descripcion = rs.getString(ArticuloTableColumns.COLUMN_DESCRIPCION);
        Articulo articulo = new Articulo(idArticulo, descripcion);
        return articulo;
    }

    protected List<Articulo> loadAllArticulos() throws SQLException {

        List<Articulo> articulos = new ArrayList<>();
        try ( PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Articulo");  ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                Articulo articulo = readArticuloFromResultSet(result);
                articulos.add(articulo);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar articulos: " + e.getMessage());
        }
        return articulos;
    }

    protected List<Articulo> loadArticulosContaining(String content) throws SQLException {
        List<Articulo> articulos = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Articulo WHERE idArticulo LIKE ?");
        stmt.setString(1, content);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            articulos.add(readArticuloFromResultSet(result));
        }
        return articulos;
    }

    protected int insertArticulo(Articulo articulo) {

        int filasAfectadas = 0;

        String sentenciaSQL = "INSERT INTO Articulo ("
                + ArticuloTableColumns.COLUMN_IDARTICULO + ", "
                + ArticuloTableColumns.COLUMN_DESCRIPCION
                + ") VALUES (?, ?)";

        try ( PreparedStatement stmt = cnt.prepareStatement(sentenciaSQL)) {

            int idArticulo = obtenerMaxId() + 1;
            stmt.setInt(1, idArticulo);
            stmt.setString(2, articulo.getDescripcion());

            filasAfectadas = stmt.executeUpdate();

            articulo.setIdArticulo(idArticulo);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Error al insertar");
        }

        return filasAfectadas;
    }

    private Integer obtenerMaxId() throws SQLException {

        PreparedStatement stmt = cnt.prepareStatement("SELECT max(idArticulo) FROM Articulo");
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            return result.getInt(1);
        } else {
            return 0; //no hay datos en la tabla
        }
    }

    protected int deleteArticulo(String idArticulo) {

        int filasAfectadas = 0;

        try ( PreparedStatement stmt = cnt.prepareStatement("DELETE FROM Articulo WHERE idArticulo = ?")) {
            stmt.setString(1, idArticulo);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }

        return filasAfectadas;
    }

    protected Articulo loadArticuloByCode(String idArticulo) throws SQLException {

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Articulo WHERE idArticulo = ?");
        stmt.setString(1, idArticulo);
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            return readArticuloFromResultSet(result);
        }
        return null;
    }

    protected int updateArticulo(String idArticulo, Articulo articuloActualizar) {

        int filasAfectadas = 0;

        String sql = "UPDATE Articulo SET descripcion = ? WHERE idArticulo = ?";

        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setString(1, articuloActualizar.getDescripcion());
            stmt.setString(2, idArticulo);

            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
        return filasAfectadas;
    }

}
