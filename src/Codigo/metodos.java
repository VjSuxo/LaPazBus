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
     
     public PilaRuta contratar(PilaRuta pilaRuta,PilaContratacion pilaContrato,String ci,int codigoBus){
     
        Postulante postulante = buscar(pilaContrato, ci);
        
        PilaRuta pilaRaux = new PilaRuta();
        
        while(!pilaRuta.esVacia()){
        
            Ruta ruta = pilaRuta.eliminar();
            PilaBus pilaBus = ruta.getBuses();
            PilaBus pilaBaux = new PilaBus();
            
            while(!pilaBus.esVacia()){
                
                Bus b = pilaBus.eliminar();
                if(b.getCodigo()==codigoBus){
                
                    
                
                }
                pilaBaux.adiElem(b);
            
            }
            pilaRaux.adiElem(ruta);
         
        }
         
         
         return pilaRuta;
         
     }
     
     private Postulante buscar(PilaContratacion pilaCon,String ci){
         PilaContratacion pilaCaux  = new PilaContratacion();
         Postulante data = null;
         
         while(!pilaCon.esVacia()){
         
             Postulante pos = pilaCon.eliminar();
             if(ci.equals(pos.getCi())){
             
                 data = pos;
             
             }
             pilaCaux.adiElem(pos);
         
         }
         pilaCon.vaciar(pilaCaux);
         return data;
     }
     
     
     
     
     
    
}
