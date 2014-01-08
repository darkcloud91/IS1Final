import entidades.Piloto;
import entidades.Posicion;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import registros.RegistroClasificaciones;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAMISHO
 */
public class PruebaConsultas {
    public static void main(String [] arg) throws ParseException {
        RegistroClasificaciones rC= new RegistroClasificaciones();
        List<Posicion> lista=new ArrayList<Posicion>();
        
        Posicion p0= new Posicion("2014","GP1");
        Posicion p1= new Posicion("2014","GP1");
        Posicion p2= new Posicion("2014","GP1");
        Posicion p3= new Posicion("2014","GP1");
        Posicion p4= new Posicion("2014","GP1");
        Posicion p5= new Posicion("2014","GP1");
        Posicion p6= new Posicion("2014","GP1");
        Posicion p7= new Posicion("2014","GP1");
        Posicion p8= new Posicion("2014","GP1");
        Posicion p9= new Posicion("2014","GP1");
        Posicion p10= new Posicion("2014","GP1");
        Posicion p11= new Posicion("2014","GP1");
        Posicion p12= new Posicion("2014","GP1");
        Posicion p13= new Posicion("2014","GP1");
        Posicion p14= new Posicion("2014","GP1");
        Posicion p15= new Posicion("2014","GP1");
        Posicion p16= new Posicion("2014","GP1");
        Posicion p17= new Posicion("2014","GP1");
        Posicion p18= new Posicion("2014","GP1");
        Posicion p19= new Posicion("2014","GP1");
        Posicion p20= new Posicion("2014","GP1");
        Posicion p21= new Posicion("2014","GP1");
        
        Piloto pil1=new Piloto("PIL-1","E1");
        Piloto pil2=new Piloto("PIL-2","E1");
        Piloto pil3=new Piloto("PIL-3","E2");
        Piloto pil4=new Piloto("PIL-4","E2");
        Piloto pil5=new Piloto("PIL-5","E3");
        Piloto pil6=new Piloto("PIL-6","E3");
        Piloto pil7=new Piloto("PIL-7","E4");
        Piloto pil8=new Piloto("PIL-8","E4");
        Piloto pil9=new Piloto("PIL-9","E5");
        Piloto pil10=new Piloto("PIL-10","E5");
        Piloto pil11=new Piloto("PIL-11","E6");
        Piloto pil12=new Piloto("PIL-12","E6");
        Piloto pil13=new Piloto("PIL-13","E7");
        Piloto pil14=new Piloto("PIL-14","E7");
        Piloto pil15=new Piloto("PIL-15","E8");
        Piloto pil16=new Piloto("PIL-16","E8");
        Piloto pil17=new Piloto("PIL-17","E9");
        Piloto pil18=new Piloto("PIL-18","E9");
        Piloto pil19=new Piloto("PIL-19","E10");
        Piloto pil20=new Piloto("PIL-20","E10");
        Piloto pil21=new Piloto("PIL-21","E11");
        Piloto pil22=new Piloto("PIL-22","E11");
        
        p0.setPiloto(pil1);
        p0.setPosicion(1);
        p1.setPiloto(pil2);
        p1.setPosicion(2);
        p2.setPiloto(pil3);
        p2.setPosicion(3);
        p3.setPiloto(pil4);
        p3.setPosicion(4);
        p4.setPiloto(pil5);
        p4.setPosicion(5);
        p5.setPiloto(pil6);
        p5.setPosicion(6);
        p6.setPiloto(pil7);
        p6.setPosicion(7);
        p7.setPiloto(pil8);
        p7.setPosicion(8);
        p8.setPiloto(pil9);
        p8.setPosicion(9);
        p9.setPiloto(pil10);
        p9.setPosicion(10);
        p10.setPiloto(pil11);
        p10.setPosicion(11);
        p11.setPiloto(pil12);
        p11.setPosicion(12);
        p12.setPiloto(pil13);
        p12.setPosicion(13);
        p13.setPiloto(pil14);
        p13.setPosicion(14);
        p14.setPiloto(pil15);
        p14.setPosicion(15);
        p15.setPiloto(pil16);
        p15.setPosicion(16);
        p16.setPiloto(pil17);
        p16.setPosicion(17);
        p17.setPiloto(pil18);
        p17.setPosicion(18);
        p18.setPiloto(pil19);
        p18.setPosicion(19);
        p19.setPiloto(pil20);
        p19.setPosicion(20);
        p20.setPiloto(pil21);
        p20.setPosicion(21);
        p21.setPiloto(pil22);
        p21.setPosicion(22);
        
        //Almacenamos resultados
        
        lista.add(p0);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p7);
        lista.add(p8);
        lista.add(p9);
        lista.add(p10);
        lista.add(p11);
        lista.add(p12);
        lista.add(p13);
        lista.add(p14);
        lista.add(p15);
        lista.add(p16);
        lista.add(p17);
        lista.add(p18);
        lista.add(p19);
        lista.add(p20);
        lista.add(p21);
        
