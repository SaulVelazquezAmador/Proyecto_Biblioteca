package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Libros;

@WebServlet("/Servlet_Libros")
public class Servlet_Libros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_Libros() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);

		boolean existe = false;
		String aut1 = "";
		String aut2 = "";
		String aut3 = "";
		String aut4 = "";
		String aut5 = "";
		String resultado = "";
		String tipo_peticion    = request.getParameter("peticion");
		String autor1           = request.getParameter("Autor1");
		String autor2           = request.getParameter("Autor2");
		String autor3           = request.getParameter("Autor3");
		String autor4           = request.getParameter("Autor4");
		String autor5           = request.getParameter("Autor5");
		String isbn             = request.getParameter("ISBN");
		String titulo           = request.getParameter("Titulo");
		String editorial        = request.getParameter("Editorial");
		String clasificacion    = request.getParameter("Clasificacion");
		String subclasificacion = request.getParameter("Subclasificacion");
		String numero_autores   = request.getParameter("NAutor");
		String año              = request.getParameter("Year");
		String ejemplares       = request.getParameter("Ejemplares");
		String ubicacion        = request.getParameter("Ubicacion");
		System.out.println(tipo_peticion);
		if (tipo_peticion != null) {
			int peticion = Integer.parseInt(tipo_peticion);
			// Si la peticion es = 1 entonces es una alta
			if(peticion == 1) {
				
				int n_autores    = Integer.parseInt(numero_autores);
				int year         = Integer.parseInt(año);
				int n_ejemplares = Integer.parseInt(ejemplares);
				
		    	//sacamos el nombre del autor
				String[] vautor      = autor1.split(" ");
				aut1 = vautor[0];

				if (autor2 != "NA") {
					String[] vautor2      = autor2.split(" ");
					aut2 = vautor2[0];			
				}

				if (autor3 != "NA") {
					String[] vautor3      = autor3.split(" ");
					aut3 = vautor3[0];			
				}

				if (autor4 != "NA") {
					String[] vautor4      = autor4.split(" ");
					aut4 = vautor4[0];			
				}

				if (autor5 != "NA") {
					String[] vautor5      = autor5.split(" ");
					aut5 = vautor5[0];			
				}

		    	Control_Libros libro = new Control_Libros();
		    	existe = libro.consultar_libros(isbn);
		    	//si no existe lo agregamos
		    	if(existe == false) {
					libro.agregar_libros(isbn, titulo, editorial, clasificacion, subclasificacion, n_autores, year, n_ejemplares, ubicacion, aut1, aut2, aut3, aut4, aut5);
		    		PrintWriter salida = response.getWriter();
					salida.println(1);
		    	}
		    	//si existe
		    	else {
					PrintWriter salida = response.getWriter();
					salida.println(2);
		    	}				
			}
			if (peticion == 2) {
				Control_Libros baja = new Control_Libros();
				resultado = baja.baja_libros(titulo);
				
				if (resultado.equals("tiene prestamos")) {
					PrintWriter salida = response.getWriter();
					salida.println(1);
				}
				if (resultado.equals("exito")) {
					PrintWriter salida = response.getWriter();
					salida.println(2);
				}
			}
			if (peticion == 3) {
				System.out.println("peticion3");
				int year         = Integer.parseInt(año);
				int n_ejemplares = Integer.parseInt(ejemplares);
				Control_Libros editar = new Control_Libros();
				editar.editar_libro(isbn, titulo, editorial, clasificacion, subclasificacion, year, n_ejemplares);
			}
		}
	}

}
