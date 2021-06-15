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
public class Bus {
    
    private PilaPersonal Dp;
    private PilaAsiento Asiento;
    private int Codigo;
    private int AñoEmpleo;
    private int Hora;
    public Bus(PilaPersonal Dp, PilaAsiento Asiento, int Codigo, int AñoEmpleo,int hora) {
        this.Dp = Dp;
        this.Asiento = Asiento;
        this.Codigo = Codigo;
        this.AñoEmpleo = AñoEmpleo;
        this.Hora = hora;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }

    public PilaPersonal getDp() {
        return Dp;
    }

    public void setDp(PilaPersonal Dp) {
        this.Dp = Dp;
    }

    public PilaAsiento getAsiento() {
        return Asiento;
    }

    public void setAsiento(PilaAsiento Asiento) {
        this.Asiento = Asiento;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getAñoEmpleo() {
        return AñoEmpleo;
    }

    public void setAñoEmpleo(int AñoEmpleo) {
        this.AñoEmpleo = AñoEmpleo;
    }

    public String mostrar(){
    
        return "Codigo :"+Codigo+" Año Empleo :"+AñoEmpleo;
        
    }
    
}
