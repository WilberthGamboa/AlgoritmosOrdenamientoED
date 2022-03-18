package Test;

import java.io.IOException;


public class QuickSortAlfabeto {

    

    public static String[] quickSort(String[] strArr, int p, int r)
    {
        if(p<r)
        {
            int q=partition(strArr,p,r);
            quickSort(strArr,p,q);
            quickSort(strArr,q+1,r);
        }
        
        return strArr;
    }
    
    private static int partition(String[] strArr, int p, int r) {

        String x = strArr[p];
        int i = p-1 ;
        int j = r+1 ;

        while (true) 
        {
            i++;
            while ( i< r && strArr[i].compareTo(x) < 0)
                i++;
            j--;
            while (j>p && strArr[j].compareTo(x) > 0)
                j--;

            if (i < j)
                swap(strArr, i, j);
            else
                return j;
        }
    }

    private static void swap(String[] strArr, int i, int j) 
    {
        String temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
    }
    
    public static void print_output(String[] strArr) throws IOException
    {
       String temp = "";
       
       for(int i=0; i < strArr.length; i++) 
           temp+=""+strArr[i];

       System.out.println("Output: " + temp + "\n");
    }
    public static void main(String[] args) throws IOException {
        System.out.println("Quick Sorting...");
       String []transformStr ={"Wilberth","Jaboc","ariel","Cambranes"};
        String[] quickStr = quickSort(transformStr,0,transformStr.length-1);
      
        print_output(quickStr);
         
        System.exit(0);
    }
}
