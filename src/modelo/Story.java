package modelo;

public class Story {

    private String titulo;
    private String descripcion;
    private int puntos;

    public Story(String titulo, String descripcion, int puntos) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puntos = puntos;
    }

    public void modificarTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void modificarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void modificarPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String verTitulo() {
        return titulo;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public int verPuntos() {
        return puntos;
    }
}
