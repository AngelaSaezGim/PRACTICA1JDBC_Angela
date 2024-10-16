/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metodo2;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practica1App.BorrarFabricasSinArticuloPedido2;
import static org.junit.jupiter.api.Assertions.*;
import practica1DataAccess.DataAccessManager;

/**
 *
 * @author angel
 */
public class BorrarFabricasSinArticuloPedido2Test {
    
    public BorrarFabricasSinArticuloPedido2Test() {
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
     * Test of FiltrarFabricasSinPedido method, of class BorrarFabricasSinArticuloPedido2.
     */
    @Test
    public void testFiltrarFabricasSinPedido() throws Exception {
        System.out.println("FiltrarFabricasSinPedido");
        DataAccessManager dam = null;
        List<String> expResult = null;
        List<String> result = BorrarFabricasSinArticuloPedido2.FiltrarFabricasSinPedido(dam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarFabricasSinArticuloPedido method, of class BorrarFabricasSinArticuloPedido2.
     */
    @Test
    public void testBorrarFabricasSinArticuloPedido() throws Exception {
        System.out.println("borrarFabricasSinArticuloPedido");
        DataAccessManager dam = null;
        int expResult = 0;
        int result = BorrarFabricasSinArticuloPedido2.borrarFabricasSinArticuloPedido(dam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
