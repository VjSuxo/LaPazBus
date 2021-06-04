/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapazbus;

import Codigo.*;
import EntGrafico.Inicio;

/**
 *
 * @author Tostadora
 */
public class LaPazBus {

    /**
     * @param args the command line arguments
     */
    
    
    static Archivos arch = new Archivos();
    
    public static void main(String[] args) {
        // TODO code application logic here
 
        PilaRuta pr = new PilaRuta();
        PilaRuta aux = new PilaRuta();
        Ruta ruta1 = Creacion();

        Inicio in = new Inicio();
       in.show();
        
        pr.adiElem(ruta1);
        aux.adiElem(ruta1);
        Manipular(aux);
        PersistenciadatosAlmacenamiento(pr);
        System.out.println("--------------------------");
       System.out.println("    Obtencion de datos");
        System.out.println("--------------------------");
        PersistenciaObtencionDatos();
        
    }
    
    
    public static void PersistenciadatosAlmacenamiento(PilaRuta pr){
    
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
        //fin de creacion de paradas
        
        //creacion de horarios
        
        direccion = direccionP;
        arch.crearCarpeta(direccion,"Horario");
        direccion+="\\Horario";
        for (int i = 0; i < rt.getHcant(); i++) {
            Horario hh = rt.getH();
            
            arch.crearArchivos(direccion,i+"Llegada",hh.getLlegada());
            arch.crearArchivos(direccion,i+"Salida",hh.getSalida());
        }
        //fin creacion de horarios
        
        //Creacion tarifa
        direccion = direccionP;
        arch.crearCarpeta(direccion,"Tarifa");
        direccion+="\\Tarifa";
        arch.crearCarpeta(direccion,"Tarjeta");
        arch.crearCarpeta(direccion,"Efectivo");
        arch.crearCarpeta(direccion,"Preferencial");
        arch.crearCarpeta(direccion,"Universitario");
        for (int i = 0; i < rt.getTcant(); i++) {
            Tarifa tr = rt.getT();
            if (tr.getTipoPago().equals("Tarjeta")) {
                arch.crearArchivos(direccion+"\\Tarjeta",tr.getTurno(),String.valueOf(tr.getCosto()));
            }
            if (tr.getTipoPago().equals("Efectivo")) {
                arch.crearArchivos(direccion+"\\Efectivo",tr.getTurno(),String.valueOf(tr.getCosto()));
            }
            if (tr.getTipoPago().equals("Preferencial")) {
                arch.crearArchivos(direccion+"\\Preferencial",tr.getTurno(),String.valueOf(tr.getCosto()));
            }
            if (tr.getTipoPago().equals("Universitario")) {
                arch.crearArchivos(direccion+"\\Universitario",tr.getTurno(),String.valueOf(tr.getCosto()));
            }
            
           
        }
        
    
    
    }
    
    
    // Obtencion de datos
    public static void PersistenciaObtencionDatos(){
        PilaRuta pl = new PilaRuta();
        String direccion="Ruta";
        Archivos arch = new Archivos();
        Bus[] Vbus = null;
        Parada[] Vparada = null;
        Horario[] VHorario = null;
        Tarifa[] VTarifa =  null;
        //Obtencion de buses
        int Ccarpetas = arch.contarCarpeta("Ruta");
        System.out.println(Ccarpetas);
        String[] Vcarpeta = new String[Ccarpetas];
        Vcarpeta = arch.cargarCarpeta(direccion, Vcarpeta);
        
        System.out.println("");
        System.out.println("------Carpetas--------");
        for (int i = 0; i < Ccarpetas; i++) {
            Vbus = cargarBus(direccion+"\\"+Vcarpeta[i]);
            Vparada = cargarParada(direccion+"\\"+Vcarpeta[i]);
            VHorario = cargarHorario(direccion+"\\"+Vcarpeta[i]);
            VTarifa = cargarTarifa(direccion+"\\"+Vcarpeta[i]);
            Ruta r = new Ruta(Vcarpeta[i],Vbus, VHorario, Vparada, VTarifa);
            pl.adiElem(r);
            System.out.println("Se agrego de manera exitosa los datos en la pila");
        }
        System.out.println("----------------------");
        System.out.println("");
        
        
        
    }
    //Obtencion de datos de bus
    public static Bus[] cargarBus(String direccion){
        Bus bus[] = null;
        Asiento[] Vas = null;
        DatosPersonal[] Vdp = null;
        String[] data = null;
        System.out.println("-*--*-*--*-*-*-*-*-*-*-*-*-*-*--**--*-*");
        System.out.println("            Cargar Bus");
            int CBus = arch.contarCarpeta(direccion+"\\Bus");
            String[] Vbus = new String[CBus];
                      bus = new Bus[CBus];
            Vbus = arch.cargarCarpeta(direccion+"\\Bus",Vbus);
            
            for (int i = 0; i < CBus; i++) {
            
                Vas  = cargarAsiento(direccion+"\\Bus\\"+Vbus[i]);
                Vdp  = cargarPersonal(direccion+"\\Bus\\"+Vbus[i]);
                data = arch.leerArchivos(direccion+"\\Bus\\"+Vbus[i],"Data",2);
                Bus b = new Bus(Vdp, Vas, Integer.parseInt(data[0]),Integer.parseInt(data[1]));
                bus[i] = b;
            }
            
        System.out.println("-*--*-*--*-*-*-*-*-*-*-*-*-*-*--**--*-*");    
          
        return bus;
    }
    
