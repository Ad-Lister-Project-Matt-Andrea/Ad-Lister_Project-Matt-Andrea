(function () {
    'use strict'

    const forms = document.querySelectorAll('.needs-validation');

    //validate username
    $("#usernameInvalid").hide();
    let usernameError = true;
    $("#username").keyup(function(){
        validateUsername();
    })
    function validateUsername(){
        let username = $("#username").val();
        if(username.length === ""){
            $("#usernameInvalid").show();
            usernameError = false;
            return false;
        } else if (username.length < 3 ){
            $("#usernameValid").show();
            usernameError = false;
            return false;
        } else{
            $("#usernameInvalid").hide();
        }
    }
    //validate password
    $("#passwordInvalid").hide();
    let passwordError = true;
    $("#password").keyup(function(){
        validatePassword();
    })
    function validatePassword(){
        let password = $("#password").val();
        if(password.length === ""){
            $("#passwordInvalid").show();
            passwordError = false;
            return false;
        } else if (password.length < 3 ){
            $("#passwordValid").show();
            passwordError = false;
            return false;
        } else{
            $("#passwordInvalid").hide();
        }
    }

    //submit button
    // Array.prototype.slice.call(forms)
    //     .forEach(function (form) {
    //         form.addEventListener('submit', function (event) {
    $("#submitbtn").click(function(){
                validateUsername();
                validatePassword();
                if (usernameError == true && passwordError == true) {
                    return true;
                }else{
                    return false;
                }

                // form.classList.add('was-validated');

            // }, false)
        })
})()