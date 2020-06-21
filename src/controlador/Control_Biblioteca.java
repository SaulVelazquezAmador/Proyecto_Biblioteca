package controlador;
import modelo.Conexion;
import java.sql.*;

import javax.swing.JOptionPane;

public class Control_Biblioteca {
	private String editorial;
	private String ciudad_editorial;

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
