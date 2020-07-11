jQuery(document).ready(function() {

//***** Pestañas de Agregar/Eliminar/Editar los libros
    $("#formulario_bajas_libros").fadeOut(0);

    $("#pestaña_agregar_lib").click(function(){
        $("#formulario_altas_libros").fadeIn(0);
        $("#formulario_bajas_libros").fadeOut(0);
    });

    $("#pestaña_eliminar_lib").click(function(){
        $("#formulario_altas_libros").fadeOut(0);
        $("#formulario_bajas_libros").fadeIn(0);
    });
//**  Selects de autores ******
    $("#autor_1").fadeOut(0);
    $("#autor_2").fadeOut(0);
    $("#autor_3").fadeOut(0);
    $("#autor_4").fadeOut(0);
    $("#autor_5").fadeOut(0);

//******  Selects de alta de libro  ************ 
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 3
    }, function(responseText){
        $('#select_clasificacion').html(responseText);
    });

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 30
    }, function(responseText){
        $('#select_editorial').html(responseText);
    });

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 301
    }, function(responseText){
        $('#autor_1').html(responseText);
    });

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 302
    }, function(responseText){
        $('#autor_2').html(responseText);
    });

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 303
    }, function(responseText){
        $('#autor_3').html(responseText);
    });

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 304
    }, function(responseText){
        $('#autor_4').html(responseText);
    });

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 305
    }, function(responseText){
        $('#autor_5').html(responseText);
    });
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 306
    }, function(responseText){
        $('#ubicacion').html(responseText);
    });
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 307
    }, function(responseText){
        $('#datos_libros').html(responseText);
    });
    //actualiza select de las clasificaciones de los libros
    $("#select_clasificacion").change(function(){
        var subclasificacion = $("#sel_clasif").val();
        $.post('Servlet_Biblioteca', 
        {
           sub_clas: subclasificacion
        }, 
        function(responseText){
            $('#select_subclasificacion').html(responseText);
        });
    });
//******* Select de bajas *********************************
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 308
    }, function(responseText){
        $('#nombre_baja_libro').html(responseText);
    });
//************** Select de numero de autores  *****************************
    $("#col_select_autores").change(function() {
        var valor = $("#numero_autores").val();
        if (valor == 1) {
            $("#autor_1").fadeIn(0);
            $("#autor_2").fadeOut(0);
            $("#autor_3").fadeOut(0);
            $("#autor_4").fadeOut(0);
            $("#autor_5").fadeOut(0);
        }
        if (valor == 2) {
            $("#autor_1").fadeIn(0);
            $("#autor_2").fadeIn(0);
            $("#autor_3").fadeOut(0);
            $("#autor_4").fadeOut(0);
            $("#autor_5").fadeOut(0);
        }
        if (valor == 3) {
            $("#autor_1").fadeIn(0);
            $("#autor_2").fadeIn(0);
            $("#autor_3").fadeIn(0);
            $("#autor_4").fadeOut(0);
            $("#autor_5").fadeOut(0);
        }
        if (valor == 4) {
            $("#autor_1").fadeIn(0);
            $("#autor_2").fadeIn(0);
            $("#autor_3").fadeIn(0);
            $("#autor_4").fadeIn(0);
            $("#autor_5").fadeOut(0);
        }
        if (valor == 5) {
            $("#autor_1").fadeIn(0);
            $("#autor_2").fadeIn(0);
            $("#autor_3").fadeIn(0);
            $("#autor_4").fadeIn(0);
            $("#autor_5").fadeIn(0);
        }
    });
