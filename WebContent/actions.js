$(document).ready(function(){

		$(".usuario_registrado").fadeOut(0);
		$("#usuario_no_encontrado").fadeOut(0);
        $('#formulario_registro').fadeOut(0);
        $('#iniciar').css('background-color', '#01a87a');
        $('#iniciar').css('color', '#ffffffff');
//***************************************************************** */
        $('#iniciar').click(function(){
                $('#registrar').css('background-color', '#42515b');
                $('#registrar').css('color', '#a0b3b0');
                $(this).css('background-color', '#01a87a');
                $(this).css('color', '#ffffffff');
                $('#formulario_inicio').fadeIn(0);
                $('#formulario_registro').fadeOut(0);
        });
//***************************************************************** */
        $('#registrar').click(function(){
                $('#iniciar').css('background-color', '#42515b');
                $('#iniciar').css('color', '#a0b3b0');
                $(this).css('background-color', '#01a87a');
                $(this).css('color', '#ffffffff');
                $('#formulario_inicio').fadeOut(0);
                $('#formulario_registro').fadeIn(0);
        });
//***************************************************************** */
    	$("#f_registro").submit(function() {
    		
    		var nombreVar = $('#nombre').val();
    		var apellidoVar = $('#apellidos').val();
    		var correoVar = $('#correo').val();
    		var claveVar = $('#contrasena').val();

    		if (nombreVar == ""){
    			alert("Ingrese el nombre");
    			return false;
    		}
    		if (apellidoVar == ""){
    			alert("Ingrese los apellidos");
    			return false;
    		}
    		if (correoVar == ""){
    			alert("Ingrese el correo");
    			return false;
    		}
    		if (claveVar == ""){
    			alert("Ingrese la contraseña");
    			return false;
    		}
    		
    		$.post('Inicio_Registro', {
    			nombre  : nombreVar,
    			apellido: apellidoVar,
    			correo  : correoVar,
    			clave   : claveVar
    		}, function(responseText) {
    			
    			if (responseText == 2)
    				alert("Datos ya existentes");
    			else
					location.href="principal.jsp";
    		});
    		return false;
    	});
    	//***************************************************************** */
    	$("#f_inicio").submit(function() {
    		var correoVar1 = $('#input_correo').val();
    		var claveVar1 = $('#input_clave').val();

    		if (correoVar1 == ""){
    			alert("Ingrese el correo");
    			return false;
    		}
    		if (claveVar1 == ""){
    			alert("Ingrese la contraseña");
    			return false;
    		}
    		$.post('Inicio_Registro', {
    			correo_ini  : correoVar1,
    			clave_ini   : claveVar1
    		}, function(responseText) {
    			
    			if(responseText == 1)
    				alert("Usuario y/o contraseña incorrectos")
    			else
					location.href="principal.jsp";
    		});
    		return false;
    	});
});