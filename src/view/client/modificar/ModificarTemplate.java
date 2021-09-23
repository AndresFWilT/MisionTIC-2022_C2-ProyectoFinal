package view.client.modificar;

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
public class ModificarTemplate extends JFrame {

    private static final long serialVersionUID = 8914150529633029364L;

    //declaracion de servicios
    private RecursosService sRecursos;
    private ObjGraficosService sObjGraficos;
    private ModificarComponent modificarComponent;

    //declaracion de elementos graficos
    private JPanel panel, panelTabla;
    private JButton bVolver, bModificar, bMostrar;
    private JLabel lTitulo, lResenia, lAnio, lAutorID;
    private JTextField tResenia, tAnio, tAutorID;

    public ModificarTemplate(ModificarComponent modificarComponent) {
        //Creacion inicial de la vista insertar
        super("Modificar datos");
        this.setResizable(false);
        //implementacion de servicios
        this.modificarComponent = modificarComponent;
        sRecursos = RecursosService.getService();
        sObjGraficos = ObjGraficosService.getService();
        //Creacion de los componentes basicos
        crearJPanels();
        crearJButtons();
        crearJLabels();
        crearTextFields();
        //Configuracion final de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1250, 720);
        setLayout(null);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    private void crearJPanels() {
        panel = sObjGraficos.construirJPanel(0, 0, 1250, 720, sRecursos.getColorPrincipalOscuro(), null);
        this.add(panel);
        panelTabla = sObjGraficos.construirJPanel(125, 250, 950, 250, sRecursos.getColorPrincipalOscuro(), null);
        panel.add(panelTabla);
    }

    private void crearJButtons() {
        //Boton Mostrar
        bMostrar = sObjGraficos.construirJButton(
                "Mostrar datos", 825, 10, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bMostrar.addActionListener(modificarComponent);
        panel.add(bMostrar);
        //Boton Retirar
        bModificar = sObjGraficos.construirJButton(
                "Modificar", 505, 175, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bModificar.addActionListener(modificarComponent);
        panel.add(bModificar);
        bModificar.setVisible(false);
        //Boton volver
        bVolver = sObjGraficos.construirJButton(
                "Volver", 500, 600, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bVolver.addActionListener(modificarComponent);
        panel.add(bVolver);
    }

    private void crearJLabels() {
        //Titulo de la ventana
        lTitulo = sObjGraficos.construirJLabel("Modificar un libro", 255, 15, 725, 30,
                null, null, sRecursos.getFontTPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lTitulo);
        //Titulo de año
        lAnio = sObjGraficos.construirJLabel("Año:", 125, 80, 50, 20,
                null, null, sRecursos.getFontLigera(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lAnio);
        //Titulo autor ID
        lAutorID = sObjGraficos.construirJLabel("Autor ID:", 125, 135, 55, 20,
                null, null, sRecursos.getFontLigera(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lAutorID);
        //Titulo reseña
        lResenia = sObjGraficos.construirJLabel("Reseña", 275, 105, 55, 20,
                null, null, sRecursos.getFontLigera(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lResenia);
    }

    private void crearTextFields() {
        //TextField Año
        tAnio = sObjGraficos.construirJTextField(
                "", 180, 80, 75, 20,
                sRecursos.getFontSubtitulo(), sRecursos.getColorBlanco(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorBlanco(),
                sRecursos.getBClaro(), "c"
        );
        panel.add(tAnio);
        //TextField ID Autor
        tAutorID = sObjGraficos.construirJTextField(
                "", 180, 135, 75, 20,
                sRecursos.getFontSubtitulo(), sRecursos.getColorBlanco(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorBlanco(),
                sRecursos.getBClaro(), "c"
        );
        panel.add(tAutorID);
        //TextField Reseña
        tResenia = sObjGraficos.construirJTextField(
                "", 350, 75, 725, 75,
                sRecursos.getFontSubtitulo(), sRecursos.getColorBlanco(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorBlanco(),
                sRecursos.getBClaro(), "c"
        );
        panel.add(tResenia);
    }

    //Funcion mostrar 
    public void setMensaje(String informacion, String titulo, int tipos) {
        JOptionPane.showMessageDialog(getContentPane(), informacion, titulo, tipos);
    }

    public void setAllClear() {
        tAutorID.setText("");
        tResenia.setText("");
        tAnio.setText("");
    }

    //getters
    public JButton mostrar() {
        return bMostrar;
    }

    public JButton modificar() {
        return bModificar;
    }

    public JButton volver() {
        return bVolver;
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

    public JPanel getPanelTabla() {
        return panelTabla;
    }
}
