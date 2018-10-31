package vista;

import controladores.TemporizadorDeStories;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modelo.StoryOrder;

public class StageAdmin extends Thread {

    private Stage stage;
    private BorderPane bpane;
    private OrderView orderView;
    private PanelView panelView;
    private StoryOrder storder;
    private static boolean inicializado;

    public StageAdmin() {
        this.stage = new Stage();
        this.storder = StoryOrder.instanciar();
    }

    @Override
    public void run() {
        if (!inicializado) inicializarStage();
    }

    private void inicializarStage() {
        inicializarBandejaDeSistema();
        inicializarViews();
        configurarStage();
    }

    private void inicializarViews() {
        //Se inicializa en este orden por dependencias
        this.bpane = new BorderPane();
        inicializarPanelView();
        inicializarOrderView();
        inicializarMenuBar();
    }

    private void inicializarBandejaDeSistema() {
        stage.setOnCloseRequest(event -> {
            TemporizadorDeStories.cancelarTodo();
            inicializado = false;
        });
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
        inicializado = true;
    }

}
