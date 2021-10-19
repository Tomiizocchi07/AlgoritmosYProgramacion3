package edu.fiuba.algo3.vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class EventoSalirEventHandler implements EventHandler<ActionEvent> {

    private final Stage programa;

    public EventoSalirEventHandler(Stage programa) {
        this.programa = programa;
    }

    public void handle(ActionEvent actionEvent){
        programa.close();
    }

}
