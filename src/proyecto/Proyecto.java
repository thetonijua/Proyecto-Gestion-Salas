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

        Map<String, Curso> colegio;
        Map<String, Integer> cursoXId;
        Map<String, Integer> alumnoXId;
        colegio = new HashMap<>();
        cursoXId = new HashMap<>();
        alumnoXId = new HashMap<>();
        String[] separado;
        String xTeclado;
        int selectMenu;
        int start, largo;
        start = 0;
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        do {
            menu();
            selectMenu = Integer.parseInt(scan.readLine());
            cls();

            switch (selectMenu) {
                case 1: //Importar CSV
                    CSV file;
                    System.out.println("Ingrese nombre de archivo CSV (ejemplo/sugerencia prueba)");
                    file = new CSV(scan.readLine());
                    String lectura = file.firstLine();
                    lectura = file.nextLine();
                    do {
                        separado = lectura.split(";");

                        largo = separado.length;

                        Curso cursoAux;
                        cursoAux = new Curso(separado[0]);
                        cursoAux.setPorceAprobacion(Float.parseFloat(separado[2]));
                        cursoAux.setCodigo(Integer.parseInt(separado[1]));
                        cursoXId.putIfAbsent(separado[0], cursoAux.getCodigo());
                        for (int i = 3; i < largo; i++) {
                            cursoAux.putAlumno(separado[i], start);
                            alumnoXId.putIfAbsent(separado[i], start);
                            start++;

                        }

                        colegio.put(separado[0], cursoAux);
                        lectura = file.nextLine();

                    } while (lectura != null);
                    break;
                case 2:
                    Curso cursoAux;
                    System.out.println("Ingrese el nombre del curso:");
                    cursoAux = new Curso(scan.readLine());
                    System.out.println("Ingrese el porcentaje de aprobacion del curso(ej. 0.1):");
                    cursoAux.setPorceAprobacion(Float.parseFloat(scan.readLine()));
                    System.out.println("Ingrese el codigo del curso");
                    cursoAux.setCodigo(Integer.parseInt(scan.readLine()));
                    cursoXId.putIfAbsent(cursoAux.getNombre(), cursoAux.getCodigo());
                    System.out.println("Cuantos alumno tiene el curso:");
                    for (int i = 0; i < Integer.parseInt(scan.readLine()); i++) {
                        System.out.println("Nombre del alumno " + (i + 1) + ":");
                        xTeclado = scan.readLine();
                        cursoAux.putAlumno(xTeclado, start);
                        alumnoXId.putIfAbsent(xTeclado, start);
                        start++;

                    }

                    colegio.put(cursoAux.getNombre(), cursoAux);
                    break;

                case 3:
                    Curso cursoAux1;
                    System.out.println("Ingrese el nombre del curso");
                    cursoAux1 = colegio.get(scan.readLine());
                    System.out.println("Nombre del alumno:");
                    xTeclado = scan.readLine();
                    cursoAux1.putAlumno(xTeclado, start);
                    alumnoXId.putIfAbsent(xTeclado, start);
                    start++;

                    break;
                case 4:
                    System.out.println(colegio.keySet());
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del curso:");
                    cursoAux = colegio.get(scan.readLine());
                    cursoAux.printLista();
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del curso:");
                    cursoAux = colegio.get(scan.readLine());
                    Alumno perkin;
                    System.out.println("Ingrese el nombre del alumno:");
                    perkin = cursoAux.getAlumno(alumnoXId.get(scan.readLine()));
                    perkin.printAsistencia();
                    break;
                case 7:
                    System.out.println("Ingrese curso:");
                    colegio.get(scan.readLine()).pasarLista();
                    break;
                default:
                    selectMenu = 0;
                    break;

            }
        } while (selectMenu != 0);

    }

    private static void menu() {

        System.out.println("1.- Importar Archivo CSV");
        System.out.println("2.- Agregar curso por teeclado");
        System.out.println("3.- Agregar Alumno");
        System.out.println("4.- Mostrar listado de cursos");
        System.out.println("5.- Mostrar listado de alumnos");
        System.out.println("6.- Mostrar listado de dias");
        System.out.println("7.- Pasar lista");
        System.out.println("0.- Salir");

    }

    private static void cls() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }

}
