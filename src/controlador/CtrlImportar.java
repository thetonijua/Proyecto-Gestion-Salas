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
import vista.ImportarArchivo;

/**
 *
 * @author BruceLee
 */
public class CtrlImportar  implements ActionListener {
    

    private ControladorMenu ctrl;
    private ImportarArchivo imp;

    public CtrlImportar(ControladorMenu ctrl ) {
        this.ctrl = ctrl;
        imp=new ImportarArchivo();
    }
    
    public void iniciar(){
                imp.setLocationRelativeTo(null);
        imp.setDefaultCloseOperation(EXIT_ON_CLOSE);
        imp.setVisible(true);
        imp.btnImportar.addActionListener(this);
        imp.btnVolver.addActionListener(this);
    }
    
    
        @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == imp.btnImportar) {
            System.out.print(imp.txtNombre.getText());
            
            if (imp.txtNombre.getText() != null) {
                try {
                    ctrl.colegio.importarCursos(imp.txtNombre.getText());
                    
                    imp.dispose();
                    ctrl.setMenuVisivle();
                } catch (IOException ex) {
                    Logger.getLogger(CtrlImportar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IdAlumnoRepetidaException ex){
                    Logger.getLogger(CtrlImportar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (e.getSource() == imp.btnVolver) {
            
            ctrl.setMenuVisivle();
            imp.dispose();

        }
}
}
