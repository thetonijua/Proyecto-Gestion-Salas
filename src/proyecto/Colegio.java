/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author J_Hor
 */
public class Colegio extends JFrame implements ActionListener, ItemListener {
    Map<String, Curso> colegio;
    Map<String, Integer> cursoXId;
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8;
    private JButton boton1,boton2,boton3;
    private JTextField tf1,tf2,tf3,tf4,tf5;
    private JComboBox combo1;
    Reporte reporte;
    Curso curso;
   
 
    
    
    public Colegio(){
 
        colegio = new HashMap<>();
        cursoXId = new HashMap<>();
        label1= new JLabel("Agregar curso");
        label2= new JLabel("Nombre");
        label3= new JLabel("% Aprobacion (ej: 0.1)");
        label4= new JLabel("Código curso");
        label5= new JLabel("N° alumnos");
        label6= new JLabel("Seleccionar curso");
        label7= new JLabel("Listado cursos");
        label8= new JLabel("Crear reporte");
        boton1= new JButton("Agregar");
        boton2= new JButton("Siguiente");
        boton3= new JButton("Generar reporte");
        tf1= new JTextField();
        tf2= new JTextField();
        tf3= new JTextField();
        tf4= new JTextField();
        tf5= new JTextField();
        combo1= new JComboBox();
    }
    
    
    
    public void configVentana(){
        setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(label2);
        add(label1);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(boton1);
        add(boton2);
        add(boton3);
        add(combo1);
        
        tf1.setBounds(250,80,150,19);
        tf2.setBounds(250,100,150,19);
        tf3.setBounds(250,120,150,19);
        tf4.setBounds(250,140,150,19);
        tf5.setBounds(250,270,150,19);
        label1.setBounds(20,0,100,100);
        label2.setBounds(80,40,100,100);
        label3.setBounds(80,60,150,100);
        label4.setBounds(80,80,150,100);
        label5.setBounds(80,100,150,100);
        label6.setBounds(20,320,150,100);
        label7.setBounds(270,300,150,100);
        combo1.setBounds(250,360,150,19);
        boton1.setBounds(190,180,100,25);
        boton2.setBounds(190,460,100,25);
        boton3.setBounds(20,267,150,25);
        
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        combo1.addItemListener(this);
        
        
        
        this.setBounds(0, 0, 500, 570);
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
                colegio.put(cursoAux.getNombre(), cursoAux);
                combo1.addItem(cursoAux.getNombre());
  
            }
        }    
        
        if(e.getSource()==boton2){
            if(combo1.getSelectedItem()==null){
              JOptionPane.showMessageDialog(null, "Selecciona un curso");  
            }else{
                
                //Arreglar aqui;despues de volver atras y volver al mismo curso, este no se puede editar(intentar volver a la misma ventana)
                String aux=combo1.getSelectedItem().toString();
                
                curso=(Curso)colegio.get(aux);
                //System.out.println(c.getNombre());
                this.setVisible(false);
                curso.configVentana(this);
                
            }
        }
        
        if(e.getSource()==boton3){
            String aux=tf5.getText();
            if(aux.equals("")){
                JOptionPane.showMessageDialog(null,"Ingrese un nombre para el archivo .txt");
            }else{
                reporte=new Reporte();
                try {
                    reporte.exportar(aux);
                } catch (IOException ex) {
                    Logger.getLogger(Colegio.class.getName()).log(Level.SEVERE, null, ex);
                }
                colegio.keySet().forEach(s -> {
                    reporte.genReport(colegio.get(s));
                });
                reporte.listo();
            }
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){
            if(e.getSource()==combo1){
                String selec= combo1.getSelectedItem().toString();
                if(selec.equals("")){
                    //JOptionPane.showMessageDialog(null, "Selecciona un curso");
                }
            }
    }


    
    
    
    
}
