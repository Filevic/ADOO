import java.util.ArrayList;
import java.util.Scanner;


public class cadenas extends extendido implements inter1 , inter2 , inter3 {

	
    public static void main(String[] args) {
        String cadena,cadena2,cadena3;
        Alfabeto a=new Alfabeto();
        Alfabeto v=new Alfabeto();
        
        
        
        int n=-2;
       
       String pal = null;
        System.out.println("el afabeto 1 es:  ");
        a.imprimirA();
        System.out.println("el alfabeto 2 es:  ");
        v.imprimirA();
        cadena=Alfabeto.Leer();
 
        
      do{
        if (a.Validar(cadena) )
            System.out.println("ok");
       else {
           System.out.println("palabra no aceptada ingresela nuevemente pero como debe de ser ");
           cadena=Alfabeto.Leer();    
       }
      }while(a.Validar(cadena)!=true); 
        System.out.println("palabra aceptadac\n\n");
      
       cadena2=Alfabeto.Leer();
    
     do{   
       if (a.Validar(cadena2) )
            System.out.println("ok");
       else {
           System.out.println("palabra no aceptada ingresela nuevemente pero como debe de ser ");
           cadena2=Alfabeto.Leer();
       }  
     }while(a.Validar(cadena2)!=true); 
            System.out.println("palabra aceptada\n\n");
     
        System.out.println("(w1w2)^n es:\n");
            Palabra.Multiplicar(cadena,cadena2,n); 
        
         
        System.out.println("ingrese la cadena en la que se va encontrar un determinado simbolo");
        Palabra b= new Palabra(Alfabeto.Leer());
        
        System.out.println("ingrese simbolo a buscar");
        String simboloTofind=Alfabeto.Leer();
        
        String imprimir= "se encontro el simbolo "+simboloTofind+", "+b.Ocurrencias(simboloTofind)+" veces";
        System.out.println(imprimir);
        
        Palabra.subcadenas(cadena, cadena2);
        Palabra.prefijos(cadena, cadena2);
        Palabra.sufijos(cadena, cadena2);
        
        System.out.println("Ingrsa la cadena 3 \n ");
        cadena3=Alfabeto.Leer();
        
      if(Palabra.espalindromo(cadena3)){
          System.out.println("La cadena es palindroma "  +cadena3);
        }
     else
        {
         System.out.println("No Palindromo "+cadena3);
        }
        
        System.out.println("Las combinaciones de E^N ");
        long x=3;
        Alfabeto.generarAlfabeto(a.rango,a.rango,x);
        
        System.out.println("El alfabeto generado de concatenar E1 y E2 es: \n");
        a.concatenarE(v);

public class cadenitas extends cadenas {
    }
    
}
