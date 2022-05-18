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
public class DiaCorto extends Dia{
    boolean asistencia;
    String horario;
     public DiaCorto(int dd, int mm, int aa, boolean siNo,String hh) {
        super(dd, mm, aa);
        asistencia = siNo;
        horario=hh;

    }

    public DiaCorto(String fecha, String siNo, String hh) {
        super(fecha);
        asistencia = "si".equals(siNo);
        horario=hh;
    }

    //setters y getters de las variables
    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    //getAsistencia retorna presente o ausente dependiendo si asistió el estudiante
    public String getAsistencia() {
        if (asistencia) {
            return "presente";
        } else {
            return "ausente";
        }
    }

    //métodos de la clase
    //retorna la asistencia
    @Override
    public String isAsistencia() {
        if(asistencia)
        return "Presente";
        else
        return "Ausente";
    }



    //imprime el día en específico
    @Override
    public void printDia() {
        System.out.println(getDia() + "-" + getMes() + "-" + getAnio() + " " + this.getAsistencia()+"\nHorario de salida: "+horario);
    }
}
