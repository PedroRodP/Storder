package vista;

import controladores.Notificador;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import modelo.Story;
import modelo.StoryOrder;

public class Aplicacion extends Application {

    @Override
    public void start(Stage stage) {

        //Ejemplos de stories precargadas
        StoryOrder storder = StoryOrder.instanciar();
        Story storyExample = new Story("Configurar background", "Elegir imagen que más se adapte", 4);
        Story storyExample2 = new Story("Dar orden a las stories", "Crear métodos para mover las stories y ordenarlas", 10);
        storder.insertarStory(storyExample);
        storder.insertarStory(storyExample2);

        //No terminar ejecucion al cerrar ventana
        Platform.setImplicitExit(false);

        //Notificador - Launcher
        Notificador notificador = Notificador.instanciar();
        notificador.run();

        //StageAdmin - Launcher
        StageAdmin admin = new StageAdmin();
        admin.run();

        //TODO On exit: notificador.limpiarBandeja();
    }
}
