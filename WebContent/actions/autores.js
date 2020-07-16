$(document).ready(function() {
    var id_autor = 0;

    $("#formulario_bajas_autores").fadeOut(0);
    $("#formulario_editar_autores").fadeOut(0);
    $("#pestaña_agregar").css('background-color', '#018A64');
    //-----------------------------------------
    $("#pestaña_agregar").click(function(){
        $(this).css('background-color', '#018A64');
        $("#pestaña_eliminar").css('background-color', '#01a87a');
        $("#pestaña_editar").css('background-color', '#01a87a');
        $("#formulario_altas_autores").fadeIn(0);
        $("#formulario_bajas_autores").fadeOut(0);
        $("#formulario_editar_autores").fadeOut(0);
    });
    //-----------------------------------------
    $("#pestaña_eliminar").click(function(){
        $(this).css('background-color', '#018A64');
        $("#pestaña_agregar").css('background-color', '#01a87a');
        $("#pestaña_editar").css('background-color', '#01a87a');
        $("#formulario_altas_autores").fadeOut(0);
        $("#formulario_editar_autores").fadeOut(0);
        $("#formulario_bajas_autores").fadeIn(0);

        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 71
            }, 
            function(responseText){
            $('#nom_baja_autor').html(responseText);
        });
    });  
    //-----------------------------------------
    $("#pestaña_editar").click(function() {
        $(this).css('background-color', '#018A64');
        $("#pestaña_agregar").css('background-color', '#01a87a');
        $("#pestaña_eliminar").css('background-color', '#01a87a');
        $("#formulario_altas_autores").fadeOut(0);
        $("#formulario_bajas_autores").fadeOut(0);
        $("#formulario_editar_autores").fadeIn(0);  
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 72
            }, 
            function(responseText){
            $('#nom_edicion_autor').html(responseText);
        });            
    });  
//*******************************************
    $("#nom_edicion_autor").change(function() {
        var n_autor = $("#nombre_edicion_autor").val();
        
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 73,
                autor_edicion: n_autor
            }, 
            function(responseText) {
                $("#nom3_autor").val(responseText[0]);
                $("#ap3_autor").val(responseText[1]);
                $("#nac3_autor").val(responseText[2]);
                id_autor = responseText[3];
        });
    });
//*****  Tabla de autores  ******************
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 7
    }, function(responseText){
        $('#datos_autores').html(responseText);
    });
//******** da de alta los autores ************
    $("#b_autores").click(function() {

        var nom_a = $("#nom_autor").val();
        var ap_a  = $("#ap_autor").val();
        var nac_a = $("#nac_autor").val();
        
        $.post('Servlet_Autores', 
        {
            peticion: 1,
            nombre_autor: nom_a,
            apellido_autor: ap_a,
            nacionalidad_autor: nac_a
        }, 
        function(responseText) {
            if (responseText == 1) {
                alert("El autor ya existe");
            }
            if (responseText == 2) {
                alert("Registro exitoso!");
                $('input[type="text"]').val('');

                $.post('Servlet_Biblioteca', {
                    tipo_muestra: 7
                }, function(responseText){
                    $('#datos_autores').html(responseText);
                });
            }
        });
    });
//****************** Da de baja un autor ***********************
    $("#eliminar_autor").click(function() {
        var respuesta = window.confirm("¿Desea darse de baja?");

        if (respuesta == false) {
            return false;
        }
        
        var nombre = $("#nombre_baja_autor").val();
        $.post('Servlet_Autores', 
            {
                peticion: 2,
                n_autor: nombre
            }, function(responseText) {
                if (responseText == 1)
                    alert("La autor tiene libros activos");
                
                if (responseText == 2) 
                    alert("Baja de autor exitosa");
                
                $.post('Servlet_Biblioteca', 
                {
                    tipo_muestra: 7
                }, 
                    function(responseText){
                    $('#datos_autores').html(responseText);
                });           
        });
    });
//***************** Editar un autor ***********************
    $("#editar_autor").click(function() {
        var nom_a = $("#nom3_autor").val();
        var ap_a  = $("#ap3_autor").val();
        var nac_a = $("#nac3_autor").val();
        
        $.post('Servlet_Autores', 
            {
                peticion: 3,
                id: id_autor,
                nombre_autor: nom_a,
                apellido_autor: ap_a,
                nacionalidad_autor: nac_a
            }, function() {
                alert("Modificación exitosa");

                $.post('Servlet_Biblioteca', {
                    tipo_muestra: 7
                }, function(responseText){
                    $('#datos_autores').html(responseText);
                });

                $.post('Servlet_Biblioteca', 
                    {
                        tipo_muestra: 72
                    }, 
                    function(responseText){
                    $('#nom_edicion_autor').html(responseText);
                });  

                $('input[type="text"]').val('');
        });
    });
});