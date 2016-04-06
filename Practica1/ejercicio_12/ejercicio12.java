import java.util.Scanner;

class ejercicio12 {
	
	public static void ScanArray2D (int[][] array,Scanner conin,int mfilas,int ncolumnas)
	{
		for(int i=0;i<mfilas;i++)
		{
			for(int j=0;j<ncolumnas;j++)
			{
			System.out.println("Introduzca el elemento de la fila "+ i + " correspondiente a la columnna "+ j + " :");
			array[i][j]=conin.nextInt();
			}
		}
	}

	public static void ProductoMatrices (int[][] array1,int[][] array2,int arrayFinal[][],int m,int n,int p)
	{
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<p;j++)
			{
			arrayFinal[i][j]=0;
				for(int k=0;k<n;k++)
				{
					arrayFinal[i][j]+=array1[i][k]*array2[k][j];
				}
			}
		}
	}

	public static void ImprimeArray2D (int[][] array, int m,int n)
	{
		System.out.println("La matriz es la siguiente");
		
		for(int i=0;i<m ; i++)
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
		int mfilas,ncolumnas,pcolumnas;
		int[][] array1,array2,arrayFinal;
		
		Scanner conin = new Scanner(System.in);
		System.out.println("Introduzca el nº de filas de la primera matriz :");
		mfilas=conin.nextInt();
		System.out.println("Introduzca el nº de columnas de la primera matriz :");
		ncolumnas=conin.nextInt();
		System.out.println("Introduzca el nº de columnas de la segunda matriz :");
		pcolumnas=conin.nextInt();
		
		
		array1=new int[mfilas][ncolumnas];
		array2=new int[ncolumnas][pcolumnas];
		arrayFinal=new int[mfilas][pcolumnas];
			
			
		ScanArray2D(array1,conin,mfilas,ncolumnas);
		ScanArray2D(array2,conin,ncolumnas,pcolumnas);
		ProductoMatrices (array1,array2,arrayFinal,mfilas,ncolumnas,pcolumnas);
		
		System.out.println("La primera matriz es :\n");
		ImprimeArray2D(array1,mfilas,ncolumnas);
		
		System.out.println("La segunda matriz es :\n");
		ImprimeArray2D(array1,ncolumnas,pcolumnas);
		
		System.out.println("La matriz resultante de la multiplicación de la primera por la segunda es :\n");
		ImprimeArray2D(arrayFinal,mfilas,pcolumnas);


	}
}
