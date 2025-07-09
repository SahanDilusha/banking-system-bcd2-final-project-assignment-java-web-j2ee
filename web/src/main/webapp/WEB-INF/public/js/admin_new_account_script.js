$(document).ready(function () {
    const contextPath = $("meta[name='ctx']").attr("content");

    const showModal = ({title, msg}) => {
        $("#modal-title").text(title);
        $("#modal-body").text(msg);
        $("#model").modal('show');
    };

    $("#createBtn").on("click", function () {
        const firstName = $("#firstName").val().trim();
        const lastName = $("#lastName").val().trim();
        const email = $("#email").val().trim();
        const mobile = $("#mobile").val().trim();
        const street = $("#street").val().trim();
        const city = $("#city").val().trim();
        const state = $("#state").val().trim();
        const zipCode = $("#zipCode").val().trim();
        const accountType = $("#accountType").eq(0).val();
        const deposit = $("#deposit").val().trim();
        const idType = $("#idType").eq(0).val();
        const idNO = $("#idNO").val().trim();

        const formData = new FormData();
        formData.append("dto", JSON.stringify({
            email,
            firstName,
            lastName,
            mobile,
            street,
            city,
            state,
            zipCode,
            idNO,
            deposit: parseFloat(deposit),
            accountType,
            idType
        }));

        console.log({
            email,
            firstName,
            lastName,
            mobile,
            street,
            city,
            state,
            zipCode,
            idNO,
            deposit: parseFloat(deposit),
            accountType,
            idType
        });

        $("#createBtn").prop('disabled', true).html('<span class="spinner-border spinner-border-sm"></span> Creating...');

        $.ajax({
            url: `${contextPath}/api/v1/account/create`,
            method: "POST",
            data: formData,
            processData: false,
            contentType: false,
            dataType: 'json',
            success: function (response) {

                console.log(response);

                if (response.status) {
                    showModal({
                        title: "Success",
                        msg: "Account successfully created!"
                    });
                } else {
                    showModal({
                        title: "Error",
                        msg: response.message || "Failed to create account."
                    });
                }
            },
            error: function (xhr, status, error) {
                console.error("Error:", error);
                showModal({
                    title: "Error",
                    msg: "Something went wrong. Please try again."
                });
            },
            complete: function () {
                $("#createBtn").prop('disabled', false).html('<i class="bi bi-check-circle"></i> Create Account');
            }
        });

    });
});
