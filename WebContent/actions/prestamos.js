$(document).ready(function() {
//****** muestra/oculta los formularios**********
    $("#formulario_bajas_prestamos").fadeOut(0);

    $("#pestaña_agregar_p").click(function(){
        $("#formulario_altas_prestamos").fadeIn(0);
        $("#formulario_bajas_prestamos").fadeOut(0);
    });

    $("#pestaña_eliminar_p").click(function(){
        $("#formulario_altas_prestamos").fadeOut(0);
        $("#formulario_bajas_prestamos").fadeIn(0);
    });
//****** Actualiza los select **********
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 20
    }, function(responseText){
        $('#select_nombre').html(responseText);
    });

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 21
    }, function(responseText){
        $('#select_libro').html(responseText);
    });

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 22
    }, function(responseText){
        $('#select_tipo').html(responseText);
    });

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 23
    }, function(responseText){
        $('#datos_prestamos').html(responseText);
    });
//******* Select de bajas *********************************
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 24
    }, function(responseText){
        $('#nombre_baja_p').html(responseText);
    });
//************** Select de libros prestados al cliente ******************************
    $("#nombre_baja_p").change(function() {
        var cte = $("#cliente_baja_prestamo").val();
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 25,
                n_completo: cte
            }, function(responseText) {
                $('#libro_baja_p').html(responseText);
        });
    });
//******* Alta de prestamos *******************************
    $("#alta_prestamos").click(function() {
        var nom = $("#prest_nombre").val();
        var lib = $("#prest_libro").val();
        var fa  = $("#f_actual").val();
        var fd  = $("#f_devolucion").val();
        var tip = $("#prest_tipo").val();
        let correo = localStorage.getItem("correo");

        $.post('Altas_Prestamos', 
            {
                peticion: 1,
                bibliotecario: correo,
                nombre: nom,
                libro: lib,
                f_actual : fa,
                f_devolucion: fd,
                tipo : tip
            }, 
            function(responseText) {
                if (responseText == 2){
                    alert("Prestamo registrado exitosamente!");
                    $('input[type="text"]').val('');
                    
                    $.post('Servlet_Biblioteca', {
                        tipo_muestra: 23
                    }, function(responseText){
                        $('#datos_prestamos').html(responseText);
                    });
                }
                else
                    alert("Prestamo ya en existencia");
        });
    });
//********** Baja de prestamos *****************************
    $("#baja_prestamos").click(function() {

        var nom = $("#cliente_baja_prestamo").val();
        var lib = $("#libro_baja_prestamo").val();

        $.post('Altas_Prestamos', 
            {
                peticion: 2,
                nombre: nom,
                libro: lib
            }, function() {

                alert("Baja exitosa!");
                
                $.post('Servlet_Biblioteca', {
                    tipo_muestra: 23
                }, function(responseText){
                    $('#datos_prestamos').html(responseText);
                });                
        });
    });
});