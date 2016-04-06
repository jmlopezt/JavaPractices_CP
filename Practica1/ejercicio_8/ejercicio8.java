import java.util.Scanner;

class ejercicio8 {
		public static void main(String args[]) {
		int nelementos;
		int max;
		int[] array;
		int i;
		
		Scanner conin = new Scanner(System.in);
		System.out.println("Introduce tamaño del array: ");
		nelementos=conin.nextInt();
		array=new int[nelementos];
		
		do{
				for(i=0;i<nelementos;i++){
					System.out.println("Introduzca el elemento"+ i +":");
					array[i]=conin.nextInt();
				
				}
				
		}while (nelementos<0 || nelementos>100);
		
		max=array[0];
		
		for (i=1;i<nelementos;i++){
			if(array[i]>max){
				max=array[i];
			}
		}
		
		System.out.println("El número más alto es :"+max);
		
		}
		
	}

