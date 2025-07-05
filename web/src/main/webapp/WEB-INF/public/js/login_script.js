$(document).ready(function () {
    const showModal = ({title, msg}) => {
        $("#modal-title").text(title);
        $("#modal-body").text(msg);

        $("#model").modal('show');
    };

    $('#login-btn').on('click', function () {
        const email = $('#email').val().trim();
        const password = $('#password').val().trim();

        if (!email || !password) {
            showModal({
                title: "Validation Error",
                msg: "Please fill in all fields"
            });
            return;
        }

        $('#login-btn').prop('disabled', true).html(
            '<span class="spinner-border spinner-border-sm"></span> Loading...'
        );

        try {
            $.ajax({
                url: "http://localhost:8080/banking-system/api/v1/login",
                method: "POST",
                data: JSON.stringify({
                    email: email,
                    password: password
                }),
                contentType: "application/json",
                dataType: 'json',
                success: function (response) {
                    console.log("Response:", response);

                    if (response.status) {
                        showModal({
                            title: "Success",
                            msg: "Login successful!"
                        });


                    } else {
                        showModal({
                            title: "Error",
                            msg: response.message || "Login failed"
                        });
                    }
                },
                error: function (xhr, status, error) {
                    console.error("Error:", error);
                    console.log("Status:", status);
                    console.log("Response:", xhr.responseText);

                    showModal({
                        title: "Error",
                        msg: "Login failed. Please try again."
                    });
                },
                complete: function () {
                    $('#login-btn').prop('disabled', false).html('Login');
                }
            });

        } catch (e) {
            console.error("Exception:", e);

            showModal({
                title: "Error",
                msg: "An unexpected error occurred."
            });

            $('#login-btn').prop('disabled', false).html('Login');
        }
    });
});