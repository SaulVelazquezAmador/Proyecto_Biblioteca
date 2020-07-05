package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import controlador.Control_Biblioteca;
//import controlador.Usuario;
import modelo.Conexion;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controlador.Usuario;

@WebServlet("/Servlet_Biblioteca")
public class Servlet_Biblioteca extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    public Servlet_Biblioteca() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("test");
		System.out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
				
		String[] datos_usuario = new String[5];
		String tipo_peticion      = request.getParameter("tipo_muestra");		
		String sub_clasificacion  = request.getParameter("sub_clas");
		String correo             = request.getParameter("Correo");
		String clave              = request.getParameter("Clave");
		System.out.println("Servlet_Biblioteca");
		//************************* Actualizaciones dinamicas de paginas*****************
		if (tipo_peticion != null) {

			int peticion = Integer.parseInt(tipo_peticion);
			if (peticion == 0) {
				//*********** rescatar datos de usuario ******************************
				Usuario user = new Usuario(correo, clave);
				datos_usuario = user.buscar_usuario(correo, clave);
				
				Gson gson = new Gson();
				String usrJson = gson.toJson(datos_usuario);
				
				PrintWriter salida0 = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UFT-8");
				salida0.write(usrJson);
				salida0.close();
			}
			if (peticion == 20) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Lector order by Nombre asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Cliente: <select id=\"sel_nombre\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre") + " " + miResultset.getString("Apellido_Paterno") + " " + miResultset.getString("Apellido_Materno") + "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (peticion == 21) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Libro order by Titulo asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Libro: <select id=\"sel_libro\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Titulo") + "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (peticion == 22) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Tipo_prestamo order by Tipo asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");

					PrintWriter salida = response.getWriter();
					salida.println("Tipo de prestamo: <select id=\"sel_tipo\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Tipo") + "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
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
			
			if (peticion == 4) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Lector order by Nombre asc");

					response.setContentType("text/html");
					response.setCharacterEncoding("UFT-8");
					int impares = 0;
					PrintWriter salida = response.getWriter();
					salida.println("<table id='tabla_clientes'>");
					salida.println("<tr bgcolor='#01a87a'>");
					salida.println("<td id = 'col_cli1' class = 'col_tabla_clientes'><label>Nombre            </label></td>");
                    salida.println("<td id = 'col_cli2' class = 'col_tabla_clientes'><label>Apellido paterno  </label></td>");
                    salida.println("<td id = 'col_cli3' class = 'col_tabla_clientes'><label>Apellido materno  </label></td>");
                    salida.println("<td id = 'col_cli4' class = 'col_tabla_clientes'><label>Correo Electronico</label></td>");
					salida.println("<td id = 'col_cli5' class = 'col_tabla_clientes'><label>Telefono          </label></td>");
                    salida.println("</tr>");
					while(miResultset.next()) {
						if (impares % 2 != 0) {
							salida.println("<tr bgcolor='#01a87a'>");
							salida.println("<td id = 'col_cli1' class = 'col_tabla_clientes'>" + miResultset.getString("Nombre") + "</td>");
							salida.println("<td id = 'col_cli2' class = 'col_tabla_clientes'>" + miResultset.getString("Apellido_Paterno") + "</td>");
							salida.println("<td id = 'col_cli3' class = 'col_tabla_clientes'>" + miResultset.getString("Apellido_Materno") + "</td>");
							salida.println("<td id = 'col_cli4' class = 'col_tabla_clientes'>" + miResultset.getString("Correo_Electronico") + "</td>");
							salida.println("<td id = 'col_cli5' class = 'col_tabla_clientes'>" + miResultset.getString("Telefono") + "</td>");
							salida.println("</tr>");
						}		
						else{
							salida.println("<tr>");
							salida.println("<td id = 'col_cli1' class = 'col_tabla_clientes'>" + miResultset.getString("Nombre") + "</td>");
							salida.println("<td id = 'col_cli2' class = 'col_tabla_clientes'>" + miResultset.getString("Apellido_Paterno") + "</td>");
							salida.println("<td id = 'col_cli3' class = 'col_tabla_clientes'>" + miResultset.getString("Apellido_Materno") + "</td>");
							salida.println("<td id = 'col_cli4' class = 'col_tabla_clientes'>" + miResultset.getString("Correo_Electronico") + "</td>");
							salida.println("<td id = 'col_cli5' class = 'col_tabla_clientes'>" + miResultset.getString("Telefono") + "</td>");
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
