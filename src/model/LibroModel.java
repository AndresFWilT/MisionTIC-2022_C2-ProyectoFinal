package model;

/**
 *
 * @author AndresFWilT
 */
public class LibroModel {

    String lib_id;
    String lib_resenia;
    String lib_anio;
    String lib_autor;

    public LibroModel(String lib_id, String lib_autor, String lib_resenia, String lib_anio) {
        this.lib_id = lib_id;
        this.lib_resenia = lib_resenia;
        this.lib_anio = lib_anio;
        this.lib_autor = lib_autor;
    }

    public String getLib_id() {
        return lib_id;
    }

    public String getLib_resenia() {
        return lib_resenia;
    }

    public String getLib_anio() {
        return lib_anio;
    }

    public String getLib_autor() {
        return lib_autor;
    }

    public Object[] toArray() {
        Object[] data = {lib_id, lib_resenia, lib_anio, lib_autor};
        return data;
    }
}
