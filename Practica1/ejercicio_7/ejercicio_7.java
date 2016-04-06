import java.util.Scanner;
	public class ejercicio_7 {
		/** metodo Main */
		public static void main(String[] args) {
			Scanner entrada = new Scanner(System.in);
			// Pedir al usuario que introduzca el anio
			System.out.print("Introduce el anio (e.g., 2016): ");
			int anio = entrada.nextInt();
			// Pedir al usuario que introduzca el mes
			System.out.print("Introduce el mes en rango 1 a 12: ");
			int mes = entrada.nextInt();
			// Imprimir el calendario
			imprimirMes(anio, mes);
			imprimirCuerpoMes(anio, mes);
			System.out.println("");
	}

	/** Imprimir el calendario para el mes y anio */
		public static void imprimirMes(int anio, int mes) {

			//System.out.println(mes + " " + anio);
			imprimirTituloMes(anio,mes);
		}

	/** Imprir el titulo del mes, e.g., Febrero, 2016 */
		public static void imprimirTituloMes(int anio, int mes) {
			String TituloMes;
			TituloMes=obtenerNombreMes(mes);

			System.out.println("          "+TituloMes+" "+anio+" ");
			System.out.println("-----------------------------");
		}

	/** Obtener el nombre del mes */
		public static String obtenerNombreMes(int mes) {
			String[] Meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio",
							"Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
			int mesaux=mes-1;
			while(mes>=0 && mesaux<12){
				
				return Meses[mesaux];	
			}

			return "Error"; 
		}

	/** Imprimir el cuerpo del mes */
		public static void imprimirCuerpoMes(int anio, int mes) {
			String[] DiasSemana={"Lunes  ","Martes  ","Miércoles  ","Jueves  ","Viernes  ",
							"Sábado  ","Domingo"};
		int dia_comienzo=0;
		int indice_dia=0;
		int contador=1;
		boolean primera=true;
		int nblancos=0;

		// imprimo la lista de los dias de la semana
			for(int i=0;i<7;i++){
				System.out.print(DiasSemana[i]);
				if(i==6){
					System.out.println("");
				}
			}
		// imprimo el calendario propiamente dicho

			dia_comienzo=obtenerDiaComienzo(anio, mes);
			indice_dia=dia_comienzo;

			for(contador=1;contador<=obtenerNumeroDiasenMes(anio, mes);contador++){
				if(primera){
					if(dia_comienzo==0){// domingo
						nblancos=6;
					}
					else{ //los demás días
						nblancos=dia_comienzo-1;
					}

					for(int j=0;j<nblancos;j++){
						System.out.print("         ");
						primera=false;
					}
				}

				System.out.print(contador+"        ");

				if(indice_dia==0 || indice_dia%7==0){
					System.out.println("");
					
				}
				indice_dia++;

			}
			
			

		}

	/** Obtener el dia de comienzo del mes en un anio */
		public static int obtenerDiaComienzo(int anio, int mes) {
			int PRIMER_DIA_ENERO_1_1800 = 3;
			int numeroTotaldeDias;

			numeroTotaldeDias=obtenerNumeroTotalDias(anio,mes);

			return ((numeroTotaldeDias + PRIMER_DIA_ENERO_1_1800) % 7);

		}

	/** Obtener numero total de dias desde 1 de enero de 1800 */
		public static int obtenerNumeroTotalDias(int anio, int mes) {
			int contador=1800;
			int ndias=0;
			boolean bisiesto=false; 
			int diasAno=0;
			int asdf=0;
			int i=1;

			while(contador!=anio){
				bisiesto=esAnioBisiesto(contador);

				if (bisiesto){
					ndias=ndias+366;
				}
				else{
					ndias=ndias+365;
				}
				contador++;
			}
			if (contador==anio){
				while(i!=mes){
					
					diasAno=diasAno + obtenerNumeroDiasenMes(anio,i);
					i++;
				}
			}


			ndias=ndias+diasAno;
			return ndias; 
		}

	/** Obtener el numero de dias en un mes */
		public static int obtenerNumeroDiasenMes(int anio, int mes) {

			int[] ndiasMes={31,28,31,30,31,30,31,31,30,31,30,31};
			int[] ndiasMes_bisiesto={31,29,31,30,31,30,31,31,30,31,30,31};
			boolean bisiesto=false;
			int ndias=0;

			bisiesto=esAnioBisiesto(anio);

			if(bisiesto){
				ndias=ndiasMes_bisiesto[mes-1];
			}
			else{
				ndias=ndiasMes[mes-1];
			}
		return ndias;
		}

	/** Ver si un anio es bisiesto */
		public static boolean esAnioBisiesto(int anio) {

			if ((anio % 400 == 0) || ((anio % 4 == 0) && (anio % 100 != 0))){
				return true;
			}
			return false; 
		}
}

