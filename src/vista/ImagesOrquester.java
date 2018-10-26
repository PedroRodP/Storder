package vista;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ImagesOrquester {

    public static void configurarIcon(Stage ventana) {
        ventana.getIcons().add(new Image(StageAdmin.class.getResourceAsStream("/resources/icon/icon.png")));
    }

    public static void configurarBackgroundPrincipal(BorderPane bpane) {
        configurarBackground(bpane, "resources/background/background2.png", 1200, 800);
    }

    public static void configurarBackgroundAddStory(BorderPane bpane) {
        configurarBackground(bpane, "resources/background/book.png",1024, 680);
    }

    public static void configurarBackground(BorderPane bpane, String ruta, int width, int height) {
        BackgroundImage bg = new BackgroundImage(new Image(ruta,
                width,height,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        bpane.setBackground(new Background(bg));
    }
}
