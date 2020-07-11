<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="styles/autores.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="actions/autores.js"></script>
</head>
    <!--------------------------------------------------------------------->
<body id="autores">
	<div id="titulo_autores">
        <h2 id="h2_autores">Autores</h2>
    </div>
    <!--------------------------------------------------------------------->
    <div id="div_opciones">
        <ul>
            <li id="pestaña_agregar">Agregar Editorial</li>
            <li id="pestaña_eliminar">Eliminar Editorial</li>
            <li id="pestaña_editar">Editar Editorial</li>
        </ul>
    </div>
    <!--------------------------------------------------------------------->
    <div id="formulario_autores">
        <form>
            <table>  
                <tr>
                    <td class="columnas_formulario_autores">
                        <label>Agregar Autor</label>
                    </td>
                </tr>                    
                <tr>
                    <td class="columnas_formulario_autores">
                        <label>Nombre: </label>
                        <input type="text" class="inputs_autores" id="nom_autor">
                    </td>

                    <td class="columnas_formulario_autores">
                        <label>Apellidos: </label>
                        <input type="text" class="inputs_autores" id="ap_autor">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_autores">
                        <label>Nacionalidad: </label>
                        <input type="text" class="inputs_autores" id="nac_autor">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_autores">
                        <input type="button" value="Agregar Autor" id="b_autores">
                    </td>
                </tr>
            </table>
        </form>
    </div> 
    <!--------------------------------------------------------------------->
    <div id="datos_autores">
        <table id="tabla_autores">
            <tr>
                <td id = "col_au1" class = "col_tabla_autores"><label>Nombre            </label></td>
                <td id = "col_au2" class = "col_tabla_autores"><label>Apellido paterno  </label></td>
                <td id = "col_au3" class = "col_tabla_autores"><label>Apellido materno  </label></td>
                <td id = "col_au4" class = "col_tabla_autores"><label>Nacionalidad      </label></td>
                <td id = 'col_au5' class = 'col_tabla_autores'><label>Editar            </label></td>
                <td id = 'col_au6' class = 'col_tabla_autores'><label>Eliminar          </label></td>
            </tr>
        </table>
    </div>
</body>
</html>