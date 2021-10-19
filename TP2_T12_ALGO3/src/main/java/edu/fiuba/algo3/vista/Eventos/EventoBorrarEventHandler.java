package edu.fiuba.algo3.vista.Eventos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vista.SectorDibujo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EventoBorrarEventHandler implements EventHandler<ActionEvent>{

    private final SectorDibujo sectorDibujo;
    private final Dibujo dibujo;

    public EventoBorrarEventHandler(Dibujo dibujo, SectorDibujo sectorDibujo){
        this.sectorDibujo = sectorDibujo;
        this.dibujo = dibujo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        sectorDibujo.resetearCanva();
        dibujo.personaje().resetear();
        dibujo.tablero().resetear();
    }


}
