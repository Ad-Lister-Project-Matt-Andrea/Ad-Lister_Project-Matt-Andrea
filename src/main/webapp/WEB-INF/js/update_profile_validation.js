(function () {
    'use strict'

    const forms = document.querySelectorAll('.needs-validation');

    document.addEventListener("DOMContentLoaded",function(){
        isUsernameValidated();
        isEmailValidated();

        $("#username").keyup(isUsernameValidated);
        $("#email").keyup(isEmailValidated);

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


})()