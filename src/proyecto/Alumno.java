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
public class Alumno {

    private String nombre;
    private int id;
    private int asistenciaTot = 0;
    private int posci = 0;
    private String[] fechaAsis = new String[365];

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public int getAsistenciaTot() {
        return asistenciaTot;
    }

    public void setAsistenciaTot(boolean asistio, String fecha) {
        if (asistio) {
            asistenciaTot++;
            setFechaAsis("Si asistio " + fecha);
        } else {
            setFechaAsis("No asistio " + fecha);
        }
    }

    public String[] getFechaAsis() {
        return this.fechaAsis;
    }

    private void setFechaAsis(String fechaAsis) {
        this.fechaAsis[posci] = fechaAsis;
        posci++;
    }

}
