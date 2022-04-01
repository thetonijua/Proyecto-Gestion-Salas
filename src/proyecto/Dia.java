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

    private int dia;
    private int mes;
    private int año;
    boolean asistencia;

    public Dia() {

    }

    public Dia(int dd, int mm, int aa, boolean siNo) {
        dia = dd;
        mes = mm;
        año = aa;
        asistencia = siNo;

    }

    public Dia(String fecha, String siNo) {
        String[] aux = fecha.split("-");
        dia = Integer.parseInt(aux[0]);
        mes = Integer.parseInt(aux[1]);
        año = Integer.parseInt(aux[2]);
        if ("si".equals(siNo)) {
            asistencia = true;
        } else {
            asistencia = false;
        }
    }

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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }
public String getAsistencia(){
    if(asistencia)return "presente";
    else return "ausente";
}    
public void printDia(){
    
    System.out.println(dia+"-"+mes+"-"+año+" "+this.getAsistencia());
}
}
