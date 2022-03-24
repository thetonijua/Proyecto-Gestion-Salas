/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 *
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Curso cursos = new Curso();
        cursos.setCodigo("1M-A");
        float porce = (float) 0.6;//no se porque me reconoce el 0.6 como double ayuda
        cursos.setPorceAprobacion(porce);
        cursos.setTotAlumn(1);
        //preparando cursos.setAño
        Dia[][] año = new Dia[12][31];
        año[0][0] = new Dia();
        año[0][0].setDiaContable(true);
        año[0][0].setNumDia("01-01-2022");
        //prepareando año[0][0].setAlumnos(alumnos)
        Alumno[] alumnos = new Alumno[1];
        alumnos[0] = new Alumno();
        alumnos[0].setAsistenciaTot(true, año[0][0].getNumDia());
        alumnos[0].setId(1);
        alumnos[0].setNombre("Cesar");

        año[0][0].setAlumnos(alumnos);
        cursos.setAño(año);

        System.out.println(cursos.getCodigo() + " Asistencia minima " + 100*cursos.getPorceAprobacion() + "% Total alumnos: " + cursos.getTotAlumn());
        System.out.println("Curso:");
        System.out.println(alumnos[0].getId()+" "+alumnos[0].getNombre()+" Asistencia total "+alumnos[0].getAsistenciaTot()+" Fecha: "+alumnos[0].getFechaAsis()[0]);
        

    }

}
