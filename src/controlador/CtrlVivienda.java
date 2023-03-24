package controlador;

import modelo.Vivienda;
import modelo.consultasVivienda;

import vista.frm_agregarCenso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;


public class CtrlVivienda implements ActionListener {

    private final Vivienda modelov;
    private final consultasVivienda consultasv;
    private final frm_agregarCenso vista;

    public CtrlVivienda(Vivienda modelov, consultasVivienda consultasv, frm_agregarCenso vista) {
        this.modelov = modelov;
        this.consultasv = consultasv;
        this.vista = vista;
        this.vista.btn_agregarvivienda.addActionListener(this);
        this.vista.btn_modificarVivienda.addActionListener(this);
        vista.cbmunicipio.removeAllItems();
        vista.cblocalidad.removeAllItems();
        llenarComboBoxMunicipios();
        llenarComboBoxLocalidades();

    }

    public void iniciar() {
        vista.setTitle("Agregar Vivienda");
        vista.setResizable(true);
        vista.setVisible(true);

        // Asignamos el ActionListener para el ComboBox de municipios
        this.vista.cbmunicipio.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        vista.cbmunicipio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el nombre del municipio seleccionado
                String nombreMunicipio = vista.cbmunicipio.getSelectedItem().toString();

                // Obtener el id del municipio y llenar el campo txtidmunicipio
                int idMunicipio = consultasv.obtenerIdMunicipio(nombreMunicipio);
                vista.txtidmunicipio.setText(Integer.toString(idMunicipio));
            }
        });

        // Agrega el listener al cbmunicipio
        vista.cbmunicipio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el id del municipio seleccionado
                int idMunicipio = consultasv.obtenerIdMunicipio(vista.cbmunicipio.getSelectedItem().toString());

                // Obtener las localidades del municipio
                List<String> localidades = consultasv.obtenerLocalidadesPorIdMunicipio(idMunicipio);

                // Actualizar el contenido del cblocalidad
                vista.cblocalidad.removeAllItems();
                for (String localidad : localidades) {
                    vista.cblocalidad.addItem(localidad);
                }
            }
        });

        /*vista.cblocalidad.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                Thread.sleep(100);
                // Obtener el id de la localidad seleccionada
            
            
            int idLocalidad = consultasv.obtenerIdLocalidad(vista.cblocalidad.getSelectedItem().toString());
            
            // Actualizar el contenido del campo txtidlocalidad
            vista.txtidlocalidad.setText(Integer.toString(idLocalidad));
            } catch (InterruptedException ex) {
                Logger.getLogger(CtrlVivienda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
         */
      if (e.getSource() == vista.btn_agregarvivienda) {

            // Obtener los datos de la vista y guardarlos en el modelo
            modelov.setId_municipio(Integer.parseInt(vista.txtidmunicipio.getText()));
            modelov.setMunicipio(vista.cbmunicipio.getSelectedItem().toString());
            int idLocalidad = consultasv.obtenerIdLocalidad(vista.cblocalidad.getSelectedItem().toString());
            modelov.setId_localidad(idLocalidad);
            modelov.setLocalidad(vista.cblocalidad.getSelectedItem().toString());
            modelov.setTendencia(vista.cbtendencia.getSelectedItem().toString());
            modelov.setTipo(vista.cbtipovivienda.getSelectedItem().toString());
            modelov.setMaterial(vista.cbmaterial.getSelectedItem().toString());
            modelov.setSaneamiento(vista.cbsaneamiento.getSelectedItem().toString());
            boolean agua = false;
            if (vista.chbagua.isSelected()) {
                agua = true;
            }
            modelov.setAgua(agua);

            boolean luz = false;
            if (vista.chbluz.isSelected()) {
                luz = true; // Fix variable name
            }
            modelov.setLuz(luz);

            boolean drenaje = false;
            if (vista.chbdrenaje.isSelected()) {
                drenaje = true;
            }
            modelov.setDrenaje(drenaje); // Fix variable name

            modelov.setNumHabitaciones(Integer.parseInt(vista.txtnumhabitaciones.getText()));
            modelov.setNumBanios(Integer.parseInt(vista.txtnumbanios.getText()));
            modelov.setUbicacion(vista.txtubicacion.getText());
            modelov.setDireccion(vista.txtdir.getText());

            // Registrar la vivienda en la base de datos
            if (consultasv.registrarVivienda(modelov)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        }

       if (e.getSource() == vista.btn_modificarVivienda) {
            // Obtener los datos de la vista y guardarlos en el modelo
            modelov.setIdvivienda(modelov.getIdvivienda());
            modelov.setMunicipio(vista.cbmunicipio.getSelectedItem().toString());
            int idLocalidad = consultasv.obtenerIdLocalidad(vista.cblocalidad.getSelectedItem().toString());
            modelov.setId_localidad(idLocalidad);
            modelov.setLocalidad(vista.cblocalidad.getSelectedItem().toString());
            modelov.setTendencia(vista.cbtendencia.getSelectedItem().toString());
            modelov.setTipo(vista.cbtipovivienda.getSelectedItem().toString());
            modelov.setMaterial(vista.cbmaterial.getSelectedItem().toString());
            modelov.setSaneamiento(vista.cbsaneamiento.getSelectedItem().toString());
            boolean agua = false;
            if (vista.chbagua.isSelected()) {
                agua = true;
            }
            modelov.setAgua(agua);

            boolean luz = false;
            if (vista.chbluz.isSelected()) {
                luz = true;
            }
            modelov.setLuz(luz);

            boolean drenaje = false;
            if (vista.chbdrenaje.isSelected()) {
                drenaje = true;
            }
            modelov.setDrenaje(drenaje);

            modelov.setNumHabitaciones(Integer.parseInt(vista.txtnumhabitaciones.getText()));
            modelov.setNumBanios(Integer.parseInt(vista.txtnumbanios.getText()));
            modelov.setUbicacion(vista.txtubicacion.getText());
            modelov.setDireccion(vista.txtdir.getText());

            // Modificar la vivienda en la base de datos
            if (consultasv.modificarVivienda(modelov)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
            }
      }
        

    }

    private void llenarComboBoxMunicipios() {
        List<String> municipios = consultasv.obtenerNombreMunicipios();
        if (municipios != null) {
            for (String municipio : municipios) {
                vista.cbmunicipio.addItem(municipio);
            }
        }
    }

    private void llenarComboBoxLocalidades() {
        List<String> localidades = consultasv.obtenerNombreLocalidades();
        if (localidades != null) {
            for (String localidad : localidades) {
                vista.cbmunicipio.addItem(localidad);
            }
        }
    }

}
