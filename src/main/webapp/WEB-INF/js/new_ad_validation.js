(function () {
    'use strict'

    const forms = document.querySelectorAll('.requires-validation');

    document.addEventListener("DOMContentLoaded",function(){
        isTitleValidated();
        isDescriptionValidated();
        isPriceValidated();
        isLocationValidated();
        isCategoryValidated();
        $("#title").keyup(isTitleValidated);
        $("#description").keyup(isDescriptionValidated);
        $("#price").keyup(isPriceValidated);
        $("#location").keyup(isLocationValidated);
        $("#category").change(isCategoryValidated);
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

    function isPriceValidated(){
        let price = $("#price").val();
        if (price.length > 0) {
            $("#price").removeClass("is-invalid");
            $("#price").addClass("is-valid");
        } else {
            $("#price").addClass("is-invalid");
            $("#price").removeClass("is-valid");
        }
    }

    function isLocationValidated(){
        let location = $("#location").val();
        if (location.length > 0) {
            $("#location").removeClass("is-invalid");
            $("#location").addClass("is-valid");
        } else {
            $("#location").addClass("is-invalid");
            $("#location").removeClass("is-valid");
        }
    }

    function isCategoryValidated(){
        let category = document.getElementById("category").value;
        console.log(category );
        if (category !== "") {
            $("#category").removeClass("is-invalid");
            $("#category").addClass("is-valid");
        } else {
            $("#category").addClass("is-invalid");
            $("#category").removeClass("is-valid");
        }
    }
})()