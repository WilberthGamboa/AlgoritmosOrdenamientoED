package Algorithms;

import java.util.ArrayList;


import Entity.DatosMovie;
import Utils.ManejoCsv;

public class RadixSortClase {
    private long startTime;
    private int numeroComparaciones;
    private int numeroIntercambios;

    int BASE = 9;
    //Función que devuelve el número máximo

    //Pasa en la funcion el arreglo de números y el tamaño del arreglo
   
    
    //Pasa en la funcion el arreglo de números y el tamaño del arreglo
    public int getMax(ArrayList<DatosMovie> arr, int n){
        //Estable que el número más grande es el inicial
        int max = arr.get(0).getDuration();
        //recorre el arreglo desde el primero número 
        numeroComparaciones++;
        for(int i = 1; i < n; i++){
            //Si el número actual es mayor al máximo se guarda como máximo
            numeroComparaciones++;
            if(arr.get(0).getDuration() > max){
                max = arr.get(0).getDuration();
            }
        }
        //Devuelve el máximo
        return max;
    }

//Pasamos el arreglo de enteros, y el tamaño de la función
    public void radixsort(ArrayList<DatosMovie> arr, int n){
         startTime = System.nanoTime();
        //Obtenemos el número máximo
        int max = getMax(arr, n);
        //Esto nos va diviendo el número entre 1,10,100, así hasta llegar al número más significativo
        numeroComparaciones++;
        for(int d = 1; max/d > 0; d *= 10){
            //Entramos a la otra función pasando el arreglo de entero, su tamaño y el iterador;
            countsort(arr, n, d);
        }
        
        long endTime = System.nanoTime();
        Long processTime = (endTime-startTime);
        ManejoCsv listaFinal = new  ManejoCsv();
        listaFinal.generarCsv(arr,"RadixSortAscendente.csv");
        listaFinal.generarTxt("RadixSortAscendente.txt",processTime,numeroComparaciones,numeroIntercambios);


    }
//Introducir el arreglo de enteros, pasar el tamaño máximo del arreglo y el iterador 
    public void countsort(ArrayList<DatosMovie> arr, int n, int d){

      DatosMovie output[] = new DatosMovie[n];
    
        //ARREGLO CON EL NÚMERO DE BASE
        int[] count = new int[BASE+1];
        //recorre e tamanio del arreglo 
        /*
        System.out.println("Valor d: "+d);
        System.out.println();
        System.out.println();
        */

        //Este bucle recorre totalmente el tamaño del arreglo,para acomodarlo en el arreglo,
        //estático 
        numeroComparaciones++;
        for(int i = 0; i < n; i++){
        /*

        Basicamente, la parte interna del count está conformada por el valor interno del arreglo, 
        divido entre D, este D es un multiplo 10 que divide al número al cual está evualuando,
        devolviendo la parte entera, posterior a este se le aplica modulo de 10 que devuelve solamente 
        el dígito menos signifcativo

        Posterior a esto se tiene que se va asignando la sumatoria de 1;


        */
            numeroIntercambios++;
            count[arr.get(i).getDuration()/d % 10] += 1;

           /*
            System.out.println("Valor arreglo: "+ arr[i] );
            System.out.println("Valor array/d: "+ arr[i]/d );
            System.out.println("Valor array/d %10: "+ arr[i]/d %10);
            System.out.println(count[arr[i]/d % 10] );
           */

            
        }
        numeroComparaciones++;
        for(int i = 1; i <= BASE; i++){
            numeroIntercambios++;
            count[i] += count[i-1];
        }
        numeroComparaciones++;
        for(int i = n-1; i >= 0; i--){
            numeroIntercambios++;
            output[count[arr.get(i).getDuration()/d % 10]-1] = arr.get(i);
            numeroIntercambios++;
          
            count[arr.get(i).getDuration()/d % 10] -= 1;
        }

        for(int i = 0; i < n; i++){
           numeroIntercambios++;
            arr.set(i, output[i]);
         
        }
    }
    
}
 