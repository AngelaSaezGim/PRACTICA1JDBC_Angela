/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1App;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import practica1DataAccess.DataAccessManager;
import practica1Objetos.LineaPedido;
import practica1Objetos.Pedido;

/**
 *
 * @author angel
 */
public class CalcularCantidadTotalArticulosPedidosAño3 {
    
   
    
    //----------------------- METODO 3 -----------------------------------------//
    /*
    iii. Método que calcule la cantidad total de artículos incluidos en todos los pedidos de un año dado.
     */
    
    public static List<Pedido> filtrarPedidosAño(DataAccessManager dam) throws SQLException {
        
        Scanner tcl = new Scanner(System.in);

        System.out.println("Dime el año en el que queremos ver los pedidos (ej 2003)");
        int añoInput = tcl.nextInt();
        List<Pedido> listaPedidosAño = dam.listarPedidosPorAño(añoInput); //PedidoDAO

        if (listaPedidosAño.isEmpty()) {
            System.out.println("No se encontraron pedidos para ese año");
        } else {
            System.out.println("Pedidos realizados en el año " + añoInput);
            
            for (Pedido pedido : listaPedidosAño) {
                System.out.println(pedido.toString());
            }
        }

        return listaPedidosAño;
    }

    //Test 3
    public static int calcularCantidadTotalArticulosPedidosAño(DataAccessManager dam) throws SQLException {

        int totalArticulos = 0;
        List<Pedido> listaPedidosAño = filtrarPedidosAño(dam); //metodo anterior

        if (listaPedidosAño.isEmpty()) {
            System.out.println("La lista está vacia");
        } else {
            
            for (Pedido pedido : listaPedidosAño) {
                //Saco las lineas de pedido de los pedidos de ese año - para luego sacar todos los articulos (CANTIDAD) asociados a esos pedidos
                List<LineaPedido> lineasPedido = dam.filtrarLineasPedidosIdPedido(String.valueOf(pedido.getIdPedido())); //LineaPedidoDAO

                for (LineaPedido linea : lineasPedido) {
                    System.out.println(linea.toString());
                    totalArticulos += linea.getCantidad();
                }
            }
        }
        System.out.println("La cantidad total de los articulos en los pedidos es de " + totalArticulos);
        return totalArticulos;
    }
    
    
    //----------------------- FIN METODO 3 -----------------------------------------//
    
       
}
