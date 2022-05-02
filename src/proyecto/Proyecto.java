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
        Menu m = new Menu();
        m.configVentana();
        Map<String, Curso> colegio;
        Reporte reporte;
        colegio = new HashMap<>();

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

                        for (int i = 3; i < largo; i++) {
                            cursoAux.putAlumno(separado[i], start);

                            start++;

                        }

                        colegio.put(separado[0], cursoAux);
                        lectura = file.nextLine();

                    } while (lectura != null);
                    break;
                    
                case 2: //Agregar curso
                    Curso cursoAux;
                    System.out.println("Ingrese el nombre del curso:");
                    cursoAux = new Curso(scan.readLine());
                    System.out.println("Ingrese el porcentaje de aprobacion del curso(ej. 0.1):");
                    cursoAux.setPorceAprobacion(Float.parseFloat(scan.readLine()));
                    System.out.println("Ingrese el codigo del curso (ej: 14):");
                    cursoAux.setCodigo(Integer.parseInt(scan.readLine()));

                    System.out.println("Cuantos alumno tiene el curso:");
                    int fin = Integer.parseInt(scan.readLine());
                    for (int i = 0; i < fin; i++) {
                        System.out.println("Nombre del alumno " + (i + 1) + ":");
                        xTeclado = scan.readLine();
                        cursoAux.putAlumno(xTeclado, start);

                        start++;

                    }

                    colegio.put(cursoAux.getNombre(), cursoAux);
                    break;

                case 3: //Agregar alumno al curso
                    Curso cursoAux1;
                    System.out.println("Ingrese el nombre del curso");
                    cursoAux1 = colegio.get(scan.readLine());
                    System.out.println("Nombre del alumno:");
                    xTeclado = scan.readLine();
                    cursoAux1.putAlumno(xTeclado, start);

                    start++;

                    break;
                    
                case 4: //Mostrar lista de cursos
                    System.out.println(colegio.keySet());
                    break;
                    
                case 5: //Mostrar lista de alumnos del curso
                    System.out.println("Ingrese el nombre del curso:");
                    cursoAux = colegio.get(scan.readLine());
                    cursoAux.printLista();
                    break;
                    
                case 6: //Mostrar la asistencia del alumno
                    System.out.println("Ingrese el nombre del curso:");
                    cursoAux = colegio.get(scan.readLine());
                    Alumno perkin;
                    System.out.println("Ingrese el nombre/id del alumno:");
                    lectura = scan.readLine();
                    if (esNumero(lectura)) {
                     perkin = cursoAux.getAlumno(Integer.parseInt(lectura));
                    }
                    perkin = cursoAux.getAlumno(lectura);
                    perkin.printAsistencia();
                    break;
                    
                case 7: //Pasar la lista del curso
                    System.out.println("Ingrese curso:");
                    colegio.get(scan.readLine()).pasarLista();
                    break;
                    
                case 8: //Eliminar alumno del curso
                    System.out.println("Ingrese curso");
                    cursoAux = colegio.get(scan.readLine());
                    cursoAux.printSetKey();
                    System.out.println("Ingrese ingrese nombre/id alumno a  eliminar");
                    lectura = scan.readLine();
                    if (esNumero(lectura)) {
                        cursoAux.eliminarAlumno(Integer.parseInt(lectura));
                    } else {
                        cursoAux.eliminarAlumno(lectura);
                    }
                    cursoAux.printSetKey();
                    break;
                    
                case 9: //Eliminar dia del alumno
                    System.out.println("Ingrese curso");
                    cursoAux = colegio.get(scan.readLine());
                    System.out.println("Ingrese ingrese Alumno");
                    lectura = scan.readLine();
                    if (esNumero(lectura)) {
                        perkin = cursoAux.getAlumno(Integer.parseInt(lectura));
                    }
                    perkin = cursoAux.getAlumno(lectura);
                    cursoAux.printLista();
                    perkin.printAsistencia();
                    System.out.println("Ingrese ingrese dia a eliminar (dd-mm-aa):");
                    perkin.eliminarDia(scan.readLine());
                    perkin.printAsistencia();
                    break;

                case 10: //crear reporte
                    System.out.println("Ingrese nombre archivo reporte");
                    lectura = scan.readLine();
                    reporte = new Reporte();
                    reporte.exportar(lectura);
                    for (String s : colegio.keySet()) {
                        reporte.genReport(colegio.get(s));

                    }
                    reporte.listo();
                    break;
                    
                default: //salir
                    selectMenu = 0;
                    break;

            }
        } while (selectMenu != 0);

    }

    private static void menu() { //opciones del menú

        System.out.println("1.- Importar Archivo CSV");
        System.out.println("2.- Agregar curso por teclado");
        System.out.println("3.- Agregar Alumno");
        System.out.println("4.- Mostrar listado de cursos");
        System.out.println("5.- Mostrar listado de alumnos");
        System.out.println("6.- Mostrar listado de dias");
        System.out.println("7.- Pasar lista");
        System.out.println("8.- Eliminar alumno");
        System.out.println("9.- Eliminar dia");
        System.out.println("10.- Crear reporte");
        System.out.println("0.- Salir");

    }

    private static void cls() {
        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }

    public static boolean esNumero(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
