package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.Eventos.*;
import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.*;
import javafx.stage.Stage;

public class SectorIconos {

    private SectorAlgoritmo sectorAlgoritmo;
    private Dibujo dibujo;
    private HBox contenedorDeIconos;
    private Button botonEjecutar;
    private Button botonBorrar;
    private Button botonSalir;

    public SectorIconos(SectorAlgoritmo sectorAlgoritmo, Dibujo dibujo) {

        this.sectorAlgoritmo = sectorAlgoritmo;
        this.dibujo = dibujo;

        VBox primerContenedor = new VBox();
        VBox segundoContenedor = new VBox();
        primerContenedor.setAlignment(Pos.CENTER);
        primerContenedor.setSpacing(10);
        segundoContenedor.setAlignment(Pos.CENTER);
        segundoContenedor.setSpacing(10);
        this.contenedorDeIconos = new HBox(primerContenedor, segundoContenedor);
        this.contenedorDeIconos.setSpacing(10);
        this.contenedorDeIconos.setAlignment(Pos.CENTER);
    }

    public HBox obtenerContenedorDeIconos(){
        return this.contenedorDeIconos;
    }

    public Button obtenerEjecutar(){
        return this.botonEjecutar;
    }

    public Button obtenerBorrar() { return this.botonBorrar; }

    public Button obtenerSalir() { return this.botonSalir; }

    public void crearIconosControladores(Canvas canva, Stage programa, SectorDibujo sectorDibujo){
        EventoEjecutarEventHandler eventoEjecutarEventHandler = new EventoEjecutarEventHandler(dibujo, canva, sectorDibujo);
        EventoBorrarEventHandler eventoBorrarEventHandler = new EventoBorrarEventHandler(dibujo, sectorDibujo);
        EventoSalirEventHandler eventoSalirEventHandler = new EventoSalirEventHandler(programa);
        this.botonEjecutar = crearIcono("src/main/java/edu/fiuba/algo3/vista/Images/ejecutar.png", eventoEjecutarEventHandler);
        this.botonBorrar = crearIcono("src/main/java/edu/fiuba/algo3/vista/Images/delete.png", eventoBorrarEventHandler);
        this.botonSalir = crearIcono("src/main/java/edu/fiuba/algo3/vista/Images/salir.png", eventoSalirEventHandler);
    }

    public Button crearIcono(String ruta, EventHandler<ActionEvent> evento) {
        ImageView imgIcono = generarImagenesLabels(ruta);
        Button botonIcono = new Button();
        botonIcono.setGraphic(imgIcono);
        //EventoEjecutarEventHandler eventoEjecutarEventHandler = new EventoEjecutarEventHandler(dibujo, canva);
        botonIcono.setOnAction(evento);
        return botonIcono;
    }

    public void crearIconoMoverArriba() {
        ImageView imgMoverArriba = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/moverArriba.png");
        Direccion direccionArriba = new Direccion(0, -25);
        Mover moverArriba = new Mover(direccionArriba);
        EventoDragAndDrop drag = new EventoDragAndDrop(imgMoverArriba, sectorAlgoritmo.obtenerContenedorDeBloques(), dibujo, moverArriba);//, deletePanel);
        drag.empezarDragAndDrop();
        ((VBox)contenedorDeIconos.getChildren().get(1)).getChildren().add(imgMoverArriba);
    }

    public void crearIconoMoverAbajo() {
        ImageView imgMoverAbajo = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/moverAbajo.png");
        Direccion direccionAbajo = new Direccion(0, 25);
        Mover moverAbajo = new Mover(direccionAbajo);
        EventoDragAndDrop drag = new EventoDragAndDrop(imgMoverAbajo, sectorAlgoritmo.obtenerContenedorDeBloques(), dibujo, moverAbajo);//, deletePanel);
        drag.empezarDragAndDrop();
        ((VBox)contenedorDeIconos.getChildren().get(1)).getChildren().add(imgMoverAbajo);
    }

    public void crearIconoMoverDerecha() {
        ImageView imgMoverDerecha = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/moverDerecha.png" );
        Direccion direccionDerecha = new Direccion(25, 0);
        Mover moverDerecha = new Mover(direccionDerecha);
        EventoDragAndDrop drag = new EventoDragAndDrop(imgMoverDerecha, sectorAlgoritmo.obtenerContenedorDeBloques(), dibujo, moverDerecha);//, deletePanel);
        drag.empezarDragAndDrop();
        ((VBox)contenedorDeIconos.getChildren().get(1)).getChildren().add(imgMoverDerecha);
    }

