package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LapizAbajoTest {

    @Test
    public void test01SeCreaLapizAbajoYSeLlamaALapizAbajo(){
        EstadoLapiz lapiz = new LapizAbajo();

        assertTrue(lapiz.lapizAbajo());
    }

    @Test
    public void test02SeCreaLapizAbajoYSeLlamaALapizArriba(){
        EstadoLapiz lapiz = new LapizAbajo();

        assertFalse(lapiz.lapizArriba());
    }
}
