$(document).ready(function() {

	$("#ficha_edicion").fadeOut(0);

//----------------------------------------------------------------------------------------------------------
	let mail = localStorage.getItem("correo");
	let clave = localStorage.getItem("clave");
	let id = 0;
//----------------------------------------------------------------------------------------------------------
	$.post('Servlet_Biblioteca', 
	{
		tipo_muestra: 8,
		Correo: mail,
		Clave: clave
	}, function(responseText) 
	{
		$("#nombre").text("Nombre: " + responseText[0] + " " + responseText[1] + " " + responseText[2]);
		$("#correo").text("Correo electronico: " + responseText[3]);
		id = responseText[5];
	});
//----------------------------------------------------------------------------------------------------------
	$("#boton_editar1").click(function() {
		$("#ficha_principal").fadeOut(0);
		$("#ficha_edicion").fadeIn(0);
		$.post('Servlet_Biblioteca', 
		{
			tipo_muestra: 8,
			Correo: mail,
			Clave: clave
		}, function(responseText) 
		{
			$("#edit_nombre").val(responseText[0]);
			$("#edit_apellido_p").val(responseText[1]);
			$("#edit_apellido_m").val(responseText[2]);
			$("#edit_correo").val(responseText[3]);
			$("#edit_clave").val(responseText[4]);
		});
	});
//----------------------------------------------------------------------------------------------------------
	$("#boton_baja").click(function() {
		var respuesta = window.confirm("Save data?");
		if (respuesta == false) {
			return false;
		}
		else{

			$.post('Servlet_Usuarios', 
				{
					peticion: 2,
					ID: id
				}, function() {
					alert("Baja exitosa");
					location.href="index.jsp";
			});
		}
	});
//----------------------------------------------------------------------------------------------------------
	$("#boton_editar2").click(function() {
		
		var nom  = $("#edit_nombre").val();
		var ap1  = $("#edit_apellido_p").val();
		var ap2  = $("#edit_apellido_m").val();
		var corr = $("#edit_correo").val();
		var clav = $("#edit_clave").val();
	
		$.post('Servlet_Usuarios', 
			{
				peticion: 1,
				ID: id,
				nombre: nom,
				apellido_paterno: ap1,
				apellido_materno: ap2,
				correo: corr,
				clave: clav
			}, function() {

				$("#ficha_edicion").fadeOut(0);	
				$("#ficha_principal").fadeIn(0);

				$.post('Servlet_Biblioteca', 
				{
					tipo_muestra: 8,
					Correo: mail,
					Clave: clave
				}, function(responseText) 
				{
					alert(responseText);
					$("#nombre").text("Nombre: " + responseText[0] + " " + responseText[1] + " " + responseText[2]);
					$("#correo").text("Correo electronico: " + responseText[3]);
				});			
		});
	});
});