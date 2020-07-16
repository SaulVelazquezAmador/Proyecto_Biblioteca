$(document).ready(function() {
    var id = 0;
    var now = new Date();
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var today = now.getFullYear()+"-"+(month)+"-"+(day);
    var devolucion = now.getFullYear()+"-"+(month)+"-"+(now.getDate()+5);

    $.post('Servlet_Biblioteca', 
        {
            tipo_muestra: 29,
            hoy: today
        }, function() {

            $.post('Servlet_Biblioteca', {
                tipo_muestra: 23,
            }, function(responseText){
                $('#datos_prestamos').html(responseText);
            });

    });

//****** muestra/oculta los formularios**********
    $("#formulario_bajas_prestamos").fadeOut(0);
    $("#formulario_edicion_prestamos").fadeOut(0);
    $("#pestaña_agregar").css('background-color', '#018A64');

    $("#pestaña_agregar").click(function(){
        $(this).css('background-color', '#018A64');
        $("#pestaña_eliminar").css('background-color', '#01a87a');
        $("#pestaña_editar").css('background-color', '#01a87a');
        $("#formulario_altas_prestamos").fadeIn(0);
        $("#formulario_edicion_prestamos").fadeOut(0);
        $("#formulario_bajas_prestamos").fadeOut(0);
    });

    $("#pestaña_eliminar").click(function(){
        $(this).css('background-color', '#018A64');
        $("#pestaña_agregar").css('background-color', '#01a87a');
        $("#pestaña_editar").css('background-color', '#01a87a');
        $("#formulario_edicion_prestamos").fadeOut(0);
        $("#formulario_altas_prestamos").fadeOut(0);
        $("#formulario_bajas_prestamos").fadeIn(0);
    
        $.post('Servlet_Biblioteca', {
            tipo_muestra: 26
        }, function(responseText){
            $('#col_cliente_edicion').html(responseText);
        });
        $.post('Servlet_Biblioteca', {
            tipo_muestra: 24
        }, function(responseText){
            $('#nombre_baja_p').html(responseText);
        });
        var cte = $("#cliente_baja_prestamo").val();
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 25,
                n_completo: cte
            }, function(responseText) {
                $('#libro_baja_p').html(responseText);
        }); 
    });
    $("#pestaña_editar").click(function(){
        $(this).css('background-color', '#018A64');
        $("#pestaña_agregar").css('background-color', '#01a87a');
        $("#pestaña_eliminar").css('background-color', '#01a87a');
        $("#formulario_altas_prestamos").fadeOut(0);
        $("#formulario_bajas_prestamos").fadeOut(0);
        $("#formulario_edicion_prestamos").fadeIn(0);
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
        tipo_muestra: 23,
    }, function(responseText){
        $('#datos_prestamos').html(responseText);
    });
//******* Fecha de hoy ************************************
    $("#f_actual").val(today);
    $("#f_actual").prop('disabled', 'disabled');
    $("#f_devolucion").val(today);
    $("#f_devolucion").prop('disabled', 'disabled');
    $("#f_inicio3").prop('disabled', 'disabled');
    $("#f_devolucion3").prop('disabled', 'disabled');
//********************************************************
    $("#select_tipo").change(function() {
        var tipo = $("#prest_tipo").val();

        if (tipo == "Para Biblioteca") {
            $("#f_devolucion").val(today);       
        }
        else{
            $("#f_devolucion").val(devolucion);
        }
    });
//******* Alta de prestamos *******************************
    $("#alta_prestamos").click(function() {
        var nom = $("#prest_nombre").val();
        var lib = $("#prest_libro").val();
        var fa  = $("#f_actual").val();
        var fd  = $("#f_devolucion").val();
        var tip = $("#prest_tipo").val();

        if (tip == "---------------") {
            alert("Seleccione un tipo de prestamo");
            return false;
        }
        $.post('Servlet_Prestamos', 
            {
                peticion: 1,
                nombre: nom,
                libro: lib,
                f_actual : fa,
                f_devolucion: fd,
                tipo : tip
            }, 
            function(responseText) {
                if (responseText == 1) {
                    alert("No hay ejemplares disponibles");
                }
                if (responseText == 2) {
                    alert("El pestamo ya existe");
                }
                if (responseText == 3){
                    alert("Prestamo registrado exitosamente!");

                    $('input[type="text"]').val('');
                    
                    $.post('Servlet_Biblioteca', {
                        tipo_muestra: 23
                    }, function(responseText){
                        $('#datos_prestamos').html(responseText);
                    });
                }
        });
    });
