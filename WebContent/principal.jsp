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

    </div>

    <div id="libros">

        <div id="titulo_libros">
            <h2 id="h2_libros">Libros</h2>
        </div>   
        
        <div id="formulario_libros">
            <form>
                <table>
                    <tr>
                        <td class="columnas_formulario_libros">
                            <label>Agregar libro</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_libros">
                            <label>ISBN: </label>
                            <input type="text" class="inputs_libros">
                        </td>
                        <td class="columnas_formulario_libros">
                            <label>Titulo: </label>
                            <input type="text" class="inputs_libros">
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_libros">
                            <label>Editorial: </label>
                            <input type="text" class="inputs_libros">
                        </td>
                        <td class="columnas_formulario_libros">
                            <label>Autor: </label>
                            <input type="text" class="inputs_libros">
                        </td>
                        <td class="columnas_formulario_libros">
                            <label>Ejemplares: </label>
                            <input type="text" class="inputs_libros">
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_prestamos">
                            <input type="button" value="Agrear">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div id="datos_libros">
            <table id="tabla_libros">
                <tr>
                    <td id = "cl1" class = "col_tabla_libros"><label>ISBN       </label></td>
                    <td id = "cl2" class = "col_tabla_libros"><label>Titulo     </label></td>
                    <td id = "cl3" class = "col_tabla_libros"><label>Editorial  </label></td>
                    <td id = "cl4" class = "col_tabla_libros"><label>Autor      </label></td>
                    <td id = "cl5" class = "col_tabla_libros"><label>Ejemplares </label></td>
                    <td id = "cl6" class = "col_tabla_libros"><label>Eliminar   </label></td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>