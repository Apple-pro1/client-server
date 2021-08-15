$(document).ready(function() {
    console.log("loading html document is completed.");

    $('#count-up-btn').click(function() {
        var countVal = 0;
        $.ajax({
            url: 'http://localhost:8080/count-up',
            type: 'GET'
        })
        .done((data, textStatus, jqXHR) => {
            console.log(data["count"]);
            countVal = data["count"];
            $('#count-field').html(countVal);

        });
    });

    $('#add-btn').click(function() {
        var a = $('#addInput1').val();
        var b = $('#addInput2').val();
        $.ajax({
            url: 'http://localhost:8080/add',
            type: 'POST',
            data:JSON.stringify({"a": a, "b":b}),
            dataType: "json",
            accept: "application/json",
            contentType: "application/json; charset=utf-8"
        })
        .done((data, textStatus, jqXHR) => {
            console.log(data);
            console.log(data["result"]);
            countVal = data["result"];
            $('#add-result-field').html(countVal);

        });
    });

});