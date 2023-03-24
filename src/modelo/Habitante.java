/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author oscar
 */
public class Habitante {

    private int idhabitante;
    private String nombre;
    private int edad;
    private String sexo;
    private String estadoCivil;
    private String nivelEducativo;
    private List<Ocupacion> ocupaciones;
    private int ingresos;
    private String nacionalidad;
    private int idvivienda;

    public int getIdvivienda() {
        return idvivienda;
    }

    public void setIdvivienda(int idvivienda) {
        this.idvivienda = idvivienda;
    }

    private static Habitante instance = null;

   /* public Habitante(int idhabitante, String nombre, int edad, String sexo, String estadoCivil, String nivelEducativo, int ingresos, String nacionalidad) {
        this.idhabitante = idhabitante;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nivelEducativo = nivelEducativo;
        this.ingresos = ingresos;
        this.nacionalidad = nacionalidad;
        this.ocupaciones = new ArrayList<Ocupacion>(); // Inicializamos la lista de habitantes
    }

    public static Habitante getInstance(int idhabitante, String nombre, int edad, String sexo, String estadoCivil, String nivelEducativo, int ingresos, String nacionalidad) {
        if (instance == null) {
            instance = new Habitante(idhabitante, nombre, edad, sexo, estadoCivil, nivelEducativo, ingresos, nacionalidad);
        }
        return instance;
    }
    */

    public int getIdhabitante() {
        return idhabitante;
    }

    public void setIdhabitante(int idhabitante) {
        this.idhabitante = idhabitante;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
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

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
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
