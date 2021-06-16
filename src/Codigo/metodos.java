/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import javax.swing.JOptionPane;

/**
 *
 * @author Tostadora
 */
public class metodos {
     private Archivos arch = new Archivos();
    
     
     
     public PilaBus ordenar(PilaBus pilaBus){
         
        PilaBus b = new PilaBus();
        PilaBus c = new PilaBus();
        while(!pilaBus.esVacia()){
        
            Bus bus = pilaBus.eliminar();
            while(!pilaBus.esVacia()){
            
                Bus data = pilaBus.eliminar();
                if(data.getAñoEmpleo()<bus.getAñoEmpleo()){
                    b.adiElem(bus);
                    bus = data;
                }
                else{
                    b.adiElem(data);
                }
            }
            c.adiElem(bus);
            pilaBus.vaciar(b);
        }
        pilaBus.vaciar(c);
        return pilaBus;
     
     }
     
     
     public PilaPersonal eliminar(PilaPersonal pilaPersonal,String ci){
     
         PilaPersonal aux = new PilaPersonal();
         
         while(!pilaPersonal.esVacia()){
         
            DatosPersonal dataP = pilaPersonal.eliminar();
            
            if(dataP.getCi().equals(ci)){
                JOptionPane.showMessageDialog(null,"El empleado con Ci :"+dataP.getCi()+" Con nombre "+dataP.getNombre()+" es eliminado ...");
            }
            else{
                aux.adiElem(dataP);
            }
         }
         
         pilaPersonal.vaciar(aux);
         
         return pilaPersonal;
     }
     
     public PilaRuta contratar(PilaRuta pilaRuta,PilaContratacion pilaContrato,String ci,String codigoBus){
     
        Postulante postulante = buscar(pilaContrato, ci);
        
        PilaRuta pilaRaux = new PilaRuta();
        
        while(!pilaRuta.esVacia()){
        
            Ruta ruta = pilaRuta.eliminar();
            PilaBus pilaBus = ruta.getBuses();
            PilaBus pilaBaux = new PilaBus();
            System.out.println("Codigo de bus a asignar "+codigoBus);
            while(!pilaBus.esVacia()){
                
                Bus b = pilaBus.eliminar();
                System.out.println("Ingresando "+b.getCodigo());
                if(b.getCodigo().equals(codigoBus)){
                    System.out.println("------------------------------------");
                    System.out.println("Codigo del bus encontrado");
                    PilaPersonal pilaPersonal =b.getDp();
                    DatosPersonal dt = new DatosPersonal(postulante.getNombre(),postulante.getCi(),postulante.getCargo(),postulante.getEdad());
                    System.out.println("-----");
                    pilaPersonal.adiElem(dt);
                    System.out.println("-----");
                    b.setDp(pilaPersonal);
                    System.out.println("--------------------------------------");
                }
                pilaBaux.adiElem(b);
            
            }
            pilaBus.vaciar(pilaBaux);
            ruta.setBuses(pilaBus);
            pilaRaux.adiElem(ruta);
         
        }
         pilaRuta.vaciar(pilaRaux);
         
         return pilaRuta;
         
     }
     
    
         
     
     
     private Postulante buscar(PilaContratacion pilaCon,String ci){
         PilaContratacion pilaCaux  = new PilaContratacion();
         Postulante data = null;
         
         while(!pilaCon.esVacia()){
         
             Postulante pos = pilaCon.eliminar();
             if(ci.equals(pos.getCi())){
                 System.out.println("Postulante encontrado");
                 data = pos;
             
             }
             pilaCaux.adiElem(pos);
         
         }
         pilaCon.vaciar(pilaCaux);
         return data;
     }
     
