package controlador;
import modelo.Conexion;
import java.sql.*;

import javax.swing.JOptionPane;

public class Usuario {
	 private String nombre;
	 private String apellido_paterno;
	 private String apellido_materno;
	 private String correo;
	 private String clave;
 
	 public Usuario(String nombre, String apellido_paterno, String apellido_materno, String correo, String clave) 
	 {
		 this.nombre           = nombre;
		 this.apellido_paterno = apellido_paterno;
		 this.apellido_materno = apellido_materno;
		 this.correo           = correo;
		 this.clave            = clave;
	 }
	 public Usuario(String correo, String clave) 
	 {
		 this.correo = correo;
		 this.clave  = clave;
	 }
//****************************************************************************************
	 public Boolean consultar_para_inicio(String correo, String clave) {
		 int encontrado = 0;
		 
			try {
				Conexion c            =new Conexion();
				Connection miConexion =c.getCon();
				Statement miStatement =miConexion.createStatement();
				ResultSet miResultset = miStatement.executeQuery("select * from Bibliotecario");
				
				while(miResultset.next()) {
					if (this.correo.equals(miResultset.getString("Correo_Bibliotecario")) 
							&& this.clave.equals(miResultset.getString("Contraseña_Bibliotecario"))) {
							encontrado = 1;
							System.out.println("encontrado 1");
					}
				}
				miStatement.close();
				miResultset.close();
				c.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}		 
		 
		if(encontrado == 1)
			 return true;
		 else
			 return false;
	 }
//********************************************************************************************
	 public Boolean consultar_para_registro(String nombre, String apellido_paterno, 
			 String apellido_materno, String correo, String clave) 
	 {
		 
		 int encontrado = 0;

		 try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Bibliotecario");
			
			while(miResultset.next()) {
				if (this.nombre.equals(miResultset.getString("Nombre_Bibliotecario")) 
						&& this.apellido_paterno.equals(miResultset.getString("Apellido_Paterno_B")) 
						&& this.apellido_materno.equals(miResultset.getString("Apellido_Materno_B")) 
						|| this.correo.equals(miResultset.getString("Correo_Bibliotecario")) 
						/*&& this.clave.equals(miResultset.getString("Contraseña"))*/) {
						encontrado = 1;
						System.out.println("encontrado");
				}
			}
			miStatement.close();
			miResultset.close();
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 if(encontrado == 1)
			 return true;
		 else
			 return false;
	 }
//**************************************************************************************
	 public void registrar_usuario(String nombre, String apellido_paterno, String apellido_materno, String correo, String clave) {

			try {
				Conexion c=new Conexion();
				Connection miConexion=c.getCon();
				
				this.nombre           = nombre;
				this.apellido_paterno = apellido_paterno;
				this.apellido_materno = apellido_materno;
				this.correo           = correo;
				this.clave            = clave;
				
				PreparedStatement sentencia = miConexion.prepareStatement("INSERT INTO Bibliotecario(Nombre_Bibliotecario, Apellido_Paterno_B, Apellido_Materno_B, Correo_Bibliotecario, Contraseña_Bibliotecario) VALUES (?,?,?,?,?)");

				sentencia.setString(1, nombre);
				sentencia.setString(2, apellido_paterno);
				sentencia.setString(3, apellido_materno);
				sentencia.setString(4, correo);
				sentencia.setString(5, clave);

				sentencia.executeUpdate();
				c.cerrarConexion();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	 
	 }
}
