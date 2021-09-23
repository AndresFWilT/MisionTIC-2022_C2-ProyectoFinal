package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.LibroModel;
import utils.ConnectionBD;

/**
 *
 * @author AndresFWilT
 */
public class LibroDAO {

    private Connection conn = null;
    private LibroModel book;

    public LibroDAO() {

    }

    
    //Query para insertar
    public boolean insertLibro(LibroModel libro) {
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "INSERT INTO libro (lib_id, lib_resenia, lib_anio, lib_autor) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(libro.getLib_id()));
            statement.setString(2, libro.getLib_resenia());
            statement.setInt(3, Integer.parseInt((libro.getLib_anio())));
            statement.setString(4, libro.getLib_autor());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    //Query para modificar
    public boolean modificarLibro(LibroModel libro) {
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            //Update para solo anio
            if (libro.getLib_autor().equals("") && libro.getLib_resenia().equals("") && !libro.getLib_anio().equals("")) {
                String sql = "UPDATE libro SET lib_anio =?  WHERE lib_id=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt((libro.getLib_anio())));
                statement.setInt(2, Integer.parseInt(libro.getLib_id()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                //Update solo para autor
            } else if (libro.getLib_anio().equals("") && libro.getLib_resenia().equals("") && !libro.getLib_autor().equals("")) {
                String sql = "UPDATE libro SET lib_autor=?  WHERE lib_id=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, libro.getLib_autor());
                statement.setInt(2, Integer.parseInt(libro.getLib_id()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                //Update solo para reseña
            } else if (libro.getLib_anio().equals("") && libro.getLib_autor().equals("") && !libro.getLib_resenia().equals("")) {
                String sql = "UPDATE libro SET lib_resenia =?  WHERE lib_id=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, libro.getLib_resenia());
                statement.setInt(2, Integer.parseInt(libro.getLib_id()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                //Update solo para año y reseña
            } else if (libro.getLib_autor().equals("") && !libro.getLib_anio().equals("") && !libro.getLib_resenia().equals("")) {
                String sql = "UPDATE libro SET lib_resenia =?,lib_anio =?  WHERE lib_id=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, libro.getLib_resenia());
                statement.setInt(2, Integer.parseInt((libro.getLib_anio())));
                statement.setInt(3, Integer.parseInt(libro.getLib_id()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                //Update solo para año y autor
            } else if (libro.getLib_resenia().equals("") && !libro.getLib_anio().equals("") && !libro.getLib_autor().equals("")) {
                String sql = "UPDATE libro SET lib_anio =?, lib_autor =?  WHERE lib_id=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, Integer.parseInt((libro.getLib_anio())));
                statement.setString(2, libro.getLib_autor());
                statement.setInt(3, Integer.parseInt(libro.getLib_id()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
                //Update para todos
            } else if (!libro.getLib_resenia().equals("") && !libro.getLib_anio().equals("") && !libro.getLib_autor().equals("")) {
                String sql = "UPDATE libro SET lib_resenia =?,lib_anio =?,lib_autor=?  WHERE lib_id=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, libro.getLib_resenia());
                statement.setInt(2, Integer.parseInt((libro.getLib_anio())));
                statement.setString(3, libro.getLib_autor());
                statement.setInt(4, Integer.parseInt(libro.getLib_id()));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    //Query para borrar
    public boolean borrarLibro(int libro) {
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "DELETE FROM libro  WHERE lib_id=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, libro);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }
    
    //Mostrar libros
    public List<LibroModel> getAllLibros() {
        ArrayList<LibroModel> libros = new ArrayList<>();
        try {
            if (conn == null) {
                conn = ConnectionBD.getConnection();
            }
            String sql = "SELECT lib_id, lib_resenia,lib_anio,lib_autor FROM libro";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                book = new LibroModel(String.valueOf(result.getInt(1)), result.getString(2), String.valueOf(result.getInt(3)), String.valueOf(result.getInt(4)));
                libros.add(book);
            }
        } catch (SQLException ex) {

        }
        return libros;
    }
}
