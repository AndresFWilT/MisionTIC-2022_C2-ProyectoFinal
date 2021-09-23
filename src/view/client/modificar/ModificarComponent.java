package view.client.modificar;

import access.LibroDAO;
import controller.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LibroModel;
import view.client.componentes.tabla.TablaComponent;
import view.client.vistaPrincipal.VistaPrincipalComponent;

/**
 *
 * @author AndresFWilT
 */
public class ModificarComponent implements ActionListener {

    private ModificarTemplate modificarTemplate;

    //Declaracion de controlador
    private TablaComponent tablaComponent;
    private Controlador control;

    //Declaracion de modelo
    private LibroModel modelo;

    //Declaracion de componentes
    private VistaPrincipalComponent vistaPrincipalComponent;

    public ModificarComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        modificarTemplate = new ModificarTemplate(this);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        control = new Controlador("modificar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modificarTemplate.mostrar()) {
            LibroDAO acceso = new LibroDAO();
            if (!acceso.getAllLibros().equals(null)) {
                tablaComponent = new TablaComponent(acceso.getAllLibros());
                modificarTemplate.getPanelTabla().add(tablaComponent.getTablaTemplate());
                modificarTemplate.modificar().setVisible(true);
            } else {
                modificarTemplate.setMensaje("No se pudo mostrar la tabla, verifique la conexion con la BD", "Atencion", 0);
            }
        } else if (e.getSource() == modificarTemplate.modificar()) {
            LibroDAO acceso = new LibroDAO();
            if (control.getControlMod(modificarTemplate.getTAutorID().getText(), modificarTemplate.getTResenia().getText(), modificarTemplate.getTAnio().getText())) {
                if (control.getControlBM(tablaComponent.getTablaTemplate().getCeldaSeleccionada())) {
                    modelo = new LibroModel(tablaComponent.getTablaTemplate().getCeldaSeleccionada(), modificarTemplate.getTAutorID().getText(), modificarTemplate.getTResenia().getText(), modificarTemplate.getTAnio().getText());
                    if (acceso.modificarLibro(modelo)) {
                        modificarTemplate.setMensaje("¡Fila modificada con exito!", "Atencion", 1);
                    } else {
                        modificarTemplate.setMensaje("¡No se pudo modificar la fila!", "Atencion", 0);
                    }
                } else {
                    modificarTemplate.setMensaje("¡Seleccione una celda!", "Atencion", 0);
                }
            } else {
                modificarTemplate.setMensaje("Diligencia al menos un dato y verifica que sean validos", "Atencion", 0);
            }
        } else if (e.getSource() == modificarTemplate.volver()) {
            modificarTemplate.setVisible(false);
            vistaPrincipalComponent.getVistaPrincipalTemplate().setVisible(true);
        }
    }

    public ModificarTemplate getModificarTemplate() {
        return modificarTemplate;
    }

}
