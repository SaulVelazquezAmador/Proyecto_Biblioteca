package controlador;
import modelo.Conexion;
import java.sql.*;

import javax.swing.JOptionPane;

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
	 public Usuario(String correo, String clave) {
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
				ResultSet miResultset = miStatement.executeQuery("select * from Clientes");
				
				while(miResultset.next()) {
					if (this.correo.equals(miResultset.getString("Correo")) 
							&& this.clave.equals(miResultset.getString("Contraseña"))) {
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
	 public Boolean consultar_para_registro(String nombre, String apellido,String correo, String clave) {
		 int encontrado = 0;

		 try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Clientes");
			
			while(miResultset.next()) {
				if (this.nombre.equals(miResultset.getString("Nombre")) 
						&& this.apellido.equals(miResultset.getString("Apellidos")) 
						|| this.correo.equals(miResultset.getString("Correo")) 
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
	 public void registrar_usuario(String nombre, String apellido, String correo, String clave) {

			try {
				Conexion c=new Conexion();
				Connection miConexion=c.getCon();
				
				this.nombre   = nombre;
				this.apellido = apellido;
				this.correo   = correo;
				this.clave    =  clave;
				int saldo     = 0;
				
				PreparedStatement sentencia = miConexion.prepareStatement("INSERT INTO Clientes(Nombre, Apellidos, Saldo, Correo, Contraseña) VALUES (?,?,?,?,?)");

				sentencia.setString(1, nombre);
				sentencia.setString(2, apellido);
				sentencia.setInt(3, saldo);
				sentencia.setString(4, correo);
				sentencia.setString(5,clave);

				sentencia.executeUpdate();
				c.cerrarConexion();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	 
	 }
}
