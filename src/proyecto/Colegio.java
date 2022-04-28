/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.*;
/**
 *
 * @author J_Hor
 */
public class Colegio extends JFrame implements ActionListener, ItemListener {
    Map<String, Curso> colegio;
    Map<String, Integer> cursoXId;
    private JLabel label1,label2,label3,label4,label5,label6;
    private JButton boton1,boton2;
    private JTextField tf1,tf2,tf3,tf4;
    private JComboBox combo1;
    
    
    public Colegio(){
        colegio = new HashMap<>();
        cursoXId = new HashMap<>();
        label1= new JLabel("Agregar curso");
        label2= new JLabel("Nombre");
        label3= new JLabel("% Aprobacion (ej: 0.1)");
        label4= new JLabel("Código curso");
        label5= new JLabel("N° alumnos");
        label6= new JLabel("Seleccionar curso");
        boton1= new JButton("Agregar");
        boton2= new JButton("Siguiente");
        tf1= new JTextField();
        tf2= new JTextField();
        tf3= new JTextField();
        tf4= new JTextField();
        combo1= new JComboBox();
    }
    
    
    
    public void configVentana(){
        setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(label2);
        add(label1);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(boton1);
        add(boton2);
        add(combo1);
        
        tf1.setBounds(250,100,150,19);
        tf2.setBounds(250,120,150,19);
        tf3.setBounds(250,140,150,19);
        tf4.setBounds(250,160,150,19);
        label1.setBounds(20,20,100,100);
        label2.setBounds(80,60,100,100);
        label3.setBounds(80,80,150,100);
        label4.setBounds(80,100,150,100);
        label5.setBounds(80,120,150,100);
        label6.setBounds(20,240,150,100);
        combo1.setBounds(250,280,150,19);
        boton1.setBounds(190,200,100,25);
        boton2.setBounds(190,390,100,25);
        
        boton1.addActionListener(this);
        combo1.addItemListener(this);
        
        
        
        this.setBounds(0, 0, 500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==boton1){
            String texto1= tf1.getText();
            String texto2= tf2.getText();
            String texto3= tf3.getText();
            String texto4= tf4.getText();
            if((texto1.equals(""))||(texto2.equals(""))||(texto3.equals(""))||(texto4.equals(""))){
                JOptionPane.showMessageDialog(null, "Rellena los 4 campos .___.");
            }else{
                Curso cursoAux;
                cursoAux = new Curso(texto1);
                cursoAux.setPorceAprobacion(Float.parseFloat(texto2));
                cursoAux.setCodigo(Integer.parseInt(texto3));
                cursoXId.putIfAbsent(texto1, cursoAux.getCodigo());
                combo1.addItem(cursoAux.getNombre());
  
            }
        }    
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){
            if(e.getSource()==combo1){
                String selec= combo1.getSelectedItem().toString();
                if(selec.equals("")){
                    JOptionPane.showMessageDialog(null, "Selecciona un curso");
                }
            }
    }


    
    
    
    
}
