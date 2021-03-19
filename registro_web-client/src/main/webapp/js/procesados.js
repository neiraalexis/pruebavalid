// The root URL for the RESTful services
var rootURL = "http://localhost:8084/registro/clientes";
var table;
var selecteds = [];

$('#btnProcesar').click(function () {  

    var rows_selected = table.column(0).checkboxes.selected();
    // Iterate over all selected checkboxes
    $.each(rows_selected, function (index, rowId) {     
        selecteds.push(rowId);
    });

    processClients();
    return false;
});

function processClients() {
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: rootURL + '/procesar',
        dataType: "json",
        data: formToJSON(),
        success: function (data, textStatus, jqXHR) {
            alert('Actualizado');
          $('#example').DataTable().ajax.reload();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(formToJSON());
            alert('Actualizar error: ' + textStatus);
            alert(jqXHR);
            alert(errorThrown);
        }
    });
}

function formToJSON() {
    return JSON.stringify(
            selecteds
            );
}

$(document).ready(function () {
    actualizar();

});

function actualizar() {
    table = $('#example').DataTable({
        'ajax': {
            "url": rootURL,
            "type": "GET",
            "dataSrc": ""
        },
       
        columns: [
             {data: 'id'},
            {data: 'nombre'},
            {data: 'apellido'},
           
            {data: 'procesado'}],
        'columnDefs': [
            {
                'targets': 0,
                'checkboxes': {
                    'selectRow': true
                }
            }
        ],
        'select': {
            'style': 'multi'
        },
        'order': [[1, 'asc']]
    });

}