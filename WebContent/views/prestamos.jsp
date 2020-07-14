<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="styles/prestamos.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="actions/prestamos.js"></script>
</head>
<body id="prestamos">
    <div id="titulo_prestamos">
        <h2 id="h2_prestamos">Prestamos</h2>
    </div>
    <!--------------------------------------------------------------------->
    <div id="div_opciones_p">
        <ul>
            <li id="pestaña_agregar_p">Agregar Prestamo</li>
            <li id="pestaña_eliminar_p">Eliminar Prestamo</li>
            <li id="pestaña_editar_p">Editar Prestamo</li>
        </ul>
    </div>
    <!--------------------------------------------------------------------->
    <div id="formulario_altas_prestamos">
        <form>
            <table>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <h3>Seleccione datos del prestamo</h3>
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
                    <td class="columnas_formulario_prestamos" id="select_tipo">
                        <label >Tipo de prestamo:</label>
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
                    <td class="columnas_formulario_prestamos">
                        <input type="button" value="Procesar" id="alta_prestamos">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!--------------------------------------------------------------------->
    <div id="formulario_bajas_prestamos">
        <form>
            <table>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <h3>Seleccione prestamo a eliminar</h3>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos" id="nombre_baja_p">
                        Cliente: <select></select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos" id="libro_baja_p">
                        Libros prestados: <select></select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <input type="button" value="Eliminar prestamo" id="baja_prestamos">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!--------------------------------------------------------------------->
    <div id="formulario_edicion_prestamos">
        <form>
            <table>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <h3>Seleccione prestamo a editar</h3>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos" id="col_cliente_edicion">
                        Cliente: <select></select>
                    </td>
                    <td class="columnas_formulario_prestamos" id="col_libro_edicion">
                        Libros prestados: <select></select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <label>Tipo de prestamo:</label>
                        <select  id="select_tipo3">
                            <option>---------------</option>
                            <option>Para Casa</option>
                            <option>Para Biblioteca</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <label>Fecha de inicio</label>
                        <input type="date" name="f_inicio" id="f_inicio3">
                    </td>
                    <td class="columnas_formulario_prestamos">
                        <label>Fecha devolucion</label>
                        <input type="date" name="f_devolucion" id="f_devolucion3">
                    </td>
                </tr>
                <tr>
                    <td class="columnas_formulario_prestamos">
                        <input type="button" value="Editar prestamo" id="boton_edicion">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <!--------------------------------------------------------------------->
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