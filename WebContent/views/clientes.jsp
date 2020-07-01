<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="styles/clientes.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="actions/clientes.js"></script>
</head>
<body id="clientes">
	<div id="titulo_clientes">
        <h2 id="h2_clientes">clientes</h2>
    </div>
 
    <div id="formulario_clientes">
        <form>
            <table>  
                <tr>
                    <td class="columnas_formulario_clientes">
                        <label>Agregar Cliente</label>
                    </td>
                </tr>                    
                <tr>
                    <td class="columnas_formulario_clientes">
                        <label>Nombre: </label>
                        <input type="text" class="inputs_clientes" id="nom_cliente">
                    </td>

                    <td class="columnas_formulario_clientes">
                        <label>Apellidos: </label>
                        <input type="text" class="inputs_clientes" id="ap_cliente">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_clientes">
                        <label>Edad: </label>
                        <input type="text" class="inputs_clientes" id="edad_cliente">
                    </td>
                    <td class="columnas_formulario_clientes">
                        <label>Direccion: </label>
                        <input type="text" class="inputs_clientes" id="direccion_cliente">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_clientes">
                        <label>Correo electronico: </label>
                        <input type="text" class="inputs_clientes" id="correo_cliente">
                    </td>
                    <td class="columnas_formulario_clientes">
                        <label>Telefono: </label>
                        <input type="text" class="inputs_clientes" id="telefono_cliente">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_clientes">
                        <input type="button" value="Agregar cliente" id="b_clientes">
                    </td>
                </tr>
            </table>
        </form>
    </div> 
    <!--
	    <div id="datos_clientes">
	        <table id="tabla_clientes">
	            <tr>
	                <td id = "col_au1" class = "col_tabla_clientes"><label>Nombre            </label></td>
	                <td id = "col_au2" class = "col_tabla_clientes"><label>Apellido paterno  </label></td>
	                <td id = "col_au3" class = "col_tabla_clientes"><label>Apellido materno  </label></td>
	                <td id = "col_au4" class = "col_tabla_clientes"><label>Nacionalidad      </label></td>
	                <td id = 'col_au5' class = 'col_tabla_clientes'><label>Editar            </label></td>
	                <td id = 'col_au6' class = 'col_tabla_clientes'><label>Eliminar          </label></td>
	            </tr>
	        </table>
	    </div>
	   -->
</body>
</html>