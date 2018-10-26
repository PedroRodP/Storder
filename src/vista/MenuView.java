package vista;

import controladores.AddStoryHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import modelo.StoryOrder;

public class MenuView extends MenuBar {

    public MenuView(StoryOrder storder, OrderView orderView) {
        configurarMenuStories(storder, orderView);
        configurarMenuAyuda();
    }

    private void agregarMenu(Menu menu) {
        this.getMenus().add(menu);
    }

    private void agregarMenuItem(MenuItem item, Menu menu) {
        menu.getItems().add(item);
    }

    private void configurarMenuAyuda() {
        Menu ayuda = new Menu("Ayuda");
        MenuItem acercaDe = new MenuItem("Acerca de...");
        acercaDe.setOnAction(event -> {
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Acerca de...");
            info.setHeaderText("STORDER.");
            info.setContentText("Story Order. Story Manager.");
            Stage alerta = (Stage) info.getDialogPane().getScene().getWindow();
            ImagesOrquester.configurarIcon(alerta);
            info.show();
        });
        agregarMenuItem(acercaDe, ayuda);

        agregarMenu(ayuda);
    }

    private void configurarMenuStories(StoryOrder storder, OrderView orderView) {
        Menu stories = new Menu("Stories");
        MenuItem agregar = new MenuItem("Agregar story");
        agregar.setOnAction(new AddStoryHandler(storder, orderView));
        agregarMenuItem(agregar, stories);

        agregarMenu(stories);
    }
}
