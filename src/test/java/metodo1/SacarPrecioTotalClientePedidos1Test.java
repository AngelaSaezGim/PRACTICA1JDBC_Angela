/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metodo1;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;
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
import practica1Objetos.Articulo;

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
                String fechaStr = "2003-09-01 00:30:02";
                Timestamp fechaPedido = Timestamp.valueOf(fechaStr);
                return List.of(
                        new Pedido(1, fechaPedido, 1001, 1, 1),
                        new Pedido(2, fechaPedido, 1, 44, 2),
                        new Pedido(3, fechaPedido, 99, 1, 1),
                        new Pedido(4, fechaPedido, 450, 1, 1)
                ); //Pedido 1 , pedido 2, pedido 3 y pedido 4
            }

            @Override
            public List<LineaPedido> filtrarPedidos(List<Pedido> pedidosCliente) {
                return List.of(); // Simulamos que no hay líneas de pedido
            }

        };
        double expResult = 0.0;
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
    }

    @Test
    public void testSacarPrecioTotalClientePedidos3() throws Exception {
        System.out.println(" ");
        System.out.println("Test 3 - HAY PEDIDOS Y HAY LINEAS DE PEDIDO ASOCIADAS A ESE CLIENTE PERO NO HAY ARTICULOS");
        System.out.println(" ");
        dam = new DataAccessManagerSimulation() {

            @Override
            public List<Pedido> listarPedidosCliente(String idCliente) {
                String fechaStr = "2003-09-01 00:30:02";
                Timestamp fechaPedido = Timestamp.valueOf(fechaStr);
                return List.of(
                        new Pedido(1, fechaPedido, 1001, 1, 1),
                        new Pedido(2, fechaPedido, 1, 44, 2),
                        new Pedido(3, fechaPedido, 99, 1, 1),
                        new Pedido(4, fechaPedido, 450, 1, 1)
                ); //Pedido 1 , pedido 2, pedido 3 y pedido 4
            }

            @Override
            public List<LineaPedido> filtrarPedidos(List<Pedido> pedidosCliente) {
                return List.of(
                        new LineaPedido(1, 1, 1, 50),
                        new LineaPedido(2, 2, 3, 30),
                        new LineaPedido(3, 3, 4, 20),
                        new LineaPedido(4, 3, 4, 10),
                        new LineaPedido(5, 4, 8, 1)); // Simulación de líneas de pedido sin artículos (no cantidad)
            }

            @Override
            public Articulo loadArticuloByCode(String idArticulo) {
                System.out.println("No se encontraron articulos");
                throw new NoSuchElementException("No se encontró el artículo con ID: " + idArticulo);
            }

        };

        assertThrows(NoSuchElementException.class, () -> {
            SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        });
    }

    /*
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
    @Test

    public void testSacarPrecioTotalClientePedidos4() throws Exception {
        System.out.println(" ");
        System.out.println("Test 4 - HAY PEDIDOS Y HAY LINEAS DE PEDIDO ASOCIADAS A ESE CLIENTE Y ADEMAS TIENEN ARTICULOS CON PRECIOS");
        System.out.println(" ");
        dam = new DataAccessManagerSimulation() {

            @Override
            public List<Pedido> listarPedidosCliente(String idCliente) {
                String fechaStr = "2003-09-01 00:30:02";
                Timestamp fechaPedido = Timestamp.valueOf(fechaStr);
                return List.of(
                        new Pedido(1, fechaPedido, 1001, 1, 1),
                        new Pedido(2, fechaPedido, 1, 44, 2),
                        new Pedido(3, fechaPedido, 99, 1, 1),
                        new Pedido(4, fechaPedido, 450, 1, 1)
                ); //Pedido 1 , pedido 2, pedido 3 y pedido 4
            }

            @Override
            public List<LineaPedido> filtrarPedidos(List<Pedido> pedidosCliente) {
                return List.of(
                        new LineaPedido(1, 1, 1, 50),
                        new LineaPedido(2, 2, 3, 30),
                        new LineaPedido(3, 3, 4, 20),
                        new LineaPedido(4, 3, 4, 10),
                        new LineaPedido(5, 4, 8, 1)); // Simulación de líneas de pedido sin artículos (no cantidad)
            }

            @Override
            public Articulo loadArticuloByCode(String idArticulo) {
                return new Articulo("Articulo de prueba");
            }

        };
        double expResult = 0.0; //PRECIO 
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
    }

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
        public Articulo loadArticuloByCode(String idArticulo) {
            return new Articulo("Articulo de prueba");
        }

        @Override
        public double sacarPrecioArticulo(String idArticulo) {
            return 0;
        }

        @Override
        public double sacarDescuento(String idCliente) {
            return 4;
        }

    }

}
