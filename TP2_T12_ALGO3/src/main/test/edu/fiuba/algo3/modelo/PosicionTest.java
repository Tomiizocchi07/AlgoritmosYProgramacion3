package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PosicionTest {

    @Test
    public void test01SeCreaObjetoPosicionVacia() {
        Posicion posicion = new Posicion();
        Posicion posicionEsperada = new Posicion(0, 0);

        assertTrue(posicion.igualA(posicionEsperada));
    }

    @Test
    public void test02SeCreaObjetoPosicionConCoordenadasYSeLoMueveHaciaArriba() {
        Posicion posicion = new Posicion(0, 3);
        Direccion direccionArriba = new Direccion(0,1);
        Posicion nuevaPosicion = posicion.mover(direccionArriba);

        Posicion posicionEsperada = new Posicion(0, 4);

        assertTrue(nuevaPosicion.igualA(posicionEsperada));
    }

    @Test
    public void test03SeCreaObjetoPosicionConCoordenadasYSeLoResetea() {
        Posicion posicion = new Posicion(3, 5);
        posicion.resetearCoordenadas();

        Posicion posicionEsperada = new Posicion(0, 0);

        assertTrue(posicion.igualA(posicionEsperada));
    }
}
