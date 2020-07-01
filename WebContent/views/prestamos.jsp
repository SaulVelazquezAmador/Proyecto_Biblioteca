<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="styles/prestamos.css">
</head>
<body id="prestamos">
    <div id="titulo_prestamos">
        <h2 id="h2_prestamos">Prestamos</h2>
    </div>
 
    <div id="formulario_prestmos">
        <form>
            <table>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <label>Datos del cliente:</label>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <label> Nombre:</label>
                        <input type="text" class="inputs_prestamos">
                    </td>
                    <td class="columnas_formulario_prestamos">
                        <label >Apellido paterno:</label>
                        <input type="text" class="inputs_prestamos">
                    </td>
                    <td class="columnas_formulario_prestamos">
                        <label >Apellido materno:</label>
                        <input type="text" class="inputs_prestamos">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <label>Datos del libro:</label>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <label>ISBN: </label>
                        <input type="text" class="inputs_prestamos">
                    </td>
                    <td class="columnas_formulario_prestamos">
                        <label>Nombre libro: </label>
                        <input type="text" class="inputs_prestamos">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <input type="button" value="Procesar">
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div id="datos_prestamos">
        <table id="tabla_prestamos">
            <tr>
                <td id = "c1" class = "col_tabla_prestamos"><label>Libro    </label></td>
                <td id = "c2" class = "col_tabla_prestamos"><label>Cliente  </label></td>
                <td id = "c3" class = "col_tabla_prestamos"><label>Inicio   </label></td>
                <td id = "c4" class = "col_tabla_prestamos"><label>Fin      </label></td>
                <td id = "c5" class = "col_tabla_prestamos"><label>Estado   </label></td>
                <td id = "c6" class = "col_tabla_prestamos"><label>Terminar </label></td>
                <td id = "c7" class = "col_tabla_prestamos"><label>         </label></td>
            </tr>
        </table>
    </div>	
</body>
</html>