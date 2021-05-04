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
    
    private DatosPersonal[] Dp;
    private Asiento[] Asiento;
    private int Codigo;
    private int AñoEmpleo;

    public Bus(DatosPersonal[] Dp, Asiento[] Asiento, int Codigo, int AñoEmpleo) {
        this.Dp = Dp;
        this.Asiento = Asiento;
        this.Codigo = Codigo;
        this.AñoEmpleo = AñoEmpleo;
        
    }

    public DatosPersonal[] getDp() {
        return Dp;
    }

    public Asiento[] getAsiento() {
        return Asiento;
    }

    public int getCodigo() {
        return Codigo;
    }

    public int getAñoEmpleo() {
        return AñoEmpleo;
    }
    
    
    
}
