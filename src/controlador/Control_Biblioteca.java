package controlador;
import modelo.Conexion;
import java.sql.*;

import javax.swing.JOptionPane;

public class Control_Biblioteca {
	private String editorial;
	private String ciudad_editorial;
	private String nombre_autor;
	private String apellido_paterno;
	private String apellido_materno;
	private String nacionalidad_autor;
//********************************************************************************************
	public Boolean consultar_editoriales(String editorial, String ciudad) 
	 {
		int encontrado = 0;
		this.editorial        = editorial;
		this.ciudad_editorial = ciudad;

		 try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Editorial");
			
			while(miResultset.next()) {
				if (this.editorial.equals(miResultset.getString("Nombre_Editorial")) 
						&& this.ciudad_editorial.equals(miResultset.getString("Ciudad")))
				{
						encontrado = 1;
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
//*************************************************************************************
	public void agregar_editorial(String editorial, String ciudad){
		this.editorial        = editorial;
		this.ciudad_editorial = ciudad;
		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			this.editorial        = editorial;
			this.ciudad_editorial = ciudad;
			
			PreparedStatement sentencia = miConexion.prepareStatement("INSERT INTO Editorial(Nombre_Editorial, Ciudad) VALUES (?,?)");

			sentencia.setString(1, editorial);
			sentencia.setString(2, ciudad_editorial);

			sentencia.executeUpdate();
			c.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//*********************************************************************************************
	public Boolean consultar_autores(String nombre_autor, String apellido_paterno, String apellido_materno, String nacionalidad)
	{
		int encontrado        = 0;	
		this.nombre_autor     = nombre_autor;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		
		 try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Autor");
			
			while(miResultset.next()) {
				if (this.nombre_autor.equals(miResultset.getString("Nombre_Autor")) 
						&& this.apellido_paterno.equals(miResultset.getString("Apellido_Paterno_Autor"))
						&&  this.apellido_materno.equals(miResultset.getString("Apellido_Materno_Autor")))
				{
						encontrado = 1;
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
//****************************************************************************************
	public void agregar_autor(String nombre_autor, String apellido_paterno, String apellido_materno, String nacionalidad) {
		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			
			this.nombre_autor       = nombre_autor;
			this.apellido_paterno   = apellido_paterno;
			this.apellido_materno   = apellido_materno;
			this.nacionalidad_autor = nacionalidad;
			
			PreparedStatement sentencia = miConexion.prepareStatement("INSERT INTO Autor(Nombre_Autor, Apellido_Paterno_Autor,Apellido_Materno_Autor, Nacionalidad) VALUES (?,?,?,?)");

			sentencia.setString(1, nombre_autor);
			sentencia.setString(2, apellido_paterno);
			sentencia.setString(3, apellido_materno);
			sentencia.setString(4, nacionalidad_autor);

			sentencia.executeUpdate();
			c.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
