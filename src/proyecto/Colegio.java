/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author J_Hor
 */
public class Colegio {
    Map<String, Curso> colegio;
    Map<String, Integer> cursoXId;
    Curso curso;
   
 
    
    
    public Colegio(){
 
        colegio = new HashMap<>();
        cursoXId = new HashMap<>();
    }    
}
