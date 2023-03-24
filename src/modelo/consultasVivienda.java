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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Oscar
 */
public class consultasVivienda extends Conexion {

    public boolean registrarVivienda(Vivienda viv) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO vivienda (tipo_vivienda,material,saneamiento,agua,luz,drenaje,tendencia,direccion,"
                + "        num_habitaciones,num_banios,localidades_idlocalidades,localidades_municipio_idmunicipio) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, viv.getTipo());
            ps.setString(2, viv.getMaterial());
            ps.setString(3, viv.getSaneamiento());
            ps.setBoolean(4, viv.getAgua());
            ps.setBoolean(5, viv.getLuz());
            ps.setBoolean(6, viv.getDrenaje());
            ps.setString(7, viv.getTendencia());
            ps.setString(8, viv.getDireccion());
            ps.setInt(9, viv.getNumHabitaciones());
            ps.setInt(10, viv.getNumBanios());
            ps.setInt(11, viv.getId_localidad());
            ps.setInt(12, viv.getId_municipio());
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

    }//end registrar Vivienda

    public boolean modificarVivienda(Vivienda viv) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE vivienda SET tipo_vivienda = ?, material = ?, saneamiento = ?, agua = ?, luz = ?, drenaje = ?, tendencia = ?, direccion = ?, num_habitaciones = ?, num_banios = ?,"
                + " localidades_idlocalidades = ?, localidades_municipio_idmunicipio = ? ORDER BY idvivienda DESC LIMIT 1";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, viv.getTipo());
            ps.setString(2, viv.getMaterial());
            ps.setString(3, viv.getSaneamiento());
            ps.setBoolean(4, viv.getAgua());
            ps.setBoolean(5, viv.getLuz());
            ps.setBoolean(6, viv.getDrenaje());
            ps.setString(7, viv.getTendencia());
            ps.setString(8, viv.getDireccion());
            ps.setInt(9, viv.getNumHabitaciones());
            ps.setInt(10, viv.getNumBanios());
            ps.setInt(11, viv.getId_localidad());
            ps.setInt(12, viv.getId_municipio());
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

    }//end modificar vivienda
    
    public int obtenerUltimoIdVivienda() {
    int id = 0;
    try {
         Connection con = getConexion();
        String sql = "SELECT MAX(id_vivienda) FROM vivienda";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        rs.close();
        ps.close();
        con.close();
    } catch (SQLException e) {
        System.out.println(e);
    }
    return id;
}


    //NO ELIMINAR VIVIENDA POR CONSISTENCIA DE LA BD
    /*  public boolean eliminarVivienda(Vivienda viv){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql= "DELETE FROM vivienda WHERE idvivienda=?";
        try{
            ps= con.prepareStatement(sql);
            ps.setInt(1,viv.getIdvivienda());
            ps.execute();
            return true;
        }   
        catch (SQLException e){
            System.err.println(e);
            return false;
        }
        finally{
            try{
                con.close();
            }
            catch (SQLException e){
                System.err.println(e); 
            }
        }
        
    }//end eliminar
     */
    public boolean buscarViienda(Vivienda viv) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM vivienda WHERE idvivienda=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, viv.getIdvivienda());
            rs = ps.executeQuery();

            if (rs.next()) {
                viv.setTipo(rs.getString("tipo_vivienda"));
                viv.setMaterial(rs.getString("material"));
                viv.setSaneamiento(rs.getString("saneamiento"));
                viv.setAgua(rs.getBoolean("agua"));
                viv.setLuz(rs.getBoolean("luz"));
                viv.setDrenaje(rs.getBoolean("drenaje"));
                viv.setTendencia(rs.getString("tendencia"));
                viv.setDireccion(rs.getString("direccion"));
                viv.setNumHabitaciones(rs.getInt("num_habitaciones"));
                viv.setNumBanios(rs.getInt("num_banios"));
                viv.setId_localidad(rs.getInt("localidades_idlocalidades"));
                viv.setId_municipio(rs.getInt("localidades_municipio_idmunicipio"));
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

    }//end buscar    

    /*
    LOS SIGUENTES METODOS SON DE PRUEBA PARA INTENTAR LLENAR COMBOBOX DE LA VISTA CON DATOS DE LA BASE DE DATOS
    SE BUSCA QUE AL SELECCIONAR UN MUNICIPIO, EL SEGUNDO COMBO BOX ASIGNE SOLO LOCALIDADES DE ESTE MUNICIPIO
    */
    


public List<String> obtenerNombreMunicipios() {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    String SQL = "SELECT nombre_municipio FROM municipio";
    try {
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();

        List<String> municipios = new ArrayList<>();
        while (rs.next()) {
            municipios.add(rs.getString("nombre_municipio"));
        }

        return municipios;

    } catch (SQLException e) {
        System.err.println(e);
        return null;
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

    public List<String> obtenerNombreLocalidades() {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    String SQL = "SELECT nombre_localidad FROM localidades";
    try {
        ps = con.prepareStatement(SQL);
        rs = ps.executeQuery();

        List<String> localidades = new ArrayList<>();
        while (rs.next()) {
            localidades.add(rs.getString("nombre_localidad"));
        }

        return localidades;

    } catch (SQLException e) {
        System.err.println(e);
        return null;
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
    public int obtenerIdMunicipio(String nombreMunicipio) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    String SQL = "SELECT idmunicipio FROM municipio WHERE nombre_municipio = ?";
    try {
        ps = con.prepareStatement(SQL);
        ps.setString(1, nombreMunicipio);
        rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("idmunicipio");
        } else {
            return -1;
        }

    } catch (SQLException e) {
        System.err.println(e);
        return -1;
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}

    public int obtenerIdLocalidad(String nombreLocalidad) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    String SQL = "SELECT idlocalidades FROM localidades WHERE nombre_localidad = ?";
    try {
        ps = con.prepareStatement(SQL);
        ps.setString(1, nombreLocalidad);
        rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("idlocalidades");
        } else {
            return -1;
        }

    } catch (SQLException e) {
        System.err.println(e);
        return -1;
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
    public List<String> obtenerLocalidadesPorIdMunicipio(int idMunicipio) {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    String SQL = "SELECT nombre_localidad FROM localidades WHERE municipio_idmunicipio = ?";
    try {
        ps = con.prepareStatement(SQL);
        ps.setInt(1, idMunicipio);
        rs = ps.executeQuery();

        List<String> localidades = new ArrayList<>();
        while (rs.next()) {
            localidades.add(rs.getString("nombre_localidad"));
        }

        return localidades;

    } catch (SQLException e) {
        System.err.println(e);
        return null;
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}





    
    
    

}//end class
