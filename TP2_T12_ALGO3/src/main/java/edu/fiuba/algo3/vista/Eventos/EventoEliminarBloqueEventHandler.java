package edu.fiuba.algo3.vista.Eventos;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.Dibujo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class EventoEliminarBloqueEventHandler implements EventHandler<ActionEvent> {
    private final Dibujo dibujo;
    private final Bloque bloque;
    private final VBox contenedorVertical;
    private final Button boton;

    public EventoEliminarBloqueEventHandler(Dibujo dibujo, Bloque bloque, VBox contenedorVertical, Button boton){
        this.dibujo = dibujo;
        this.bloque = bloque;
        this.contenedorVertical = contenedorVertical;
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        dibujo.eliminarBloque(bloque);
        contenedorVertical.getChildren().remove(boton);
    }
}
