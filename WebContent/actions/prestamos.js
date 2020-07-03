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
});