package view.client.mostrar;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.services.ObjGraficosService;
import view.services.RecursosService;

/**
 *
 * @author AndresFWilT
 */
public class MostrarTemplate extends JFrame {

    private static final long serialVersionUID = 8914150529633029064L;

    //declaracion de servicios
    private RecursosService sRecursos;
    private ObjGraficosService sObjGraficos;
    private MostrarComponent mostrarComponent;

    //declaracion de elementos graficos
    private JPanel panel,panelTabla;
    private JButton bVolver, bMostrar;
    private JLabel lTitulo;

    public MostrarTemplate(MostrarComponent mostrarComponent) {
        //Creacion inicial de la vista insertar
        super("Mostrar datos");
        this.setResizable(false);
        //implementacion de servicios
        this.mostrarComponent = mostrarComponent;
        sRecursos = RecursosService.getService();
        sObjGraficos = ObjGraficosService.getService();
        //Creacion de los componentes basicos
        crearJPanels();
        crearJButtons();
        crearJLabels();
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
        panelTabla = sObjGraficos.construirJPanel(0, 100, 1000, 250, sRecursos.getColorPrincipalOscuro(),null);
        panel.add(panelTabla);
    }

    private void crearJButtons() {
        //Boton Mostrar
        bMostrar = sObjGraficos.construirJButton(
                "Mostrar datos", 375, 5, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bMostrar.addActionListener(mostrarComponent);
        panel.add(bMostrar);
        //Boton volver
        bVolver = sObjGraficos.construirJButton(
                "Volver", 375, 400, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bVolver.addActionListener(mostrarComponent);
        panel.add(bVolver);
    }
    
    private void crearJLabels() {
        //Titulo de la ventana
        lTitulo = sObjGraficos.construirJLabel("Mostrar datos", 0, 5, 500, 30,
                null,null, sRecursos.getFontTPrincipal(),sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lTitulo);
    }
    
    //Funcion mostrar 
    public void setMensaje(String informacion, String titulo, int tipos) {
        JOptionPane.showMessageDialog(getContentPane(), informacion, titulo, tipos);
    }
    
    //Getters
    public JButton getBVolver() {
        return bVolver;
    }

    public JButton getBMostrar() {
        return bMostrar;
    }
    
    public JPanel getPanelTabla() {
        return panelTabla;
    }

}
