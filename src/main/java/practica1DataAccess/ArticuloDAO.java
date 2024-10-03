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
        Articulo articulo = new Articulo(idArticulo,descripcion);
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

}
