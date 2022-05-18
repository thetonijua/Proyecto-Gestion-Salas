/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author BruceLee
 */
public abstract class Dia {

    //variables de instancia
    private int dia;
    private int mes;
    private int anio;


    /*public Dia() {

    }*/
    //constructores
    public Dia(int dd, int mm, int aa ) {
        dia = dd;
        mes = mm;
        anio = aa;

    }

    public Dia(String fecha) {
        String[] aux = fecha.split("-");
        dia = Integer.parseInt(aux[0]);
        mes = Integer.parseInt(aux[1]);
        anio = Integer.parseInt(aux[2]);

    }

    //setters y getters de las variables
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

   
    
    //retorna la fecha actual, con su día, mes y año
    public String getFecha(){    
        return (dia+"-"+mes+"-"+anio);
    }

    //imprime el día en específico
    public abstract void printDia();
    public abstract String isAsistencia();
}
