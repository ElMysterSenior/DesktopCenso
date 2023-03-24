/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopcenso;

/**
 *
 * @author oscar
 */
public class App {

    public static void main(String[] args) {

        Habitante habitante = Habitante.getInstance("Juan", 30, 'M', "Casado", "Universitario", 50000, "Mexicano");
        Ocupacion ocupacion = new Ocupacion(1, "Ingeniero", "Ingeniero Mecatronica");
        habitante.agregarOcupacion(ocupacion);
        
        // Crear una instancia de Vivienda usando el patrón Singleton
        Vivienda vivienda = Vivienda.getInstance("Casa", "Ladrillo", "Bueno", true, true, true, "Urbana", "Calle 123", 3, 2, "Ciudad", "Barrio", "Centro");

        // Usar las instancias creadas
        System.out.println("El habitante " + habitante.getNombre() + " tiene " + habitante.getEdad() + " años y es " + habitante.getEstadoCivil());
        ocupacion.mostrarDatos();
        System.out.println("La vivienda en la que vive " + habitante.getNombre() + " está ubicada en " + vivienda.getDireccion() + " y tiene " + vivienda.getNumHabitaciones() + " habitaciones y " + vivienda.getNumBanios() + " baños.");
        
    }
}
