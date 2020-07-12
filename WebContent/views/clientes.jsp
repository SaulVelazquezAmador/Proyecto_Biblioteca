<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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
    <!--------------------------------------------------------------------->
	<div id="titulo_clientes">
        <h2 id="h2_clientes">Clientes</h2>
    </div>
    <!--------------------------------------------------------------------->
    <div id="div_opciones">
        <ul>
            <li id="pestaña_agregar">Agregar Cliente</li>
            <li id="pestaña_eliminar">Eliminar Cliente</li>
            <li id="pestaña_editar">Editar Cliente</li>
        </ul>
    </div>
    <!--------------------------------------------------------------------->
    <div id="formulario_altas_clientes">
        <form>
            <table>   
                <tr>
                    <td class="columnas_datos_clientes">
                        <h3>Agregar Cliente</h3>
                    </td>
                </tr>                   
                <tr>
                    <td class="columnas_datos_clientes">
                        <label>Nombre: </label>
                        <input type="text" class="inputs_clientes" id="nom_cliente">
                    </td>

                    <td class="columnas_datos_clientes">
                        <label>Apellidos: </label>
                        <input type="text" class="inputs_clientes" id="ap_cliente">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_datos_clientes">
                        <label>Edad: </label>
                        <input type="text" class="inputs_clientes" id="edad_cliente">
                    </td>
                    <td class="columnas_datos_clientes">
                        <label>Direccion: </label>
                        <input type="text" class="inputs_clientes" id="direccion_cliente">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_datos_clientes">
                        <label>Correo electronico: </label>
                        <input type="text" class="inputs_clientes" id="correo_cliente">
                    </td>
                    <td class="columnas_datos_clientes">
                        <label>Telefono: </label>
                        <input type="text" class="inputs_clientes" id="telefono_cliente">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_datos_clientes">
                        <input type="button" value="Agregar cliente" id="agregar_cliente">
                    </td>
                </tr>
            </table>
        </form>
    </div> 
    <!--------------------------------------------------------------------->
    <div id="formulario_bajas_clientes">
        <form>
            <table>
                <tr>
                    <td class="columnas_datos_clientes">
                        <h3>Eliminar Cliente</h3>
                    </td>
                </tr>   
                <tr>
                    <td class="columnas_datos_clientes" id="nombre_baja">
                        Cliente: <select></select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_datos_clientes">
                        <input type="button" value="Eliminar cliente" id="eliminar_cliente">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!--------------------------------------------------------------------->
    <div id="formulario_editar_clientes">
        <form>
            <table>
                <tr>
                    <td class="columnas_datos_clientes">
                        <h3>Editar Cliente</h3>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_datos_clientes" id="nombre_edicion">
                        Cliente: <select></select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_datos_clientes">
                        <label>Nombre: </label>
                        <input type="text" class="inputs_clientes" id="nom_cliente3">
                    </td>

                    <td class="columnas_datos_clientes">
                        <label>Apellidos: </label>
                        <input type="text" class="inputs_clientes" id="ap_cliente3">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_datos_clientes">
                        <label>Edad: </label>
                        <input type="text" class="inputs_clientes" id="edad_cliente3">
                    </td>
                    <td class="columnas_datos_clientes">
                        <label>Direccion: </label>
                        <input type="text" class="inputs_clientes" id="direccion_cliente3">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_datos_clientes">
                        <label>Correo electronico: </label>
                        <input type="text" class="inputs_clientes" id="correo_cliente3">
                    </td>
                    <td class="columnas_datos_clientes">
                        <label>Telefono: </label>
                        <input type="text" class="inputs_clientes" id="telefono_cliente3">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_datos_clientes">
                        <input type="button" value="Agregar cliente" id="editar_cliente">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!--------------------------------------------------------------------->
    <div id="datos_clientes">
        <table id="tabla_clientes">
            <tr>
                <td id = "col_cli1" class = "col_tabla_clientes"><label>Nombre            </label></td>
                <td id = "col_cli2" class = "col_tabla_clientes"><label>Apellido paterno  </label></td>
                <td id = "col_cli3" class = "col_tabla_clientes"><label>Apellido materno  </label></td>
                <td id = "col_cli4" class = "col_tabla_clientes"><label>Correo Electronico</label></td>
                <td id = 'col_cli5' class = 'col_tabla_clientes'><label>Telefono            </label></td>
            </tr>
        </table>
    </div>

</body>
</html>