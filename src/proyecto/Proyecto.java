/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import controlador.ControladorMenu;
import java.io.*;
import java.util.*;
import vista.Menu2;

/**
 *
 * @author BruceLee
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IdAlumnoRepetidaException, IOException {
        Colegio colegio = new Colegio();
        Usuario usuario= new Usuario();
        DatosStrategy fb= new FormatoBreve();
        DatosStrategy fe= new FormatoExtenso();
        usuario.dt=fb;
        String aux;
        Menu2 menu= new Menu2();
        ControladorMenu ctrlMenu=new ControladorMenu(colegio, menu);
        ctrlMenu.desplegar();
        menu.setVisible(true);
        int selectMenu;

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

       do {
            menu();
            selectMenu = Integer.parseInt(scan.readLine());
            cls();

            switch (selectMenu) {
                case 1: //Importar CSV
                    System.out.println("Ingrese nombre de archivo CSV (ejemplo/sugerencia prueba)");
                    colegio.importarCursos(scan.readLine());
                    break;

                case 2: //Agregar curso
                    
                    break;
                    
                case 3: //Añade un alumno nuevo al curso
                    System.out.println("ingrese Curso");
                    String cursoAux=scan.readLine();
                    System.out.println("Ingrese nombre");
                    String AlumnoAux=scan.readLine();
                    colegio.agregarAlumno(AlumnoAux,cursoAux);
                    break;

                case 4: //Mostrar lista de cursos
                    System.out.println(colegio.colegio.keySet());
                    break;

                case 5: //Mostrar lista de alumnos del curso
                    colegio.mostrarAlumno();
                    break;

                case 6: //Mostrar la asistencia del alumno
                    colegio.showAsis();
                    break;

                case 7: //Pasar la lista del curso
                    colegio.pasarLista();
                    break;

                case 8: //Eliminar alumno del curso
                    colegio.delAlumno();
                    break;

                case 9: //Eliminar dia del alumno
                    colegio.delDia();
                    break;

                case 10: //Crea un reporte de los cursos del colegio
                    colegio.reporte();
                    break;

                case 11: //Asistencia en una fecha de un curso
                    colegio.asisXDia();
                    break;

                case 12: //Alumnos de todo el colegio que asistieron a una determinada fecha
                    colegio.asisXDiaColegio();
                    break;
                    
                case 13: //Cambiar la asistencia de un alumno de una determinada fecha
                    colegio.cambiarAsist();
                    break;
                    
                case 14://Datos de alumnos vista 
                    System.out.println("\nIngrese tipo de usuario (docente/alumno):\n");
                    aux=scan.readLine();
                    if(aux.equals("docente")){
                        usuario.dt=fe;
                    }
                    if(aux.equals("alumno")){
                        usuario.dt=fb;
                    }
                   
                    usuario.mostrarDatos(colegio);
                    break;

                default: //salir
                    selectMenu = 0;
                    break;

            }
        } while (selectMenu != 0);

    }

    private static void menu() { //Opciones del menú

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
        System.out.println("11.- Mostrar asistencia en una fecha");
        System.out.println("12.- Mostrar alumnos del colegio que asistieron en una fecha determinada");
        System.out.println("13.- Cambiar asistencia de un alumno");
        System.out.println("14.- Datos Curso/Alumno vista Usuario(Alumno/Profesor)");
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
