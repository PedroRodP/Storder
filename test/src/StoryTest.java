import modelo.Story;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StoryTest {

    @Test
    public void testCrearStoryConTituloDescripcionYPuntos() {

        String titulo = "title";
        String descripcion = "description";
        int puntos = 5;
        Story story = new Story(titulo, descripcion, puntos);

        assertEquals(titulo, story.verTitulo());
        assertEquals(descripcion, story.verDescripcion());
        assertEquals(puntos, story.verPuntos());
    }

    @Test
    public void testModificarTituloCambiaTitulo() {

        String titulo1 = "title 1";
        String titulo2 = "title 2";
        Story story = new Story(titulo1, "descripcion", 5);

        story.modificarTitulo(titulo2);

        assertEquals(titulo2, story.verTitulo());
    }

    @Test
    public void testModificarDescripcionCambiaDescripcion() {

        String descripcion1 = "desc 1";
        String descripcion2 = "desc 2";
        Story story = new Story("titulo", descripcion1, 5);

        story.modificarDescripcion(descripcion2);

        assertEquals(descripcion2, story.verDescripcion());
    }

    @Test
    public void testModificarPuntosCambiaPuntos() {

        int puntos1 = 3;
        int puntos2 = 5;
        Story story = new Story("titulo", "descripcion", puntos1);

        story.modificarPuntos(puntos2);

        assertEquals(puntos2, story.verPuntos());
    }
}
