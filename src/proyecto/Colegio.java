/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static proyecto.Proyecto.esNumero;

/**
 *
 * @author J_Hor
 */
public class Colegio {

    Map<String, Curso> colegio;
    Map<String, Integer> cursoXId;
    public Set<String> listadoCursos;
    int cantAlumnos;
    Curso curso;
    String xTeclado;
    int start = 0;
    Alumno estudiante;
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    

    public Colegio() {
        colegio = new HashMap<>();
        cursoXId = new HashMap<>();
        cantAlumnos = 0;
    }

    public void defineCurso(String nombre, String codigo, String aprobacion) {
        curso = new Curso(nombre);
        curso.setCodigo(Integer.parseInt(codigo));
        curso.setPorceAprobacion(Float.parseFloat(aprobacion));

    }

    public void addCurso(String nombre) {
        colegio.put(nombre, curso);
        cursoXId.put(nombre, curso.getCodigo());
    }
// funcionalidades Principales

    public void importarCursos(String scan) throws FileNotFoundException, IOException {
        CSV file;
        String[] separado;
        int largo;

        file = new CSV(scan);
        String lectura = file.firstLine();
        lectura = file.nextLine();
        do {
            separado = lectura.split(";");
            largo = separado.length;
            this.defineCurso(separado[0], separado[1], separado[2]);

            for (int i = 3; i < largo; i++) {
                curso.putAlumno(separado[i], cantAlumnos);
                cursoXId.put(separado[i], cantAlumnos);
                cantAlumnos++;

            }

            colegio.put(separado[0], curso);
            lectura = file.nextLine();

        } while (lectura != null);
    }

    //
    public void agregarCurso(String curso1) throws IOException {

        System.out.println("Ingrese el nombre del curso:");
        curso = new Curso(curso1);
        System.out.println("Ingrese el porcentaje de aprobacion del curso(ej. 0.1):");
        curso.setPorceAprobacion(Float.parseFloat(scan.readLine()));
        System.out.println("Ingrese el codigo del curso (ej: 14):");
        curso.setCodigo(Integer.parseInt(scan.readLine()));

        System.out.println("Cuantos alumnos tiene el curso:");
        int fin = Integer.parseInt(scan.readLine());
        for (int i = 0; i < fin; i++) {
            System.out.println("Nombre del alumno " + (i + 1) + ":");
            curso.putAlumno(scan.readLine(), cantAlumnos);
            cantAlumnos++;

        }
        colegio.put(curso.getNombre(), curso);
    }
    
    public void agregarAlumno() throws IOException {
        System.out.println("Ingrese el nombre del curso");
        curso = colegio.get(scan.readLine());
        System.out.println("Nombre del alumno:");
        xTeclado = scan.readLine();
        curso.putAlumno(xTeclado, start);

        start++;
    }

    //
    public void mostrarAlumno() throws IOException {

        System.out.println("Ingrese el nombre del curso:");
        curso = colegio.get(scan.readLine());
        curso.printLista();
    }

    //
    public void showAsis() throws IOException {
        System.out.println("Ingrese el nombre del curso:");
        curso = colegio.get(scan.readLine());
        System.out.println("Ingrese el nombre/id del alumno: \n");
        String lectura = scan.readLine();
        if (esNumero(lectura)) {
            curso.getAlumno(Integer.parseInt(lectura)).printAsistencia();
        }
        curso.getAlumno(lectura).printAsistencia();

    }

    //
    public void pasarLista() throws IOException {
        System.out.println("Ingrese Fecha (dd-mm-aa)");
        String fecha = scan.readLine();
        System.out.println("Ingrese curso:");
        colegio.get(scan.readLine()).tomarAsistencia(fecha);
    }

    //
    public void delAlumno() throws IOException {
        System.out.println("Ingrese curso");
        curso = colegio.get(scan.readLine());
        curso.printSetKey();
        System.out.println("Ingrese nombre/id alumno a  eliminar");
        String lectura = scan.readLine();
        if (esNumero(lectura)) {
            curso.eliminarAlumno(Integer.parseInt(lectura));
        } else {
            curso.eliminarAlumno(lectura);
        }
        curso.printSetKey();
    }

//
    public void delDia() throws IOException {
        System.out.println("Ingrese curso");
        curso = colegio.get(scan.readLine());
        System.out.println("Ingrese Alumno");
        String lectura = scan.readLine();
        if (esNumero(lectura)) {
            curso.getAlumno(Integer.parseInt(lectura)).printAsistencia();
            System.out.println("Ingrese ingrese dia a eliminar (dd-mm-aa):");
            curso.getAlumno(Integer.parseInt(lectura)).eliminarDia(scan.readLine());
            curso.getAlumno(Integer.parseInt(lectura)).printAsistencia();
        }

        curso.getAlumno(lectura).printAsistencia();
        System.out.println("Ingrese ingrese dia a eliminar (dd-mm-aa):");
        curso.getAlumno(lectura).eliminarDia(scan.readLine());
        curso.getAlumno(lectura).printAsistencia();

    }

//
    public void reporte() throws IOException {

        Reporte reporte = new Reporte();
        System.out.println("Ingrese nombre archivo reporte");
        reporte.exportar(scan.readLine());
        for (String s : colegio.keySet()) {
            reporte.genReport(colegio.get(s));

        }
        reporte.listo();
    }

//asistencia por dia
    public void asisXDia() throws IOException {
        System.out.println("Ingrese curso");
        curso = colegio.get(scan.readLine());
        curso.printAsistencia();
    }

    //Alumnos de todo el colegio que asistieron a una determinada fecha
    public void asisXDiaColegio() throws IOException {
        System.out.println("Ingrese fecha a revisar:");
        String  lectura = scan.readLine();
        System.out.println("\n");
        for (String name : colegio.keySet()) {
            curso = colegio.get(name);
            curso.siFueron(lectura);
        }
    }
    
    public void cambiarAsist() throws IOException {
        System.out.println("Ingrese curso");
        curso = colegio.get(scan.readLine());
        System.out.println("Ingrese Alumno");
        String lectura = scan.readLine();
        if (esNumero(lectura)) {
            estudiante = curso.getAlumno(Integer.parseInt(lectura));
        }
        estudiante = curso.getAlumno(lectura);
        estudiante.printAsistencia();
        System.out.println("Ingrese ingrese dia a cambiar (dd-mm-aa):");
        String fecha = scan.readLine();
        curso.cambiarAsistencia(fecha, lectura);
    }
    
    public void listaCursosString(){
        listadoCursos= colegio.keySet();
        
    }
}
