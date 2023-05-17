
import DAO.PeliculasDAO;
import Models.Pelicula;

import java.util.ArrayList;
import java.util.Date;

public class
Main {

    public static void main(String[] args) {

        PeliculasDAO peliculasDAO = new PeliculasDAO();

        Date fecha1 = new Date(2023-04-05);
        Date fecha2 = new Date(1992-12-01);
        Date fecha3 = new Date(1997-06-12);
        Pelicula pelicula1 = new Pelicula("Los geniales niños que comen chocolate","Aventura",fecha3) ;

        Pelicula pelicula2 = new Pelicula ("La caja Mágica", "Accion",fecha2);


        //AgregarPelicula.
        peliculasDAO.agregarPelicula(new Pelicula("D&D Honor entre Ladrones","Aventuras",fecha1, "La jungla de cristal"));
        peliculasDAO.agregarPelicula(new Pelicula("Pesadilla antes de navidad","Animacion",fecha2, "La jungla de cristal"));


        //ActualizarPelicula.
        peliculasDAO.actualizarPelicula(pelicula1.getTitulo(),pelicula2);


        //EliminarPelicula.
        peliculasDAO.eliminarPelicula("La jungla de cristal");

        ArrayList<Pelicula> peliculas = peliculasDAO.getPelicula();
        //ListarPelicula.
        peliculasDAO.getPelicula();
        for (Pelicula p: peliculas)
        {
            System.out.println(p);
        }




    }
}
