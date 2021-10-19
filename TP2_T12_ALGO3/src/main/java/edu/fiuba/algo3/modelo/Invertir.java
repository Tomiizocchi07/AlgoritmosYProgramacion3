package edu.fiuba.algo3.modelo;

public class Invertir extends Bloque{

    private Algoritmo algoritmoInvertido = new Algoritmo();

    public Invertir(){}

    public Invertir(Algoritmo algoritmo) throws AlgoritmoPersonalizadoSinBloquesError {
        if (algoritmo.obtenerAlgoritmo().size() == 0){
            throw new AlgoritmoPersonalizadoSinBloquesError();
        }
        this.algoritmoInvertido = algoritmo;
    }

    public void agregarBloque(Bloque unBloque){ algoritmoInvertido.agregarBloque(unBloque); }

    public Algoritmo obtenerAlgoritmo(){ return algoritmoInvertido; }

    public void agregarAlgoritmo(Algoritmo algoritmo) throws AlgoritmoPersonalizadoSinBloquesError {
        if (algoritmo.obtenerAlgoritmo().size() == 0){
            throw new AlgoritmoPersonalizadoSinBloquesError();
        }
        this.algoritmoInvertido = algoritmo;
    }

    public void ejecutar(Personaje personaje, Tablero tablero){
        algoritmoInvertido.ejecutarInvertido(personaje, tablero);
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero){
        algoritmoInvertido.ejecutar(personaje, tablero);
    }

    public Invertir clonarBloque() throws AlgoritmoPersonalizadoSinBloquesError {
        return new Invertir(this.algoritmoInvertido.clonarAlgoritmo());
    }
}
