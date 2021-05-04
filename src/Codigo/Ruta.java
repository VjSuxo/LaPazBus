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
    private Horario[] H;
    private Parada P;

    public Ruta(String NombreRuta, Bus[] Buses, Horario[] H, Parada P) {
        this.NombreRuta = NombreRuta;
        this.Buses = Buses;
        this.H = H;
        this.P = P;
    }

    public String getNombreRuta() {
        return NombreRuta;
    }

    public void setNombreRuta(String NombreRuta) {
        this.NombreRuta = NombreRuta;
    }

    public Bus[] getBuses() {
        return Buses;
    }

    public void setBuses(Bus[] Buses) {
        this.Buses = Buses;
    }

    public Horario[] getH() {
        return H;
    }

    public void setH(Horario[] H) {
        this.H = H;
    }

    public Parada getP() {
        return P;
    }

    public void setP(Parada P) {
        this.P = P;
    }
    
    
    
}
