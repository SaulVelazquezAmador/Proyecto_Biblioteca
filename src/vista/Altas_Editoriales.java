package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Biblioteca;

@WebServlet("/Altas_Editoriales")
public class Altas_Editoriales extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Altas_Editoriales() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("e");
		boolean existe = false;
		String nombre_editorial   = request.getParameter("n_editorial");
		String ciudad_editorial   = request.getParameter("n_ciudad");
		//***********************************************************************
		if (nombre_editorial != null && ciudad_editorial != null) {

			Control_Biblioteca control_editorial = new Control_Biblioteca();
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
	}

}
