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
    private Bus[] Buses;
    private int Bindice=0,Bcant=0;
    private Horario[] H;
    private int Hindice=0,Hcant=0;
    private Parada P;
    private Tarifa T;
    public Ruta(String NombreRuta, Bus[] Buses, Horario[] H, Parada P,Tarifa t) {
        this.NombreRuta = NombreRuta;
        this.Bindice = Buses.length;
        this.Bcant = Bindice;
        for (int i = 0; i < this.Bcant; i++) {
            this.Buses[i] = Buses[i];
        }
        this.Hindice = H.length;
        Hcant = Hindice;
        for (int i = 0; i < Hcant; i++) {
            this.H[i] = H[i];
        }
        this.H = H;
        this.P = P;
        this.T = t;
    }

    public String getNombreRuta() {
        return NombreRuta;
    }

    public void setNombreRuta(String NombreRuta) {
        this.NombreRuta = NombreRuta;
    }

    public Bus getBuses() {         
        
        Bus data = Buses[Bindice];
        if (Bindice>0){
            data = Buses[Bindice];
            Bindice--;
        }
        if(Bindice<=0){
            Bindice = Bcant;
        }
        return data;
    }

    public void setBuses(Bus buses) {
        this.Buses[Bcant] = buses;
        Bcant++;
    }

    public Horario getH() {
        Horario data = null;
        
        if (Hindice>0){
            data = H[Hindice];
            Hindice--;
        }
        if(Hindice<=0){
            Hindice = Hcant;
        }
        
        return data;
    }

    public void setH(Horario h) {
        this.H[Hcant] = h;
        Hcant++;
    }

    public Parada getP() {
        return P;
    }

    public void setP(Parada P) {
        this.P = P;
    }
        
    
    
}
