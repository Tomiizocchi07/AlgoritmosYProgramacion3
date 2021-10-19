
package edu.fiuba.algo3.modelo;

public class Personaje {
    private EstadoLapiz estadoLapiz;
    private Posicion posicion;

    public Personaje(){
        this.posicion = new Posicion();
        this.estadoLapiz = new LapizArriba();
    }

    public EstadoLapiz obtenerEstadoLapiz(){
        return this.estadoLapiz;
    }

    public Posicion obtenerPosicion(){
        return this.posicion;
    }

    public void modificarPosicion(Direccion direccion, Tablero tablero){
        Posicion nuevaPosicion = this.posicion.mover(direccion);
        if(tablero.posicionEsValida(nuevaPosicion)){
            tablero.actualizar(this.posicion, nuevaPosicion, this.estadoLapiz);
            this.posicion = nuevaPosicion;
        }
    }

    public void modificarEstadoLapiz(EstadoLapiz nuevoEstado){
        this.estadoLapiz = nuevoEstado;
    }

    public void resetear(){
        this.estadoLapiz = new LapizArriba();
        this.posicion.resetearCoordenadas();
    }

}
