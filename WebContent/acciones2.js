$(document).ready(function(){

    $("#prestamos").fadeOut(0);
    $("#libros").fadeOut(0);
    $("#editoriales").fadeOut(0);
    
    $("#op_1").click(function(){
        $("#libros").fadeOut(0);
        $("#prestamos").fadeOut(0);
        $("#editoriales").fadeOut(0);
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
        $("#libros").fadeOut(0);
        $("#editoriales").fadeOut(0);
        $("#prestamos").fadeIn(0);
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
    });
    //muestra libros
    $("#op_3").click(function(){
        $("#libros").fadeIn(0);
        $("#editoriales").fadeOut(0);
        $("#prestamos").fadeOut(0);
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
    });
    $("#op_4").click(function(){
        $("#libros").fadeOut(0);
        $("#editoriales").fadeOut(0);
        $("#prestamos").fadeOut(0);
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
        $("#libros").fadeOut(0);
        $("#prestamos").fadeOut(0);
        $("#editoriales").fadeIn(0);
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
    $("#op_7").click(function(){
        $("#libros").fadeOut(0);
        $("#prestamos").fadeOut(0);
        $("#editoriales").fadeOut(0);
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
    });
    $("#op_8").click(function(){
        $("#libros").fadeOut(0);
        $("#prestamos").fadeOut(0);
        $("#editoriales").fadeOut(0);
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
    });

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