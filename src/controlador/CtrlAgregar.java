 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import vista.AgregarCurso;
import modelo.Cursomod;

/**
 *
 * @author J_Hor
 */
public class CtrlAgregar implements ActionListener{
    
    private AgregarCurso agregarCurso;
    private Cursomod cursoM;
    private Controlador ctrl;
    
    public CtrlAgregar(AgregarCurso agregarCurso,Cursomod cursoM, Controlador ctrl){
        this.agregarCurso=agregarCurso;
        this.cursoM=cursoM;
        this.ctrl=ctrl;
        
    }
    
    public void iniciarAgregarCurso(){
        agregarCurso.setLocationRelativeTo(null);
        agregarCurso.setDefaultCloseOperation(EXIT_ON_CLOSE);
        agregarCurso.setVisible(true);
        agregarCurso.btnAgregar.addActionListener(this);
        agregarCurso.btnVolver.addActionListener(this);

        //agregarCurso.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        cursoM.setName(agregarCurso.nombre.getText());
        cursoM.setAprob(agregarCurso.aprob.getText());
        cursoM.setCod(agregarCurso.cod.getText());
        if(e.getSource()==agregarCurso.btnAgregar){
            if (agregarCurso.nombre.getText() != null) {
            ctrl.setNombreCurso(agregarCurso.nombre.getText());
            agregarCurso.dispose();
            ctrl.setMenuVisivle();
            }
        }
        if (e.getSource() == agregarCurso.btnVolver) {
            agregarCurso.dispose();
            ctrl.setMenuVisivle();
        }
    }
}
