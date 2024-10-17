/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metodo1;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practica1App.SacarPrecioTotalClientePedidos1;
import static org.junit.jupiter.api.Assertions.*;
import practica1DataAccess.DataAccessManager;
import practica1Objetos.LineaPedido;
import practica1Objetos.Pedido;

/**
 *
 * @author angel
 */
public class SacarPrecioTotalClientePedidos1Test {

    private DataAccessManager dam;

    @BeforeEach
    public void setUp() {
        dam = new DataAccessManagerSimulation();
        // Simulamos la entrada del cliente como 1 para todos los tests
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
    }

    public SacarPrecioTotalClientePedidos1Test() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of sacarPrecioTotalClientePedidos method, of class
     * SacarPrecioTotalClientePedidos1.
     */
    //COMPLEJIDAD CICLOMATICA = 4
    @Test
    public void testSacarPrecioTotalClientePedidos1() throws Exception {
        System.out.println("Test 1 - NO HAY PEDIDOS ASOCIADOS A ESE CLIENTE (lista vacia)");
        System.out.println(" ");
        dam = new DataAccessManagerSimulation() {
            
            @Override
            public List<Pedido> listarPedidosCliente(String idCliente) {
                return List.of();
            }
        };
        double expResult = 0.0;
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testSacarPrecioTotalClientePedidos2() throws Exception {
        System.out.println(" ");
        System.out.println("Test 2 - HAY PEDIDOS PERO NO HAY LINEAS PEDIDOS ASOCIADAS A ESE CLIENTE");
        System.out.println(" ");
        dam = new DataAccessManagerSimulation() {
            
            @Override
            public List<Pedido> listarPedidosCliente(String idCliente) {
                String fechaStr ="2003-09-01 00:30:02";
                Timestamp fechaPedido = Timestamp.valueOf(fechaStr);
                return List.of(new Pedido(1, fechaPedido, 1001, 1, 1), new Pedido(2, fechaPedido, 1, 44, 2),
                        new Pedido(3, fechaPedido, 99, 1, 1), new Pedido(4, fechaPedido, 450, 1, 1)); //Pedido 1 , pedido 2, pedido 3 y pedido 4
            }
            @Override
            public List<LineaPedido> filtrarPedidos(List<Pedido> pedidosCliente) {
                return List.of();
            }
        };
        double expResult = 0.0;
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
    }

    /*
    public void testSacarPrecioTotalClientePedidos3() throws Exception {
        System.out.println(" ");
        System.out.println("Test 3 - HAY PEDIDOS Y HAY LINEAS DE PEDIDO ASOCIADAS A ESE CLIENTE PERO NO HAY ARTICULOS");
        System.out.println(" ");
        DataAccessManager dam = null;
        double expResult = 0.0;
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
    }
    
        /*
    Pedidos hechos por el cliente 1
	-> Pedido [1]  Fecha del pedido = 2024-10-02 16:45:37.0 | Numero Comanda = 1001 | Id cliente relacionado = 1 | Direccion = 1
	-> Pedido [2]  Fecha del pedido = 2003-09-01 22:20:00.0 | Numero Comanda = 44 | Id cliente relacionado = 1 | Direccion = 2
	-> Pedido [3]  Fecha del pedido = 2024-10-10 08:53:03.0 | Numero Comanda = 99 | Id cliente relacionado = 1 | Direccion = 1
	-> Pedido [4]  Fecha del pedido = 2006-07-02 10:20:00.0 | Numero Comanda = 450 | Id cliente relacionado = 1 | Direccion = 1

    Líneas de pedido asociadas a estos pedidos:
	-> Linea Pedido [1]  Id del pedido relacionado = 1 | Id del articulo relacionado = 1 | Cantidad = 50
	-> Linea Pedido [2]  Id del pedido relacionado = 2 | Id del articulo relacionado = 3 | Cantidad = 30
	-> Linea Pedido [3]  Id del pedido relacionado = 3 | Id del articulo relacionado = 4 | Cantidad = 20
	-> Linea Pedido [4]  Id del pedido relacionado = 3 | Id del articulo relacionado = 4 | Cantidad = 10
	-> Linea Pedido [5]  Id del pedido relacionado = 4 | Id del articulo relacionado = 8 | Cantidad = 1
    
    ----------------------------
Información del artículo asociado (ID: 1):
Descripción: manzanas
 - cantidad pedida = 50
 - Precio por artículo: 6.0
 - Total por esta línea: 300,00
----------------------------
----------------------------
Información del artículo asociado (ID: 3):
Descripción: Alfombras
 - cantidad pedida = 30
 - Precio por artículo: 18.0
 - Total por esta línea: 540,00
----------------------------
----------------------------
Información del artículo asociado (ID: 4):
Descripción: Sandias
 - cantidad pedida = 20
 - Precio por artículo: 8.56
 - Total por esta línea: 171,20
----------------------------
----------------------------
Información del artículo asociado (ID: 4):
Descripción: Sandias
 - cantidad pedida = 10
 - Precio por artículo: 8.56
 - Total por esta línea: 85,60
----------------------------
----------------------------
Información del artículo asociado (ID: 8):
Descripción: Anillos
 - cantidad pedida = 1
 - Precio por artículo: 18.0
 - Total por esta línea: 18,00
    
El precio total sin descuento es: 1114,80
El descuento aplicado es: 4.0%
El precio total con descuento es: 1070,21
Has pagado 44,59 euros menos 
*/
/*
    public void testSacarPrecioTotalClientePedidos4() throws Exception {
        System.out.println(" ");
        System.out.println("Test 4 - HAY PEDIDOS Y HAY LINEAS DE PEDIDO ASOCIADAS A ESE CLIENTE Y ADEMAS TIENEN ARTICULOS CON PRECIOS");
        System.out.println(" ");
        DataAccessManager dam = null;
        double expResult = 0.0; //PRECIO 
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
    }
*/
    private static class DataAccessManagerSimulation extends DataAccessManager {

        public DataAccessManagerSimulation() {
            super();
        }

        @Override
        public List<Pedido> listarPedidosCliente(String idCliente) {
            return List.of();
        }

        @Override
        public List<LineaPedido> filtrarPedidos(List<Pedido> pedidosCliente) {
            return List.of();
        }

        @Override
        public double sacarPrecioArticulo(String idArticulo) {
            return 0;
        }

        @Override
        public double sacarDescuento(String idCliente) {
            return 0;
        }

    }

}
