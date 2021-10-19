package edu.fiuba.algo3.modelo;

public class Mover extends Bloque {

    private Direccion direccion = new Direccion();

    public Mover(){ }

    public Mover(Direccion direccion){
        this.direccion = direccion;
    }

    public void ejecutar(Personaje personaje, Tablero tablero){
        personaje.modificarPosicion(direccion, tablero);
    }

    public void agregarAlgoritmo(Algoritmo algoritmo){}

    public void ejecutarInvertido(Personaje personaje, Tablero tablero) {
        Direccion direccionInvertida = direccion.invertir();
        personaje.modificarPosicion(direccionInvertida, tablero);
    }

    public Direccion obtenerDireccion (){
        return this.direccion;
    }

    public Mover clonarBloque(){ return new Mover(new Direccion(direccion.obtenerX(), direccion.obtenerY()));}

}
