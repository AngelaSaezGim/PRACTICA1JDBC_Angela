/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metodo1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import practica1App.SacarPrecioTotalClientePedidos1;
import static org.junit.jupiter.api.Assertions.*;
import practica1DataAccess.DataAccessManager;

/**
 *
 * @author angel
 */
public class SacarPrecioTotalClientePedidos1Test {
    
    private DataAccessManager dam;
    
        
    @BeforeEach
    public void setUp() {
        dam = new DataAccessManagerSimulation();
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
     * Test of sacarPrecioTotalClientePedidos method, of class SacarPrecioTotalClientePedidos1.
     */
    //COMPLEJIDAD CICLOMATICA = 4
    @Test
    public void testSacarPrecioTotalClientePedidos1() throws Exception {
        System.out.println("sacarPrecioTotalClientePedidos");
        DataAccessManager dam = null;
        double expResult = 0.0;
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void testSacarPrecioTotalClientePedidos2() throws Exception {
        System.out.println("sacarPrecioTotalClientePedidos");
        DataAccessManager dam = null;
        double expResult = 0.0;
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void testSacarPrecioTotalClientePedidos3() throws Exception {
        System.out.println("sacarPrecioTotalClientePedidos");
        DataAccessManager dam = null;
        double expResult = 0.0;
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    public void testSacarPrecioTotalClientePedidos4() throws Exception {
        System.out.println("sacarPrecioTotalClientePedidos");
        DataAccessManager dam = null;
        double expResult = 0.0;
        double result = SacarPrecioTotalClientePedidos1.sacarPrecioTotalClientePedidos(dam);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    private static class DataAccessManagerSimulation extends DataAccessManager {

        public DataAccessManagerSimulation() {
            super(); 
        }

    }
    
}
