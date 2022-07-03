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
public class FormatoExtenso implements DatosStrategy{
    
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    Curso curso;
    
    /* Formato de salida de datos en el que se muestran a todos los alumnos y se puede acceder a los datos de cualquiera de ellos*/
    
    @Override
    public void ObtenerDatos(Colegio colegio){
        String aux = null;
        boolean c=true;
        
        colegio.colegio.keySet();
        
        do{
            try {
                c=colegio.infoAlumnoE();
                
            } catch (IOException ex){ 
            
            }
        }while(c);

    }
    
}
//            
          //  colegio.mostrarAlumno();