/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author zadik
 */
public class GranPremio {
    String nombre;
    String pais;
    Circuito circuito;
    String dia;
    String mes;
    String anyo;
    List<Posicion> posiciones;
    Posicion posicion;
    String idGranPremio;

//     public GranPremio(){
//    
//    }
    
    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public String getIdGranPremio() {
        return idGranPremio;
    }

    public void setIdGranPremio(String idGranPremio) {
        this.idGranPremio = idGranPremio;
    }
    public GranPremio(){
        this.posiciones=new ArrayList<Posicion>();
    
    }
    
    public void introducirDatosGP(String nombre, String pais, Circuito circuito, String dia,
            String mes, String anyo) {
        
        this.nombre = nombre;
        this.pais = pais;
        this.circuito = circuito;
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
        this.idGranPremio=nombre+anyo;
    }
    
   
    public Posicion nuevaPosicion(){
        return this.posicion=new Posicion(this.anyo,this.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }
    
}
