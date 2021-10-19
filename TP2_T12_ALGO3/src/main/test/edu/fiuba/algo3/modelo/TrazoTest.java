package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrazoTest {

    @Test
    public void test01SeCreaUnTrazoYSeObtieneLaPosicionInicial(){
        Posicion posInicial = new Posicion(1, 1);
        Posicion posFinal = new Posicion(3, 4);
        EstadoLapiz estado = new LapizArriba();
        Trazo trazo = new Trazo(posInicial, posFinal, estado);

        Posicion posicionEsperada = new Posicion(1, 1);

        assertTrue(posicionEsperada.igualA(trazo.obtenerInicial()));
    }

    @Test
    public void test02SeCreaTrazoYSeObtieneLaPosicionFinal(){
        Posicion posInicial = new Posicion();
        Posicion posFinal = new Posicion(3, 4);
        EstadoLapiz estado = new LapizArriba();
        Trazo trazo = new Trazo(posInicial, posFinal, estado);

        Posicion posicionEsperada = new Posicion(3, 4);

        assertTrue(posicionEsperada.igualA(trazo.obtenerFinal()));
    }

    @Test
    public void test03SeCreaTrazoConEstadoLapizArribaYSeObtieneElEstado(){
        Posicion posInicial = new Posicion();
        Posicion posFinal = new Posicion(3, 4);
        EstadoLapiz estado = new LapizArriba();
        Trazo trazo = new Trazo(posInicial, posFinal, estado);

        assertTrue(trazo.obtenerEstadoLapiz().lapizArriba());
    }
}
