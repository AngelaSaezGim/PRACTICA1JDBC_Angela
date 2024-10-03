/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package practica1App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author angsaegim
 */
public class MenuPractica1App {

    public static void main(String[] args) throws ClassNotFoundException {
       
        String url="jdbc:mysql://localhost:3306/practica1?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        
         try {
            //puede ser que sea requerido lo siguiente
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "serpis");

            //Tipo statement
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT idArticulo, descripcion FROM Articulo";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.println("Id Articulo: " + resultado.getInt("idArticulo"));
                System.out.println("Descripcion: " + resultado.getString("descripcion"));
                System.out.println(" ");
            }
                       
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
}
