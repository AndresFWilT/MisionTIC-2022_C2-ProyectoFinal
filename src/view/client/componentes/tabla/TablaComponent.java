package view.client.componentes.tabla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.LibroModel;

/**
 *
 * @author AndresFWilT
 */
public class TablaComponent {

    private List<LibroModel> libros;

    private TablaTemplate tablaTemplate;

    public TablaComponent(List<LibroModel> libros) {
        this.libros = libros;
        tablaTemplate = new TablaTemplate(this, this.libros);
    }

    public TablaTemplate getTablaTemplate() {
        return tablaTemplate;
    }

}
