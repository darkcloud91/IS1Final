
import controlador.Formula1;
import entidades.CampeonatoMundial;
import registros.RegistroEscuderias;
import registros.RegistroPilotos;
import java.util.List;
import java.util.ArrayList;
import entidades.Escuderia;
import entidades.Piloto;
import interfaz.Pantalla;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAMISHO
 */
public class pruebaMain {
    public static void main(String [] arg) throws ParseException {
        
    /*
        //creamos una lista de pilotos activos
        //como solo son string que contienen claves lo creamos
        //directamente para pruebas
        List<String> pilotosActivos=new ArrayList<String>();
        pilotosActivos.add("PIL1");
        pilotosActivos.add("PIL3");
        
        //creamos los pilotos y los metemos en una lista
        List<Piloto> pilotos=new ArrayList<Piloto>();
        Piloto p1=new Piloto("PIL-1");
        Piloto p2=new Piloto("PIL-2");
        Piloto p3=new Piloto("PIL-3");
        Piloto p4=new Piloto("PIL-4");
        pilotos.add(p1);
        pilotos.add(p2);
        pilotos.add(p3);
        pilotos.add(p4);
        
        //como decidimos meter la fecha de creacion como tipo
        //Date debemos hacer una convercion de String a date
        //poner atencion en el throws Parse... de arriba
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	String dateInString = "7-Jun-2013";
        Date date = formatter.parse(dateInString);

        //creamos una escuderia sin pilotos porque
        //aun no se hace la implememntacion de
        //pilotos, se descomenta una vez ya esté
        Escuderia esc=new Escuderia();
        esc.introducirDatos(pilotos,pilotosActivos, "Escuderia 1", "Sede 1", "Chasis 1", "Motor 1", "Neumatico 1", "1990", "7-Jun-2013");
        
        //ahora para guardar en el fichero, creamos un 
        //registro y le pasamos la escuderia que
        //queremos grabar
        RegistroEscuderias rE=new RegistroEscuderias();
        //--rE.guardarEscuderia(esc);
        //rE.LeeFichero();
        //rE.escribir("text de prueba");
        
        //por ultimo leo el fichero para ver
        //si lo guarda en el formato deseado
        //--rE.LeeFichero();
        
        List<Escuderia> escuderias=new ArrayList<Escuderia>();
        escuderias=rE.cargarEscuderias();
        
        Escuderia esc1=escuderias.get(0);
        
        esc1.mostrarDatos(esc1);*/
        
        
        
        /* Simulacion de grasp */
        
        Formula1 f1=new Formula1(); //creo el controlador
        
        
        
        
        
        
        f1.cargarDatosEscuderias();//cargamos los datos de los ficheros
        f1.cargarDatosPilotos();
        f1.cargarDatosGrandesPremios();
        f1.cargarDatosCM();
        //f1.cargarDatosCircuitos();
        
        
        //creamos una pantalla para que sirva de interfaz
        
        Pantalla p1=new Pantalla(f1);
        
        //inicia la ejecucion de pantantalla
        p1.menuPrincipal();
        
    }
    
}
