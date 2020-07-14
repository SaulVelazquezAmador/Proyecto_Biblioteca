package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Conexion;

public class Control_Clientes {
	private int id_lector = 0;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private int edad;
	private String direccion;
	private String correo;
	private String telefono;
	//********************************************************************************************
	public void editar_clientes(int id, String nombre, String apellido_paterno, String apellido_materno,
			int edad, String direccion, String correo, String telefono) {
		
		this.id_lector = id;
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.edad = edad;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			PreparedStatement sentencia = miConexion.prepareStatement("UPDATE Lector set Nombre=?, Apellido_Paterno=?, Apellido_Materno=?, Edad=?, Direccion = ?, Correo_Electronico=?, Telefono=? WHERE ID_Lector = ?");

			sentencia.setString(1, this.nombre);
			sentencia.setString(2, this.apellido_paterno);
			sentencia.setString(3, this.apellido_materno);
			sentencia.setInt(4, this.edad);
			sentencia.setString(5, this.direccion);
			sentencia.setString(6, this.correo);
			sentencia.setString(7, this.telefono);
			sentencia.setInt(8, this.id_lector);

			sentencia.executeUpdate();							
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 	//********************************************************************************************
	public Boolean consultar_clientes(String nombre, String apellido_paterno, String apellido_materno,
			String correo, String telefono) 
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
						&& this.telefono == miResultset.getString("Telefono"))
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
			int edad, String direccion, String correo, String telefono){
		
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
			sentencia.setString(7, this.telefono);
			sentencia.setInt(8, prestamos);
			sentencia.executeUpdate();
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//******************************************************************
	//***************** Eliminar cliente *******************************
	//******************************************************************
	public String eliminar_cliente(String nombre, String apellido_paterno, String apellido_materno) {
		
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
	//********  Buscamos su ID **********
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Lector");
			
			while(miResultset.next()) {
				if (this.nombre.equals(miResultset.getString("Nombre"))
						&& this.apellido_paterno.equals(miResultset.getString("Apellido_Paterno"))
						&& this.apellido_materno.equals(miResultset.getString("Apellido_Materno")))
				{
					this.id_lector = miResultset.getInt("ID_Lector");
				}
			}
			
			//PreparedStatement sentencia = miConexion.prepareStatement("DELETE From Lector WHERE ID_Lector = ?");
			//sentencia.setInt(1, this.id_lector);
			
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	//***************  Buscamos si tiene algun prestamo activo  ********************
		int activos = 0;
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Prestamos");
			
			while(miResultset.next()) {
				if (this.id_lector == miResultset.getInt("R_Lector"))
				{
					activos = 1;
				}
			}
			
			//PreparedStatement sentencia = miConexion.prepareStatement("DELETE From Lector WHERE ID_Lector = ?");
			//sentencia.setInt(1, this.id_lector);
			
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (activos == 1) {
			return "tiene prestamos";
		}
	//************  Realizamos la baja *********************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			PreparedStatement sentencia = miConexion.prepareStatement("delete from Lector where ID_Lector = ?");
			sentencia.setInt(1, this.id_lector);
			
			sentencia.executeUpdate();
			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "exito";
	}
}
