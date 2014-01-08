/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;

import entidades.CampeonatoMundial;
import entidades.Escuderia;
import entidades.Circuito;
import entidades.GranPremio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAMISHO
 */
public class RegistroGranPremio {
    List<GranPremio> listaGrandesPremios;
    RegistroCircuitos registroCircuitos;
    String ruta;
    File archivo;
    FileReader fr;
    BufferedReader br;
//implementar
    public RegistroGranPremio(){
        listaGrandesPremios=new ArrayList<GranPremio>();
        ruta="src/registros/";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
    }
    //implementar
     private void LeeFichero() {
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (this.ruta+"R_GrandesPremios.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
           
         // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null)
            System.out.println(linea);
    }
    catch(Exception e){
       e.printStackTrace();
    }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
       try{                    
            if( null != fr ){   
                fr.close();     
            }                  
        }catch (Exception e2){ 
            e2.printStackTrace();
        }
    }
  }
    
    public void guardarGranPremio(GranPremio gp){
        listaGrandesPremios.add(gp);
        String grabar="";
        grabar+=gp.getNombre()+";";
        grabar+=gp.getDia()+";";
        grabar+=gp.getMes()+";";
        grabar+=gp.getAnyo()+";";
        grabar+=gp.getPais()+";";
        grabar+=gp.getIdGranPremio()+";";
        grabar+=gp.getCircuito().getNombre()+";";
             
        this.escribir(grabar);
    }
    
    public void cargarEscuderias(){
        List<GranPremio> gPs=new ArrayList<GranPremio>();
        List<String> lineas=new ArrayList<String>();
        try {
       
           archivo = new File (this.ruta+"R_GrandesPremios.txt");
           fr = new FileReader (archivo);
           br = new BufferedReader(fr);
           
         // Lectura del fichero
           String linea;
           while((linea=br.readLine())!=null)
               lineas.add(linea);
            //System.out.println(linea);
    }
    catch(Exception e){
       e.printStackTrace();
    }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
       try{                    
            if( null != fr ){   
                fr.close();     
            }                  
        }catch (Exception e2){ 
            e2.printStackTrace();
        }
    }
        //si hay ñectura de lineas añadimos a la lista de escuderias
        if(!lineas.isEmpty()){
            for(String a:lineas){
                String[] atr;
                GranPremio granPremio=new GranPremio();
                atr=a.split(";");
                granPremio.setNombre(atr[0]);
                
                              
                granPremio.setDia(atr[1]);
                granPremio.setMes(atr[2]);
                granPremio.setAnyo(atr[4]);
                granPremio.setPais(atr[5]);
                granPremio.setIdGranPremio(atr[6]);
                Circuito cir=this.registroCircuitos.introduceIdcircuito(atr[7]);
                granPremio.setCircuito(cir);
                
                               
                gPs.add(granPremio);
            }
        }else{
            System.out.println("No existen escuderias");
        }
        
        //return esc;
        this.listaGrandesPremios=gPs;
    }
    
    private void escribir(String cadena){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.ruta+"R_CGrandesPremios.txt",true);
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
    
    
    public List<GranPremio> getListaGrandesPremios() {
        return listaGrandesPremios;
    }

    public void setListaEscuderias(List<GranPremio> listaGrandesPremios) {
        this.listaGrandesPremios = listaGrandesPremios;
    }
    public List<GranPremio> cargarGrandesPremios(){
        return this.listaGrandesPremios;
    }
    public GranPremio getGranPremio(String idGP){
        GranPremio granpremio=new GranPremio();
        for(GranPremio gp:this.listaGrandesPremios){
            if(gp.getIdGranPremio().equals(idGP)){
                granpremio=gp;
                break;
            }
        }
    return granpremio;
    }
}