     public Ruta crearRutaIncaLlojeta(){
         
         //crear bus
         //crea personal
         PilaBus pilaBus = new PilaBus();
         PilaPersonal pilaPersonal = new PilaPersonal();
         DatosPersonal datosPersonal = new DatosPersonal("Victor Suxo","6150883","conductor",20);
                       pilaPersonal.adiElem(datosPersonal);
                       datosPersonal = new DatosPersonal("Ruben Dario","4152445","anfitrion",19);
                       pilaPersonal.adiElem(datosPersonal);
        //crear asiento               
        PilaAsiento pilaAsiento = new PilaAsiento();
        Asiento asiento; 
        for (int i = 0; i < 10; i++) {
               asiento = new Asiento("libre","normal", true);
                pilaAsiento.adiElem(asiento);
         }
                asiento = new Asiento("ocupado","normal", false);
                pilaAsiento.adiElem(asiento);
          for (int i = 0; i < 10; i++) {
                asiento = new Asiento("libre","preferencial", false);
                pilaAsiento.adiElem(asiento);
         }
         
         Bus b = new Bus(pilaPersonal,pilaAsiento,"15BH12",2006,9);
         pilaBus.adiElem(b);
         
         //bus 2
          pilaPersonal = new PilaPersonal();
          datosPersonal = new DatosPersonal("Ramon Mamani","12583","conductor",20);
                       pilaPersonal.adiElem(datosPersonal);
                       datosPersonal = new DatosPersonal("Alan Mamani","15852","anfitrion",19);
                       pilaPersonal.adiElem(datosPersonal);
        //crear asiento               
        pilaAsiento = new PilaAsiento();
        
        for (int i = 0; i < 10; i++) {
               asiento = new Asiento("libre","normal", true);
                pilaAsiento.adiElem(asiento);
         }
                asiento = new Asiento("ocupado","normal", false);
                pilaAsiento.adiElem(asiento);
          for (int i = 0; i < 10; i++) {
                asiento = new Asiento("libre","preferencial", false);
                pilaAsiento.adiElem(asiento);
         }
         
         b = new Bus(pilaPersonal,pilaAsiento,"16BR15U",2009,10);
         pilaBus.adiElem(b);
         
          //bus 3
          pilaPersonal = new PilaPersonal();
          datosPersonal = new DatosPersonal("Tiranus Palus","4753215","conductor",25);
                       pilaPersonal.adiElem(datosPersonal);
                       datosPersonal = new DatosPersonal("Mamani Mamani","5153255","anfitrion",19);
                       pilaPersonal.adiElem(datosPersonal);
        //crear asiento               
        pilaAsiento = new PilaAsiento();
        
        for (int i = 0; i < 10; i++) {
               asiento = new Asiento("libre","normal", true);
                pilaAsiento.adiElem(asiento);
         }
                asiento = new Asiento("ocupado","normal", false);
                pilaAsiento.adiElem(asiento);
          for (int i = 0; i < 10; i++) {
                asiento = new Asiento("libre","preferencial", false);
                pilaAsiento.adiElem(asiento);
         }
         
         b = new Bus(pilaPersonal,pilaAsiento,"11TH55",2004,12);
         pilaBus.adiElem(b);
         
         //horario
         PilaHorario pilaHorario = new PilaHorario();
         Horario horario = new Horario("7:00","9:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("9:00","11:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("11:00","13:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("13:00","15:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("15:00","17:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("17:00","19:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("19:00","21:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("21:00","23:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("23:00","00:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("00:00","2:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("2:00","4:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("4:00","6:00", 0);
                pilaHorario.adiElem(horario);
                
                
         //parada
         PilaParada pilaParada = new PilaParada();
         Parada parada = new Parada("Llojeta","av. max fernandez");
                pilaParada.adiElem(parada);
                parada = new Parada("Llojeta","av. mario mercado");
                pilaParada.adiElem(parada);
                parada = new Parada("Llojeta","cementerio jardin");
                pilaParada.adiElem(parada);
                parada = new Parada("Los Leones","puentes trillizos");
                pilaParada.adiElem(parada);
                parada = new Parada("Miraflores","av. del libertador");
                pilaParada.adiElem(parada);
                parada = new Parada("Miraflores","av. del poeta");
                pilaParada.adiElem(parada);
                parada = new Parada("Prado","federico zuazo");
                pilaParada.adiElem(parada);
                parada = new Parada("Prado","plaza camacho");
                pilaParada.adiElem(parada);
                parada = new Parada("Prado","estacion central puc");
                pilaParada.adiElem(parada);
                
        //tarifa 

        PilaTarifa pilaTarifa = new PilaTarifa();
        Tarifa tarifa = new Tarifa("tarjeta","diurno",2);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("tarjeta","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("efectivo","diurno",2.3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("efectivo","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("preferencial","diurno",1.5);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("preferencial","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("universitaria","diurno",1.8);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("efectivo","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               
         Ruta ruta = new Ruta("Inca LLojeta",pilaBus, pilaHorario, pilaParada, pilaTarifa);
         
         return ruta;
     }
     
     
     
     public Ruta crearRutaVillaSalome(){
         
         //crear bus
         //crea personal
         PilaBus pilaBus = new PilaBus();
         PilaPersonal pilaPersonal = new PilaPersonal();
         DatosPersonal datosPersonal = new DatosPersonal("Marcos Mamani","1593547","conductor",22);
                       pilaPersonal.adiElem(datosPersonal);
                       datosPersonal = new DatosPersonal("Esteban Quispe","654853","anfitrion",23);
                       pilaPersonal.adiElem(datosPersonal);
        //crear asiento               
        PilaAsiento pilaAsiento = new PilaAsiento();
        Asiento asiento; 
        for (int i = 0; i < 10; i++) {
               asiento = new Asiento("libre","normal", true);
                pilaAsiento.adiElem(asiento);
         }
                asiento = new Asiento("ocupado","normal", false);
                pilaAsiento.adiElem(asiento);
          for (int i = 0; i < 10; i++) {
                asiento = new Asiento("libre","preferencial", false);
                pilaAsiento.adiElem(asiento);
         }
         
         Bus b = new Bus(pilaPersonal,pilaAsiento,"18HTO12",2003,9);
         pilaBus.adiElem(b);
         
         //bus 2
          pilaPersonal = new PilaPersonal();
          datosPersonal = new DatosPersonal("Oliver Rivera","15862134","conductor",30);
                       pilaPersonal.adiElem(datosPersonal);
                       datosPersonal = new DatosPersonal("Edwin Alanoca","6852357","anfitrion",19);
                       pilaPersonal.adiElem(datosPersonal);
        //crear asiento               
        pilaAsiento = new PilaAsiento();
        
        for (int i = 0; i < 10; i++) {
               asiento = new Asiento("libre","normal", true);
                pilaAsiento.adiElem(asiento);
         }
                asiento = new Asiento("ocupado","normal", false);
                pilaAsiento.adiElem(asiento);
          for (int i = 0; i < 10; i++) {
                asiento = new Asiento("libre","preferencial", false);
                pilaAsiento.adiElem(asiento);
         }
         
         b = new Bus(pilaPersonal,pilaAsiento,"16BKTM11",2009,10);
         pilaBus.adiElem(b);
         
          //bus 3
          pilaPersonal = new PilaPersonal();
          datosPersonal = new DatosPersonal("Jose Amaru","455831541","conductor",35);
                       pilaPersonal.adiElem(datosPersonal);
                       datosPersonal = new DatosPersonal("Hugo Ramos","3586521","anfitrion",25);
                       pilaPersonal.adiElem(datosPersonal);
        //crear asiento               
        pilaAsiento = new PilaAsiento();
        
        for (int i = 0; i < 10; i++) {
               asiento = new Asiento("libre","normal", true);
                pilaAsiento.adiElem(asiento);
         }
                asiento = new Asiento("ocupado","normal", false);
                pilaAsiento.adiElem(asiento);
          for (int i = 0; i < 10; i++) {
                asiento = new Asiento("libre","preferencial", false);
                pilaAsiento.adiElem(asiento);
         }
         
         b = new Bus(pilaPersonal,pilaAsiento,"11JJMN",2004,12);
         pilaBus.adiElem(b);
         
         //horario
         PilaHorario pilaHorario = new PilaHorario();
         Horario horario = new Horario("7:00","9:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("9:00","11:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("11:00","13:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("13:00","15:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("15:00","17:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("17:00","19:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("19:00","21:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("21:00","23:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("23:00","00:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("00:00","2:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("2:00","4:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("4:00","6:00", 0);
                pilaHorario.adiElem(horario);
                
                
         //parada
         PilaParada pilaParada = new PilaParada();
         Parada parada = new Parada("Villa Salome","av. ciudad del niño");
                pilaParada.adiElem(parada);
                parada = new Parada("Villa Salome","sampa");
                pilaParada.adiElem(parada);
                parada = new Parada("Villa Salome","av. circunvalacion");
                pilaParada.adiElem(parada);
                parada = new Parada("Pampahasi","av. 23 de marzo");
                pilaParada.adiElem(parada);
                parada = new Parada("Pampahasi","calle 4");
                pilaParada.adiElem(parada);
                parada = new Parada("Pampahasi","mecado 10 de enero");
                pilaParada.adiElem(parada);
                parada = new Parada("Pampahasi","av. octavio campero");
                pilaParada.adiElem(parada);
                parada = new Parada("Villa San Antonio","av. esteban arce");
                pilaParada.adiElem(parada);
                parada = new Parada("Villa Copacabana","calle 3 viejas");
                pilaParada.adiElem(parada);
                parada = new Parada("Villa Copacabana","av. refael ballivian");
                pilaParada.adiElem(parada);
                parada = new Parada("Villa Copacabana","puente paraguay");
                pilaParada.adiElem(parada);
                parada = new Parada("Miraflores","av. busch");
                pilaParada.adiElem(parada);
                parada = new Parada("Miraflores","calle diaz romero");
                pilaParada.adiElem(parada);
                parada = new Parada("Miraflores","laikakota");
                pilaParada.adiElem(parada);
                parada = new Parada("Prado","federico zuazo");
                pilaParada.adiElem(parada);
                parada = new Parada("Prado","plaza camacho");
                pilaParada.adiElem(parada);
                parada = new Parada("Prado","estacion central puc");
                pilaParada.adiElem(parada);
        //tarifa 

        PilaTarifa pilaTarifa = new PilaTarifa();
        Tarifa tarifa = new Tarifa("tarjeta","diurno",2);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("tarjeta","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("efectivo","diurno",2.3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("efectivo","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("preferencial","diurno",1.5);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("preferencial","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("universitaria","diurno",1.8);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("efectivo","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               
         Ruta ruta = new Ruta("Villa Salome",pilaBus, pilaHorario, pilaParada, pilaTarifa);
         
         return ruta;
     }
    
      public Ruta crearRutaChasquipampa(){
         
         //crear bus
         //crea personal
         PilaBus pilaBus = new PilaBus();
         PilaPersonal pilaPersonal = new PilaPersonal();
         DatosPersonal datosPersonal = new DatosPersonal("Miguel Mamani","1132568","conductor",23);
                       pilaPersonal.adiElem(datosPersonal);
                       datosPersonal = new DatosPersonal("Jaime Mendoza","3543215","anfitrion",30);
                       pilaPersonal.adiElem(datosPersonal);
        //crear asiento               
        PilaAsiento pilaAsiento = new PilaAsiento();
        Asiento asiento; 
        for (int i = 0; i < 10; i++) {
               asiento = new Asiento("libre","normal", true);
                pilaAsiento.adiElem(asiento);
         }
                asiento = new Asiento("ocupado","normal", false);
                pilaAsiento.adiElem(asiento);
          for (int i = 0; i < 10; i++) {
                asiento = new Asiento("libre","preferencial", false);
                pilaAsiento.adiElem(asiento);
         }
         
         Bus b = new Bus(pilaPersonal,pilaAsiento,"18YTF13",2003,9);
         pilaBus.adiElem(b);
         
         //bus 2
          pilaPersonal = new PilaPersonal();
          datosPersonal = new DatosPersonal("Mario Casas","455832","conductor",35);
                       pilaPersonal.adiElem(datosPersonal);
                       datosPersonal = new DatosPersonal("Edwin Castellanos","35864831","anfitrion",29);
                       pilaPersonal.adiElem(datosPersonal);
        //crear asiento               
        pilaAsiento = new PilaAsiento();
        
        for (int i = 0; i < 10; i++) {
               asiento = new Asiento("libre","normal", true);
                pilaAsiento.adiElem(asiento);
         }
                asiento = new Asiento("ocupado","normal", false);
                pilaAsiento.adiElem(asiento);
          for (int i = 0; i < 10; i++) {
                asiento = new Asiento("libre","preferencial", false);
                pilaAsiento.adiElem(asiento);
         }
         
         b = new Bus(pilaPersonal,pilaAsiento,"1588HUB",2009,11);
         pilaBus.adiElem(b);
         
          //bus 3
          pilaPersonal = new PilaPersonal();
          datosPersonal = new DatosPersonal("Angel Tintaya","3285663","conductor",35);
                       pilaPersonal.adiElem(datosPersonal);
                       datosPersonal = new DatosPersonal("Jorge Salinar","612563","anfitrion",22);
                       pilaPersonal.adiElem(datosPersonal);
        //crear asiento               
        pilaAsiento = new PilaAsiento();
        
        for (int i = 0; i < 10; i++) {
               asiento = new Asiento("libre","normal", true);
                pilaAsiento.adiElem(asiento);
         }
                asiento = new Asiento("ocupado","normal", false);
                pilaAsiento.adiElem(asiento);
          for (int i = 0; i < 10; i++) {
                asiento = new Asiento("libre","preferencial", false);
                pilaAsiento.adiElem(asiento);
         }
         
         b = new Bus(pilaPersonal,pilaAsiento,"111HFM",2004,9);
         pilaBus.adiElem(b);
         
         //horario
         PilaHorario pilaHorario = new PilaHorario();
         Horario horario = new Horario("7:00","9:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("9:00","11:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("11:00","13:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("13:00","15:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("15:00","17:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("17:00","19:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("19:00","21:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("21:00","23:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("23:00","00:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("00:00","2:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("2:00","4:00", 0);
                pilaHorario.adiElem(horario);
                horario = new Horario("4:00","6:00", 0);
                pilaHorario.adiElem(horario);
                
                
         //parada
         PilaParada pilaParada = new PilaParada();
         Parada parada = new Parada("Ovejuyo","calle 63");
                pilaParada.adiElem(parada);
                parada = new Parada("Chasquipampa","calle 53");
                pilaParada.adiElem(parada);
                parada = new Parada("Chasquipampa","av. jose muñoz reyes");
                pilaParada.adiElem(parada);
                parada = new Parada("Cota Cota","laguna de cota cota");
                pilaParada.adiElem(parada);
                parada = new Parada("Cota Cota","calle 28");
                pilaParada.adiElem(parada);
                parada = new Parada("Los Pinos","calle 25 los pinos");
                pilaParada.adiElem(parada);
                parada = new Parada("Los Pinos","av. jose aguirre acha");
                pilaParada.adiElem(parada);
                parada = new Parada("Calacoto","calle 21");
                pilaParada.adiElem(parada);
                parada = new Parada("Calacoto","av. costanera");
                pilaParada.adiElem(parada);
                parada = new Parada("Calacoto","calle 15");
                pilaParada.adiElem(parada);
                parada = new Parada("Calacoto","las cholas");
                pilaParada.adiElem(parada);
                parada = new Parada("Obrajes","calle 16");
                pilaParada.adiElem(parada);
                parada = new Parada("Obrajes","av. ormachea");
                pilaParada.adiElem(parada);
                parada = new Parada("Obrajes","av. hernando siles");
                pilaParada.adiElem(parada);
                parada = new Parada("Miraflores","av. del libertador");
                pilaParada.adiElem(parada);
                parada = new Parada("Miraflores","av. del poeta");
                pilaParada.adiElem(parada);
                parada = new Parada("Prado","federico zuazo");
                pilaParada.adiElem(parada);
                parada = new Parada("Prado","plaza camacho");
                pilaParada.adiElem(parada);
                parada = new Parada("Prado","estacion central puc");
                pilaParada.adiElem(parada);
                
        //tarifa 

        PilaTarifa pilaTarifa = new PilaTarifa();
        Tarifa tarifa = new Tarifa("tarjeta","diurno",2);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("tarjeta","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("efectivo","diurno",2.3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("efectivo","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("preferencial","diurno",1.5);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("preferencial","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("universitaria","diurno",1.8);
               pilaTarifa.adiElem(tarifa);
               tarifa = new Tarifa("efectivo","nocturno",3);
               pilaTarifa.adiElem(tarifa);
               
         Ruta ruta = new Ruta("Chasquipampa",pilaBus, pilaHorario, pilaParada, pilaTarifa);
         
         return ruta;
     }
      
      
     public PilaContratacion crear(){
     
         PilaContratacion pl = new PilaContratacion();
         
         Postulante pos = new Postulante("antonio garrido","1122255","conductor",22);
                    pl.adiElem(pos);
                    pos = new Postulante("mario cejas","2255533","anfitrion",23);
                    pl.adiElem(pos);
                    pos = new Postulante("marco diaz","153215","conductor",32);
                    pl.adiElem(pos);
                    pos = new Postulante("edwuar edmundo","52125","conductor",52);
                    pl.adiElem(pos);
                    pos = new Postulante("esteban colque","8631222","anfitrion",22);
                    pl.adiElem(pos);
                    pos = new Postulante("mario casas","87454321","conductor",22);
                    pl.adiElem(pos);
        return pl;            
     } 
      
     
}
