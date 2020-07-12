package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Autores;

@WebServlet("/Servlet_Autores")
public class Servlet_Autores extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet_Autores() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		boolean existe            = false;
		String resultado          = "";
		String nombre_autor       = "";
		String apellido_paterno   = "";
		String apellido_materno   = "";
		String id_autor           = request.getParameter("id");
		String nombre_completo_a  = request.getParameter("n_autor");
		String tipo_peticion      = request.getParameter("peticion");
		String nombre_a           = request.getParameter("nombre_autor");
		String apellidos_a        = request.getParameter("apellido_autor");
		String nacionalidad_a     = request.getParameter("nacionalidad_autor");
		//*************************************************************************
		if (tipo_peticion != null) {
			int peticion = Integer.parseInt(tipo_peticion);
			
			// Si la peticion es = 1 entonces es una alta
			
			if(peticion == 1) {
				int espacio = 0;
				//regresa -1 si lo encuentra
				espacio = apellidos_a.indexOf(" ");
				
				if(espacio != -1) {
					System.out.println("tiene espacio");
					String[] apellidos = apellidos_a.split(" ");
					apellido_paterno = apellidos[0];
					apellido_materno = apellidos[1];	
				}
				else {
					System.out.println("else");
					apellido_paterno = apellidos_a;
					apellido_materno = "";
				}
				Control_Autores control_autor = new Control_Autores();
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
			if(peticion == 2) {
			
				int tamaño = 0;
				
				String[] nombre_completo = nombre_completo_a.split(" ");
				tamaño = nombre_completo.length;
				
				if(tamaño == 2) {
					nombre_autor     = nombre_completo[0];		
					apellido_paterno = nombre_completo[1];
					apellido_materno = "";
				}

				if (tamaño == 3) {
					nombre_autor     = nombre_completo[0];		
					apellido_paterno = nombre_completo[1];
					apellido_materno = nombre_completo[2];	
				}
				if(tamaño == 4) {
					nombre_autor     = nombre_completo[0];
					nombre_autor     += " ";
					nombre_autor     += nombre_completo[1];
					apellido_paterno = nombre_completo[2];
					apellido_materno = nombre_completo[3];			
				}
				
				Control_Autores baja = new Control_Autores();
				resultado = baja.baja_autor(nombre_autor, apellido_paterno, apellido_materno);
				if (resultado.equals("tiene libros")) {
					PrintWriter salida = response.getWriter();
					salida.println(1);
				}
				if (resultado.equals("exito")) {
					PrintWriter salida = response.getWriter();
					salida.println(2);
				}				
			}
			if (peticion == 3) {
				
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
				
				int ID_Aut = Integer.parseInt(id_autor);
				Control_Autores editar = new Control_Autores();
				editar.edita_autor(ID_Aut, nombre_a, apellido_paterno, apellido_materno, nacionalidad_a);
			}
		}
	}

}

