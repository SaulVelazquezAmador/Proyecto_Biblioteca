package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Editoriales;

@WebServlet("/Servlet_Editoriales")
public class Servlet_Editoriales extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet_Editoriales() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		boolean existe = false;
		String resultado = "";
		String tipo_peticion = request.getParameter("peticion");
		String nombre_editorial   = request.getParameter("n_editorial");
		String ciudad_editorial   = request.getParameter("n_ciudad");
		//***********************************************************************
		if (tipo_peticion != null) {
			int peticion = Integer.parseInt(tipo_peticion);
			// Si la peticion es = 1 entonces es una alta
			if(peticion == 1) {

				Control_Editoriales control_editorial = new Control_Editoriales();
				existe = control_editorial.consultar_editoriales(nombre_editorial, ciudad_editorial);

				if (existe == true) {
					PrintWriter salida = response.getWriter();
					salida.println(1);
				}
				else{
					control_editorial.agregar_editorial(nombre_editorial, ciudad_editorial);
					PrintWriter salida = response.getWriter();
					salida.println(2);
				}				
			}
			// Si la peticion es = 2 entonces es una baja
			if (peticion == 2) {
				Control_Editoriales baja = new Control_Editoriales();
				resultado = baja.baja_editorial(nombre_editorial);
				
				if (resultado.equals("tiene libros")) {
					PrintWriter salida = response.getWriter();
					salida.println(1);
				}
				if (resultado.equals("exito")) {
					PrintWriter salida = response.getWriter();
					salida.println(2);
				}
			}
		}
	}
}

