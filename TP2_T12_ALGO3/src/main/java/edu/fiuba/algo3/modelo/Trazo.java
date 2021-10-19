package edu.fiuba.algo3.modelo;

public class Trazo {

    private Posicion posicionInicial;
    private Posicion posicionFinal;
    private EstadoLapiz estadoLapiz;

    public Trazo(Posicion posicionInicial, Posicion posicionFinal, EstadoLapiz estadoLapiz){

        this.posicionInicial = posicionInicial;
        this.posicionFinal = posicionFinal;
        this.estadoLapiz = estadoLapiz;
    }

    public Posicion obtenerInicial(){ return this.posicionInicial;}

    public Posicion obtenerFinal(){ return this.posicionFinal;}

    public EstadoLapiz obtenerEstadoLapiz(){ return this.estadoLapiz;}

}
