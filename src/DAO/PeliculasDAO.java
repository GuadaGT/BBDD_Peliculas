package DAO;

import Models.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class PeliculasDAO
{
    //Establecemos la conexión con la BBDD una vez creada e importada la tabla
    public static Connection getConnection()
    {
        String url = "jdbc:mysql://localhost:3306/videoClub";
        String user = "root";
        String pass = "";

        try
        {
            return DriverManager.getConnection(url,user,pass);
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //agregarPelciula(Pelicula pelicula): Agrega una nueva película a la tabla de películas.
    public static void agregarPelicula(Pelicula pelicula)
    {
        try
        {
            Connection connection = getConnection();
            String sql = "INSERT INTO peliculas (titulo,genero,fecha_estreno) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Pasamos los parámetros que tenemos que incluir en la BBDD.
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setDate(3,new java.sql.Date(pelicula.getFecha_estreno().getTime()));

            //Ejecutamos la función executeUpdate dentro de un if para comprobar que sea correcto.
            if(ps.executeUpdate() >= 1)
            {
                System.out.println("Pelicula introducido correctamente en el sistema.");
            }
            else
            {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //actualizarPelicula(String titulo, Pelicula pelicula): Actualiza los datos de una película existente.
    public static void  actualizarPelicula(String titulo,Pelicula pelicula)
    {
        try
        {
            Connection con = getConnection();

            String sql = "UPDATE peliculas SET titulo = ?, genero = ?, fecha_estreno = ? WHERE titulo = ?";
            PreparedStatement ps1 = con.prepareStatement(sql);

            ps1.setString(1, pelicula.getTitulo());
            ps1.setString(2, pelicula.getGenero());
            ps1.setDate(3,new java.sql.Date(pelicula.getFecha_estreno().getTime()));

            //Parámetro por el cual vamos a buscar la película en la BBDD.
            ps1.setString(4,titulo);

            //Ejecutamos la función executeUpdate dentro de un if para comprobar que sea correcto y se haya modificado el coche.
            //Si se ha modificado al menos un campo será mayor o igual a 1.
            if(ps1.executeUpdate() >= 1)
            {
                System.out.println("Pelicula introducido correctamente en el sistema.");
            }
            else
            {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //eliminarPelicula(String titulo): Elimina una película de la tabla películas por su nombre.eliminarPelicula(String titulo): Elimina una película de la tabla películas por su nombre.
    public static void eliminarPelicula(String titulo)
    {
        try
        {
            Connection c = getConnection();
            String sql = "DELETE FROM peliculas WHERE titulo = ?";
            PreparedStatement preparedStatement = c.prepareStatement(sql);

            preparedStatement.setString(1,titulo);
            //Ejecutamos la función executeUpdate dentro de un if para comprobar que sea correcto y se haya modificado el coche.
            //Si se ha modificado al menos un campo será mayor o igual a 1.
            if(preparedStatement.executeUpdate() >= 1)
            {
                System.out.println("Pelicula introducido correctamente en el sistema.");
            }
            else
            {
                System.out.println("Ha ocurrido un error inesperado.");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException();
        }
    }

    //listarPeliculas(): Devuelve una lista de todas las películas de la tabla peliculas
    public ArrayList<Pelicula> getPelicula()
    {
        try
        {
            //Declaramos el Arraylist de películas que será el que almacene la información
            //que se devuelve en el main
            ArrayList<Pelicula> peliculas = new ArrayList<>();
            Connection connect = getConnection();

            //Declaramos el Statement para que nos acumule la información en un Resulset.
            Statement statement = connect.createStatement();
            String sql = "SELECT * FROM Peliculas";
            ResultSet resultSet = statement.executeQuery(sql);

            //Hacemos un bucle while para recorrerlo linea por linea mietras hayan lineas disponibles y guardarlo en
            //el ArrayList que hemos declarado.
            while(resultSet.next())
            {
                String titulo = resultSet.getString("titulo");
                String genero = resultSet.getString("genero");
                Date fecha_estreno = resultSet.getDate("fecha_estreno");

                //Creamos el objeto con los atributos.
                Pelicula p = new Pelicula(titulo,genero,fecha_estreno, "La jungla de cristal");
                peliculas.add(p);
            }
            return peliculas;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

}
