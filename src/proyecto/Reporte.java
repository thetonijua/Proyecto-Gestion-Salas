/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.*;

/**
 *
 * @author BruceLee
 */
public class Reporte {

    PrintWriter salida;
    String[] array;
     
    //Crea el archivo .txt del reporte
    public void exportar(String name) throws IOException {
        salida = new PrintWriter(name + ".txt");

    }

    //Genera los datos del curso, incluyendo su nombre, código, porcentaje de asistencia mínima, cantidad de alumnos y los alumnos en sí
    public void genReport(Curso curso) {
        salida.println("Nombre del Curso: " + curso.getNombre());
        salida.println("Codigo del Curso: " + curso.getCodigo());
        salida.println("Porcentaje de asistencia minima del Curso: " + (curso.getPorceAprobacion() * 100) + "%");
        salida.println("Cantidad de alumnos: "+curso.cantAlum());

        for (int j = 0; j < curso.cantAlum(); j++) {
            separarAlumno();
            salida.println("Nombre: " + curso.datosAlumno(j).getNombre());
            salida.println("Id: " + curso.datosAlumno(j).getId());
            salida.println("Asitio " + curso.datosAlumno(j).getTotAsistencia() + " De " + curso.datosAlumno(j).totalDias());
            salida.println("Falto a " + curso.datosAlumno(j).faltas() + " clases");

        }
        separarCursos();
    }

    //Separa los distintos cursos del colegio
    private void separarCursos() {
        salida.println("\n");
        for (int i = 0; i < 138; i++) {
            salida.print("/");
        }
        salida.println("\n");
    }

    //Separa los distintos alumnos del curso
    private void separarAlumno() {
        salida.println();
        for (int i = 0; i < 138; i++) {
            salida.print("-");
        }
        salida.println();
    }
    
    //Escribe el texto del reporte
    public void escribir(String texto) {
        salida.print(texto);

    }

    //Cierra una vez terminado el reporte
    public void listo() {
        salida.close();
    }
}
