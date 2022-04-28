/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import java.util.*;
/**
 *
 * @author BruceLee
 */
public class Alumno {
    
    //variables de instancia
    
    private String nombre;
    private int id;
    private int totAsistencia;
    private ArrayList <Dia> asistencia;

    //constructores
    
    public Alumno() {
        nombre = "No-Name";
        id = 0;
        totAsistencia = 0;
       
        asistencia=new ArrayList();
    }

    public Alumno(String name,  int ide) {
        nombre = name;
        id = ide;
        totAsistencia = 0;
        asistencia=new ArrayList();
         
        
    }
    
    //setters y getters de las variables

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotAsistencia() {
        return totAsistencia;
    }

    public void setTotAsistencia(int totAsistencia) {
        this.totAsistencia = totAsistencia;
    }

    public ArrayList getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(ArrayList asistencia) {
        this.asistencia = asistencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void asistencia(String fecha, String siNo) {
        Dia aux=new Dia (fecha,siNo);
        
        asistencia.add(aux);

    }

    //ahora no es necesario pero lo necesitare despues
    /*public void asistencia(int dia, int mes, int anio, boolean siNo) {
        Dia aux=new Dia (dia,mes,anio,siNo);
        asistencia.add(aux);

    }
    public void printAsistencia(){
        for (int i=0;i<asistencia.size();i++){
            Dia aux=asistencia.get(i);
            aux.printDia();
        }
    }*/
}
