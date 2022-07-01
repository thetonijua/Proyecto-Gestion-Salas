/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Set;
import javax.swing.*;

/**
 *
 * @author cesar
 */
public class VentanaMostrarCurso {

    JFrame ventana;
    JTextArea texto = new JTextArea();
    JScrollPane scroll;
   

    public VentanaMostrarCurso(String listados) {
        
        System.out.println(listados);
        ventana = new JFrame("Mostrar Curso");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scroll = new JScrollPane(texto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        texto.setText(listados);
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        ventana.add(scroll);
        ventana.setBounds(0, 0, 240, 240);
        ventana.setVisible(true);
    }

}
