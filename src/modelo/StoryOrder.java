package modelo;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Iterator;
import java.util.LinkedList;

public class StoryOrder {

    private static StoryOrder storder;
    private LinkedList<Story> stories;
    private Iterator<Story> iterator;

    private StoryOrder() {
        stories = new LinkedList<>();
        iterator = stories.iterator();
    }

    public static StoryOrder instanciar() {
        if (storder == null) {
            storder = new StoryOrder();
        }
        return storder;
    }

    public void insertarStory(Story story) {
        stories.add(story);
    }

    public void insertarStory(Story story, int pos) {
        desplazarStoriesDesde(pos);
        stories.set(pos + 1, story);
    }

    private void desplazarStoriesDesde(int pos) {
        if ((! stories.isEmpty()) && stories.size() >= pos) {
            LinkedList<Story> aux = new LinkedList<>();
            for (int i = (pos + 1); i < stories.size(); i++) {
                aux.add(stories.remove(pos));
            }
            //Guardo un null para reservar la posicion
            stories.set(pos + 1, null);
            stories.addAll(aux);
        }
    }

    public void borrarStory(String titulo) {
        Iterator<Story> it = stories.iterator();
        while (it.hasNext()) {
            Story story = it.next();
            if (story.verTitulo() == titulo) {
                stories.remove(story);
                return;
            }
        }
    }

    public LinkedList<Story> verStoryOrder() {
        return (LinkedList<Story>) stories.clone();
    }

    public Story buscarStoryPorTitulo(String tituloBuscado) throws NotFound {
        Iterator<Story> it = stories.iterator();
        while (it.hasNext()) {
            Story story = it.next();
            if (story.verTitulo() == tituloBuscado) {
                return story;
            }
        }
        throw new NotFound();
    }

}
