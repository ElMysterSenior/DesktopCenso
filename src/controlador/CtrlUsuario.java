/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.consultasUsuario;
import modelo.Usuario;
import vista.frmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Habitante;
import modelo.Ocupacion;
import modelo.Vivienda;
import modelo.consultasHabitante;
import modelo.consultasHabitanteOcupacion;
import modelo.consultasOcupacion;
import modelo.consultasVivienda;
import vista.frmMenuOp;
import vista.frm_agregarCenso;


public class CtrlUsuario implements ActionListener {

    private final Usuario modelo;
    private final consultasUsuario consultas;
    private final frmLogin vista;


    public CtrlUsuario(Usuario modelo, consultasUsuario consultas, frmLogin vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;

        this.vista.btn_login.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Inico de sesion");
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btn_login) {
            modelo.setUsuario(vista.txt_usuario.getText());
            modelo.setPass(vista.txt_pass.getText());
            try {
                if (consultas.verificarUsuario(modelo)) {
                    JOptionPane.showMessageDialog(null, "LOGIN EXITOSO!");
                    vista.hide();
                    CtrlMenu ctrlMenu = new CtrlMenu(new frmMenuOp());
                    ctrlMenu.iniciar();
                } else {
                    JOptionPane.showMessageDialog(null, "EL USUARIO Y/O CONTRASEÑA INCORRECTA!");
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }

    }
}
