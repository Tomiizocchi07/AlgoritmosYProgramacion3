package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AlgoritmoPersonalizadoTest {

    @Test
    public void test01SeCreaUnBloqueAlgoritmoPersonalizadoConAlgoritmoVacio(){
        AlgoritmoPersonalizado algoritmoPersonalizado = new AlgoritmoPersonalizado();
        Algoritmo algoritmo = algoritmoPersonalizado.obtenerAlgoritmo();
        ArrayList<Bloque> arrayDeBloques = algoritmo.obtenerAlgoritmo();

        assertEquals(0,arrayDeBloques.size());
    }

    @Test
    public void test02SeCreaUnBloqueAlgoritmoPersonalizadoConAlgoritmoYaCreadoYSeLoEjecuta() throws AlgoritmoPersonalizadoSinBloquesError {
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Algoritmo algoritmo = new Algoritmo();
        Direccion direccionArriba = new Direccion(0,1);
        Mover bloqueMoverArriba = new Mover(direccionArriba);
        algoritmo.agregarBloque(bloqueMoverArriba);
        AlgoritmoPersonalizado algoritmoPersonalizado = new AlgoritmoPersonalizado(algoritmo);
        algoritmoPersonalizado.ejecutar(personaje, tablero);
        Posicion posicionEsperada = new Posicion(0,1);
        Posicion posicionActual = personaje.obtenerPosicion();

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test03SeCreaUnBloqueAlgoritmoPersonalizadoConAlgoritmoYaCreadoYSeLoEjecutaInvertido() throws AlgoritmoPersonalizadoSinBloquesError {
        Personaje personaje = new Personaje();
        Tablero tablero = new Tablero();
        Algoritmo algoritmo = new Algoritmo();
        Direccion direccionArriba = new Direccion(0,1);
        Mover bloqueMoverArriba = new Mover(direccionArriba);
        algoritmo.agregarBloque(bloqueMoverArriba);

        AlgoritmoPersonalizado algoritmoPersonalizado = new AlgoritmoPersonalizado(algoritmo);
        algoritmoPersonalizado.ejecutarInvertido(personaje, tablero);
        Posicion posicionActual = personaje.obtenerPosicion();
        Posicion posicionEsperada = new Posicion(0,-1);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test04SeCreaUnBloqueAlgoritmoPersonalizadoConAlgoritmoYSeAgregaAOtroAlgoritmo() throws AlgoritmoPersonalizadoSinBloquesError {
        Algoritmo algoritmoUno = new Algoritmo();
        Algoritmo algoritmoDos = new Algoritmo();

        Direccion direccionArriba = new Direccion(0,1);
        Mover bloqueMoverArriba = new Mover(direccionArriba);
        algoritmoUno.agregarBloque(bloqueMoverArriba);

        Direccion direccionAbajo = new Direccion(0,-1);
        Mover bloqueMoverAbajo = new Mover(direccionAbajo);
        algoritmoDos.agregarBloque(bloqueMoverAbajo);
        BajarLapiz bloqueBajarLapiz = new BajarLapiz();
        algoritmoDos.agregarBloque(bloqueBajarLapiz);

        AlgoritmoPersonalizado algoritmoPersonalizado = new AlgoritmoPersonalizado(algoritmoDos);
        algoritmoUno.agregarBloque(algoritmoPersonalizado);

        ArrayList<Bloque> arrayDeBloques = algoritmoUno.obtenerAlgoritmo();

        assertEquals(2,arrayDeBloques.size()); //Deberia tener 2 bloques, uno para el MoverArriba y otro para el AlgoritmoPersonalizado
    }

    @Test
    public void test05SeCreaAlgoritmoPersonalizadoConAlgoritmoVacioDebeLanzarExcepcion(){
        Algoritmo algoritmo = new Algoritmo();
        assertThrows(AlgoritmoPersonalizadoSinBloquesError.class, () -> new AlgoritmoPersonalizado(algoritmo));
    }

    @Test
    public void test06SeCreaAlgoritmoPersonalizadoYSeAgregaUnAlgoritmoVacioDebeLanzarExcepcion(){
        Algoritmo algoritmo = new Algoritmo();
        AlgoritmoPersonalizado personalizado = new AlgoritmoPersonalizado();

        assertThrows(AlgoritmoPersonalizadoSinBloquesError.class, () -> personalizado.agregarAlgoritmo(algoritmo));
    }
}
