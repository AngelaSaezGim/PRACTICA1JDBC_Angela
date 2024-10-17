/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metodo3;

import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practica1App.CalcularCantidadTotalArticulosPedidosAño3;
import static org.junit.jupiter.api.Assertions.*;
import practica1DataAccess.DataAccessManager;
import practica1Objetos.Pedido;
import practica1Objetos.LineaPedido;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class CalcularCantidadTotalArticulosPedidosAño3Test {

    private DataAccessManager dam;

    @BeforeEach
    public void setUp() {

        // Simulamos la entrada del año como 2003 para todos los tests
        // Buscado - SerIn redirige la entrada estándar (System.in) para que el Scanner lea siempre "2003"
        System.setIn(new ByteArrayInputStream("2003\n".getBytes()));
        dam = new DataAccessManagerSimulation();

    }

    public CalcularCantidadTotalArticulosPedidosAño3Test() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @AfterEach
    public void tearDown() {
        System.setIn(System.in);
    }

    //COMPLEJIDAD CICLOMATICA = 4
    /**
     * Test of calcularCantidadTotalArticulosPedidosAño method, of class
     * CalcularCantidadTotalArticulosPedidosAño3.
     */
    @Test
    public void testCalcularCantidadTotalArticulosPedidosAño1() throws Exception {
        System.out.println("");
        System.out.println("TEST 1 - La lista de pedidos año está vacia");
        System.out.println("");
        dam = new DataAccessManagerSimulation() {
            @Override
            public List<Pedido> listarPedidosPorAño(int año) {
                return List.of();
            }
        };
        int expResult = 0;
        int result = CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño(dam);
        assertEquals(expResult, result);
    }

    @Test
    public void testCalcularCantidadTotalArticulosPedidosAño2() throws Exception {
        
        System.out.println("");
        System.out.println("TEST 2 - La lista de pedidos año NO está vacia, pero NO HAY LINEAS DE PEDIDO");
        System.out.println("");
        dam = new DataAccessManagerSimulation() {
            @Override
            public List<Pedido> listarPedidosPorAño(int año) { //(formato: YYYY-MM-DD HH:MM:SS) - fecha -2003
                String fechaStr ="2003-09-01 00:30:02";
                Timestamp fechaPedido = Timestamp.valueOf(fechaStr);
                return List.of(new Pedido(1, fechaPedido, 1, 1, 1), new Pedido(2, fechaPedido, 1, 1, 1)); //Pedido 1 y pedido 2
            }

            @Override
            public List<LineaPedido> filtrarLineasPedidosIdPedido(String idPedido) {
                return List.of();
            }
        };
        int expResult = 0;
        int result = CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño(dam);
        assertEquals(expResult, result);
    }

    @Test
    public void testCalcularCantidadTotalArticulosPedidosAño3() throws Exception {
        
        System.out.println("");
        System.out.println("TEST 3 - La lista de pedidos año NO está vacia, y las lineas de Pedido tienen cantidades de artículos");
        System.out.println("");
        dam = new DataAccessManagerSimulation() {
            @Override
            public List<Pedido> listarPedidosPorAño(int año) {
                String fechaStr="2003-09-01 00:30:00";
                Timestamp fechaPedido = Timestamp.valueOf(fechaStr);
                return List.of(new Pedido(1,fechaPedido , 1, 1, 1), new Pedido(2,fechaPedido, 1, 1, 1)); //Pedido 1 y pedido 2
            }

            @Override
            public List<LineaPedido> filtrarLineasPedidosIdPedido(String idPedido) {
                if (idPedido.equals("1")) {
                    return List.of(
                            new LineaPedido(1, 1, 1, 10), //IdLineaPedido - 1, IdPedido - 1, Articulo - 1, Cantidad - 10
                            new LineaPedido(2, 1, 2, 3)
                    );
                } else if (idPedido.equals("2")) {
                    return List.of(
                            new LineaPedido(3, 2, 3, 2) // Pedido 2, Articulo 3, Cantidad 2
                    );
                }
                return List.of();
            }
        };
        int expResult = 15;
        int result = CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño(dam);
        assertEquals(expResult, result);
    }

    @Test
    public void testCalcularCantidadTotalArticulosPedidosAño4() throws Exception {
        System.out.println("");
        System.out.println("TEST 4 - La lista de pedidos año NO está vacia, pero algunas lineas de pedido tienen cantidad 0");
        System.out.println("");
        dam = new DataAccessManagerSimulation() {
            @Override
            public List<Pedido> listarPedidosPorAño(int año) {
                String fechaStr="2003-09-01 00:30:00";
                Timestamp fechaPedido = Timestamp.valueOf(fechaStr);
                return List.of(new Pedido(1,fechaPedido , 1, 1, 1), new Pedido(2,fechaPedido, 1, 1, 1)); //Pedido 1 y pedido 2
            }

            @Override
            public List<LineaPedido> filtrarLineasPedidosIdPedido(String idPedido) {
                if (idPedido.equals("1")) {
                    return List.of(
                            new LineaPedido(1, 1, 1, 10), //Cantidad - 10
                            new LineaPedido(2, 1, 2, 0) // Cantidad 0
                    );
                } else if (idPedido.equals("2")) {
                    return List.of(
                            new LineaPedido(3, 2, 3, 0) 
                    );
                }
                return List.of();
            }
        };
        int expResult = 10;
        int result = CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño(dam);
        assertEquals(expResult, result);
    }
    
    private static class DataAccessManagerSimulation extends DataAccessManager {

        public DataAccessManagerSimulation() {
            super();
        }

        @Override
        public List<Pedido> listarPedidosPorAño(int año) {
            return List.of();
        }

        @Override
        public List<LineaPedido> filtrarLineasPedidosIdPedido(String idPedido) {
            return List.of();
        }
    }

}
