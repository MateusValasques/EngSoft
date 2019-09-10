package visão;

public class Conta_B {
	<head>

    <title>Untitled Page</title>

    <script type="text/javascript">

    //Obtido no site www.bb.com.br

    function FormataDado(campo, tammax, pos, teclapres) { 

	var keyCode; 

	if (teclapres.srcElement) 

	{ 

		keyCode = teclapres.keyCode; 

	} else 	if (teclapres.target) 

	{ 

		keyCode = teclapres.which; 

	} 

	if (keyCode == 0 || keyCode == 8) { return true; } 

	if ((keyCode < 48 || keyCode > 57) && keyCode != 88 && (keyCode != 120)) { return false; } 

	var tecla = keyCode; 

	vr = campo.value; 

	vr = vr.replace("-", ""); 

	vr = vr.replace("/", ""); 

	tam = vr.length; 

	if (tam < tammax && tecla != 8) 

	{ tam = vr.length + 1; } 

	if (tecla == 8) 

	{ 

		tam = tam - 1; 

	} 

	if (tecla == 8 || tecla == 88 || tecla >= 48 && tecla <= 57 || tecla >= 96 && tecla <= 105 || tecla == 120) 

	{ 

		if (tam <= 2) 

		{ 

			campo.value = vr; 

		} 

		if (tam > pos && tam <= tammax) 

		{ 

			campo.value = vr.substr(0, tam - pos) + "-" + vr.substr(tam - pos, tam); 

		} 

	} 

}


    </script>

</head>

<body>

<form>

    <input id="Text1" type="text" onkeypress="return FormataDado(this,12,1,event);" />

<form>


</body>

</html>





}
