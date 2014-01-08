/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author MAMISHO
 */
public class Escuderia {
    //private String idEscuderia; //el nombre es el id
    private List<Piloto> pilotos;
    private List<String> idPilotosActivos;
    private String nombre;
    private String sede;
    private String chasis;
    private String motor;
    private String neumaticos;
    private String primeraTemporada;
    private String fechaCrea;
    private int p;

    public Escuderia(){
        this.pilotos=new ArrayList<Piloto>();
        this.idPilotosActivos=new ArrayList<String>();
    }
    public Escuderia(String nombre){
        this.nombre=nombre;
        this.pilotos=new ArrayList<Piloto>();
        this.idPilotosActivos=new ArrayList<String>();
    }
    public void introducirDatos(/*String idEscuderia,*/List<Piloto> pilotos, List<String>idPilotosActivos,String nombre, String sede,String chasis, String motor,String neumaticos,String primeraTemporada, String fechaCrea){
    	//this.idEscuderia=idEscuderia;
    	this.pilotos=pilotos;
    	this.idPilotosActivos=idPilotosActivos;
        this.nombre=nombre;
        this.sede=sede;
        this.chasis=chasis;
        this.motor=motor;
        this.neumaticos=neumaticos;
        this.primeraTemporada=primeraTemporada;
        this.fechaCrea=fechaCrea;
    }

    public void modificarDatos(/*String nombre,*/String sede, String chasis,String motor, String neumaticos, String primeraTemporada,String fechaCrea){
        //this.nombre=nombre;
        this.sede=sede;
        this.chasis=chasis;
        this.motor=motor;
        this.neumaticos=neumaticos;
        this.primeraTemporada=primeraTemporada;
        this.fechaCrea=fechaCrea;
    }

    public void mostrarDatos(Escuderia esc){
        System.out.println(this.toString(esc));
    }
    
    public void agregarPiloto(Piloto piloto){
        this.pilotos.add(piloto);
    }
    
    public void eliminarPiloto(Piloto piloto){
        this.pilotos.remove(piloto);
    }

    private String toString(Escuderia esc){
        String datosEscuderia;
        /*String pilotosDesc="";
        String pilotoA1=esc.idPilotosActivos.get(0);
        String pilotoA2=esc.idPilotosActivos.get(1);
      
        for(Piloto piloto:esc.pilotos){
            String activo="NO";
            if(pilotoA1.equals(piloto.idPiloto) || pilotoA2.equals(piloto.idPiloto)){
                activo="SI";
            }
            pilotosDesc=pilotosDesc + "Activo : "+ activo + "\n" + piloto.imprimirPiloto();
            
        }*/
        
        datosEscuderia="* Escuderia *\n" + "Nombre: " + esc.nombre + "\nSede: "+esc.sede + "\nChasis: "+esc.chasis+"\nMotor: "+esc.motor+"\nNeumaticos: "+esc.neumaticos+"\nPrimera Temporada: "+esc.primeraTemporada+"\nFecha de creacion: "+  esc.fechaCrea+"\n";
        return datosEscuderia;
    }
    
    public void sustituirPilotos(Piloto p1, Piloto p2){
        for(String p:this.idPilotosActivos){
            if(p.equals(p1.getIdPiloto())){
                //p=;
                this.idPilotosActivos.remove(p);
                this.idPilotosActivos.add(p2.getIdPiloto());
            }
        }
    }

    //añade código por netbeans
    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public List<String> getIdPilotosActivos() {
        return idPilotosActivos;
    }

    public void setIdPilotosActivos(List<String> idPilotosActivos) {
        this.idPilotosActivos = idPilotosActivos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(String neumaticos) {
        this.neumaticos = neumaticos;
    }

    public String getPrimeraTemporada() {
        return primeraTemporada;
    }

    public void setPrimeraTemporada(String primeraTemporada) {
        this.primeraTemporada = primeraTemporada;
    }

    public String getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }
    
    public int getP() {
        return this.p;
    }

    public void setP(int p) {
        this.p=p;
    }
}
