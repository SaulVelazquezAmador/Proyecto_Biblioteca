jQuery(document).ready(function() {
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 6
    }, function(responseText){
        $('#datos_editoriales').html(responseText);
    });
    // da de alta una editorial
    $("#b_editorial").click(function() {

        var nom = $("#n_editorial").val();
        var ciu = $("#c_editorial").val();

        $.post('Altas_Editoriales', 
        {
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
});