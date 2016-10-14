/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout; 

public class MarcoDibujo extends JFrame {
    
    private JButton deshacerFigura; //Deshace la ultima figura que se haya 
                                    //dibujado
    private JButton borrarFiguras;  //Borra todas las figuras del dibujo
    private JComboBox coloresPreferidos;    //13 colores preferidos
    private JComboBox figuraDibujar;        //selecciona figura a dibujar
    private JCheckBox figuraRellena; //selecciona si la figura estara rellena o 
                                     //no
    private JLabel barraEstado;
    
    private final String nombreColores [] = {"Negro", "Rojo", "Azul", "Rosado", 
        "Amarillo", "Verde", "Naranja", "Celeste", "Morado", "Plomo", "Cyan",
        "Marron", "Blano"};
    
    private final String nombreFigura [] = {"Linea", "Rectangulo", "Ovalo"};
    private JPanel panelHerramientas;
    
    private Color colores [] = {Color.BLACK, Color.RED, Color.BLUE, 
        Color.PINK, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.lightGray,
        Color.MAGENTA, Color.GRAY, Color.CYAN, Color.darkGray, Color.WHITE};
    
    private MiFigura figura [] = {new MiLinea (), new MiRectangulo (), 
            new MiOvalo ()};
    
    private PanelDibujo dibujo;
    
    public MarcoDibujo (){
        super ("Java Drawings");
        
        barraEstado = new JLabel ("(0, 0)");
        dibujo = new PanelDibujo (barraEstado);
        
        panelHerramientas = new JPanel ();
        panelHerramientas.setLayout (new GridLayout (1, 5));
                
        deshacerFigura = new JButton ("Deshacer Figura");
        deshacerFigura.addActionListener (
            new ActionListener (){
                public void actionPerformed (ActionEvent evento){
                    dibujo.borrarUltimaFigura();
                }
            }
        );
        
        borrarFiguras = new JButton ("Borrar Figuras");
        borrarFiguras.addActionListener (
            new ActionListener (){
                public void actionPerformed (ActionEvent evento){
                    dibujo.borrarDibujo();
                }
            }
        );
        
        coloresPreferidos = new JComboBox (nombreColores);
        coloresPreferidos.addItemListener (
            new ItemListener (){
                public void itemStateChanged (ItemEvent evento){
                    if (evento.getStateChange () == ItemEvent.SELECTED){
                        dibujo.establecerColorActual 
                            (colores [coloresPreferidos.getSelectedIndex()]);
                    }
                }
            }
        );
        
        figuraDibujar = new JComboBox (nombreFigura);
        figuraDibujar.addItemListener (
            new ItemListener (){
                public void itemStateChanged (ItemEvent evento){
                    if (evento.getStateChange () == ItemEvent.SELECTED){
                        dibujo.establecerTipoFigura (
                            figura [figuraDibujar.getSelectedIndex ()]);
                    }   
                }
            }
        );
        
        figuraRellena = new JCheckBox ("Relleno / Sin Relleno");
        figuraRellena.addItemListener (
            new ItemListener (){
                public void itemStateChanged (ItemEvent evento){
                    dibujo.establecerFiguraRellena
                            (figuraRellena.isSelected ());
                }
            }
        );
        
        panelHerramientas.add (deshacerFigura);
        panelHerramientas.add (borrarFiguras);
        panelHerramientas.add (coloresPreferidos);
        panelHerramientas.add (figuraDibujar);
        panelHerramientas.add (figuraRellena);
        
        add (panelHerramientas, BorderLayout.NORTH);
        add (dibujo.obtenerPanelDibujo(), BorderLayout.CENTER);
        add (barraEstado, BorderLayout.SOUTH);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);        
        setSize (1000, 400);
        setVisible (true);
    }
}