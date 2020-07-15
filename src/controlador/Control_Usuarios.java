package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Conexion;

public class Control_Usuarios {
	 private int id;
	 private String nombre;
	 private String apellido_paterno;
	 private String apellido_materno;
	 private String correo;
	 private String clave;
//****************************************************************************************
	 public void baja_usuario(int id) {
		 this.id = id;
		 try {
			 Conexion c=new Conexion();
			 Connection miConexion=c.getCon();
				
			 PreparedStatement sentencia = miConexion.prepareStatement("delete from Bibliotecario where ID_Bibliotecario = ?");
			 
			 sentencia.setInt(1, this.id);

			 sentencia.executeUpdate();
			 
			 c.cerrarConexion();
		 	} catch (SQLException e) {
		 		e.printStackTrace();
			}		 
	 }
//****************************************************************************************
	 public void editar_usuario(int id, String nombre, String a_paterno, String a_materno,
			 String correo, String clave) {
		 this.id = id;
		 this.nombre = nombre;
		 this.apellido_paterno = a_paterno;
		 this.apellido_materno = a_materno;
		 this.correo = correo;
		 this.clave = clave;

		 try {
			 Conexion c=new Conexion();
			 Connection miConexion=c.getCon();
				
			 PreparedStatement sentencia = miConexion.prepareStatement("UPDATE Bibliotecario set Nombre_Bibliotecario=?, Apellido_Paterno_B=?, Apellido_Materno_B=?, Correo_Bibliotecario=?, Contraseña_Bibliotecario=? WHERE ID_Bibliotecario = ?");

			 sentencia.setString(1, this.nombre);
			 sentencia.setString(2, this.apellido_paterno);
			 sentencia.setString(3, this.apellido_materno);
			 sentencia.setString(4, this.correo);
			 sentencia.setString(5, this.clave);
			 sentencia.setInt(6, this.id);

			 sentencia.executeUpdate();							
			 c.cerrarConexion();
		 	} catch (SQLException e) {
		 		e.printStackTrace();
			}
	}
}
