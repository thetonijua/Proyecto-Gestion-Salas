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
        cursos.setPorceAprobacion(1);
        System.out.println(cursos.getCodigo());

    }

}
