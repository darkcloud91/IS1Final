/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;
import entidades.Posicion;
import java.util.Comparator;

/**
 *
 * @author MAMISHO
 */
public class ComparadorPosicion implements Comparator {
    public int compare(Object a,Object b){
        int r=0;
        Posicion p1=(Posicion)a;
        Posicion p2=(Posicion)b;
        
        r=p1.getNombreGranPremio().compareTo(p2.getNombreGranPremio());
        if(r==0){
            r=p1.getPosicion()-p2.getPosicion();
        }
        return r;
    }
}
