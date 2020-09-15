/**
 *		Reporte de las inmobiliarias registradas por usuario 
 */

function report(){	
	$.ajax({
		url : "/inmobilaria/dataRptProvinciaDescripcion",
		method : 'GET',
		success : function(response){
			console.log(response);
			
			var toData = [];
			var toLabels = [];
			var toColors = [];
			var creadores = [];
			var datasets = {}
			var datasets2 = [];
			

			$.each(response, function(i, item){
				toLabels.push(item.nombre);
				creadores.push(item.creadoPor);
				toColors.push(getRandomColor());
				
			});
			
			$.each(response, function(i, item){
				if(datasets[item.creadoPor + item.nombre]) {
					datasets[item.creadoPor + item.nombre].total++;
				} else {
					datasets[item.creadoPor + item.nombre] = {
							nombre: item.nombre,
							creadoPor: item.creadoPor,
							total: 1,
					}
				}
			});
			
			datasets = Object.values(datasets);
		
			toLabels = quitarDuplicados(toLabels);
			creadores = quitarDuplicados(creadores);
			
			
			
			
			var emptyData = new Array(creadores.length).fill(0).map(() => new Array(toLabels.length).fill(0));
			console.log(toLabels.length, creadores.length, emptyData);
			
			
			$.each(creadores, function(i, creadoPor){
				$.each(toLabels, function(j, nombre){
					$.each(datasets, function(k, item){
						if(item.creadoPor == creadoPor && item.nombre == nombre) {
							//console.log(i,j,emptyData[i][j])
							emptyData[i][j] = item.total;
						}
					});
				});
				datasets2.push({
					label: creadoPor,
					backgroundColor: getRandomColor(),
					borderColor: getRandomColor(),
					borderWidth: 1,
					data: emptyData[i]
				});
			});
									
			var barChartData = {
				labels: toLabels,
				datasets: datasets2,

			};

			var ctx = document.getElementById('canvas').getContext('2d');
			window.myBar = new Chart(ctx, {
				type: 'bar',
				data: barChartData,
				options: {
					responsive: true,
					legend: {
						position: 'top',
					},
					title: {
						display: true,
						text: 'REPORTE DE INMOBILIARIAS REGISTRADAS POR PROVINCIA'
					},
					scales: {
				        yAxes: [{
				            ticks:{
								beginAtZero: true
							}
				        }]
				    }
				}
			});
			
		},
		error : function(err){
			console.log(err);
		}		
	});	
}


function quitarDuplicados(valores) {
  let datos = {};
  valores.forEach(function(i) {
    if(!datos[i]) {
    	datos[i] = true;
    }
  });
  return Object.keys(datos);
}


function getRandomColor() {
	  var letters = '0123456789ABCDEF';
	  var color = '#';
	  for (var i = 0; i < 6; i++) {
	    color += letters[Math.floor(Math.random() * 16)];
	  }
	  return color;
	}

$(document).ready(function(){
	report();	
	report2();	
});

