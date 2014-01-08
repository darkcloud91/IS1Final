/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAMISHO
 */
public class Posicion {
    private String anyo;
    private String nombreGranPremio;
    private Piloto piloto;
    private int posicion;
    
    
    public Posicion(String anyo,String nombreGranPremio,Piloto polito, int posicion){
        this.anyo=anyo;
        this.nombreGranPremio=nombreGranPremio;
        this.piloto=piloto;
        this.posicion=posicion;
    }
    public Posicion(String anyo,String nombreGranPremio){
        this.anyo=anyo;
        this.nombreGranPremio=nombreGranPremio;
        
    }
    
    public void mostrarClasificacionEscuderiasCM(List<Posicion> posiciones){
        int[] puntos={25,18,15,12,10,8,6,4,2,1};
        
        System.out.println("\nLa longitu de el array es :"+puntos.length);
        int i=0;
        List<Escuderia> clasificacion=new ArrayList<Escuderia>();
        
        for(Posicion p:posiciones){
            if(i>21){
                i=0;
            }
            Boolean encontrado=false;
            for(Escuderia e:clasificacion){
                if(e.getNombre().equals(p.getPiloto().getEquipo())){
                    int aux=0;
                    if(i<10){
                        aux=e.getP()+puntos[i];
                        e.setP(aux);
                    }
                    encontrado=true;
                    break;
                }
            }
            if(!encontrado){
                Escuderia esc=new Escuderia(p.getPiloto().getEquipo());
                if(i<10){
                    esc.setP(puntos[i]);
                }else{
                    esc.setP(0);
                }
                
                clasificacion.add(esc);
            }
            if(i<10){
                System.out.println(p.getNombreGranPremio()+" - "+p.getPiloto().getIdPiloto()+":"+p.getPiloto().getEquipo()+" - "+p.getPosicion()+" puntos="+puntos[i]+"\n");
            }else{
                System.out.println(p.getNombreGranPremio()+" - "+p.getPiloto().getIdPiloto()+":"+p.getPiloto().getEquipo()+" - "+p.getPosicion()+" puntos= 0\n");
            }
            i++;
        }
        for(Escuderia e:clasificacion){
            System.out.println("\nEscuderia: "+e.getNombre()+" - "+e.getP());
        }
        
        //ordenar lista en orden de llegada Pilotos
        //asignar puntos y crear lista por escuderias(Escuderia,puntos)
        //generar cadena 
        
        //System.out.println(cadena generada);
    }
    
    
        /*la lista recibida sera generica con la estructura
         *@overwrite
         * Escuderia Nombre=Lo sacamos de los pilotos.equipo
         * puntos
         */
    private String cadenaClasificacionEscuderiasCM(List posiciones){
        String cadenaPosiciones="";
        
        return cadenaPosiciones;
    }
    
     public void mostrarClasificacionPilotosCM(List<Posicion> posiciones){
        int[] puntos={25,18,15,12,10,8,6,4,2,1};
        
        System.out.println("\nLa longitu de el array es :"+puntos.length);
        int i=0;
        List<Piloto> clasificacion=new ArrayList<Piloto>();
        
        for(Posicion p:posiciones){
            if(i>21){
                i=0;
            }
            Boolean encontrado=false;
            for(Piloto pl:clasificacion){
                if(pl.getIdPiloto().equals(p.getPiloto().getIdPiloto())){
                    int aux=0;
                    if(i<10){
                        aux=pl.getP()+puntos[i];
                        pl.setP(aux);
                    }
                    encontrado=true;
                    break;
                }
            }
            if(!encontrado){
                Piloto piloto=new Piloto(p.getPiloto().getIdPiloto(),p.getPiloto().getEquipo());
                if(i<10){
                    piloto.setP(puntos[i]);
                }else{
                    piloto.setP(0);
                }
                
                clasificacion.add(piloto);
            }
            /*if(i<10){
                System.out.println(p.getNombreGranPremio()+" - "+p.getPiloto().getIdPiloto()+":"+p.getPiloto().getEquipo()+" - "+p.getPosicion()+" puntos="+puntos[i]+"\n");
            }else{
                System.out.println(p.getNombreGranPremio()+" - "+p.getPiloto().getIdPiloto()+":"+p.getPiloto().getEquipo()+" - "+p.getPosicion()+" puntos= 0\n");
            }*/
            i++;
        }
        for(Piloto pl:clasificacion){
            System.out.println("\nPiloto: "+pl.getIdPiloto()+":"+pl.getEquipo()+" - "+pl.getP());
        }
         
         
         //System.out.println(cadena generada);
    }
    
    
        /*la lista recibida sera generica con la estructura
         *@overwrite
         * Pilotos
         * puntos
         */
    private String cadenaClasificacionPilotosCM(List posiciones){
        String cadenaPosiciones="";
        //generamos cadena a partir del array y revoyvemos
        return cadenaPosiciones;
    }
    
    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getNombreGranPremio() {
        return nombreGranPremio;
    }

    public void setNombreGranPremio(String nombreGranPremio) {
        this.nombreGranPremio = nombreGranPremio;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto =piloto;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public void introducirDatosPosicion(String anyo,String nombreGranPremio, Piloto piloto, int posicion){
        this.anyo=anyo;
        this.nombreGranPremio=nombreGranPremio;
        this.piloto=piloto;
        this.posicion=posicion;
    }
}
