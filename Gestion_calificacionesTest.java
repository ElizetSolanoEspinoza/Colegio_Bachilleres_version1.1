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
public class Gestion_calificacionesTest {
    
    public Gestion_calificacionesTest() {
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
     * Test of mostrartabla method, of class Gestion_calificaciones.
     */
    @Test
    public void testMostrartabla() {
        System.out.println("mostrartabla");
        String valor = "";
        Gestion_calificaciones instance = new Gestion_calificaciones();
        instance.mostrartabla(valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Gestion_calificaciones.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Gestion_calificaciones.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
