package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Conexion;

public class Control_Clientes {
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private int edad;
	private String direccion;
	private String correo;
	private int telefono;
 	//********************************************************************************************
	public Boolean consultar_clientes(String nombre, String apellido_paterno, String apellido_materno,
			String correo, int telefono) 
	 {
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.correo = correo;
		this.telefono = telefono;
		int encontrado = 0;
		 try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Lector");
			
			while(miResultset.next()) {
				if (this.nombre.equals(miResultset.getString("Nombre")) 
						&& this.apellido_paterno.equals(miResultset.getString("Apellido_Paterno"))
						&& this.apellido_materno.equals(miResultset.getString("Apellido_Materno"))
						&& this.correo.equals(miResultset.getString("Correo_Electronico"))
						&& this.telefono == miResultset.getInt("Telefono"))
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
	public void agregar_cliente(String nombre, String apellido_paterno, String apellido_materno,
			int edad, String direccion, String correo, int telefono){
		
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.edad = edad;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		int prestamos = 0;
		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			PreparedStatement sentencia = miConexion.prepareStatement("INSERT INTO Lector(Nombre, Apellido_Paterno, Apellido_Materno, Edad, Direccion, Correo_Electronico, Telefono, Prestamos_Activos) VALUES (?,?,?,?,?,?,?,?)");

			sentencia.setString(1, this.nombre);
			sentencia.setString(2, this.apellido_paterno);
			sentencia.setString(3, this.apellido_materno);
			sentencia.setInt(4, this.edad);
			sentencia.setString(5, this.direccion);
			sentencia.setString(6, this.correo);
			sentencia.setInt(7, this.telefono);
			sentencia.setInt(8, prestamos);
			sentencia.executeUpdate();
			c.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
