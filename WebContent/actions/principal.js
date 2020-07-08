$(document).ready(function(){

    if (localStorage.getItem("correo")) {
        let correo = localStorage.getItem("correo");
        let clave = localStorage.getItem("clave");       
    }
    else{
        alert("Debe iniciar sesión")
        location.href="index.jsp";
    }


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
    });
    /*   Clientes  */    
    $("#op_4").click(function(){
        $('#vistas').load("views/clientes.jsp");
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
    });
    /*   Editoriales  */
    $("#op_5").click(function(){
        $('#vistas').load("views/editoriales.jsp");
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
    });
    //    muestra autores
    $("#op_6").click(function(){
        $('#vistas').load("views/autores.jsp");
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
    });

    $("#op_7").click(function(){
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        $("#op_9").css('background-color', '#222222');
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
    });
    $("#op_9").click(function(){
        $(this).css('background-color', '#23303e');
        $("#op_1").css('background-color', '#222222');
        $("#op_2").css('background-color', '#222222');
        $("#op_3").css('background-color', '#222222');
        $("#op_4").css('background-color', '#222222');
        $("#op_5").css('background-color', '#222222');
        $("#op_6").css('background-color', '#222222');
        $("#op_7").css('background-color', '#222222');
        $("#op_8").css('background-color', '#222222');
        localStorage.clear();
        location.href="index.jsp";
    });
});