package taller1app;

import java.io.*;
import ucn.*;

public class Taller1App {

	//Funciones
	public static int LecturaTxtJuegos(String [] C, String [] NG, int [] Y, int [] PV, int [] PG, int [] CV){
		ArchivoEntrada Juegos = new ArchivoEntrada("juegos.txt");
		int cantJuegos = 0
		while(!Juegos.isEndFile()){
			Registro regJuego = Juegos.getRegistro();

			// Se obtienen los datos
			String Codigo    = regJuego.getString();
			String NombreG   = regJuego.getString();
			int Year         = regJuego.getInteger(); // corregir
			int PrecioVenta  = regJuego.getInteger();
			int PGanancia    = regJuego.getInteger();
			int CantVendida  = regJuego.getInteger;

			// Se almacenan los datos
			C[cantJuegos]  = Codigo;
			NG[cantJuegos] = NombreG;
			Y[cantJuegos]  = Year;
			PV[cantJuegos] = PrecioVenta;
			PG[cantJuegos] = PGanancia;
			CV[cantJuegos] = CantVendida;

			cantJuegos++;}
			Juegos.close();
			return cantJuegos;
		}

	public static int LecturaTxtJuegosCAT(String [] CodJ, String [] CatJ){
		ArchivoEntrada catJuegos = new ArchivoEntrada("categorias.txt");
		int cantCJuegos = 0
		while(!catJuegos.isEndFile()){
			Registro regCJuegos = catJuegos.getRegistro();

			// Se obtienen los datos
			String CodigoJ = regJuego.getString();
			String CatJ    = regJuego.getString();

			// Se almacenan los datos
			CodJ[cantCJuegos]  = CodigoJ;
			CatJ[cantCJuegos]  = CatJ;

			cantCJuegos++;}
			catJuegos.close();
			return cantCJuegos;
		}

	//Calcular ganancia
	public static double CalcularGanancia(int pventa, int pganancia){
			double Porcentaje = (double) pganancia/100
			double Ganancia   = (double) pventa*Porcentaje;
		
			return Ganancia;
		}

	//calcular ganancia total
	public static double CalcularGananciaTotal(int pventa, int pganancia, int cvendida){
			double Porcentaje = (double) pganancia/100
			double Ganancia   = (double) pventa*Porcentaje;
			double GananciaTotal = Ganancia * cvendida
		
			return GananciaTotal;
		}

