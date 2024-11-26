/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author elize
 */
public class Informacion_alumnosTest {
    
    public Informacion_alumnosTest() {
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
     * Test of cerrar method, of class Informacion_alumnos.
     */
    @Test
    public void testCerrar() {
        System.out.println("cerrar");
        Informacion_alumnos instance = new Informacion_alumnos();
        instance.cerrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmarsalida method, of class Informacion_alumnos.
     */
    @Test
    public void testConfirmarsalida() {
        System.out.println("confirmarsalida");
        Informacion_alumnos instance = new Informacion_alumnos();
        instance.confirmarsalida();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Informacion_alumnos.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Informacion_alumnos.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
