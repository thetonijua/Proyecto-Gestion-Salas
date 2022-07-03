/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import proyecto.IdAlumnoRepetidaException;
import vista.AgregarAlumno;

/**
 *
 * @author BruceLee
 */
public class CtrlAgregarAlumno implements ActionListener {

    private AgregarAlumno agregarAlumno;

    private ControladorMenu ctrl;

    public CtrlAgregarAlumno(AgregarAlumno agregarAlumno, ControladorMenu ctrl) {
        this.agregarAlumno = agregarAlumno;
        this.ctrl = ctrl;

    }

    public void iniciarAgregarAlumno() {
        agregarAlumno.setLocationRelativeTo(null);
        agregarAlumno.setDefaultCloseOperation(EXIT_ON_CLOSE);
        agregarAlumno.setVisible(true);
        agregarAlumno.btnAgregar.addActionListener(this);
        agregarAlumno.btnVolver.addActionListener(this);

        //agregarAlumno.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == agregarAlumno.btnAgregar) {
            if (agregarAlumno.txtCurso.getText() != null && agregarAlumno.txtAlumno.getText() != null) {

                try {
                    ctrl.colegio.agregarAlumno(agregarAlumno.txtAlumno.getText(), agregarAlumno.txtCurso.getText());
                    agregarAlumno.dispose();
                    ctrl.setMenuVisivle();
                } catch (IOException ex) {
                    Logger.getLogger(CtrlAgregarAlumno.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IdAlumnoRepetidaException ex) {
                    Logger.getLogger(CtrlAgregarAlumno.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (e.getSource() == agregarAlumno.btnVolver) {

                ctrl.setMenuVisivle();
                agregarAlumno.dispose();

            }
        }
    }
}
