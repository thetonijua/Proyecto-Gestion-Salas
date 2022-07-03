/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author g-od
 */
public class IdAlumnoRepetidaException extends Exception{
    public IdAlumnoRepetidaException () {
        super ("El ID de alumno se encuentra repetido");
    }
}