    public void crearIconoMoverIzquierda() {
        ImageView imgMoverIzquierda = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/moverIzquierda.png");
        Direccion direccionIzquierda = new Direccion(-25, 0);
        Mover moverIzquierda = new Mover(direccionIzquierda);
        EventoDragAndDrop drag = new EventoDragAndDrop(imgMoverIzquierda, sectorAlgoritmo.obtenerContenedorDeBloques(), dibujo, moverIzquierda);//, deletePanel);
        drag.empezarDragAndDrop();
        ((VBox)contenedorDeIconos.getChildren().get(1)).getChildren().add(imgMoverIzquierda);
    }

    public void crearIconoLevantarLapiz() {
        ImageView imgLevantarLapiz = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/levantarLapiz.png");
        LevantarLapiz levantarLapiz = new LevantarLapiz();
        EventoDragAndDrop drag = new EventoDragAndDrop(imgLevantarLapiz, sectorAlgoritmo.obtenerContenedorDeBloques(), dibujo, levantarLapiz);//, deletePanel);
        drag.empezarDragAndDrop();
        ((VBox)contenedorDeIconos.getChildren().get(1)).getChildren().add(imgLevantarLapiz);
    }

    public void crearIconoBajarLapiz() {

        ImageView imgBajarLapiz = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/bajarLapiz.png");
        BajarLapiz bajarLapiz = new BajarLapiz();
        EventoDragAndDrop drag = new EventoDragAndDrop(imgBajarLapiz, sectorAlgoritmo.obtenerContenedorDeBloques(), dibujo, bajarLapiz);//, deletePanel);
        drag.empezarDragAndDrop();
        ((VBox)contenedorDeIconos.getChildren().get(1)).getChildren().add(imgBajarLapiz);
    }

    public void crearIconoInvertir(VBox contenedorDeAlgoritmos) {
        ImageView imgInvertir = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/Invertir.png");
        Button botonInvertir = new Button();
        Invertir invertir = new Invertir();
        botonInvertir.setGraphic(imgInvertir);
        EventoAlgoritmoPersonalizadoEventHandler eventoAlgoritmoPersonalizadoEventHandler = new EventoAlgoritmoPersonalizadoEventHandler(contenedorDeAlgoritmos, dibujo, sectorAlgoritmo.obtenerContenedorDeBloques(), invertir, "src/main/java/edu/fiuba/algo3/vista/Images/invertirGuardado.png");
        botonInvertir.setOnAction(eventoAlgoritmoPersonalizadoEventHandler);
        ((VBox)contenedorDeIconos.getChildren().get(0)).getChildren().add(botonInvertir);
    }

    public void crearIconoRepetir(VBox contenedorDeAlgoritmos, int numVeces) {

        ImageView imgRepetir;

        if (numVeces == 2){
            imgRepetir = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/repetir2.png" );
        }
        else{
            imgRepetir = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/repetir3.png" );
        }

        Button botonRepetir = new Button();
        Repetir repetir = new Repetir(numVeces);
        botonRepetir.setGraphic(imgRepetir);
        EventoAlgoritmoPersonalizadoEventHandler eventoAlgoritmoPersonalizadoEventHandler = new EventoAlgoritmoPersonalizadoEventHandler(contenedorDeAlgoritmos, dibujo, sectorAlgoritmo.obtenerContenedorDeBloques(), repetir, "src/main/java/edu/fiuba/algo3/vista/Images/repetirGuardado.png");
        botonRepetir.setOnAction(eventoAlgoritmoPersonalizadoEventHandler);
        ((VBox)contenedorDeIconos.getChildren().get(0)).getChildren().add(botonRepetir);
    }

    public void crearIconoAlgoritmoPersonalizado(VBox contenedorDeAlgoritmos) {
        ImageView imgAlgoritmoPersonalizado = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/algoritmoPersonalizado.png" );
        Button botonAlgoritmoPersonalizado = new Button();
        botonAlgoritmoPersonalizado.setGraphic(imgAlgoritmoPersonalizado);
        AlgoritmoPersonalizado algoritmoPersonalizado = new AlgoritmoPersonalizado();
        EventoAlgoritmoPersonalizadoEventHandler eventoAlgoritmoPersonalizadoEventHandler = new EventoAlgoritmoPersonalizadoEventHandler(contenedorDeAlgoritmos, dibujo, sectorAlgoritmo.obtenerContenedorDeBloques(),algoritmoPersonalizado, "src/main/java/edu/fiuba/algo3/vista/Images/guardarAlgoritmo.png");
        botonAlgoritmoPersonalizado.setOnAction(eventoAlgoritmoPersonalizadoEventHandler);
        ((VBox)contenedorDeIconos.getChildren().get(0)).getChildren().add(botonAlgoritmoPersonalizado);
    }

    public ImageView generarImagenesLabels(String ruta){
        try {
            var input = new java.io.FileInputStream(ruta);
            var image = new javafx.scene.image.Image(input);
            return new javafx.scene.image.ImageView(image);
        }
        catch(java.io.FileNotFoundException ex) {
            System.err.println("An IOException was caught!");
            ex.printStackTrace();
        }

        return null;
    }
}
