package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Prestamos;

@WebServlet("/Servlet_Prestamos")
public class Servlet_Prestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet_Prestamos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		String resultado = "";
		int tamaño = 0;
		String nombre_cliente   = "";
		String apellido_paterno = "";
		String apellido_materno = "";
		String id               = request.getParameter("id_prestamo");
		String tipo_peticion    = request.getParameter("peticion");
		String Correo           = request.getParameter("bibliotecario");
		String Nombre           = request.getParameter("nombre");
		String Libro            = request.getParameter("libro");
		String F_inicio         = request.getParameter("f_actual");
		String F_devolucion     = request.getParameter("f_devolucion");
		String Tipo             = request.getParameter("tipo");
		
		if (tipo_peticion != null) {
			int peticion = Integer.parseInt(tipo_peticion);
//*************** Si la peticion es = 1 entonces es una alta *********************************
			
			if (peticion == 1) 
			{
				String[] nombre_completo = Nombre.split(" ");
				tamaño = nombre_completo.length;
				if (tamaño == 3) {
					nombre_cliente   = nombre_completo[0];		
					apellido_paterno = nombre_completo[1];
					apellido_materno = nombre_completo[2];
				}
				if(tamaño == 4) {
					nombre_cliente   = nombre_completo[0];
					nombre_cliente   += " ";
					nombre_cliente   += nombre_completo[1];
					apellido_paterno = nombre_completo[2];
					apellido_materno = nombre_completo[3];			
				}
				
				Control_Prestamos prestamo = new Control_Prestamos();
				resultado = prestamo.altas_prestamos(Libro, nombre_cliente, apellido_paterno, apellido_materno, Correo, F_inicio, F_devolucion, Tipo);
				if (resultado.equals("no hay libros")) {
					PrintWriter salida = response.getWriter();
					salida.println(1);
				}
				if (resultado.equals("prestamo ya existe")) {
					PrintWriter salida = response.getWriter();
					salida.println(2);					
				}
				if (resultado.equals("exito")) {
					System.out.println("Registrado");
					PrintWriter salida = response.getWriter();
					salida.println(3);
				}		
			}
//*************** Si la peticion es = 2 entonces es una baja *********************************			
			if (peticion == 2) 
			{
				String[] nombre_completo = Nombre.split(" ");
				tamaño = nombre_completo.length;
				if (tamaño == 3) {
					nombre_cliente   = nombre_completo[0];		
					apellido_paterno = nombre_completo[1];
					apellido_materno = nombre_completo[2];
				}
				if(tamaño == 4) {
					nombre_cliente   = nombre_completo[0];
					nombre_cliente   += " ";
					nombre_cliente   += nombre_completo[1];
					apellido_paterno = nombre_completo[2];
					apellido_materno = nombre_completo[3];			
				}
				
				Control_Prestamos baja = new Control_Prestamos();
				baja.baja_prestamos(nombre_cliente, apellido_paterno, apellido_materno, Libro);
			}
			if (peticion == 3)
			{
				int id_p = Integer.parseInt(id);
				Control_Prestamos edita = new Control_Prestamos();
				edita.editar_prestamo(id_p, F_devolucion);
			}
		}
		
	}

}
