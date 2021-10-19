package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Algoritmo{

    private ArrayList<Bloque> algoritmo = new ArrayList<>();

    public Algoritmo(){}

    public Algoritmo(ArrayList<Bloque> algoritmo) { this.algoritmo = algoritmo;}

    public ArrayList<Bloque> obtenerAlgoritmo() { return algoritmo; }

    public void agregarBloque(Bloque unBloque) { algoritmo.add(unBloque); }

    public void ejecutar(Personaje personaje, Tablero tablero){
        for (Bloque bloque : algoritmo){
            bloque.ejecutar(personaje, tablero);
        }
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero){
        for (Bloque bloque : algoritmo){
            bloque.ejecutarInvertido(personaje, tablero);
        }
    }

    public void eliminarBloque(Bloque bloque) {
        algoritmo.removeIf(bloque1 -> bloque == bloque1);
    }

    public Algoritmo clonarAlgoritmo() throws AlgoritmoPersonalizadoSinBloquesError {
        ArrayList<Bloque> nuevoArray = new ArrayList<>();
        for (Bloque bloque : algoritmo){
            nuevoArray.add(bloque.clonarBloque());
        }
        return new Algoritmo(nuevoArray);
    }

}
