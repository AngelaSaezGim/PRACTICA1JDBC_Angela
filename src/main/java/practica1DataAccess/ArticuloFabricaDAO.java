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
        try ( PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM ArticuloFabrica");  ResultSet result = stmt.executeQuery()) {

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

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM Articulo WHERE idArticulo LIKE ? AND idFabrica LIKE ?");
        stmt.setString(1, content1);
        stmt.setString(2, content2);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            articulosFabrica.add(readArticuloFabricaFromResultSet(result));
        }

        return articulosFabrica;
    }

}
