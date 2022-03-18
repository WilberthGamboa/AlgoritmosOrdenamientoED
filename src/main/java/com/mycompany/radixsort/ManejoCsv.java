package com.mycompany.radixsort;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVReader;

public class ManejoCsv {
	private LinkedList<DatosMovie> listaPeliculas;
	// Java code to illustrate reading a
	// CSV file line by line


	public ManejoCsv(){
		this.listaPeliculas= new LinkedList<DatosMovie>();
	}
	public void readDataLineByLine()  throws NumberFormatException, IOException  {

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
				

			//	System.out.println(datos[0]);
			//	System.out.println(datos[1]);
				// Movie movie = new Movie(datos[1], Double.parseDouble(datos[7]));
				DatosMovie pelicula = new DatosMovie(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]), datos[3], datos[4], datos[5]);
				this.listaPeliculas.add(pelicula);
				//this.moviesLL.insertCrescent(movie);
				// usr.imprimirInfo(); //Eliminar después
				i++;
			}
			// System.out.println(moviesLL.getSize());
		}



	

		/*
		 * 
		 * try {
		 * 
		 * // Create an object of filereader
		 * // class with CSV file as a parameter.
		 * FileReader filereader = new FileReader("Movie.csv");
		 * 
		 * // create csvReader object passing
		 * // file reader as a parameter
		 * CSVReader csvReader = new CSVReader(filereader);
		 * String[] nextRecord;
		 * DatosMovie dato = new DatosMovie();
		 * // we are going to read data line by line
		 * // int i = 0;
		 * 
		 * for (int i = 0; i < 100; i++) {
		 * 
		 * nextRecord = csvReader.readNext();
		 * System.out.println(nextRecord[0]);
		 * 
		 * }
		 * /*
		 * while ((nextRecord = csvReader.readNext()) != null) {
		 * System.out.println(nextRecord[0]);
		 * // dato.agregarDato(Integer.parseInt(nextRecord[0]),
		 * nextRecord[1],Integer.parseInt(nextRecord[2]), nextRecord[3], nextRecord[4],
		 * nextRecord[5]);
		 * // i++;
		 * // System.out.println();
		 * }
		 * 
		 * 
		 * // dato.imprimirLista();
		 * }
		 * catch (Exception e) {
		 * e.printStackTrace();
		 * }
		 */

	}

	
	

	


	public LinkedList<DatosMovie> getListaPeliculas() {
		return listaPeliculas;
	}
	public void setListaPeliculas(LinkedList<DatosMovie> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	public void imprimirLista(){


		for (int i = 0; i < listaPeliculas.size(); i++) {

			System.out.println(listaPeliculas.get(i).getDuration());
			
		}
			
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ManejoCsv hola = new ManejoCsv();
		RadixSortClase ob = new RadixSortClase();
		ReverseQuickSort quickSort = new ReverseQuickSort();
		 LinkedList<DatosMovie> listaPeliculas = hola.getListaPeliculas();

		try {
			hola.readDataLineByLine();
			hola.imprimirLista();
			int n =  listaPeliculas.size();

			ob.radixsort(listaPeliculas, n);
			System.out.println("Ascendente");
			hola.imprimirLista();
			quickSort.quickSort(listaPeliculas);
			System.out.println("Descendente");
			hola.imprimirLista();
			
		} catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

	//	hola.readDataLineByLine();
	}

}
