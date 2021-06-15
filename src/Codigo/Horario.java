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
public class Horario {
    private String Llegada;
    private String Salida;
    private int Frecuencia;

    public Horario(String Llegada, String Salida,int Frecuencia) {
        this.Llegada = Llegada;
        this.Salida = Salida;
        this.Frecuencia = Frecuencia;
    }

    public int getFrecuencia() {
        return Frecuencia;
    }

    public void setFrecuencia(int Frecuencia) {
        this.Frecuencia = Frecuencia;
    }

    public String getLlegada() {
        return Llegada;
    }

    public void setLlegada(String Llegada) {
        this.Llegada = Llegada;
    }

    public String getSalida() {
        return Salida;
    }

    public void setSalida(String Salida) {
        this.Salida = Salida;
    }
    
    public String mostrar(){
    
        return "Llegada : "+Llegada+" Salida :"+Salida;
        
    }
    
    
}
