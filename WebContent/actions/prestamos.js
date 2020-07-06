$(document).ready(function() {

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

    $("#b_prestamos").click(function() {
        var nom = $("#prest_nombre").val();
        var lib = $("#prest_libro").val();
        var fa  = $("#f_actual").val();
        var fd  = $("#f_devolucion").val();
        var tip = $("#prest_tipo").val();
        let correo = localStorage.getItem("correo");

        $.post('Altas_Prestamos', 
            {
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
                }
                else
                    alert("Prestamo ya en existencia");
        });
    });
});