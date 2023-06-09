(function () {
    'use strict'

    const forms = document.querySelectorAll('.needs-validation');

    document.addEventListener("DOMContentLoaded",function(){
        isUsernameValidated();
        isPasswordValidated();
        $("#username").keyup(isUsernameValidated);
        $("#password").keyup(isPasswordValidated);
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
})()