package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BajarLapizTest {

    @Test
    public void test01SeCreaUnBloqueBajarLapizYSeLoEjecuta(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Bloque bloque = new BajarLapiz();

        bloque.ejecutar(personaje, tablero);

        EstadoLapiz estado = personaje.obtenerEstadoLapiz();

        assertTrue(estado.lapizAbajo());
    }

    @Test
    public void test02SeCreaUnBloqueBajarLapizYSeLoEjecutaInvertido(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Bloque bloque = new BajarLapiz();

        bloque.ejecutarInvertido(personaje, tablero);

        EstadoLapiz estado = personaje.obtenerEstadoLapiz();

        assertFalse(estado.lapizAbajo() );
    }
}
