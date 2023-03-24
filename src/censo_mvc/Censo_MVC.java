/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censo_mvc;

import controlador.CtrlHabitante;
import controlador.CtrlUsuario;
import controlador.CtrlMenu;
import controlador.CtrlVivienda;
import modelo.consultasUsuario;
import modelo.Usuario;
import vista.frmLogin;
import modelo.Habitante;
import modelo.Vivienda;
import modelo.Ocupacion;
import modelo.consultasVivienda;
import modelo.consultasHabitante;
import modelo.consultasOcupacion;
import modelo.consultasHabitanteOcupacion;
import vista.frm_agregarCenso;
import vista.frmMenuOp;

public class Censo_MVC {

    public static void main(String[] args) {
       Usuario usu = new Usuario();
       Habitante hab = new Habitante();
       Vivienda viv=new Vivienda();
       Ocupacion oc=new Ocupacion();
       
       consultasUsuario cu = new consultasUsuario();
       consultasVivienda cv = new consultasVivienda();
       consultasHabitante ch = new consultasHabitante();
       consultasOcupacion co = new consultasOcupacion();
       consultasHabitanteOcupacion cho = new consultasHabitanteOcupacion();
       
       
       frmLogin frmlog = new frmLogin();
       frm_agregarCenso frmag =new frm_agregarCenso();
       CtrlUsuario ctrlusuario = new CtrlUsuario(usu,cu,frmlog);
       CtrlVivienda ctrlvivienda = new CtrlVivienda(viv,cv,frmag);
       CtrlHabitante ctrlhab = new CtrlHabitante(hab, ch, frmag);
       
      
       ctrlusuario.iniciar();

    

      
   
  
      

    }
    
}
