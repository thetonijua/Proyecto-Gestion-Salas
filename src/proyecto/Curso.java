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
public class Curso {
private String codigo;
private Dia[][] año=new Dia[12][31];
private int totAlumn;
private float porceAprobacion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Dia[][] getAño() {
        return año;
    }

    public void setAño(Dia[][] año) {
        this.año = año;
    }

    public int getTotAlumn() {
        return totAlumn;
    }

    public void setTotAlumn(int totAlumn) {
        this.totAlumn = totAlumn;
    }

    public float getPorceAprobacion() {
        return porceAprobacion;
    }

    public void setPorceAprobacion(float porceAprobacion) {
        this.porceAprobacion = porceAprobacion;
    }

}
