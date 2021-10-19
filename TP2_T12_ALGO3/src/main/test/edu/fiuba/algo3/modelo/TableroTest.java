package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {

    @Test
    public void test01AgregoUnTrazoAlTablero(){
        Tablero tablero = new Tablero();
        tablero.actualizar(new Posicion(), new Posicion(1,2), new LapizArriba());

        assertEquals(tablero.obtenerTrazos().size(),1);
    }

    @Test
    public void test02SeAgregaUnaPosicionAlTableroYLuegoSeLoResetea(){
        Tablero tablero = new Tablero();
        tablero.actualizar(new Posicion(), new Posicion(1,2), new LapizArriba());
        tablero.resetear();

        assertEquals(tablero.obtenerTrazos().size(),0);
    }

    @Test
    public void test03SeVerificaQueUnaPosicionConCoordenadasMayoresAlTamanioDelTableroEsInvalida(){
        Tablero tablero = new Tablero(5, 5);
        Posicion posicion = new Posicion(6, 6);

        assertFalse(tablero.posicionEsValida(posicion));
    }
}
