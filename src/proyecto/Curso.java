/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.*;
import java.io.*;

/**
 *
 * @author BruceLee
 */
public class Curso {

    //variables de instancia
    private String nombre;
    private int codigo;
    private float porceAprobacion;
    private Map<Integer, Alumno> estudiantes;
    private Map<String, Integer> nombreXId;
    private List<Integer> listaEstu;
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in)); //usado para leer la lista

    //constructores
    public Curso(String name, float numero, int cod) {
        nombre = name;
        porceAprobacion = numero;
        estudiantes = new HashMap();
        nombreXId = new HashMap();
        codigo = cod;
        listaEstu = new ArrayList();
    }

    public Curso() {
        nombre = "Por asignar";
        porceAprobacion = (float) 0;
        estudiantes = new HashMap();
        nombreXId = new HashMap();
        listaEstu = new ArrayList();

    }

    public Curso(String name) {
        nombre = name;
        porceAprobacion = (float) 0;
        estudiantes = new HashMap();
        nombreXId = new HashMap();
        listaEstu = new ArrayList();
    }

    //setters y getters de las variables
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPorceAprobacion() {
        return porceAprobacion;
    }

    //dos setters para porceAprobacion por si el argumento es int o float
    public void setPorceAprobacion(int porceAprobacion) {
        this.porceAprobacion = porceAprobacion;
    }

    public void setPorceAprobacion(float porceAprobacion) {
        this.porceAprobacion = porceAprobacion;
    }

    //tres getters para alumno por si el argumento es Integer, float o String
    public Alumno getAlumno(Integer id) {

        if (!estudiantes.containsKey(id)) {
            System.out.println("No se encontro ");

        }
        return estudiantes.get(id);
    }

    public Alumno getAlumno(float id) {
        int num;
        float aux = id % 1;
        aux = id - aux;
        num = (int) aux;

        if (!estudiantes.containsKey(num)) {
            System.out.println("No se encontro ");

        }
        return estudiantes.get(num);
    }

    public Alumno getAlumno(String txt) {
        int num = nombreXId.get(txt);

        if (!estudiantes.containsKey(num)) {
            System.out.println("No se encontro ");

        }
        return estudiantes.get(num);
    }

    //métodos de la clase
    /*dos métodos para añadir el alumno a la lista
    el primero es para una id de tipo int*/
    public void putAlumno(String name, int id) {
        Alumno aux = new Alumno(name, id);
        nombreXId.put(name, id);
        estudiantes.put(id, aux);
        listaEstu.add(id);
    }

    //el segundo es para una id de tipo String
    public void putAlumno(String name, String id) {
        int num = Integer.parseInt(id);
        Alumno aux = new Alumno(name, num);
        estudiantes.put(num, aux);
        nombreXId.put(name, num);
        listaEstu.add(num);
    }

    //imprime la key del estudiante en el mapa
    public void printSetKey() {
        System.out.println(estudiantes.keySet());
    }

    //pasa la lista de asistencia, preguntando si el estudiante está presente o no
    public void pasarLista() throws IOException {
        int largo = listaEstu.size();
        int cod;
        String lectura;
        String fecha;
        System.out.println("Ingrese Fecha");
        fecha = scan.readLine();

        Alumno aux;
        for (int i = 0; i < largo; i++) {
            cod = listaEstu.get(i);
            aux = estudiantes.get(cod);
            System.out.println("Esta presente " + aux.getNombre() + "? (si/no)");
            lectura = scan.readLine();
            aux.asistencia(fecha, lectura);
        }
    }

    //imprime toda la lista de estudiantes
    public void printLista() throws IOException {
        int largo = listaEstu.size();
        int cod;
        String lectura;

        Alumno aux;
        for (int i = 0; i < largo; i++) {
            cod = listaEstu.get(i);
            aux = estudiantes.get(cod);
            System.out.println(aux.getNombre());
        }
    }

    //elimina un alumno de la lista según su id
    public void eliminarAlumno(int id) {
        int i;
        if (estudiantes.remove(id) != null) {
            for (i = 0; i < listaEstu.size(); i++) {

                if (id == listaEstu.get(i)) {
                    listaEstu.remove(i);
                }

            }
        }
    }
    
    //elimina un alumno de la lista según su nombre
    public void eliminarAlumno(String name) {
        int i,id;
        id=nombreXId.get(name);
        if (estudiantes.remove(id) != null) {
            for (i = 0; i < listaEstu.size(); i++) {

                if (id == listaEstu.get(i)) {
                    listaEstu.remove(i);
                }

            }
        }
    }
    
    //retorna la cantidad de alumnos, que es el tamaño de la lista
    public int cantAlum(){
        return listaEstu.size();
    }
    
    //retorna los datos del estudiante usando su código
    public Alumno datosAlumno (int num){
           int cod = listaEstu.get(num);
           return estudiantes.get(cod);   
    }
}
