/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopcenso;


import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author oscar
 */
public class Habitante {

    private String nombre;
    private int edad;
    private char sexo;
    private String estadoCivil;
    private String nivelEducativo;
    private List<Ocupacion> ocupaciones;
    private double ingresos;
    private String nacionalidad;
    
    private static Habitante instance = null;

    public Habitante(String nombre, int edad, char sexo, String estadoCivil, String nivelEducativo, double ingresos, String nacionalidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nivelEducativo = nivelEducativo;
        this.ingresos = ingresos;
        this.nacionalidad = nacionalidad;
        this.ocupaciones = new ArrayList<Ocupacion>(); // Inicializamos la lista de habitantes
    }
    
    public static Habitante getInstance(String nombre, int edad, char sexo, String estadoCivil, String nivelEducativo, double ingresos, String nacionalidad) {
        if (instance == null) {
            instance = new Habitante(nombre, edad, sexo, estadoCivil, nivelEducativo, ingresos, nacionalidad);
        }
        return instance;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }

    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }

    public void agregarOcupacion(Ocupacion ocupacion) {
        ocupaciones.add(ocupacion);
    }

    public List<Ocupacion> getOcupacion() {
        return ocupaciones; // Agregamos un método para acceder a la lista de habitantes
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Sexo: " + sexo);
        System.out.println("Estado Civil: " + estadoCivil);
        System.out.println("Nivel Educativo: " + nivelEducativo);
        System.out.println("Ingresos: " + ingresos);
        System.out.println("Nacionalidad: " + nacionalidad);
    }

}
