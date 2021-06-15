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
public class PilaBus {
     private Bus[] pl = new Bus[50];
   private int max = 50,tope=1;
   private static Scanner sc = new Scanner(System.in);
   
   
   public PilaBus(){
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
   
  
   
    public void adiElem(Bus data){
        if(!esLlena()){
           pl[tope] = data;
           tope++;
       }
   }
   
   public void mostrar(){
       System.out.println("Mostrando Pila Bus");
       PilaBus aux = new PilaBus();
       int n = tope;
       for(int i=0; i<=n-1;i++){
           Bus data =eliminar();
           System.out.println("--**--**--**--**--**");
           System.out.println(data.mostrar());
           System.out.println("--------------------------Asiento");
           data.getAsiento().mostrar();
           System.out.println("");
           System.out.println("-------------------------Personal");
           data.getDp().mostrar();
           System.out.println("");
           System.out.println("--**--**--**--**--**");
       }
       this.vaciar(aux);
   }
   
   public Bus eliminar(){
       if(!esVacia()){
           Bus data = pl[tope-1];
           tope--;
           return data;
       }
       else{
           return null;
       }
       
   }
   
   
   public void vaciar(PilaBus z){
       
       while(!z.esVacia()){
           this.adiElem(z.eliminar());
       }
   }
}
