/*
/* ************ Juan Manuel López Torralba *******************
 * 4º Curso Grado Ingeniería de Tecnología de Telecomunicación
 * Especialidad: Sistemas de Telecomunicación
 * Asignatura: CP (Complementos de Programación)
 * Optativa Telemática
 */


package calculoareapoligono;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import java.util.Scanner;


/**
 *Esta clase contiene unicamente un metodo main() con el codigo necesario 
 * para calcular de forma aproximada el area de un circulo mediante el area 
 * de un poligono. Para ello, solicitara al usuario, el radio de un cırculo 
 * y las coordenadas x e y de su centro, para crear un objeto de la clase 
 * Circulo. 
 * 
 * Tambien solicitara el número de lados n que queremos que tenga el
 * polıgono. El programa debe escribir ahora el area del polıgono, y el 
 * area del cırculo.
 * 
 * @author Juanma
 */
public class CalculoAreaCirculo {
    
    public static void main(String[] args){
        Circulo circulo;
        Poligono poligono;
        Scanner conin = new Scanner(System.in);
        circulo = new Circulo();
        
        // leer radio y coordenadas x e y del c´ırculo
        System.out.println("Introduzca el radio del circulo: ");
        double radio=conin.nextDouble();
        System.out.println("Introduzca las coordenadas x e y del centro: ");
        double x=conin.nextDouble();
        double y=conin.nextDouble();
        
        // construyo el circulo
        circulo=new Circulo(radio,x,y);
        
        // leer numero lados n del pol´ıgono usado para aproximar el ´area del c´ırculo
        System.out.println("Introduzca el numero de vértices del poligono: ");
        int nvertices=conin.nextInt();
        
        //construyo el poligono para aproximar el circulo
        poligono = new Poligono(circulo, nvertices); 
        
        // Mostrar área del anterior Poligono (´area aproximada del círculo)
        System.out.println("El área del circulo aproximada por el poligono es :"+poligono.AreaPoligono());
        // Mostrar el área del Circulo con método de clase Circulo
        System.out.println("El área del Círculo es :"+circulo.AreaCirculo());
    }  
}
