/*
/* ************ Juan Manuel López Torralba *******************
 * 4º Curso Grado Ingeniería de Tecnología de Telecomunicación
 * Especialidad: Sistemas de Telecomunicación
 * Asignatura: CP (Complementos de Programación)
 * Optativa Telemática
 */
package calculoareapoligono2;
import java.util.Scanner;
/**
 *
 * @author Juanma
 */
public class CalculoAreaPoligono2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        Scanner intro = new Scanner(System.in);
        System.out.println("Crear poligono manual ---> Pulse 1 \n"
                + "Crear poligono a parir de un circulo ---> Pulse 2");
        
        choice=intro.nextInt();
        
        if (choice==1){
            Poligono2 poligono=new Poligono2();
            
            System.out.println("Introduzca el número de vertices del poligono: ");
            int n=intro.nextInt();

        
            for(int i=0;i<n;i++){
                Punto p=new Punto();
                System.out.println("A continuación introduzca las coordenadas de los puntos: ");
                p.LeePunto();
                poligono.anadepunto(p);
            }
    
            System.out.println("El perimetro del polígono es :"+poligono.ObtenerPerimetro());
            System.out.println("El área del polígono es :"+poligono.AreaPoligono());
        }
        else{
            CalculoAreaCirculo2.main(args);
        }
    
    
    }  
}
