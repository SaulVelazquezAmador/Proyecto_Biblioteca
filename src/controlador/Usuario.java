package controlador;
import modelo.Conexion;;

public class Usuario {
	 private String nombre;
	 private String apellido;
	 private String correo;
	 private String clave;
 
	 public Usuario(String nombre, String apellido,String correo, String clave) {
		 this.nombre   = nombre;
		 this.apellido = apellido;
		 this.correo   = correo;
		 this.clave    = clave;
	 }
}
