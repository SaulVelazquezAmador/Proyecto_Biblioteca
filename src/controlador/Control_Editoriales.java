package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Conexion;

public class Control_Editoriales {
	private int id_editorial;
	private String editorial;
	private String ciudad_editorial;
	
	//*********************************Editar Editorial *****************************************
	public void editar_editorial(int id_editorial, String nombre_editorial, String ciudad) {
		
		this.id_editorial = id_editorial;
		this.editorial = nombre_editorial;
		this.ciudad_editorial = ciudad;
		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			PreparedStatement sentencia = miConexion.prepareStatement("UPDATE Editorial set Nombre_Editorial=?, Ciudad=? WHERE ID_Editorial = ?");

			sentencia.setString(1, this.editorial);
			sentencia.setString(2, this.ciudad_editorial);
			sentencia.setInt(3, this.id_editorial);

			sentencia.executeUpdate();							
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//********************************************************************************************
		public String baja_editorial(String nombre_editorial) {
			this.editorial = nombre_editorial;
	//*****************  Buscamos el ID de la editorial********************
			try {
				Conexion c=new Conexion();
				Connection miConexion=c.getCon();
				
				Statement miStatement=miConexion.createStatement();
				ResultSet miResultset = miStatement.executeQuery("select * from Editorial");
				
				while(miResultset.next()) {
					if (this.editorial.equals(miResultset.getString("Nombre_Editorial")))
					{
						this.id_editorial = miResultset.getInt("ID_Editorial");
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
				ResultSet miResultset = miStatement.executeQuery("select * from Libro");
				// Si la peticion es = 1 entonces es una alta
				while(miResultset.next()) {
					if (this.id_editorial == miResultset.getInt("R_Editorial"))
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
				
				PreparedStatement sentencia = miConexion.prepareStatement("delete from Editorial where ID_Editorial = ?");
				sentencia.setInt(1, this.id_editorial);
				
				sentencia.executeUpdate();
				
				c.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			return "exito";
		}
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
}
