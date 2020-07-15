<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="styles/usuarios.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="actions/usuarios.js"></script>
</head>
<body id="usuarios">
    <!--------------------------------------------------------------------->
    <div id="titulo_usuarios">
        <h2 class="hs">Usuarios</h2>
    </div>   
    <!--------------------------------------------------------------------->
	<div class="fichas" id="ficha_principal">
		<table id="tabla_principal">
			<tr class="filas_ficha">
				<td>
					<h4 class="hs" id="h4">Usuario actual</h4>
				</td>
			</tr>
			<tr class="filas_ficha">
				<td class="columnas_ficha">
					<label id="nombre"></label>
				</td>
			</tr>
			<tr class="filas_ficha">
				<td class="columnas_ficha">
					<label id="correo"></label>
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="Baja" id="boton_baja">
					<input type="button" value="Edición" id="boton_editar1">
				</td>
			</tr>
		</table>
	</div>
<!--------------------------------------------------------------------------->
	<div class="fichas" id="ficha_edicion">
		<table id="tabla_edicion">
			<tr>
				<td>
					<h4 class="hs">Editar usuario</h4>
				</td>
			</tr>
			<tr>
				<td class="columnas_ficha2">
					<input type="text" id="edit_nombre" class="inputs_usuarios">
				</td>
				<td class="columnas_ficha2">
					<input type="text" id="edit_apellido_p" class="inputs_usuarios">
				</td>
				<td class="columnas_ficha2">
					<input type="text" id="edit_apellido_m" class="inputs_usuarios">
				</td>
			</tr>
			<tr>
				<td class="columnas_ficha2">
					<input type="text" id="edit_correo" class="inputs_usuarios">
				</td>
				<td class="columnas_ficha2">
					<input type="password" id="edit_clave" class="inputs_usuarios">
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="Editar" id="boton_editar2">
				</td>
			</tr>
		</table>
	</div>
	<div id="tabla_usuarios">
		<table>
		</table>
	</div>
</body>
</html>