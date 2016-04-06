import java.util.Scanner;

class ejercicio10 {
	
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

	public static int EliminaRepetidos (int[] array, int[] arrayNR)
	{
		int j=0;
		arrayNR[0]=array[0];
		for(int i=0;i<array.length;i++)
		{
			if(arrayNR[j] != array[i])
			{
				j++;
				arrayNR[j]=array[i];
			
			}
		}
		return j+1;
	}

	public static void ImprimeArray (int[] array, int[] arrayNR,int nelementos_NR)
	{
		System.out.println("El vector original es el siguiente");
		
		for(int i=0;i<array.length ; i++)
		{
			System.out.println( " " + array[i]);
		}
	
		System.out.println("El vector sin REPETIDOS es el siguiente");
		
		for(int j=0;j<nelementos_NR; j++)
		{
			System.out.println( " " + arrayNR[j]);
		}
	
	
	}
	
	public static void main (String [] args)
	{
		int nelementos, nelementos_NR;	
		int[] array, arrayNR;
		Scanner conin = new Scanner(System.in);
		System.out.println("INtroduzca la longitud del array :");
		nelementos=conin.nextInt();
		array=new int[nelementos];	
		arrayNR=new int[nelementos];
			
			
		ScanArray(array,conin);
		nelementos_NR=EliminaRepetidos(array, arrayNR);
		ImprimeArray(array, arrayNR,nelementos_NR);

	}
}
