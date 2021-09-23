package view.client.vistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.client.insertar.InsertarComponent;
import view.client.modificar.ModificarComponent;
import view.client.mostrar.MostrarComponent;
import view.client.retirar.RetirarComponent;

/**
 *
 * @author AndresFWilT
 */
public class VistaPrincipalComponent implements ActionListener {

    //declaramos objetos de las vistas y template a relacionar
    private VistaPrincipalTemplate vistaPrincipalTemplate;
    private InsertarComponent insertar;
    private ModificarComponent modificar;
    private RetirarComponent retirar;
    private MostrarComponent mostrar;

    //Constructor
    public VistaPrincipalComponent() {
        this.vistaPrincipalTemplate = new VistaPrincipalTemplate(this);
        vistaPrincipalTemplate.setName("Vista Principal");
    }

    //Action Performed de los botones
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipalTemplate.getbInsertar()) {
            insertar = new InsertarComponent(this);
            vistaPrincipalTemplate.setVisible(false);
        } else if (e.getSource() == vistaPrincipalTemplate.getbModificar()) {
            modificar = new ModificarComponent(this);
            vistaPrincipalTemplate.setVisible(false);
        } else if (e.getSource() == vistaPrincipalTemplate.getbRetirar()) {
            retirar = new RetirarComponent(this);
            vistaPrincipalTemplate.setVisible(false);
        } else if (e.getSource() == vistaPrincipalTemplate.getbMostrar()) {
            mostrar = new MostrarComponent(this);
            vistaPrincipalTemplate.setVisible(false);
        }
    }

    //getter de la vista
    public VistaPrincipalTemplate getVistaPrincipalTemplate() {
        return this.vistaPrincipalTemplate;
    }
}
