package edu.fiuba.algo3.modelo;

public class LevantarLapiz extends Bloque{

    public LevantarLapiz(){ }

    public void ejecutar(Personaje personaje, Tablero tablero){
        personaje.modificarEstadoLapiz(new LapizArriba());
    }

    public void agregarAlgoritmo(Algoritmo algoritmo){}

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        EstadoLapiz lapizAbajo = new LapizAbajo();
        personaje.modificarEstadoLapiz(lapizAbajo);
    }

    public LevantarLapiz clonarBloque(){ return new LevantarLapiz();}
}
