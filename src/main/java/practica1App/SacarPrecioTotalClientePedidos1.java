/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1App;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import practica1DataAccess.DataAccessManager;
import practica1Objetos.Articulo;
import practica1Objetos.LineaPedido;
import practica1Objetos.Pedido;

/**
 *
 * @author angel
 */
public class SacarPrecioTotalClientePedidos1 {

    //CON LOS PEDIDOS DE ESE CLIENTE - SACAMOS LAS LINEAS Y LAS CALCULAMOS

    public static List<Pedido> consultarPedidosCliente(DataAccessManager dam, String idCliente) throws SQLException {
        
        //SACAMOS LA LISTA DE PEDIDOS DE ESE CLIENTE
        List<Pedido> pedidosFilteredByClient = dam.listarPedidosCliente(idCliente); //PedidoDAO
        if (pedidosFilteredByClient != null) {
            System.out.println("Pedidos hechos por el cliente " + idCliente);
            MetodosMenu.printPedidos(pedidosFilteredByClient);
        } else {
            System.out.println("No se encontraron pedidos con el id de ese cliente.");

        }
        return pedidosFilteredByClient;
    }
    
    public static double sacarPrecioTotalClientePedidos(DataAccessManager dam) throws SQLException, Exception {
        Scanner tcl = new Scanner(System.in);
        System.out.println("Listado de comandas con importe y descuento");
        System.out.println("Escribeme el id del cliente al que queremos ver los pedidos");
        String idClienteStr = tcl.nextLine();
        double precioTotalConDescuento = 0;
        int idCliente = Integer.parseInt(idClienteStr);

        List<Pedido> pedidosCliente = consultarPedidosCliente(dam, idClienteStr); //Llamo al metodo anterior

        // saco las lineas de pedido de la lista de pedidos asociada a un cliente
        List<LineaPedido> lineasPedidoCliente = dam.filtrarPedidos(pedidosCliente); //LineaPedidoDAO

        double precioTotalSinDescuento = 0;

        if (lineasPedidoCliente != null && !lineasPedidoCliente.isEmpty()) {
            System.out.println("Líneas de pedido asociadas a estos pedidos:"); 
            MetodosMenu.printLineasPedido(lineasPedidoCliente);

            //SACAMOS EL IMPORTE DE LOS PEDIDOS DEL CLIENTE - USANDO LINEAPEDIDO
            for (LineaPedido linea : lineasPedidoCliente) {  
                int idArticulo = linea.getIdArticulo();
                String idArticuloStr = String.valueOf(idArticulo);
                Articulo articulo = dam.loadArticuloByCode(idArticuloStr); //PARA PODER PONER LA DESCRIPCION - ArticuloDAO

                if (articulo != null) {
                    System.out.println("----------------------------");
                    System.out.println("Información del artículo asociado (ID: " + idArticulo + "):");
                    MetodosMenu.printArticulo(articulo);
                    System.out.println(" - cantidad pedida = " + linea.getCantidad());

                    /*PRECIO ARTICULOS*/
                    double precioPorArticulo = dam.sacarPrecioArticulo(idArticuloStr); //SACAMOS PRECIO de ArticuloFabricaDAO
                    double totalLinea = precioPorArticulo * linea.getCantidad(); // (calcular total en cada linea)
                    precioTotalSinDescuento += totalLinea; //sumando por cada linea al importe total del cliente

                    System.out.println(" - Precio por artículo: " + precioPorArticulo);
                    System.out.println(" - Total por esta línea: " + String.format("%.2f", totalLinea));
                    System.out.println("----------------------------");
                } else {
                    System.out.println("No se encontró artículo con ID: " + idArticulo);
                }
            }
            System.out.println("");
        } else {
            System.out.println("No se encontraron líneas de pedido con los IDs de pedido asociados a ese cliente.");
        }

        double descuento = dam.sacarDescuento(idClienteStr) / 100; //ClienteDAO
        precioTotalConDescuento = precioTotalSinDescuento * (1 - descuento);

        System.out.println("El precio total sin descuento es: " + String.format("%.2f", precioTotalSinDescuento));
        System.out.println("El descuento aplicado es: " + (descuento * 100) + "%");
        System.out.println("El precio total con descuento es: " + String.format("%.2f", precioTotalConDescuento));
        System.out.println("Has pagado " + String.format("%.2f", (precioTotalSinDescuento - precioTotalConDescuento)) + " euros menos ");

        return precioTotalConDescuento;
    }

    
}
