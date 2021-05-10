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
        
        this.Bcant = Buses.length;
        this.Buses = new Bus[Bcant];
        for (int i = 0; i < this.Bcant; i++) {
            this.Buses[i] = Buses[i];
        }
        
        this.Hcant = H.length;
        this.H = new Horario[Hcant];
        for (int i = 0; i < Hcant; i++) {
            this.H[i] = H[i];
        }
        
        this.Pcant = P.length;
        this.P = new Parada[Pcant];
        for (int i = 0; i < Pcant; i++) {
            this.P[i] = P[i];
        }
        
        this.Tcant = t.length;
        this.T = new Tarifa[Tcant];
        for (int i = 0; i < Tcant; i++) {
            this.T[i]=t[i];
        }
    }

    public String getNombreRuta() {
        return NombreRuta;
    }

    public void setNombreRuta(String NombreRuta) {
        this.NombreRuta = NombreRuta;
    }

    public Bus getBuses() {         
        
        Bus data = Buses[Bindice];
        if (Bindice<=Bcant){
            data = Buses[Bindice];
            Bindice++;
        }
        else{
            Bindice = 0;
            data = null;
        }
        return data;
    }

    public void setBuses(Bus buses) {
        this.Buses[Bcant] = buses;
        Bcant++;
    }

    public Horario getH() {
        Horario data = null;
        
        if (Hindice<=Hcant){
            data = H[Hindice];
            Hindice++;
        }
        else{
            Hindice = 0;
            data = null;
        }
        
        return data;
    }

    public void setH(Horario h) {
        this.H[Hcant] = h;
        Hcant++;
    }

    public Parada getP() {
        Parada data = null;
        
        if (Pindice<=Pcant){
            data = P[Pindice];
            Pindice++;
        }
        else{
            Pindice = 0;
            data = null;
        }
        
        return data;
    }

    public void setP(Parada p) {
        this.P[Pcant] = p;
        Pcant++;
    }

    public Tarifa getT() {
        Tarifa data = null;
        
        if (Tindice<=Tcant){
            data = T[Tindice];
            Tindice++;
        }
        else{
            Tindice = 0;
            data = null;
        }
        return data;
    }

    public void setT(Tarifa t) {
        this.T[Pcant] = t;
        Tcant++;
    }

    public int getBcant() {
        return Bcant;
    }

    public void setBcant(int Bcant) {
        this.Bcant = Bcant;
    }

    public int getHcant() {
        return Hcant;
    }

    public void setHcant(int Hcant) {
        this.Hcant = Hcant;
    }

    public int getPcant() {
        return Pcant;
    }

    public void setPcant(int Pcant) {
        this.Pcant = Pcant;
    }

    public int getTcant() {
        return Tcant;
    }

    public void setTcant(int Tcant) {
        this.Tcant = Tcant;
    }
        
    
    
}
