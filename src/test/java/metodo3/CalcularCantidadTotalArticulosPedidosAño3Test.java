/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metodo3;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practica1App.CalcularCantidadTotalArticulosPedidosAño3;
import static org.junit.jupiter.api.Assertions.*;
import practica1DataAccess.DataAccessManager;
import practica1Objetos.Pedido;

/**
 *
 * @author angel
 */
public class CalcularCantidadTotalArticulosPedidosAño3Test {
    
    public CalcularCantidadTotalArticulosPedidosAño3Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of filtrarPedidosAño method, of class CalcularCantidadTotalArticulosPedidosAño3.
     */
    @Test
    public void testFiltrarPedidosAño() throws Exception {
        System.out.println("filtrarPedidosA\u00f1o");
        DataAccessManager dam = null;
        List<Pedido> expResult = null;
        List<Pedido> result = CalcularCantidadTotalArticulosPedidosAño3.filtrarPedidosAño(dam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularCantidadTotalArticulosPedidosAño method, of class CalcularCantidadTotalArticulosPedidosAño3.
     */
    @Test
    public void testCalcularCantidadTotalArticulosPedidosAño() throws Exception {
        System.out.println("calcularCantidadTotalArticulosPedidosA\u00f1o");
        DataAccessManager dam = null;
        int expResult = 0;
        int result = CalcularCantidadTotalArticulosPedidosAño3.calcularCantidadTotalArticulosPedidosAño(dam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
