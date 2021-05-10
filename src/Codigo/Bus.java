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
    private int DPcant=0,DPindice=0;
    private Asiento[] Asiento;
    private int Acant=0,Aindice=0;
    private int Codigo;
    private int AñoEmpleo;
    
    
    public Bus(DatosPersonal[] Dp, Asiento[] Asiento, int Codigo, int AñoEmpleo) {
        this.Dp = Dp;
        this.Codigo = Codigo;
        this.AñoEmpleo = AñoEmpleo;
        
        this.Acant = Asiento.length; 
        this.Asiento = new Asiento[Acant];
        for (int i = 0; i < Acant; i++) {
            this.Asiento[i] = Asiento[i];
        }
        
        this.DPcant = Dp.length;
        this.Dp = new DatosPersonal[DPcant];
        for (int i = 0; i < DPcant; i++) {
            DatosPersonal d = Dp[i];
            this.Dp[i]=Dp[i];
        }
    }

    public DatosPersonal getDp() {
        DatosPersonal data = null;
        if (DPindice<DPcant){
            data = Dp[DPindice];
            DPindice++;
        }
        else{
            System.out.println(DPindice);
            DPindice = 0;
            data = null;
        }
        
        return data;
    }

    public Asiento getAsiento() {
        
        Asiento data = null;
        if (Aindice<Acant){
            data = Asiento[Aindice];
            Aindice++;
        }
        else{
            Aindice = 0;
            data = null;
        }
        return data;
    }

    public int getCodigo() {
        return Codigo;
    }

    public int getAñoEmpleo() {
        return AñoEmpleo;
    }

    public void setDp(DatosPersonal data) {
        this.Dp[DPcant] = data;
        DPcant++;
    }

    public void setAsiento(Asiento A) {
        this.Asiento[Acant] = A;
        Acant++;
    }

    public void setCodigo(int Codigo) {
        
        this.Codigo = Codigo;
    
    }

    public void setAñoEmpleo(int AñoEmpleo) {
        this.AñoEmpleo = AñoEmpleo;
    }

    public int getDPcant() {
        return DPcant;
    }

    public void setDPcant(int DPcant) {
        this.DPcant = DPcant;
    }

    public int getAcant() {
        return Acant;
    }

    public void setAcant(int Acant) {
        this.Acant = Acant;
    }
    
    
    
    
    
}
