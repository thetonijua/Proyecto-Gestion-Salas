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

/**
 *
 * @author J_Hor
 */
public class CtrlAgregar implements ActionListener {

    private AgregarCurso agregarCurso;

    private ControladorMenu ctrl;
    

    public  CtrlAgregar(AgregarCurso agregarCurso, ControladorMenu ctrl) {
        this.agregarCurso = agregarCurso;
        this.ctrl = ctrl;

    }

    public void iniciarAgregarCurso() {
        agregarCurso.setLocationRelativeTo(null);
        agregarCurso.setDefaultCloseOperation(EXIT_ON_CLOSE);
        agregarCurso.setVisible(true);
        agregarCurso.btnAgregar.addActionListener(this);
        agregarCurso.btnVolver.addActionListener(this);

        //agregarCurso.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == agregarCurso.btnAgregar) {
            if (agregarCurso.txtNombre.getText() != null) {
                ctrl.colegio.defineCurso(agregarCurso.txtNombre.getText(), agregarCurso.txtCodigo.getText(),agregarCurso.txtAprob.getText());
                ctrl.colegio.addCurso();
                ctrl.setMenuVisivle();
                agregarCurso.dispose();
                
                
            }
        }
        if (e.getSource() == agregarCurso.btnVolver) {
            
            ctrl.setMenuVisivle();
            agregarCurso.dispose();

        }
    }
}
