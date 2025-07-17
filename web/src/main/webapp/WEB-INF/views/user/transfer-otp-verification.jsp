<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Verify Transfer - OTP Confirmation</title>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Nunito', sans-serif;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .verification-container {
            max-width: 500px;
            width: 100%;
            padding: 20px;
        }

        .card {
            border: none;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }

        .card-header {
            background: #4e73df;
            color: white;
            border-radius: 15px 15px 0 0 !important;
            padding: 20px;
        }

        .transfer-details {
            background: #f8f9fa;
            border-radius: 10px;
            padding: 15px;
            margin: 20px 0;
        }

        .otp-inputs {
            display: flex;
            gap: 10px;
            justify-content: center;
            margin: 20px 0;
        }

        .otp-inputs input {
            width: 50px;
            height: 50px;
            text-align: center;
            font-size: 24px;
            border: 2px solid #dee2e6;
            border-radius: 10px;
            background: #f8f9fa;
        }

        .otp-inputs input:focus {
            border-color: #4e73df;
            box-shadow: none;
            background: white;
        }

        .timer {
            color: #dc3545;
            font-weight: bold;
            font-size: 18px;
        }

        .resend-link {
            color: #4e73df;
            text-decoration: none;
            font-weight: 500;
        }

        .resend-link:hover {
            text-decoration: underline;
        }

        .btn-verify {
            background: #4e73df;
            border: none;
            padding: 12px 30px;
            font-weight: 500;
        }

        .btn-verify:hover {
            background: #2e59d9;
        }

        .detail-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
        }

        .detail-label {
            color: #6c757d;
        }

        .detail-value {
            font-weight: 500;
        }

        .progress {
            height: 4px;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="verification-container">
    <div class="card">
        <div class="card-header text-center">
            <img src="${pageContext.request.contextPath}/resources/image/app/bank-logo.png"
                 alt="Bank Logo"
                 style="width: 40px; margin-bottom: 10px;">
            <h4 class="mb-0">Verify Transfer</h4>
        </div>

        <div class="card-body">
            <!-- Transfer Details -->
            <div class="transfer-details">
                <div class="detail-row">
                    <span class="detail-label">From Account</span>
                    <span class="detail-value">**** 1234</span>
                </div>
                <div class="detail-row">
                    <span class="detail-label">To Account</span>
                    <span class="detail-value">**** 5678</span>
                </div>
                <div class="detail-row">
                    <span class="detail-label">Amount</span>
                    <span class="detail-value text-primary">$1,000.00</span>
                </div>
                <div class="detail-row">
                    <span class="detail-label">Reference</span>
                    <span class="detail-value">Monthly Rent</span>
                </div>
            </div>

            <!-- OTP Message -->
            <div class="text-center mb-4">
                <p class="mb-1">Enter the OTP sent to</p>
                <h6 class="mb-0">+1 (***) *** 4321</h6>
            </div>

            <!-- OTP Input -->
            <form id="otpForm">
                <div class="otp-inputs">
                    <input type="text" maxlength="1" class="form-control" autofocus>
                    <input type="text" maxlength="1" class="form-control">
                    <input type="text" maxlength="1" class="form-control">
                    <input type="text" maxlength="1" class="form-control">
                    <input type="text" maxlength="1" class="form-control">
                    <input type="text" maxlength="1" class="form-control">
                </div>

                <!-- Timer -->
                <div class="text-center mb-3">
                    <span class="timer">02:59</span>
                </div>

                <!-- Resend -->
                <div class="text-center mb-4">
                    <a href="#" class="resend-link" id="resendLink">Resend OTP</a>
                </div>

                <!-- Verify Button -->
                <button type="submit" class="btn btn-verify btn-primary w-100">
                    Verify & Complete Transfer
                </button>
            </form>
        </div>
    </div>

    <!-- Cancel Link -->
    <div class="text-center mt-3">
        <a href="#" class="text-muted" onclick="history.back()">
            <i class="bi bi-arrow-left"></i> Cancel Transfer
        </a>
    </div>
</div>

<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

<script>
    $(document).ready(function() {
        // OTP Input Handling
        $('.otp-inputs input').on('input', function() {
            if (this.value.length === 1) {
                $(this).next('input').focus();
            }
        });

        $('.otp-inputs input').on('keydown', function(e) {
            if (e.key === 'Backspace' && !this.value) {
                $(this).prev('input').focus();
            }
        });

        // Timer
        let timeLeft = 179; // 2:59 in seconds
        const timerEl = $('.timer');

        const timer = setInterval(function() {
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

        // Form Submit
        $('#otpForm').on('submit', function(e) {
            e.preventDefault();

            // Get OTP
            const otp = Array.from($('.otp-inputs input'))
                .map(input => input.value)
                .join('');

            // Show loading state
            const submitBtn = $(this).find('button[type="submit"]');
            const originalText = submitBtn.html();
            submitBtn.prop('disabled', true)
                .html('<span class="spinner-border spinner-border-sm"></span> Verifying...');

            // Simulate verification (replace with actual verification)
            setTimeout(function() {
                submitBtn.html(originalText).prop('disabled', false);
                // Show success and redirect
                window.location.href = 'transfer-success.jsp';
            }, 2000);
        });

        // Resend OTP
        $('#resendLink').on('click', function(e) {
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
    });
</script>
</body>
</html>