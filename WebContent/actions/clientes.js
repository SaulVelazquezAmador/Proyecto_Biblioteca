$(document).ready(function() {

//******* Tabla de los clientes ***********************************************
    $.post('Servlet_Biblioteca', 
        {
            tipo_muestra: 4
        }, 
        function(responseText){
        $('#datos_clientes').html(responseText);
    });

    $("#formulario_bajas_clientes").fadeOut(0);

    $("#pestaña_agregar").click(function(){
        $("#formulario_altas_clientes").fadeIn(0);
        $("#formulario_bajas_clientes").fadeOut(0);
    });

    $("#pestaña_eliminar").click(function(){
        $("#formulario_altas_clientes").fadeOut(0);
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
//******** Alta de cliente *****************************************************
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

        $.post('Altas_Clientes', 
        {
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

        $.post('Altas_Clientes',
        {
            peticion: 2,
            nom_baja: nom
        },
            function(){
                alert("hecho");
                $.post('Servlet_Biblioteca', 
                {
                	tipo_muestra: 4
                }, 
                 	function(responseText){
                	$('#datos_clientes').html(responseText);
                });
        });
    });
});    
    