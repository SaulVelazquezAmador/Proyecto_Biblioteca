package vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		String correo_inicio      =request.getParameter("correo_ini");
		String clave_inicio       =request.getParameter("clave_ini");
		String nombre_registro    =request.getParameter("nombre");
		String apellidos_registro =request.getParameter("apellido");
		String correo_registro    =request.getParameter("correo");
		String password_registro  =request.getParameter("clave");
		String tipo_peticion      =request.getParameter("tipo_muestra");
		String sub_clasificacion  =request.getParameter("sub_clas");
		
		
		System.out.println("llego a serv");
		if (correo_inicio != null && clave_inicio != null) 
		{
			System.out.println("llego a serv22");
			Usuario user_inicio = new Usuario(correo_inicio, clave_inicio);
			existe = user_inicio.consultar_para_inicio(correo_inicio, clave_inicio);
			
			if(existe == true) 
			{ 
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("/principal.jsp");
				rd.forward(request, response);
			}
			else 
			{
				PrintWriter salida = response.getWriter();
				salida.println(1);
			}
		}
		//**************************************************************
		else if(nombre_registro != null && apellidos_registro != null
				&& correo_registro != null && password_registro != null)
		{	
			//separo los apellidos en caso de ser un registro nuevo
			String[] apellidos      = apellidos_registro.split(" ");
			String apellido_paterno = apellidos[0];
			String apellido_materno = apellidos[1];
			
			//creamos objeto de tipo Usuario
			//primero verificamos si el introducido existe
			Usuario user = new Usuario(nombre_registro, apellido_paterno, apellido_materno, correo_registro, password_registro);
			existe = user.consultar_para_registro(nombre_registro,  apellido_paterno, apellido_materno, correo_registro, password_registro);
			
			//Si el usuario ya existe, entonces ya no se hace nada
			if(existe == true) 
			{
				PrintWriter salida = response.getWriter();
				salida.println(2);
			} 
			//si no hay que darlo de alta y mandar a la pagina principal
			else 
			{
				user.registrar_usuario(nombre_registro, apellido_paterno, apellido_materno, correo_registro, password_registro);
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("/principal.jsp");
				rd.forward(request, response);		
			}
		}
		//*********************************************************************
		else if (tipo_peticion != null) {
			int peticion = Integer.parseInt(tipo_peticion);
			System.out.println("entro en if");
			if(peticion == 3)
			{
				try {
					Conexion c            =new Conexion();
					Connection miConexion =c.getCon();
					Statement miStatement =miConexion.createStatement();
					ResultSet miResultset = miStatement.executeQuery("select * from Clasificacion");
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
			System.out.println("sahhhle");
		}
		//***********************************************************************
		
		else if(sub_clasificacion != null) {
			System.out.println("aaa");
			try {
				Conexion c            =new Conexion();
				Connection miConexion =c.getCon();
				Statement miStatement =miConexion.createStatement();
				ResultSet miResultset = miStatement.executeQuery("select * from Clasificacion");

				while(miResultset.next()) {
					if (sub_clasificacion.equals(miResultset.getString("Nombre_Clasificacion"))) {
						int id_clasificacion = miResultset.getInt("ID_Clasificacion");
						
						Statement miStatement2 =miConexion.createStatement();
						ResultSet miResultset2 = miStatement2.executeQuery("select * from Subclasificacion");
						response.setContentType("text/html");
						response.setCharacterEncoding("UFT-8");
						PrintWriter salida = response.getWriter();
						salida.println("Sublasificacion: <select>");
						while(miResultset2.next()) {
							if (miResultset2.getInt("ID_Subclasificacion") > id_clasificacion 
									&& miResultset2.getInt("ID_Subclasificacion") < (id_clasificacion+10)){
								salida.println("<option>" + miResultset2.getString("Nombre_Subclasificacion") + "</option>");
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
