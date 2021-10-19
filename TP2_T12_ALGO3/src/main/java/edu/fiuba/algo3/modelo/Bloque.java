package edu.fiuba.algo3.modelo;

public abstract class Bloque {

    public abstract void ejecutar(Personaje personaje, Tablero tablero);

    public abstract void ejecutarInvertido(Personaje personaje, Tablero tablero);

    public abstract void agregarAlgoritmo(Algoritmo algoritmo) throws AlgoritmoPersonalizadoSinBloquesError;

    public abstract Bloque clonarBloque() throws AlgoritmoPersonalizadoSinBloquesError;
}
