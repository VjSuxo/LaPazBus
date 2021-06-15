/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.Scanner;

/**
 *
 * @author Tostadora
 */
public class PilaAsiento {
     private Asiento[] pl = new Asiento[50];
   private int max = 50,tope=1;
   private static Scanner sc = new Scanner(System.in);
   
   
   public PilaAsiento(){
       tope=0;
   }
    
   public boolean esVacia(){
       if(tope == 0){
           
           return true;
       }
       else{
           return false;
       }
       
   }
   
   public boolean esLlena(){
       if(tope == max){
         
           return true;
       }
       else{
          
           return false;
       }
   }
   
   public int nroElem(){
       return tope;
       
   }
   
  
   
    public void adiElem(Asiento data){
        if(!esLlena()){
           pl[tope] = data;
           tope++;
       }
   }
   
   public void mostrar(){
       System.out.println("Mostrando Pila Asiento");
       PilaAsiento aux = new PilaAsiento();
       int n = tope;
       for(int i=0; i<=n-1;i++){
           Asiento data =eliminar();
           System.out.println("");
           System.out.println("-**-**-**-**-**-**-**-**-");
           System.out.println(data.mostrar());
           System.out.println("-**-**-**-**-**-**-**-**-");
           System.out.println("");
       }
       this.vaciar(aux);
   }
   
   public Asiento eliminar(){
       if(!esVacia()){
           Asiento data = pl[tope-1];
           tope--;
           return data;
       }
       else{
           return null;
       }
       
   }
   
   
   public void vaciar(PilaAsiento z){
       
       while(!z.esVacia()){
           this.adiElem(z.eliminar());
       }
   }
}
