package Utils;

import java.io.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

import Algorithms.InsertionSort;

import Algorithms.QuickSortAlfabetoD;
import Algorithms.QuickSortAlfabetoA;
import Algorithms.RadixSortClase;
import Algorithms.ReverseQuickSort;
import Entity.DatosMovie;

public class ManejoCsv {
	private ArrayList<DatosMovie> listaPeliculas;
	// Java code to illustrate reading a
	// CSV file line by line

	public ManejoCsv() {
		this.listaPeliculas = new ArrayList<DatosMovie>();
	}

	public void readDataLineByLine() throws NumberFormatException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader("Movie (1).csv"))) {
			String linea = "";

			int i = 0;
			br.readLine(); // saltar los nombres de columna
			while ((linea = br.readLine()) != null && i < 100) {
				String[] datos = linea.split(",");

				for (int j = 0; j < datos.length; j++) {
					if (datos[j].equals("")) {
						datos[j] = "0";
					}
				}

				// System.out.println(datos[0]);
				// System.out.println(datos[1]);
				// Movie movie = new Movie(datos[1], Double.parseDouble(datos[7]));
				DatosMovie pelicula = new DatosMovie(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]),
						datos[3], datos[4], datos[5]);
				this.listaPeliculas.add(pelicula);
				// this.moviesLL.insertCrescent(movie);
				// usr.imprimirInfo(); //Eliminar después
				i++;
			}
			// System.out.println(moviesLL.getSize());
		}

	}

	public ArrayList<DatosMovie> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(ArrayList<DatosMovie> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

	public void generarCsv(ArrayList<DatosMovie> listaPeliculas, String nombreFile) {

		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(nombreFile);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// create a List which contains String array
			List<String[]> data = new ArrayList<String[]>();
		//	data.add(new String[]{"Movie ID","Movie title","Duration","Color","Lenguage","Country"});
			for (int i = 0; i < listaPeliculas.size(); i++) {
				data.add(new String[] { String.valueOf(listaPeliculas.get(i).getMovie_id()),
						listaPeliculas.get(i).getMovie_title(), String.valueOf(listaPeliculas.get(i).getDuration()),
						listaPeliculas.get(i).getColor(), listaPeliculas.get(i).getLanguage(),
						listaPeliculas.get(i).getCountry() });

			}

			writer.writeAll(data);

			// closing writer connection
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void generarTxt( String nameFile,Long processTime, int numeroComparaciones, int numeroIntercambios){

		try {
            PrintWriter writer = new PrintWriter(nameFile, "UTF-8");
            writer.println("1) Tiempo de ejecución del algoritmo: "+ processTime);
            writer.println("2)Numero de comparaciones: "+numeroComparaciones);
			writer.println("3)Numero de intercambios: "+numeroIntercambios);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

	public void iniciarPrograma() {
		ManejoCsv manejoCsv = new ManejoCsv();
		RadixSortClase radixSortClase = new RadixSortClase();
		ReverseQuickSort quickSort = new ReverseQuickSort();
		QuickSortAlfabetoD alfabetoA = new QuickSortAlfabetoD();
		QuickSortAlfabetoA alfabetoD = new QuickSortAlfabetoA();
		
		InsertionSort insertionSort = new InsertionSort();
		ArrayList<DatosMovie> listaPeliculas = manejoCsv.getListaPeliculas();

		try {
			manejoCsv.readDataLineByLine();
		

	
			// System.out.println("Ascendente");
			// hola.imprimirLista();
			
			/*
			 * System.out.println("Alfabeto Ascendente");
			 * 
			 * LinkedList<DatosMovie> quickStr = alfabeto.quickSort(listaPeliculas, 0,
			 * listaPeliculas.size() - 1);
			 * alfabeto.print_output(quickStr);
			 */

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("0- ORDENAR ASCENDENTE POR DURACION PELICULA");
		System.out.println("1- ORDENAR DESCENDENTE POR DURACION PELICULA");
		System.out.println("2- ORDENAR ASCENDENTE POR NOMBRE PELICULA");
		System.out.println("3- ORDENAR DESCENDENTE POR NOMBRE PELICULA");
		System.out.println();
		System.out.println("Digite la opción");
		Scanner sc = new Scanner(System.in);
		int optionA = sc.nextInt();

	

		switch (optionA) {
		
			case 0:
			System.out.println("0- ORDENAR CON RADIX SORT");
			System.out.println("1- ORDENAR CON INSERT SORT");
			optionA = sc.nextInt();
			System.out.println("Digite la opción");
			if (optionA==0) {
				int n = listaPeliculas.size();
				radixSortClase.radixsort(listaPeliculas, n);

				
			} else {
				insertionSort.ordenar(listaPeliculas);
			}
			
				
				break;
			case 1:
			System.out.println("0- ORDENAR CON QUICK SORT");
			System.out.println("1- ORDENAR CON INSERT SORT");
			optionA = sc.nextInt();


			if (optionA==0) {
				quickSort.quickSort(listaPeliculas);

				
			} else {
				insertionSort.ordenarDescendiente(listaPeliculas);
			}
				
				break;

			case 2:
			alfabetoA.quickSort(listaPeliculas, 0, listaPeliculas.size() - 1);
				break;

			case 3:
		
			alfabetoD.quickSort(listaPeliculas, 0, listaPeliculas.size() - 1);
				break;
		
			default:

				break;
		}
		
/*
		int n = listaPeliculas.size();

		radixSortClase.radixsort(listaPeliculas, n);


		System.out.println("Ascendete");
		//int n = listaPeliculas.size();

		 //ob.radixsort(listaPeliculas, n);
			System.out.println("Descendente");
			quickSort.quickSort(listaPeliculas);
		//	 alfabeto.quickSort(listaPeliculas, 0,  listaPeliculas.size() - 1,0);

			 insertionSort.ordenar(listaPeliculas);
		 //alfabeto.quickSort(listaPeliculas, 0,  listaPeliculas.size() - 1,1);

			*/




	}

	

}
