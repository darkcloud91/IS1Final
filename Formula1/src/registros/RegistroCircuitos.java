/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package registros;
import entidades.Circuito;
import java.io.*;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author zadik
 */
public class RegistroCircuitos {
    List<Circuito> ListaCircuitos;
    String ruta;
    File archivo;
    FileReader fr;
    BufferedReader br;

    public RegistroCircuitos(List<Circuito> ListaCircuitos) {
        this.ListaCircuitos = ListaCircuitos;
        ruta="src/registros/";
        File archivo=null;
        FileReader fr=null;
        BufferedReader br=null;
    }
    public List<Circuito> getListaCircuitos() {
        return ListaCircuitos;
    }

    public void setListaCircuitos(List<Circuito> listaCircuitos) {
        this.ListaCircuitos = listaCircuitos;
    }
    
    //Ficheros
    private void LeeFichero() {
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (this.ruta+"R_circuitos.txt");
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
    private void actualizarFichero(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.ruta+"R_circuitos.txt");
            pw = new PrintWriter(fichero);
            int cont=this.getListaCircuitos().size();
            int i;
            for(i=0;i<cont;i++){
                Circuito c=this.getListaCircuitos().get(i);
               this.guardarCircuito(c); 
            }
            
            /*for(Circuito cir:this.getListaCircuitos()){
                this.guardarCircuito(cir);
            }*/
                //pw.println(cadena);
 
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
    private void escribir(String cadena){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.ruta+"R_circuito.txt",true);
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
    public void cargarCircuitos(){
        List<Circuito> cir=new ArrayList<Circuito>();
        List<String> lineas=new ArrayList<String>();
        try {
       
           archivo = new File (this.ruta+"R_circuito.txt");
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
        //si hay ñectura de lineas añadimos a la lista de circuitos
        if(!lineas.isEmpty()){
            for(String a:lineas){
                String[] atr;
                Circuito circuito=new Circuito();
                atr=a.split(";");
                circuito.setNombre(atr[0]);
                
                /*circuito.setUbicacion(atr[1]);
                circuito.setLongitud(atr[2]);
                circuito.setNvueltas(atr[3]);
                circuito.setDistancia(atr[4]);
                circuito.setRecordvuelta(atr[5]);*/
                                
                cir.add(circuito);
            }
        }else{
            System.out.println("No existen circuitos");
        }
        
        //return esc;
        this.ListaCircuitos=cir;
    }

    public void guardarCircuito(Circuito cir){
        String grabar="";
        grabar+=cir.getIdcircuito()+";";
        grabar+=cir.getNombre()+";";
        grabar+=cir.getUbicacion()+";";
        grabar+=cir.getLongitud()+";";
        grabar+=cir.getNvueltas()+";";
        grabar+=cir.getDistancia()+";";
        grabar+=cir.getRecordvuelta()+";";
        
        this.escribir(grabar);
    }
    public void borraCircuito(Circuito cir){
        this.eliminarCircuitoLista(cir);
    }
    private void eliminarCircuitoLista(Circuito cir){
        List<Circuito> l=this.getListaCircuitos();
        for(Circuito e:l){
            if(cir.getNombre().equals(e.getNombre())){
                this.ListaCircuitos.remove(e);
                break;
            }
        }
        this.actualizarFichero();
    }
    
    private void modificarCircuitoLista(Circuito cir){
        List<Circuito> l=this.getListaCircuitos();
        int i=0;
        for(Circuito e:l){
            if(cir.getNombre().equals(e.getNombre())){
                //this.listaCircuitos.remove(e);
                this.ListaCircuitos.set(i, cir);
                break;
            }
            i++;
        }
        this.actualizarFichero();
    }
    public Circuito introduceIdcircuito(String idcircuito){
        Circuito cir=null;
        for(Circuito e:this.getListaCircuitos()){
            if(e.getNombre().equals(idcircuito)){
                cir=e;
            }
        }
        return cir;
    }
    
}
