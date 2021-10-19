package edu.fiuba.algo3.vista.Eventos;

import edu.fiuba.algo3.modelo.Bloque;
import edu.fiuba.algo3.modelo.Dibujo;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class EventoDragAndDrop {

    ImageView source;
    VBox target;
    Dibujo dibujo;
    Bloque bloque;

    public EventoDragAndDrop(ImageView source, VBox target, Dibujo dibujo, Bloque bloque){
        this.source = source;
        this.target = target;
        this.dibujo = dibujo;
        this.bloque = bloque;
    }

    public void empezarDragAndDrop() {
        source.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {

                //allow any transfer mode
                Dragboard db = source.startDragAndDrop(TransferMode.ANY);

                // put a string on dragboard
                ClipboardContent content = new ClipboardContent();
                content.putImage(source.getImage());
                db.setContent(content);

                event.consume();
            }
        });

        target.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                //data is dragged over the target
                // accept it only if it is  not dragged from the same node and if it has a string data
                if (event.getGestureSource() != target && event.getDragboard().hasImage()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });

        target.setOnDragEntered(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasImage()) {
                    target.setStyle("-fx-background-color: #add8e6;");
                }

                event.consume();
            }
        });

        target.setOnDragExited(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                target.setStyle("-fx-background-color: #336699;");

                event.consume();
            }
        });

        target.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {
                    success = true;
                }
                event.setDropCompleted(success);

                event.consume();
            }
        });

        source.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                Dragboard db = event.getDragboard();
                ImageView image = new ImageView(db.getImage());
                Button button = new Button();
                button.setGraphic(image);
                button.setOnAction(new EventoEliminarBloqueEventHandler(dibujo, bloque, target, button));
                target.getChildren().add(button);
                target.setAlignment(Pos.BOTTOM_CENTER);
                dibujo.agregarBloque(bloque);
                event.consume();
            }
        });

    }
}
