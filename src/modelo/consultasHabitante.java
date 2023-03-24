package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class consultasHabitante extends Conexion {

    public boolean registrarHabitante(Habitante hab) {
        PreparedStatement ps = null;
        Connection con = getConexion();
       
       String sql ="INSERT INTO habitante (idhabitante, nombre, edad, sexo, edo_civil,"
               + " nivel_educativo, ingresos, nacionalidad, vivienda_idvivienda) VALUES (?, ?, ?, ?, ?, ?,"
               + " ?, ?, (SELECT idvivienda FROM vivienda ORDER BY idvivienda DESC LIMIT 1))";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, hab.getIdhabitante());
            ps.setString(2, hab.getNombre());
            ps.setInt(3, hab.getEdad());
            ps.setString(4, String.valueOf(hab.getSexo()));
            ps.setString(5, hab.getEstadoCivil());
            ps.setString(6, hab.getNivelEducativo());
            ps.setInt(7, (int) hab.getIngresos());
            ps.setString(8, hab.getNacionalidad());
           

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

    }//end registrar habitante

    public boolean modificarVivienda(Habitante hab, Vivienda viv) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE habitante SET nombre=?, edad=?, sexo=?, edo_civil=?, "
                + "nivel_educativo=?, ingresos=?, nacionalidad=?, vivienda_idvivienda=? WHERE idhabitante=?";

        try {
            ps = con.prepareStatement(sql);
           
            ps.setString(1, hab.getNombre());
            ps.setInt(2, hab.getEdad());
            ps.setString(3, hab.getSexo());
            ps.setString(4, hab.getEstadoCivil());
            ps.setString(5, hab.getNivelEducativo());
            ps.setInt(6, hab.getIngresos());
            ps.setString(7, hab.getNacionalidad());
            ps.setInt(8, viv.getIdvivienda());
             ps.setInt(9, hab.getIdhabitante());
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

    }//end modificar habitante

  public boolean eliminarHabitante(int idHabitante) {
    PreparedStatement ps = null;
    Connection con = getConexion();
   
    String sql = "DELETE FROM habitante WHERE idhabitante = ?";
    
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idHabitante);

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
}


    public boolean buscarHabitante(Habitante hab, Vivienda viv) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM habitante WHERE idhabitante=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, hab.getIdhabitante());
            rs = ps.executeQuery();

            if (rs.next()) {
                hab.setNombre(rs.getString("nombre"));
                hab.setEdad(rs.getInt("edad"));
                hab.setSexo(rs.getString("sexo"));
                hab.setEstadoCivil(rs.getString("edo_civil"));
                hab.setNivelEducativo(rs.getString("nivel_educativo"));
                hab.setIngresos(rs.getInt("ingresos"));
                hab.setNacionalidad(rs.getString("nacionalidad"));
                viv.setIdvivienda(rs.getInt("vivienda_idvivienda"));

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

    }//end buscar habitante   
public List<Habitante> buscarHabitantesDeUltimaVivienda() {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
    String sql = "SELECT * FROM habitante WHERE vivienda_idvivienda=(SELECT idvivienda FROM vivienda ORDER BY idvivienda DESC LIMIT 1)";
    List<Habitante> habitantes = new ArrayList<>();

    try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Habitante hab = new Habitante();
            hab.setIdhabitante(rs.getInt("idhabitante"));
            hab.setNombre(rs.getString("nombre"));
            hab.setEdad(rs.getInt("edad"));
            hab.setSexo(rs.getString("sexo"));
            hab.setEstadoCivil(rs.getString("edo_civil"));
            hab.setNivelEducativo(rs.getString("nivel_educativo"));
            hab.setIngresos(rs.getInt("ingresos"));
            hab.setNacionalidad(rs.getString("nacionalidad"));
            habitantes.add(hab);
        }

    } catch (SQLException e) {
        System.err.println(e);
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    return habitantes;
}


}
