jQuery(document).ready(function() {
    $("#autor_1").fadeOut(0);
    $("#autor_2").fadeOut(0);
    $("#autor_3").fadeOut(0);
    $("#autor_4").fadeOut(0);
    $("#autor_5").fadeOut(0);

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
//***********************************************************************
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
    $("#b_libros").click(function() {
        var isbn  = $("#isbn_lib").val();
        var titl  = $("#titulo_lib").val();
        var edit  = $("#sel_edit").val();
        var clas  = $("#sel_clasif").val();
        var subc  = $("#sel_subclasif").val();
        var autor = $("#numero_autores").val();
        var yr    = $("#year_lib")
        var ejem  = $("#ejemplares_lib").val();
        var ubc   = $("#ubicacion_libro").val();

        if (autor == 1){
            var au1  = $("#aut_1").val();
            $.post('Altas_Libros', 
                {
                    Autor1          : au1,
                    ISBN            : isbn,
                    Titulo          : titl,
                    Editorial       : edit,
                    Clasificacion   : clas,
                    Subclasificacion: subc,
                    NAutor          : autor,
                    Year            : yr,
                    Ejemplares      : ejem,
                    ubicacion       : ubc 
                },
                function(responseText) {
                    
            });
        }
        if (autor == 2){
            var au1  = $("#aut_1").val();
            var au2  = $("#aut_2").val();
        }
        if (autor == 3){
            var au1  = $("#aut_1").val();
            var au2  = $("#aut_2").val();
            var au3  = $("#aut_3").val();
        }
        if (autor == 4){
            var au1  = $("#aut_1").val();
            var au2  = $("#aut_2").val();
            var au3  = $("#aut_3").val();
            var au4  = $("#aut_4").val();
        }
        if (autor == 5){
            var au1  = $("#aut_1").val();
            var au2  = $("#aut_2").val();
            var au3  = $("#aut_3").val();
            var au4  = $("#aut_4").val();
            var au5  = $("#aut_5").val();
        }
    });
});