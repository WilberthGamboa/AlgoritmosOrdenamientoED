package Algorithms;

import java.util.LinkedList;

import Entity.DatosMovie;

public class RadixSortClase {
    int BASE = 9;
    //Función que devuelve el número máximo

    //Pasa en la funcion el arreglo de números y el tamaño del arreglo
    public int getMax(LinkedList<DatosMovie> arr, int n){
        //Estable que el número más grande es el inicial
        int max = arr.get(0).getDuration();
        //recorre el arreglo desde el primero número 
        for(int i = 1; i < n; i++){
            //Si el número actual es mayor al máximo se guarda como máximo
            if(arr.get(i).getDuration() > max){
                max = arr.get(i).getDuration();
            }
        }
        //Devuelve el máximo
        return max;
    }

//Pasamos el arreglo de enteros, y el tamaño de la función
    public void radixsort(LinkedList<DatosMovie> arr, int n){
        //Obtenemos el número máximo
        int max = getMax(arr, n);
        //Esto nos va diviendo el número entre 1,10,100, así hasta llegar al número más significativo
        for(int d = 1; max/d > 0; d *= 10){
            //Entramos a la otra función pasando el arreglo de entero, su tamaño y el iterador;
            countsort(arr, n, d);
        }
    }
//Introducir el arreglo de enteros, pasar el tamaño máximo del arreglo y el iterador 
    public void countsort(LinkedList<DatosMovie> arr, int n, int d){
        //Arreglo de tamaño máximo entero :v SI PAPU XDDXSX DXDXDXDXDXDXDXD
        int[] output = new int[n];
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
        for(int i = 0; i < n; i++){
        /*

        Basicamente, la parte interna del count está conformada por el valor interno del arreglo, 
        divido entre D, este D es un multiplo 10 que divide al número al cual está evualuando,
        devolviendo la parte entera, posterior a este se le aplica modulo de 10 que devuelve solamente 
        el dígito menos signifcativo

        Posterior a esto se tiene que se va asignando la sumatoria de 1;


        */
            
            count[arr.get(i).getDuration()/d % 10] += 1;

           /*
            System.out.println("Valor arreglo: "+ arr[i] );
            System.out.println("Valor array/d: "+ arr[i]/d );
            System.out.println("Valor array/d %10: "+ arr[i]/d %10);
            System.out.println(count[arr[i]/d % 10] );
           */

            
        }

        for(int i = 1; i <= BASE; i++){
            count[i] += count[i-1];
        }

        for(int i = n-1; i >= 0; i--){
            output[count[arr.get(i).getDuration()/d % 10]-1] = arr.get(i).getDuration();
            count[arr.get(i).getDuration()/d % 10] -= 1;
        }

        for(int i = 0; i < n; i++){
            arr.get(i).setDuration(output[i]);
            
        }
    }
    

   
    
    
}
/*
public class RadixSort{
    public static void main(String[] args){
        RadixSortClase ob = new RadixSortClase();
        int[] arr = {179, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        ob.radixsort(arr, n);

        
        System.out.println("After sorting");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
 */