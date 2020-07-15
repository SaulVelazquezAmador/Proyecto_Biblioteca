jQuery(document).ready(function() {
    var id_editorial = 0;

    $("#formulario_bajas_editoriales").fadeOut(0);
    $("#formulario_editar_editoriales").fadeOut(0);
    $("#pestaña_agregar").css('background-color', '#018A64');

    $("#pestaña_agregar").click(function(){
        $(this).css('background-color', '#018A64');
        $("#pestaña_eliminar").css('background-color', '#01a87a');
        $("#pestaña_editar").css('background-color', '#01a87a');
        $("#formulario_altas_editoriales").fadeIn(0);
        $("#formulario_bajas_editoriales").fadeOut(0);
        $("#formulario_editar_editoriales").fadeOut(0);
    });

    $("#pestaña_eliminar").click(function(){
        $(this).css('background-color', '#018A64');
        $("#pestaña_agregar").css('background-color', '#01a87a');
        $("#pestaña_editar").css('background-color', '#01a87a');
        $("#formulario_altas_editoriales").fadeOut(0);
        $("#formulario_bajas_editoriales").fadeIn(0);
        $("#formulario_editar_editoriales").fadeOut(0);
    //******* Select con los nombres para baja *********************************************
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 61
            }, 
            function(responseText){
            $('#nom_baja_editorial').html(responseText);
        });
    });
    //-----------------------------------------
    $("#pestaña_editar").click(function() {
        $(this).css('background-color', '#018A64');
        $("#pestaña_agregar").css('background-color', '#01a87a');
        $("#pestaña_eliminar").css('background-color', '#01a87a');
        $("#formulario_altas_editoriales").fadeOut(0);
        $("#formulario_bajas_editoriales").fadeOut(0);
        $("#formulario_editar_editoriales").fadeIn(0);  
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 62
            }, 
            function(responseText){
            $('#nom_edicion_editorial').html(responseText);
        });          
    });
//****************** Actualizamos los inputs con la editorial seleccionada *************************
    $("#nom_edicion_editorial").change(function() {
        var n_editorial = $("#nombre_edicion_editorial").val();
        if (n_editorial == "---------------------")
            return false;
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 63,
                editorial_edicion: n_editorial
            }, 
            function(responseText) {
                alert(responseText);
                $("#n_editorial3").val(responseText[0]);
                $("#c_editorial3").val(responseText[1]);
                id_editorial = responseText[2];
        });
    });
//******* Tabla de editoriales *************************************************
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 6
    }, function(responseText){
        $('#datos_editoriales').html(responseText);
    });
//********* da de alta una editorial *******************************************
    $("#alta_editorial").click(function() {

        var nom = $("#n_editorial").val();
        var ciu = $("#c_editorial").val();

        $.post('Servlet_Editoriales', 
        {
            peticion: 1,
            n_editorial: nom,
            n_ciudad: ciu
        }, 
        function(responseText) {
            
            if (responseText == 1) {
                alert("La editorial ya existe");
            }
            // si tuvo exito limpia los campos y actualiza la tabla
            if (responseText == 2) {
                alert("Registro exitoso!");
                $('input[type="text"]').val('');
                
                $.post('Servlet_Biblioteca', {
                    tipo_muestra: 6
                }, function(responseText){
                    $('#datos_editoriales').html(responseText);
                });
            }
        });
    });
//****************** Da de baja una editorial ***********************
    $("#eliminar_editorial").click(function() {
        var nombre = $("#nombre_baja_editorial").val();
        
        $.post('Servlet_Editoriales', 
            {
                peticion: 2,
                n_editorial: nombre
            }, function(responseText) {
                if (responseText == 1)
                    alert("La editorial tiene libros activos");
                
                if (responseText == 2) 
                    alert("Baja de editorial exitosa");
                
                $.post('Servlet_Biblioteca', 
                {
                    tipo_muestra: 6
                }, 
                    function(responseText){
                    $('#datos_editoriales').html(responseText);
                });           
        });
    });
//***************** Editar un editorial ***********************
    $("#editar_editorial").click(function() {

        var nom_e = $("#n_editorial3").val();
        var ciu   = $("#c_editorial3").val();

        $.post('Servlet_Editoriales', 
            {
                peticion: 3,
                id: id_editorial,
                n_editorial: nom_e,
                n_ciudad: ciu

            }, function() {
                alert("Modificación exitosa");

                $.post('Servlet_Biblioteca', {
                    tipo_muestra: 6
                }, function(responseText){
                    $('#datos_editoriales').html(responseText);
                });

                $.post('Servlet_Biblioteca', 
                    {
                        tipo_muestra: 62
                    }, 
                    function(responseText){
                    $('#nom_edicion_editorial').html(responseText);
                });  

                $('input[type="text"]').val('');
        });
    });
});