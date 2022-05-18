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
public class DiaNormal extends Dia {

    boolean asistencia;

    public DiaNormal() {
        super(0, 0, 0);
        asistencia = false;
    }

    public DiaNormal(int dd, int mm, int aa, boolean siNo) {
        super(dd, mm, aa);
        asistencia = siNo;

    }

    public DiaNormal(String fecha, String siNo) {
        super(fecha);
        asistencia = "si".equals(siNo);
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
        System.out.println(getDia() + "-" + getMes() + "-" + getAnio() + " " + this.getAsistencia());
    }
}