    public static Asiento[] cargarAsiento(String direccion){
        
        
        System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("            Cargar Asiento");
            int CAsiento = arch.ContarArchivos2(direccion+"\\Asiento");
            Asiento[] as = new Asiento[CAsiento];
            String[] Vas = new String[CAsiento];
            String[] data = new String[3];
            Vas = arch.cargarArchivos(direccion+"\\Asiento", Vas);
            
            
            for (int i = 0; i < CAsiento; i++) {
                data = arch.leerArchivos(direccion+"\\Asiento",Vas[i],3);
                boolean sw1 = false;
                boolean sw2 = false;
                if (data[1].equals("true")) {
                    sw1 = true;
                }
                if(data[2].equals("true")){
                    sw2 = true;
                }
                Asiento dt = new Asiento(sw1,data[0],sw2);
                as[i] = dt;
            }
        System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        return as;
    
    }
    
    public static DatosPersonal[] cargarPersonal(String direccion){
        
        
        System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        System.out.println("            Cargar Personal Bus");
            int CDpersonal = arch.ContarArchivos2(direccion+"\\Personal");
            DatosPersonal[] dp = new DatosPersonal[CDpersonal];
            String[] Vdp = new String[CDpersonal];
            String[] data = new String[4];
            data = arch.cargarArchivos(direccion+"\\Personal", Vdp);
            
            
            for (int i = 0; i < CDpersonal; i++) {
                data = arch.leerArchivos(direccion+"\\Personal",Vdp[i],5);
               
                DatosPersonal dt = new DatosPersonal(data[1],data[0],data[3],Integer.parseInt(data[2]));
                dp[i] = dt;
            }
        System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
        return dp;
    
    }
    // fin de obtencion datos bus
   
    //obtencion de Parada
    public static Parada[] cargarParada(String direccion){
        int indice = 0;
        Parada[] P = null;
            System.out.println("**************************************");
            System.out.println("              cargar Parada");
            int Cparadas = arch.contarCarpeta(direccion+"\\Parada");
            String[] VParada = new String[Cparadas];
            String[] Vcalle  = null; 
                     VParada = arch.cargarCarpeta(direccion+"\\Parada", VParada);
            int CCalles = 0;
            for (int i = 0; i < Cparadas; i++) {
                CCalles += arch.ContarArchivos(direccion+"\\Parada\\"+VParada[i]);
                  
            }
            
            P = new Parada[CCalles];
            
            for (int i = 0; i < Cparadas; i++) {
            
                CCalles = arch.ContarArchivos(direccion+"\\Parada\\"+VParada[i]);
                    
                    Vcalle  = new String[CCalles];
                    Vcalle  = arch.cargarArchivos(direccion+"\\Parada\\"+VParada[i], Vcalle);
                    for (int j = 0; j < CCalles; j++) {
                    
                        Parada pa = new Parada(VParada[i],Vcalle[j]);    
                        P[indice] = pa;
                        indice++;
                    
                    }
                    
            }
            System.out.println("**************************************");
        return P;
    }
    //fin de obtencion de Parada
    
    //obtencion de horario
    public static Horario[] cargarHorario(String direccion){
        Horario[] H = null;
        int CHorario = arch.ContarArchivos(direccion+"\\Horario");
        System.out.println(CHorario);
            H = new Horario[CHorario];
        String[] Vh = new String[CHorario];
            Vh = arch.cargarArchivos(direccion+"\\Horario", Vh);
        String[] data = new String[1];
        String[] data2 = new String[1];
            for (int i = 0; i < CHorario-1; i+=2) {
                data = arch.leerArchivos(direccion+"\\Horario",Vh[i],1);
                data2 = arch.leerArchivos(direccion+"\\Horario",Vh[i+1],1);
                Horario h = new Horario(data[0],data2[0],0);
            }
        return H;
    }
    //fin obtencion de horario
    
    //obtener tarifa
    public static Tarifa[] cargarTarifa(String direccion){
        Tarifa[] T = null;
        int indice = 0;
        int j = 0;
        int CTarifa = arch.contarCarpeta(direccion+"\\Tarifa");
                 T = new Tarifa[CTarifa*2];
        String[] Vt = new String[CTarifa];
        String[] dataPago = new String[CTarifa];
        String[] dataTurnoD = new String[1];
        String[] dataTurnoN = new String[1];
                 dataPago = arch.cargarCarpeta(direccion+"\\Tarifa", dataPago);
                
                 System.out.println(direccion+"-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        for (int i = 0; i < 8; i+=2) {
            
            if(j==4){
                break;
            }
                dataTurnoD = arch.leerArchivos(direccion+"\\Tarifa\\"+dataPago[j],"Diurno", 1);
            
                dataTurnoN = arch.leerArchivos(direccion+"\\Tarifa\\"+dataPago[j],"Nocturno", 1);
                
                
                double x = Double.parseDouble(dataTurnoD[0]);
                System.out.println(x);
                Tarifa dt = new Tarifa(dataPago[j],"Diurno",x);
                T[i] = dt;
            
                   x = Double.parseDouble(dataTurnoN[0]);
                   dt = new Tarifa(dataPago[j],"Nocturno",x);
                T[i+1] = dt;
            
            j++;
            
        }
        
        for (int i = 0; i < CTarifa*2; i++) {
            
            System.out.println(T[i].getTipoPago());
        }
        return T;
    }
    //fin obtencion tarifa
    
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
        Horario[] hv = new Horario[5];
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
