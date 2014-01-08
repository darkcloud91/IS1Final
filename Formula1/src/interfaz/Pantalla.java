/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import controlador.Formula1;
import edi.io.IO;
import entidades.Circuito;
import entidades.GranPremio;
import entidades.Piloto;
import java.util.ArrayList;
//import EntradaSalida;

/**
 *
 * @author MAMISHO
 */
public class Pantalla {
    Formula1 f1;
    
    public Pantalla(Formula1 f1){
        this.f1=f1;
    }
    
    public void menuPrincipal(){
        int op=0;
        Boolean salir=false;
        while(!salir){
        do{
        System.out.println("**** Gestión de fromula1 ****\n");
        System.out.println("1) Gestión Pilotos\n");
        System.out.println("2) Gestión Escuderias\n");
        System.out.println("3) Gestión Circuitos\n");
        //ampliar los demas casos de uso en el menu
        System.out.println("4) Iniciar CM\n");
        System.out.println("5) Insertar Resultados\n");
        System.out.println("6) Ver clasificación de Pilotos en CM\n");
        System.out.println("7) Ver clasificación de Escuderias en CM\n");
        System.out.println("8) Ver clasificación de Pilotos en GP\n");
        System.out.println("9) Ver clasificación de Escuderias en GP\n");
        System.out.println("10) Gestión Salir\n");
        System.out.println("\n_____Selecciona una opción_____\n");
        op=(int)IO.readNumber();        
        
        }
        while(op<1 || op>10);
        
        switch(op){
            case 1:
                System.out.println("Entraste a gestión Pilotos");
                this.menuPilotos();
                break;
            case 2:
                System.out.println("Entraste a gestión Escuderias");
                this.menuEscuderias();
                break;
            case 3:
                System.out.println("Entraste a gestión Circuitos");
                this.menuCircuitos();
                break;
            case 4:
                System.out.println("Entraste a iniciar CM");
                this.inicializarCM();
                break;
            case 5:
                System.out.println("Entraste a insertar Resultados");
                //while(aux){
                this.introducirDatosposicion(solicitarIdGP());
                System.out.println("resultado guardado");
                
                
                
                break;
            case 6:
                System.out.println("\n*** Ver clasificación de Pilotos en CM ***\n");
                this.f1.consultaCPCM();
                break;
            case 7:
                System.out.println("\n*** Ver clasificación de Escuderias en CM ***\n");
                this.f1.consultaCECM();
                break;
            case 8:
                System.out.println("Entraste ver clasificacion pilotos en GP");
                break;
            case 9:
            System.out.println("Entraste ver clasificacion Escuderias en GP");
                break;
            case 10: 
                System.out.println("Selección salir");
                salir=true;
                break;
        }
        }
    }
    
    public void inicializarCM(){
    double numeroGP,i;
    String anyo;
    String nombre;
    String pais;
    Circuito circuito;
    String idCircuito;
    String dia;
    String mes;
    String anyoGP;
    ArrayList<GranPremio> grandesPremios=new ArrayList<GranPremio>();
     this.f1.inicializaCM();
     System.out.println("\nIntroduzca el año en que celebrara el Campeonato Mundial\n");
     anyo=IO.readLine();
     System.out.println("\nIntroduzca el nº de Grandes Premios que tendran lugar.\n"
             + "Este debera estar entre 18 y 20\n");
     numeroGP=IO.readNumber();
     for(i=0;i<numeroGP;i++){
     this.f1.inicializaGP();
    
      System.out.println("**Introduzca los datos del Gran Premio**");
        System.out.println("\nNombre: ");
        nombre=IO.readLine();
        System.out.println("\nPais: ");
        pais=IO.readLine();
        System.out.println("\nId del circuito donde se celebrara: ");
        idCircuito=IO.readLine();
        System.out.println("\nDia: ");
        dia=IO.readLine();
        System.out.println("\nMes: ");
        mes=IO.readLine();
        System.out.println("\nAño: ");
        anyoGP=IO.readLine();
        circuito=this.f1.introduceIdCircuito(idCircuito);
        grandesPremios.add(this.f1.getGranPremio());
        this.f1.introducirDatosGP(nombre, pais, circuito, dia, mes, anyo);
        System.out.println("Gran Premio inicializado correctamente.");
     }
     this.f1.introducirDatosCM(anyo, numeroGP, grandesPremios);
     System.out.println("Campeonato Mundial inicializado correctamente.");
     }
    
