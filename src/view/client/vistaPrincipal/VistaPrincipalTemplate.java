package view.client.vistaPrincipal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.services.ObjGraficosService;
import view.services.RecursosService;

/**
 *
 * @author AndresFWilT
 */
public class VistaPrincipalTemplate extends JFrame {

    private static final long serialVersionUID = 8914150529633029064L;

    //Declaracion de objetos graficos
    private JPanel panel;
    private JLabel lTituloEmpresa;
    private JButton bInsertar, bModificar, bRetirar, bMostrar;

    //Declaracion de objetos decoradores
    //Declaracion de servicios
    private RecursosService sRecursos;
    private ObjGraficosService sObjGraficos;
    private VistaPrincipalComponent vistaPrincipalComponent;

    public VistaPrincipalTemplate(VistaPrincipalComponent vistaPrincipalComponent) {
        //Declara inicio de la ventana
        super("Vista Principal");
        this.setResizable(false);
        //Se traen los componentes de la ventana
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        //Se implementan servicios
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        //Se crean los componentes graficos de la ventana
        this.crearJPanels();
        this.crearJLabels();
        this.crearJButtons();
        //Se termina de configurar la ventana
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public void crearJPanels() {
        panel = sObjGraficos.construirJPanel(0, 0, 1000, 500, sRecursos.getColorPrincipal(), null);
        this.add(panel);
    }

    private void crearJLabels() {
        lTituloEmpresa = sObjGraficos.construirJLabel("Te Reto A Programarlo S.A.S", 255, 15, 500, 30,
                null,null, sRecursos.getFontTPrincipal(),sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), null, "c");
        panel.add(lTituloEmpresa);
    }

    private void crearJButtons() {
        //Boton insertar
        bInsertar = sObjGraficos.construirJButton(
                "Insertar", 375, 100, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), sRecursos.getBAzul(), "c", true);
        bInsertar.addActionListener(vistaPrincipalComponent);
        panel.add(bInsertar);
        //Boton modificar
        bModificar = sObjGraficos.construirJButton(
                "Modificar", 375, 150, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), sRecursos.getBAzul(), "c", true);
        bModificar.addActionListener(vistaPrincipalComponent);
        panel.add(bModificar);
        //Boton retirar
        bRetirar = sObjGraficos.construirJButton("Retirar", 375, 200, 250, 45, sRecursos.getCMano(), null, sRecursos.getFontLigera(),
                sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), sRecursos.getBAzul(), "c", true);
        bRetirar.addActionListener(vistaPrincipalComponent);
        panel.add(bRetirar);
        //Boton mostrar
        bMostrar = sObjGraficos.construirJButton("Mostrar", 375, 250, 250, 45, sRecursos.getCMano(), null, sRecursos.getFontLigera(),
                sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), sRecursos.getBAzul(), "c", true);
        bMostrar.addActionListener(vistaPrincipalComponent);
        panel.add(bMostrar);
    }
    
    //getter
    
    public JPanel panel() {
        return this.panel;
    }

    public JButton getbInsertar() {
        return this.bInsertar;
    }

    public JButton getbModificar() {
        return this.bModificar;
    }

    public JButton getbRetirar() {
        return this.bRetirar;
    }

    public JButton getbMostrar() {
        return this.bMostrar;
    }

}
