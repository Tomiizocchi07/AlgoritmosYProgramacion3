package edu.fiuba.algo3.modelo;

public class Direccion {
    private int x;
    private int y;

    //Constructor
    public Direccion(){
    }

    public Direccion(int coordenadaX, int coordenadaY){
        this.x = coordenadaX;
        this.y = coordenadaY;
    }

    public int obtenerX(){
        return this.x;
    }
    public int obtenerY(){
        return this.y;
    }

    public Direccion invertir(){
        int coordenadaX = (-1) * this.x;
        int coordenadaY = (-1) * this.y;
        return new Direccion(coordenadaX,coordenadaY);
    }

    public boolean coordenadasIgualesA(int coordenadaX, int coordenadaY){
        return (coordenadaX == this.x) && (coordenadaY == this.y);
    }

}
