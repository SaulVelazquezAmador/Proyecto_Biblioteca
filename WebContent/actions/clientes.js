$(document).ready(function() {

    var id_cliente = 0;

    $("#formulario_bajas_clientes").fadeOut(0);
    $("#formulario_editar_clientes").fadeOut(0);
    $("#pestaña_agregar").css('background-color', '#018A64');

    $("#pestaña_agregar").click(function(){
        $(this).css('background-color', '#018A64');
        $("#pestaña_eliminar").css('background-color', '#01a87a');
        $("#pestaña_editar").css('background-color', '#01a87a');
        $("#formulario_altas_clientes").fadeIn(0);
        $("#formulario_bajas_clientes").fadeOut(0);
        $("#formulario_editar_clientes").fadeOut(0);
    });

    $("#pestaña_eliminar").click(function(){
        $(this).css('background-color', '#018A64');
        $("#pestaña_agregar").css('background-color', '#01a87a');
        $("#pestaña_editar").css('background-color', '#01a87a');
        $("#formulario_altas_clientes").fadeOut(0);
        $("#formulario_editar_clientes").fadeOut(0);
        $("#formulario_bajas_clientes").fadeIn(0);
    //******* Select con los nombres para baja *********************************************
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 41
            }, 
            function(responseText){
            $('#nombre_baja').html(responseText);
        });
    });

    $("#pestaña_editar").click(function() {
        $(this).css('background-color', '#018A64');
        $("#pestaña_agregar").css('background-color', '#01a87a');
        $("#pestaña_eliminar").css('background-color', '#01a87a');
        $("#formulario_altas_clientes").fadeOut(0);
        $("#formulario_editar_clientes").fadeIn(0);
        $("#formulario_bajas_clientes").fadeOut(0); 

        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 42
            }, 
            function(responseText){
            $('#nombre_edicion_cliente').html(responseText);
        });          
    });
// Actualiza los datos del cliente que se va a editar cuando cambia el select del nombre
    $("#nombre_edicion_cliente").change(function() {
        var n_cliente = $("#nom_edicion_cliente").val();
        
        $.post('Servlet_Biblioteca', 
            {
                tipo_muestra: 43,
                cliente_edicion: n_cliente
            }, 
            function(responseText) {
                $("#nom_cliente3").val(responseText[0]);
                $("#ap_cliente3").val(responseText[1]);
                $("#edad_cliente3").val(responseText[2]);
                $("#direccion_cliente3").val(responseText[3]);
                $("#correo_cliente3").val(responseText[4]);
                $("#telefono_cliente3").val(responseText[5]);
                id_cliente = responseText[6];
        });
    });
//Actualiza la tabla de los clientes
    $.post('Servlet_Biblioteca', 
        {
            tipo_muestra: 4
        }, 
        function(responseText){
        $('#datos_clientes').html(responseText);
    });
//************** Alta de cliente *****************************************************
    $("#agregar_cliente").click(function() {

        var nom  = $("#nom_cliente").val();
        var ap   = $("#ap_cliente").val();
        var ed   = $("#edad_cliente").val();
        var dir  = $("#direccion_cliente").val();
        var corr = $("#correo_cliente").val();
        var tel  = $("#telefono_cliente").val();

        if (isNaN(ed) == true){
            alert("Ingrese un numero en la edad");
            $("#edad_cliente").focus();
            return false
        }
        if (isNaN(tel) == true){
            alert("Ingrese solo numeros en el telefono");
            $("#telefono_cliente").focus();
            return false
        }

        $.post('Servlet_Clientes', 
        {
            peticion: 1,
            n_cliente: nom,
            a_cliente: ap,
            e_cliente: ed,
            d_cliente: dir,
            c_cliente: corr,
            t_cliente: tel
        }, 
        function(responseText) {
            // si tuvo exito limpia los campos y actualiza la tabla
            if (responseText == 1) {
                alert("Registro exitoso!");
                $('input[type="text"]').val('');  

                $.post('Servlet_Biblioteca', 
                {
                    tipo_muestra: 4
                }, 
                    function(responseText){
                    $('#datos_clientes').html(responseText);
                });               
            }
            else{
                alert("El cliente ya existe");
            }
        });
    });

//********** Baja de cliente *************************************************
    $("#eliminar_cliente").click(function(){
        var nom = $("#sel_baja_cliente").val();

        $.post('Servlet_Clientes',
        {
            peticion: 2,
            nom_baja: nom
        },
            function(responseText){
                if (responseText == 1)
                    alert("El cliene tiene prestamos pendientes");
                if (responseText == 2) 
                    alert("Baja de cliente exitosa");
                
                $.post('Servlet_Biblioteca', 
                {
                	tipo_muestra: 4
                }, 
                 	function(responseText){
                	$('#datos_clientes').html(responseText);
                });
        });
    });
//************ Editar cliente *************************************
    $("#editar_cliente").click(function() {
        var nom  = $("#nom_cliente3").val();
        var ap   = $("#ap_cliente3").val();
        var ed   = $("#edad_cliente3").val();
        var dir  = $("#direccion_cliente3").val();
        var corr = $("#correo_cliente3").val();
        var tel  = $("#telefono_cliente3").val();

        if (isNaN(ed) == true){
            alert("Ingrese un numero en la edad");
            $("#edad_cliente").focus();
            return false
        }
        if (isNaN(tel) == true){
            alert("Ingrese solo numeros en el telefono");
            $("#telefono_cliente").focus();
            return false
        }

        $.post('Servlet_Clientes', 
        {
            peticion: 3,
            n_cliente: nom,
            a_cliente: ap,
            e_cliente: ed,
            d_cliente: dir,
            c_cliente: corr,
            t_cliente: tel,
            i_cliente: id_cliente
        }, 
        function(responseText) {
            // si tuvo exito limpia los campos y actualiza la tabla

            alert("Modificación exitosa");

            $.post('Servlet_Biblioteca', {
                tipo_muestra: 4
            }, function(responseText){
                $('#datos_clientes').html(responseText);
            });

            $.post('Servlet_Biblioteca', 
                {
                    tipo_muestra: 42
                }, 
                function(responseText){
                $('#nom_edicion_cliente').html(responseText);
            });  

            $('input[type="text"]').val(''); 
        });
    });
});
    