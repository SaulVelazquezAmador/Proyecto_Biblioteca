package vista;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlador.Control_Clientes;

@WebServlet("/Servlet_Clientes")
public class Servlet_Clientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet_Clientes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		boolean existe = false;
		String resultado = "";
		String apellido_paterno = "";
		String apellido_materno = "";
		int edad = 0;
		
		String tipo_peticion = request.getParameter("peticion"); 
		String nombre        = request.getParameter("n_cliente");
		String apellidos     = request.getParameter("a_cliente");
		String e             = request.getParameter("e_cliente");
		String direccion     = request.getParameter("d_cliente");
		String correo        = request.getParameter("c_cliente");
		String telefono      = request.getParameter("t_cliente");
		String id_cliente    = request.getParameter("i_cliente");
		String nombre_baja   = request.getParameter("nom_baja");
		
		if (tipo_peticion != null) {
			int peticion = Integer.parseInt(tipo_peticion);
			// Si la peticion es = 1 entonces es una alta
			if(peticion == 1) {
				edad = Integer.parseInt(e); 
				
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

				int gm = correo.indexOf("@gmail.com");
				int hm = correo.indexOf("@hotmail.com");
				int ol = correo.indexOf("@outlook.com");

				if(existe == true) {
		    		PrintWriter salida = response.getWriter();
					salida.println(2);
				}
				else if (gm == -1 && hm == -1 && ol == -1) {
					PrintWriter salida = response.getWriter();
					salida.println(3);
				}
				else {
					cliente.agregar_cliente(nombre, apellido_paterno, apellido_materno, edad, direccion, correo, telefono);
		    		PrintWriter salida = response.getWriter();
					salida.println(1);
				}	
			}
			//Si la peticion = 2 entonces es una baja
			if (peticion == 2) {
				
				String nombre_cliente = "";
				int tamaño = 0;
				
				String[] nombre_completo = nombre_baja.split(" ");
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
				Control_Clientes cliente = new Control_Clientes();
				resultado = cliente.eliminar_cliente(nombre_cliente, apellido_paterno, apellido_materno);
				
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
				int espacio = 0;
				//regresa -1 si lo encuentra
				espacio = apellidos.indexOf(" ");
				
				if(espacio != -1) {
					String[] apellidos_cliente = apellidos.split(" ");
					apellido_paterno = apellidos_cliente[0];
					apellido_materno = apellidos_cliente[1];	
				}
				else {
					apellido_paterno = apellidos;
					apellido_materno = "";
				}

				int gm = correo.indexOf("@gmail.com");
				int hm = correo.indexOf("@hotmail.com");
				int ol = correo.indexOf("@outlook.com");

				if (gm == -1 && hm == -1 && ol == -1){
		    		PrintWriter salida = response.getWriter();
					salida.println(1);					
				}
				else{
					int id = Integer.parseInt(id_cliente);
					edad = Integer.parseInt(e);
					Control_Clientes editar = new Control_Clientes();
					editar.editar_clientes(id, nombre, apellido_paterno, apellido_materno, edad, direccion, correo, telefono);
		    		PrintWriter salida = response.getWriter();
					salida.println(2);
				}
			}
		}
	}

}

