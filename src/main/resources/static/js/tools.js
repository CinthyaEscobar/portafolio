function activar()
{
	var check = document.getElementById('chkTransporte');
	var select = document.getElementById('cbTransporte');		
	if(check.checked)
	{		
		select.disabled = false;
		obtenerPrecioTransporte();			
	}
	else
	{
		select.selectedIndex = 0;
		select.disabled = true;
		final -= old;
		document.getElementById("totalReserva").innerHTML = final;
		calcularPrepago();
	}
}

var old = 0;
function obtenerPrecioTransporte()
{
	
	var e = document.getElementById('cbTransporte');	
	var text = e.options[e.selectedIndex].text.split("$");
	if(text.length > 1)
	{
		var p = parseInt(text[1].trim());
		var check = document.getElementById('chkTransporte');
		if(check.checked)
		{
			final -= old;
			final += p; 
		}
		else
		{
			final =- old;
		}
		console.log(final);
		document.getElementById("totalReserva").innerHTML = final;
		calcularPrepago();
		old = p;
	}
	 especial();
}

var total = 1;
function generar()
{
		var dvInicio = "<div id='base"+total +"' >";
		var run = "<input type='text' name='runAcom' placeholder='Rut'  required> ";
		var nombre = "<input type='text' name='nombreAcom' placeholder='Nombre Completo'  required>";
		var eliminar = "<input type='button' name='eliminar' value='x' onclick='remove("+total+")'>" 
		var dvTermino = "</div> <br>";
		
		//$("#cuerpo").append(divComienzo);
		$("#cuerpo").append(dvInicio);
		$("#base"+total).append(run);
		$("#base"+total).append(nombre);
		$("#base"+total).append(eliminar);
		//$("#cuerpo").append(dvInicio);	
		total++;	
}

function remove(value)
{
	document.getElementById("base"+value).remove();
}


var transporte = 0;
var tours = 0;
var v = 0;
var final = parseInt($('#totalDpto').val());


document.getElementById("tourTotal").innerHTML = tours;
document.getElementById("totalReserva").innerHTML = final;
calcularPrepago();

function sumarTour(value,id)
{
	var tour = document.getElementById('tour'+id);
	if(tour.checked)	
	{
		tours += value;
		final += value
	}
	else
	{
		tours -= value;		
		final -= value
	}
	console.log(tours);
	console.log(final);	
	document.getElementById("totalReserva").innerHTML = final;
	document.getElementById("tourTotal").innerHTML = tours;
	calcularPrepago()
	especial();
}

function calcularPrepago()
{
	var porcentaje = parseInt($('#porcentaje').val());
	v = final * porcentaje / 100
	document.getElementById("prepago").innerHTML = v;
	especial();
}

function especial()
{
	$('#total_final').val(final)
	$('#total_prepago').val(v)
}
	

