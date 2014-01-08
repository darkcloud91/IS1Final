/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;
import registros.RegistroGranPremio;

/**
 *
 * @author MAMISHO
 */
public class CampeonatoMundial {
    private String anyo;
    List<GranPremio> grandesPremios;
    //RegistroGranPremio registrosGrandesPremios;
    double numeroGrandesPremios;
    /*
     @overwrite
     * quien invoque el contructor debe pasar el año
     * actual y numero de GP, ya que en los requisitos no se pide
     * que se gestiones varior CM es decir solo se
     * toma en cuenta el del año actual. Por lo tanto no cargamos
     * los grandes premios del mismo hasta que soliciten la lista
     * en el metodo
     */

    public double getNumeroGrandesPremios() {
        return numeroGrandesPremios;
    }

    public void setNumeroGrandesPremios(int numeroGrandesPremios) {
        this.numeroGrandesPremios = numeroGrandesPremios;
    }
    
    //arreglar implementacios
    public CampeonatoMundial(){
    grandesPremios=new ArrayList<GranPremio>();
    }
    
    public void introducirDatosCM(String anyo,double numeroGrandesPremios,ArrayList<GranPremio> gp){
        this.anyo=anyo;
        this.numeroGrandesPremios=numeroGrandesPremios;
        
    }
    
    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public List<GranPremio> getGrandesPremios() {
        //implementar para que devuelva solo GP del año del CM
        //para esto recorre el registro del mismo
        return grandesPremios;
    }
    
    

    public void setGrandesPremios(List<GranPremio> grandesPremios) {
        this.grandesPremios = grandesPremios;
    }
    
    /*public void cargarGrandesPremios(){
        this.registrosGrandesPremios.cagarGrandesPremios();
    }*/
}
