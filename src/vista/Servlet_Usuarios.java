package vista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Usuarios;
import controlador.Usuario;

@WebServlet("/Servlet_Usuarios")
public class Servlet_Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet_Usuarios() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
		String tipo_peticion= request.getParameter("peticion");
		String id_usuario  	= request.getParameter("ID");
		String nombre   	= request.getParameter("nombre");
		String a_paterno   	= request.getParameter("apellido_paterno");
		String a_materno    = request.getParameter("apellido_materno");
		String correo      	= request.getParameter("correo");
		String clave      	= request.getParameter("clave");

		int id = Integer.parseInt(id_usuario);
		
		if (tipo_peticion != null) {
			int peticion = Integer.parseInt(tipo_peticion);
			// Si la peticion es = 1 entonces es una alta
			if(peticion == 1) {
				
				Control_Usuarios editar = new Control_Usuarios();
				editar.editar_usuario(id, nombre, a_paterno, a_materno, correo, clave);		
			}
			if (peticion == 2) {
				Control_Usuarios baja = new Control_Usuarios();
				baja.baja_usuario(id);
			}
		}
	}

}
