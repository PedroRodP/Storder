package vista;

import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Story;
import modelo.StoryOrder;

public class Aplicacion extends Application {

    @Override
    public void start(Stage stage) {

        //Ejemplos de stories precargadas
        StoryOrder storder = new StoryOrder();
        Story storyExample = new Story("Configurar background", "Elegir imagen que más se adapte", 4);
        Story storyExample2 = new Story("Dar orden a las stories", "Crear métodos para mover las stories y ordenarlas", 10);
        storder.insertarStory(storyExample);
        storder.insertarStory(storyExample2);


        //StageAdmin - Launcher
        StageAdmin admin = new StageAdmin(stage, storder);
    }
}
