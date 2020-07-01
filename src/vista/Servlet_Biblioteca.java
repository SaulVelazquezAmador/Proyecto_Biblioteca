package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.Control_Biblioteca;
import controlador.Usuario;
import modelo.Conexion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet_Biblioteca")
public class Servlet_Biblioteca extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public Servlet_Biblioteca() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		
		boolean existe = false;

		String tipo_peticion      = request.getParameter("tipo_muestra");
		
		String sub_clasificacion  = request.getParameter("sub_clas");
		//************************* Actualizaciones dinamicas de paginas*****************
		if (tipo_peticion != null) {

			int peticion = Integer.parseInt(tipo_peticion);
			System.out.println("aaaaaa");
			if(peticion == 3)
			{
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Clasificacion order by Nombre_Clasificacion asc");
					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");
					PrintWriter salida = response.getWriter();
					salida.println("Clasificacion: <select id=\"sel_clasif\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Clasificacion") + "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}

			if (peticion == 30) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Editorial order by Nombre_Editorial asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Editorial: <select id=\"sel_edit\">>");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Editorial") + "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 301) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Autor: <select id=\"aut_1\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Autor")+ " " + miResultset.getString("Apellido_Paterno_Autor")+ " "+ miResultset.getString("Apellido_Materno_Autor")+ "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 302) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Autor: <select id=\"aut_2\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Autor")+ " " + miResultset.getString("Apellido_Paterno_Autor")+ " "+ miResultset.getString("Apellido_Materno_Autor")+ "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 303) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Autor: <select id=\"aut_3\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Autor")+ " " + miResultset.getString("Apellido_Paterno_Autor")+ " "+ miResultset.getString("Apellido_Materno_Autor")+ "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 304) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Autor: <select id=\"aut_4\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Autor")+ " " + miResultset.getString("Apellido_Paterno_Autor")+ " "+ miResultset.getString("Apellido_Materno_Autor")+ "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 305) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Autor: <select id=\"aut_5\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Autor")+ " " + miResultset.getString("Apellido_Paterno_Autor")+ " "+ miResultset.getString("Apellido_Materno_Autor")+ "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 306) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Libreros order by Nombre_Librero asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Ubicación: <select id=\"ubicacion_libro\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Librero")+ "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 6) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Editorial order by Nombre_Editorial asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");
					int imparese = 0;
					PrintWriter salida = response.getWriter();
					salida.println("<table id='tabla_editoriales'>");
					salida.println("<tr bgcolor='#01a87a'>");
					salida.println("<td id = 'cole1' class = 'col_tabla_editoriales'><label>Nombre    </label></td>");
                    salida.println("<td id = 'cole2' class = 'col_tabla_editoriales'><label>Ciudad    </label></td>");
					salida.println("<td id = 'cole3' class = 'col_tabla_editoriales'><label>Editar    </label></td>");
                    salida.println("<td id = 'cole4' class = 'col_tabla_editoriales'><label>Eliminar  </label></td>");
                    salida.println("</tr>");
					while(miResultset.next()) {
						if (imparese % 2 !=0) {
							salida.println("<tr bgcolor='#01a87a'>");
							salida.println("<td id = 'cole1' class = 'col_tabla_editoriales'>" + miResultset.getString("Nombre_Editorial") + "</td>");
							salida.println("<td id = 'cole2' class = 'col_tabla_editoriales'>" + miResultset.getString("Ciudad") + "</td>");
							salida.println("<td id = 'cole3' class = 'col_tabla_editoriales'></td>");
		                    salida.println("<td id = 'cole4' class = 'col_tabla_editoriales'></td>");
							salida.println("</tr>");							
						}
						else {
							salida.println("<tr>");
							salida.println("<td id = 'cole1' class = 'col_tabla_editoriales'>" + miResultset.getString("Nombre_Editorial") + "</td>");
							salida.println("<td id = 'cole2' class = 'col_tabla_editoriales'>" + miResultset.getString("Ciudad") + "</td>");
							salida.println("<td id = 'cole3' class = 'col_tabla_editoriales'></td>");
		                    salida.println("<td id = 'cole4' class = 'col_tabla_editoriales'></td>");
							salida.println("</tr>");
						}
						imparese += 1;
					}
					salida.println("</table>");
					
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
			}
			if (peticion == 7) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");
					int impares = 0;
					PrintWriter salida = response.getWriter();
					salida.println("<table id='tabla_autores'>");
					salida.println("<tr bgcolor='#01a87a'>");
					salida.println("<td id = 'col_au1' class = 'col_tabla_autores'><label>Nombre            </label></td>");
                    salida.println("<td id = 'col_au2' class = 'col_tabla_autores'><label>Apellido paterno  </label></td>");
                    salida.println("<td id = 'col_au3' class = 'col_tabla_autores'><label>Apellido materno  </label></td>");
                    salida.println("<td id = 'col_au4' class = 'col_tabla_autores'><label>Nacionalidad      </label></td>");
					salida.println("<td id = 'col_au5' class = 'col_tabla_autores'><label>Editar            </label></td>");
                    salida.println("<td id = 'col_au6' class = 'col_tabla_autores'><label>Eliminar          </label></td>");
                    salida.println("</tr>");
					while(miResultset.next()) {
						if (impares % 2 != 0) {
							salida.println("<tr bgcolor='#01a87a'>");
							salida.println("<td id = 'col_au1' class = 'col_tabla_autores'>" + miResultset.getString("Nombre_Autor") + "</td>");
							salida.println("<td id = 'col_au2' class = 'col_tabla_autores'>" + miResultset.getString("Apellido_Paterno_Autor") + "</td>");
							salida.println("<td id = 'col_au3' class = 'col_tabla_autores'>" + miResultset.getString("Apellido_Materno_Autor") + "</td>");
							salida.println("<td id = 'col_au4' class = 'col_tabla_autores'>" + miResultset.getString("Nacionalidad") + "</td>");
							salida.println("<td id = 'col_au5' class = 'col_tabla_autores'></td>");
		                    salida.println("<td id = 'col_au6' class = 'col_tabla_autores'></td>");
							salida.println("</tr>");
						}		
						else{
							salida.println("<tr>");
							salida.println("<td id = 'col_au1' class = 'col_tabla_autores'>" + miResultset.getString("Nombre_Autor") + "</td>");
							salida.println("<td id = 'col_au2' class = 'col_tabla_autores'>" + miResultset.getString("Apellido_Paterno_Autor") + "</td>");
							salida.println("<td id = 'col_au3' class = 'col_tabla_autores'>" + miResultset.getString("Apellido_Materno_Autor") + "</td>");
							salida.println("<td id = 'col_au4' class = 'col_tabla_autores'>" + miResultset.getString("Nacionalidad") + "</td>");
							salida.println("<td id = 'col_au5' class = 'col_tabla_autores'></td>");
		                    salida.println("<td id = 'col_au6' class = 'col_tabla_autores'></td>");
							salida.println("</tr>");						
						}
						impares += 1;
					}
					salida.println("</table>");
					
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}		
			}
		}
		//***********************************************************************
		else if(sub_clasificacion != null) {

			try {
				Conexion c            =new Conexion();
				Connection miConexion =c.getCon();
				Statement miStatement =miConexion.createStatement();
				ResultSet miResultset = miStatement.executeQuery("select * from Clasificacion");

				while(miResultset.next()) {
					if (sub_clasificacion.equals(miResultset.getString("Nombre_Clasificacion"))) {
						int id_clasificacion = miResultset.getInt("ID_Clasificacion");
						
						Statement miStatement2 =miConexion.createStatement();
						ResultSet miResultset2 = miStatement2.executeQuery("select * from Subclasificacion order by Nombre_Subclasificacion asc");
						response.setContentType("text/html");
						response.setCharacterEncoding("UFT-8");
						PrintWriter salida = response.getWriter();
						salida.println("Sublasificacion: <select id=\"sel_subclasif\">");
						while(miResultset2.next()) {
							if (miResultset2.getInt("ID_Subclasificacion") > id_clasificacion 
									&& miResultset2.getInt("ID_Subclasificacion") < (id_clasificacion+10))
							{
								String sub_aux = miResultset2.getString("Nombre_Subclasificacion");
								if (!sub_aux.equals("")) {
									salida.println("<option>" + miResultset2.getString("Nombre_Subclasificacion") + "</option>");	
								}
							}
						}
						salida.println("</select>");
					}
				}

				miStatement.close();
				miResultset.close();
				c.cerrarConexion();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
	}
}
