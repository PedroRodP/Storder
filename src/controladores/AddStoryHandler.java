package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.Story;
import modelo.StoryOrder;
import vista.ImagesOrquester;
import vista.OrderView;
import vista.PanelView;

public class AddStoryHandler implements EventHandler<ActionEvent> {

    private StoryOrder storder;
    private OrderView orderView;

    public AddStoryHandler(StoryOrder storder, OrderView orderView) {
        this.orderView = orderView;
        this.storder = storder;
    }

    @Override
    public void handle(ActionEvent a) {
        Stage ventana = new Stage();
        Scene escena = new Scene(configurarBorderPane(ventana));
        ventana.setScene(escena);
        configurarStage(ventana);
    }

    private void configurarStage(Stage ventana) {
        ventana.setWidth(800);
        ventana.setHeight(600);
        ventana.setResizable(false);
        ImagesOrquester.configurarIcon(ventana);
        ventana.setTitle("Agregar story...");
        ventana.show();
    }

    private void configurarBotonAceptar(PanelView panelEditable) {
        String titulo = panelEditable.getTitulo().getText();
        String descripcion = panelEditable.getDescripcion().getText();
        int puntos = Integer.parseInt(panelEditable.getPuntos().getText());
        Story story = new Story(titulo, descripcion, puntos);
        storder.insertarStory(story);
        orderView.actualizar();
    }

    private BorderPane configurarBorderPane(Stage ventana) {
        //Configurar pane
        BorderPane pane = new BorderPane();
        ImagesOrquester.configurarBackgroundAddStory(pane);
        pane.setPadding(new Insets(70));

        PanelView panelEditable = PanelView.crearEditable();
        pane.setCenter(panelEditable);

        Button aceptar = new Button("Aceptar");
        aceptar.setOnAction(event -> {
            configurarBotonAceptar(panelEditable);
            ventana.close();
        });
        Button cancelar = new Button("Cancelar");
        cancelar.setOnAction(event -> {
            ventana.close();
        });
        //Configurar botones
        HBox botones = new HBox(aceptar, cancelar);
        botones.setSpacing(5);
        botones.setAlignment(Pos.CENTER_RIGHT);

        pane.setBottom(botones);

        return pane;
    }
}
