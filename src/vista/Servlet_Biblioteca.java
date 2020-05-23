package vista;

import java.io.IOException;
import controlador.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Biblioteca
 */
@WebServlet("/Servlet_Biblioteca")
public class Servlet_Biblioteca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_Biblioteca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		boolean existe = false;
		String nombre_registro=request.getParameter("nombre");
		String apellidos_registro=request.getParameter("apellido");
		String correo_registro=request.getParameter("correo");
		String password_registro=request.getParameter("clave");

		System.out.println(nombre_registro);
		System.out.println(apellidos_registro);
		System.out.println(correo_registro);
		System.out.println(password_registro);
		
		Usuario user = new Usuario(nombre_registro, apellidos_registro, correo_registro, password_registro);
		existe = user.consultar_usuario(nombre_registro, apellidos_registro, correo_registro, password_registro);
		if(existe == true) {
			System.out.println("exito");
		}
		else {
			System.out.println("mal");
		}
		
				
		//RequestDispatcher rd;
		//rd = request.getRequestDispatcher("/principal.jsp");
		//rd.forward(request, response);
	}

}