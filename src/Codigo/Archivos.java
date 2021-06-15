/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Tostadora
 */
public class Archivos {
    
    
    FileWriter w;
    BufferedWriter bw;
    PrintWriter pw;
    String arch,datos="";
    JFileChooser selecionar = new JFileChooser();
    File archivo;
    
    public void crearCarpeta(){
        System.out.println("Creando carpeta principal . . . ");
        File crear_carpeta = new File("LaPazBus");
        crear_carpeta.mkdir();
    }
    
    public void crearCarpeta(String nombre){
        System.out.println("Creando carpeta... "+nombre);
        File crear_carpeta;
        crear_carpeta = new File("LaPazBus\\"+nombre);
        crear_carpeta.mkdir();
    }
    
    public void crearCarpeta(String carpeta,String nombre){
        System.out.println("Creando carpeta en "+carpeta+" con nombre "+nombre);
        File crear_carpeta;
        crear_carpeta = new File("LaPazBus\\"+carpeta+"\\"+nombre);
        crear_carpeta.mkdir();
    }
    
    public int buscarCarpeta(String nombre){    
        int sw = 0;      
        File f = new File("LaPazBus");
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            String s = "LaPazBus"+ "\\" +nombre;
            String p = file.toString();
            if(p.equals(s)){
                System.out.println("Carpeta encontrada");
               sw = 1;                
            }            
        }        
      return sw;        
    }
    
    public int buscarCrpt(String nombre,String direccion){    
        int sw = 0;      
        File f = new File("LaPazBus"+"\\"+direccion);
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            String s = "LaPazBus"+ "\\" +direccion+"\\"+nombre;
            String p = file.toString();
            if(p.equals(s)){
                System.out.println("Carpeta encontrada");
               sw = 1;                
            }            
        }        
      return sw;        
    }
    
    public int contarCarpeta(String carpeta){
        int sw = 0; 
        File f = new File("LaPazBus"+"\\"+carpeta);
        File[] listFiles = f.listFiles();
            for (File file : listFiles) {
                String p = file.toString();
                System.out.println(p);
                
                    sw +=1;                
                            
            }
        return sw;
    }
    
    public int contarCarpeta(String carpeta,String nombre,int rango){
        
        int sw = 0;      
        File f = new File("LaPazBus"+"\\"+carpeta);
        File[] listFiles = f.listFiles();
        if(rango!=-1){
            System.out.println("Ingreso a "+carpeta);
            for (File file : listFiles) {
                String s = "LaPazBus"+ "\\" +nombre;
                String p = file.getName().toString();
                String x = p.substring(0,1);
                if(x.equals(nombre)){
                    sw ++;  
                }            
            }        
        }
        else{
        
            for (File file : listFiles) {
                String s = "LaPazBus"+ "\\" +nombre;
                String p = file.toString();
                System.out.println(p);
                if(p.equals(s)){
                    sw +=1;                
                }            
            }            
            
        }
      return sw;   
    
    }    

    
    
    public String[] cargarCarpeta(String carpeta,String[] s){
        int j = 0 ;
        File f = new File("LaPazBus\\"+carpeta);
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            
            String p = file.getName().toString();
                    s[j] =  file.getName();
                     System.out.println(s[j]);
                        j++;
                
        }
        return s; 
    }
    
    
    public void crearArchivos(String carpeta,String archivo,String s){
        
        try {
            File crear_archivo = new File("LaPazBus"+"\\"+carpeta,archivo);
            System.out.println("---------------* * * * ----------------");
            System.out.println("Nombre : "+archivo);
            System.out.println(crear_archivo);
            System.out.println("--------------- * * * * ----------------");
               crear_archivo.createNewFile();
                w= new FileWriter(crear_archivo);
                bw= new BufferedWriter(w);
                pw=new PrintWriter(bw);
                pw.write(s);
                arch=archivo;
                pw.close();
                bw.close();
        } catch (IOException ex) {
            System.out.println("No se pudo");
        }
    }
    
    
    public int ContarArchivos(String carpeta){
        int c = 0 ;
        String s = "";
        File f = new File("LaPazBus"+"\\"+carpeta);
        System.out.println("Direccion que se estan contando "+f);
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            s = file.getName();
            c++;
        }
        return c;
    }
    
    
    public int ContarArchivos(String carpeta,String t){
        int c = 0 ;
        String s = "";
        File f = new File("LaPazBus"+"\\"+carpeta);
        System.out.println("Direccion que se estan contando "+f +" nombre buscado "+t);
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
        s = file.getName();
           if((s.substring(0,3)).equals(t.substring(0,3))){
               c++;
           }
        }
        return c;
    }
  
    public int ContarArchivos2(String carpeta){
        int c = 0 ;
        String s = "";
        File f = new File("LaPazBus"+"\\"+carpeta);
        System.out.println("Direccion que se estan contando "+f);
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            s = file.getName();
            c++;     
        }
        return c;
    }
    
    public String[] cargarArchivos(String carpeta,String[] s){
        int j = 0 ;
        
        File f = new File("LaPazBus\\"+carpeta);
        File[] listFiles = f.listFiles();
        System.out.println(f);
        for (File file : listFiles) {
                    s[j] =  file.getName();
                     System.out.println(s[j]);
                        j++;
                
        }
        return s; 
    }
    
    public int econtarArchivos(String carpeta,String t){
        int c = 0 ;
        String s = "";
        File f = new File("LaPazBus"+"\\"+carpeta);
        System.out.println();
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
        System.out.println(file);
        s = file.getName();
        int tm = t.length();
           if((s).equals(t)){
               c++;
           }
        }
        System.out.println(c);
        return c;
    }
    
    public void EliminarArchivos(String carpeta,String t){
        int c = 0 ;
        String s = "";
        File f = new File("LaPazBus"+"\\"+carpeta);
        System.out.println(f);
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            System.out.println("Buscando");
        s = file.getName();
        int tm = s.length();
            
            if(s.substring(0, 4).equals("peon")){
                System.out.println(s.substring(0, 4)+" encontrado su id es "+s.substring(5));
                if((s.substring(4)).equals(t)){
                    JOptionPane.showMessageDialog(null,"Peon eliminado");
                    file.delete();
                }
            }
            else{
                System.out.println(s.substring(5));
                System.out.println(s.substring(0, 5)+" encontrado su id es" +" : "+s.substring(5)+"es comparado con "+t);
                
                if((s.substring(5)).equals(t)){
                    JOptionPane.showMessageDialog(null,"Soldado de mecha "+s.substring(0,5)+" eliminado");
                    file.delete();
                }
                
            }
        }
    }
    
    public void eliminaArchivo(String carpeta,String t){
        int c = 0 ;
        String s = "";
        File f = new File("LaPazBus"+"\\"+carpeta);
        System.out.println(f);
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            System.out.println("Buscando");
            s = file.getName();
            int tm = s.length();
            
            if(s.equals(t)){
                System.out.println("Encontrado "+s);
                    
                    file.deleteOnExit();
            }
            
        }
    }
    
    public String[] leerArchivos(String nom,String tipo,int cantidad) {
        
        String []arreglo=null;
        String []ve = new String[cantidad];
        int indice = 0;
        
            String ss="";
            boolean s = false;
            int i=0,cont=0;
            String dir = "LaPazBus"+"\\"+nom+"\\"+tipo;
            System.out.println(dir);
            File fr = new File(dir);
            
            if(fr.exists()){
                FileReader r = null;
                try {
                    r = new FileReader(dir);
                    BufferedReader buf = new BufferedReader(r);
                    String temp = "";
                    while(temp!=null){
                        try {
                            temp = buf.readLine();
                        } catch (IOException ex) {
                            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(temp==null){
                            break;
                        }
                        
                        String x;
                        x=temp;
                        arreglo = x.split(" ");
                        System.out.println("tamaño arreglo"+arreglo.length);
                        while(true){
                            ss = ss+arreglo[i];
                            ve[indice] = arreglo[i];
                            indice++;
                            i++;
                            System.out.println("i "+i);
                            if(i>=arreglo.length){
                                i=0;
                                break;
                            }
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        r.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               
            }        
        return ve;        
        
    }
    
    public String leerArchivos2(String nom,String tipo) {
        
        String []arreglo=null;
        String []ve;
        
        
            String ss="";
            boolean s = false;
            int i=0,cont=0;
            String dir = "LaPazBus"+"\\"+nom+"\\"+tipo;
            File fr = new File(dir);
            
            if(fr.exists()){
                FileReader r = null;
                try {
                    r = new FileReader(dir);
                    BufferedReader buf = new BufferedReader(r);
                    String temp = "";
                    while(temp!=null){
                        try {
                            temp = buf.readLine();
                        } catch (IOException ex) {
                            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(temp==null){
                            break;
                        }
                        
                        String x;
                        x=temp;
                        arreglo = x.split(" ");
                        while(true){
                            ss = ss+" "+arreglo[i];
                            i++;
                            if(i>=arreglo.length){
                                i=0;
                                break;
                            }
                        }
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        r.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               
            }
        
        return ss;        
        
    }
    
    public void Adicionararchivo(String carpeta,String archivo,String s){
        try {
            File crear_archivo = new File(carpeta+archivo);
            
            if(crear_archivo.exists()){
                w= new FileWriter(crear_archivo,true);
                bw= new BufferedWriter(w);
                bw.newLine();
                pw=new PrintWriter(bw);
            }
            else{
                crear_archivo.createNewFile();
                w= new FileWriter(crear_archivo);
                bw= new BufferedWriter(w);
                pw=new PrintWriter(bw);
            }
            
            pw.write(s);
            pw.close();
            bw.close();
            
            } catch (IOException ex) {
            
                System.out.println("Datos no agregados");
            }
    }
    
    public void moverArchivos(String carpeta,String lugarx,String lugary,int posi){
        
        int c = 0 ;
        String s = "";
        File f = new File("LaPazBus"+"\\"+carpeta+lugarx);
        File[] listFiles = f.listFiles();
        for (File file :listFiles) {
             
             if(c==posi){
                 s = file.getName();
                 JOptionPane.showMessageDialog(null,"El peon con nro:  "+s+" le fue arrebatado su carga y es movido a descanso");
                 file.delete();
                 break;
             }
             c++;
        }
        crearArchivos(carpeta+"\\"+lugary, s,"descansando");
    
    }
    
    public void moverArchivos2(String carpeta,String lugarx,String lugary,String nombre){
        
        String  c ;
        String s = "";
        File f = new File("LaPazBus"+"\\"+carpeta+lugarx);
        System.out.println(f);
        File[] listFiles = f.listFiles();
        for (File file :listFiles) {
            
            c = file.getName();
            
             if(c.equals(nombre)){
                 s = file.getName();
                 JOptionPane.showMessageDialog(null,nombre+" movido con exito");
                 file.delete();
                 break;
             }
             
        }
        crearArchivos(carpeta+"\\"+lugary, s,"descansando");
    
    }
    
    
}
