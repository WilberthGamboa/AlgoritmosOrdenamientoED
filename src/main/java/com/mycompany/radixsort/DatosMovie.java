package com.mycompany.radixsort;

import java.util.LinkedList;

public class DatosMovie {
    private int movie_id;
    private String movie_title;
    private int duration;
    private String color;
    private String language;
    private String country;
    private LinkedList<DatosMovie> listaMovies= new LinkedList<DatosMovie>();




    
    public DatosMovie(){

    }



    public DatosMovie(int movie_id, String movie_title, int duration, String color, String language, String country
           ) {
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.duration = duration;
        this.color = color;
        this.language = language;
        this.country = country;
       
    }
    /*
    public void agregarDato(int movie_id, String movie_title, int duration, String color, String language, String country){
      //  System.out.println(movie_id);
        DatosMovie datoMovie = new DatosMovie(movie_id, movie_title, duration, color, language, country, listaMovies);
        listaMovies.add(datoMovie);
    }

    */

    public void imprimirLista(){
        int tamanio = listaMovies.size();
       // System.out.println(tamanio);
        for (int i = 0; i < tamanio; i++) {
           // System.out.println(listaMovies.get(0).getMovie_id());
            
        }
    }
    public int getMovie_id() {
        return movie_id;
    }
    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
    public String getMovie_title() {
        return movie_title;
    }
    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    


    

}
