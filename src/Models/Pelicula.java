package Models;

import java.util.Date;

public class Pelicula
{
    private String titulo;
    private String genero;
    private Date fecha_estreno;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public Pelicula(String s, String aventura, Date fecha3) {
    }

    public Pelicula(String titulo, String genero, Date fecha_estreno, String la_jungla_de_cristal) {
        this.titulo = titulo;
        this.genero = genero;
        this.fecha_estreno = fecha_estreno;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", fecha_estreno=" + fecha_estreno +
                '}';
    }
}
