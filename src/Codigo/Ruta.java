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
    private Parada P[];
    private int Pindice=0,Pcant=0;
    private Tarifa[] T;
    private int Tindice=0,Tcant=0;
    public Ruta(String NombreRuta, Bus[] Buses, Horario[] H, Parada P[],Tarifa[] t) {
        
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
        
        this.Pindice = P.length;
        Pcant = Pindice;
        for (int i = 0; i < Pcant; i++) {
            this.P[i] = P[i];
        }
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
            data = Buses[Bindice];
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
            data = H[Hindice];
        }
        
        return data;
    }

    public void setH(Horario h) {
        this.H[Hcant] = h;
        Hcant++;
    }

    public Parada getP() {
        Parada data = null;
        
        if (Pindice>0){
            data = P[Pindice];
            Pindice--;
        }
        if(Pindice<=0){
            Pindice = Pcant;
            data = P[Pindice];
        }
        
        return data;
    }

    public void setP(Parada p) {
        this.P[Pcant] = p;
        Pcant++;
    }

    public Tarifa getT() {
        Tarifa data = null;
        
        if (Tindice>0){
            data = T[Tindice];
            Tindice--;
        }
        if(Tindice<=0){
            Tindice = Tcant;
            data = T[Tindice];
        }
        return data;
    }

    public void setT(Tarifa t) {
        this.T[Pcant] = t;
        Tcant++;
    }
        
    
    
}
