/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import entidades.Posicion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author MAMISHO
 */
public class RegistroClasificaciones {
    List<Posicion> listaPosiciones;
    String ruta;
    File archivo;
    FileReader fr;
    BufferedReader br;
    
    public RegistroClasificaciones(){
        listaPosiciones=new ArrayList<Posicion>();
        ruta="src/registros/";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
    }
    
    /*Para que funcione esta clase se supone que los
     * Datos de los registros se cargan una vez se haya inicializado un
     * CM y se hayan seleccionardo creado los GP, luego se puede
     * ejecutar el CU-13 el cual consiste en ingresar los
     * Resultados de cada GP, por lo cual es a patir de ese momento en el
     * que podemos realizar las consultas, y el registro ya estará
     * cargado con los datos de los resultados invocados desde el CU-13
     * 
     * A continuacion lo que hacemos es devolver la lista de posiciones
     * completa porque queremos clasificacion del CM y en la lista
     * Actual solo estan las posiciones de todos los GP del CM actual
     * 
     * 
     * Para devolverlas ordenadas por las posisiones las ordenamos con
     * una clase comparadora.
     */
    public void guardarPosicion(Posicion pos){
        
        String grabar="";
        grabar+=pos.getAnyo()+";";
        grabar+=pos.getNombreGranPremio()+";";
        grabar+=pos.getPosicion()+";";
        grabar+=pos.getPiloto().getIdPiloto()+";";
        
             
        this.escribir(grabar);
    }
    
    private void escribir(String cadena){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.ruta+"R_clasificaciones.txt",true);
            pw = new PrintWriter(fichero);
 
            
                pw.println(cadena);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    public List<Posicion> obtenerListaPosicionesCM(String anyo){
        List<Posicion> l=this.listaPosiciones;
        Collections.sort(l, new ComparadorPosicion());
        return l;
    }
    public List<Posicion> obtenerListaPosicionesGP(String idGranPremio){
        List<Posicion> l=this.listaPosiciones;
        Collections.sort(l, new ComparadorPosicion());
        return l;
    }

    public List<Posicion> getListaPosiciones() {
        return listaPosiciones;
    }

    public void setListaPosiciones(List<Posicion> listaPosiciones) {
        this.listaPosiciones = listaPosiciones;
    }
    
}
