// The root URL for the RESTful services
var rootURL = "http://localhost:8084/registro/clientes";
var currentClient;
findAll();

$('#btnAdd').click(function() {
	newCliente();
	return false;
});

$('#btnSave').click(function() {
	if ($('#clienteId').val() == '')
		addCliente();	
	return false;
});


$('#clienteList a').live('click', function() {
	findById($(this).data('identity'));
});

$("img").error(function(){
  $(this).attr("src", "pics/generic.jpg");

});

function newCliente() {	
	currentClient = {};
	renderDetails(currentClient); // Display empty form
}

function findAll() {
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", // data type of response
		success: renderList
	});
}


function findById(id) {
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + id,
		dataType: "json",
		success: function(data){			
			currentClient = data;
			renderDetails(currentClient);
		}
	});
}

function addCliente() {
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Creado exitosamente');			
			$('#clienteId').val(data.id);
                        findAll();
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('Adicionar error: ' + textStatus);
		}
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);
	$('#clienteList li').remove();
	$.each(list, function(index, cliente) {
		$('#clienteList').append('<li><a href="#" data-identity="' + cliente.id + '">'+cliente.nombre+" "+cliente.apellido+'</a></li>');
	});
}

function renderDetails(cliente) {
	$('#clienteId').val(cliente.id);
	$('#nombre').val(cliente.nombre);
	$('#apellido').val(cliente.apellido);
	$('#procesado').val(cliente.procesado);
}

function formToJSON() {
	var clienteId = $('#clienteId').val();
	return JSON.stringify({
		"clienteId": clienteId == "" ? null : clienteId, 
		"nombre": $('#nombre').val(), 
		"apellido": $('#apellido').val(),
		"procesado": $('#procesado').val()
		});
}
