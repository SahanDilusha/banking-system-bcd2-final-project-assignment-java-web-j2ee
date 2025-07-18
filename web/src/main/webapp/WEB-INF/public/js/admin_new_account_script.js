$(document).ready(function () {

    const contextPath = $("meta[name='ctx']").attr("content");

    const showModal = ({title, msg}) => {
        $("#modal-title").text(title);
        $("#modal-body").text(msg);
        $("#model").modal('show');
    };

    $("#transferBtn").on("click", function () {


        $("#transferBtn").prop('disabled', true).html('<span class="spinner-border spinner-border-sm"></span> Processing...');

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
                $("#transferBtn").prop('disabled', false).html('<i class="bi bi-arrow-right-circle"></i> Continue');
            }
        });

    });
});