        //añadimos otro gp
        Posicion p22= new Posicion("2014","GP2");
        Posicion p23= new Posicion("2014","GP2");
        Posicion p24= new Posicion("2014","GP2");
        Posicion p25= new Posicion("2014","GP2");
        Posicion p26= new Posicion("2014","GP2");
        Posicion p27= new Posicion("2014","GP2");
        Posicion p28= new Posicion("2014","GP2");
        Posicion p29= new Posicion("2014","GP2");
        Posicion p30= new Posicion("2014","GP2");
        Posicion p31= new Posicion("2014","GP2");
        Posicion p32= new Posicion("2014","GP2");
        Posicion p33= new Posicion("2014","GP2");
        Posicion p34= new Posicion("2014","GP2");
        Posicion p35= new Posicion("2014","GP2");
        Posicion p36= new Posicion("2014","GP2");
        Posicion p37= new Posicion("2014","GP2");
        Posicion p38= new Posicion("2014","GP2");
        Posicion p39= new Posicion("2014","GP2");
        Posicion p40= new Posicion("2014","GP2");
        Posicion p41= new Posicion("2014","GP2");
        Posicion p42= new Posicion("2014","GP2");
        Posicion p43= new Posicion("2014","GP2");
        
        //metemos los pilotos en los nuevos resultados
        p22.setPiloto(pil1);
        p22.setPosicion(1);
        p23.setPiloto(pil2);
        p23.setPosicion(2);
        p24.setPiloto(pil3);
        p24.setPosicion(3);
        p25.setPiloto(pil4);
        p25.setPosicion(4);
        p26.setPiloto(pil5);
        p26.setPosicion(5);
        p27.setPiloto(pil6);
        p27.setPosicion(6);
        p28.setPiloto(pil7);
        p28.setPosicion(7);
        p29.setPiloto(pil8);
        p29.setPosicion(8);
        p30.setPiloto(pil9);
        p30.setPosicion(9);
        p31.setPiloto(pil10);
        p31.setPosicion(10);
        p32.setPiloto(pil11);
        p32.setPosicion(11);
        p33.setPiloto(pil12);
        p33.setPosicion(12);
        p34.setPiloto(pil13);
        p34.setPosicion(13);
        p35.setPiloto(pil14);
        p35.setPosicion(14);
        p36.setPiloto(pil15);
        p36.setPosicion(15);
        p37.setPiloto(pil16);
        p37.setPosicion(16);
        p38.setPiloto(pil17);
        p38.setPosicion(17);
        p39.setPiloto(pil18);
        p39.setPosicion(18);
        p40.setPiloto(pil19);
        p40.setPosicion(19);
        p41.setPiloto(pil20);
        p41.setPosicion(20);
        p42.setPiloto(pil21);
        p42.setPosicion(21);
        p43.setPiloto(pil22);
        p43.setPosicion(22);
        
        //almacenamos los resultados de GP2
        //Almacenamos resultados
        
        lista.add(p22);
        lista.add(p23);
        lista.add(p24);
        lista.add(p25);
        lista.add(p26);
        lista.add(p27);
        lista.add(p28);
        lista.add(p29);
        lista.add(p30);
        lista.add(p31);
        lista.add(p32);
        lista.add(p33);
        lista.add(p34);
        lista.add(p35);
        lista.add(p36);
        lista.add(p37);
        lista.add(p38);
        lista.add(p39);
        lista.add(p40);
        lista.add(p41);
        lista.add(p42);
        lista.add(p43);
        
       //añadimos al registro
        rC.setListaPosiciones(lista);
        
        //ahora operamos y vemos si funcionan las operaciones de consulta
        
        //hacemos funcion de F1
        
        List<Posicion> posiciones=rC.obtenerListaPosicionesCM("2014");
        p0.mostrarClasificacionEscuderiasCM(posiciones);
        p0.mostrarClasificacionPilotosCM(posiciones);
    }
    
}