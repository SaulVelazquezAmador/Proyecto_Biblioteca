package vista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Actualizacion_Vistas")
public class Actualizacion_Vistas extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Actualizacion_Vistas() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String tipo_vista = request.getParameter("tipo_vista");
		int vista = Integer.parseInt(tipo_vista);
		
		if (vista == 3) {
			System.out.println("entra");
			request.getRequestDispatcher("prestamos.jsp").forward(request, response);
		}
	}

}
