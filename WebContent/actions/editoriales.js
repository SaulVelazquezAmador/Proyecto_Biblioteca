jQuery(document).ready(function() {

    $("#formulario_bajas_editoriales").fadeOut(0);

    $("#pestaña_agregar").click(function(){
        $("#formulario_altas_editoriales").fadeIn(0);
        $("#formulario_bajas_editoriales").fadeOut(0);
    });

    $("#pestaña_eliminar").click(function(){
        $("#formulario_altas_editoriales").fadeOut(0);
        $("#formulario_bajas_editoriales").fadeIn(0);
    
    //******* Select con los nombres para baja *********************************************
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 61
            }, 
            function(responseText){
            $('#nom_baja_editorial').html(responseText);
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

        $.post('Altas_Editoriales', 
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
        
        $.post('Altas_Editoriales', 
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
});