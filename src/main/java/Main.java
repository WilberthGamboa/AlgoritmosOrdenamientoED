import java.io.IOException;
import java.util.LinkedList;

import Algorithms.QuickSortAlfabeto;
import Algorithms.RadixSortClase;
import Algorithms.ReverseQuickSort;
import Entity.DatosMovie;
import Utils.ManejoCsv;

public class Main {
    public void iniciarPrograma(){
        ManejoCsv hola = new ManejoCsv();
		RadixSortClase ob = new RadixSortClase();
		ReverseQuickSort quickSort = new ReverseQuickSort();
		QuickSortAlfabeto alfabeto = new QuickSortAlfabeto();
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
			System.out.println("Alfabeto Ascendente");

			LinkedList<DatosMovie> quickStr=alfabeto.quickSort(listaPeliculas,0,listaPeliculas.size()-1);
			alfabeto.print_output(quickStr);
			
		} catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }


    public static void main(String[] args) {
        
    }
    
}
