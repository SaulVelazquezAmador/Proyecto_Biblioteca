$(document).ready(function(){

    $("#prestamos").fadeOut(0);
    $("#libros").fadeOut(0);
    $("#editoriales").fadeOut(0);
    $("#autores").fadeOut(0);
    
    $("#op_1").click(function(){
        $("#libros").fadeOut(0);
        $("#prestamos").fadeOut(0);
        $("#editoriales").fadeOut(0);
        $("#autores").fadeOut(0);
        $(this).css('background-color', '#23303e');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
        $("#op_10").css('background-color', '#222222');
    });
    //muestra prestamos
    $("#op_2").click(function(){
        $('#vistas').load("views/prestamos.jsp");
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
        $("#op_10").css('background-color', '#222222');
        /*
        $("#libros").fadeOut(0);
        $("#editoriales").fadeOut(0);
        $("#prestamos").fadeIn(0);
        $("#autores").fadeOut(0);*/
    });
    //muestra libros
    $("#op_3").click(function(){
        $('#vistas').load("views/libros.jsp");
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
        $("#op_10").css('background-color', '#222222');

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
            tipo_muestra: 300
        }, function(responseText){
            $('#select_autores').html(responseText);
        });
    });
    $("#op_4").click(function(){
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
        $("#op_10").css('background-color', '#222222');
    });
    $("#op_5").click(function(){
        $("#libros").fadeOut(0);
        $("#editoriales").fadeOut(0);
        $("#prestamos").fadeOut(0);
        $("#autores").fadeOut(0);
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
        $("#op_10").css('background-color', '#222222');
    });
    /*   Editoriales  */
    $("#op_6").click(function(){
        $('#vistas').load("views/editoriales.jsp");
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
        $("#op_10").css('background-color', '#222222');

        $.post('Servlet_Biblioteca', {
            tipo_muestra: 6
        }, function(responseText){
            $('#datos_editoriales').html(responseText);
        });

    });
    //    muestra autores
    $("#op_7").click(function(){
        $('#vistas').load("views/autores.jsp");
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
        $("#op_10").css('background-color', '#222222');
        
        $.post('Servlet_Biblioteca', {
            tipo_muestra: 7
        }, function(responseText){
            $('#datos_autores').html(responseText);
        });
    });
    $("#op_8").click(function(){
        $("#libros").fadeOut(0);
        $("#prestamos").fadeOut(0);
        $("#editoriales").fadeOut(0);
        $("#autores").fadeOut(0);
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
        $("#op_10").css('background-color', '#222222');
    });
    $("#op_9").click(function(){
        $("#libros").fadeOut(0);
        $("#prestamos").fadeOut(0);
        $("#editoriales").fadeOut(0);
        $("#autores").fadeOut(0);
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_10").css('background-color', '#222222');
    });
    $("#op_10").click(function(){
        $("#libros").fadeOut(0);
        $("#prestamos").fadeOut(0);
        $("#editoriales").fadeOut(0);
        $("#autores").fadeOut(0);
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
        location.href="login.html";
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
    // da de alta una editorial
    $("#b_editorial").click(function() {

        var nom = $("#n_editorial").val();
        var ciu = $("#c_editorial").val();

        $.post('Servlet_Biblioteca', 
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
    // da de alta los autores
    $("#b_autores").click(function() {

        var nom_a = $("#nom_autor").val();
        var ap_a  = $("#ap_autor").val();
        var nac_a = $("#nac_autor").val();

        $.post('Servlet_Biblioteca', 
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

/*
*/