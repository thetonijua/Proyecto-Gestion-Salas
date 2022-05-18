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
public class DiaExcepcional extends Dia{
    String festivo;
    public DiaExcepcional(int dd, int mm, int aa, String ff){
    super(dd,mm,aa);   
    festivo=ff;
}


    @Override
    public void printDia() {
         System.out.println(getDia() + "-" + getMes() + "-" + getAnio() + "no se realisaron clases por "+festivo);
    }
        @Override
    public String isAsistencia() {
        return "No hubo clases";
    }

    
    
}
