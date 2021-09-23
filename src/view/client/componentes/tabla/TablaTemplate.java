package view.client.componentes.tabla;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import model.LibroModel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.plaf.basic.BasicScrollBarUI;
import view.services.RecursosService;

/**
 *
 * @author AndresFWilT
 */
public class TablaTemplate extends JPanel {

    private static final long SerialVersionUID = -8946942932242371111L;

    //Declaracion de variables
    List<LibroModel> libros;

    //Declaracion de servicio
    private RecursosService sRecursos;
    private TablaComponent tablaComponent;

    //Creacion de elementos graficos
    private JTable tabla;
    private JScrollPane scrollTabla;
    private String[] header = {"Libro ID", "Año", "Autor", "Reseña"};
    private DefaultTableModel modeloTabla;
    private Color colorFuente, colorOscuro;

    public TablaTemplate(TablaComponent tablaComponent, List<LibroModel> libros) {
        this.libros = libros;
        this.tablaComponent = tablaComponent;
        sRecursos = RecursosService.getService();
        this.crearTabla();
    }

    private void crearTabla() {
        String nombreFuente = "Saints Seriff";
        colorFuente = sRecursos.getColorSecundario();
        colorOscuro = sRecursos.getColorPrincipalOscuro();
        tabla = new JTable();
        tabla.setRowHeight(25);
        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JLabel celda = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                celda.setOpaque(true);
                celda.setFont(new Font(nombreFuente, Font.BOLD, 13));
                celda.setForeground(colorFuente);
                celda.setHorizontalAlignment(SwingConstants.CENTER);
                if (row % 2 != 0) {
                    celda.setBackground(sRecursos.getColorBlanco());
                } else {
                    celda.setBackground(sRecursos.getColorGrisClaro());
                }
                if (isSelected) {
                    celda.setBackground(sRecursos.getColorSecundario());
                    celda.setForeground(sRecursos.getColorPrincipal());
                }
                return celda;
            }
        });

        scrollTabla = new JScrollPane(tabla);
        scrollTabla.setLocation(50, 35);
        scrollTabla.setSize(900, 200);

        JPanel pCorner = new JPanel();
        pCorner.setBackground(sRecursos.getColorPrincipalOscuro());
        scrollTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);

        scrollTabla.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            private Dimension d = new Dimension();

            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                g.setColor(sRecursos.getColorBlanco());
                g.fillRect(r.x, r.y, r.width, r.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                JScrollBar sb = (JScrollBar) c;
                if (!sb.isEnabled()) {
                    return;
                } else if (isDragging) {
                    g2.setPaint(new Color(30, 30, 30));
                } else if (isThumbRollover()) {
                    g2.setPaint(sRecursos.getColorSecundario());
                } else {
                    g2.setPaint(sRecursos.getColorSecundario());
                }

                if (r.width < r.height) {
                    g2.fillRoundRect((r.width - 7) / 2, r.y, 7, r.height, 10, 10);
                } else {
                    g2.fillRoundRect(r.x, (r.height - 7) / 2, r.width, 7, 10, 10);
                }
            }
        });

        this.add(scrollTabla);

        agregarDatosATabla(libros);

        this.setSize(1000, 350);
        this.setLayout(null);
        this.setBackground(sRecursos.getColorPrincipalOscuro());
        this.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(46, 46, 46)),
                        "Registro de libros", SwingConstants.LEFT, 0, new Font(nombreFuente, Font.PLAIN, 17), sRecursos.getColorPrincipal()));
    }

    private void agregarDatosATabla(List<LibroModel> libros) {
        tabla.removeAll();
        modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(header);
        this.tabla.setModel(modeloTabla);
        for (int i = 0; i < libros.size(); i++) {
            modeloTabla.addRow(libros.get(i).toArray());
        }
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public String getCeldaSeleccionada() {
        try{
            return String.valueOf(tabla.getValueAt(tabla.getSelectedRow(), 0));
        }catch(ArrayIndexOutOfBoundsException ignored){
            return null;
        }
    }

}
