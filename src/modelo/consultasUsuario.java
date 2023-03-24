/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import vista.frmLogin;

/**
 *
 * @author Oscar
 */
public class consultasUsuario extends Conexion {

 public boolean verificarUsuario(Usuario usuario) throws SQLException {
    Connection con = getConexion();
    String SQL = "SELECT * FROM login_usuario WHERE usuario = ? AND pass = ?";
    PreparedStatement stmt = con.prepareStatement(SQL);
    stmt.setString(1, usuario.getUsuario());
    stmt.setString(2, usuario.getPass());
    ResultSet rs = stmt.executeQuery();
    
    boolean encontrado = false;
    
    while (rs.next()) {
        encontrado = true;
    }
    
    return encontrado;
}



    
}
    

