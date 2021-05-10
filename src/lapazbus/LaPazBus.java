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
        
        
        
        pr.adiElem(ruta);
        pr.mostrar();
        
        Ruta rt = pr.eliminar();
        
        System.out.println("Horario");
        System.out.println("");
        
        
        for (int i = 0; i < rt.getHcant()-1; i++) {
             h = rt.getH();
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
        for (int i = 0; i < ruta.getPcant(); i++) {
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
