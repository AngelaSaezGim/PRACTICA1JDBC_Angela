/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metodo3;

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

/**
 *
 * @author angel
 */
public class CalcularCantidadTotalArticulosPedidosAño3Test {
    
      private DataAccessManager dam;
    
    @BeforeEach
    public void setUp() {

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
    }
    
    //COMPLEJIDAD CICLOMATICA = 4
    /**
     * Test of calcularCantidadTotalArticulosPedidosAño method, of class CalcularCantidadTotalArticulosPedidosAño3.
     */
    
    @Test
    public void testCalcularCantidadTotalArticulosPedidosAño1() throws Exception {
        System.out.println("La lista de pedidos año está vacia");
        dam = new DataAccessManagerSimulation();
        int expResult = 0;
        int result = CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño(dam);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcularCantidadTotalArticulosPedidosAño2() throws Exception {
        System.out.println("La lista de pedidos año NO está vacia, pero NO HAY LINEAS DE PEDIDO");
          dam = new DataAccessManagerSimulation() {
            @Override
            public List<Pedido> listarPedidosPorAño(int año) {
                return List.of(new Pedido(1), new Pedido(2)); // Simulamos dos pedidos
            }

            @Override
            public List<LineaPedido> filtrarLineasPedidosIdPedido(String idPedido) {
                return List.of(); 
            }
        };
        int expResult = 0;
        int result = CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño((DataAccessManager) dam);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcularCantidadTotalArticulosPedidosAño3() throws Exception {
        System.out.println("");
        DataAccessManager dam = null;
        int expResult = 0;
        int result = CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño(dam);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCalcularCantidadTotalArticulosPedidosAño4() throws Exception {
        System.out.println("");
        DataAccessManager dam = null;
        int expResult = 0;
        int result = CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño(dam);
        assertEquals(expResult, result);
    }

    private static class DataAccessManagerSimulation extends DataAccessManager {

        public DataAccessManagerSimulation() {
            super(); 
        }

        @Override
        public List<Pedido> listarPedidosPorAño(int año) {
            return List.of(); // Lista vacía para la simulación
        }

        @Override
        public List<LineaPedido> filtrarLineasPedidosIdPedido(String idPedido) {
            return List.of(); // Lista vacía para la simulación
        }
    }

}
