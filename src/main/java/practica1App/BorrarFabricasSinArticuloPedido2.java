/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1App;

import java.sql.SQLException;
import java.util.List;
import practica1DataAccess.DataAccessManager;

/**
 *
 * @author angel
 */
public class BorrarFabricasSinArticuloPedido2 {
    
    //----------------------- METODO 2-----------------------------------------//
    /*
    ii. Método que borre todas las fábricas a las que no se haya pedido ningún artículo que se haya incluido en ningún pedido.
    */
    
    public static List<String> FiltrarFabricasSinPedido(DataAccessManager dam) throws SQLException {

        System.out.println("Mostramos las fabricas sin artículos asociados a pedidos.");
        List<String> fabricasSinPedidos = dam.filtrarFabricasSinPedido(); //ArticuloFabricaDAO

        if (fabricasSinPedidos.isEmpty()) {
            System.out.println("No se encontraron fábricas sin artículos asociados a pedidos.");
        } else {
            System.out.println("Id de las fábricas sin artículos asociados a pedidos:");
            for (String idFabrica : fabricasSinPedidos) {
                System.out.println("Id fabrica = " + idFabrica + " sin artículos asociados a pedidos");
            }
        }

        return fabricasSinPedidos;
    }

    //TEST - 2
    public static int borrarFabricasSinArticuloPedido(DataAccessManager dam) throws SQLException {

        List<String> fabricasSinPedidos = FiltrarFabricasSinPedido(dam);

        System.out.println("Procedemos a borrar las fabricas sin artículos asociados a pedidos");
        int numFabricasBorradas = dam.borrarFabricasSinArticulosAsociadosAPedido(fabricasSinPedidos); //FabricaDAO

        if (numFabricasBorradas > 0) {
            System.out.println("Fabricas con articulos asociados a pedidos borradas exitosamente. Se borraron = " + numFabricasBorradas);
        } else {
            System.out.println("No se borró nada.");
        }

        return numFabricasBorradas;
    }

    //----------------------- FIN METODO 2 -----------------------------------------//
}
