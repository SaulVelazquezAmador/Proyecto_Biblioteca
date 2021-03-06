package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Usuario;

@WebServlet("/Inicio_Registro")
public class Inicio_Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Inicio_Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		boolean existe = false;
		String correo_inicio      =request.getParameter("correo_ini");
		String clave_inicio       =request.getParameter("clave_ini");
		String nombre_registro    =request.getParameter("nombre");
		String apellidos_registro =request.getParameter("apellido");
		
		String correo_registro    =request.getParameter("correo");
		String password_registro  =request.getParameter("clave");
		
		//**************************************************************
		if(nombre_registro != null && apellidos_registro != null
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
			
			int gm = correo_registro.indexOf("@gmail.com");
			int hm = correo_registro.indexOf("@hotmail.com");
			int ol = correo_registro.indexOf("@outlook.com");
			
			//Si el usuario ya existe, entonces ya no se hace nada
			if(existe == true) 
			{
				PrintWriter salida = response.getWriter();
				salida.println(2);
			} 
			else if (gm == -1 && hm == -1 && ol == -1) {
				PrintWriter salida = response.getWriter();
				salida.println(3);
			}
			//si no hay que darlo de alta y mandar a la pagina principal
			else 
			{
				user.registrar_usuario(nombre_registro, apellido_paterno, apellido_materno, correo_registro, password_registro);
				PrintWriter salida = response.getWriter();
				salida.println(1);		
			}
		}
		else if (correo_inicio != null && clave_inicio != null) 
		{

			Usuario user_inicio = new Usuario(correo_inicio, clave_inicio);
			existe = user_inicio.consultar_para_inicio(correo_inicio, clave_inicio);

			if(existe == true) 
			{ 
				PrintWriter salida = response.getWriter();
				salida.println(2);
//				RequestDispatcher rd;
//				rd = request.getRequestDispatcher("/principal.jsp");
//				rd.forward(request, response);
			}
			else 
			{
				PrintWriter salida = response.getWriter();
				salida.println(1);
			}
		}
	}

}
