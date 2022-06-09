/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.Set;
import proyecto.Colegio;

/**
 *
 * @author J_Hor
 */
public class Cursomod {
    
    private Colegio colegio;    
    private String name;
    private String aprob;
    private String cod;
    private Set<String> lista;

    public Set<String> getLista() {
        return lista;
    }

    public Set<String> srLista(Set<String> lista) {
        this.lista = colegio.listadoCursos;
        return lista;
    }

    public Colegio getColegio() {
        return colegio;
    }

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAprob() {
        return aprob;
    }

    public void setAprob(String aprob) {
        this.aprob = aprob;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
    
    
}/*   
colegio


proyecto
 Menu menu= new Menu();
        Controlador controlador= new Controlador(menu);
        controlador.iniciarmenu();
*/
