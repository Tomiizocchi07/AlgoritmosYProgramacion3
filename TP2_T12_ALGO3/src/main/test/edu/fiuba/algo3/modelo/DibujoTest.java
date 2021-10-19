package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class DibujoTest {

    @Test
    public void test01SeAgregaBloqueMoverArribaAlAlgoritmoYSeEjecuta() throws AlgoritmoSinBloquesError {
        Dibujo dibujo = new Dibujo();
        Direccion direccionArriba = new Direccion(0,1);
        Mover moverArriba = new Mover(direccionArriba);
        dibujo.agregarBloque(moverArriba);
        dibujo.ejecutar();
        Posicion posicionActual = dibujo.personaje().obtenerPosicion();
        Posicion posicionEsperada = new Posicion (0,1);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test02SeAgregaBloqueMoverAbajoAlAlgoritmoYSeEjecuta() throws AlgoritmoSinBloquesError {
        Dibujo dibujo = new Dibujo();
        Direccion direccionAbajo = new Direccion(0,-1);
        Mover moverAbajo = new Mover(direccionAbajo);
        dibujo.agregarBloque(moverAbajo);
        dibujo.ejecutar();

        Posicion posicionActual = dibujo.personaje().obtenerPosicion();
        Posicion posicionEsperada = new Posicion(0,-1);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test03SeAgregaBloqueMoverDerechaAlAlgoritmoYSeEjecuta() throws AlgoritmoSinBloquesError {
        Dibujo dibujo = new Dibujo();
        Direccion direccionDerecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(direccionDerecha);
        dibujo.agregarBloque(moverDerecha);
        dibujo.ejecutar();

        Posicion posicionActual = dibujo.personaje().obtenerPosicion();
        Posicion posicionEsperada = new Posicion (1,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test04SeAgregaBloqueMoverIzquierdaAlAlgoritmoYSeEjecuta() throws AlgoritmoSinBloquesError {
        Dibujo dibujo = new Dibujo();
        Direccion direccionIzquierda = new Direccion(-1,0);
        Mover moverIzquierda = new Mover(direccionIzquierda);
        dibujo.agregarBloque(moverIzquierda);
        dibujo.ejecutar();

        Posicion posicionActual = dibujo.personaje().obtenerPosicion();
        Posicion posicionEsperada = new Posicion(-1,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test05SeAgregaBloqueLevantarLapizAlAlgoritmoYSeEjecuta() throws AlgoritmoSinBloquesError {
        Dibujo dibujo = new Dibujo();
        dibujo.agregarBloque(new LevantarLapiz());
        dibujo.ejecutar();

        EstadoLapiz estado = dibujo.personaje().obtenerEstadoLapiz();

        assertTrue(estado.lapizArriba());
    }

    @Test
    public void test06SeAgregaBloqueBajarLapizAlAlgoritmoYSeEjecuta() throws AlgoritmoSinBloquesError {
        Dibujo dibujo = new Dibujo();
        dibujo.agregarBloque(new BajarLapiz());
        dibujo.ejecutar();

        EstadoLapiz estado = dibujo.personaje().obtenerEstadoLapiz();

        assertTrue(estado.lapizAbajo());
    }

    @Test
    public void test07SeAgregaBloqueInvertirConBloqueMoverDerechaAlAlgoritmoYSeEjecuta() throws AlgoritmoSinBloquesError {
        Dibujo dibujo = new Dibujo();
        Algoritmo algoritmo = new Algoritmo();
        Direccion derecha = new Direccion(1,0);
        Mover moverDerecha = new Mover(derecha);
        algoritmo.agregarBloque(moverDerecha);
        Invertir invertir = new Invertir();
        invertir.agregarBloque(moverDerecha);
        dibujo.agregarBloque(invertir);
        dibujo.ejecutar();

        Posicion posicionActual = dibujo.personaje().obtenerPosicion();
        Posicion posicionEsperada = new Posicion(-1,0);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test08SeAgregaBloqueAlgoritmoPersonalizadoConUnAlgoritmoYSeEjecuta() throws AlgoritmoSinBloquesError, AlgoritmoPersonalizadoSinBloquesError {
        Dibujo dibujo = new Dibujo();
        Algoritmo algoritmo = new Algoritmo();
        Mover moverArriba = new Mover(new Direccion(0,1));
        algoritmo.agregarBloque(moverArriba);
        AlgoritmoPersonalizado algoritmoPersonalizado = new AlgoritmoPersonalizado(algoritmo);
        dibujo.agregarBloque(algoritmoPersonalizado);
        dibujo.ejecutar();

        Posicion posicionActual = dibujo.personaje().obtenerPosicion();
        Posicion posicionEsperada = new Posicion (0,1);

        assertTrue(posicionActual.igualA(posicionEsperada));
    }

    @Test
    public void test09SeAgreganDosBloquesYLuegoSeBorraUno(){
        Dibujo dibujo = new Dibujo();
        ArrayList<Bloque> arrayDeBloques = dibujo.algoritmo().obtenerAlgoritmo();
        BajarLapiz lapizAbajo = new BajarLapiz();
        LevantarLapiz lapizArriba = new LevantarLapiz();
        dibujo.agregarBloque(lapizAbajo);
        dibujo.agregarBloque(lapizArriba);

        assertEquals(2,arrayDeBloques.size());
        dibujo.eliminarBloque(lapizAbajo);
        assertEquals(1,arrayDeBloques.size());
    }

    @Test
    public void test10SeEjecutaSinBloquesDebeLanzarExcepcion(){
        Dibujo dibujo = new Dibujo();

        assertThrows(AlgoritmoSinBloquesError.class, dibujo::ejecutar);
    }


}
