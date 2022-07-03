/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import static proyecto.Proyecto.esNumero;

/**
 *
 * @author J_Hor
 */
public class FormatoBreve implements DatosStrategy {
    
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    Curso curso;
    @Override
    public void ObtenerDatos(Colegio colegio){
        
        try {
            colegio.infoAlumno();
        } catch (IOException ex) {
            Logger.getLogger(FormatoBreve.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
        
    }
    
    
}
