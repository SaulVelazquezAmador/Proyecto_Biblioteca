jQuery(document).ready(function() {

    $.post('Servlet_Biblioteca', {
        tipo_muestra: 7
    }, function(responseText){
        $('#datos_autores').html(responseText);
    });
    // da de alta los autores
    $("#b_autores").click(function() {

        var nom_a = $("#nom_autor").val();
        var ap_a  = $("#ap_autor").val();
        var nac_a = $("#nac_autor").val();

        $.post('Altas_Autores', 
        {
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
});