import modelo.Story;
import modelo.StoryOrder;
import org.junit.Test;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StoryOrderTest {

    @Test
    public void testInsertarStoryGuardaStory() {

        StoryOrder order = new StoryOrder();
        Story story = new Story("titulo", "descripcion", 5);

        order.insertarStory(story);

        assertEquals(order.verStoryOrder().get(0), story);
    }

    @Test
    public void testInsertarStoryEnPosicionGuardaStoryEnPosicion() {

        StoryOrder order = new StoryOrder();
        Story story = new Story("titulo", "descripcion", 5);
        Story aux = new Story("auxtit", "auxdescrip", 3);
        int pos = 5;

        for (int i = 0; i < 10; i++) {
            order.insertarStory(aux);
        }
        order.insertarStory(story, pos);

        //assertEquals(aux, order.verStoryOrder().get(5));
        assertEquals(story, order.verStoryOrder().get(pos + 1)); //Pos+1 por ser un método de LinkedList
        //assertEquals(aux, order.verStoryOrder().get(7));
    }

    @Test
    public void testBorrarStoryPorTituloEliminaStory() {

        StoryOrder order = new StoryOrder();
        String tituloBuscado = "Prueba";
        int pos = 5;
        Story story = new Story(tituloBuscado, "descripcion", 5);
        Story aux = new Story("titulo", "descripcion", 5);

        for (int i = 0; i < 10; i++) {
            order.insertarStory(aux);
        }
        order.insertarStory(story, pos);
        order.borrarStory(tituloBuscado);

        assertNotEquals(tituloBuscado, order.verStoryOrder().get(pos+1).verTitulo());
    }

    @Test
    public void testObtenerStoryPorTituloDevuelveStoryConEseTitulo() throws NotFound {

        StoryOrder order = new StoryOrder();
        String tituloBuscado = "Prueba";
        int pos = 5;
        Story story = new Story(tituloBuscado, "descripcion", 5);
        Story aux = new Story("titulo", "descripcion", 5);

        for (int i = 0; i < 10; i++) {
            order.insertarStory(aux);
        }
        order.insertarStory(story, pos);

        Story esperada = order.buscarStoryPorTitulo(tituloBuscado);

        assertEquals(order.verStoryOrder().get(pos+1), esperada);
    }

    @Test
            (expected = NotFound.class)
    public void testObtenerStoryPorTituloLanzaNotFoundExceptionSiNoLoEncuentra() throws NotFound {

        StoryOrder order = new StoryOrder();
        String tituloBuscado = "Prueba";
        Story aux = new Story("titulo", "descripcion", 5);

        for (int i = 0; i < 10; i++) {
            order.insertarStory(aux);
        }

        Story esperada = order.buscarStoryPorTitulo(tituloBuscado);
    }
}
