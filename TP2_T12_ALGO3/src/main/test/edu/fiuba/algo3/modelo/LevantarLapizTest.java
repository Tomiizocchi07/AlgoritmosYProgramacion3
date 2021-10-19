package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LevantarLapizTest {

    @Test
    public void test01SeCreaUnBloqueLevantarLapizYSeLoEjecuta(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Bloque bloque = new LevantarLapiz();

        bloque.ejecutar(personaje, tablero);

        EstadoLapiz estado = personaje.obtenerEstadoLapiz();

        assertTrue(estado.lapizArriba());
    }

    @Test
    public void test02SeCreaUnBloqueLevantarLapizYSeLoEjecutaInvertido(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Bloque bloque = new LevantarLapiz();

        bloque.ejecutarInvertido(personaje, tablero);

        EstadoLapiz estado = personaje.obtenerEstadoLapiz();

        assertFalse(estado.lapizArriba());
    }
}

