package controlador;
import modelo.Conexion;
import java.sql.*;

public class Control_Autores {

	private int id_autor;
	private String nombre_autor;
	private String apellido_paterno;
	private String apellido_materno;
	private String nacionalidad_autor;

//************************ Baja de autor  *****************************************************
	public String baja_autor(String nombre, String apellido_paterno, String apellido_materno) {
		
		this.nombre_autor = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		//*****************  Buscamos el ID de la editorial********************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Autor");
			
			while(miResultset.next()) {
				if (this.nombre_autor.equals(miResultset.getString("Nombre_Autor")) &&
						this.apellido_paterno.equals(miResultset.getString("Apellido_Paterno_Autor")) &&
						this.apellido_materno.equals(miResultset.getString("Apellido_Materno_Autor")))
				{
					this.id_autor = miResultset.getInt("ID_Autor");
				}
			}
			
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//***************  Buscamos si tiene algun libro dado de alta  ********************
		int activos = 0;
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Autores_Libro");
			// Si la peticion es = 1 entonces es una alta
			while(miResultset.next()) {
				if (this.id_autor == miResultset.getInt("R_Autor"))
					activos = 1;
			}
			
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (activos == 1) 
			return "tiene libros";
		//************  Realizamos la baja *********************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			PreparedStatement sentencia = miConexion.prepareStatement("delete from Autor where ID_Autor = ?");
			sentencia.setInt(1, this.id_autor);
			
			sentencia.executeUpdate();
			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "exito";
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
