package controlador;
import modelo.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Conexion;

public class Control_Libros {
	private String autor1;
	private String autor2;
	private String autor3;
	private String autor4;
	private String autor5;
	private String isbn;
	private String titulo;
	private String editorial;
	private String clasificacion;
	private String subclasificacion;
	private int numero_autores;
	private int year;
	private int ejemplares;
	private String ubicacion;
//************************************************************
	public void editar_libro(String isbn, String titulo, String editorial, String clasificacion,
			String subclasificacion, int año, int ejemplares) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.clasificacion = clasificacion;
		this.subclasificacion = subclasificacion;
		this.year = año;
		this.ejemplares = ejemplares;
		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
//************** buscamos el id de la editorial **************************************
			Statement miStatement2=miConexion.createStatement();
			ResultSet miResultset2 = miStatement2.executeQuery("select * from Editorial");
			
			int id_editorial = 0;
			while(miResultset2.next()) {
				if (this.editorial.equals(miResultset2.getString("Nombre_Editorial")))
				{
					id_editorial= miResultset2.getInt("ID_Editorial");
				}
			}
			miStatement2.close();
			miResultset2.close();
//************** buscamos el id de la clasificacion ***********************************
			Statement miStatement3=miConexion.createStatement();
			ResultSet miResultset3 = miStatement3.executeQuery("select * from Clasificacion");
			
			int id_clasif = 0;
			while(miResultset3.next()) {
				if (this.clasificacion.equals(miResultset3.getString("Nombre_Clasificacion")))
				{
					id_clasif= miResultset3.getInt("ID_Clasificacion");
				}
			}
			miStatement3.close();
			miResultset3.close();
//************** buscamos el id de la subclasificacion ********************************
			Statement miStatement4=miConexion.createStatement();
			ResultSet miResultset4 = miStatement4.executeQuery("select * from Subclasificacion");
			
			int id_subclasif = 0;
			while(miResultset4.next()) {
				if (this.subclasificacion.equals(miResultset4.getString("Nombre_Subclasificacion")))
				{
					id_subclasif= miResultset4.getInt("ID_Subclasificacion");
				}
			}
			miStatement4.close();
			miResultset4.close();
//*********************************************************************************************
			
			PreparedStatement sentencia = miConexion.prepareStatement("UPDATE Libro set Titulo=?, R_Editorial=?, R_Clasificacion=?, R_Subclasificacion=?, Año=?, Ejemplares=? WHERE ISBN = ?");

			sentencia.setString(1, this.titulo);
			sentencia.setInt(2, id_editorial);
			sentencia.setInt(3, id_clasif);
			sentencia.setInt(4, id_subclasif);
			sentencia.setInt(5, this.year);
			sentencia.setInt(6, this.ejemplares);
			sentencia.setString(7, this.isbn);

