package edu.fiuba.algo3.vista.Eventos;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EventoAlgoritmoPersonalizadoEventHandler implements EventHandler<ActionEvent> {
    private final Dibujo dibujo;
    private final VBox contenedorDeBloques;
    private final VBox contenedorDeAlgoritmos;
    private final String ruta;
    private final Bloque bloque;

    public EventoAlgoritmoPersonalizadoEventHandler(VBox contenedorDeAlgoritmos, Dibujo dibujo, VBox contenedorDeBloques, Bloque bloque, String ruta){
        this.dibujo = dibujo;
        this.contenedorDeBloques = contenedorDeBloques;
        this.contenedorDeAlgoritmos = contenedorDeAlgoritmos;
        this.contenedorDeAlgoritmos.setAlignment(Pos.TOP_CENTER);
        this.bloque = bloque;
        this.ruta = ruta;
    }

    public Label guardarNombreAlgoritmo(){
        Stage ventanaTextField = new Stage();
        TextField inputField = new TextField();
        Label consigna = new Label("Escriba el nombre de su bloque personalizado");
        Button botonGuardar = new Button("Guardar");
        Label nombreAlgoritmo = new Label();
        Label mensaje = new Label(" ");
        VBox contenedorVertical = new VBox(consigna, inputField, botonGuardar, mensaje);
        Scene escenaTextField = new Scene(contenedorVertical);
        ventanaTextField.setScene(escenaTextField);
        ventanaTextField.setResizable(true);
        ventanaTextField.show();

        botonGuardar.setOnAction(e -> {
            try{
                String nombre = inputField.getText();
                nombreAlgoritmo.setText(nombre);
                if (nombre.length() == 0) {
                    throw new BloqueSinNombreError();
                }
                else{ ventanaTextField.close();}
            }
            catch(BloqueSinNombreError exc){
                mensaje.setText("El nombre del bloque no puede estar vacío");
                mensaje.setTextFill(Color.RED);
            }
        });
        return nombreAlgoritmo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        try{
            Algoritmo nuevoAlgoritmo = dibujo.algoritmo().clonarAlgoritmo();
            bloque.agregarAlgoritmo(nuevoAlgoritmo);
            Label nombreAlgoritmo = guardarNombreAlgoritmo();
            System.out.println(nombreAlgoritmo.getText());
            ImageView imgBloqueGuardado = generarImagenesLabels(ruta);
            VBox contenedorVertical = new VBox(imgBloqueGuardado, nombreAlgoritmo);
            contenedorVertical.setSpacing(10);
            contenedorDeAlgoritmos.getChildren().add(contenedorVertical);
            EventoDragAndDrop drag = new EventoDragAndDrop(imgBloqueGuardado, contenedorDeBloques, dibujo, bloque);
            drag.empezarDragAndDrop();
        }
        catch (AlgoritmoPersonalizadoSinBloquesError exc) {
            Stage ventanaError = new Stage();
            Label mensajeError = new Label();
            mensajeError.setText("El bloque personalizado no puede estar vacío");
            mensajeError.setTextFill(Color.RED);
            VBox contenedorMensaje = new VBox(mensajeError);
            Scene escenaError = new Scene(contenedorMensaje);
            ventanaError.setScene(escenaError);
            ventanaError.show();
        }
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