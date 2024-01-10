package entidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.Conexion;

public class LoginDao {
	
	public static int validar(String username, String password) {
		Connection con;
		Conexion cn = new Conexion();
		
		PreparedStatement ps;
		ResultSet rs;
		String us = "";
		int valido = 0;
		String sql = "Select * from eval02.usuario where username = ? and password = ?";
		
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			rs = ps.executeQuery();
			while(rs.next()) {
				us = rs.getString("username");
			}
			if(us!=""||us!=null) {
				valido = 1;
			} else {
				valido = 0;
			}
		} catch (Exception e) {}
		return valido;
	}
	
	public static String describir(String username, String password) {
		Connection con;
		Conexion cn = new Conexion();
		
		PreparedStatement ps;
		ResultSet rs;
		String us = "";
		String msj = "";
		String sql = "Select concat('Nombre: ',Nombre,' ',Apellido,' - Fono: ',Telefono,' - Fecha Ingreso: ',FechaIngreso) as mensaje from eval02.persona where Rut in (Select Rut from eval02.usuario where username = ? and password = ?)";
		
		try {
			con = cn.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			rs = ps.executeQuery();
			while(rs.next()) {
				us = rs.getString("mensaje");
			}
			if(us!=""||us!=null) {
				msj = us;
			} else {
				msj = "";
			}
		} catch (Exception e) {}
		
		return msj;
	}
}
