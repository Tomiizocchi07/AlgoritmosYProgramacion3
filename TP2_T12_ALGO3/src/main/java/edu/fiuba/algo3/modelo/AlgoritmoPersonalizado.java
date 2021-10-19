package edu.fiuba.algo3.modelo;

public class AlgoritmoPersonalizado extends Bloque{

    private Algoritmo algoritmoGuardado = new Algoritmo();

    public AlgoritmoPersonalizado(){}

    public AlgoritmoPersonalizado(Algoritmo algoritmo) throws AlgoritmoPersonalizadoSinBloquesError {
        if (algoritmo.obtenerAlgoritmo().size() == 0){
            throw new AlgoritmoPersonalizadoSinBloquesError();
        }
        this.algoritmoGuardado = algoritmo;
    }

    public void agregarAlgoritmo(Algoritmo algoritmo) throws AlgoritmoPersonalizadoSinBloquesError {
        if (algoritmo.obtenerAlgoritmo().size() == 0){
            throw new AlgoritmoPersonalizadoSinBloquesError();
        }
        this.algoritmoGuardado = algoritmo;}

    public Algoritmo obtenerAlgoritmo(){return algoritmoGuardado;}

    public void ejecutar(Personaje personaje, Tablero tablero){
        algoritmoGuardado.ejecutar(personaje, tablero);
    }

    public void ejecutarInvertido(Personaje personaje, Tablero tablero){
        algoritmoGuardado.ejecutarInvertido(personaje, tablero);
    }

    public AlgoritmoPersonalizado clonarBloque() throws AlgoritmoPersonalizadoSinBloquesError{
        return new AlgoritmoPersonalizado(this.algoritmoGuardado.clonarAlgoritmo());
    }

}
