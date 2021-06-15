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
public class PilaHorario {
     private Horario[] pl = new Horario[50];
   private int max = 50,tope=1;
   private static Scanner sc = new Scanner(System.in);
   
   
   public PilaHorario(){
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
   
  
   
    public void adiElem(Horario data){
        if(!esLlena()){
           pl[tope] = data;
           tope++;
       }
   }
   
   public void mostrar(){
       System.out.println("Mostrando Pila horario");
       PilaHorario aux = new PilaHorario();
       int n = tope;
       for(int i=0; i<=n-1;i++){
           Horario data =eliminar();
           System.out.println(data.mostrar());
       }
       this.vaciar(aux);
   }
   
   public Horario eliminar(){
       if(!esVacia()){
           Horario data = pl[tope-1];
           tope--;
           return data;
       }
       else{
           return null;
       }
       
   }
   
   
   public void vaciar(PilaHorario z){
       
       while(!z.esVacia()){
           this.adiElem(z.eliminar());
       }
   }
}
