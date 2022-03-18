package Algorithms;



import java.util.LinkedList;

import Entity.DatosMovie;


public class ReverseQuickSort {

    public  void quickSort(LinkedList <DatosMovie> array) {
        quickSort(array, 0, array.size() - 1);
    }

    private  void quickSort(LinkedList <DatosMovie> array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    private  int partition(LinkedList <DatosMovie> array, int p, int r) {
        int i = p - 1;
        int j = p;
        while (j < r) {

            /** Just change compare condition **/
            if (array.get(j).getDuration() > array.get(r).getDuration()) {
                swap(array, i + 1, j);
                i++;
            }
            j++;
        }
        swap(array, i + 1, r);
        return i + 1;
    }

    private  void swap(LinkedList <DatosMovie> array, int i, int j) {
        int temp = array.get(i).getDuration();
       array.get(i).setDuration(array.get(j).getDuration());
        
       array.get(j).setDuration(temp);
    }
}
