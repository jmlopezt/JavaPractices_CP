/*
/* ************ Juan Manuel López Torralba *******************
 * 4º Curso Grado Ingeniería de Tecnología de Telecomunicación
 * Especialidad: Sistemas de Telecomunicación
 * Asignatura: CP (Complementos de Programación)
 * Optativa Telemática
 */
package calculoareapoligono2;

import static java.lang.Math.pow;
import java.util.Scanner;

/**
 *La clase circulo representa las coordenadas en 2D de un punto; es decir, 
 * su centro. Ademas de su radio.
 * @author juanma
 */
public class Circulo {
    Scanner numbin = new Scanner(System.in);
    
    Punto centro;
    private double Radio;
    
    
/**
 * Este es un constructor que inicializa el circulo a 0
 */
    Circulo(){
        Punto punto =new Punto();
        centro=punto;
        Radio=0;
        
    }
    
    
 /**
 *Con este metodo defino el circulo
 */
    Circulo(double Radio,double x,double y){
        this.Radio=Radio;
        centro=new Punto(x,y);     
    }

 /**
 *Aquí defino/modifico el radio del cirulo
 * 
 */
    void RadioCirculo(double Radio){
        this.Radio=Radio;
    }
    

/**
 * Este método permite al usuario introducr los 
 * valores del circulo.
 * Para el centro hace una llamada al método 
 * corrspondiente en la clase punto y así definirlo
 */
    void LeeCirculo(){
        centro.LeePunto();
        System.out.println("Introduce el radio");
        Radio=numbin.nextDouble();     
    }
    
    
/**
 * Este método permite imprimir por pantalla
 * la definición del circulo.
 */
    void EscribeCirculo(){
        centro.EscribePunto();
        System.out.println("  "+Radio);
    }
    
 /**
 * Modifica el contenido del centro segun el valor devuelto 
 * por el metodo usando para cada coordenada
 */
    Punto CentroCirculo(){
        return centro;
    }
    
    
/**
 * Devuelve el radio
 */
    double LeerRadio(){
        return Radio;    
    }
    
    
/**
* Obtiene el área del circulo.
 */
    double AreaCirculo(){
    double area=Math.PI*pow(Radio,2);
    return area;
    }
}
