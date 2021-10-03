$(document).ready(function() {
    console.log("HTML LOADED");

    $.ajax({
        url: 'http://localhost:8080/weather',
        type: 'GET',
        accept: "application/json",
        contentType: "application/json; charset=utf-8"
    })
    .done((data, textStatus, jqXHR) => {
        console.log(data);
        var temperature = data.temperature;
        $('#temperature').html(temperature);
    });

});
