/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import vista.ListarCursos;

/**
 *
 * @author BruceLee
 */
public class CtrlMostrarCursos implements ActionListener {

    private ListarCursos listar;
    String nombres;
    private ControladorMenu ctrl;

    public CtrlMostrarCursos(ListarCursos listar, ControladorMenu ctrl) {
        this.listar = listar;
        this.ctrl = ctrl;
        //this.nombres=nombres;
    }

    public void iniciar() {
        listar.setLocationRelativeTo(null);
        listar.txtMostrar.setText(ctrl.colegio.listaCursosString());
        listar.setDefaultCloseOperation(EXIT_ON_CLOSE);
        listar.setVisible(true);
        listar.btnVolver.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == listar.btnVolver) {

            ctrl.setMenuVisivle();
            listar.dispose();

        }

    
}
}
