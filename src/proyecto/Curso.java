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

    private String nombre;
    private int codigo;
    private float porceAprobacion;
    private Map<Integer, Alumno> estudiantes;
    private List<Integer> listaEstu;
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

    public Curso(String name, float numero, int cod) {
        nombre = name;
        porceAprobacion = numero;
        estudiantes = new HashMap();
        codigo = cod;
        listaEstu = new ArrayList();
    }

    public Curso() {
        nombre = "Por asignar";
        porceAprobacion = (float) 0;
        estudiantes = new HashMap();
        listaEstu = new ArrayList();

    }

    public Curso(String name) {
        nombre = name;
        porceAprobacion = (float) 0;
        estudiantes = new HashMap();
        listaEstu = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPorceAprobacion() {
        return porceAprobacion;
    }

    public void setPorceAprobacion(int porceAprobacion) {
        this.porceAprobacion = porceAprobacion;
    }

    public void setPorceAprobacion(float porceAprobacion) {
        this.porceAprobacion = porceAprobacion;
    }

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
        int num;
        float id = Float.parseFloat(txt);
        float aux = id % 1;
        aux = id - aux;
        num = (int) aux;

        if (!estudiantes.containsKey(num)) {
            System.out.println("No se encontro ");

        }
        return estudiantes.get(num);
    }

    public void putAlumno(String name, int id) {
        Alumno aux = new Alumno(name, id);

        estudiantes.put(id, aux);
        listaEstu.add(id);
    }

    public void putAlumno(String name, String id) {
        int num = Integer.parseInt(id);
        Alumno aux = new Alumno(name, num);
        estudiantes.put(num, aux);
        listaEstu.add(num);
    }

    public void printSetKey() {
        System.out.println(estudiantes.keySet());
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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

}
