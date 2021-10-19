package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SectorAlgoritmo {

    private VBox algoritmo;
    private VBox bloques;

    public SectorAlgoritmo(){
        VBox bloques = new VBox();
        bloques.setPrefHeight(600);
        this.bloques = bloques;
        ImageView imgTituloAlgoritmo = generarImagenesLabels("src/main/java/edu/fiuba/algo3/vista/Images/tituloAlgoritmo.png" );
        VBox algoritmo = new VBox(imgTituloAlgoritmo, bloques);
        algoritmo.setStyle("-fx-background-color: #336699;");
        algoritmo.setPrefWidth(400);
        algoritmo.setAlignment(Pos.TOP_CENTER);
        algoritmo.setSpacing(5);
        this.algoritmo = algoritmo;

    }

    public VBox obtenerContenedorDeAlgoritmo(){
        return this.algoritmo;
    }

    public VBox obtenerContenedorDeBloques(){
        return this.bloques;
    }

    private ImageView generarImagenesLabels(String ruta){
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
