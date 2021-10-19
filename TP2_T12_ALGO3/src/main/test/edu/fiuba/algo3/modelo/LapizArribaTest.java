package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LapizArribaTest {

    @Test
    public void test01SeCreaLapizArribaYSeLlamaALapizArriba(){
        EstadoLapiz lapiz = new LapizArriba();

        assertTrue(lapiz.lapizArriba());
    }

    @Test
    public void test02SeCreaLapizArribaYSeLlamaALapizAbajo(){
        EstadoLapiz lapiz = new LapizArriba();

        assertFalse(lapiz.lapizAbajo());
    }
}
