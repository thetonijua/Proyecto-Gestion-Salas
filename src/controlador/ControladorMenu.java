/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Menu2;
import vista.AgregarCurso;
import proyecto.Colegio;
import vista.ListarCursos;

/**
 *
 * @author BruceLee
 */
public class ControladorMenu implements ActionListener {

    Colegio colegio;
    Menu2 menu;

    //
    AgregarCurso ventanaAddCurso;
    CtrlAgregar ctrlAddCurso;
    //
    ListarCursos listarCursos;
    CtrlMostrarCursos ctrlMostrarCursos;

    public ControladorMenu(Colegio colegio, Menu2 menu) {
        this.colegio = colegio;
        this.menu = menu;
        this.ventanaAddCurso = new AgregarCurso();
        menu.botonOpcion1.addActionListener(this);
        menu.botonOpcion2.addActionListener(this);
        menu.botonOpcion4.addActionListener(this);
    }

    public void desplegar() {
        menu.setTitle("Menu");
        menu.setLocationRelativeTo(null);

    }

    public void setMenuVisivle() {
        menu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menu.botonOpcion1) {
            menu.setVisible(false);
            CtrlImportar ctrlImp = new CtrlImportar(this);
            ctrlImp.iniciar();
        }
        if (e.getSource() == menu.botonOpcion2) {
            menu.setVisible(false);
            ventanaAddCurso = new AgregarCurso();

            ctrlAddCurso = new CtrlAgregar(ventanaAddCurso, this);
            ctrlAddCurso.iniciarAgregarCurso();

            //colegio.agregarCurso
        }
        if (e.getSource() == menu.botonOpcion4) {
            menu.setVisible(false);
            listarCursos = new ListarCursos();
            ctrlMostrarCursos = new CtrlMostrarCursos(listarCursos, this);
            ctrlMostrarCursos.iniciar();
            //System.out.println(colegio.keySet());
        }
    }

}
