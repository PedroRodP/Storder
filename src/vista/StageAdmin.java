package vista;

import controladores.Notificador;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.StoryOrder;

import javax.management.Notification;
import java.awt.*;

public class StageAdmin {

    private Stage stage;
    private BorderPane bpane;
    private OrderView orderView;
    private PanelView panelView;
    private StoryOrder storder;

    public StageAdmin(Stage stage, StoryOrder storder) {
        this.stage = stage;
        this.bpane = new BorderPane();
        this.storder = storder;

        inicializarStage();
    }


    public void inicializarStage() {
        try {
            Notificador notificador = new Notificador();
            //Se inicializa primero el PanelView porque el OrderView requiere de este
            inicializarPanelView();
            inicializarOrderView();
            inicializarMenuBar();
            configurarStage();
            stage.setOnCloseRequest(event -> {
                notificador.apagar();
            });
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void inicializarOrderView() {
        this.orderView = new OrderView(storder, panelView);
        orderView.mostrarOrderView(); //actualiza lista de stories
        bpane.setLeft(orderView);
    }

    private void inicializarPanelView() {
        this.panelView = PanelView.crearDeLectura();
        bpane.setRight(panelView);
    }

    private void inicializarMenuBar() {
        MenuView menuView = new MenuView(storder, orderView);
        bpane.setTop(menuView);
    }

    private void configurarStage() {
        //Set escena
        Scene scene = new Scene(bpane);
        stage.setScene(scene);

        //Set dimensiones
        stage.setWidth(1024);
        stage.setHeight(700);
        stage.setResizable(false);

        //Set imagenes
        ImagesOrquester.configurarIcon(stage);
        ImagesOrquester.configurarBackgroundPrincipal(bpane);

        //Launch
        stage.setTitle("Storder");
        stage.show();
    }

}
