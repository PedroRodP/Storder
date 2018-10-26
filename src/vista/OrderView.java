package vista;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import modelo.StoryOrder;

public class OrderView extends VBox {

    private final StoryOrder storder;
    private PanelView panelView;

    public OrderView(StoryOrder storder, PanelView panelView) {
        this.storder = storder;
        this.panelView = panelView;
        this.setPadding(new Insets(10));
    }

    public void agregarNodo(Node nodo) {
        this.getChildren().add(nodo);
    }

    public void mostrarOrderView() {

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(15));

        storder.verStoryOrder().forEach(story -> {
                    Button storyButton = new Button();
                    storyButton.setPrefWidth(450); //Ancho del boton
                    storyButton.setText(story.verTitulo());
                    storyButton.setOnAction(event -> {
                        panelView.mostrarStory(story);
                    });
                    agregarNodo(storyButton);
                }
        );
    }

    public void actualizar() {
        this.getChildren().clear();
        mostrarOrderView();
    }
}
