<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistema Bibliotecario</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="actions2.js"></script>
</head>
<body id="cuerpo2">

    <div id="menu_principal">
        <table>
            <tr id="op_0">
                <td>Biblioteca     </td>
            </tr>
            <tr>
                <td id="op_1">Inicio         </td>
            </tr>
            <tr>
                <td id="op_2">Prestamos      </td>
            </tr>
            <tr>
                <td id="op_3">Libros         </td>
            </tr>
            <tr>
                <td id="op_4">Clientes       </td>
            </tr>
            <tr>
                <td id="op_5">Categorias     </td>
            </tr>
            <tr>
                <td id="op_6">Editoriales    </td>
            </tr>
            <tr>
                <td id="op_7">Autores        </td>
            </tr>
            <tr>
                <td id="op_8">Reportes       </td>
            </tr>
            <tr>
                <td id="op_9">Usuarios       </td>
            </tr>
            <tr>
                <td id="op_10">Cerrar sesión </td>
            </tr>
        </table>
    </div>
    
    <div id="prestamos">

        <div id="formulario_prestmos">
            <table>
                <tr>
                    <td>
                        <label> Nombre: </label>
                    </td>
                    <td>
                        <label>Apellidos: </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Libro: </label>
                    </td>
                </tr>
            </table>
        </div>
        <div id="datos_prestamos">
            <p>aqui va a ir la info</p>
        </div>
    </div>
</body>
</html>