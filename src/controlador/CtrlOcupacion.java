/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Habitante;
import modelo.Ocupacion;
import modelo.consultasOcupacion;
import modelo.consultasHabitanteOcupacion;
import modelo.consultasHabitante;
import modelo.Ocupacion;
import vista.frm_agregarCenso;

public class CtrlOcupacion implements ActionListener {

    private final Ocupacion modeloo;
    private final Habitante modeloh;
        private final consultasOcupacion consultaso;
    private final consultasHabitanteOcupacion consultasho;
    private final consultasHabitante consultash;
    private final frm_agregarCenso vista;

    public CtrlOcupacion(Ocupacion modeloo, Habitante modeloh, consultasOcupacion consultaso, consultasHabitanteOcupacion consultasho, consultasHabitante consultash, frm_agregarCenso vista) {
        this.modeloo = modeloo;
        this.modeloh = modeloh;
        this.consultaso = consultaso;
        this.consultasho = consultasho;
        this.consultash = consultash;
        this.vista = vista;
        
        this.vista.btn_agregarocupacion.addActionListener(this);
        this.vista.btn_quitarocupacion.addActionListener(this);
    }



    public void iniciar() {
        vista.setTitle("Agregar Vivienda");
        vista.setResizable(true);
        vista.setVisible(true);

    }
        @Override
    public void actionPerformed(ActionEvent e) {
              if (e.getSource() == vista.btn_agregarocupacion) {

            // Obtener los datos de la vista y guardarlos en el modelo
            modeloo.setNombre_ocupacion(vista.txtocupacion.getText());
            modeloo.setDetalle_ocupacion(vista.txtdetalleocupacion.getText());

            // Registrar la vivienda en la base de datos
            if (consultaso.registrarOcupacion(modeloo)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");

            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
            
        }
    }

}