//*********************************************************
//********* Zona de bajas *********************************
//*********************************************************
//******* Select de bajas *********************************
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 24
    }, function(responseText){
        $('#nombre_baja_p').html(responseText);
    });
//**Select de libros prestados al cliente *****************
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
//********** Baja de prestamos *****************************
    $("#baja_prestamos").click(function() {

        var nom = $("#cliente_baja_prestamo").val();
        var lib = $("#libro_baja_prestamo").val();

        $.post('Servlet_Prestamos', 
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
                //libros prestados por esa persona
                $.post('Servlet_Biblioteca', {
                    tipo_muestra: 26
                }, function(responseText){
                    $('#col_cliente_edicion').html(responseText);
                });
                $.post('Servlet_Biblioteca', {
                    tipo_muestra: 24
                }, function(responseText){
                    $('#nombre_baja_p').html(responseText);
                });
                var cte = $("#cliente_baja_prestamo").val();
                $.post('Servlet_Biblioteca', 
                    {
                        tipo_muestra: 25,
                        n_completo: cte
                    }, function(responseText) {
                        $('#libro_baja_p').html(responseText);
                }); 
        });
    });
//***********************************************************
//********* Zona de edicion *********************************
//***********************************************************
//******* Select de edicion *********************************
    $.post('Servlet_Biblioteca', {
        tipo_muestra: 26
    }, function(responseText){
        $('#col_cliente_edicion').html(responseText);
    });
//**Select de libros prestados al cliente *****************
    $("#col_cliente_edicion").change(function() {

        var cte = $("#sel_cliente_edicion").val();

        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 27,
                n_completo: cte
            }, function(responseText) {
                $('#col_libro_edicion').html(responseText);
                $("#select_tipo3").val("---------------");
                $("#select_tipo3").prop('disabled', 'disabled');
        });
    });

    $('#col_libro_edicion').change(function() {
        var cte = $("#sel_cliente_edicion").val();
        var lib = $("#sel_libro_edicion").val();

        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 28,
                n_completo: cte,
                titulo: lib
            }, function(responseText) 
            {
                $("#f_inicio3").val(responseText[0]);
                $("#f_devolucion3").val(responseText[1]);

                if (responseText[2] == "Para Biblioteca") {
                    $("#select_tipo3").prop('disabled', false);
                    $("#select_tipo3").val("Para Biblioteca");
                }
                    
                if (responseText[2] == "Para Casa")
                {
                    $("#select_tipo3").val("Para Casa");
                    $("#select_tipo3").prop('disabled', 'disabled');
                }
                id = responseText[3];
            });
    });

    $("#select_tipo3").change(function() {
        
        var tipo = $("#select_tipo3").val();
        
        if (tipo == "Para Casa") 
            $("#f_devolucion3").val(devolucion);
        
        if (tipo == "Para Biblioteca") 
            $("#f_devolucion3").val(today);       
    });

    $("#boton_edicion").click(function() {
        fech_d = $("#f_devolucion3").val();
        tip    = $("#select_tipo3").val();

        if (tip == "Para Biblioteca")
            return false;

        alert(fech_d);
        alert(tip);
        $.post('Servlet_Prestamos', 
            {
                peticion: 3,
                id_prestamo: id,
                f_devolucion: fech_d,
            }, function() {
                alert("Edicion exitosa");
                $("#select_tipo3").prop('disabled', 'disabled');

                $.post('Servlet_Biblioteca', {
                    tipo_muestra: 23
                }, function(responseText){
                    $('#datos_prestamos').html(responseText);
                });
            });
    });
});