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

    <div id="titulo_editoriales">
        <h2 id="h2_editoriales">Editoriales</h2>
    </div>  
     
    <div id="formulario_editoriales">
        <form>
            <table>
                <tr>
                    <td class="columnas_formulario_editoriales">
                        <label>Agregar Editorial</label>
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
                        <input type="button" value="Agregar" id="b_editorial">
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div id="datos_editoriales">
        <table id="tabla_editoriales">
            <tr>
                <td id = "cole1" class = "col_tabla_editoriales"><label>Nombre    </label></td>
                <td id = "cole2" class = "col_tabla_editoriales"><label>Ciudad    </label></td>
                <td id = 'cole3' class = 'col_tabla_editoriales'><label>Editar    </label></td>
                <td id = 'cole4' class = 'col_tabla_editoriales'><label>Eliminar  </label></td>
            </tr>
        </table>
    </div>

</body>
</html>