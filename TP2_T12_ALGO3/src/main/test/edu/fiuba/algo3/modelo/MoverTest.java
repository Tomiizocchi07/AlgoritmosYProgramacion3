package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MoverTest {
    @Test
    public void test01SeCreaObjetoMover(){
        Mover bloqueMover = new Mover();
        Direccion direccion = bloqueMover.obtenerDireccion();

        assertTrue(direccion.coordenadasIgualesA(0,0));
    }

    @Test
    public void test02SeCreaObjetoMoverArriba(){
        //creo una direccion "arriba" con x=0 e y=1
        Mover bloqueMover = new Mover(new Direccion(0,1));
        Direccion direccion = bloqueMover.obtenerDireccion();

        assertTrue(direccion.coordenadasIgualesA(0, 1));
    }

    @Test
    public void test03SeCreaObjetoMoverAbajo(){
        //creo una direccion "abajo" con x=0 e y=-1
        Mover bloqueMover = new Mover(new Direccion(0,-1));
        Direccion direccion = bloqueMover.obtenerDireccion();

        assertTrue(direccion.coordenadasIgualesA(0, -1));
    }

    @Test
    public void test04SeCreaObjetoMoverALaDerecha(){
        //creo una direccion "a la derecha" con x=1 e y=0
        Mover bloqueMover = new Mover(new Direccion(1,0));
        Direccion direccion = bloqueMover.obtenerDireccion();

        assertTrue(direccion.coordenadasIgualesA(1, 0));
    }

    @Test
    public void test05SeCreaObjetoMoverALaIzquierda(){
        //creo una direccion "a la izquierda" con x=-1 e y=0
        Mover bloqueMover = new Mover(new Direccion(-1,0));
        Direccion direccion = bloqueMover.obtenerDireccion();

        assertTrue(direccion.coordenadasIgualesA(-1, 0));
    }

    @Test
    public void test06SeCreaObjetoMoverArribaYSeLoEjecuta(){
        //creo una direccion "arriba" con x=0 e y=1
        Direccion direccionArriba = new Direccion(0,1);
        Mover bloqueMover = new Mover(direccionArriba);

        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        bloqueMover.ejecutar(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(0,1);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test06SeCreaObjetoMoverArribaYSeLoEjecutaInvertido(){
        //creo una direccion "arriba" con x=0 e y=1
        Direccion direccionArriba = new Direccion(0,1);
        Mover bloqueMover = new Mover(direccionArriba);

        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        bloqueMover.ejecutarInvertido(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(0,-1);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }


}
