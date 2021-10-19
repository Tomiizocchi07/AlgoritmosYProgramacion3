package edu.fiuba.algo3.modelo;

public class Dibujo {

    private Algoritmo algoritmo = new Algoritmo();
    private Personaje personaje = new Personaje();
    private Tablero tablero = new Tablero(10, 10);

    public Dibujo(){ }

    public Dibujo(int alto, int ancho){
        this.tablero = new Tablero(alto, ancho);
    }

    public Personaje personaje(){
        return this.personaje;
    }

    public Tablero tablero(){ return this.tablero; }

    public Algoritmo algoritmo(){return this.algoritmo;}

    public void agregarBloque (Bloque bloque){
        this.algoritmo.agregarBloque(bloque);
    }

    public void ejecutar() throws AlgoritmoSinBloquesError {
        if(algoritmo.obtenerAlgoritmo().size() == 0) {
            throw new AlgoritmoSinBloquesError();
        }
        this.algoritmo.ejecutar(this.personaje, this.tablero);
    }

    public void eliminarBloque(Bloque bloque){ this.algoritmo.eliminarBloque(bloque);}

}
