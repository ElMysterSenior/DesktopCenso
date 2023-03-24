/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.frm_agregarCenso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Habitante;
import modelo.Vivienda;
import modelo.consultasHabitante;
import modelo.consultasVivienda;

public class CtrlHabitante implements ActionListener {

    private final Habitante modeloh;
    private final consultasHabitante consultash;
    private final frm_agregarCenso vista;

    public CtrlHabitante(Habitante modeloh, consultasHabitante consultash, frm_agregarCenso vista) {
        this.modeloh = modeloh;
        this.consultash = consultash;
        this.vista = vista;
        this.vista.btn_quitarhabitante.addActionListener(this);
        this.vista.btn_agregarhabitante.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Agregar Vivienda");
        vista.setResizable(true);
        vista.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_agregarhabitante) {
            // Obtener los datos de la vista y guardarlos en el modelo del habitante
            modeloh.setIdhabitante(Integer.parseInt(vista.txtidhab.getText()));
            modeloh.setNombre(vista.txtnombre.getText());
            modeloh.setEdad(Integer.parseInt(vista.txtedad.getText()));
            modeloh.setSexo(vista.cbsexo.getSelectedItem().toString());
            modeloh.setEstadoCivil(vista.cbniveleducativo.getSelectedItem().toString());
            modeloh.setNivelEducativo(vista.cbniveleducativo.getSelectedItem().toString());
            modeloh.setIngresos(Integer.parseInt(vista.txtingreso.getText()));
            modeloh.setNacionalidad(vista.txtnacionalidad.getText());

            if (consultash.registrarHabitante(modeloh)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                // Actualizar la tabla de habitantes de la última vivienda en la vista
                DefaultTableModel model = (DefaultTableModel) vista.jTable1.getModel();
                model.setRowCount(0); // Limpiar la tabla antes de agregar los nuevos datos
                List<Habitante> habitantes = consultash.buscarHabitantesDeUltimaVivienda();
                for (Habitante hab : habitantes) {
                    model.addRow(new Object[]{
                        hab.getIdhabitante(),
                        hab.getNombre(),
                        hab.getEdad(),
                        hab.getSexo(),
                        hab.getEstadoCivil(),
                        hab.getNivelEducativo(),
                        hab.getIngresos(),
                        hab.getNacionalidad()
                    });
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }

        }
        if (e.getSource() == vista.btn_quitarhabitante) {
            int idHabitante = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del habitante a eliminar: "));
            if (consultash.eliminarHabitante(idHabitante)) {
                JOptionPane.showMessageDialog(null, "Habitante eliminado");
                // Actualizar la tabla de habitantes de la última vivienda en la vista
                DefaultTableModel model = (DefaultTableModel) vista.jTable1.getModel();
                model.setRowCount(0); // Limpiar la tabla antes de agregar los nuevos datos
                List<Habitante> habitantes = consultash.buscarHabitantesDeUltimaVivienda();
                for (Habitante hab : habitantes) {
                    model.addRow(new Object[]{
                        hab.getIdhabitante(),
                        hab.getNombre(),
                        hab.getEdad(),
                        hab.getSexo(),
                        hab.getEstadoCivil(),
                        hab.getNivelEducativo(),
                        hab.getIngresos(),
                        hab.getNacionalidad()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar habitante");
            }
        }
    }

}
