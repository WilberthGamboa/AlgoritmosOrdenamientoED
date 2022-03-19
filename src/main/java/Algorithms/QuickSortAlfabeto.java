package Algorithms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import Entity.DatosMovie;
import Utils.ManejoCsv;


public class QuickSortAlfabeto {
    private long startTime;
    private int numeroComparaciones;
    private int numeroIntercambios;

    public  ArrayList<DatosMovie> quickSort(ArrayList <DatosMovie> strArr, int p, int r,int orden)
    {
        long startTime = System.nanoTime();
        numeroComparaciones++;
        if(p<r)
        {
            int q=partition(strArr,p,r,orden);
            quickSort(strArr,p,q, orden);
            quickSort(strArr,q+1,r,orden);
        }

        long endTime = System.nanoTime();
        Long processTime = (endTime-startTime);
        ManejoCsv listaFinal = new  ManejoCsv();
        listaFinal.generarCsv(strArr,"Alfabeto.csv");
        listaFinal.generarTxt("QuickSortEstadisticasAlfabeto.txt",processTime,numeroComparaciones,numeroIntercambios);
        
        return strArr;
    }
    
    private  int partition(ArrayList <DatosMovie> strArr, int p, int r,int orden) {

        String x = strArr.get(p).getMovie_title();
        int i = p-1 ;
        int j = r+1 ;
        
        if(orden==0){
            numeroComparaciones++;
            while (true) 
        {
            i++;
            numeroComparaciones++;
            while ( i< r && strArr.get(i).getMovie_title().compareTo(x) > 0)
                i++;
            j--;
            numeroComparaciones++;
            while (j>p && strArr.get(j).getMovie_title().compareTo(x) < 0)
                j--;
                numeroComparaciones++;
            if (i < j)
                swap(strArr, i, j);
            else
                return j;
        }
        }
        numeroComparaciones++;
        while (true) 
        {
            i++;
            numeroComparaciones++;
            while ( i< r && strArr.get(i).getMovie_title().compareTo(x) > 0)
                i++;
            j--;
            numeroComparaciones++;
            while (j>p && strArr.get(j).getMovie_title().compareTo(x) < 0)
                j--;
                numeroComparaciones++;
            if (i < j)
                swap(strArr, i, j);
            else
                return j;
        }
    }

    private  void swap(ArrayList <DatosMovie> strArr, int i, int j) 
    {
        DatosMovie temporal = new DatosMovie();
        numeroIntercambios++;
        temporal= strArr.get(i);
        numeroIntercambios++;
        strArr.set(i, strArr.get(j));
        numeroIntercambios++;
        strArr.set(j, temporal);
      
    }
    
    public  void print_output(LinkedList <DatosMovie> strArr) throws IOException
    {
     
       
       for(int i=0; i < strArr.size(); i++){
           System.out.println(strArr.get(i).getMovie_title());
           System.out.println();
       }   
    }
}