   private void menuPilotos(){
        int op=0;
        Boolean salir=false;
        while(!salir){
        do{
        System.out.println("**** Gestión Pilotos ****\n");
        System.out.println("1) Alta Piloto\n");
        System.out.println("2) Baja Piloto\n");
        System.out.println("3) Modificar Piloto\n");
        System.out.println("4) Consultar Piloto\n");
        System.out.println("5) Cambiar Equipo de Piloto\n");
        System.out.println("6) Regresar a menu principal\n");
        System.out.println("\n_____Selecciona una opción_____\n");
        op=(int)IO.readNumber();
        }
        while(op<1 || op>6);
        
        switch(op){
            case 1:
                this.f1.realizarAltaPiloto();
                this.introducirDatosPiloto();
                System.out.println("\nPiloto guardado correctamente");
                break;
            case 2:
                System.out.println("\n** Baja de Piloto **\n");
                this.f1.realizarBajaPiloto(this.solicitarIdPiloto());
                System.out.println("El Piloto se elimino de forma correcta\n");
                break;
            case 3:
                System.out.println("\n** Modificar Piloto **\n");
                this.f1.realizarModificarPiloto(this.solicitarIdPiloto());
                this.ModificarDatosPiloto();
                break;
            case 4:
                System.out.println("\n** Consultar Piloto **\n");
                this.f1.realizarConsultaPiloto(this.solicitarIdPiloto());
                break;
            case 5:
                System.out.println("\n*** Cambio de equipo de piloto ***\n");
                this.f1.cambiarEquipoPiloto(this.solicitarIdPiloto(),this.solicitarId());
                System.out.println("El cambio es correcto\n");
                break;
            case 6:
                salir=true;
                break;
        }
        }
    }
    public void introducirDatosPiloto(){
        String idPiloto;
        String nombre;
        String apellido;
        String equipo;
        String equipoAnterior;
        String nacionalidad;
        String fechaNacimiento;
        
        System.out.println("**Introduzca los datos del Piloto**");
        System.out.println("\nNombre: ");
        nombre=IO.readLine();
        System.out.println("\nApellido: ");
        apellido=IO.readLine();
        System.out.println("\nIdPiloto(formado por las 3 primeras letras del nombre y las "
                + "3 primeras del apellido): ");
        idPiloto=IO.readLine();
        System.out.println("\nEquipo: ");
        equipo=IO.readLine();
        System.out.println("\nEquipo anterior: ");
        equipoAnterior=IO.readLine();
        System.out.println("\nNacionalidad: ");
        nacionalidad=IO.readLine();
        System.out.println("\nFecha nacimiento(dd-mm-yyy): ");
        fechaNacimiento=IO.readLine();
        
       this.f1.introducirDatosPiloto(nombre,apellido,idPiloto,equipo,equipoAnterior,nacionalidad,
               fechaNacimiento);
    }
   
    public void ModificarDatosPiloto(){
        String idPiloto;
        String nombre;
        String apellido;
        String equipo;
        String equipoAnterior;
        String nacionalidad;
        String fechaNacimiento;
       
        System.out.println("**Introduzca nuevos datos de la Escudería**");
         System.out.println("\nNombre: ");
        nombre=IO.readLine();
        System.out.println("\nApellido: ");
        apellido=IO.readLine();
        System.out.println("\nIdPiloto(formado por las 3 primeras letras del nombre y las "
                + "3 primeras del apellido): ");
        idPiloto=IO.readLine();
        System.out.println("\nEquipo: ");
        equipo=IO.readLine();
        System.out.println("\nEquipo anterior: ");
        equipoAnterior=IO.readLine();
        System.out.println("\nNacionalidad: ");
        nacionalidad=IO.readLine();
        System.out.println("\nFecha nacimiento(dd-mm-yyy): ");
        fechaNacimiento=IO.readLine();
        
        this.f1.modificarDatosPiloto(nombre,apellido,idPiloto,equipo,equipoAnterior,nacionalidad,
               fechaNacimiento);
    }
    
