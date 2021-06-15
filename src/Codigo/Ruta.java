/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

/**
 *
 * @author Tostadora
 */
public class Ruta {
    
    private String NombreRuta;
    private PilaBus Buses;
    private PilaHorario H;
    private PilaParada P;
    private PilaTarifa T;

    public Ruta() {
    }

    public Ruta(String NombreRuta, PilaBus Buses, PilaHorario H, PilaParada P, PilaTarifa T) {
        this.NombreRuta = NombreRuta;
        this.Buses = Buses;
        this.H = H;
        this.P = P;
        this.T = T;
    }

    public String getNombreRuta() {
        return NombreRuta;
    }

    public void setNombreRuta(String NombreRuta) {
        this.NombreRuta = NombreRuta;
    }

    public PilaBus getBuses() {
        return Buses;
    }

    public void setBuses(PilaBus Buses) {
        this.Buses = Buses;
    }

    public PilaHorario getH() {
        return H;
    }

    public void setH(PilaHorario H) {
        this.H = H;
    }

    public PilaParada getP() {
        return P;
    }

    public void setP(PilaParada P) {
        this.P = P;
    }

    public PilaTarifa getT() {
        return T;
    }

    public void setT(PilaTarifa T) {
        this.T = T;
    }

     public void mostrar(){
       System.out.println("Mostrando Pila");
     
      
      
           
           System.out.println("-----------------------------");
           System.out.println(getNombreRuta());
           System.out.println("");
           System.out.println("---------------------------Bus");
           getBuses().mostrar();
           System.out.println("");
           System.out.println("-----------------------Horario");
           getH().mostrar();
           System.out.println("");
           System.out.println("---------------------Parada");
           getP().mostrar();
           System.out.println("");
           System.out.println("---------------------Tarifa");
           getT().mostrar();
           System.out.println("-------------------------------");
        
       }
   
   }
    
    
    
    
    
    
    
    
    
    
    

