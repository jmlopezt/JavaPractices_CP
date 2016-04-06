import java.util.Scanner;

class ejercicio9 {
	
	public static void ScanArray (int[] array,Scanner conin)
	{
		do
		{
			for(int i=0;i<array.length;i++)
			{
				System.out.println("Introduzca el número "+ i + ": ");
				array[i]=conin.nextInt();
			}
		}
		while(array.length<0 || array.length>100);
	}

	public static void InvArray (int[] array)
	{
		for(int i=0;i<array.length/2;i++)
		{
			int aux;
			aux=array[i];
			array[i]=array[array.length-i-1];
			array[array.length-i-1]=aux;
		}
	}

	
	public static void main (String [] args)
	{
		int nelementos;			
		int[] array;
		Scanner conin = new Scanner(System.in);
		System.out.println("Introduzca la longitud del array :");
		nelementos=conin.nextInt();
		array=new int[nelementos];			
			
		ScanArray(array,conin);
		InvArray(array);
		
		System.out.println("El vector invertido es el siguiente");
		
		for(int i=0;i<nelementos ; i++){
			System.out.println( " " + array[i]);
		}
	
	
	
	
	}
}
