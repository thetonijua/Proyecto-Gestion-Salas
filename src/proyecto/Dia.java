/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Estudiante
 */
public class Dia {

    private boolean diaContable;
    private String numDia;
    private Alumno[] alumnos;
    private int totDiasCont = 0;

    public boolean isDiaContable() {
        return diaContable;
    }

    public void setDiaContable(boolean diaContable) {
        this.diaContable = diaContable;
        if (diaContable) {
            totDiasCont++;
        }
    }

    public String getNumDia() {
        return numDia;
    }

    public void setNumDia(String numDia) {
        this.numDia = numDia;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    /*public int getTotDiasCont() {
        return totDiasCont;
    }

   /*  public void setTotDiasCont(int totDiasCont) {
        this.totDiasCont = totDiasCont;
    }
    No creo que sea necesario Cesar
     */
}
