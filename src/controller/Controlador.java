package controller;

import access.LibroDAO;
import java.util.List;
import model.LibroModel;

/**
 *
 * @author AndresFWilT
 */
public class Controlador {

    private String comando;
    private List<LibroModel> libros;

    public Controlador(String comando) {
        this.comando = comando;
    }

    public boolean getControlIn(String libroID, String autorID, String resenia, String anio) {
        if (this.comando.equals("insertar")) {
            if (libroID.equals("") || libroID.equals(null) && autorID.equals("") || autorID.equals(null)
                    && resenia.equals("") || resenia.equals(null) && anio.equals("") || anio.equals(null)) {
                return false;
            } else if (!esNumerico(libroID) || !esNumerico(autorID) || !esNumerico(anio)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public boolean getControlBM(String celdaSeleccionada) {
        if (this.comando.equals("retirar") || this.comando.equals("modificar")) {
            if (!esNumerico(celdaSeleccionada) || celdaSeleccionada.equals("") || celdaSeleccionada.equals(null)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean esNumerico(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public boolean getControlMod(String autorID, String resenia, String anio) {
        if (this.comando.equals("modificar")) {
            if(!autorID.equals("")){
                return true;
            }else if(!resenia.equals("")){
                return true;
            }else if(!anio.equals("")){
                return true;
            }else if (!esNumerico(autorID) || !esNumerico(anio)) {
                return false;
            }
        } else {
            return false;
        }
        return false;
    }
    
    public List<LibroModel> getLibros() {
        return libros;
    }
}
