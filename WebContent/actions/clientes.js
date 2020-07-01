$(document).ready(function() {
    // da de alta una editorial
    $("#b_clientes").click(function() {

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
            }
            else{
                alert("El cliente ya existe");
            }
        });
    });
});    
    