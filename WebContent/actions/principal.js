$(document).ready(function(){
    
    $("#op_1").click(function(){
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
    });
    $("#op_8").click(function(){
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
});