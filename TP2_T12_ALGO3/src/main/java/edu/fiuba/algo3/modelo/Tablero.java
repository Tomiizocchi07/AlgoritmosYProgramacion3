package edu.fiuba.algo3.modelo;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.Optional;

public class Tablero {

    private ArrayList<Trazo> trazos = new ArrayList<>();
    private int alto = 10;
    private int ancho = 10;

    public Tablero(){}

    public Tablero(int alto, int ancho){
        this.alto = alto;
        this.ancho = ancho;
    }

    public void actualizar(Posicion posInicial, Posicion posFinal, EstadoLapiz estadoLapiz){
        Trazo trazo = new Trazo(posInicial, posFinal, estadoLapiz);
        trazos.add(trazo);
    }

    public boolean posicionEsValida(Posicion posicion) {
        boolean x = Math.abs(posicion.obtenerX()) <= this.ancho / 2;
        boolean y = Math.abs(posicion.obtenerY()) <= this.alto / 2;
        return x && y;
    }

    public void resetear(){
        this.trazos = new ArrayList<>();
    }

    public ArrayList<Trazo> obtenerTrazos(){ return this.trazos;}
}
