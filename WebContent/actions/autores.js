$(document).ready(function() {

    $("#formulario_bajas_autores").fadeOut(0);

    $("#pestaña_agregar").click(function(){
        $("#formulario_altas_autores").fadeIn(0);
        $("#formulario_bajas_autores").fadeOut(0);
    });

    $("#pestaña_eliminar").click(function(){
        $("#formulario_altas_autores").fadeOut(0);
        $("#formulario_bajas_autores").fadeIn(0);
    //******* Select con los nombres para baja *********************************************
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 71
            }, 
            function(responseText){
            $('#nom_baja_autor').html(responseText);
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
});