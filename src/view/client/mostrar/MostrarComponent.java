/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.client.mostrar;

import access.LibroDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LibroModel;
import view.client.componentes.tabla.TablaComponent;
import view.client.vistaPrincipal.VistaPrincipalComponent;

/**
 *
 * @author AndresFWilT
 */
public class MostrarComponent implements ActionListener{

    private MostrarTemplate mostrarTemplate;
    
    private TablaComponent tablaComponent;
    
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    public MostrarComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        mostrarTemplate = new MostrarTemplate(this);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mostrarTemplate.getBMostrar()) {
            LibroDAO acceso = new LibroDAO();
            if(!acceso.getAllLibros().equals(null)){
                tablaComponent = new TablaComponent(acceso.getAllLibros());
                mostrarTemplate.getPanelTabla().add(tablaComponent.getTablaTemplate());
            }else{
                mostrarTemplate.setMensaje("No se pudo mostrar la tabla","¡Atencion!",0);
            }
        } else if (e.getSource() == mostrarTemplate.getBVolver()) {
            vistaPrincipalComponent.getVistaPrincipalTemplate().setVisible(true);
            mostrarTemplate.setVisible(false);
        }
    }
    
    public MostrarTemplate getInsertarTemplate() {
        return mostrarTemplate;
    }
}