    public String solicitarIdPiloto(){
        String idPiloto;
        System.out.println("Introduce el id del piloto\n");
        idPiloto=IO.readLine();
        return idPiloto;
    }
    
    private void menuEscuderias(){
        int op=0;
        Boolean salir=false;
        while(!salir){
        do{
        System.out.println("**** Gestión Escuderías ****\n");
        System.out.println("1) Alta Escudería\n");
        System.out.println("2) Baja Escudería\n");
        System.out.println("3) Modificar Escudería\n");
        System.out.println("4) Consultar Escudería\n");
        System.out.println("5) Cambiar pilotos activos\n");
        System.out.println("6) Regresar a menu principal\n");
        System.out.println("\n_____Selecciona una opción_____\n");
        op=(int)IO.readNumber();
        }
        while(op<1 || op>6);
        
        switch(op){
            case 1:
                this.f1.realizarAltaEscuderia();
                this.introducirDatosEscuderia();
                System.out.println("\nEscuderia guardada correctamente");
                break;
            case 2:
                System.out.println("\n** Baja de Escuderia **\n");
                this.f1.realizarBajaEscuderia(this.solicitarId());
                System.out.println("La escuderia se elimino de forma correcta\n");
                break;
            case 3:
                System.out.println("\n** Modificar Escuderia **\n");
                this.f1.realizarModificarEscuderia(this.solicitarId());
                this.ModificarDatosEscuderia();
                
                break;
            case 4:
                this.f1.realizarConsultaEscuderia(this.solicitarId());
                break;
            case 5:
                System.out.println("\n*** Cambio de pilotos activos ***\n");
                String idEscuderia=this.solicitarId();
                String idPiloto1=this.solicitarIdPiloto("Introduce el id del piloto 1");
                String idPiloto2=this.solicitarIdPiloto("Introduce el id del piloto 2");
                
                this.f1.realizarCambioPilotosActivos(idEscuderia,idPiloto1,idPiloto2);
                System.out.println("El cambio es correcto\n");
                break;
            case 6:
                salir=true;
                break;
        }
        }
    }
    
    public void introducirDatosEscuderia(){
        String nombre;
        String[] idPilotos=new String[4];
        int numPilotos=0;
        String[] idPilotosActivos;
        String sede;
        String chasis;
        String motor;
        String neumaticos;
        String primeraTemporada;
        String fechaCrea;
        Boolean completo=false;
        Boolean otromas=false;
        int contador=0;
        int opcion=1;
        
        System.out.println("**Introduzca los datos de la Escudería**");
        System.out.println("\nNombre: ");
        nombre=IO.readLine();
        System.out.println("\nSede: ");
        sede=IO.readLine();
        System.out.println("\nChasis: ");
        chasis=IO.readLine();
        System.out.println("\nMotor: ");
        motor=IO.readLine();
        System.out.println("\nNeumaticos: ");
        neumaticos=IO.readLine();
        System.out.println("\nPrimera Temporada: ");
        primeraTemporada=IO.readLine();
        System.out.println("\nFecha Creación(dd-mm-yyy): ");
        fechaCrea=IO.readLine();
        
        System.out.println("\n**** Pilotos de la escudería ****");
        while(contador<4 && !otromas){
            System.out.println("\nID del piloto");
            String aux=IO.readLine();
            idPilotos[contador]=aux;
            numPilotos++;
            if(contador>0){//hacer pruebas de index
                do{
                    if(contador<3){
                    System.out.println("\nIngresar otro?\n\t[1=si | 2=no]");
                    opcion=(int)IO.readNumber();
                    }else{
                        opcion=2;
                    }
                    
                }while(opcion<1 || opcion >2);
                
                if(opcion==2){
                    otromas=true;
                }
            }
            contador++;
        }
        
        idPilotosActivos=this.seleccionaPilotosActivos(idPilotos,numPilotos);
        
        
        this.f1.introducirDatosEscuderia(idPilotos, idPilotosActivos, nombre, sede, chasis, motor, neumaticos, primeraTemporada, fechaCrea);
    }
    
