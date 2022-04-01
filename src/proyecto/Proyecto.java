/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.*;
import java.util.*;

/**
 *
 * @author BruceLee
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        CSV file;
        file = new CSV("prueba");

        Map<String, Curso> colegio;
        Map<String, Integer> cursoXId;
        Map<String, Integer> alumnoXId;
        colegio = new HashMap<>();
        cursoXId = new HashMap<>();
        alumnoXId = new HashMap<>();

        String lectura = file.firstLine();

        String[] separado;
        int start, largo;
        start = 0;

        do {
            separado = lectura.split(";");

            largo = separado.length;

            Curso cursoAux;
            cursoAux = new Curso(separado[0]);
            cursoAux.setPorceAprobacion(Float.parseFloat(separado[2]));
            cursoAux.setCodigo(Integer.parseInt(separado[1]));
            cursoXId.putIfAbsent(separado[0], cursoAux.getCodigo());
            for (int i = 3; i < largo; i++) {
                cursoAux.putAlumno(separado[i], "30-03-2022", start);
                alumnoXId.putIfAbsent(separado[i], start);
                start++;

            }

            colegio.put(separado[0], cursoAux);
            lectura = file.nextLine();

        } while (lectura != null);
        System.out.println(colegio.keySet());
        Curso aux = colegio.get("A2");
        aux.pasarLista();
        int ayuda = alumnoXId.get("Alberto");
        Alumno perkin = aux.getAlumno(ayuda);
        System.out.println(perkin.getNombre() + " " + perkin.getTotAsistencia() + " ");
        perkin.printAsistencia();

    }

}
