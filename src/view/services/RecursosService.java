/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.services;

/**
 *
 * @author AndresFWilT
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class RecursosService {

    private Color colorPrincipal, colorPrincipalOscuro, colorSecundario;
    private Color colorClaro,colorBlanco,colorNegro;
    private Font fontTPrincipal, fontTitulo, fontSubtitulo;
    private Font fontMediana, fontLigera;
    private Cursor cMano;
    private Border bInferiorAzul, bInferiorClaro, bClaro, bAzul;
    private ImageIcon iCerrar, iMinimizar;

    static private RecursosService servicio;

    private RecursosService() {
        this.crearColores();
        this.crearFuentes();
        this.crearCursores();
        this.crearBordes();
    }

    private void crearColores() {
        colorPrincipal = new Color(188, 194, 222);
        colorPrincipalOscuro = new Color(6, 15, 55);
        colorSecundario = new Color(100, 77, 187);
        colorClaro = new Color(191, 192, 219);
        colorBlanco = new Color(255,255,255);
        colorNegro = new Color(0,0,0);
    }

    private void crearFuentes() {
        fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
        fontTitulo = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
        fontSubtitulo = new Font("Forte", Font.PLAIN, 13);
        fontMediana = new Font("LuzSans-Book", Font.PLAIN, 15);
        fontLigera = new Font("LuzSans-Book", Font.PLAIN, 12);
    }

    private void crearCursores() {
        cMano = new Cursor(Cursor.HAND_CURSOR);
    }

    private void crearBordes() {
        bInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2, 0, colorSecundario);
        bInferiorClaro = BorderFactory.createMatteBorder(0, 0, 1, 0, colorClaro);
        bClaro = BorderFactory.createLineBorder(colorClaro, 2, true);
        bAzul = BorderFactory.createLineBorder(colorSecundario, 2, true);
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public Color getColorPrincipalOscuro() {
        return colorPrincipalOscuro;
    }

    public Border getBInferiorGris() {
        return bInferiorClaro;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }
    
    public Color getColorBlanco(){
        return colorBlanco;
    }
    
    public Color getColorNegro(){
        return colorNegro;
    }

    public Color getColorGrisClaro() {
        return colorClaro;
    }

    public Font getFontTPrincipal() {
        return fontTPrincipal;
    }

    public Font getFontTitulo() {
        return fontTitulo;
    }

    public Font getFontSubtitulo() {
        return fontSubtitulo;
    }

    public Font getFontMediana() {
        return fontMediana;
    }

    public Font getFontLigera() {
        return fontLigera;
    }

    public Cursor getCMano() {
        return cMano;
    }

    public Border getBInferiorAzul() {
        return bInferiorAzul;
    }
    
    public Border getBInferiorClaro(){
        return bInferiorClaro;
    }

    public Border getBClaro() {
        return bClaro;
    }

    public Border getBAzul() {
        return bAzul;
    }

    public ImageIcon getICerrar() {
        return iCerrar;
    }

    public ImageIcon getIMinimizar() {
        return iMinimizar;
    }

    public static RecursosService getService() {
        if (servicio == null) {
            servicio = new RecursosService();
        }
        return servicio;
    }

}