    public void ModificarDatosEscuderia(){
        //String nombre;
        //String[] idPilotos=new String[4];
        //int numPilotos=0;
        //String[] idPilotosActivos;
        String sede;
        String chasis;
        String motor;
        String neumaticos;
        String primeraTemporada;
        String fechaCrea;
        //Boolean completo=false;
        //Boolean otromas=false;
        //int contador=0;
        //int opcion=1;
        
        System.out.println("**Introduzca nuevos datos de la Escudería**");
        //System.out.println("\nNombre: ");
        //nombre=IO.readLine();
        System.out.println("\nSede: ");
        sede=IO.readLine();
        System.out.println("\nChasis: ");
        chasis=IO.readLine();
        System.out.println("\nMotor: ");
        motor=IO.readLine();
        System.out.println("\nNeumaticos: ");
        neumaticos=IO.readLine();
        System.out.println("\nPrimera Temporada: ");
        primeraTemporada=IO.readLine();
        System.out.println("\nFecha Creación(dd-mm-yyy): ");
        fechaCrea=IO.readLine();
        
        /*System.out.println("\n**** Pilotos de la escudería ****");
        while(contador<4 && !otromas){
            System.out.println("\nID del piloto");
            String aux=IO.readLine();
            idPilotos[contador]=aux;
            numPilotos++;
            if(contador>0){//hacer pruebas de index
                do{
                    if(contador<3){
                    System.out.println("\nIngresar otro?\n\t[1=si | 2=no]");
                    opcion=(int)IO.readNumber();
                    }else{
                        opcion=2;
                    }
                    
                }while(opcion<1 || opcion >2);
                
                if(opcion==2){
                    otromas=true;
                }
            }
            contador++;
        }*/
        
        //idPilotosActivos=this.seleccionaPilotosActivos(idPilotos,numPilotos);
        
        
        this.f1.modificarDatosEscuderia(/*nombre,*/ sede, chasis, motor, neumaticos, primeraTemporada, fechaCrea);
    }
    
    private String[] seleccionaPilotosActivos(String[] p,int numPilotos){
        String[] pA=new String[2];
        int opcion=0;
        int i;
        int contador=0;
        
        System.out.println("\n**** Selecciona los Pilotos activos ****");
        do{
            do{
                for(i=0;i<numPilotos;i++){
                        System.out.println("\n"+i+") "+p[i]);
                }
             opcion=(int)IO.readNumber();
            }while(opcion<0 || opcion>numPilotos-1);
            
            
            if(contador==0){
                pA[contador]=p[opcion];
                System.out.println("\nSeleccion correcta, ahora selecciona otro");
            }else{
                if(pA[0].equals(p[opcion])){
                    System.out.println("\nYa esta seleccionado, selecciona otro\n");
                    contador--;
                }else{
                    pA[contador]=p[opcion];
                }
            }
            contador++;
        }while(contador<2);
        
        return pA;
    }
    
    public String solicitarId(){
        String idEscuderia;
        System.out.println("Introduce el id de la escuderia\n");
        idEscuderia=IO.readLine();
        //this.f1.realizarBajaEscuderia(idEscuderia);
        return idEscuderia;
    }

    public String solicitarIdPiloto(String mensaje){
        String piloto;
        System.out.println(mensaje);
        piloto=IO.readLine();
        return piloto;
    }

