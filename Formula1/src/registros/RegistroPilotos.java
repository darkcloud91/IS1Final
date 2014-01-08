/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package registros;
import entidades.Escuderia;
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
public class RegistroPilotos {
    List<Piloto> listaPilotos;
    String ruta;
    File archivo;
    FileReader fr;
    BufferedReader br;
    
    public RegistroPilotos(){
        listaPilotos=new ArrayList<Piloto>();
        ruta="src/registros/";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
    }
    
    private void LeeFichero() {
        try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
           archivo = new File (this.ruta+"R_Piloto.txt");
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
    
    public void guardarPiloto(Piloto p){
       this.listaPilotos.add(p);
        String grabar="";
          
        grabar+=p.getNombre()+";";
        grabar+=p.getApellido()+";";
        grabar+=p.getIdPiloto()+";";
        grabar+=p.getEquipo()+";";
        grabar+=p.getEquipoAnterior()+";";
        grabar+=p.getNacionalidad()+";";
        grabar+=p.getFechaNacimiento();
        
        this.escribir(grabar);
    }
    
    public void guardarPilotoModificado(Piloto p){
       this.modificarPilotoLista(p);
    }
    
    private void escribir(String cadena){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(this.ruta+"R_Piloto.txt",true);
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
    
    public Piloto introduceIdPiloto(String idPiloto){
        Piloto p=null;
        for(Piloto e:this.getListaPilotos()){
            if(e.getIdPiloto().equals(idPiloto)){
                p=e;
            }
        }
        return p;
    }
    
    public void borraPiloto(Piloto p){
        this.eliminarPilotoLista(p);
    }
        public void cargarPilotos(){
        List<Piloto> pil=new ArrayList<Piloto>();
        List<String> lineas=new ArrayList<String>();
        try {
       
           archivo = new File (this.ruta+"R_Piloto.txt");
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
      
        if(!lineas.isEmpty()){
            for(String a:lineas){
                String[] atr;
                Piloto piloto=new Piloto();
                atr=a.split(";");
                             
                            
                
                piloto.setNombre(atr[0]);
                piloto.setApellido(atr[1]);
                piloto.setIdPiloto(atr[2]);
                piloto.setEquipo(atr[3]);
                piloto.setEquipoAnterior(atr[4]);
                piloto.setNacionalidad(atr[5]);
                piloto.setFechaNacimiento(atr[6]);
                
                pil.add(piloto);
            }
        }else{
            System.out.println("No existen pilotos");
        }
        
        //return esc;
        this.listaPilotos=pil;
    }

    public List<Piloto> getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(List<Piloto> listaPilotos) {
        this.listaPilotos = listaPilotos;
    }
    
    private void eliminarPilotoLista(Piloto p){
        List<Piloto> l=this.getListaPilotos();
        for(Piloto pil:l){
            if(p.getIdPiloto().equals(pil.getIdPiloto())){
                this.listaPilotos.remove(pil);
                break;
            }
        }
        this.actualizarFichero();
    }
    
    private void modificarPilotoLista(Piloto p){
        List<Piloto> l=this.getListaPilotos();
        int i=0;
        for(Piloto pil:l){
            if(p.getIdPiloto().equals(pil.getIdPiloto())){
                //this.listaEscuderias.remove(e);
                this.listaPilotos.remove(pil);
                //this.listaPilotos.set(i, p);
                this.listaPilotos.add(p);
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
            fichero = new FileWriter(this.ruta+"R_Piloto.txt");
            pw = new PrintWriter(fichero);

            int cont=this.getListaPilotos().size();
            int i;
            for(i=0;i<cont;i++){
                Piloto p=this.getListaPilotos().get(i);
               this.guardarPiloto(p); 
            }
            
 
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
    public Piloto getpiloto(String idpiloto){
        Piloto piloto=new Piloto();
        for(Piloto gp:this.getListaPilotos()){
            if(gp.getIdPiloto().equals(idpiloto)){
                piloto=gp;
                break;
            }
        }
    return piloto;
    }
            
}

