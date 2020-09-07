/**
 *		Reporte de las ofertas  
 */


/*
 *  Obtenemos todas las inmobilarias registradas en la BD
 */
function report(){	
	var materias = null;
	$.ajax({
		url : "/inmobilaria/todasInmobilarias",
		method : 'GET',
		async: false,
		success : function(response){
			console.log(response);
			materias = response;
		},
		error : function(err){
			console.log(err);
		}		
	});	
	return materias;
}

/*
 * Obtenemos los valores de las inmobilarias de la base de datos
 */

function report12(){	
	var matriculados = null;
	$.ajax({
		url : "/inmobilaria/CantidadOfertas",
		method : 'GET',
		async: false,
		success : function(response){
			console.log(response);
			matriculados = response;
		},
		error : function(err){
			console.log(err);
		}		
	});
	return matriculados;
	
}

/*
 * Generador de colores aleatorios
 */

function getRandomColor() {
	  var letters = '0123456789ABCDEF';
	  var color = '#';
	  for (var i = 0; i < 6; i++) {
	    color += letters[Math.floor(Math.random() * 16)];
	  }
	  return color;
	}

$(document).ready(function(){
	
	var colores = [];
	for(var i in report12()){
		colores.push(getRandomColor());
		
	}
	var config = {
			type: 'doughnut',
			data: {
				datasets: [{
					data: report12(),
					backgroundColor: colores,
					label: 'Dataset 1'
				}],
				labels:report()
			},
			options: {
				responsive: true,
				legend: {
					position: 'top',
				},
				title: {
					display: true,
					text: 'Cantidad de ofertas por inmueble'
				},
				animation: {
					animateScale: true,
					animateRotate: true
				}
			}
		};

		window.onload = function() {
			var ctx = document.getElementById('chart-area').getContext('2d');
			window.myDoughnut = new Chart(ctx, config);
		};
});

