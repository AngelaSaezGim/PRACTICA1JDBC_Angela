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
import practica1Objetos.DireccionEnvio;

/**
 *
 * @author angsaegim
 */
public class DireccionEnvioDAO extends DataAccessObject {

    DireccionEnvioDAO(Connection cnt) {
        super(cnt);
    }

    private class DireccionEnvioTableColumns {

        private final static String COLUMN_IDDIRECCION = "idDireccion";
        private final static String COLUMN_NUMERO = "numero";
        private final static String COLUMN_CALLE = "calle";
        private final static String COLUMN_COMUNA = "comuna";
        private final static String COLUMN_CIUDAD = "ciudad";
        private final static String COLUMN_IDCLIENTE = "idCliente";
    }

    private static DireccionEnvio readDireccionEnvioFromResultSet(ResultSet rs) throws SQLException {

        int idDireccion = rs.getInt(DireccionEnvioDAO.DireccionEnvioTableColumns.COLUMN_IDDIRECCION);
        int numero = rs.getInt(DireccionEnvioDAO.DireccionEnvioTableColumns.COLUMN_NUMERO);
        String calle = rs.getString(DireccionEnvioDAO.DireccionEnvioTableColumns.COLUMN_CALLE);
        String comuna = rs.getString(DireccionEnvioDAO.DireccionEnvioTableColumns.COLUMN_COMUNA);
        String ciudad = rs.getString(DireccionEnvioDAO.DireccionEnvioTableColumns.COLUMN_CIUDAD);
        int idCliente = rs.getInt(DireccionEnvioDAO.DireccionEnvioTableColumns.COLUMN_IDCLIENTE);

        DireccionEnvio direccionEnvio = new DireccionEnvio(idDireccion, numero, calle, comuna, ciudad, idCliente);
        return direccionEnvio;
    }

    protected List<DireccionEnvio> loadAllDireccionesEnvio() throws SQLException {

        List<DireccionEnvio> direccionesEnvios = new ArrayList<>();
        try ( PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM DireccionEnvio");  ResultSet result = stmt.executeQuery()) {

            while (result.next()) {
                DireccionEnvio direccionEnvio = readDireccionEnvioFromResultSet(result);
                direccionesEnvios.add(direccionEnvio);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar direccion envio: " + e.getMessage());
        }
        return direccionesEnvios;
    }

    protected List<DireccionEnvio> loadDireccionEnvioContaining(String content) throws SQLException {
        List<DireccionEnvio> direccionesEnvios = new ArrayList<>();

        PreparedStatement stmt = cnt.prepareStatement("SELECT * FROM DireccionEnvio WHERE idDireccion LIKE ?");
        stmt.setString(1, content);
        ResultSet result = stmt.executeQuery();

        while (result.next()) {
            direccionesEnvios.add(readDireccionEnvioFromResultSet(result));
        }
        return direccionesEnvios;
    }

    protected int insertDireccionEnvio(DireccionEnvio direccionEnvio) throws SQLException {
        int filasAfectadas = 0;

        String sentenciaSQL = "INSERT INTO DireccionEnvio ("
                + DireccionEnvioTableColumns.COLUMN_IDDIRECCION + ", "
                + DireccionEnvioTableColumns.COLUMN_NUMERO + ", "
                + DireccionEnvioTableColumns.COLUMN_CALLE + ", "
                + DireccionEnvioTableColumns.COLUMN_COMUNA + ", "
                + DireccionEnvioTableColumns.COLUMN_CIUDAD + ", "
                + DireccionEnvioTableColumns.COLUMN_IDCLIENTE + ") "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try ( PreparedStatement stmt = cnt.prepareStatement(sentenciaSQL)) {

            int idDireccion = obtenerMaxId() + 1;
            stmt.setInt(1, idDireccion);
            stmt.setInt(2, direccionEnvio.getNumero());
            stmt.setString(3, direccionEnvio.getCalle());
            stmt.setString(4, direccionEnvio.getComuna());
            stmt.setString(5, direccionEnvio.getCiudad());
            stmt.setInt(6, direccionEnvio.getIdCliente());

            filasAfectadas = stmt.executeUpdate();

            direccionEnvio.setIdDireccion(idDireccion);

        } catch (SQLException e) {
            throw new SQLException("Error al insertar la dirección de envío: " + e.getMessage());
        }

        return filasAfectadas;

    }

    protected boolean clienteExiste(int idCliente) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Cliente WHERE idCliente = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new SQLException("Error al verificar existencia del cliente: " + e.getMessage());
        }
        return false;
    }

    private Integer obtenerMaxId() throws SQLException {

        PreparedStatement stmt = cnt.prepareStatement("SELECT max(idDireccion) FROM DireccionEnvio");
        ResultSet result = stmt.executeQuery();

        if (result.next()) {
            return result.getInt(1);
        } else {
            return 0;
        }
    }

    protected int deleteDireccion(String idDireccion) {

        int filasAfectadas = 0;

        try ( PreparedStatement stmt = cnt.prepareStatement("DELETE FROM DireccionEnvio WHERE idDireccion = ?")) {
            stmt.setString(1, idDireccion);
            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }

        return filasAfectadas;
    }

    protected DireccionEnvio loadDireccionEnvioByCode(String idDireccion) throws SQLException {
        DireccionEnvio direccionEnvio = null;

        String sql = "SELECT * FROM DireccionEnvio WHERE idDireccion = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setString(1, idDireccion);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                direccionEnvio = readDireccionEnvioFromResultSet(result);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al cargar la dirección de envío con ID " + idDireccion + ": " + e.getMessage());
        }
        return direccionEnvio;
    }

    protected int updateDireccionEnvio(String idDireccion, DireccionEnvio direccionEnvioActualizar) throws SQLException {
        int filasAfectadas = 0;

        String sql = "UPDATE DireccionEnvio SET numero = ?, calle = ?, comuna = ?, ciudad = ?, idCliente = ? WHERE idDireccion = ?";
        try ( PreparedStatement stmt = cnt.prepareStatement(sql)) {
            stmt.setInt(1, direccionEnvioActualizar.getNumero());
            stmt.setString(2, direccionEnvioActualizar.getCalle());
            stmt.setString(3, direccionEnvioActualizar.getComuna());
            stmt.setString(4, direccionEnvioActualizar.getCiudad());
            stmt.setInt(5, direccionEnvioActualizar.getIdCliente());
            stmt.setString(6, idDireccion);

            filasAfectadas = stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar la dirección de envío con ID " + idDireccion + ": " + e.getMessage());
        }
        return filasAfectadas;
    }

}
