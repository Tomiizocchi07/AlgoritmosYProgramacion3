package edu.fiuba.algo3.vista;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.*;
import javafx.scene.paint.Color;

public class SectorPersonaje {
    private double x;
    private double y;
    private GraphicsContext gc;
    private Image imagen;

    public SectorPersonaje(GraphicsContext gc, double x, double y){
        this.x = x;
        this.y = y;
        this.gc = gc;
        gc.setFill(Color.RED);
        gc.fillOval(x - 5,y - 5,10,10);
    }

    public void actualizarPosicion(double x, double y){
        gc.fillOval(x-5,y-5,10,10);
    }
}

