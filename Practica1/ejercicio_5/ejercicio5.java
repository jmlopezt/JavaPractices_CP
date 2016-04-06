import java.util.Scanner;

class ejercicio5 {

	public static boolean EsPrimo(int varInt) {
		
	int contador=2;
	boolean primo=true;

	while ((primo) && (contador!=varInt)){

		if(varInt % contador ==0)
			primo=false;
	contador++;
	}

	return primo;
	}
	


	public static void Imprime(int numero) { // imprime los primos inferiores a numero
		int i=1;
		int limite=0;
		boolean primo;
		int contador=2;

		Scanner conin = new Scanner(System.in);


		while (contador!=numero){
			primo=EsPrimo(contador);

				if (limite==10){
					System.out.println(" ");
					limite=0;
				}
				if (primo){
					System.out.print(" "+contador);
					limite++;			
				}
			contador++;
			
		}
	
	}



	public static void MetodoAlternativo(int numero) { // imprime n primos 
		int i=1;
		int limite=0;
		boolean primo;
		int nprimos=0;
		int contador=2;

		Scanner conin = new Scanner(System.in);

		while(nprimos<numero){
			primo=EsPrimo(contador);

			if (limite==10){
				System.out.println(" ");
				limite=0;
			}
			if (primo){
				System.out.print(" "+contador);
				limite++;
				nprimos++;		
			}
		contador++;

	
		}
	}


	public static void main(String args[]) {
		int varInt;

		Scanner conin = new Scanner(System.in);
		System.out.println("Introduce un número int: ");
		varInt=conin.nextInt();
		System.out.println("Los primos inferiores a "+varInt+" son:");
		Imprime(varInt);
		System.out.println("");
		System.out.println("Los primeros "+varInt+" nº primos son: ");
		MetodoAlternativo(varInt);
		System.out.println("");


	}

}







