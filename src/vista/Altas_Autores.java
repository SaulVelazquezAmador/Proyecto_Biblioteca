package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Biblioteca;

@WebServlet("/Altas_Autores")
public class Altas_Autores extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Altas_Autores() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		boolean existe = false;
		String apellido_paterno = "";
		String apellido_materno = "";
		String nombre_a           = request.getParameter("nombre_autor");
		String apellidos_a        = request.getParameter("apellido_autor");
		String nacionalidad_a     = request.getParameter("nacionalidad_autor");
		//*************************************************************************
		if (nombre_a != null && apellidos_a != null && nacionalidad_a != null) {
			int espacio = 0;
			espacio = apellidos_a.indexOf(" ");
			
			if(espacio != -1) {
				String[] apellidos = apellidos_a.split(" ");
				apellido_paterno = apellidos[0];
				apellido_materno = apellidos[1];	
			}
			else {
				apellido_paterno = apellidos_a;
				apellido_materno = "";
			}
			Control_Biblioteca control_autor = new Control_Biblioteca();
			existe = control_autor.consultar_autores(nombre_a, apellido_paterno, apellido_materno, nacionalidad_a);
		
			if (existe == true) {
				PrintWriter salida = response.getWriter();
				salida.println(1);
			}
			else {
				control_autor.agregar_autor(nombre_a, apellido_paterno, apellido_materno, nacionalidad_a);
				PrintWriter salida = response.getWriter();
				salida.println(2);
			}
		}
	}

}
