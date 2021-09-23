/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.client.retirar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import view.services.ObjGraficosService;
import view.services.RecursosService;

/**
 *
 * @author AndresFWilT
 */
public class RetirarTemplate extends JFrame{
    
    private static final long serialVersionUID = 8914150529633029064L;

    //declaracion de servicios
    private RecursosService sRecursos;
    private ObjGraficosService sObjGraficos;
    private RetirarComponent retirarComponent;
    
    //declaracion componentes graficos
    private JPanel panel,panelTabla;
    private JLabel lTitulo,lInfo;
    private JButton bRetirar,bVolver,bMostrar;
    
    RetirarTemplate(RetirarComponent retirarComponent) {
        //Creacion inicial de la vista insertar
        super("Insertar datos");
        this.setResizable(false);
        //implementacion de servicios
        this.retirarComponent = retirarComponent;
        sRecursos = RecursosService.getService();
        sObjGraficos = ObjGraficosService.getService();
        //Creacion componentes de la ventana
        this.crearJPanels();
        this.crearJLabels();
        this.crearJButtons();
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

    private void crearJLabels() {
        //Titulo de la ventana
        lTitulo = sObjGraficos.construirJLabel("Eliminar", 255, 5, 500, 30,
                null,null, sRecursos.getFontTPrincipal(),sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lTitulo);
        //Titulo de libro ID
        lInfo = sObjGraficos.construirJLabel("Seleccione una fila de la tabla, luego oprima el boton retirar", 0, 445, 350, 20,
                null,null, sRecursos.getFontLigera(),sRecursos.getColorPrincipalOscuro(), sRecursos.getColorPrincipal(), null, "c");
        panel.add(lInfo);
    }

    private void crearJButtons() {
        //Boton Mostrar
        bMostrar = sObjGraficos.construirJButton(
                "Mostrar datos", 375, 35, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bMostrar.addActionListener(retirarComponent);
        panel.add(bMostrar);
        //Boton Retirar
        bRetirar = sObjGraficos.construirJButton(
                "Borrar", 505, 400, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bRetirar.addActionListener(retirarComponent);
        panel.add(bRetirar);
        bRetirar.setVisible(false);
        //Boton volver
        bVolver = sObjGraficos.construirJButton(
                "Volver", 250, 400, 250, 45, sRecursos.getCMano(),
                null, sRecursos.getFontLigera(), sRecursos.getColorPrincipal(), sRecursos.getColorPrincipalOscuro(), sRecursos.getBClaro(), "c", true);
        bVolver.addActionListener(retirarComponent);
        panel.add(bVolver);
    }
    
    //Funcion mostrar 
    public void setMensaje(String informacion, String titulo, int tipos) {
        JOptionPane.showMessageDialog(getContentPane(), informacion, titulo, tipos);
    }
    
    public JPanel panelTabla(){
        return panelTabla;
    }
    
    public JButton bRetirar(){
        return bRetirar;
    }
    
    public JButton bVolver(){
        return bVolver;
    }
    
    public JButton bMostrar(){
        return bMostrar;
    }

    public JPanel getPanelTabla() {
        return panelTabla;
    }
    
}
