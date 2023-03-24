/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oscar
 */
public class consultasOcupacion extends Conexion{
    public boolean registrarOcupacion(Ocupacion oc) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "insert into ocupacion (nombre_ocupacion,detalle_ocupacion)values(?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, oc.getNombre_ocupacion());
            ps.setString(2, oc.getDetalle_ocupacion());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }//end registrar ocupacion
    
    public boolean modificarOcupacion(Ocupacion oc) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE ocupacion SET nombre_ocupacion=?,detalle_ocupacion=? WHERE idocupacion=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, oc.getNombre_ocupacion());
            ps.setString(2, oc.getDetalle_ocupacion());
            ps.setInt(3, oc.getIdocupacion());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }//end modificar ocupacion
    
     public boolean eliminarOcupacion(Ocupacion oc) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM ocupacion WHERE idocupacion=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, oc.getIdocupacion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }//end eliminar ocupacion
      public boolean buscarOcupacion(Ocupacion oc) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM ocupacion WHERE idocupacion=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, oc.getIdocupacion());
            rs = ps.executeQuery();

            if (rs.next()) {
                oc.setNombre_ocupacion(rs.getString("nombre_ocupacion"));
                oc.setDetalle_ocupacion(rs.getString("detalle_ocupacion"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }//end buscar ocupacion   
}
