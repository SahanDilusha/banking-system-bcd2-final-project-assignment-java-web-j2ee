$(document).ready(function () {

    const contextPath = $("meta[name='ctx']").attr("content");

    $('input[name="transferType"]').change(function () {
        if ($(this).attr('id') === 'external') {
            $('#bankDetails').slideDown();
        } else {
            $('#bankDetails').slideUp();
        }
    });

    const showModal = ({title, msg}) => {
        $("#modal-title").text(title);
        $("#modal-body").text(msg);
        $("#model").modal('show');
    };


    $("#transferBtn").on("click", function () {

        $("#transferBtn").prop('disabled', true).html('<span class="spinner-border spinner-border-sm"></span> Creating...');

        $.ajax({
            url: `${contextPath}/api/v1/account/transfer`,
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                "fromAccount": 1751879908854,
                "toAccount": 1752039628169,
                "amount": 100.00,
                "holderName": "kamal",
                "reference": "Rent Pay",
                "transferType": "INTERNAL"
            }),
            dataType: 'json',
            success: function (response) {

                console.log(response);

                if (response.status) {
                    showModal({
                        title: "Success",
                        msg: "Account successfully created!"
                    });
                    window.location.href = `${contextPath}${response.message}`;
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
                $("#transferBtn").prop('disabled', false).html('<i class="bi bi-arrow-right-circle"></i> Create Account');
            }
        });

    });

});