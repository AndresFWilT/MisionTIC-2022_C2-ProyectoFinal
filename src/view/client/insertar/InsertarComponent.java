package view.client.insertar;

import access.LibroDAO;
import controller.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.LibroModel;
import view.client.vistaPrincipal.VistaPrincipalComponent;

/**
 *
 * @author AndresFWilT
 */
public class InsertarComponent implements ActionListener {

    private InsertarTemplate insertarTemplate;

    //Declaracion de controlador
    private Controlador controlador;

    //Declaracion de modelo
    private LibroModel modelo;
            
    //Declaracion de componentes
    private VistaPrincipalComponent vistaPrincipalComponent;

    public InsertarComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        insertarTemplate = new InsertarTemplate(this);
        this.vistaPrincipalComponent = vistaPrincipalComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == insertarTemplate.getbInsertar()) {
            controlador = new Controlador("insertar");
            if (controlador.getControlIn(insertarTemplate.getTLibroID().getText(), insertarTemplate.getTAutorID().getText(), insertarTemplate.getTResenia().getText(), insertarTemplate.getTAnio().getText())) {
                modelo = new LibroModel(insertarTemplate.getTLibroID().getText(), insertarTemplate.getTAutorID().getText(), insertarTemplate.getTResenia().getText(), insertarTemplate.getTAnio().getText());
                //Declaracion de Acceso
                LibroDAO acceso = new LibroDAO();
                if(acceso.insertLibro(modelo)){
                    insertarTemplate.setMensaje("Datos ingresados correctamente", "¡Atencion!", 1);
                }else{
                    insertarTemplate.setAllClear();
                    insertarTemplate.setMensaje("Verifique que haya diligenciado datos validos", "¡Atencion!", 0);
                }
            } else {
                insertarTemplate.setAllClear();
                insertarTemplate.setMensaje("Verifique que haya ingresado todos los datos", "¡Atencion!", 0);
            }
        } else if (e.getSource() == insertarTemplate.getbVolver()) {
            vistaPrincipalComponent.getVistaPrincipalTemplate().setVisible(true);
            insertarTemplate.setVisible(false);
        }
    }
    
    public InsertarTemplate getInsertarTemplate() {
        return insertarTemplate;
    }
}
