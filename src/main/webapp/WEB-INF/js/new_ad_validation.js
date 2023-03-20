(function () {
    'use strict'

    const forms = document.querySelectorAll('.needs-validation');

    document.addEventListener("DOMContentLoaded",function(){
        isTitleValidated();
        isDescriptionValidated();
        $("#title").keyup(isTitleValidated);
        $("#description").keyup(isDescriptionValidated);
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

    function isTitleValidated(){
        let title = $("#title").val();
        if (title.length > 0) {
            $("#title").removeClass("is-invalid");
            $("#title").addClass("is-valid");
        } else {
            $("#title").addClass("is-invalid");
            $("#title").removeClass("is-valid");
        }
    }

    function isDescriptionValidated(){
        let description = $("#description").val();
        if(description.length > 0) {
            $("#description").removeClass("is-invalid");
            $("#description").addClass("is-valid");
        } else {
            $("#description").addClass("is-invalid");
            $("#description").removeClass("is-valid");
        }
    }
})()