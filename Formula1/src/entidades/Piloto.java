/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import java.util.Date;


/**
 *
 * @author MAMISHO
 */
public class Piloto {
    String idPiloto;
    String nombre;
    String apellido;
    String equipo;
    String equipoAnterior;
    String nacionalidad;
    String fechaNacimiento;
    int p;
    
    
    public Piloto(){
    
    }
    
    public Piloto(String idPiloto){
        this.idPiloto=idPiloto;
    }
    
    
    public Piloto(String idPiloto,String equipo){
        this.idPiloto=idPiloto;
        this.equipo=equipo;
    }
    
    public void introducirDatos(String nombre,String apellido,String idPiloto,String equipo,
    String equipoAnterior,String nacionalidad, String fechaNacimiento){
    this.nombre=nombre;
    this.apellido=apellido;
    this.idPiloto=idPiloto;
    this.equipo=equipo;
    this.equipoAnterior=equipoAnterior;
    this.nacionalidad=nacionalidad;
    this.fechaNacimiento=fechaNacimiento;
  
    }
    
     public void cambiarDatos(String nombre,String apellido,String idPiloto,String equipo,
    String equipoAnterior,String nacionalidad, String fechaNacimiento){
    this.nombre=nombre;
    this.apellido=apellido;
    this.idPiloto=idPiloto;
    this.equipo=equipo;
    this.equipoAnterior=equipoAnterior;
    this.nacionalidad=nacionalidad;
    this.fechaNacimiento=fechaNacimiento;
  
    }
    
    public void mostrarDatos(Piloto p){
        System.out.println(this.toString(p));
    }
    
    public String toString(Piloto p){
    String datosPiloto="Piloto\nNombre: "+p.nombre+"\nApellido: "+p.apellido+"\nIdPiloto: "+p.idPiloto+
            "\nEquipo actual: "+p.equipo+"\nEquipo anterior: "+p.equipoAnterior+"\nNacionalidad: "+
            p.nacionalidad+"\nFecha de nacimiento: "+p.fechaNacimiento+"\n";
    return datosPiloto;
    }
    public String getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(String idPiloto) {
        this.idPiloto = idPiloto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getEquipoAnterior() {
        return equipoAnterior;
    }

    public void setEquipoAnterior(String equipoAnterior) {
        this.equipoAnterior = equipoAnterior;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int getP() {
        return this.p;
    }

    public void setP(int p) {
        this.p=p;
    }
    
}

