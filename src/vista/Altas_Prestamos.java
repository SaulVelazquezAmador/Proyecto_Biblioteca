package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Prestamos;

@WebServlet("/Altas_Prestamos")
public class Altas_Prestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Altas_Prestamos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		boolean existe = false;
		int tamaño = 0;
		String nombre_cliente   = "";
		String apellido_paterno = "";
		String apellido_materno = "";
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
				System.out.println(nombre_cliente);
				System.out.println(apellido_paterno);
				System.out.println(apellido_materno);
				
				Control_Prestamos prestamo = new Control_Prestamos();
				existe = prestamo.consultar_prestamos(Libro, nombre_cliente, apellido_paterno, apellido_materno, Correo, F_inicio, F_devolucion, Tipo);
				if (existe == true) {
					System.out.println("Ya existe");
					PrintWriter salida = response.getWriter();
					salida.println(1);
				}
				else {
					System.out.println("Registrado");
					PrintWriter salida = response.getWriter();
					salida.println(2);
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
				System.out.println(nombre_cliente);
				System.out.println(apellido_paterno);
				System.out.println(apellido_materno);
				
				Control_Prestamos baja = new Control_Prestamos();
				baja.baja_prestamos(nombre_cliente, apellido_paterno, apellido_materno, Libro);
			}
		}
		
	}

}
