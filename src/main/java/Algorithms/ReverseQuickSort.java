package Algorithms;



import java.util.ArrayList;


import Entity.DatosMovie;
import Utils.ManejoCsv;


public class ReverseQuickSort {
    private int numeroComparaciones;
    private int numeroIntercambios;

    public  void quickSort(ArrayList <DatosMovie> array) {
        long startTime = System.nanoTime();
        quickSort(array, 0, array.size() - 1);
        long endTime = System.nanoTime();
        Long processTime = (endTime-startTime);
        ManejoCsv listaFinal = new  ManejoCsv();
        listaFinal.generarCsv(array,"QuickSortD.csv");
        listaFinal.generarTxt("QuickSortD.txt",processTime,numeroComparaciones,numeroIntercambios);
        
    }

    private  void quickSort(ArrayList <DatosMovie> array, int p, int r) {
        numeroComparaciones++;
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    private  int partition(ArrayList <DatosMovie> array, int p, int r) {
        int i = p - 1;
        int j = p;
        numeroComparaciones++;
        while (j < r) {

            /** Just change compare condition **/
            numeroComparaciones++;
            if (array.get(j).getDuration() > array.get(r).getDuration()) {
                swap(array, i + 1, j);
                i++;
            }
            j++;
        }
        swap(array, i + 1, r);
        return i + 1;
    }

    private  void swap(ArrayList <DatosMovie> array, int i, int j) {
        DatosMovie temporal = new DatosMovie();
        temporal= array.get(i);
        numeroIntercambios++;
        array.set(i, array.get(j));
        numeroIntercambios++;
        array.set(j, temporal);
     





    


    }


    
}