	public static void BusquedaCategoriaArray(String [] CategoriasBase, String [] CategoriasIng,String [] AuxNomJuego){  // base lectura / ing ingresadas
    	int x = 0; int y=0;
    	for(i = 0; i<CategoriasIng.length;i++){
    		for(y = 0 ; y<cantCJuegos;y++){
    			if(CategoriasIng[i].equals(CategoriasBase[y]);){
    			AuxNomJuego[x] = CodigoJuego[i];
    			x++;}
				}
    		}// fin del for

    public static void BusquedaCategoria(String Categoria, String [] CategoriasBase,String [] Aux){  // base lectura / ing ingresadas
    	int x = 0; int y=0;
    	for(i = 0; i<CategoriasBase.length;i++){
    		if(Categoria.equals(CategoriasBase[i])){
    			Aux[x] = CodigoJuego[i];
    			x++;
    		}
    	}// fin del for
    }

	public static void EliminarRepetidos(String [] Array){
    	for(int i=0;i<Array.length;i++){
			for(int j=0;j<Array.length-1;j++){
				if(i!=j){
					if(Array[i]==Array[j]){
						// Reemplazamos el valor repetido con un 0
						arraycar[i]="0";
					}
				}
			}
		}
	}
	//Funcion main
    public static void main(String[] args) throws IOException {

    	//Inicializacion Matrices

    	//Inicializacion Arreglos de la Matriz Juegos
    	String Codigo[]    = new Codigo[20];
    	String NombreG[]   = new NombreG[20];
    	int Year[]         = new Year[20];
    	int PrecioVenta[]  = new PrecioVenta[20];
    	int PGanancia[]    = new PGanancia[20];
    	int CVendida[]     = new CVendida[20];

    	//Inicializacion Arreglos de la Matriz Juegos
    	String CodigoJuego[] = new CodigoJuego[65];
    	String CateJuego[]   = new CateJuego[65];

    	//Inicializacion Lectura de datos y Almacenamiento
    	int cantJuegos  = LecturaTxtJuegos(Codigo,NombreG,Year,PrecioVenta,PGanancia,CVendida);
    	int cantCJuegos = LecturaTxtJuegosCAT(CodigoJuego,CateJuego);


    	//Inicio Menu

    	//RF1
    	StdOut.println("(1) - Juego Mas Vendido / Juego con Mas Ganancia");
    	StdOut.println("Ingrese un year: "); //Corregir
    	int year = StdIn.ReadInt;
    	int i = 0; int j = 0;
    	int cantAux = 0;
    	double Ganancia; double gananciaAux;
    	String nombreAux1[] = new nombreAux1[20];
    	String nombreAux2[] = new nombreAux2[20];


    	double auxGTotal    = new auxPorcGanancia[20];
    	int cantidadV[]     = new cantidadV[20];


    	//Busca y almacena los juegos que cumplen el año ingresado
    	for(i = 0; i<cantJuegos;i++){
    		if (year.equals(Year[i]);){
    			Ganancia = 0;
    			nombreAux1[cantAux]  = NombreG[i];
    			nombreAux2[cantAux]  = NombreG[i];
    			cantidadV[cantAux]   = CVendida[i];

    			//Calculo Ganancia
    			Ganancia = CalcularGananciaTotal(PrecioVenta[i],PGanancia[i],CVendida)
    			auxGTotal[cantAux]   = Ganancia;
    			cantAux++}
    	}

    	// Ordenamiento cantidad vendida
    	for(i = 0; i<=cantAux-2;i++){
    		for(j = i+1; j<=cantAux-1;j++){
    			if(cantidadV[i]<cantidadV[j]){
    				String auxNombre; int auxCantidad;
    				auxNombre      = nombreAux1[i];
    				nombreAux1[i]  = nombreAux1[j];
    				nombreAux1[j]  = auxNombre

    				auxCantidad    = cantidadV[i];
    				cantidadV[i]   = cantidadV[j];
    				cantidadV[j]   = auxCantidad;
    			}
    		}
    	}

    		// Ordenamiento ganancias vendidas
    		for(i = 0; i<=cantAux-2;i++){
    		for(j = i+1; j<=cantAux-1;j++){
    			if(cantidadV[i]<cantidadV[j]){
    				String auxNombre; int auxCantG;
    				auxNombre      = nombreAux2[i];
    				nombreAux2[i]  = nombreAux2[j];
    				nombreAux2[j]  = auxNombre

    				auxCantG       = auxGTotal[i];
    				auxGTotal[i]   = auxGTotal[j];
    				auxGTotal[j]   = auxCantG;
    			}
    			}
    		}

    		// print resultados posicion 0

    //RF2
    StdOut.println("(2) - Ganancia total de ventas en Categorias");
    StdOut.println("Categorias Existentes (26):");
    StdOut.println("Anime||Accion||Aventura||Caceria||Carreras||Deportes||Dificil");
    StdOut.println("Estrategia||Fantasia||FPS||JRPG||Lucha||MMORPG||Multijugador||Mundo Abierto");
    StdOut.println("Plataforma||Primera Persona||PvP||Rol||Shooter||Simulador||Steampunk||Survival");
    StdOut.println("Terror||Un jugador||Visual Novel");
    StdOut.println("------------------------------------------------------------------------------");
    int contador = 0;
    String auxAlmaCat[] = new auxAlmaCat[26];
    StdOut.println("Ingrese una categoria (-1 para finalizar): ");
    String categoria    = StdIn.ReadString;
    auxAlmaCat[0]       = categoria;
    contador++;

    while(!categoria.equals("-1")||contador!=26){
    	StdOut.println("Ingrese una categoria (-1 para finalizar): ");
    	String categoria = StdIn.ReadString;
    	contador++}

    String AuxNomJuego[] = new AuxNomJuego[65];

    BusquedaCategoriaArray(CateJuego,auxAlmaCat,AuxNomJuego);

    //Eliminamos repetidos
    EliminarRepetidos(AuxNomJuego);
    int j;
   	double GananciaT;
    for(i = 0; i<AuxNomJuego.length;i++){
    	for(j=0; j<cantJuegos;j++){
    		if (AuxNomJuego[i].equals(Codigo[j]);){
    			//Calculo Ganancia
    			GananciaT  = CalcularGananciaTotal(PrecioVenta[i],PGanancia[i],CVendida);}
    	}
    }

    //Impresion Resultado

    StdOut.println("La Ganancia Total de las "+(auxAlmaCat.length+1)+" categoria(s) es: "+GananciaT);
    //RF3
    StdOut.println("(3) - Top Ten ");
    StdOut.println("Categorias Existentes (26):");
    StdOut.println("Anime||Accion||Aventura||Caceria||Carreras||Deportes||Dificil");
    StdOut.println("Estrategia||Fantasia||FPS||JRPG||Lucha||MMORPG||Multijugador||Mundo Abierto");
    StdOut.println("Plataforma||Primera Persona||PvP||Rol||Shooter||Simulador||Steampunk||Survival");
    StdOut.println("Terror||Un jugador||Visual Novel");
    StdOut.println("------------------------------------------------------------------------------");
    StdOut.println("Ingrese una categoria: ");

    int i;int j;int iaux = 0

    String categoria    = StdIn.ReadString;
    String  auxTOPTEN[] = new auxTOPTEN[10];
    int cantvenTOPTEN[] = new cantvenTOPTEN[10];
    BusquedaCategoria(categoria,CateJuego,auxTOPTEN);

    //Busca
	for(i = 0; i<auxTOPTEN.length;i++){
		for(j=0;j<Codigo.length;j++){
			if (auxTOPTEN[i].equals(Codigo[j])){
			cantvenTOPTEN[iaux]   = CVendida[i];
			iaux++
			}
		}
	}

	// Ordenamiento ganancias vendidas
    for(i = 0; i<=cantAux-2;i++){
		for(j = i+1; j<=cantAux-1;j++){
			if(cantvenTOPTEN[i]<cantvenTOPTEN[j]){
				String auxN; int auxC;
				auxN               = auxTOPTEN[i];
				auxTOPTEN[i]       = auxTOPTEN[j];
				auxTOPTEN[j]       = auxN;

				auxC               = cantvenTOPTEN[i];
				cantvenTOPTEN[i]   = cantvenTOPTEN[j];
				cantvenTOPTEN[j]   = auxC;
    		}	
    	}
    }


    }//fin del main
}
