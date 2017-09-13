/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1app;

import java.io.*;
import ucn.*;

/**
 *
 * @author D4C
 */
public class TALLER1APP {

// Funciones
public static int LecturaTxtJuegos(String [] C, String [] NG, int [] Y, int [] PV, int [] PG, int [] CV) throws IOException{
    ArchivoEntrada Juegos = new ArchivoEntrada("juegos.txt");
    int cantJuegos = 0;
    while(!Juegos.isEndFile()){
            Registro regJuego = Juegos.getRegistro();

            // Se obtienen los datos
            String Codigo    = regJuego.getString();
            String NombreG   = regJuego.getString();
            int Year         = regJuego.getInt(); // corregir
            int PrecioVenta  = regJuego.getInt();
            int PGanancia    = regJuego.getInt();
            int CantVendida  = regJuego.getInt();

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

	public static int LecturaTxtJuegosCAT(String [] CodJ, String [] CatJ) throws IOException{
            ArchivoEntrada catJuegos = new ArchivoEntrada("categorias.txt");
            int cantCJuegos = 0;
            while(!catJuegos.isEndFile()){
                    Registro regCJuegos = catJuegos.getRegistro();

                    // Se obtienen los datos
                    String CodigoJ = regCJuegos.getString();
                    String CategoriaJ    = regCJuegos.getString();

                    // Se almacenan los datos
                    CodJ[cantCJuegos]  = CodigoJ;
                    CatJ[cantCJuegos]  = CategoriaJ;

                    cantCJuegos++;
            }
            catJuegos.close();
            return cantCJuegos;
        }

	//Calcular ganancia
	public static double CalcularGanancia(int pventa, int pganancia){
            double Porcentaje = (double) pganancia/100;
            double Ganancia   = (double) pventa*Porcentaje;
            return Ganancia;
            }

	//calcular ganancia total
	public static double CalcularGananciaTotal(int pventa, int pganancia, int cvendida){
            double Porcentaje = (double) pganancia/100;
            
            double Ganancia   = (double) pventa*Porcentaje;
            
            double GananciaTotal = Ganancia * cvendida;
            
            return GananciaTotal;
            }

	public static void BusquedaCategoriaArray(String [] CategoriasBase, 
                String [] CategoriasIng,
                String[] CodigosJuego,String [] AuxNomJuego,int contador){  // base lectura / ing ingresadas
    	int i; int x=0; int y;
    	for(i = 0; i<contador;i++){
    		for(y=0 ; y<CategoriasBase.length;y++){
    			if(CategoriasIng[i].equals(CategoriasBase[y])){
                            AuxNomJuego[x] = CodigosJuego[y];
                            StdOut.println(AuxNomJuego[x]);
    			x++;}
                }
    	}// fin del for
        }
        public static void BusquedaCategoria(String Categoria, String [] CategoriasBase, 
                String [] CodigosJuego, String [] Aux){
    	int i; int x = 0;
    	for(i = 0; i<CategoriasBase.length-1;i++){
    		if(Categoria.equals(CategoriasBase[i])){
    			Aux[x] = CodigosJuego[i];
    			x++;
    		}
    	}
        }

	public static void EliminarRepetidos(String [] Array){
    	for(int i=0;i<Array.length;i++){
			for(int j=0;j<Array.length-1;j++){
				if(i!=j){
					if(Array[i]==Array[j]){
						// Reemplazamos el valor repetido con un 0
						Array[i]="0";
					}
				}
			}
		}
	}
        
        
        public static void RF1(int cantJuegos, int [] Year, String [] NombreG
        , int [] CVendida, int [] PrecioVenta,int [] PGanancia){
        StdOut.println("(1) - Juego Mas Vendido / Juego con Mas Ganancia");
    	StdOut.println("Ingrese un year: "); //Corregir
    	int year = StdIn.readInt();
    	int i; int j;
    	int cantAux = 0;
    	double Ganancia;
    	String [] nombreAux1 = new String[20];
    	String [] nombreAux2 = new String[20];


    	double [] auxGTotal  = new double [20];
    	int    [] cantidadV  = new int[20];


    	//Busca y almacena los juegos que cumplen el año ingresado
    	for(i = 0; i<cantJuegos;i++){
            if (year == Year[i]){
                nombreAux1[cantAux]  = NombreG[i];
                nombreAux2[cantAux]  = NombreG[i];
                cantidadV[cantAux]   = CVendida[i];

                //Calculo Ganancia
                Ganancia = CalcularGananciaTotal(PrecioVenta[i],PGanancia[i],CVendida[i]);
                auxGTotal[cantAux]   = Ganancia;
                cantAux++;}
    	}

    	// Ordenamiento cantidad vendida
    	for(i = 0; i<=cantAux-2;i++){
            for(j = i+1; j<=cantAux-1;j++){
    		if(cantidadV[i]<cantidadV[j]){
                    String auxNombre; int auxCantidad;
                    auxNombre      = nombreAux1[i];
                    nombreAux1[i]  = nombreAux1[j];
                    nombreAux1[j]  = auxNombre;

                    auxCantidad    = cantidadV[i];
                    cantidadV[i]   = cantidadV[j];
                    cantidadV[j]   = auxCantidad;
    		}
            }
    	}

    	// Ordenamiento ganancias vendidas
        for(i = 0; i<=cantAux-2;i++){
            for(j = i+1; j<=cantAux-1;j++){
                if(auxGTotal[i]<auxGTotal[j]){
                    String auxNombre; double auxCantG;
                    auxNombre      = nombreAux2[i];
                    nombreAux2[i]  = nombreAux2[j];
                    nombreAux2[j]  = auxNombre;

                    auxCantG       = auxGTotal[i];
                    auxGTotal[i]   = auxGTotal[j];
                    auxGTotal[j]   = auxCantG;
                }
                }
        }
        StdOut.println(nombreAux1[0]+" - Cantidades Vendidas:"+cantidadV[0]);
        StdOut.println(nombreAux2[0]+" - Ganancia Total:"+auxGTotal[0]);

    		// print resultados posicion 0
        }
        
    //RF2
    public static void RF2(String [] CateJuego,String[] CodigoJuego, 
            String [] Codigo, int [] PrecioVenta,int [] PGanancia,int [] CVendida){
    StdOut.println("(2) - Ganancia total de ventas en Categorias");
    StdOut.println("Categorias Existentes (26):");
    StdOut.println("Anime||Accion||Aventura||Caceria||Carreras||Deportes||Dificil");
    StdOut.println("Estrategia||Fantasia||FPS||JRPG||Lucha||MMORPG||Multijugador||Mundo Abierto");
    StdOut.println("Plataforma||Primera Persona||PvP||Rol||Shooter||Simulador||Steampunk||Survival");
    StdOut.println("Terror||Un jugador||Visual Novel");
    StdOut.println("------------------------------------------------------------------------------");
    int contador = 0;
    String [] auxAlmaCat = new String [26];
    StdOut.println("Ingrese una categoria (-1 para terminar): ");
    String categoria    = StdIn.readString();
    if(categoria.equals("-1")){StdOut.println("Se acabo");}
    else{
    auxAlmaCat[0]       = categoria;
    contador++;
    while (!categoria.equals("-1")&&contador<26) {
	StdOut.println("Ingrese una categoria (-1 para terminar): ");
    categoria    = StdIn.readString();
    auxAlmaCat[contador]       = categoria;
    contador++;
	}
    /**
    StdOut.println("Ingrese una categoria: ");
    String categoria    = StdIn.readString();
    auxAlmaCat[0]       = categoria;
    contador++;
    StdOut.println("Ingrese una categoria: ");
    categoria    = StdIn.readString();
    auxAlmaCat[1]       = categoria;
    contador++;
    StdOut.println("Ingrese una categoria: ");
    categoria    = StdIn.readString();
    auxAlmaCat[2]       = categoria;
    contador++; 
    /**
    while(categoria.equals("stop")||contador!=26){
    	StdOut.println("Ingrese una categoria (-1 para finalizar): ");
    	String categoriaAux = StdIn.readString();
        auxAlmaCat[contador] = categoriaAux;
    	contador++;}**/

    String [] AuxNomJuego = new String[65];

    BusquedaCategoriaArray(CateJuego,auxAlmaCat,CodigoJuego,AuxNomJuego,contador); //revisar

    //Eliminamos repetidos
    EliminarRepetidos(AuxNomJuego);
    int h,i; double GananciaT=0;
    for(i = 0; i<contador;i++){
    	for(h=0; h<Codigo.length;h++){
            if(AuxNomJuego[i].equals(Codigo[h])){
    		//Calculo Ganancia
                GananciaT  = GananciaT+CalcularGananciaTotal(PrecioVenta[h],PGanancia[h],CVendida[h]);
            }
    	}
    }
    //Impresion Resultado
    StdOut.println("La Ganancia Total de las "+(contador)+" categoria(s) es: "+GananciaT);
    }
    }
    //RF3
    public static void RF3(String [] CateJuego,String [] CodigoJuego, String[] Codigo,int[] CVendida, String[] NombreG) throws IOException{
    StdOut.println("(3) - Top Ten ");
    StdOut.println("Categorias Existentes (26):");
    StdOut.println("Anime||Accion||Aventura||Caceria||Carreras||Deportes||Dificil");
    StdOut.println("Estrategia||Fantasia||FPS||JRPG||Lucha||MMORPG||Multijugador||Mundo Abierto");
    StdOut.println("Plataforma||Primera Persona||PvP||Rol||Shooter||Simulador||Steampunk||Survival");
    StdOut.println("Terror||Un jugador||Visual Novel");
    StdOut.println("------------------------------------------------------------------------------");
    StdOut.println("Ingrese una categoria: ");

    int i;int j;int iaux = 0;

    String categoria        = StdIn.readString();
    String [] auxTOPTEN     = new String[10];
    String [] nombresTOPTEN = new String[10];
    
    for(i=0;i<10;i++){
        auxTOPTEN[i]     = "----";
        nombresTOPTEN[i] = "----";}
    
    int    []cantvenTOPTEN = new int[10];
    BusquedaCategoria(categoria,CateJuego,CodigoJuego,auxTOPTEN);
    
    //Busca
    for(i = 0; i<10;i++){
        for(j=0;j<Codigo.length;j++){
            if(auxTOPTEN[i].equals(Codigo[j])){
               cantvenTOPTEN[iaux]  = CVendida[j];
               nombresTOPTEN[iaux]  = NombreG[j];
               iaux++;
            }
        }
    }

	// Ordenamiento ganancias vendidas
    for(i = 0; i<=cantvenTOPTEN.length-2;i++){
        for(j = i+1; j<=cantvenTOPTEN.length-1;j++){
            if(cantvenTOPTEN[i]<cantvenTOPTEN[j]){
                String auxCod,auxN; int auxC;
                auxCod               = auxTOPTEN[i];
                auxTOPTEN[i]       = auxTOPTEN[j];
                auxTOPTEN[j]       = auxCod;

                auxC               = cantvenTOPTEN[i];
                cantvenTOPTEN[i]   = cantvenTOPTEN[j];
                cantvenTOPTEN[j]   = auxC;
                
                auxN = nombresTOPTEN[i];
                nombresTOPTEN[i] = nombresTOPTEN[j];
                nombresTOPTEN[j] = auxN;
            }	
        }
    }
        for(i=0;i<auxTOPTEN.length;i++)
        StdOut.println(auxTOPTEN[i]+"    "+nombresTOPTEN[i]+"    "+cantvenTOPTEN[i]);
        
        String Filename = ("top-ten-"+categoria+".txt");
        PrintStream txtsalida = new PrintStream(Filename);
        txtsalida.println("Top ten "+categoria);
        for(i=0;i<auxTOPTEN.length;i++){
        txtsalida.println(auxTOPTEN[i]+"    "+nombresTOPTEN[i]+"    "+cantvenTOPTEN[i]);}
        StdOut.println("\"SE CREÓ EL ARCHIVO "+ Filename +" CON ÉXITO.");
        
    }
        
	//Funcion main
    public static void main(String[] args) throws IOException {

    	//Inicializacion Matrices
        
        
    	//Inicializacion Arreglos de la Matriz Juegos
    	String [] Codigo      = new String [20];
    	String [] NombreG     = new String [20];
    	int    [] Year        = new int[20];
    	int    [] PrecioVenta = new int[20];
    	int    [] PGanancia   = new int[20];
    	int    [] CVendida    = new int[20];

    	//Inicializacion Arreglos de la Matriz Categorias
    	String [] CodigoJuego = new String[65];
    	String [] CateJuego   = new String[65];

    	//Inicializacion Lectura y Almacenamiento de datos del txt
    	int cantJuegos  = LecturaTxtJuegos(Codigo,NombreG,Year,PrecioVenta,PGanancia,CVendida);
    	int cantCJuegos = LecturaTxtJuegosCAT(CodigoJuego,CateJuego);
        
        /*
        RF1(cantJuegos,Year,NombreG,CVendida,PrecioVenta,PGanancia);
        RF2(CateJuego,CodigoJuego,Codigo,PrecioVenta,PGanancia,CVendida);
        RF3(CateJuego,CodigoJuego,Codigo,CVendida);
        */
        
    	// Inicio Menú 
       int op; 
       do{ 
            StdOut.println("Taller 1" );
            StdOut.println(" 1.- RF1" );               // RF1
            StdOut.println(" 2.- RF2" );              // RF2
            StdOut.println(" 3.- RF3" );      // RF3
            StdOut.println(" 4.- Salir. " );                       // Salida
            
            StdOut.println("\nIngrese una opción del menú: " );
            op = StdIn.readInt();
            StdOut.println("");
            switch(op){
                
                case 1: 
                    RF1(cantJuegos,Year,NombreG,CVendida,PrecioVenta,PGanancia);
                    break;
                case 2:
                    RF2(CateJuego,CodigoJuego,Codigo,PrecioVenta,PGanancia,CVendida);
                    break;
                case 3:
                    RF3(CateJuego,CodigoJuego,Codigo,CVendida,NombreG);
                    break;
                case 4:
                    StdOut.println("Usted está saliendo del menú..." );                  
                    break;
                
                default:
                    StdOut.println("OPCIÓN NO VÁLIDA" );
                    break; 
              }
             // Saldra del menú cuando la opción ingresada sea igual a 5 
            }while( op != 4 );
        
        
    	
        
    
    
    


    }//fin del main
    
}


