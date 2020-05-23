package controlador;
import modelo.Conexion;
import java.sql.*;

public class Usuario {
	 private String nombre;
	 private String apellido;
	 private String correo;
	 private String clave;
 
	 public Usuario(String nombre, String apellido,String correo, String clave) {
		 this.nombre   = nombre;
		 this.apellido = apellido;
		 this.correo   = correo;
		 this.clave    = clave;
	 }
	 
	 public Boolean consultar_usuario(String nombre, String apellido,String correo, String clave) {
		 int encontrado = 0;
		 try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Clientes");
			
			while(miResultset.next()) {
				if (this.nombre.equals(miResultset.getString("Nombre")) 
						&& this.apellido.equals(miResultset.getString("Apellidos")) 
						&& this.correo.equals(miResultset.getString("Correo")) 
						&& this.apellido.equals(miResultset.getString("Contraseña"))) {
						encontrado = 1;
						System.out.println("encontrado");
				}
			}
			miStatement.close();
			miResultset.close();
			c.cerrarConexion();
			return true;
		} catch (SQLException e) {
			System.out.println("usuario");
			e.printStackTrace();
		}
		 if(encontrado == 1)
			 return true;
		 else
			 return false;
	 }
}
