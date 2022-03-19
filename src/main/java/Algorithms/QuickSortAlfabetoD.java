package Algorithms;


import java.util.ArrayList;


import Entity.DatosMovie;
import Utils.ManejoCsv;


public class QuickSortAlfabetoD {
    private long startTime;
    private int numeroComparaciones;
    private int numeroIntercambios;

    public  ArrayList<DatosMovie> quickSort(ArrayList <DatosMovie> strArr, int p, int r)
    {
         startTime = System.nanoTime();
        numeroComparaciones++;
        if(p<r)
        {
            int q=partition(strArr,p,r);
            quickSort(strArr,p,q );
            quickSort(strArr,q+1,r);
        }

        long endTime = System.nanoTime();
        Long processTime = (endTime-startTime);
        ManejoCsv listaFinal = new  ManejoCsv();
        listaFinal.generarCsv(strArr,"QuickSortAlfabetoD.csv");
        listaFinal.generarTxt("QuickSortAlfabetoD.txt",processTime,numeroComparaciones,numeroIntercambios);
        
        return strArr;
    }
    
    private  int partition(ArrayList <DatosMovie> strArr, int p, int r) {

        String x = strArr.get(p).getMovie_title();
        int i = p-1 ;
        int j = r+1 ;
        
       
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
    
  
}
