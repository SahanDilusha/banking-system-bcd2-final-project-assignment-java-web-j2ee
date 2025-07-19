$(document).ready(function () {

    // OTP Input Handling
    $('.otp-inputs input').on('input', function () {
        if (this.value.length === 1) {
            $(this).next('input').focus();
        }
    });

    $('.otp-inputs input').on('keydown', function (e) {
        if (e.key === 'Backspace' && !this.value) {
            $(this).prev('input').focus();
        }
    });

    // Timer
    let timeLeft = 179; // 2:59 in seconds
    const timerEl = $('.timer');

    const timer = setInterval(function () {
        const minutes = Math.floor(timeLeft / 60);
        const seconds = timeLeft % 60;

        timerEl.text(
            minutes.toString().padStart(2, '0') + ':' +
            seconds.toString().padStart(2, '0')
        );

        if (timeLeft === 0) {
            clearInterval(timer);
            $('#resendLink').removeClass('disabled');
        } else {
            timeLeft--;
        }
    }, 1000);

    // Resend OTP
    $('#resendLink').on('click', function (e) {
        e.preventDefault();

        if ($(this).hasClass('disabled')) {
            return;
        }

        $(this).addClass('disabled');
        timeLeft = 179;

        // Show resend confirmation
        const originalText = $(this).text();
        $(this).html('<i class="bi bi-check-circle"></i> OTP Sent!');

        setTimeout(() => {
            $(this).text(originalText);
        }, 3000);
    });

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


    $("#btnTransfer").on("click", function () {

        $("#btnTransfer").prop('disabled', true).html('<span class="spinner-border spinner-border-sm"></span> Creating...');

        $.ajax({
            url: `${contextPath}/api/v1/account/transfer-verification`,
            method: "POST",
            contentType: "application/json",
            data: JSON.stringify({
                otp: Array.from($('.otp-inputs input'))
                    .map(input => input.value)
                    .join(''),
                hashedPassword: new URLSearchParams(window.location.search).get('hs'),
            }),
            dataType: 'json',
            success: function (response) {

                console.log(response);

                if (response.status) {
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
                $("#btnTransfer").prop('disabled', false).html('<i class="bi bi-arrow-right-circle"></i> Verify & Complete Transfer');
            }
        });

    });

});