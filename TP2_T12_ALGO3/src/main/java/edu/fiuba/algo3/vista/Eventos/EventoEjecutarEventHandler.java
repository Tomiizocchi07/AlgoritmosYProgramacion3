package edu.fiuba.algo3.vista.Eventos;

import edu.fiuba.algo3.vista.SectorDibujo;
import edu.fiuba.algo3.vista.SectorPersonaje;
import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;


public class EventoEjecutarEventHandler implements EventHandler<ActionEvent> {

    private final Dibujo dibujo;
    private final Canvas canva;
    private final SectorDibujo sectorDibujo;

    public EventoEjecutarEventHandler(Dibujo dibujo, Canvas canva, SectorDibujo sectorDibujo) {
        this.dibujo = dibujo;
        this.canva = canva;
        this.sectorDibujo = sectorDibujo;
    }

    public void handle(ActionEvent actionEvent){
        sectorDibujo.resetearCanva();
        dibujo.personaje().resetear();
        dibujo.tablero().resetear();
        GraphicsContext gc = canva.getGraphicsContext2D();

        gc.beginPath();
        double xMedio = (gc.getCanvas().getWidth()) / 2;
        double yMedio = (gc.getCanvas().getHeight()) / 2;
        gc.moveTo(xMedio,yMedio);

        try{
            dibujo.ejecutar();
            SectorPersonaje sectorPersonaje = new SectorPersonaje(gc,xMedio,yMedio);

            ArrayList<Trazo> trazos = this.dibujo.tablero().obtenerTrazos();
            for (Trazo trazo : trazos) {
                if (trazo.obtenerEstadoLapiz().lapizAbajo()) {
                    gc.lineTo(xMedio + trazo.obtenerFinal().obtenerX(), yMedio + trazo.obtenerFinal().obtenerY());
                } else {
                    gc.moveTo(xMedio + trazo.obtenerFinal().obtenerX(), yMedio + trazo.obtenerFinal().obtenerY());
                }
                sectorPersonaje.actualizarPosicion(xMedio + trazo.obtenerFinal().obtenerX(), yMedio + trazo.obtenerFinal().obtenerY());
            }
            gc.stroke();
        } catch(AlgoritmoSinBloquesError exc) {
            Stage ventanaError = new Stage();
            Label mensajeError = new Label();
            mensajeError.setText("El algoritmo no puede estar vacío");
            mensajeError.setTextFill(Color.RED);
            VBox contenedorMensaje = new VBox(mensajeError);
            Scene escenaError = new Scene(contenedorMensaje);
            ventanaError.setScene(escenaError);
            ventanaError.show();
        }

    }

}