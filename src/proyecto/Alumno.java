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
    private ArrayList<Dia> asistencia;

    //constructores
    public Alumno() {
        nombre = "No-Name";
        id = 0;
        totAsistencia = 0;
        asistencia = new ArrayList();
    }

    public Alumno(String name, int ide) {
        nombre = name;
        id = ide;
        totAsistencia = 0;
        asistencia = new ArrayList();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //métodos de la clase
    /*dos métodos para añadir a la lista de asistencia una fecha y si el alumno asistió o no esa fecha
    el primero es para una fecha de tipo String*/
    public void asistencia(String fecha, String siNo) {
        Dia aux = new DiaNormal(fecha, siNo);
        if(siNo.equals("si"))
            totAsistencia++;
        asistencia.add(aux);

    }

    //el segundo es para una fecha con su respectivo día, mes y año, todos de tipo int
    public void asistencia(int dia, int mes, int anio, boolean siNo) {
        
        asistencia.add(new DiaNormal(dia, mes, anio, siNo));

    }

    //elimina un día de la lista
    public void eliminarDia(String dd) {
        for (int i = 0; i < asistencia.size(); i++) {
            if (dd.equals(asistencia.get(i).getFecha())) {
                if ("Presente".equals(asistencia.get(i).isAsistencia())) {
                    totAsistencia--;
                }
                asistencia.remove(i);
            }
        }
    }

    //imprime toda la asistencia del alumno
    public void printAsistencia() {
        for (int i = 0; i < asistencia.size(); i++) {
            Dia aux = asistencia.get(i);
            aux.printDia();
        }
    }
    
    //retorna el total de días, que es el tamaño de la lista
    public int totalDias(){
        return asistencia.size();
    }
    
    //retorna el total de inasistencias
    public int faltas(){
        return(totalDias()-totAsistencia);
    }
}
