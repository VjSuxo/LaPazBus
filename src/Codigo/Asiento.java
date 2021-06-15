/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

/**
 *
 * @author Tostadora
 * @param Estado = (False) si esta ocupado (True) si esta disponible
 * @param Tipo   = Que tipo de asiento es (regular,preferencial,señalados)
 * @param Seccion= (True)Delantera  (False)trasera
 */
public class Asiento {
    private String Estado;
    private String  Tipo;
    private boolean Seccion;

    public Asiento(String Estado, String Tipo, boolean Seccion) {
        
        this.Estado = Estado;
        this.Tipo = Tipo;
        this.Seccion = Seccion;
    }

    public String isEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public boolean isSeccion() {
        return Seccion;
    }

    public void setSeccion(boolean Seccion) {
        this.Seccion = Seccion;
    }
 
    public String mostrar(){
    
        return "Estado : "+Estado+" Tipo : "+Tipo+" Seccion : "+Seccion;
        
    }
    
    
}
