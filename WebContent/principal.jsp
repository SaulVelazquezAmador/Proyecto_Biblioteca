<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
    <title>Sistema Bibliotecario</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="acciones2.js"></script>
</head>
<body id="cuerpo2">

    <div id="menu_principal">
        <table>
            <tr id="op_0">
                <td>Biblioteca     </td>
            </tr>
            <tr>
                <td id="op_1"> 
                    <svg
                        id="Layer_1" enable-background="new 0 0 511.995 511.995" height="512" viewBox="0 0 511.995
                        511.995" width="512" xmlns="http://www.w3.org/2000/svg"><g><path d="m507.308
                        236.641-198.98-198.99c-28.86-28.85-75.8-28.85-104.66 0l-198.98 198.99c-6.25 6.25-6.25
                        16.38 0 22.63 6.24 6.25 16.38 6.25 22.62 0l12.69-12.69v203.4c0 25.405 20.595 46 46
                        46h80c5.523 0 10-4.477 10-10v-148c0-27.614 22.386-50 50-50h60c27.614 0 50 22.386 50
                        50v148c0 5.523 4.477 10 10 10h80c25.405 0 46-20.595 46-46v-203.4l12.69 12.69c3.12 3.12
                        7.22 4.69 11.31 4.69s8.19-1.57 11.31-4.69c6.25-6.25 6.25-16.38 0-22.63z"/></g></svg> Inicio
                </td>
            </tr>
            <tr>
                <td id="op_2">
                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="
                        http://www.w3.org/1999/xlink" x="0px"     y="0px"
                        width="912.899px" height="912.899px" viewBox="0 0 912.899 912.899" style="enable-background
                        :new 0 0 912.899 912.899;"
                        xml:space="preserve">   
                        <g>
                            <circle cx="456" cy="202.4" r="202.4"/>
                            <path d="M81.2,477.5v42c0.3,0,0.7,0,1,0c28.8,0,56,11.2,76.4,31.6c20.4,20.4,31.6,47.5,31.6,76.4c0,28.8-11.2,56-31.6,76.399
                            c-20.4,20.4-47.5,31.601-76.4,31.601c-0.3,0-0.7,0-1,0v144.8c0,14.1,11.5,25,24.9,25c1.7,0,3.4-0.2,5.1-0.5
                            c37.9-7.7,94.3-12.7,157.4-12.7c83,0,154.6,8.5,187.4,20.8c32.7-12.3,104.299-20.8,187.399-20.8c63.102,0,119.5,4.9,157.4,12.7
                            c1.701,0.3,3.4,0.5,5.1,0.5c13.5,0,24.9-10.9,24.9-25V735.5c-28.799,0-56-11.2-76.4-31.601c-20.398-20.399-31.6-47.5-31.6-76.399
                            c0-28.8,11.201-56,31.6-76.4c20.4-20.399,47.5-31.6,76.4-31.6v-42c0-10.9-7.1-20.601-17.5-23.8
                            C783.5,444.3,718.6,427.1,643.399,427.1C539.899,427.1,456,459.7,456,459.7S372.1,427.1,268.6,427.1
                            c-75.2,0-140.1,17.2-169.9,26.601C88.3,457,81.2,466.6,81.2,477.5z"/>
                            <path d="M66.2,557.3c-5.2,1.2-10.3,2.9-15,5.2c-24.3,11.6-41,36.3-41,65s16.8,53.399,41,65c4.7,2.3,9.8,4,15,5.2
                            c4.8,1.1,9.9,1.699,15,1.8c0.3,0,0.7,0,1,0c39.8,0,72-32.2,72-72s-32.2-72-72-72c-0.3,0-0.7,0-1,0
                            C76.1,555.6,71.1,556.2,66.2,557.3z"/>
                            <path d="M758.7,627.5c0,39.8,32.199,72,72,72c5.1,0,10.199-0.5,15-1.601c5.199-1.1,10.301-2.8,15-5
                            c24.801-11.399,42-36.399,42-65.5c0-29.1-17.199-54.1-42-65.5c-4.699-2.199-9.801-3.899-15-5c-4.801-1-9.9-1.6-15-1.6
                            C790.899,555.5,758.7,587.8,758.7,627.5z"/>
                        </g>
                    </svg> Prestamos
                </td>
            </tr>
            <tr>
                <td id="op_3">
                    <svg 
                        id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512" xmlns="http://www.w3.org/2000/svg"><g><path d="m163.268 407.746c-2.895-.211-5.809-.317-8.74-.317h-101.801-15v-293.184h-37.727v330.591h240.879l-3.386-3.345c-20.156-19.905-46.244-31.707-74.225-33.745z"/><path d="m154.528 67.164h-86.801v310.265h86.802c31.445 0 61.437 9.769 86.472 27.849v-300.588l-3.507-3.464c-22.242-21.964-51.706-34.062-82.966-34.062zm34.394 240.079h-69.117v-30h69.117zm0-67.469h-69.117v-30h69.117zm0-67.469h-69.117v-30h69.117z"/><path d="m444.273 377.429v-310.265h-86.802c-31.26 0-60.724 12.098-82.966 34.063l-3.505 3.463v300.587c25.035-18.08 55.027-27.849 86.472-27.849h86.801zm-121.195-235.124h69.117v30h-69.117zm0 67.469h69.117v30h-69.117zm0 67.469h69.117v30h-69.117z"/><path d="m474.273 114.245v293.184h-116.801c-31.26 0-60.724 12.097-82.966 34.063l-3.385 3.344h240.879v-330.591z"/></g>
                    </svg> Libros<!--Libros-->
                </td>
            </tr>
            <tr>
                <td id="op_4">Clientes       </td>
            </tr>
            <tr>
                <td id="op_5">Categorias     </td>
            </tr>
            <tr>
                <td id="op_6">
                    <svg 
                        id="bold" enable-background="new 0 0 24 24" height="512" viewBox="0 0 24 24" width="512" xmlns="http://www.w3.org/2000/svg"><path d="m13.03 1.87-10.99-1.67c-.51-.08-1.03.06-1.42.39-.39.34-.62.83-.62 1.34v21.07c0 .55.45 1 1 1h3.25v-5.25c0-.97.78-1.75 1.75-1.75h2.5c.97 0 1.75.78 1.75 1.75v5.25h4.25v-20.4c0-.86-.62-1.59-1.47-1.73zm-7.53 12.88h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75zm0-3h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75zm0-3h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75zm0-3h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75zm5 9h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75zm0-3h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75zm0-3h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75zm0-3h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75z"/><path d="m22.62 10.842-7.12-1.491v14.649h6.75c.965 0 1.75-.785 1.75-1.75v-9.698c0-.826-.563-1.529-1.38-1.71zm-2.37 10.158h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75zm0-3h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75zm0-3h-1.5c-.414 0-.75-.336-.75-.75s.336-.75.75-.75h1.5c.414 0 .75.336.75.75s-.336.75-.75.75z"/>
                    </svg> Editoriales<!--EDitoriales-->
                </td>
            </tr>
            <tr>
                <td id="op_7">
                    <svg 
                        id="Solid" height="512" viewBox="0 0 512 512" width="512" xmlns="http://www.w3.org/2000/svg"><path d="m139.313 304 44.687 44.687 44.687-44.687z"/><path d="m395.332 453.406v.007l-33.941 11.314a8 8 0 0 1 -10.12-10.12l11.314-33.941h.007a7.952 7.952 0 0 1 1.926-3.129l79.2-79.2 4.282-4.278v-46.059h-160v192h160v-78.059l-49.539 49.539a7.952 7.952 0 0 1 -3.129 1.926zm-19.332-69.406h-32a8 8 0 0 1 0-16h32a8 8 0 0 1 0 16zm32-32a8 8 0 1 1 8-8 8 8 0 0 1 -8 8zm-32-48h48a8 8 0 0 1 0 16h-48a8 8 0 0 1 0-16zm-64 0h32a8 8 0 0 1 0 16h-32a8 8 0 0 1 0-16zm0 32h64a8 8 0 0 1 0 16h-64a8 8 0 0 1 0-16zm0 32a8 8 0 1 1 -8 8 8 8 0 0 1 8-8zm16 80h-16a8 8 0 0 1 0-16h16a8 8 0 0 1 0 16zm16-32h-32a8 8 0 0 1 0-16h32a8 8 0 0 1 0 16z"/><path d="m240 352v-36.686l-36.686 36.686z"/><path d="m256 360a8 8 0 0 1 -8 8h-56v112h80v-176h-16z"/><path d="m112 360v-56h-56a24.028 24.028 0 0 0 -24 24v152h144v-112h-56a8 8 0 0 1 -8-8z"/><path d="m128 315.314v36.686h36.686z"/><path d="m279.664 200h-16.464a40 40 0 0 1 -79.2-8 40 40 0 0 1 -79.195 8h-16.469a96 96 0 0 0 191.328 0zm-126.32 43.562a8 8 0 0 1 11.094-2.218c13.346 8.9 25.778 8.9 39.124 0a8 8 0 0 1 8.876 13.312c-9.3 6.2-18.87 9.3-28.438 9.3s-19.136-3.1-28.438-9.3a8 8 0 0 1 -2.218-11.094z"/><path d="m200 192a24 24 0 1 0 24-24 24.028 24.028 0 0 0 -24 24zm32 0a8 8 0 1 1 -8-8 8 8 0 0 1 8 8z"/><path d="m377.995 442.327-4.322-4.322-2.161 6.483z"/><path d="m224 152a40.067 40.067 0 0 1 39.2 32h16.8v-24a64.082 64.082 0 0 0 -56.407-63.534c-3.066 32.242-23.438 58.826-50.574 68.048a39.844 39.844 0 0 1 10.981 27.486 40.045 40.045 0 0 1 40-40z"/><path d="m373.088 386.911h96v16h-96z" transform="matrix(.707 -.707 .707 .707 -155.911 413.421)"/><path d="m472 336a7.952 7.952 0 0 0 -5.657 2.343l-5.657 5.657 11.314 11.313 5.657-5.656a8 8 0 0 0 -5.657-13.657z"/><path d="m72 177.376a24 24 0 0 0 4.592 46.378 111.652 111.652 0 0 1 -4.592-31.754z"/><path d="m112.022 168h-24.022v16h16.805a39.841 39.841 0 0 1 7.217-16z"/><path d="m208 88a8 8 0 0 1 8-8 80.091 80.091 0 0 1 80 80v.805a39.841 39.841 0 0 1 16 7.217v-8.022a128 128 0 0 0 -256 0v8.022a39.841 39.841 0 0 1 16-7.217v-.805a8 8 0 0 1 8-8h72c30.878 0 56-28.71 56-64z"/><path d="m296 177.376v14.624a111.652 111.652 0 0 1 -4.592 31.754 24 24 0 0 0 4.592-46.378z"/><path d="m120 192a24 24 0 1 0 24-24 24.028 24.028 0 0 0 -24 24zm32 0a8 8 0 1 1 -8-8 8 8 0 0 1 8 8z"/>
                    </svg> Autores<!--Autores-->
                </td>
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
    <!--------------------------- Menu Prestamos ---------------------------------------->
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
    <!--------------------------- Menu Libros ---------------------------------------->
    <div id="libros">

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
                            <input type="text" class="inputs_libros">
                        </td>
                        <td class="columnas_formulario_libros">
                            <label>Titulo: </label>
                            <input type="text" class="inputs_libros">
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
                        <td class="columnas_formulario_libros" id="select_editorial">
                            Editorial: <select></select>
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
    <!--------------------------- Menu Editoriales ---------------------------------------->
    <div id="editoriales">

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
                            <input type="button" value="Agregar" class="inputs_editoriales" id="b_editorial">
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
                </tr>
            </table>
        </div>

    </div>
</body>
</html>