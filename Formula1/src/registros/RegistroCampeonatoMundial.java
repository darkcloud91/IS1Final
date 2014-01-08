/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;
import entidades.CampeonatoMundial;
import entidades.GranPremio;
import entidades.Piloto;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MAMISHO
 */
public class RegistroCampeonatoMundial {
    List<CampeonatoMundial> listaCM;
    String ruta;
    File archivo;
    FileReader fr;
    BufferedReader br;
    
    public RegistroCampeonatoMundial(){
        listaCM=new ArrayList<CampeonatoMundial>();
        ruta="src/registros/";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
    }
    
    private void LeeFichero() {
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (this.ruta+"R_CampeonatoMundial.txt");
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
    
    public void guardarCampeonatoMundial(CampeonatoMundial cm){
        listaCM.add(cm);
        List<GranPremio> grandesPremios=cm.getGrandesPremios();
        String grabar="";
        String gPs="";
        
        grabar+=cm.getAnyo()+";";
        grabar+=cm.getNumeroGrandesPremios()+";";
       
        for(GranPremio gp:grandesPremios){
        gPs+=gp.getIdGranPremio()+"\n";
        }
        grabar+=gPs;
        
        this.escribir(grabar);
    }
    
    
    
    private void escribir(String cadena){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.ruta+"R_CampeonatoMundial.txt",true);
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
    
    public void cargarCampeonatos(){
        List<CampeonatoMundial> cms=new ArrayList<CampeonatoMundial>();
        List<String> lineas=new ArrayList<String>();
        try {
       
           archivo = new File (this.ruta+"R_Escuderia.txt");
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
                CampeonatoMundial campeonatoMundial=new CampeonatoMundial();
                atr=a.split(";");
                campeonatoMundial.setAnyo(atr[0]);
                //campeonatoMundial.setNumeroGrandesPremios(atr[1]);
                
                
                cms.add(campeonatoMundial);
            }
        }else{
            System.out.println("No existen escuderias");
        }
        
        //return esc;
        this.listaCM=cms;
    }

    
    public List<CampeonatoMundial> getListaCM() {
        return listaCM;
    }

    public void setListaEscuderias(List<CampeonatoMundial> listaCM) {
        this.listaCM = listaCM;
    }
    
     
   
              
}

