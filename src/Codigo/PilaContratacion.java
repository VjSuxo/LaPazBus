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
public class PilaContratacion {

   private Postulante[] pl = new Postulante[50];
   private int max = 50,tope=1;
   private static Scanner sc = new Scanner(System.in);
   
   
   public PilaContratacion(){
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
   
 
     
    public void adiElem(Postulante data){
        if(!esLlena()){
           pl[tope] = data;
           tope++;
       }
   }
   
   public void mostrar(){
       System.out.println("Mostrando Pila");
       PilaContratacion aux = new PilaContratacion();
       int n = tope;
       for(int i=0; i<=n-1;i++){
           Postulante x = eliminar();
           System.out.println(x.getNombre());
           aux.adiElem(x);
       }
       this.vaciar(aux);
   }
   
   public Postulante eliminar(){
       if(!esVacia()){
           Postulante x = pl[tope-1];
           tope--;
           return x;
       }
       else{
           return null;
       }
       
   }
   
   
   public void vaciar(PilaContratacion z){
       
       while(!z.esVacia()){
           this.adiElem(z.eliminar());
       }
   }
}
