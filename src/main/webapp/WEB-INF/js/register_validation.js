(function () {
    'use strict'

    const forms = document.querySelectorAll('.needs-validation');

    document.addEventListener("DOMContentLoaded",function(){
        isUsernameValidated();
        isEmailValidated();
        isPasswordValidated();
        isConfirmPasswordValidated();
        $("#username").keyup(isUsernameValidated);
        $("#email").keyup(isEmailValidated);
        $("#password").keyup(isPasswordValidated);
        $("#confirm_password").keyup(isConfirmPasswordValidated);
    })

    //submit button
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated');

            }, false)
        })

    function isUsernameValidated(){
        let username = $("#username").val();
        if (username.length > 0) {
            $("#username").removeClass("is-invalid");
            $("#username").addClass("is-valid");
        } else {
            $("#username").addClass("is-invalid");
            $("#username").removeClass("is-valid");
        }
    }

    function isEmailValidated(){
        let email = $("#email").val();
        if (email.length > 0) {
            $("#email").removeClass("is-invalid");
            $("#email").addClass("is-valid");
        } else {
            $("#email").addClass("is-invalid");
            $("#email").removeClass("is-valid");
        }
    }

    function isPasswordValidated(){
        let password = $("#password").val();
        if(password.length > 0) {
            $("#password").removeClass("is-invalid");
            $("#password").addClass("is-valid");
        } else {
            $("#password").addClass("is-invalid");
            $("#password").removeClass("is-valid");
        }
    }

    function isConfirmPasswordValidated(){
        let confirm_password = $("#confirm_password").val();
        if(confirm_password.length > 0) {
            $("#confirm_password").removeClass("is-invalid");
            $("#confirm_password").addClass("is-valid");
        } else {
            $("#confirm_password").addClass("is-invalid");
            $("#confirm_password").removeClass("is-valid");
        }
    }
})()