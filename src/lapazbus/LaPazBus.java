/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapazbus;

import Codigo.*;

/**
 *
 * @author Tostadora
 */
public class LaPazBus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        PilaRuta pr = new PilaRuta();
        PilaRuta aux = new PilaRuta();
        Ruta ruta1 = Creacion();

        pr.adiElem(ruta1);
        aux.adiElem(ruta1);
        Manipular(aux);
        // manipulacion almacenamiento de datos
        
        Archivos arch = new Archivos();
        
        arch.crearCarpeta();
           
        arch.crearCarpeta("Ruta");
        arch.crearCarpeta("Solicitudes");
        
        System.out.println("----------------------");
        System.out.println("|Creando datos en Ruta|");
        System.out.println("----------------------");
        
        Ruta rt = pr.eliminar();
        // @param direccion = direccion donde se crearan las carpetas y archivos modifica
        String direccion = "Ruta";
        // crear carpeta ruta donde se almacenaran todos los objetos
        arch.crearCarpeta("Ruta",rt.getNombreRuta());
        direccion += "\\"+rt.getNombreRuta();
        //@param direccionP = la direccon principal no cambia
        String direccionP = direccion;
        //Inicio de creacion de buses en la ruta
        arch.crearCarpeta(direccion,"Bus");
        direccion +="\\Bus"; 
        for (int i = 0; i < rt.getBcant()-1; i++) {
            
            Bus b = rt.getBuses();
            
            arch.crearCarpeta(direccion,String.valueOf(b.getCodigo()));
          
            direccion += "\\"+String.valueOf(b.getCodigo());
            String data = b.getCodigo()+"\n"+b.getAñoEmpleo();
            arch.crearArchivos(direccion,"Data",data);
                
            //agrega los acientos del bus
            arch.crearCarpeta(direccion,"Asiento");
            for (int j = 0; j < b.getAcant(); j++) {
                Asiento a = b.getAsiento();
                data =  a.getTipo()+"\n"+a.isEstado()+"\n"+a.isSeccion();
                arch.crearArchivos(direccion+"\\Asiento",j+a.getTipo(), data);
                
            }
            
            //agrega persona del bus
            arch.crearCarpeta(direccion,"Personal");
            for (int j = 0; j < b.getDPcant()-1; j++) {
                DatosPersonal per = b.getDp();
                data = per.getCi()+"\n"+per.getNombre()+"\n"+per.getEdad()+"\n"+per.getCargo();
                arch.crearArchivos(direccion+"\\Personal",per.getCi(),data);
                
            }
            
        }
        //fin de creacion de buses en la ruta
    
        //Creacion de paradas
        direccion = direccionP;
        arch.crearCarpeta(direccion,"Parada");
        direccion +="\\Parada"; 
        int sw = 0;
        String CZona="";
        String data;
        for (int i = 0; i < rt.getPcant(); i++) {
            Parada p = rt.getP();
            String Zona = p.getZona();
            if (Zona==CZona) {
                if (sw==0) {
                    arch.crearCarpeta(direccion, Zona);
                    sw=1;
                }
                arch.crearArchivos(direccion+"\\"+Zona,p.getCalle(),p.getCalle());
               
            }
            else{
                CZona = Zona;
                arch.crearCarpeta(direccion, Zona);
                 arch.crearArchivos(direccion+"\\"+Zona,p.getCalle(),p.getCalle());
            }
        }
    }
    
    
    public static Ruta Creacion(){
        
        
        
        DatosPersonal[] pv = new DatosPersonal[2];
            DatosPersonal persona = new DatosPersonal("Pepe","15937","Conductor", 10);
            pv[0] = persona;
            persona = new DatosPersonal("Juan","8462","Contador", 15);
            pv[1] = persona;
            
            Asiento[] av = new Asiento[20];
            Asiento a = new Asiento(true,"normal", true);
            av[0] = a;
            a = new Asiento(true,"normal", true);
            av[1] = a;
            a = new Asiento(true,"normal", true);
            av[2] = a;
            a = new Asiento(true,"normal", true);
            av[3] = a;
            a = new Asiento(true,"normal", true);
            av[4] = a;
            a = new Asiento(true,"normal", true);
            av[5] = a;
            a = new Asiento(true,"normal", true);
            av[6] = a;
            a = new Asiento(true,"normal", true);
            av[7] = a;
            a = new Asiento(true,"normal", true);
            av[8] = a;
            a = new Asiento(true,"normal", true);
            av[9] = a;
            a = new Asiento(true,"normal", true);
            av[10] = a;
            a = new Asiento(true,"normal", true);
            av[11] = a;
            a = new Asiento(true,"normal", true);
            av[12] = a;
            a = new Asiento(true,"normal", true);
            av[13] = a;
            a = new Asiento(true,"normal", true);
            av[14] = a;
            a = new Asiento(true,"preferencial", false);
            av[15] = a;
            a = new Asiento(true,"preferencial", false);
            av[16] = a;
            a = new Asiento(true,"preferencial", false);
            av[17] = a;
            a = new Asiento(true,"preferencial", false);
            av[18] = a;
            a = new Asiento(true,"preferencial", false);
            av[19] = a;
            
        Bus bus = new Bus(pv, av, 0, 2005);
        
        
        pv = new DatosPersonal[3];
            persona = new DatosPersonal("Tori","15937","Conductor", 10);
            pv[0] = persona;
            persona = new DatosPersonal("Jhon","8462","Contador", 15);
            pv[1] = persona;
            
            av = new Asiento[20];
            a = new Asiento(true,"normal", true);
            av[0] = a;
            a = new Asiento(true,"normal", true);
            av[1] = a;
            a = new Asiento(true,"normal", true);
            av[2] = a;
            a = new Asiento(true,"normal", true);
            av[3] = a;
            a = new Asiento(true,"normal", true);
            av[4] = a;
            a = new Asiento(true,"normal", true);
            av[5] = a;
            a = new Asiento(true,"normal", true);
            av[6] = a;
            a = new Asiento(true,"normal", true);
            av[7] = a;
            a = new Asiento(true,"normal", true);
            av[8] = a;
            a = new Asiento(true,"normal", true);
            av[9] = a;
            a = new Asiento(true,"normal", true);
            av[10] = a;
            a = new Asiento(true,"normal", true);
            av[11] = a;
            a = new Asiento(true,"normal", true);
            av[12] = a;
            a = new Asiento(true,"normal", true);
            av[13] = a;
            a = new Asiento(true,"normal", true);
            av[14] = a;
            a = new Asiento(true,"preferencial", false);
            av[15] = a;
            a = new Asiento(true,"preferencial", false);
            av[16] = a;
            a = new Asiento(true,"preferencial", false);
            av[17] = a;
            a = new Asiento(true,"preferencial", false);
            av[18] = a;
            a = new Asiento(true,"preferencial", false);
            av[19] = a;
            
        Bus bus1 = new Bus(pv, av, 01, 2006);
        
        Bus[] busv = new Bus[2];
        busv[0] = bus;
        busv[1] = bus1;
        Horario[] hv = new Horario[6];
        Horario h = new Horario("04:00", "11:00", 0);
        hv[0] = h;
        h = new Horario("11:00", "13:00", 0);
        hv[1] = h;
        h = new Horario("13:00", "17:00", 0);
        hv[2] = h;
        h = new Horario("17:00", "23:00", 0);
        hv[3] = h;
        h = new Horario("23:00", "04:00", 0);
        hv[4] = h;
        
        Parada[] Pv = new Parada[6];
        Parada p = new Parada("Irpavi","calle 18");
        Pv[0] = p;
        p = new Parada("Irpavi","calle 15");
        Pv[1] = p;
        p = new Parada("Irpavi","San Martin de Porres");
        Pv[2] = p;
        p = new Parada("Irpavi","calle 18");
        Pv[3] = p;
        p = new Parada("Irpavi","calle 3");
        Pv[4] = p;
        p = new Parada("Bolgonia","Univ La Salle");
        Pv[5] = p;
        
        Tarifa[] tv = new Tarifa[8];
            Tarifa t = new Tarifa("Tarjeta","Diurno", 2);
            tv[0]=t;
            t = new Tarifa("Tarjeta","Nocturno",3);
            tv[1]=t;
            t = new Tarifa("Efectivo","Diurno",2.3);
            tv[2]=t;
            t = new Tarifa("Efectivo","Nocturno",3);
            tv[3]=t;
            t = new Tarifa("Preferencial","Diurno",1.5);
            tv[4]=t;
            t = new Tarifa("Preferencial","Nocturno",3);
            tv[5]=t;
            t = new Tarifa("Universitario","Diurno",1.8);
            tv[6]=t;
            t = new Tarifa("Universitario","Nocturno",3);
            tv[7]=t;
        
        Ruta ruta = new Ruta("PUC",busv,hv, Pv, tv);
        
        
        
        
        return ruta;
    }
    
    public static void Manipular(PilaRuta pr){
    
        PilaRuta aux = pr;
        Ruta ruta;
        aux.mostrar();
         
        Ruta rt = aux.eliminar();
        ruta = rt;
        
        
        System.out.println("Horario");
        System.out.println("");
        
        
        for (int i = 0; i < rt.getHcant()-1; i++) {
            Horario h = rt.getH();
            System.out.println("----------------------------");
            System.out.println("Llegada : "+h.getLlegada());
            System.out.println("Salida  : "+h.getSalida());
            System.out.println("----------------------------");
        }
        
        System.out.println("Bus 1");
        Bus bs = rt.getBuses();
        for (int i = 0; i < bs.getDPcant(); i++) {
            DatosPersonal dp = bs.getDp();
            System.out.println("Bus personal :\n Nombre : "+dp.getNombre()+"\n Cargo: "+dp.getCargo());
            
        }
        
        for (int i = 0; i < bs.getAcant(); i++) {
            Asiento as = bs.getAsiento();
            System.out.println("Asiento :"+as.getTipo());
        }
        
        System.out.println("----------------------");
        System.out.println("");
        for (int i = 0; i < ruta.getPcant()-1; i++) {
            Parada pa = ruta.getP();
            System.out.println("Parada :\n"+"Zona :"+ pa.getZona()+"\n Calle : \n"+pa.getCalle());
        }
        System.out.println("");
        System.out.println("Tarifa :");
        
        for (int i = 0; i < ruta.getTcant()-1; i++) {
            Tarifa ta = ruta.getT();
            System.out.println("Turno :"+ta.getTurno()+" Tipo de pago : "+ta.getTipoPago()+"\n Costo :"+ta.getCosto());
            System.out.println("");
        }
        
        
    
    }
    
}
