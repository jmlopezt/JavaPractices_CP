/*
/* ************ Juan Manuel López Torralba *******************
 * 4º Curso Grado Ingeniería de Tecnología de Telecomunicación
 * Especialidad: Sistemas de Telecomunicación
 * Asignatura: CP (Complementos de Programación)
 * Optativa Telemática
 */

package calculoareapoligono2;

import java.util.ArrayList;
import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/*
 * Hace lo mismo que Poligono pero usando ArrayList
 */

/**
 *
 * @author Juanma
 */

public class Poligono2{
    private static ArrayList<Punto> ptos = new ArrayList<>();
    private static int numPuntos=0; // número de puntos que tiene ahora el Poligono
    
    private double radiocirculo;
    private Punto centrocirculo;

    
    /**
     * Este constructor de Poligono reserva espacio
     * para 4 vertices 
     * y los inicializa a 0. 
    */
    Poligono2() {
        ptos=new ArrayList<>();
        numPuntos=0;
    }

    Poligono2(Circulo circulo,int nvertices){
        double alfa=2*PI/nvertices;
        double x,y;
        
        radiocirculo=circulo.LeerRadio();
        centrocirculo=circulo.CentroCirculo();
        ptos=new ArrayList<>();
        
        for(int i=0;i<nvertices;i++){
           x=centrocirculo.ObtieneCoordenada_x()+radiocirculo*cos(i*alfa);
           y=centrocirculo.ObtieneCoordenada_y()+radiocirculo*sin(i*alfa);        
           ptos.add(new Punto(x,y));
           numPuntos++;
        }
        
    }
    
    
    
    /**
     * Este metodo añade el punto @param p al array
     * si no cupiera, dobla además la capacidad del array
     */
    public void anadepunto(Punto p){
        ptos.add(p);
        numPuntos++;
    }
    
    /**
     * Este método devuelve el número de puntos del polígono
     */
    public int nPuntos(){
        return ptos.size();
    }
    
    /**
     * Éste método devuelve el enésimo @param n punto
     * de un polígono, y en caso de no tener, 
     * devuelve @return null
     */
    public Punto ObtenerPunto(int n){
        if (n>ptos.size() || n<0){
            return null;
        }
        else{
            System.out.println(n);
            return ptos.get(n);
        }
    } 
    
    public double ObtenerPerimetro(){
        double perimetro=0,modulo=0;
        int i;
 
        for(i=0;i<numPuntos;i++){
            if(i==numPuntos-1){
                modulo=ptos.get(0).CalcDistEuclid(ptos.get(numPuntos-1).ObtieneCoordenada_x(), ptos.get(numPuntos-1).ObtieneCoordenada_y());
                perimetro=perimetro+modulo;
            }
            else{
                modulo=ptos.get(i).CalcDistEuclid(ptos.get(i+1).ObtieneCoordenada_x(), ptos.get(i+1).ObtieneCoordenada_y());
                perimetro=perimetro+modulo;
            }
        
        }
        return perimetro;
    }
    
        private Punto interiorPoligono(){
            return ptos.get(0);
    }
    
    private static double AreaTriangulo(Punto pto1,Punto pto2,Punto pto3){
        double T=0,area=0,S1=0,S2=0,S3=0;
        
        S1=pto1.CalcDistEuclid(pto2.ObtieneCoordenada_x(), pto2.ObtieneCoordenada_y());
        S2=pto2.CalcDistEuclid(pto3.ObtieneCoordenada_x(), pto3.ObtieneCoordenada_y());
        S3=pto3.CalcDistEuclid(pto1.ObtieneCoordenada_x(), pto1.ObtieneCoordenada_y());  
        T=(S1+S2+S3)/2;
        area=sqrt(T*(T-S1)*(T-S2)*(T-S3));
        
        return area;
    }
    static double AreaPoligono(){
         double areapoligono=0;
         
         for(int i=0;i<numPuntos;i++){
            if(i==numPuntos-1){
                areapoligono=areapoligono+AreaTriangulo(ptos.get(0), ptos.get(numPuntos-1), ptos.get(0));
            }
            else{
                areapoligono=areapoligono+AreaTriangulo(ptos.get(0), ptos.get(i), ptos.get(i+1));
            }
         }

         return areapoligono;
    }
    
    
    
    

}
