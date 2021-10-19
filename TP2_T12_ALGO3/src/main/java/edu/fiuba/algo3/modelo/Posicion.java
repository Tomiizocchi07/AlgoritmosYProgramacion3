package edu.fiuba.algo3.modelo;

public class Posicion {
    private int x = 0;
    private int y = 0;

    public Posicion(){}

    public Posicion(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Posicion mover (Direccion direccion){
        return new Posicion(
            this.x + direccion.obtenerX(),
            this.y + direccion.obtenerY());
    }

    public int obtenerX(){
        return x;
    }

    public int obtenerY(){
        return y;
    }

    public boolean igualA(Posicion pos){
        return (pos.obtenerX() == this.x) && (pos.obtenerY() == this.y);
    }

    public void resetearCoordenadas() {
        this.x = 0;
        this.y = 0;
    }
}
