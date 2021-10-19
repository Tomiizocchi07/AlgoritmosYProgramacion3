package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class InvertirTest {

    @Test
    public void test01SeCreaUnBloqueInvertirConUnAlgoritmoVacio(){
        Invertir bloqueInvertir = new Invertir();
        Algoritmo algoritmoInvertido = bloqueInvertir.obtenerAlgoritmo();
        ArrayList<Bloque> arrayDeBloques = algoritmoInvertido.obtenerAlgoritmo();

        assertEquals(0,arrayDeBloques.size());
    }

    @Test
    public void test02SeCreaUnBloqueInvertirSeAgregaBloqueMoverDerechaYPersonajeVaALaIzquierda(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Direccion derecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(derecha);
        Invertir bloqueInvertir = new Invertir();

        bloqueInvertir.agregarBloque(moverDerecha);
        bloqueInvertir.ejecutar(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(-1,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test03SeCreaUnBloqueInvertirConAlgoritmoHaciaLaDerechaYLoInviertoALaIzquierda() throws AlgoritmoPersonalizadoSinBloquesError {
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Algoritmo algoritmo = new Algoritmo();
        Direccion derecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(derecha);
        algoritmo.agregarBloque(moverDerecha);

        Invertir bloqueInvertir = new Invertir(algoritmo);
        bloqueInvertir.ejecutar(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(-1,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test04SeCreaUnBloqueInvertirSeAgregaBloqueBajarLapizYPersonajeSubeLapiz(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();
        Invertir bloqueInvertir = new Invertir();

        bloqueInvertir.agregarBloque(bloqueBajarLapiz);
        bloqueInvertir.ejecutar(personaje, tablero);

        EstadoLapiz estado = personaje.obtenerEstadoLapiz();

        assertFalse(estado.lapizAbajo());
    }

    @Test
    public void test05SeCreaUnBloqueInvertirConAlgoritmoBajarLapizYPersonajeSubeLapiz() throws AlgoritmoPersonalizadoSinBloquesError {
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Algoritmo algoritmo = new Algoritmo();
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();

        algoritmo.agregarBloque(bloqueBajarLapiz);
        Invertir bloqueInvertir = new Invertir(algoritmo);
        bloqueInvertir.ejecutar(personaje, tablero);

        EstadoLapiz estado = personaje.obtenerEstadoLapiz();

        assertFalse(estado.lapizAbajo());
    }

    @Test
    public void test06SeCreaUnBloqueInvertirSeAgregaBloqueMoverDerechaYSeLoEjecutaInvertido(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Direccion derecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(derecha);
        Invertir bloqueInvertir = new Invertir();

        bloqueInvertir.agregarBloque(moverDerecha);
        bloqueInvertir.ejecutarInvertido(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(1,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test07SeCreaUnBloqueInvertirConAlgoritmoHaciaLaDerechaYSeLoEjecutaInvertido() throws AlgoritmoPersonalizadoSinBloquesError {
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Algoritmo algoritmo = new Algoritmo();
        Direccion derecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(derecha);
        algoritmo.agregarBloque(moverDerecha);

        Invertir bloqueInvertir = new Invertir(algoritmo);
        bloqueInvertir.ejecutarInvertido(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(1,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test08SeCreaBloqueInvertirConAlgoritmoVacioDebeLanzarExcepcion(){
        Algoritmo algoritmo = new Algoritmo();

        assertThrows(AlgoritmoPersonalizadoSinBloquesError.class, () -> new Invertir(algoritmo));
    }

    @Test
    public void test09SeCreaBloqueInvertirYSeAgregaUnAlgoritmoVacioDebeLanzarExcepcion(){
        Algoritmo algoritmo = new Algoritmo();
        Invertir invertir = new Invertir();

        assertThrows(AlgoritmoPersonalizadoSinBloquesError.class, () -> invertir.agregarAlgoritmo(algoritmo));
    }


}
