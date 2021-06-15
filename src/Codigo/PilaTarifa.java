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
public class PilaTarifa {
     private Tarifa[] pl = new Tarifa[50];
   private int max = 50,tope=1;
   private static Scanner sc = new Scanner(System.in);
   
   
   public PilaTarifa(){
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
   
  
   
    public void adiElem(Tarifa data){
        if(!esLlena()){
           pl[tope] = data;
           tope++;
       }
   }
   
   public void mostrar(){
       System.out.println("Mostrando Pila Tarifa");
       PilaTarifa aux = new PilaTarifa();
       int n = tope;
       for(int i=0; i<=n-1;i++){
           Tarifa data =eliminar();
           System.out.println(data.mostrar());
       }
       this.vaciar(aux);
   }
   
   public Tarifa eliminar(){
       if(!esVacia()){
           Tarifa data = pl[tope-1];
           tope--;
           return data;
       }
       else{
           return null;
       }
       
   }
   
   
   public void vaciar(PilaTarifa z){
       
       while(!z.esVacia()){
           this.adiElem(z.eliminar());
       }
   }
}
