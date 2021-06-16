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
public class PilaRuta {

   private Ruta[] pl = new Ruta[50];
   private int max = 50,tope=1;
   private static Scanner sc = new Scanner(System.in);
   
   
   public PilaRuta(){
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
   
  
   
    public void adiElem(Ruta data){
        if(!esLlena()){
           pl[tope] = data;
           tope++;
       }
   }
   
   public void mostrar(){
       System.out.println("Mostrando Pila");
       PilaRuta aux = new PilaRuta();
       int n = tope;
       for(int i=0; i<=n-1;i++){
           Ruta data =eliminar();
           System.out.println("-----------------------------");
           System.out.println(data.getNombreRuta());
           System.out.println("");
           System.out.println("---------------------------Bus");
           data.getBuses().mostrar();
           System.out.println("");
           System.out.println("-------------------------Bus Asiento");
           Bus b = data.getBuses().eliminar();
           b.getAsiento().mostrar();
           System.out.println("");
           System.out.println("------------------------Bus Personal");
           b.getDp().mostrar();
           System.out.println("");
           System.out.println("-----------------------Horario");
           data.getH().mostrar();
           System.out.println("");
           System.out.println("---------------------Parada");
           data.getP().mostrar();
           System.out.println("");
           System.out.println("---------------------Tarifa");
           data.getT().mostrar();
           System.out.println("-------------------------------");
           
           aux.adiElem(data);
       }
       this.vaciar(aux);
   }
   
   public Ruta eliminar(){
       if(!esVacia()){
           Ruta data = pl[tope-1];
           tope--;
           return data;
       }
       else{
           return null;
       }
       
   }
   
   
   public void vaciar(PilaRuta z){
       
       while(!z.esVacia()){
           this.adiElem(z.eliminar());
       }
   }
}
