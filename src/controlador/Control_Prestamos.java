package controlador;

import java.text.SimpleDateFormat; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Conexion;

public class Control_Prestamos {
	private String id_libro;
	private int id_lector = 0;
	private int id_bibliotecario = 0;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String libro;
	private String fecha_actual;
	private String fecha_devolucion;
	private String tipo;
	private String bibliotecario;
	
	public Boolean consultar_prestamos(String libro, String nombre, 
			String apellido_paterno, String apellido_materno,
			String bibliotecario, String fecha_actual, 
			String fecha_devolucion, String tipo) {
		
		int encontrado = 0;
		
		this.libro = libro;
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.bibliotecario = bibliotecario;
		this.fecha_actual = fecha_actual;
		this.fecha_devolucion = fecha_devolucion;
		this.tipo = tipo;
//************** buscamos el id del cliente **************************************		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();

			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Lector");
			
			int id_lector = 0;
			while(miResultset.next()) {
				if (this.nombre.equals(miResultset.getString("Nombre"))
						&& this.apellido_paterno.equals(miResultset.getString("Apellido_Paterno"))
						&& this.apellido_materno.equals(miResultset.getString("Apellido_Materno")))
				{
					this.id_lector = miResultset.getInt("ID_Lector");
					System.out.println(this.id_lector);
				}
			}
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//************** buscamos el id del libro **************************************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();

			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Libro");
			
			while(miResultset.next()) {
				if (this.libro.equals(miResultset.getString("Titulo")))
				{
					this.id_libro = miResultset.getString("ISBN");
					System.out.println(this.id_libro);
				}
			}
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//************** buscamos el id del bibliotecario ******************************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();

			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Bibliotecario");
					
			while(miResultset.next()) {
				if (this.bibliotecario.equals(miResultset.getString("Correo_Bibliotecario")))
				{
					this.id_bibliotecario = miResultset.getInt("ID_Bibliotecario");
					System.out.println(this.id_bibliotecario);
				}
			}
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//************** buscamos el prestamo **************************************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Prestamos");
			
			while(miResultset.next()) {
				if (this.id_libro.equals(miResultset.getString("R_Libro"))
						&& this.id_lector == miResultset.getInt("R_Lector"))
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
		else {
			
//			SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy"); 
//			formatter1.parse(this.fecha_actual);
//			formatter1.parse(this.fecha_devolucion);
			
			int id_tipo;
			
			if(this.tipo.equals("Para Biblioteca"))
				id_tipo = 1;
			else
				id_tipo = 2;
				
			try {
				Conexion c=new Conexion();
				Connection miConexion=c.getCon();
				
				PreparedStatement sentencia = miConexion.prepareStatement("INSERT INTO Prestamos(R_Libro, R_Lector, R_Bibliotecario, Fecha_Entrega, Fecha_Devolucion, Sancion, R_Tipo_Prestamo) VALUES (?,?,?,?,?,?,?)");
				
				sentencia.setString(1, this.id_libro);
				sentencia.setInt(2, this.id_lector);
				sentencia.setInt(3, this.id_bibliotecario);
				sentencia.setString(4, this.fecha_actual);
				sentencia.setString(5, this.fecha_devolucion);
				sentencia.setFloat(6, 0);
				sentencia.setInt(7, id_tipo);

				sentencia.executeUpdate();							
				c.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		} 
							
	}
//*********************Agregamos libro ******************************************
}
