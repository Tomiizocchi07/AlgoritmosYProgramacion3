package edu.fiuba.algo3.vista.Eventos;

import edu.fiuba.algo3.vista.SectorAlgoritmo;
import edu.fiuba.algo3.vista.SectorDibujo;
import edu.fiuba.algo3.vista.SectorIconos;
import edu.fiuba.algo3.modelo.Dibujo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EventoBotonIniciarEventHandler implements EventHandler<ActionEvent> {
    private Dibujo dibujo;
    private Stage stageBienvenida;

    public EventoBotonIniciarEventHandler(Dibujo dibujo, Stage stageBienvenida){

        this.dibujo = dibujo;
        this.stageBienvenida = stageBienvenida;
    }


    public void handle(ActionEvent actionEvent){

        //cierro ventana de bienvenida
        stageBienvenida.close();

        //creo nueva ventana
        Stage programa = new Stage();

        //sector de algoritmo
        SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();

        //sector de algoritmos personalizados
        VBox algoritmosPersonalizados = new VBox();
        algoritmosPersonalizados.setPrefHeight(200);
        algoritmosPersonalizados.setAlignment(Pos.CENTER);


        //sector de iconos que se arrastran al sector Algoritmo
        SectorIconos sectorIconos = new SectorIconos(sectorAlgoritmo, dibujo);

        sectorIconos.crearIconoMoverArriba();
        sectorIconos.crearIconoMoverAbajo();
        sectorIconos.crearIconoMoverDerecha();
        sectorIconos.crearIconoMoverIzquierda();
        sectorIconos.crearIconoLevantarLapiz();
        sectorIconos.crearIconoBajarLapiz();

        sectorIconos.crearIconoInvertir(algoritmosPersonalizados);
        sectorIconos.crearIconoRepetir(algoritmosPersonalizados,2);
        sectorIconos.crearIconoRepetir(algoritmosPersonalizados,3);
        sectorIconos.crearIconoAlgoritmoPersonalizado(algoritmosPersonalizados);


        //sector de dibujo
        SectorDibujo sectorDibujo = new SectorDibujo();

        //Botones Controladores
        sectorIconos.crearIconosControladores(sectorDibujo.obtenerCanva(), programa, sectorDibujo);

        HBox contenedorBotonesControladores = new HBox(sectorIconos.obtenerEjecutar(),sectorIconos.obtenerBorrar(), sectorIconos.obtenerSalir());
        contenedorBotonesControladores.setSpacing(10);
        VBox contenedorVertical = new VBox(sectorDibujo.obtenerCanva(),contenedorBotonesControladores);
        contenedorVertical.setAlignment(Pos.CENTER);

        //toda la pagina
        HBox contenedorHorizontal = new HBox(contenedorVertical, sectorIconos.obtenerContenedorDeIconos(), sectorAlgoritmo.obtenerContenedorDeAlgoritmo(),algoritmosPersonalizados);//, deletePanel);
        contenedorHorizontal.setSpacing(20);
        contenedorHorizontal.setAlignment(Pos.CENTER);





        Scene scene = new Scene(contenedorHorizontal,600,600);

        programa.setScene(scene);
        programa.setMaximized(true);
        programa.show();
    }

}
