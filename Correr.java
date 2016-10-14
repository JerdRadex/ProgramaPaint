/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;


import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Correr extends JFrame {
     private final JDesktopPane theDesktop;

   // set up GUI
   public Correr()
   {
      super("Using a JDesktopPane");

      JMenuBar bar = new JMenuBar(); 
      JMenu addMenu = new JMenu("Add"); 
      JMenuItem newGrados = new JMenuItem("Grados Simples");
      JMenuItem new1 = new JMenuItem("Grados Kevin");
      JMenuItem new2 = new JMenuItem("Evento Combobox");
      JMenuItem new3 = new JMenuItem("Listener");
      JMenuItem new4 = new JMenuItem("Juego");
      
      addMenu.add(newGrados); // add new frame item to Add menu
      addMenu.add(new1);
      addMenu.add(new2);
      addMenu.add(new3);
      addMenu.add(new4);
      bar.add(addMenu); // add Add menu to menu bar
      setJMenuBar(bar); // set menu bar for this application

      theDesktop = new JDesktopPane(); 
      add(theDesktop);
 newGrados.addActionListener(  
 new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              JInternalFrame frame = new JInternalFrame(
                  "Internal Frame", true, true, true, true);
              
             GradosSimples marcoEtiqueta=new GradosSimples();
        marcoEtiqueta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoEtiqueta.setSize(400,500);
        marcoEtiqueta.setVisible(true);
         theDesktop.add(frame); // attach internal frame
               frame.setVisible(true); // show internal frame
          }
     
 }
 
 );
  new1.addActionListener(  
 new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              JInternalFrame frame = new JInternalFrame(
                  "Internal Frame", true, true, true, true);
              
             ProgramaGrados marcoEtiqueta=new ProgramaGrados();
        marcoEtiqueta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoEtiqueta.setSize(400,500);
        marcoEtiqueta.setVisible(true);
         theDesktop.add(frame); // attach internal frame
               frame.setVisible(true); // show internal frame
          }
     
 }
 
 ); 
  new2.addActionListener(  
 new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              JInternalFrame frame = new JInternalFrame(
                  "Internal Frame", true, true, true, true);
              combo  marcoEtiqueta=new combo();
             
        marcoEtiqueta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoEtiqueta.setSize(400,500);
        marcoEtiqueta.setVisible(true);
         theDesktop.add(frame); // attach internal frame
               frame.setVisible(true); // show internal frame
          }
     
 }
 
 );
  new3.addActionListener(  
 new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              JInternalFrame frame = new JInternalFrame(
                  "Internal Frame", true, true, true, true);
              
            acciones marcoEtiqueta=new acciones();
        marcoEtiqueta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoEtiqueta.setSize(400,500);
        marcoEtiqueta.setVisible(true);
         theDesktop.add(frame); // attach internal frame
               frame.setVisible(true); // show internal frame
          }
     
 }
 
 );
   new4.addActionListener(  
 new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
              JInternalFrame frame = new JInternalFrame(
                  "Internal Frame", true, true, true, true);
              
            Juego marcoEtiqueta=new Juego();
        marcoEtiqueta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoEtiqueta.setSize(400,500);
        marcoEtiqueta.setVisible(true);
         theDesktop.add(frame); // attach internal frame
               frame.setVisible(true); // show internal frame
          }
     
 }
 
 );
}
}