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
    private ConjuntoAlumnos alumnos;
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in)); //usado para leer la lista

    //constructores
    public Curso(String name, float numero, int cod) {
        nombre = name;
        porceAprobacion = numero;
        codigo = cod;
        alumnos = new ConjuntoAlumnos();

    }

    public Curso() {
        nombre = "Por asignar";
        porceAprobacion = (float) 0;
        alumnos = new ConjuntoAlumnos();

    }

    public Curso(String name) {
        nombre = name;
        porceAprobacion = (float) 0;
        alumnos = new ConjuntoAlumnos();
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

    //2 getters para alumno por si el argumento es Integer, float o String
    public Alumno getAlumno(Integer id) {
        return alumnos.getAlumno(id);
    }

    public Alumno getAlumno(String txt) {
        return alumnos.getAlumno(txt);
    }
    

    //métodos de la clase
    /*dos métodos para añadir el alumno a la lista
    el primero es para una id de tipo int*/
    public void putAlumno(String name, int id) throws IdAlumnoRepetidaException {
        alumnos.putAlumno(name, id);
    }

    //el segundo es para una id de tipo String
    // Metodo ocupado en interfaz para ingresar alumno
    public void putAlumno(String name, String id) throws IdAlumnoRepetidaException {
        alumnos.putAlumno(name, id);

    }

    //imprime la key del estudiante en el mapa
    public void printSetKey() {
        alumnos.printSetKey();
    }
    public Set getSetNombre() {
        return alumnos.getSetNombre();
    }
    //pasa la lista de asistencia, preguntando si el estudiante está presente o no
    public void tomarAsistencia(String fecha) throws IOException {
        alumnos.tomarAsistencia(fecha);
    }

//Asistencia del curso en una fecha
    public void printAsistencia() throws IOException {
        alumnos.printAsistencia();
    }

    //imprime toda la lista de estudiantes
    public void printLista() throws IOException {
        alumnos.printLista();
    }

    //elimina un alumno de la lista según su id
    public void eliminarAlumno(int id) {
        alumnos.eliminarAlumno(id);
    }

    //elimina un alumno de la lista según su nombre
    public void eliminarAlumno(String name) {
        alumnos.eliminarAlumno(name);
    }

    //retorna la cantidad de alumnos, que es el tamaño de la lista
    public int cantAlum() {
        return alumnos.cantAlum();
    }

    //retorna los datos del estudiante usando su código
    public Alumno datosAlumno(int num) {

        return alumnos.datosAlumno(num);
    }

    /*public void asistenciaMin() throws IOException {
        int largo = listaEstu.size();
        int cod;
        
        Alumno aux1;
        Alumno aux2;
        for (int i = 0; i < largo; i++){
            cod = listaEstu.get(i);
            aux1 = estudiantes.get(cod);
            
        }
    }*/
    public void siFueron(String fecha) throws IOException {
        alumnos.siFueron(fecha);

    }
    //2 métodos para cambiar la asistencia, por si se ingresa el nombre o el id del alumno

    public void cambiarAsistencia(String fecha, String nombre) throws IOException {
        alumnos.cambiarAsistencia(fecha, nombre);
    }

    public void cambiarAsistencia(String fecha, int id) throws IOException {
        alumnos.cambiarAsistencia(fecha, id);
    }
}
