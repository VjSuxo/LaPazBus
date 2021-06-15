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
public class PilaParada {
     private Parada[] pl = new Parada[50];
   private int max = 50,tope=1;
   private static Scanner sc = new Scanner(System.in);
   
   
   public PilaParada(){
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
   
  
   
    public void adiElem(Parada data){
        if(!esLlena()){
           pl[tope] = data;
           tope++;
       }
   }
   
   public void mostrar(){
       System.out.println("Mostrando Pila Parada");
       PilaParada aux = new PilaParada();
       int n = tope;
       for(int i=0; i<=n-1;i++){
           Parada data =eliminar();
           System.out.println("----------------------");
           System.out.println(data.mostrar());
           System.out.println("-----------------------");
       }
       this.vaciar(aux);
   }
   
   public Parada eliminar(){
       if(!esVacia()){
           Parada data = pl[tope-1];
           tope--;
           return data;
       }
       else{
           return null;
       }
       
   }
   
   
   public void vaciar(PilaParada z){
       
       while(!z.esVacia()){
           this.adiElem(z.eliminar());
       }
   }
}
