/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author MAMISHO
 */
public class Circuito {
    private String idcircuito;
    private String nombre;
    private String ubicacion;
    private int longitud;
    private int nvueltas;
    private int distancia;
    private int recordvuelta;

    public Circuito() {
    }

    /*public Circuito(/*String idcircuitos, String nombre, String ubicacion, int longitud, int nvueltas, int distancia, int recordvuelta) {
        //this.idcircuitos = idcircuitos;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.longitud = longitud;
        this.nvueltas = nvueltas;
        this.distancia = distancia;
        this.recordvuelta = recordvuelta;
    }*/
    public void introducirDatos(String idcircuito, String nombre, String ubicacion, int longitud, int nvueltas, int distancia, int recordvuelta) {
        this.idcircuito = idcircuito;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.longitud = longitud;
        this.nvueltas = nvueltas;
        this.distancia = distancia;
        this.recordvuelta = recordvuelta;
    }
    public void modificarDatos(String idcircuito, String nombre, String ubicacion, int longitud, int nvueltas, int distancia, int recordvuelta) {
        this.idcircuito = idcircuito;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.longitud = longitud;
        this.nvueltas = nvueltas;
        this.distancia = distancia;
        this.recordvuelta = recordvuelta;
    }
    public void muestradatos(Circuito cir){
        System.out.println(this.toString(cir));
        
    }

    
    public String toString(Circuito cir) {
        return "Circuito{" + "idcircuitos=" + idcircuito + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", longitud=" + longitud + ", nvueltas=" + nvueltas + ", distancia=" + distancia + ", recordvuelta=" + recordvuelta + '}';
    }
    

    public String getIdcircuito() {
        return idcircuito;
    }

    public void setIdcircuito(String idcircuito) {
        this.idcircuito = idcircuito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getNvueltas() {
        return nvueltas;
    }

    public void setNvueltas(int nvueltas) {
        this.nvueltas = nvueltas;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getRecordvuelta() {
        return recordvuelta;
    }

    public void setRecordvuelta(int recordvuelta) {
        this.recordvuelta = recordvuelta;
    }
    
    
}