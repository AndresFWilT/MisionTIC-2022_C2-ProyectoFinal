/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.client.retirar;

import access.LibroDAO;
import controller.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.client.componentes.tabla.TablaComponent;
import view.client.vistaPrincipal.VistaPrincipalComponent;

/**
 *
 * @author AndresFWilT
 */
public class RetirarComponent implements ActionListener {

    private RetirarTemplate retirarTemplate;

    private VistaPrincipalComponent vistaPrincipalComponent;
    private TablaComponent tablaComponent;
    private Controlador control;

    public RetirarComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        retirarTemplate = new RetirarTemplate(this);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        control = new Controlador("retirar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retirarTemplate.bMostrar()) {
            LibroDAO acceso = new LibroDAO();
            if (!acceso.getAllLibros().equals(null)) {
                tablaComponent = new TablaComponent(acceso.getAllLibros());
                retirarTemplate.getPanelTabla().add(tablaComponent.getTablaTemplate());
                retirarTemplate.bRetirar().setVisible(true);
            } else {
                retirarTemplate.setMensaje("No se pudo mostrar la tabla, verifique la conexion con la BD", "Atencion", 0);
            }
        } else if (e.getSource() == retirarTemplate.bRetirar()) {
            LibroDAO acceso = new LibroDAO();
            if (control.getControlBM(tablaComponent.getTablaTemplate().getCeldaSeleccionada())) {
                if(acceso.borrarLibro(Integer.parseInt(tablaComponent.getTablaTemplate().getCeldaSeleccionada()))){
                    retirarTemplate.setMensaje("¡Fila retirada con exito!", "Atencion", 1);
                    retirarTemplate.bRetirar().setVisible(true);
                }else{
                    retirarTemplate.setMensaje("¡No se pudo retirar la fila!", "Atencion", 0);
                }
            } else {
                retirarTemplate.setMensaje("Seleccione una celda valida", "Atencion", 0);
            }
        } else if (e.getSource() == retirarTemplate.bVolver()) {
            vistaPrincipalComponent.getVistaPrincipalTemplate().setVisible(true);
            retirarTemplate.setVisible(false);
        }
    }

    public RetirarTemplate getRetirarTemplate() {
        return retirarTemplate;
    }

}
