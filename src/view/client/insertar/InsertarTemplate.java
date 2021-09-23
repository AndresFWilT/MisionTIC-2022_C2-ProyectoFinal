package view.client.insertar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import view.services.ObjGraficosService;
import view.services.RecursosService;

/**
 *
 * @author AndresFWilT
 */
public class InsertarTemplate extends JFrame {

    private static final long serialVersionUID = 8914150529633029064L;

    //declaracion de servicios
    private RecursosService sRecursos;
    private ObjGraficosService sObjGraficos;
    private InsertarComponent insertarComponent;

    //declaracion de elementos graficos
    private JPanel panel;
    private JButton bVolver, bInsertar;
    private JLabel lTitulo, lLibroID, lResenia, lAnio, lAutorID;
    private JTextField tLibroID, tResenia, tAnio, tAutorID;

    public InsertarTemplate(InsertarComponent insertarComponent) {
        //Creacion inicial de la vista insertar
        super("Insertar datos");
        this.setResizable(false);
        //implementacion de servicios
        this.insertarComponent = insertarComponent;
        sRecursos = RecursosService.getService();
        sObjGraficos = ObjGraficosService.getService();
        //Creacion de los componentes basicos
        crearJPanels();
        crearJButtons();
        crearJLabels();
        crearTextFields();
        //Configuracion final de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLayout(null);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void crearJPanels() {
        panel = sObjGraficos.construirJPanel(0, 0, 1000, 500, sRecursos.getColorPrincipalOscuro(), null);
        this.add(panel);
    }

    private void crearJButtons() {
        //Boton insertar
        bInsertar = sObjGraficos.construirJButton(
                "Insertar", 400, 310, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bInsertar.addActionListener(insertarComponent);
        panel.add(bInsertar);
        //Boton volver
        bVolver = sObjGraficos.construirJButton(
                "Volver", 400, 375, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bVolver.addActionListener(insertarComponent);
        panel.add(bVolver);
    }

    private void crearJLabels() {
        //Titulo de la ventana
        lTitulo = sObjGraficos.construirJLabel("Insertar un libro", 255, 15, 500, 30,
                null,null, sRecursos.getFontTPrincipal(),sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lTitulo);
        //Titulo de libro ID
        lLibroID = sObjGraficos.construirJLabel("Libro ID:", 295, 75, 50, 20,
                null,null, sRecursos.getFontLigera(),sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lLibroID);
        //Titulo de año
        lAnio = sObjGraficos.construirJLabel("Año:", 425, 75, 50, 20,
                null,null, sRecursos.getFontLigera(),sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lAnio);
        //Titulo autor ID
        lAutorID = sObjGraficos.construirJLabel("Autor ID:", 535, 75, 55, 20,
                null,null, sRecursos.getFontLigera(),sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lAutorID);
        //Titulo reseña
        lResenia = sObjGraficos.construirJLabel("Reseña", 480, 110, 55, 20,
                null,null, sRecursos.getFontLigera(),sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lResenia);
    }

    private void crearTextFields() {
        //TextField libro ID
        tLibroID = sObjGraficos.construirJTextField(
                "", 370, 75, 50, 20,
                sRecursos.getFontSubtitulo(),sRecursos.getColorBlanco(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorBlanco(),
                sRecursos.getBClaro(), "c"
        );
        panel.add(tLibroID);
        //TextField Año
        tAnio = sObjGraficos.construirJTextField(
                "", 480, 75, 50, 20,
                sRecursos.getFontSubtitulo(),sRecursos.getColorBlanco(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorBlanco(),
                sRecursos.getBClaro(), "c"
        );
        panel.add(tAnio);
        //TextField ID Autor
        tAutorID = sObjGraficos.construirJTextField(
                "", 590, 75, 50, 20,
                sRecursos.getFontSubtitulo(),sRecursos.getColorBlanco(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorBlanco(),
                sRecursos.getBClaro(), "c"
        );
        panel.add(tAutorID);
        //TextField Reseña
        tResenia = sObjGraficos.construirJTextField(
                "", 200, 140, 600, 150,
                sRecursos.getFontSubtitulo(),sRecursos.getColorBlanco(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorBlanco(),
                sRecursos.getBClaro(), "c"
        );
        panel.add(tResenia);
    }
    
    public void setAllClear(){
        tAutorID.setText("");
        tResenia.setText("");
        tAnio.setText("");
        tLibroID.setText("");
    }
    
    //Funcion mostrar 
    public void setMensaje(String informacion, String titulo, int tipos) {
        JOptionPane.showMessageDialog(getContentPane(), informacion, titulo, tipos);
    }

    //Getters
    public JButton getbVolver() {
        return bVolver;
    }

    public JButton getbInsertar() {
        return bInsertar;
    }

    public JTextField getTLibroID() {
        return tLibroID;
    }

    public JTextField getTAutorID() {
        return tAutorID;
    }

    public JTextField getTResenia() {
        return tResenia;
    }

    public JTextField getTAnio() {
        return tAnio;
    }

}
