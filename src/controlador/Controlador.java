/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Cursomod;
import vista.AgregarCurso;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import vista.ListarCursos;
import vista.Menu;

/**
 *
 * @author J_Hor
 */
public class Controlador implements ActionListener{
    
    private AgregarCurso agregarCurso;
    private Menu menu;
    private ListarCursos listarCursos;
    private Cursomod cursoM;
    
    public Controlador(Menu menu){
        this.menu=menu;
        
    }
    
    public void iniciarmenu(){
        menu.setLocationRelativeTo(null);
        this.menu.aceptar.addActionListener(this);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        menu.setVisible(true);
        //menu.dispose();
    }
    
    public void iniciarAgregarCurso(){
        agregarCurso= new AgregarCurso();
        agregarCurso.setLocationRelativeTo(null);
        agregarCurso.setDefaultCloseOperation(EXIT_ON_CLOSE);
        agregarCurso.setVisible(true);
        menu.setVisible(false);
        //agregarCurso.dispose();
    }
    
    public void iniciarListarCursos(){
        listarCursos= new ListarCursos();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(menu.agregar.isSelected()){

            iniciarAgregarCurso();
        }
        
        if(menu.listar.isSelected()){
         
            
        }
        
        
        /*cursoM.setName(agregarCurso.nombre.getText());
        cursoM.setAprob(agregarCurso.aprob.getText());
        cursoM.setCod(agregarCurso.cod.getText());*/
    }
    
    
}
