package Algorithms;

import java.io.IOException;
import java.util.LinkedList;

import Entity.DatosMovie;


public class QuickSortAlfabeto {


    public  LinkedList<DatosMovie> quickSort(LinkedList <DatosMovie> strArr, int p, int r)
    {
        if(p<r)
        {
            int q=partition(strArr,p,r);
            quickSort(strArr,p,q);
            quickSort(strArr,q+1,r);
        }
        
        return strArr;
    }
    
    private  int partition(LinkedList <DatosMovie> strArr, int p, int r) {

        String x = strArr.get(p).getMovie_title();
        int i = p-1 ;
        int j = r+1 ;

        while (true) 
        {
            i++;
            while ( i< r && strArr.get(i).getMovie_title().compareTo(x) > 0)
                i++;
            j--;
            while (j>p && strArr.get(j).getMovie_title().compareTo(x) < 0)
                j--;

            if (i < j)
                swap(strArr, i, j);
            else
                return j;
        }
    }

    private  void swap(LinkedList <DatosMovie> strArr, int i, int j) 
    {
        String temp = strArr.get(i).getMovie_title();
        strArr.get(i).setMovie_title(strArr.get(j).getMovie_title());
        strArr.get(j).setMovie_title(temp);
       
    }
    
    public  void print_output(LinkedList <DatosMovie> strArr) throws IOException
    {
     
       
       for(int i=0; i < strArr.size(); i++){
           System.out.println(strArr.get(i).getMovie_title());
           System.out.println();
       }   
    }
}
