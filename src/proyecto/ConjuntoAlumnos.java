/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author BruceLee
 */
public class ConjuntoAlumnos implements Asistencia {

    private Map<Integer, Alumno> estudiantes;
    private Map<String, Integer> nombreXId;
    private List<Integer> listaEstu;
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

    public ConjuntoAlumnos() {
        estudiantes = new HashMap();
        nombreXId = new HashMap();
        listaEstu = new ArrayList();
    }

    // 2 getters para alumno por si el argumento es Integer, float o String
    public Alumno getAlumno(Integer id) {

        if (!estudiantes.containsKey(id)) {
            System.out.println("No se encontro ");

        }
        return estudiantes.get(id);
    }

    //
    public Alumno getAlumno(String txt) {
        int num = nombreXId.get(txt);

        if (!estudiantes.containsKey(num)) {
            System.out.println("No se encontro ");

        }
        return estudiantes.get(num);
    }
        public void getAlumnoInf(String txt) {
        int num = nombreXId.get(txt);

        if (!estudiantes.containsKey(num)) {
            System.out.println("No se encontro ");

        }
        estudiantes.get(num).getTotAsistencia();
    }

//
    public void putAlumno(String name, int id) throws IdAlumnoRepetidaException {
        if (estudiantes.get(id) != null) {
            for (int i = 0; i < listaEstu.size(); i++) {
                if (id == listaEstu.get(i)) {
                    throw new IdAlumnoRepetidaException();
                }
            }
        }
        nombreXId.put(name, id);
        estudiantes.put(id, new Alumno(name, id));
        listaEstu.add(id);
    }

    //
    public void putAlumno(String name, String id) throws IdAlumnoRepetidaException {
        int num = Integer.parseInt(id);
        if (estudiantes.get(num) != null) {
            for (int i = 0; i < listaEstu.size(); i++) {
                if (num == listaEstu.get(i)) {
                    throw new IdAlumnoRepetidaException();
                }
            }
        }
        nombreXId.put(name, num);
        estudiantes.put(num, new Alumno(name, num));
        listaEstu.add(num);

    }

    //
    public void printSetKey() {
        System.out.println(estudiantes.keySet());
    }
    public Set getSetNombre() {
        return nombreXId.keySet();
    }
    //pasa la lista de asistencia, preguntando si el estudiante está presente o no

    @Override
    public void tomarAsistencia(String fecha) throws IOException {

        for (int i = 0; i < listaEstu.size(); i++) {

            System.out.println("Esta presente " + estudiantes.get(listaEstu.get(i)).getNombre() + "? (si/no)");
            estudiantes.get(listaEstu.get(i)).tomarAsistencia(fecha);
        }
    }

    //Asistencia del curso en una fecha
    @Override
    public void printAsistencia() throws IOException {
        System.out.println("Ingrese fecha a revisar:");
        String lectura = scan.readLine();

        for (int i = 0; i < listaEstu.size(); i++) {
            if (estudiantes.get(listaEstu.get(i)).comprobarAsistenciaDia(lectura) == 0) {
                System.out.println(estudiantes.get(listaEstu.get(i)).getNombre() + " presente.");
            }
            if (estudiantes.get(listaEstu.get(i)).comprobarAsistenciaDia(lectura) == 1) {
                System.out.println(estudiantes.get(listaEstu.get(i)).getNombre() + " ausente.");
            }
            if (estudiantes.get(listaEstu.get(i)).comprobarAsistenciaDia(lectura) == 2) {
                System.out.println("Dia no agregado");
                break;
            }
        }
        System.out.println("\n");

    }

    //imprime toda la lista de estudiantes
    public void printLista() throws IOException {

        for (int i = 0; i < listaEstu.size(); i++) {
            System.out.println(estudiantes.get(listaEstu.get(i)).getNombre());
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
        int i, id;
        id = nombreXId.get(name);
        if (estudiantes.remove(id) != null) {
            for (i = 0; i < listaEstu.size(); i++) {

                if (id == listaEstu.get(i)) {
                    listaEstu.remove(i);
                    nombreXId.remove(name);
                    estudiantes.remove(id);
                }

            }
        }
    }

    //retorna la cantidad de alumnos, que es el tamaño de la lista
    public int cantAlum() {
        return listaEstu.size();
    }

    //retorna los datos del estudiante usando su código
    public Alumno datosAlumno(int num) {
        return estudiantes.get(listaEstu.get(num));
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

        for (int i = 0; i < listaEstu.size(); i++) {

            if (estudiantes.get(listaEstu.get(i)).comprobarAsistenciaDia(fecha) == 0) {
                System.out.println(estudiantes.get(listaEstu.get(i)).getNombre() + " presente.");
            }
        }
        System.out.println("\n");

    }

        //2 métodos para cambiar la asistencia, por si se ingresa el nombre o el id del alumnoF
    public void cambiarAsistencia(String fecha, String nombre) throws IOException {
        estudiantes.get(nombreXId.get(nombre)).cambiarDia(fecha);
    }

    public void cambiarAsistencia(String fecha, int id) throws IOException {
        estudiantes.get(id).cambiarDia(fecha);
    }

}
