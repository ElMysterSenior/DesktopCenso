/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Ocupacion {
    private int idocupacion;
    private String nombre_ocupacion;
    private String detalle_ocupacion;

    /*public Ocupacion(int idocupacion, String nombre_ocupacion, String detalle_ocupacion) {
        this.idocupacion = idocupacion;
        this.nombre_ocupacion = nombre_ocupacion;
        this.detalle_ocupacion = detalle_ocupacion;
    }
    */

    public int getIdocupacion() {
        return idocupacion;
    }

    public void setIdocupacion(int idocupacion) {
        this.idocupacion = idocupacion;
    }

    public String getNombre_ocupacion() {
        return nombre_ocupacion;
    }

    public void setNombre_ocupacion(String nombre_ocupacion) {
        this.nombre_ocupacion = nombre_ocupacion;
    }

    public String getDetalle_ocupacion() {
        return detalle_ocupacion;
    }

    public void setDetalle_ocupacion(String detalle_ocupacion) {
        this.detalle_ocupacion = detalle_ocupacion;
    }
    public void mostrarDatos() {
    System.out.println("ID: " + this.idocupacion);
    System.out.println("Nombre de ocupación: " + this.nombre_ocupacion);
    System.out.println("Detalle de ocupación: " + this.detalle_ocupacion);
}

}
