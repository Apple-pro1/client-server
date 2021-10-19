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

    $('#happy-image').click(function() {
        console.log("happy imaged clicked!");
        alert("happy imaged clicked!");
    });

    $('#sad-image').click(function() {
            console.log("sad imaged clicked!");
            alert("sad imaged clicked!");
        });

    $('#angry-image').click(function() {
        console.log("angry imaged clicked!");
        alert("angry imaged clicked!");
    });

});
