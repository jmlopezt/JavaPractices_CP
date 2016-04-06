import java.util.Scanner;

class ejercicio11 {
	
	public static void ScanArray2D (int[][] array,Scanner conin,int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
			System.out.println("Introduzca el elemento de la fila "+ i + " correspondiente a la columnna "+ j + " :");
			array[i][j]=conin.nextInt();
			}
		}
	}

	public static int CalcTraza (int[][] array, int n)
	{
	int traza=0;
		for(int i=0;i<n;i++)
		{
			traza+=array[i][i];
		}
		return traza;
	}

	public static void ImprimeArray2D (int[][] array, int n)
	{
		System.out.println("La matriz es la siguiente");
		
		for(int i=0;i<n ; i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(" " +array[i][j]+ " ");
			}
		System.out.println(" ");
		}
	}
	
	public static void main (String [] args)
	{
		int nelementos, traza;
		int[][] array;
		
		Scanner conin = new Scanner(System.in);
		System.out.println("INtroduzca la longitud del array :");
		
		nelementos=conin.nextInt();
		array=new int[nelementos][nelementos];	
			
			
		ScanArray2D(array,conin,nelementos);
		traza=CalcTraza(array,nelementos);
		ImprimeArray2D(array,nelementos);
		
		System.out.println("La traza resultante es :" + traza);


	}
}
