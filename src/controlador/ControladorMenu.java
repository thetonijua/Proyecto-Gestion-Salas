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

/**
 *
 * @author BruceLee
 */
public class ControladorMenu implements ActionListener {

    Colegio colegio;
    Menu2 menu;
    AgregarCurso ventanaAddCurso;

    public ControladorMenu(Colegio colegio, Menu2 menu) {
        this.colegio = colegio;
        this.menu = menu;
        this.ventanaAddCurso = new AgregarCurso();
        menu.botonOpcion1.addActionListener(this);
        menu.botonOpcion2.addActionListener(this);
        menu.botonOpcion3.addActionListener(this);
        menu.botonOpcion4.addActionListener(this);
        menu.botonOpcion5.addActionListener(this);
        menu.botonOpcion6.addActionListener(this);
        menu.botonOpcion7.addActionListener(this);
        menu.botonOpcion8.addActionListener(this);
        menu.botonOpcion9.addActionListener(this);
        menu.botonOpcion10.addActionListener(this);
        menu.botonOpcion11.addActionListener(this);
        menu.botonOpcion12.addActionListener(this);
    }

    public void desplegar() {
        menu.setTitle("Menu");
        menu.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        


        if (e.getSource() == menu.botonOpcion1) {
            //    System.out.println("Ingrese nombre de archivo CSV (ejemplo/sugerencia prueba)");
            // colegio.importarCursos(scan.readLine());
        }
        if (e.getSource() == menu.botonOpcion2) {
            menu.setVisible(false);
            ventanaAddCurso = new AgregarCurso();
            ventanaAddCurso.setVisible(true);
          
            //colegio.agregarCurso
        }
        if (e.getSource() == menu.botonOpcion3) {
            //colegio.agregarAlumno();
        }
        if (e.getSource() == menu.botonOpcion4) {
            //System.out.println(colegio.keySet());
        }
        if (e.getSource() == menu.botonOpcion5) {
            //colegio.mostrarAlumno();
        }
        if (e.getSource() == menu.botonOpcion6) {
            //colegio.showAsis();
        }
        if (e.getSource() == menu.botonOpcion7) {
            //colegio.pasarLista();
        }
        if (e.getSource() == menu.botonOpcion8) {
            //colegio.delAlumno();
        }
        if (e.getSource() == menu.botonOpcion9) {
            //colegio.delDia();
        }
        if (e.getSource() == menu.botonOpcion10) {
            //colegio.reporte();
        }
        if (e.getSource() == menu.botonOpcion11) {
            //colegio.asisXDia();
        }
        if (e.getSource() == menu.botonOpcion12) {
            //colegio.asisXDiaColegio();
        }


    }
}
