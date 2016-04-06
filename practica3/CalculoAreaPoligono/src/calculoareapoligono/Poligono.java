/*
/* ************ Juan Manuel López Torralba *******************
 * 4º Curso Grado Ingeniería de Tecnología de Telecomunicación
 * Especialidad: Sistemas de Telecomunicación
 * Asignatura: CP (Complementos de Programación)
 * Optativa Telemática
 */



package calculoareapoligono;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;



/**
 *
 * @author Juanma
 */

public class Poligono{
    private static Punto ptos[]; // array con los vértices del Poligono
    private static int numPuntos=0; // número de puntos que tiene ahora el Poligono
    
    private double radiocirculo;
    private Punto centrocirculo;

    
    /**
     * Este constructor de Poligono reserva espacio
     * para 4 vertices 
     * y los inicializa a 0. 
    */
    Poligono() {
        ptos=new Punto[4];
        numPuntos=0;
    }

    
    /**
     * Este es un constructor con el cual obtenemos un polígono a a partir de 
     * un círculo y el numero deseado de vertices del futuro poligono
    */
    Poligono(Circulo circulo,int nvertices){
        double alfa=2*PI/nvertices;
        double x,y;
        
        radiocirculo=circulo.LeerRadio();
        centrocirculo=circulo.CentroCirculo();
        ptos=new Punto[nvertices];
        
        for(int i=0;i<nvertices;i++){
           x=centrocirculo.ObtieneCoordenada_x()+radiocirculo*cos(i*alfa);
           y=centrocirculo.ObtieneCoordenada_y()+radiocirculo*sin(i*alfa);        
           ptos[i]=new Punto(x,y);
           numPuntos++;
        }
        
    }
    
    
    
    /**
     * Este metodo añade el punto @param p al array
     * si no cupiera, dobla además la capacidad del array
     */
    public void anadepunto(Punto p){
    
        if (numPuntos==ptos.length){
            Punto[] aux;
            aux = new Punto[2*numPuntos];
            System.arraycopy(ptos, 0, aux, 0, numPuntos);
            ptos=new Punto[2*numPuntos];
            ptos=aux;
        } else {
        }
        ptos[numPuntos]=p;
        numPuntos++;
    }
    
    /**
     * Este método devuelve el número de puntos del polígono
     */
    public int nPuntos(){
        return numPuntos;
    }
    
    /**
     * Éste método devuelve el enésimo @param n punto
     * de un polígono, y en caso de no tener, 
     * devuelve @return null
     */
    public Punto ObtenerPunto(int n){
        if (n>ptos.length || n<0){
            return null;
        }
        else{
            System.out.println(n);
            ptos[n-1].EscribePunto();  // me escribe por pantalla las coordenadas del punto solicitado
            return ptos[n-1];
        }
    } 
    
    
    
     /**
     * Éste método devuelve el  @param perimetro de un polígono, 
     */
    public double ObtenerPerimetro(){
        double perimetro=0,modulo=0;
        int i;
 
        for(i=0;i<numPuntos;i++){
            if(i==numPuntos-1){
                modulo=ptos[0].CalcDistEuclid(ptos[numPuntos-1].ObtieneCoordenada_x(), ptos[numPuntos-1].ObtieneCoordenada_y());
                perimetro=perimetro+modulo;
            }
            else{
                modulo=ptos[i].CalcDistEuclid(ptos[i+1].ObtieneCoordenada_x(), ptos[i+1].ObtieneCoordenada_y());
                perimetro=perimetro+modulo;
            }
        
        }
        return perimetro;
    }
    
     /**
     * Éste método devuelve un punto cualquiera del interior de un poligono
     */
        private Punto interiorPoligono(){
            return ptos[0];
    }
    
        
        
        
     /**
     * Éste método devuelve el @area de un triangulo a partir de la distancia
     * euclidea entre los puntos introducidos como parámetros.
     */
    private static double AreaTriangulo(Punto pto1,Punto pto2,Punto pto3){
        double T=0,area=0,S1=0,S2=0,S3=0;
        
        S1=pto1.CalcDistEuclid(pto2.ObtieneCoordenada_x(), pto2.ObtieneCoordenada_y());
        S2=pto2.CalcDistEuclid(pto3.ObtieneCoordenada_x(), pto3.ObtieneCoordenada_y());
        S3=pto3.CalcDistEuclid(pto1.ObtieneCoordenada_x(), pto1.ObtieneCoordenada_y());  
        T=(S1+S2+S3)/2;
        area=sqrt(T*(T-S1)*(T-S2)*(T-S3));
        
        return area;
    }
    
    
    
     /**
     * Éste método devuelve el @param n área de un polígono empleando la función 
     * AreaTriangulo
     */
    static double AreaPoligono(){
         double areapoligono=0;
         
         for(int i=0;i<numPuntos;i++){
            if(i==numPuntos-1){
                areapoligono=areapoligono+AreaTriangulo(ptos[0], ptos[numPuntos-1], ptos[0]);
            }
            else{
                areapoligono=areapoligono+AreaTriangulo(ptos[0], ptos[i], ptos[i+1]);
            }
         }

         return areapoligono;
    }
    
    
    
    

}
