package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PersonajeTest {

    @Test
    public void test01SeCreaPersonajePorDefectoConLapizArriba() {
        Personaje personaje = new Personaje();
        EstadoLapiz estadoLapiz = personaje.obtenerEstadoLapiz();

        assertTrue(estadoLapiz.lapizArriba());
    }

    @Test
    public void test02SeModificaElEstadoDelLapizDelPersonajeALapizAbajo() {
        Personaje personaje = new Personaje();
        personaje.modificarEstadoLapiz(new LapizAbajo());
        EstadoLapiz estadoLapiz = personaje.obtenerEstadoLapiz();

        assertTrue(estadoLapiz.lapizAbajo());
    }

    @Test
    public void test03SeModificaLaPosicionDelPersonajeCincoLugaresHaciaArriba() {
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Direccion direccionArriba = new Direccion(0, 5);
        personaje.modificarPosicion(direccionArriba, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(0,5);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test04SeCreaUnPersonajeSeLeModificaLaPosicionYSeLoResetea(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Direccion direccionArriba = new Direccion(0, 5);
        personaje.modificarPosicion(direccionArriba, tablero);

        personaje.resetear();
        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(0,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test05SeCreaUnPersonajeSeLeModificaElEstadoDelLapizHaciaAbajoYSeLoResetea(){
        Personaje personaje = new Personaje();
        personaje.modificarEstadoLapiz(new LapizAbajo());

        personaje.resetear();
        EstadoLapiz estadoActual = personaje.obtenerEstadoLapiz();

        assertTrue(estadoActual.lapizArriba());
    }
}
