package Algorithms;

import java.util.ArrayList;

import Entity.DatosMovie;
import Utils.ManejoCsv;

public class InsertionSort {
    private int numeroComparaciones;
    private int numeroIntercambios;
    public void ordenar(ArrayList<DatosMovie> arreglo ){
        long startTime = System.nanoTime();
        int n = arreglo.size();
        numeroComparaciones++;
        for(int i = 1; i < n; i++){
            DatosMovie key = arreglo.get(i);
            int j = i - 1;
            numeroComparaciones++;
            while(j >= 0 && arreglo.get(j).getDuration() > key.getDuration()){
                numeroIntercambios++;
                arreglo.set(j+1, arreglo.get(j));
               
                j = j - 1;
            }
            numeroIntercambios++;
            arreglo.set(j+1,key);
        }

        long endTime = System.nanoTime();
        Long processTime = (endTime-startTime);
        ManejoCsv listaFinal = new  ManejoCsv();
        listaFinal.generarCsv(arreglo,"InsertionSortA.csv");
        listaFinal.generarTxt("InsertionSortA.txt",processTime,numeroComparaciones,numeroIntercambios);
    }

    public void ordenarDescendiente(ArrayList<DatosMovie> arr ){
        long startTime = System.nanoTime();
        int size = arr.size();
        numeroComparaciones++;
        for (int step = 1; step < size; step++) {
            DatosMovie key = arr.get(step);
        
            int j = step - 1;
            numeroComparaciones++;
            while (j >= 0 && key.getDuration() > arr.get(j).getDuration()) {
            // For ascending order, change key> arr[j] to key< arr[j].
            numeroIntercambios++;
            arr.set(j+1, arr.get(j));
               
                --j;
            }
            numeroIntercambios++;
            arr.set(j+1, key);
          
        }

        long endTime = System.nanoTime();
        Long processTime = (endTime-startTime);
        ManejoCsv listaFinal = new  ManejoCsv();
        listaFinal.generarCsv(arr,"InsertionSortD.csv");
        listaFinal.generarTxt("InsertionSortD.txt",processTime,numeroComparaciones,numeroIntercambios);
    }

}