//*******  ALta de libro  ********************
    $("#b_libros").click(function() {
        var isbn  = $("#isbn_lib").val();
        var titl  = $("#titulo_lib").val();
        var edit  = $("#sel_edit").val();
        var clas  = $("#sel_clasif").val();
        var subc  = $("#sel_subclasif").val();
        var autor = $("#numero_autores").val();
        var yr    = $("#year_lib").val();
        var ejem  = $("#ejemplares_lib").val();
        var ubc   = $("#ubicacion_libro").val();
        var na    = "NA";

        if (autor == 1){
            var au1  = $("#aut_1").val();
            $.post('Altas_Libros', 
            {
                peticion: 1,
                Autor1: au1,
                Autor2: na,
                Autor3: na,
                Autor4: na,
                Autor5: na,
                ISBN: isbn,
                Titulo: titl,
                Editorial: edit,
                Clasificacion: clas,
                Subclasificacion: subc,
                NAutor: autor,
                Year: yr,
                Ejemplares: ejem,
                Ubicacion: ubc 
            },
            function(responseText) 
            {
                if (responseText == 1){
                    alert("Libro registrado exitosamente!");
                    $('input[type="text"]').val('');

                        $.post('Servlet_Biblioteca', {
                            tipo_muestra: 307
                        }, function(responseText){
                            $('#datos_libros').html(responseText);
                        });
                }
                else{
                    alert("Libro ya en existencia");
                }
            });
        }
    //***********************************************************
        if (autor == 2){
            alert("2 autores");
            var au1  = $("#aut_1").val();
            var au2  = $("#aut_2").val();
            $.post('Altas_Libros', 
            {
                peticion: 1,
                Autor1: au1,
                Autor2: au2,
                Autor3: na,
                Autor4: na,
                Autor5: na,
                ISBN: isbn,
                Titulo: titl,
                Editorial: edit,
                Clasificacion: clas,
                Subclasificacion: subc,
                NAutor: autor,
                Year: yr,
                Ejemplares: ejem,
                Ubicacion: ubc 
            },
            function(responseText) 
            {
                if (responseText == 1){
                    alert("Libro registrado exitosamente!");
                    $('input[type="text"]').val('');

                    $.post('Servlet_Biblioteca', {
                        tipo_muestra: 307
                    }, function(responseText){
                        $('#datos_libros').html(responseText);
                    });
                }
                else{
                    alert("Libro ya en existencia");
                }
            });
        }
    //***********************************************************
        if (autor == 3){
            var au1  = $("#aut_1").val();
            var au2  = $("#aut_2").val();
            var au3  = $("#aut_3").val();
            $.post('Altas_Libros', 
            {
                peticion: 1,
                Autor1: au1,
                Autor2: au2,
                Autor3: au3,
                Autor4: na,
                Autor5: na,
                ISBN: isbn,
                Titulo: titl,
                Editorial: edit,
                Clasificacion: clas,
                Subclasificacion: subc,
                NAutor: autor,
                Year: yr,
                Ejemplares: ejem,
                Ubicacion: ubc 
            },
            function(responseText) 
            {
                if (responseText == 1){
                    alert("Libro registrado exitosamente!");
                    $('input[type="text"]').val('');
                    
                    $.post('Servlet_Biblioteca', {
                        tipo_muestra: 307
                    }, function(responseText){
                        $('#datos_libros').html(responseText);
                    });
                }
                else{
                    alert("Libro ya en existencia");
                }
            });
        }
    //***********************************************************
        if (autor == 4){
            var au1  = $("#aut_1").val();
            var au2  = $("#aut_2").val();
            var au3  = $("#aut_3").val();
            var au4  = $("#aut_4").val();
            $.post('Altas_Libros', 
            {
                peticion: 1,
                Autor1: au1,
                Autor2: au2,
                Autor3: au3,
                Autor4: au4,
                Autor5: na,
                ISBN: isbn,
                Titulo: titl,
                Editorial: edit,
                Clasificacion: clas,
                Subclasificacion: subc,
                NAutor: autor,
                Year: yr,
                Ejemplares: ejem,
                Ubicacion: ubc 
            },
            function(responseText) 
            {
                if (responseText == 1){
                    alert("Libro registrado exitosamente!");
                    $('input[type="text"]').val('');

                    $.post('Servlet_Biblioteca', {
                        tipo_muestra: 307
                    }, function(responseText){
                        $('#datos_libros').html(responseText);
                    });
                }
                else{
                    alert("Libro ya en existencia");
                }
            });
        }
    //***********************************************************
        if (autor == 5){
            var au1  = $("#aut_1").val();
            var au2  = $("#aut_2").val();
            var au3  = $("#aut_3").val();
            var au4  = $("#aut_4").val();
            var au5  = $("#aut_5").val();
            $.post('Altas_Libros', 
            {
                peticion: 1,
                Autor1: au1,
                Autor2: au2,
                Autor3: au3,
                Autor4: au4,
                Autor5: au5,
                ISBN: isbn,
                Titulo: titl,
                Editorial: edit,
                Clasificacion: clas,
                Subclasificacion: subc,
                NAutor: autor,
                Year: yr,
                Ejemplares: ejem,
                Ubicacion: ubc 
            },
            function(responseText) 
            {
                if (responseText == 1){
                    alert("Libro registrado exitosamente!");
                    $('input[type="text"]').val('');

                    $.post('Servlet_Biblioteca', {
                        tipo_muestra: 307
                    }, function(responseText){
                        $('#datos_libros').html(responseText);
                    });
                }
                else{
                    alert("Libro ya en existencia");
                }
            });
        }
    });
//*******  Baja de libro  ********************  
    $("#boton_baja_libros").click(function() {
        var lib = $("#titulo_baja_libro").val();

        $.post('Altas_Libros', 
            {
                peticion: 2,
                Titulo: lib
            }, function(responseText) {
                if (responseText == 1)
                    alert("Hay ejemplare en prestamo");

                if (responseText == 2)
                    alert("Baja de libro exitosa");

                    $.post('Servlet_Biblioteca', {
                        tipo_muestra: 307
                    }, function(responseText){
                        $('#datos_libros').html(responseText);
                    });
        });
    });
});