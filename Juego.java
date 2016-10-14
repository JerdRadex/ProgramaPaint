/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;


public class Juego extends JFrame{
    
     private JTextField N1;
    private JLabel eti;
    private JLabel et;
    int num=(int)Math.floor(Math.random()*(1-(1001))+(1001));
     


public Juego(){
    super("Grados");
        setLayout( new FlowLayout());
        
        eti= new JLabel("tengo un numero del 1 al 1000 intentalo adivinar");
        N1=new JTextField(10);
        et=new JLabel("hola");
        add(eti);
        add(N1);
       
        N1.addActionListener( 
        new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            int n1;
            
            n1=Integer.parseInt(N1.getText());
            
            if(n1>num){
                et=new JLabel();
                getContentPane().setBackground(
            Color.BLUE);
               et.setText("\"Lo siento demasiado alto\"");
                
            }  
           
                if(n1<num){
                    et=new JLabel();
                     getContentPane().setBackground(
            Color.RED);
                     et.setText("Lo siento demasiado bajo");
                }
                
            if(n1==num){
                et=new JLabel("Lo has adivinado felicidades");
                N1.setEditable(false);
                et.setText("Lo has adivinado felicidades");
            }
            
        }
            
        }
         
        );
       add(et); 
}
}
