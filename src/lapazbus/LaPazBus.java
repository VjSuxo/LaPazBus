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
    
    
   
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        PilaRuta pilaRuta = new PilaRuta();
        PilaContratacion pilaContratacion = new PilaContratacion();
        
        metodos met = new metodos();
        
        pilaRuta.adiElem(met.crearRutaChasquipampa());
        pilaRuta.adiElem(met.crearRutaIncaLlojeta());
        pilaRuta.adiElem(met.crearRutaVillaSalome());
        
        pilaContratacion = met.crear();
        
        Inicio in = new Inicio();
        in.Base(pilaRuta, pilaContratacion);
        in.show();
        
        
      
        
    }
    
    
    
       
    
   
}
