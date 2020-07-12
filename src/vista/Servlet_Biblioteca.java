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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
				
		String[] datos_usuario = new String[5];
		String tipo_peticion      = request.getParameter("tipo_muestra");
		String autor_completo     = request.getParameter("autor_edicion");
		String sub_clasificacion  = request.getParameter("sub_clas");
		String correo             = request.getParameter("Correo");
		String clave              = request.getParameter("Clave");
		String nom_completo       = request.getParameter("n_completo");
		String nom_editorial      = request.getParameter("editorial_edicion");
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

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Cliente: <select id=\"prest_nombre\">");
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

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Libro: <select id=\"prest_libro\">");
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

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Tipo de prestamo: <select id=\"prest_tipo\">");
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

			if (peticion == 23) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select Prestamos.Fecha_Entrega, Prestamos.Fecha_Devolucion, Libro.Titulo, Lector.Nombre, Lector.Apellido_Paterno, Lector.Apellido_Materno"
							+ "											from Prestamos inner join Libro"
							+ "											on Prestamos.R_LIbro = Libro.ISBN"
							+ "											inner join Lector"
							+ "											on Prestamos.R_Lector = Lector.ID_Lector"
							+ "                                         ORDER BY Lector.Nombre");

					response.setContentType("text/html;charset=UTF-8");
					int impares = 0;
					PrintWriter salida = response.getWriter();
					salida.println("<table id='tabla_prestamos'>");
					salida.println("<tr bgcolor='#01a87a'>");
					salida.println("<td id = 'p1' class = 'col_tabla_prestamos'><label>Libro    </label></td>");
					salida.println("<td id = 'p2' class = 'col_tabla_prestamos'><label>Cliente  </label></td>");
					salida.println("<td id = 'p3' class = 'col_tabla_prestamos'><label>Inicio   </label></td>");
					salida.println("<td id = 'p4' class = 'col_tabla_prestamos'><label>Fin      </label></td>");
					salida.println("<td id = 'p5' class = 'col_tabla_prestamos'><label>Terminar </label></td>");
					salida.println("<td id = 'p6' class = 'col_tabla_prestamos'><label>         </label></td>");
					salida.println("</tr>");
					while(miResultset.next()) {
						if (impares % 2 != 0) {
							salida.println("<tr bgcolor='#01a87a' id='fila_tabla_prestamos'>");
							salida.println("<td id = 'p1' class = 'col_tabla_prestamos'>" + miResultset.getString("Titulo") + "</td>");
							salida.println("<td id = 'p2' class = 'col_tabla_prestamos'>" + miResultset.getString("Nombre") + " " + miResultset.getString("Apellido_Paterno") + " " + miResultset.getString("Apellido_Materno") + "</td>");
							salida.println("<td id = 'p3' class = 'col_tabla_prestamos'>" + miResultset.getString("Fecha_Entrega") + "</td>");
							salida.println("<td id = 'p4' class = 'col_tabla_prestamos'>" + miResultset.getString("Fecha_Devolucion") + "</td>");
							salida.println("<td id = 'p5' class = 'col_tabla_prestamos'> </td>");
							salida.println("<td id = 'p6' class = 'col_tabla_prestamos'> </td>");
							salida.println("</tr>");
						}		
						else{
							salida.println("<tr id='fila_tabla_prestamos'>");
							salida.println("<td id = 'p1' class = 'col_tabla_prestamos'>" + miResultset.getString("Titulo") + "</td>");
							salida.println("<td id = 'p2' class = 'col_tabla_prestamos'>" + miResultset.getString("Nombre")+" "+miResultset.getString("Apellido_Paterno")+" "+miResultset.getString("Apellido_Materno") + "</td>");
							salida.println("<td id = 'p3' class = 'col_tabla_prestamos'>" + miResultset.getString("Fecha_Entrega") + "</td>");
							salida.println("<td id = 'p4' class = 'col_tabla_prestamos'>" + miResultset.getString("Fecha_Devolucion") + "</td>");
							salida.println("<td id = 'p5' class = 'col_tabla_prestamos'> </td>");
							salida.println("<td id = 'p6' class = 'col_tabla_prestamos'> </td>");
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
			
			if (peticion == 24) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Lector order by Nombre asc");

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Cliente: <select id=\"cliente_baja_prestamo\">");
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
			
			if (peticion == 25) {
				//variables para el nombre
				String nombre_cliente = "";
				String apellido_paterno = "";
				String apellido_materno = "";
				int tamaño = 0, id_lector = 0;
				
				String[] nombre_completo = nom_completo.split(" ");
				tamaño = nombre_completo.length;
				//si tiene un nombre
				if (tamaño == 3) {
					nombre_cliente   = nombre_completo[0];		
					apellido_paterno = nombre_completo[1];
					apellido_materno = nombre_completo[2];
				}
				//si tiene dos nombres
				if(tamaño == 4) {
					nombre_cliente   = nombre_completo[0];
					nombre_cliente   += " ";
					nombre_cliente   += nombre_completo[1];
					apellido_paterno = nombre_completo[2];
					apellido_materno = nombre_completo[3];			
				}
				//buscamos el id del lector
				try {
					Conexion c=new Conexion();
					Connection miConexion=c.getCon();

					Statement miStatement=miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Lector");
					
					while(miResultset.next()) {
						if (nombre_cliente.equals(miResultset.getString("Nombre"))
								&& apellido_paterno.equals(miResultset.getString("Apellido_Paterno"))
								&& apellido_materno.equals(miResultset.getString("Apellido_Materno")))
						{
							id_lector = miResultset.getInt("ID_Lector");
						}
					}
					miStatement.close();
					miResultset.close();			
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//buscamos los prestamos de ese lector
				try {
					Conexion c=new Conexion();
					Connection miConexion=c.getCon();
					
					Statement miStatement=miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select Libro.Titulo, Prestamos.R_Lector"
							+ "											from Prestamos inner join Libro"
							+ "											on Prestamos.R_LIbro = Libro.ISBN"
							+ "											ORDER BY Libro.Titulo");
					
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter salida = response.getWriter();
					salida.println("Libros prestados: <select id=\"libro_baja_prestamo\">");	
					
					while(miResultset.next()) {
						if(id_lector == miResultset.getInt("R_Lector")) 
							salida.println("<option>" + miResultset.getString("Libro.Titulo") + "</option>");
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
					response.setContentType("text/html;charset=UTF-8");
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

					response.setContentType("text/html;charset=UTF-8");

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

					response.setContentType("text/html;charset=UTF-8");

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

					response.setContentType("text/html;charset=UTF-8");

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

					response.setContentType("text/html;charset=UTF-8");

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

					response.setContentType("text/html;charset=UTF-8");

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

					response.setContentType("text/html;charset=UTF-8");

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

					response.setContentType("text/html;charset=UTF-8");

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
			if (peticion == 307) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Libro order by Titulo asc");

					response.setContentType("text/html;charset=UTF-8");

					int impares = 0;
					PrintWriter salida = response.getWriter();
					salida.println("<table id='tabla_libros'>");
					salida.println("<tr bgcolor='#01a87a'>");
					salida.println("<td id = 'cl1' class = 'col_tabla_libros'><label>ISBN  		</label></td>");
                    salida.println("<td id = 'cl2' class = 'col_tabla_libros'><label>Titulo 		</label></td>");
                    salida.println("<td id = 'cl3' class = 'col_tabla_libros'><label>Año  		</label></td>");
                    salida.println("<td id = 'cl4' class = 'col_tabla_libros'><label>Ejemplares 	</label></td>");
                    salida.println("</tr>");
					while(miResultset.next()) {
						if (impares % 2 != 0) {
							salida.println("<tr bgcolor='#01a87a'>");
							salida.println("<td id = 'cl1' class = 'col_tabla_libros'>" + miResultset.getString("ISBN") 	+   "</td>");
							salida.println("<td id = 'cl2' class = 'col_tabla_libros'>" + miResultset.getString("Titulo") 	+ 	"</td>");
							salida.println("<td id = 'cl3' class = 'col_tabla_libros'>" + miResultset.getInt("Año") 		+ 	"</td>");
							salida.println("<td id = 'cl4' class = 'col_tabla_libros'>" + miResultset.getInt("Ejemplares") + "</td>");
							salida.println("</tr>");
						}		
						else{
							salida.println("<tr>");
							salida.println("<td id = 'cl1' class = 'col_tabla_libros'>" + miResultset.getString("ISBN") 	+ 	"</td>");
							salida.println("<td id = 'cl2' class = 'col_tabla_libros'>" + miResultset.getString("Titulo") 	+ 	"</td>");
							salida.println("<td id = 'cl3' class = 'col_tabla_libros'>" + miResultset.getInt("Año") 		+ 	"</td>");
							salida.println("<td id = 'cl4' class = 'col_tabla_libros'>" + miResultset.getInt("Ejemplares") + "</td>");
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
			if (peticion == 308) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Libro order by Titulo asc");

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Libro: <select id=\"titulo_baja_libro\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Titulo")+ "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
//****************************************************************************			
			if (peticion == 4) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Lector order by Nombre asc");

					response.setContentType("text/html;charset=UTF-8");

					int impares = 0;
					PrintWriter salida = response.getWriter();
					salida.println("<table id='tabla_clientes'>");
					salida.println("<tr bgcolor='#01a87a'>");
					salida.println("<td id = 'col_cli1' class = 'col_tabla_clientes'><label>Nombre            </label></td>");
                    salida.println("<td id = 'col_cli2' class = 'col_tabla_clientes'><label>Apellido paterno  </label></td>");
                    salida.println("<td id = 'col_cli3' class = 'col_tabla_clientes'><label>Apellido materno  </label></td>");
                    salida.println("<td id = 'col_cli4' class = 'col_tabla_clientes'><label>Correo Electronico</label></td>");
					salida.println("<td id = 'col_cli5' class = 'col_tabla_clientes'><label>Prestamos          </label></td>");
                    salida.println("</tr>");
					while(miResultset.next()) {
						if (impares % 2 != 0) {
							salida.println("<tr bgcolor='#01a87a'>");
							salida.println("<td id = 'col_cli1' class = 'col_tabla_clientes'>" + miResultset.getString("Nombre") + "</td>");
							salida.println("<td id = 'col_cli2' class = 'col_tabla_clientes'>" + miResultset.getString("Apellido_Paterno") + "</td>");
							salida.println("<td id = 'col_cli3' class = 'col_tabla_clientes'>" + miResultset.getString("Apellido_Materno") + "</td>");
							salida.println("<td id = 'col_cli4' class = 'col_tabla_clientes'>" + miResultset.getString("Correo_Electronico") + "</td>");
							salida.println("<td id = 'col_cli5' class = 'col_tabla_clientes'>" + miResultset.getInt("Prestamos_Activos") + "</td>");
							salida.println("</tr>");
						}		
						else{
							salida.println("<tr bgcolor = '#B4AAA8'>");
							salida.println("<td id = 'col_cli1' class = 'col_tabla_clientes'>" + miResultset.getString("Nombre") + "</td>");
							salida.println("<td id = 'col_cli2' class = 'col_tabla_clientes'>" + miResultset.getString("Apellido_Paterno") + "</td>");
							salida.println("<td id = 'col_cli3' class = 'col_tabla_clientes'>" + miResultset.getString("Apellido_Materno") + "</td>");
							salida.println("<td id = 'col_cli4' class = 'col_tabla_clientes'>" + miResultset.getString("Correo_Electronico") + "</td>");
							salida.println("<td id = 'col_cli5' class = 'col_tabla_clientes'>" + miResultset.getInt("Prestamos_Activos") + "</td>");
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
			 
			if (peticion == 41) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Lector order by Nombre asc");

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Cliente: <select id=\"sel_baja_cliente\">");
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
//**************************************************************************************************
			if (peticion == 6) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Editorial order by Nombre_Editorial asc");

					response.setContentType("text/html;charset=UTF-8");
					int imparese = 0;
					PrintWriter salida = response.getWriter();
					salida.println("<table id='tabla_editoriales'>");
					salida.println("<tr bgcolor='#01a87a'>");
					salida.println("<td id = 'cole1' class = 'col_tabla_editoriales'><label>Nombre    </label></td>");
                    salida.println("<td id = 'cole2' class = 'col_tabla_editoriales'><label>Ciudad    </label></td>");
                    salida.println("</tr>");
					while(miResultset.next()) {
						if (imparese % 2 !=0) {
							salida.println("<tr bgcolor='#01a87a'>");
							salida.println("<td id = 'cole1' class = 'col_tabla_editoriales'>" + miResultset.getString("Nombre_Editorial") + "</td>");
							salida.println("<td id = 'cole2' class = 'col_tabla_editoriales'>" + miResultset.getString("Ciudad") + "</td>");
							salida.println("</tr>");							
						}
						else {
							salida.println("<tr>");
							salida.println("<td id = 'cole1' class = 'col_tabla_editoriales'>" + miResultset.getString("Nombre_Editorial") + "</td>");
							salida.println("<td id = 'cole2' class = 'col_tabla_editoriales'>" + miResultset.getString("Ciudad") + "</td>");
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
			if (peticion == 61) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Editorial order by Nombre_Editorial asc");

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Editorial: <select id=\"nombre_baja_editorial\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Editorial")+ "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 62) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Editorial order by Nombre_Editorial asc");

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Editorial: <select id=\"nombre_edicion_editorial\">");
					salida.println("<option>" + "---------------------" + "</option>");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Editorial")+ "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 63) {
				
				String[] datos_editorial = new String[3];
				
				datos_editorial[0] = nom_editorial;
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Editorial order by Nombre_Editorial asc");

					response.setContentType("application/json");

					while(miResultset.next()) {
						if(nom_editorial.equals(miResultset.getString("Nombre_Editorial"))){
								datos_editorial[1] = miResultset.getString("Ciudad");
								datos_editorial[2] = miResultset.getString("ID_Editorial");
						}
					}

					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				Gson gson = new Gson();
				String autorJson = gson.toJson(datos_editorial);
				
				PrintWriter salida = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UFT-8");
				salida.write(autorJson);
				salida.close();	
			}
//*************************************************************************************************
			if (peticion == 7) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("text/html;charset=UTF-8");
					int impares = 0;
					PrintWriter salida = response.getWriter();
					salida.println("<table id='tabla_autores'>");
					salida.println("<tr bgcolor='#01a87a'>");
					salida.println("<td id = 'col_au1' class = 'col_tabla_autores'><label>Nombre            </label></td>");
                    salida.println("<td id = 'col_au2' class = 'col_tabla_autores'><label>Apellido paterno  </label></td>");
                    salida.println("<td id = 'col_au3' class = 'col_tabla_autores'><label>Apellido materno  </label></td>");
                    salida.println("<td id = 'col_au4' class = 'col_tabla_autores'><label>Nacionalidad      </label></td>");
                    salida.println("</tr>");
					while(miResultset.next()) {
						if (impares % 2 != 0) {
							salida.println("<tr bgcolor='#01a87a'>");
							salida.println("<td id = 'col_au1' class = 'col_tabla_autores'>" + miResultset.getString("Nombre_Autor") + "</td>");
							salida.println("<td id = 'col_au2' class = 'col_tabla_autores'>" + miResultset.getString("Apellido_Paterno_Autor") + "</td>");
							salida.println("<td id = 'col_au3' class = 'col_tabla_autores'>" + miResultset.getString("Apellido_Materno_Autor") + "</td>");
							salida.println("<td id = 'col_au4' class = 'col_tabla_autores'>" + miResultset.getString("Nacionalidad") + "</td>");
							salida.println("</tr>");
						}		
						else{
							salida.println("<tr>");
							salida.println("<td id = 'col_au1' class = 'col_tabla_autores'>" + miResultset.getString("Nombre_Autor") + "</td>");
							salida.println("<td id = 'col_au2' class = 'col_tabla_autores'>" + miResultset.getString("Apellido_Paterno_Autor") + "</td>");
							salida.println("<td id = 'col_au3' class = 'col_tabla_autores'>" + miResultset.getString("Apellido_Materno_Autor") + "</td>");
							salida.println("<td id = 'col_au4' class = 'col_tabla_autores'>" + miResultset.getString("Nacionalidad") + "</td>");
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
			if (peticion == 71) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Autor: <select id=\"nombre_baja_autor\">");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Autor") + " " + miResultset.getString("Apellido_Paterno_Autor") + " " + miResultset.getString("Apellido_Materno_Autor") + "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 72) {
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("text/html;charset=UTF-8");

					PrintWriter salida = response.getWriter();
					salida.println("Autor: <select id=\"nombre_edicion_autor\">");
					salida.println("<option>" + "---------------------" + "</option>");
					while(miResultset.next()) {
						salida.println("<option>" + miResultset.getString("Nombre_Autor") + " " + miResultset.getString("Apellido_Paterno_Autor") + " " + miResultset.getString("Apellido_Materno_Autor") + "</option>");
					}
					salida.println("</select>");
					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (peticion == 73) {
				
				String[] informacion_autor = new String[4];
				String nombre_autor = "";
				String apellido_paterno = "";
				String apellido_materno = "";
				int tamaño = 0;
				
				String[] datos_autor_edicion = autor_completo.split(" ");
				tamaño = datos_autor_edicion.length;
				
				if(tamaño == 2) {
					nombre_autor     = datos_autor_edicion[0];		
					apellido_paterno = datos_autor_edicion[1];
					apellido_materno = "";
				}

				if (tamaño == 3) {
					nombre_autor     = datos_autor_edicion[0];		
					apellido_paterno = datos_autor_edicion[1];
					apellido_materno = datos_autor_edicion[2];	
				}
				if(tamaño == 4) {
					nombre_autor     = datos_autor_edicion[0];
					nombre_autor     += " ";
					nombre_autor     += datos_autor_edicion[1];
					apellido_paterno = datos_autor_edicion[2];
					apellido_materno = datos_autor_edicion[3];	
				}
				
				informacion_autor[0] = nombre_autor;
				informacion_autor[1] = apellido_paterno + " " + apellido_materno;
				
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Autor order by Nombre_Autor asc");

					response.setContentType("application/json");

					while(miResultset.next()) {
						if(nombre_autor.equals(miResultset.getString("Nombre_Autor")) && 
								apellido_paterno.equals(miResultset.getString("Apellido_Paterno_Autor")) &&
								apellido_materno.equals(miResultset.getString("Apellido_Materno_Autor"))){
								informacion_autor[2] = miResultset.getString("Nacionalidad");
								informacion_autor[3] = miResultset.getString("ID_Autor");
						}
					}

					miStatement.close();
					miResultset.close();
					c.cerrarConexion();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				Gson gson = new Gson();
				String autorJson = gson.toJson(informacion_autor);
				
				PrintWriter salida = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UFT-8");
				salida.write(autorJson);
				salida.close();				
				
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
						response.setContentType("text/html;charset=UTF-8");
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
