package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepetirTest {

    @Test
    public void test01SeCreaUnBloqueRepetirConAlgoritmoVacio(){
        Repetir bloqueRepetir = new Repetir();
        Algoritmo algoritmoRepetido = bloqueRepetir.obtenerAlgoritmo();
        ArrayList<Bloque> arrayDeBloques = algoritmoRepetido.obtenerAlgoritmo();

        assertEquals(0,arrayDeBloques.size());
    }

    @Test
    public void test02SeCreaUnBloqueRepetirConBloqueMoverYSeLoEjecuta(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Direccion derecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(derecha);
        Repetir bloqueRepetir = new Repetir();

        bloqueRepetir.agregarBloque(moverDerecha);
        bloqueRepetir.ejecutar(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(2,0);

        //Por default, el bloque Repetir se repite 2 veces
        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test03SeCreaUnBloqueRepetirTresVecesConBloqueMoverYSeLoEjecuta(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Direccion derecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(derecha);
        Repetir bloqueRepetir = new Repetir(3);

        bloqueRepetir.agregarBloque(moverDerecha);
        bloqueRepetir.ejecutar(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(3,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test04SeCreaUnBloqueRepetirConBloqueMoverYSeLoEjecutaInvertido(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Direccion derecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(derecha);
        Repetir bloqueRepetir = new Repetir();

        bloqueRepetir.agregarBloque(moverDerecha);
        bloqueRepetir.ejecutarInvertido(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(-2,0);

        //Por default, el bloque Repetir se repite 2 veces
        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test05SeCreaUnBloqueRepetirTresVecesConBloqueMoverYSeLoEjecutaInvertido(){
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Direccion derecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(derecha);
        Repetir bloqueRepetir = new Repetir(3);

        bloqueRepetir.agregarBloque(moverDerecha);
        bloqueRepetir.ejecutarInvertido(personaje, tablero);

        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(-3,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test08SeCreaBloqueRepetirConAlgoritmoVacioDebeLanzarExcepcion(){
        Algoritmo algoritmo = new Algoritmo();

        assertThrows(AlgoritmoPersonalizadoSinBloquesError.class, () -> new Repetir(2, algoritmo));
    }

    @Test
    public void test09SeCreaBloqueRepetirYSeAgregaUnAlgoritmoVacioDebeLanzarExcepcion(){
        Algoritmo algoritmo = new Algoritmo();
        Repetir repetir = new Repetir();

        assertThrows(AlgoritmoPersonalizadoSinBloquesError.class, () -> repetir.agregarAlgoritmo(algoritmo));
    }



}
