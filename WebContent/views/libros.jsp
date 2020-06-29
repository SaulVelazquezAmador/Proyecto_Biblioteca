<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="styles/libros.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="actions/libros.js"></script>
</head>
<body id="libros">
        <div id="titulo_libros">
            <h2 id="h2_libros">Líbros</h2>
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
                            <input type="text" class="inputs_libros" id="isbn_lib">
                        </td>
                        <td class="columnas_formulario_libros">
                            <label>Titulo: </label>
                            <input type="text" class="inputs_libros" id="titulo_lib">
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_libros">
                            <label>Año: </label>
                            <input type="text" class="inputs_libros" id="year_lib">
                        </td>
                        <td class="columnas_formulario_libros">
                            <label>Ejemplares: </label>
                            <input type="text" class="inputs_libros" id="ejemplares_lib">
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_libros" id="select_clasificacion">
                            Clasificacion: <select></select>    
                        </td>
                        <td colspan="2" class="columnas_formulario_libros" id="select_subclasificacion">
                            Subclasificacion: <select></select>
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_libros" id="col_select_autores">  
                            Autores:<select name="autores" id="numero_autores">
                                        <option value="0">----</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                        </td>
                        <td class="columnas_formulario_libros" id="select_editorial">
                            Editorial: <select></select>
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_libros" id="autor_1">
                            Autor 1: <select></select>
                        </td>
                        <td class="columnas_formulario_libros" id="autor_2">
                            Autor 2: <select></select>
                        </td>
                        <td class="columnas_formulario_libros" id="autor_3">
                            Autor 3: <select></select>
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_libros" id="autor_4">
                            Autor 4: <select></select>
                        </td>
                        <td class="columnas_formulario_libros" id="autor_5">
                            Autor 5: <select></select>
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_libros" id="ubicacion">
                            Ubicacion: <select></select>
                        </td>
                    </tr>
                    <tr>
                        <td class="columnas_formulario_libros">
                            <input type="button" value="Agregar Libro" id="b_libros">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <!---
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
        -->
</body>
</html>