package controlador;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Conexion;

public class Control_Prestamos {
	
	private String id_libro;
	private int prestamos_activos;
	private int ejemplares_libro = 0;
	private int id_lector = 0;
	private int id_bibliotecario = 0;
	private int id_prestamo;
	private float sancion;
	private String nombre;
	private String apellido_paterno;
	private String apellido_materno;
	private String libro;
	private String fecha_actual;
	private String fecha_devolucion;
	private String tipo;
	private String bibliotecario;
	
//************************************************************************************************	
	public void editar_prestamo(int id, String fecha_devolucion) {
		this.id_prestamo = id;
		this.fecha_devolucion = fecha_devolucion;
		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			PreparedStatement sentencia = miConexion.prepareStatement("UPDATE Prestamos set Fecha_Devolucion=?, R_Tipo_Prestamo=? WHERE ID_Prestamo = ?");

			sentencia.setString(1, this.fecha_devolucion);
			sentencia.setInt(2, 2);
			sentencia.setInt(3, this.id_prestamo);

			sentencia.executeUpdate();							
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//************************************************************************************************
	public String baja_prestamos(String nombre, String apellido_paterno, String apellido_materno,
			String libro) {
		this.libro = libro;
		this.nombre = nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;

//************** buscamos el id del cliente **************************************		
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
					this.prestamos_activos = miResultset.getInt("Prestamos_Activos");
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
					this.ejemplares_libro = miResultset.getInt("Ejemplares");
				}
			}
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//************** buscamos el adeudo **************************************
				try {
					Conexion c=new Conexion();
					Connection miConexion=c.getCon();

					Statement miStatement=miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Prestamos");
					
					while(miResultset.next()) {
						if (this.id_lector == miResultset.getInt("R_Lector") && this.id_libro.equals(miResultset.getString("R_Libro")))
						{
							this.sancion = miResultset.getFloat("Sancion");
						}
					}
					miStatement.close();
					miResultset.close();			
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
//*******************  Hacemos la baja  **************************************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			System.out.println(this.id_lector);
			System.out.println(this.id_libro);
			PreparedStatement sentencia = miConexion.prepareStatement("delete from Prestamos where R_Libro = ? and R_Lector = ?");

			sentencia.setString(1, this.id_libro);
			sentencia.setInt(2, this.id_lector);

			sentencia.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//------------- Actualizar ejemplares de libro -------------------------------
		try {
			this.ejemplares_libro += 1;
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			PreparedStatement sentencia = miConexion.prepareStatement("UPDATE Libro set Ejemplares = ? WHERE ISBN = ?");

			sentencia.setInt(1, this.ejemplares_libro);
			sentencia.setString(2, this.id_libro);

			sentencia.executeUpdate();							
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//--------------- Actualizar prestamos activos del lector---------------------------------
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			this.prestamos_activos -= 1;
			
			PreparedStatement sentencia = miConexion.prepareStatement("UPDATE Lector set Prestamos_Activos = ? WHERE ID_Lector = ?");

			sentencia.setInt(1, this.prestamos_activos);
			sentencia.setInt(2, this.id_lector);

			sentencia.executeUpdate();							
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(this.sancion == 5) 
			return "con sancion";
		else
			return "sin sancion";
	}
//***************************************************************************
//*************************** Altas de prestamos *****************************
//***************************************************************************
	public String altas_prestamos(String libro, String nombre, 
			String apellido_paterno, String apellido_materno,
			String fecha_actual, 
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
			
			while(miResultset.next()) {
				if (this.nombre.equals(miResultset.getString("Nombre"))
						&& this.apellido_paterno.equals(miResultset.getString("Apellido_Paterno"))
						&& this.apellido_materno.equals(miResultset.getString("Apellido_Materno")))
				{
					this.prestamos_activos = miResultset.getInt("Prestamos_Activos");
					this.id_lector = miResultset.getInt("ID_Lector");
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
					this.ejemplares_libro = miResultset.getInt("Ejemplares");
				}
			}
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (this.ejemplares_libro == 0)
			return "no hay libros";
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
			return "prestamo ya existe";
		else {
			
	//*********** Realizamos el prestamo **************************************
			int id_tipo;
			
			if(this.tipo.equals("Para Biblioteca"))
				id_tipo = 1;
			else
				id_tipo = 2;
				
			try {
				Conexion c=new Conexion();
				Connection miConexion=c.getCon();
				
				PreparedStatement sentencia = miConexion.prepareStatement("INSERT INTO Prestamos(R_Libro, R_Lector, Fecha_Entrega, Fecha_Devolucion, Sancion, R_Tipo_Prestamo) VALUES (?,?,?,?,?,?)");
				
				sentencia.setString(1, this.id_libro);
				sentencia.setInt(2, this.id_lector);
				sentencia.setString(3, this.fecha_actual);
				sentencia.setString(4, this.fecha_devolucion);
				sentencia.setFloat(5, 0);
				sentencia.setInt(6, id_tipo);
				sentencia.executeUpdate();	
				
				c.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
//------------- Actualizar ejemplares de libro -------------------------------
			try {
				this.ejemplares_libro -= 1;
				Conexion c=new Conexion();
				Connection miConexion=c.getCon();
				
				PreparedStatement sentencia = miConexion.prepareStatement("UPDATE Libro set Ejemplares = ? WHERE ISBN = ?");

				sentencia.setInt(1, this.ejemplares_libro);
				sentencia.setString(2, this.id_libro);

				sentencia.executeUpdate();							
				c.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
//--------------- Actualizar prestamos activos del lector---------------------------------
			try {
				Conexion c=new Conexion();
				Connection miConexion=c.getCon();
				
				this.prestamos_activos += 1;
				
				PreparedStatement sentencia = miConexion.prepareStatement("UPDATE Lector set Prestamos_Activos = ? WHERE ID_Lector = ?");

				sentencia.setInt(1, this.prestamos_activos);
				sentencia.setInt(2, this.id_lector);

				sentencia.executeUpdate();							
				c.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "exito";
		} 
						
	}
}
