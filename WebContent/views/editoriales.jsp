<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="styles/editoriales.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="actions/editoriales.js"></script>
</head>
<body id="editoriales"> 
    <!--------------------------------------------------------------------->
    <div id="titulo_editoriales">
        <h2 id="h2_editoriales">Editoriales</h2>
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
    <div id="formulario_altas_editoriales">
        <form>
            <table id="tabla_altas">
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <h3>Agregar Editorial</h3>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <label>Nombre: </label>
                        <input type="text" class="inputs_editoriales" id="n_editorial">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <label>Ciudad: </label>
                        <input type="text" class="inputs_editoriales" id="c_editorial">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <input type="button" value="Agregar" id="alta_editorial">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!--------------------------------------------------------------------->
    <div id="formulario_bajas_editoriales">
        <form>
            <table id="tabla_bajas">
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <h3>Eliminar Editorial</h3>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_editoriales" id="nom_baja_editorial">
                        Editorial: <select></select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <input type="button" value="Eliminar editorial" id="eliminar_editorial">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!--------------------------------------------------------------------->
    <div id="formulario_editar_editoriales">
    	<form>
    		<table id="tabla_edicion">
    			<tr>
    				<td class="columnas_formulario_editoriales">
    					<h3>Editar Editorial</h3>
    				</td>
    			</tr>
                <tr>
                    <td class="columnas_formulario_editoriales" id="nom_edicion_editorial">
                        Editorial: <select></select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <label>Nombre: </label>
                        <input type="text" class="inputs_editoriales" id="n_editorial3">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <label>Ciudad: </label>
                        <input type="text" class="inputs_editoriales" id="c_editorial3">
                    </td>
                </tr>   
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <input type="button" value="Editar editorial" id="editar_editorial">
                    </td>
                </tr>             
    		</table>
    	</form>
    </div>
    <!--------------------------------------------------------------------->
    <div id="datos_editoriales"  class="divs_tabla">
        <table id="tabla_editoriales">
            <tr>
                <td id = "cole1" class = "col_tabla_editoriales"><label>Nombre    </label></td>
                <td id = "cole2" class = "col_tabla_editoriales"><label>Ciudad    </label></td>
            </tr>
        </table>
    </div>

</body>
</html>