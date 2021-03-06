<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html id="documento_principal">
<head>
    <link rel="stylesheet" type="text/css" href="styles/login.css">	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="actions/login.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body id="cuerpo">
 
    <div> 
        <table>
            <tr>
                <td>
                    <label class="menu_superior" id = "iniciar">Iniciar</label>
                </td>
                <td>
                    <label class="menu_superior" id = "registrar">Registro</label>
                </td>
            </tr>
        </table>
      <!--********************************Formulario de inicio de sesion********************************-->
        <form id="f_inicio">
            <table border="0" align="center"  id="formulario_inicio">
                <tr>
                    <td colspan="2" align="center">
                        <label id="mensaje_bienvenido">Bienvenido!</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input class="inicio" type="text" id="input_correo" placeholder="Correo*">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input class="inicio" type="password" id="input_clave" placeholder="Contraseña*">
                    </td>
                </tr>
                <tr >
                    <td colspan="2" align="center">
                        <input class="inicio" type="submit" value="Entrar" id="boton_entrar">
                    </td>
                </tr>
            </table>
        </form>
        <!--******************************** Formulario de registro ********************************-->
        <form id="f_registro">
            <table border="0" align="center"  id="formulario_registro">
                <tr>
                    <td colspan="2" align="center">
                        <label id="mensaje_registro">Ingresa tus datos</label>
                    </td>
                </tr>
                <tr>
                    <td align="left">
                        <input type="text" class="input_registros1" placeholder="Nombre*" id="nombre">
                    </td>
                    <td align="left">
                        <input type="text" class="input_registros1" placeholder="Apellidos*" id="apellidos">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="text" class="input_registros" placeholder="Correo*" id="correo">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                    	<input type="password" class="input_registros" placeholder="Contraseña*" id="contrasena">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Registrar" id="boton_registrar">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
