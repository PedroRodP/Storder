package vista;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.Story;

public class PanelView extends VBox {

    private boolean modificable;
    private TextField titulo;
    private TextArea descripcion;
    private TextField puntos;

    private PanelView(){
        //No se puede instanciar un PanelView sin indicicar modo lectura o escritura
    }

    public static PanelView crearDeLectura() {
        PanelView panel = new PanelView();
        panel.modificable = false;
        panel.crearStandard();
        return panel;
    }

    public static PanelView crearEditable() {
        PanelView panel = new PanelView();
        panel.modificable = true;
        panel.crearStandard();
        return panel;
    }

    public TextField getTitulo() {
        return titulo;
    }

    public TextArea getDescripcion() {
        return descripcion;
    }

    public TextField getPuntos() {
        return puntos;
    }

    private void crearStandard() {
        this.titulo = new TextField();
        this.descripcion = new TextArea();
        this.puntos = new TextField();
        Story standard = new Story("Story", "Detalles", 0);
        this.setPadding(new Insets(10));
        mostrarStory(standard);
    }

    public void mostrarStory(Story story) {
        limpiar();
        agregarTextFieldTitulo(story.verTitulo());
        agregarTextAreaDescripcion(story.verDescripcion());
        agregarTextPuntos(story.verPuntos());
    }

    private void limpiar() {
        this.getChildren().clear();
    }

    public void agregarNodo(Node nodo) {
        this.getChildren().add(nodo);
    }

    private void agregarTextFieldTitulo(String titulo) {
        this.titulo.setText(titulo);
        hacerModificable(this.titulo);
        agregarNodo(this.titulo);
    }

    private void agregarTextAreaDescripcion(String descripcion) {
        this.descripcion.setText(descripcion);
        hacerModificable(this.descripcion);
        agregarNodo(this.descripcion);
    }

    private void agregarTextPuntos(int puntos) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5));

        String puntosString = Integer.toString(puntos);
        if (puntos < 10) {
            puntosString = "0" + puntosString;
        }
        this.puntos.setText(puntosString);
        hacerModificable(this.puntos);
        this.puntos.setMaxWidth(30);

        pane.setRight(this.puntos);
        agregarNodo(pane);
    }

    private void hacerModificable(TextInputControl text) {
        if (modificable) {
            text.setEditable(true);
        }
        else {
            text.setEditable(false);
        }
    }
}