    public void menuCircuitos(){
        int op=0;
        Boolean salir=false;
        while(!salir){
        do{
        System.out.println("**** Gestión Circuitos ****\n");
        System.out.println("1) Alta Circuitoa\n");
        System.out.println("2) Baja Circuito\n");
        System.out.println("3) Modificar Circuito\n");
        System.out.println("4) Consultar Circuito\n");
        System.out.println("5) Regresar a menu principal\n");
        System.out.println("\n_____Selecciona una opción_____\n");
        op=(int)IO.readNumber();
        }
        while(op<1 || op>6);
        
        switch(op){
            case 1:
                this.f1.realizarAltaCircuito();
                this.introducirDatosCircuito();
                System.out.println("\nCircuito guardado correctamente");
                break;
            case 2:
                System.out.println("\n** Baja de Circuito **\n");
                
                
                this.f1.realizarBajaCircuito(solicitarIdCircuito());
                System.out.println("El Circuito se elimino de forma correcta\n");
                break;
            case 3:
                System.out.println("\n** Modificar Circuito **\n");
                
                this.f1.realizarModificarCircuito(solicitarIdCircuito());
                this.ModificarDatosCircuito();
                
                break;
            case 4:
                this.f1.realizarConsultaCircuito(solicitarIdCircuito());
                break;
            case 5:
                salir=true;
                break;
            
        }
        }
    }
    
     public void introducirDatosCircuito(){
        
        
        String idcircuito;
        String nombre;
        String ubicacion;
        int longitud;
        int nvueltas;
        int distancia;
        int recordvuelta;
        Boolean completo=false;
        Boolean otromas=false;
        int contador=0;
        int opcion=1;
        
        System.out.println("**Introduzca los datos del Circuito**");
        System.out.println("\nId del circuito: ");
        idcircuito=IO.readLine();
        System.out.println("\nNombre: ");
        nombre=IO.readLine();
        System.out.println("\nUbicacion: ");
        ubicacion=IO.readLine();
        System.out.println("\nlongitud: ");
        longitud=(int)IO.readNumber();
        System.out.println("\nNumero de vueltas: ");
        nvueltas=(int)IO.readNumber();
        System.out.println("\nDistancia: ");
        distancia=(int)IO.readNumber();
        System.out.println("\nRecord vuelta: ");
        recordvuelta=(int)IO.readNumber();
        this.f1.introducirDatosCircuito(idcircuito,nombre, ubicacion,longitud ,nvueltas , distancia, recordvuelta);
    }
    
    public void ModificarDatosCircuito(){
        
        String idcircuito;
        String nombre;
        String ubicacion;
        int longitud;
        int nvueltas;
        int distancia;
        int recordvuelta;
                
        System.out.println("**Introduzca nuevos datos del Circuito**");
        System.out.println("\nId del circuito: ");
        idcircuito=IO.readLine();
        System.out.println("\nNombre: ");
        nombre=IO.readLine();
        System.out.println("\nUbicacion: ");
        ubicacion=IO.readLine();
        System.out.println("\nlongitud: ");
        longitud=(int)IO.readNumber();
        System.out.println("\nNumero de vueltas: ");
        nvueltas=(int)IO.readNumber();
        System.out.println("\nDistancia: ");
        distancia=(int)IO.readNumber();
        System.out.println("\nRecord vuelta: ");
        recordvuelta=(int)IO.readNumber();
        this.f1.modificarDatosCircuito(idcircuito,nombre, ubicacion,longitud ,nvueltas , distancia, recordvuelta);
    }
    public String solicitarIdCircuito(){
        String idCircuito;
        System.out.println("Introduce el id del circuito\n");
        idCircuito=IO.readLine();
        return idCircuito;
    }  
    public String solicitarIdGP(){
        String idGP;
        System.out.println("Introduce el id Gran Premio\n");
        idGP=IO.readLine();
        return idGP;
    } 
    public void introducirDatosposicion(String idGp){
        String idpiloto;
        int posicion;
       
        
        System.out.println("**Introduzca resultados**");
        System.out.println("\nId del piloto: ");
        idpiloto=IO.readLine();
        System.out.println("\nPosicion: ");
        posicion=(int)IO.readNumber();
        
        this.f1.almacenarResultados(idGp,idpiloto,posicion);
    }
    

}

