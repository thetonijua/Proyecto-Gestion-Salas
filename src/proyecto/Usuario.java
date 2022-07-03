/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author J_Hor
 */
public class Usuario {
    
    DatosStrategy dt;   
    
    public Usuario(){
        
    }
    
    
    void mostrarDatos(Colegio colegio){
        dt.ObtenerDatos(colegio);
    }
}
