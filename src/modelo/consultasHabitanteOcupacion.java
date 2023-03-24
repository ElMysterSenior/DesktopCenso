
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class consultasHabitanteOcupacion extends Conexion {
     public boolean registrarOcupacionHabitante(Habitante hab,Ocupacion oc) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "insert into habitante_ocupacion (habitante_idhabitante,ocupacion_idocupacion)values(?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, hab.getIdhabitante());
            ps.setInt(2, oc.getIdocupacion());

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
}
