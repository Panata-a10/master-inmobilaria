
function create(){
	
	$.ajax({
		url : "/detalle/create",
		method : 'GET',
		success : function(response){
			console.log(response);
			$("#contentFrmDetalle").empty();
			$("#contentFrmDetalle").html(response);
			
		},
		
		error : function(err){
			console.log(err);
		}
				
	});
}


function list(){
	
	$.ajax({
		url : "/inmobilaria/details/",
		method : 'GET',
		success : function(response){
			console.log(response);
			$("#listDetalles").empty();
			$("#listDetalles").html(response);
		},
		error : function(err){
			console.log(err);
		}
	});
	
}


function save(){
	
	var dataForm = objectifyForm($("#frmDetalle").serializeArray());	
	var requestBody = JSON.stringify(dataForm);
	console.log(requestBody);		
	$.ajax({
		url : "https://inmobilaria.herokuapp.com/inmobilaria/add",
		method : 'POST',
		contentType : "application/json",
		headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
		data : requestBody,
		success : function (response){
			console.log(response);
			list();
		},
		error : function(err){
			console.log(err);
		}
	});
}

function objectifyForm(formArray) {
	var returnArray = {};
	for (var i = 0; i < formArray.length; i++) {
		returnArray[formArray[i]['name']] = formArray[i]['value'];
	}
	return returnArray;
}


$(document).ready(function(){
	
	list();
	$("#btnAdd").click(function(){
		create();
	});
	
	
	$("#btnSubmit").click(function(){
		save();
	});
});