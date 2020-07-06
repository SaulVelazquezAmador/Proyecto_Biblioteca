<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="styles/prestamos.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="actions/prestamos.js"></script>
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
                    <td class="columnas_formulario_prestamos" id="select_nombre">
                        <label> Cliente:</label>
                        <select></select>
                    </td>
                    <td class="columnas_formulario_prestamos" id="select_libro">
                        <label >Libro:</label>
                        <select></select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <label>Fecha de inicio</label>
                        <input type="date" name="f_inicio" id="f_actual">
                    </td>
                    <td class="columnas_formulario_prestamos">
                        <label>Fecha devolucion</label>
                        <input type="date" name="f_devolucion" id="f_devolucion">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos" id="select_tipo">
                        <label >Tipo de prestamo:</label>
                        <select></select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <input type="button" value="Procesar" id="b_prestamos">
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
                <td id = "c5" class = "col_tabla_prestamos"><label>Terminar </label></td>
                <td id = "c6" class = "col_tabla_prestamos"><label>         </label></td>
            </tr>
        </table>
    </div>	
</body>
</html>