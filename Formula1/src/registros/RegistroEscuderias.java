/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;
import entidades.Escuderia;
import entidades.Piloto;
import java.io.*;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
//import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MAMISHO
 */
public class RegistroEscuderias {
    List<Escuderia> listaEscuderias;
    String ruta;
    File archivo;
    FileReader fr;
    BufferedReader br;
    
    public RegistroEscuderias(){
        listaEscuderias=new ArrayList<Escuderia>();
        ruta="src/registros/";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
    }
    
    private void LeeFichero() {
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (this.ruta+"R_Escuderia.txt");
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
    
    public void guardarEscuderia(Escuderia esc){
        this.listaEscuderias.add(esc);
        String grabar="";
        String pilotos="PIL1:PIL2:PIL3:PIL4:";
        /*for(Piloto piloto:esc.getPilotos()){
            pilotos+=piloto.getIdPiloto()+":";
        }*/
        pilotos=pilotos.substring(0, pilotos.length()-1);
        
        grabar+=esc.getNombre()+";";
        grabar+=pilotos+";";
        grabar+=esc.getIdPilotosActivos().get(0)+":";
        grabar+=esc.getIdPilotosActivos().get(1)+";";
        grabar+=esc.getSede()+";";
        grabar+=esc.getChasis()+";";
        grabar+=esc.getMotor()+";";
        grabar+=esc.getNeumaticos()+";";
        grabar+=esc.getPrimeraTemporada()+";";
        grabar+=esc.getFechaCrea();
        
        this.escribir(grabar);
    }
    
    public void guardarEscuderiaModificada(Escuderia esc){
       this.modificarEscuderiaLista(esc);
    }
    
    private void escribir(String cadena){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.ruta+"R_Escuderia.txt",true);
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
    
    public Escuderia introduceIdEscuderia(String idescuderia){
        Escuderia esc=null;
        for(Escuderia e:this.getListaEscuderias()){
            if(e.getNombre().equals(idescuderia)){
                esc=e;
            }
        }
        return esc;
    }
    
    public void borraEscuderia(Escuderia esc){
        this.eliminarEscuderiaLista(esc);
    }
    
    public void cargarEscuderias(){
        List<Escuderia> esc=new ArrayList<Escuderia>();
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
                Escuderia escuderia=new Escuderia();
                atr=a.split(";");
                escuderia.setNombre(atr[0]);
                
                //atr[1] son los pilotos, pero no los construyo
                //hasta que lo implementen
                
                String[] pActivos=atr[2].split(":");
                List<String> pilotosActivos=new ArrayList<String>();
                pilotosActivos.add(pActivos[0]);
                pilotosActivos.add(pActivos[1]);
                
                escuderia.setIdPilotosActivos(pilotosActivos);
                
                escuderia.setSede(atr[3]);
                escuderia.setChasis(atr[4]);
                escuderia.setMotor(atr[5]);
                escuderia.setNeumaticos(atr[6]);
                escuderia.setPrimeraTemporada(atr[7]);
                
                //la fecha la convertimos
                /*SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                String dateInString = atr[8];
                Date date = null;
                try {
                    date = formatter.parse(dateInString);
                } catch (ParseException ex) {
                    Logger.getLogger(RegistroEscuderias.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                escuderia.setFechaCrea(atr[7]);
                
                esc.add(escuderia);
            }
        }else{
            System.out.println("No existen escuderias");
        }
        
        //return esc;
        this.listaEscuderias=esc;
    }

    public List<Escuderia> getListaEscuderias() {
        return listaEscuderias;
    }

    public void setListaEscuderias(List<Escuderia> listaEscuderias) {
        this.listaEscuderias = listaEscuderias;
    }
    
    private void eliminarEscuderiaLista(Escuderia esc){
        List<Escuderia> l=this.getListaEscuderias();
        for(Escuderia e:l){
            if(esc.getNombre().equals(e.getNombre())){
                this.listaEscuderias.remove(e);
                break;
            }
        }
        this.actualizarFichero();
    }
    
    private void modificarEscuderiaLista(Escuderia esc){
        List<Escuderia> l=this.getListaEscuderias();
        int i=0;
        for(Escuderia e:l){
            if(esc.getNombre().equals(e.getNombre())){
                //this.listaEscuderias.remove(e);
                this.listaEscuderias.set(i, esc);
                break;
            }
            i++;
        }
        this.actualizarFichero();
    }
    
    private void actualizarFichero(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.ruta+"R_Escuderia.txt");
            pw = new PrintWriter(fichero);
            int cont=this.getListaEscuderias().size();
            int i;
            for(i=0;i<cont;i++){
                Escuderia e=this.getListaEscuderias().get(i);
               this.guardarEscuderia(e); 
            }
            
            
            /*for(Escuderia e:this.getListaEscuderias()){
                this.guardarEscuderia(e);
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
            
}

