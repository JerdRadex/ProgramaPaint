/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Paint;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PanelDibujo extends JPanel {

    private GUIMiFigura2D figuras [];    //almacena todas las figuras que se dibujan
    private int cuentaFiguras;      //cuenta el numero de figuras en el arreglo
    private int tipoFigura;         //Determine el tipo de figura a dibujar
    private GUIMiFigura2D figuraActual;  //representa figura actual que se esta
                                    //dibujando
    private Paint colorActual1;      //representa el color del dibujo actual
    private Paint colorActual2;
    private boolean figuraRellena;  //determina si se dibuja una figura rellena
    private boolean usoGradiente;
    private float trazoActual;   
    private float longGuion;
    private JLabel etiquetaEstado;  //representa la barra de estado representa
                                    //coordenadas de la posición actual del
                                    //raton
    private boolean usoGuiones;
   
    //private JPanel panelDibujo;
    private int posicionX;
    private int posicionY;
    private int posicionX1;
    private int posicionY1;
    private int posicionX2;
    private int posicionY2;
   
    public PanelDibujo (JLabel etiqueta){
       
        //panelDibujo = new JPanel ();
       
        etiquetaEstado = etiqueta;
        figuras = new GUIMiFigura2D [100];
        cuentaFiguras = 0;
        tipoFigura = 0;
        establecerTipoFigura (new MiLinea2D ());
        figuraActual = null;
        colorActual1 = Color.BLACK;
        colorActual1 = Color.BLUE;
        figuraRellena = false;
        usoGradiente = false;
        this.setBackground(Color.WHITE);
       
        ManejadorRaton manejador = new ManejadorRaton ();
        this.addMouseListener (manejador);
        this.addMouseMotionListener (manejador);
    }
   
    private class ManejadorRaton extends MouseAdapter
            implements MouseMotionListener {
        //maneja el evento cuando se oprime el raton
        public void mousePressed (MouseEvent evento){
            switch (tipoFigura){
                case 0:
                    figuraActual = new MiLinea2D ();
                    break;
                case 1:
                    figuraActual = new MiRectangulo2D ();
                    break;
                case 2:
                    figuraActual = new MiOvalo2D ();
                    break;
                default:
                    break;
            }
            posicionX1 = evento.getX ();
            posicionY1 = evento.getY ();
        }
       
        //manejo evento cuando se suelta el boton del raton despues de
        //arrastrarlo
        public void mouseReleased (MouseEvent evento){
            posicionX2 = evento.getX ();
            posicionY2 = evento.getY ();
            if (figuraActual instanceof MiLinea2D){
                figuras [cuentaFiguras] = new MiLinea2D (posicionX1, posicionY1,
                        posicionX2, posicionY2, colorActual1, trazoActual,
                        usoGuiones, longGuion);
                repaint ();
            }else if (figuraActual instanceof MiRectangulo2D){
                figuras [cuentaFiguras] = new MiRectangulo2D (posicionX1,
                        posicionY1, posicionX2, posicionY2, colorActual1,
                        colorActual2, figuraRellena, trazoActual, usoGradiente);
                repaint ();
            }else{
                figuras [cuentaFiguras] = new MiOvalo2D (posicionX1, posicionY1,
                        posicionX2, posicionY2, colorActual1, colorActual2,
                        figuraRellena, trazoActual, usoGradiente);
                repaint ();
            }
            figuraActual = null;
            cuentaFiguras++;
        }
       
        //maneja evento cuando el usuario mueve el raton
        public void mouseMoved (MouseEvent evento){
            etiquetaEstado.setText (String.format ("(%d, %d)",
                    evento.getX(), evento.getY ()));
        }
       
        //el evento cuando el usuario arrastra el raton con el boton oprimido
        public void mouseDragged (MouseEvent evento){
            posicionX = evento.getX ();
            posicionY = evento.getY ();
            if (figuraActual instanceof MiLinea2D){
                figuras [cuentaFiguras] = new MiLinea2D (posicionX1, posicionY1,
                        posicionX, posicionY, colorActual1, trazoActual,
                        usoGuiones, longGuion);
                repaint ();
            }else if (figuraActual instanceof MiRectangulo2D){
                figuras [cuentaFiguras] = new MiRectangulo2D (posicionX1,
                        posicionY1, posicionX, posicionY, colorActual1,
                        colorActual2, figuraRellena, trazoActual, usoGradiente);
                repaint ();
            }else{
                figuras [cuentaFiguras] = new MiOvalo2D (posicionX1, posicionY1,
                        posicionX, posicionY, colorActual1, colorActual2,
                        figuraRellena, trazoActual, usoGradiente);
                repaint ();
            }
            etiquetaEstado.setText (String.format ("(%d, %d)",
                    evento.getX(), evento.getY ()));
        }
    }
   
    public void paintComponent (Graphics g){
        super.paintComponent (g);
       
        Graphics2D g2d = (Graphics2D) g;
       
        System.out.println ("A Pintar");
        for (int count = 0; count < cuentaFiguras + 1; count++){
            if (figuras [count] != null)
                figuras [count].dibujar(g2d);
            else
                ;
        }
    }
   
    //establece el tipo de figura a dibujar
    public void establecerTipoFigura (GUIMiFigura2D figura){
        if (figura instanceof MiLinea2D){
            tipoFigura = 0;
        }else if (figura instanceof MiRectangulo2D){
            tipoFigura = 1;
        }else {
            tipoFigura = 2;
        }
    }
   
    //se establece el primer color a usar
    public void establecerColorActual1 (Paint color){
        colorActual1 = color;
    }
   
    //Se establece el segundo color a usar
    public void establecerColorActual2 (Paint color){
        colorActual2 = color;
    }
   
    //Se establece si se dibuja con relleno la figura o no
    public void establecerFiguraRellena (boolean rellena){
        figuraRellena = rellena;
    }
   
    //Establece el trazo actual de la figura
    public void establecerTrazoActual (float trazo){
        trazoActual = trazo;
    }
   
    //se establece la longitud de los guiones
    public void establecerLongGuioin (float longitud){
        longGuion = longitud;
    }
   
    //Establece si se usan guiones para dibujar la línea
    public void establecerUsoGuiones (boolean guiones){
        usoGuiones = guiones;
    }
   
    //se establece si se dibuja con gradiente la figura o no
    public void establecerUsoGradiente (boolean gradiente){
        usoGradiente = gradiente;
    }
   
    //método para borrar la última figura que se dibujo
    public void borrarUltimaFigura (){
        cuentaFiguras--;
        if (cuentaFiguras < 0){
            cuentaFiguras = 0;
            repaint ();
        }else
            repaint ();
    }
   
    //método para borrar todos los dibujos que se dibujaron
    public void borrarDibujo (){
        cuentaFiguras = 0;
        repaint ();
    }   
   
    public JPanel obtenerPanelDibujo (){
        return this;
    }
}