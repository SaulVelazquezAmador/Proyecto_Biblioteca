package modelo;
import java.sql.*;

public class Conexion {
	private Connection con = null;
//----------------------------------------------------------
	public Conexion(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Biblioteca", "root", "12345");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
            System.out.println("Error desconocido: "+e);
        }
	}
//----------------------------------------------------------	
	public Connection getCon() {
		return con;
	}
//----------------------------------------------------------		
	public void cerrarConexion(){
		try {
			con.close();
		} catch (SQLException e) {
			  e.printStackTrace();
		  	}
	}
}
