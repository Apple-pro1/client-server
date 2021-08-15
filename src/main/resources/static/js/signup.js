function validateEmail(email) {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function validateSignUpInput(email, password, confirmPassword) {
    if (!validateEmail(email)) {
        alert("invalid e-mail address!!");
        return false;
    }

        // password length check
    if (password.length < 4) {
        alert("Password too short!!");
        $('#passwordInput').val('');
        return false;
    }

    if (confirmPassword !== password) {
        alert("Password not matching!!");
        $('#confirmPasswordInput').val('');
        return false;
    }

    return true;
}

$(document).ready(function() {
    console.log("loading html document is completed.");


    $('#sign-up-btn').click(function() {
        var email = $('#emailInput').val();
        var password = $('#passwordInput').val();
        var confirmPassword = $('#confirmPasswordInput').val();


        if (!validateSignUpInput(email, password, confirmPassword)) {
            return;
        }

        $.ajax({
            url: 'http://localhost:8080/service-member',
            type: 'POST',
            data:JSON.stringify({"memberEmail": email, "memberPassword": password}),
            dataType: "json",
            accept: "application/json",
            contentType: "application/json; charset=utf-8"
        })
        .done((data, textStatus, jqXHR) => {
            console.log(data);
            console.log(data["memberId"]);
            alert("Sign Up - Success")
            location.href = "sign-in";


        });
    });

    $('#log-in-btn').click(function() {
        var email = $('#loginEmailInput').val();
        var password = $('#loginPasswordInput').val();

        // TODO email length check
        if (!validateEmail(email)) {
            alert("invalid e-mail address!!");
            return;
        }

        // password length check
        if (password.length < 4) {
            alert("Password too short!!");
            $('#passwordInput').val('');
            return;
        }


        $.ajax({
            url: 'http://localhost:8080/login',
            type: 'POST',
            data:JSON.stringify({"memberEmail": email, "memberPassword": password}),
            dataType: "json",
            accept: "application/json",
            contentType: "application/json; charset=utf-8"
        })
        .done((data, textStatus, jqXHR) => {
            console.log(data);
            console.log(data["sessionId"]);

            var isSuccess = data["success"];
            if (isSuccess) {
                alert("login - Success")
            } else {
                alert("invalid password or username!!");
            }

        });
    });

});