			sentencia.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}
	//****************************************************************************
	//******************* Consultar **********************************************
	//****************************************************************************
	public Boolean consultar_libros(String isbn) {
		int encontrado = 0;
		this.isbn = isbn;
		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Libro");
			
			while(miResultset.next()) {
				if (this.isbn.equals(miResultset.getString("ISBN")))
						encontrado = 1;
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
//****************************************************************************
//*******************  Alta de libros  ***************************************	
//****************************************************************************
	public void agregar_libros(String isbn, String titulo, String editorial, String clasificacion,
			String subclasificacion, int n_autores, int año, int ejemplares, String ubicacion,
			String autor1, String autor2, String autor3, String autor4, String autor5) 
	{
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.clasificacion = clasificacion;
		this.subclasificacion = subclasificacion;
		this.numero_autores = n_autores;
		this.year = año;
		this.ejemplares = ejemplares;
		this.ubicacion = ubicacion;
		
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
//************** buscamos el id de la editorial **************************************
			Statement miStatement2=miConexion.createStatement();
			ResultSet miResultset2 = miStatement2.executeQuery("select * from Editorial");
			
			int id_editorial = 0;
			while(miResultset2.next()) {
				if (this.editorial.equals(miResultset2.getString("Nombre_Editorial")))
				{
					id_editorial= miResultset2.getInt("ID_Editorial");
				}
			}
			miStatement2.close();
			miResultset2.close();
//************** buscamos el id de la clasificacion ***********************************
			Statement miStatement3=miConexion.createStatement();
			ResultSet miResultset3 = miStatement3.executeQuery("select * from Clasificacion");
			
			int id_clasif = 0;
			while(miResultset3.next()) {
				if (this.clasificacion.equals(miResultset3.getString("Nombre_Clasificacion")))
				{
					id_clasif= miResultset3.getInt("ID_Clasificacion");
				}
			}
			miStatement3.close();
			miResultset3.close();
//************** buscamos el id de la subclasificacion ********************************
			Statement miStatement4=miConexion.createStatement();
			ResultSet miResultset4 = miStatement4.executeQuery("select * from Subclasificacion");
			
			int id_subclasif = 0;
			while(miResultset4.next()) {
				if (this.subclasificacion.equals(miResultset4.getString("Nombre_Subclasificacion")))
				{
					id_subclasif= miResultset4.getInt("ID_Subclasificacion");
				}
			}
			miStatement4.close();
			miResultset4.close();
			
//************** buscamos el id de la ubicacion **************************************
			Statement miStatement5=miConexion.createStatement();
			ResultSet miResultset5 = miStatement5.executeQuery("select * from Libreros");
			
			int id_librero = 0;
			while(miResultset5.next()) {
				if (this.ubicacion.equals(miResultset5.getString("Nombre_Librero")))
				{
					id_librero= miResultset5.getInt("ID_Librero");
				}
			}
			miStatement5.close();
			miResultset5.close();
//************** Agregamos el libro ********************************************
			PreparedStatement sentencia = miConexion.prepareStatement("INSERT INTO Libro(ISBN, Titulo, R_Editorial, R_Clasificacion, R_Subclasificacion, Numero_de_Autores, Año, Ejemplares,R_Ubicacion) VALUES (?,?,?,?,?,?,?,?,?)");
			
			sentencia.setString(1, this.isbn);
			sentencia.setString(2, this.titulo);
			sentencia.setInt(3, id_editorial);
			sentencia.setInt(4, id_clasif);
			sentencia.setInt(5, id_subclasif);
			sentencia.setInt(6, this.numero_autores);
			sentencia.setInt(7, this.year);
			sentencia.setInt(8, this.ejemplares);
			sentencia.setInt(9, id_librero);
			sentencia.executeUpdate();
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//*********************************************************************************
		try {
			Conexion c2=new Conexion();
			Connection miConexion2=c2.getCon();
			this.autor1 = autor1;
			this.autor2 = autor2;
			this.autor3 = autor3;
			this.autor4 = autor4;
			this.autor5 = autor5;
//************** agregamos los autores ********************************************
			Statement miStatement1=miConexion2.createStatement();
			ResultSet miResultset1 = miStatement1.executeQuery("select * from Autor");
			
			int id_autor1 = 0, id_autor2 = 0, id_autor3 = 0, id_autor4 = 0, id_autor5 = 0;

			while(miResultset1.next()) {
				if (this.autor1.equals(miResultset1.getString("Nombre_Autor")))
					id_autor1= miResultset1.getInt("ID_Autor");

				if (this.autor2.equals(miResultset1.getString("Nombre_Autor")))
					id_autor2= miResultset1.getInt("ID_Autor");

				if (this.autor3.equals(miResultset1.getString("Nombre_Autor")))
					id_autor3= miResultset1.getInt("ID_Autor");

				if (this.autor4.equals(miResultset1.getString("Nombre_Autor")))
					id_autor4= miResultset1.getInt("ID_Autor");
				
				if (this.autor5.equals(miResultset1.getString("Nombre_Autor")))
					id_autor5= miResultset1.getInt("ID_Autor");
			}
			miStatement1.close();
			miResultset1.close();
			
//************** Agregamos el libro ********************************************
			PreparedStatement sentencia2 = miConexion2.prepareStatement("INSERT INTO Autores_Libro(R_Autor, R_ISBN) VALUES (?,?)");

			for (int i=0; i<this.numero_autores; i++) {
				if (i == 0) {
					sentencia2.setInt(1, id_autor1);
					sentencia2.setString(2, this.isbn);
					sentencia2.executeUpdate();		
				}	
				if (i == 1) {
					sentencia2.setInt(1, id_autor2);
					sentencia2.setString(2, this.isbn);
					sentencia2.executeUpdate();		
				}	
				if (i == 2) {
					sentencia2.setInt(1, id_autor3);
					sentencia2.setString(2, this.isbn);
					sentencia2.executeUpdate();		
				}	
				if (i == 3) {
					sentencia2.setInt(1, id_autor4);
					sentencia2.setString(2, this.isbn);
					sentencia2.executeUpdate();		
				}	
				if (i == 4) {
					sentencia2.setInt(1, id_autor5);
					sentencia2.setString(2, this.isbn);
					sentencia2.executeUpdate();	
					
				}				
			}
			c2.cerrarConexion();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//****************************************************************************
	//*******************  Baja de libros  ***************************************	
	//****************************************************************************
	public String baja_libros(String titulo) {
		this.titulo = titulo;
		//******** buscamos el id del libro *************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();

			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Libro");
					
			while(miResultset.next()) {
				if (this.titulo.equals(miResultset.getString("Titulo")))
				{
					this.isbn = miResultset.getString("ISBN");
				}
			}
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//************* verificamos si se encuentra en prestamo *******************
		int activos = 0;
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();

			Statement miStatement=miConexion.createStatement();
			ResultSet miResultset = miStatement.executeQuery("select * from Prestamos");
					
			while(miResultset.next()) {
				if (this.isbn.equals(miResultset.getString("R_Libro")))
				{
					activos = 1;
				}
			}
			miStatement.close();
			miResultset.close();			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (activos == 1)
			return "tiene prestamos";
		//************  Realizamos baja de tabla Autores_Libro *********************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			PreparedStatement sentencia = miConexion.prepareStatement("delete from Autores_Libro where R_ISBN = ?");
			sentencia.setString(1, this.isbn);
			
			sentencia.executeUpdate();
			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		//************  Realizamos la baja *********************
		try {
			Conexion c=new Conexion();
			Connection miConexion=c.getCon();
			
			PreparedStatement sentencia = miConexion.prepareStatement("delete from Libro where ISBN = ?");
			sentencia.setString(1, this.isbn);
			
			sentencia.executeUpdate();
			
			c.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return "exito";
	}
	
}