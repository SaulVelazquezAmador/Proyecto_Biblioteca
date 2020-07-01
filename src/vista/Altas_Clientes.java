package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Clientes;

@WebServlet("/Altas_Clientes")
public class Altas_Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Altas_Clientes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		boolean existe = false;
		String apellido_paterno = "";
		String apellido_materno = "";
		int edad = 0;
		int telefono = 0;
		String nombre      = request.getParameter("n_cliente");
		String apellidos   = request.getParameter("a_cliente");
		String e           = request.getParameter("e_cliente");
		String direccion   = request.getParameter("d_cliente");
		String correo      = request.getParameter("c_cliente");
		String t           = request.getParameter("t_cliente");
		
		if (nombre != null && apellidos != null && e != null && direccion != null &&
				correo != null && t != null) {
			
			edad = Integer.parseInt(e); 
			telefono = Integer.parseInt(t);
			
			int espacio = 0;
			espacio = apellidos.indexOf(" ");
			
			if(espacio != -1) {
				String[] apellidosc = apellidos.split(" ");
				apellido_paterno = apellidosc[0];
				apellido_materno = apellidosc[1];	
			}
			else {
				apellido_paterno = apellidos;
				apellido_materno = "";
			}	
			
			Control_Clientes cliente = new Control_Clientes();
			existe = cliente.consultar_clientes(nombre, apellido_paterno, apellido_materno, correo, telefono);
			
			if(existe == false) {
				cliente.agregar_cliente(nombre, apellido_paterno, apellido_materno, edad, direccion, correo, telefono);
	    		PrintWriter salida = response.getWriter();
				salida.println(1);
			}
			else {
	    		PrintWriter salida = response.getWriter();
				salida.println(2);
			}
		}
	}

}
