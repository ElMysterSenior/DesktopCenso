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
public class Vivienda {
    private int idvivienda;//id de la vivienda
    private String tipo; // (casa, apartamento, etc.)
    private String material; //(Vivienda de concreto, Vivienda de adobe (antiguo), Vivienda de ladrillo, Vivienda de madera...)
    private String saneamiento; //(alcantarillado, pozo séptico, letrina, etc.)
    private boolean agua;
    private boolean luz;
    private boolean drenaje;
    private String tendencia; //(propia, alquilada, en comodato, etc.)
    private String direccion; //(Dirección de la vivienda)
    private int numHabitaciones;//(Número de habitaciones)
    private int numBanios;//(Número de baños)
    private int id_municipio;//(cve del municipio)
    private String municipio;//(nombre del municipio)
    private int id_localidad;//(cve de la localidad)
    private String localidad;//(nombre de la localidad)
    private String ubicacion; //(Rural, urbana)
    private List<Habitante> habitantes; // Agregamos un atributo para almacenar los habitantes
    
     private static Vivienda instance = null;

   /* public Vivienda(int idvivienda,String tipo, String material, String saneamiento, boolean agua, boolean luz, boolean drenaje, String tendencia, String direccion, int numHabitaciones, int numBanios, String municipio, String localidad, String ubicacion) {
        this.idvivienda =idvivienda;
        this.tipo = tipo;
        this.material = material;
        this.saneamiento = saneamiento;
        this.agua = agua;
        this.luz = luz;
        this.drenaje = drenaje;
        this.tendencia = tendencia;
        this.direccion = direccion;
        this.numHabitaciones = numHabitaciones;
        this.numBanios = numBanios;
        this.municipio = municipio;
        this.localidad = localidad;
        this.ubicacion = ubicacion;
        this.habitantes = new ArrayList<Habitante>(); // Inicializamos la lista de habitantes
    }
    
     public static Vivienda getInstance(int idvivienda,String tipo, String material, String saneamiento, boolean agua, boolean luz, boolean drenaje, String tendencia, String direccion, int numHabitaciones, int numBanios, String municipio, String localidad, String ubicacion) {
        if (instance == null) {
            instance = new Vivienda(idvivienda,tipo, material, saneamiento, agua, luz, drenaje, tendencia, direccion, numHabitaciones, numBanios, municipio, localidad, ubicacion);
        }
        return instance;
    }
*/

    public int getIdvivienda() {
        return idvivienda;
    }

    public void setIdvivienda(int idvivienda) {
        this.idvivienda = idvivienda;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMaterial() {
        return material;
    }

    public String getSaneamiento() {
        return saneamiento;
    }

    public boolean getAgua() {
        return agua;
    }

    public boolean getLuz() {
        return luz;
    }

    public boolean getDrenaje() {
        return drenaje;
    }

    public String getTendencia() {
        return tendencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public int getNumBanios() {
        return numBanios;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
        public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public int getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(int id_localidad) {
        this.id_localidad = id_localidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setSaneamiento(String saneamiento) {
        this.saneamiento = saneamiento;
    }

    public void setAgua(boolean agua) {
        this.agua = agua;
    }

    public void setLuz(boolean luz) {
        this.luz = luz;
    }

    public void setDrenaje(boolean drenaje) {
        this.drenaje = drenaje;
    }

    public void setTendencia(String tendencia) {
        this.tendencia = tendencia;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void agregarHabitante(Habitante habitante) {
        habitantes.add(habitante);
    }

    public List<Habitante> getHabitantes() {
        return habitantes; // Agregamos un método para acceder a la lista de habitantes
    }

    public void mostrarInformacion() {
        System.out.println("Tipo de vivienda: " + tipo);
        System.out.println("Material de construcción: " + material);
        System.out.println("Saneamiento: " + saneamiento);
        System.out.println("¿Tiene agua?: " + (agua ? "Sí" : "No"));
        System.out.println("¿Tiene luz?: " + (luz ? "Sí" : "No"));
        System.out.println("¿Tiene drenaje?: " + (drenaje ? "Sí" : "No"));
        System.out.println("Tendencia: " + tendencia);
        System.out.println("Dirección: " + direccion);
        System.out.println("Número de habitaciones: " + numHabitaciones);
        System.out.println("Número de baños: " + numBanios);
        System.out.println("Municipio: " + municipio);
        System.out.println("Localidad: " + localidad);
        System.out.println("Ubicación: " + ubicacion);
    }
}
