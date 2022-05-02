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

    public void exportar(String name) throws IOException {
        salida = new PrintWriter(name + ".txt");

    }

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

    private void separarCursos() {
        salida.println("\n");
        for (int i = 0; i < 138; i++) {
            salida.print("/");
        }
        salida.println("\n");
    }

    private void separarAlumno() {
        salida.println();
        for (int i = 0; i < 138; i++) {
            salida.print("-");
        }
        salida.println();
    }

    public void escribir(String texto) {
        salida.print(texto);

    }

    public void listo() {
        salida.close();
    }
}
