package edu.fiuba.algo3.modelo;

public class BajarLapiz extends Bloque{

    public BajarLapiz(){    }

    public void ejecutar(Personaje personaje, Tablero tablero){
        personaje.modificarEstadoLapiz(new LapizAbajo());
    }

    public void agregarAlgoritmo(Algoritmo algoritmo){}

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        EstadoLapiz lapizArriba = new LapizArriba();
        personaje.modificarEstadoLapiz(lapizArriba);
    }

    public BajarLapiz clonarBloque(){ return new BajarLapiz();}
}
