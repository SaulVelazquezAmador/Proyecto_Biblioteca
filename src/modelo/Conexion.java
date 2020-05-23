package modelo;
import java.sql.*;

public class Conexion {
	private Connection con = null;
	public Conexion(){
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banco", "root", "12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getCon() {
		return con;
	}
		
	public void cerrarConexion(){
		try {
			con.close();
		} catch (SQLException e) {
			  e.printStackTrace();
		  	}
	}
}
