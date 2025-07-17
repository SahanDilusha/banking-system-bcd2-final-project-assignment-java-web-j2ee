<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>500 - Internal Server Error</title>

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
            overflow-x: hidden;
        }

        .error-container {
            text-align: center;
            padding: 40px 20px;
            position: relative;
        }

        .error-code {
            font-size: 120px;
            font-weight: 800;
            color: #e74a3b; /* Red color for 500 error */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
            margin-bottom: 0;
            line-height: 1;
        }

        .error-text {
            font-size: 24px;
            color: #5a5c69;
            margin-bottom: 30px;
        }

        .error-description {
            color: #858796;
            margin-bottom: 30px;
            max-width: 600px;
        }

        .error-image {
            max-width: 400px;
            margin-bottom: 30px;
        }

        .btn-return {
            padding: 12px 30px;
            font-size: 16px;
            transition: all 0.3s;
        }

        .btn-return:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* Gear Animation */
        .gear {
            position: absolute;
            opacity: 0.1;
        }

        .gear-1 {
            top: 20%;
            left: 10%;
            animation: rotate 10s linear infinite;
        }

        .gear-2 {
            top: 60%;
            right: 10%;
            animation: rotate 7s linear infinite reverse;
        }

        @keyframes rotate {
            from {
                transform: rotate(0deg);
            }
            to {
                transform: rotate(360deg);
            }
        }

        /* Error Code Animation */
        @keyframes glitch {
            0% {
                transform: translate(0);
            }
            20% {
                transform: translate(-2px, 2px);
            }
            40% {
                transform: translate(-2px, -2px);
            }
            60% {
                transform: translate(2px, 2px);
            }
            80% {
                transform: translate(2px, -2px);
            }
            100% {
                transform: translate(0);
            }
        }

        .glitch {
            animation: glitch 1s linear infinite;
            animation-play-state: paused;
        }

        .glitch:hover {
            animation-play-state: running;
        }

        /* Support Card */
        .support-card {
            background: white;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            margin-top: 30px;
        }

        .support-card i {
            font-size: 24px;
            color: #e74a3b;
        }

        /* Error Details Accordion */
        .error-details {
            max-width: 600px;
            margin: 20px auto;
            text-align: left;
        }

        .error-details .accordion-button:not(.collapsed) {
            background-color: #f8d7da;
            color: #842029;
        }

        /* Dark Mode */
        @media (prefers-color-scheme: dark) {
            body {
                background-color: #1a1a1a;
                color: #fff;
            }

            .error-text {
                color: #e0e0e0;
            }

            .error-description {
                color: #b0b0b0;
            }

            .support-card {
                background: #2d2d2d;
                color: #fff;
            }

            .error-details .accordion-button:not(.collapsed) {
                background-color: #2d1215;
                color: #f8d7da;
            }
        }
    </style>
</head>
<body>
<!-- Background Gears -->
<i class="bi bi-gear-fill gear gear-1 display-1"></i>
<i class="bi bi-gear-fill gear gear-2 display-1"></i>

<div class="container">
    <div class="error-container">
        <!-- Logo -->
        <img src="${pageContext.request.contextPath}/resources/image/app/bank-logo.png"
             alt="Bank Logo"
             class="mb-4"
             style="width: 60px;">

        <!-- Error Details -->
        <h1 class="error-code glitch">500</h1>
        <h2 class="error-text">Internal Server Error</h2>
        <p class="error-description mx-auto">
            Oops! Something went wrong on our end. Our team has been notified and is working
            to fix the issue. Please try again later.
        </p>

        <!-- Error Reference -->
        <div class="d-inline-block bg-light rounded px-3 py-2 mb-4">
            <small class="text-muted">
                Error Reference: <span class="font-monospace">${errorId}</span>
            </small>
        </div>

        <!-- Action Buttons -->
        <div class="d-flex justify-content-center gap-3 mb-4">
            <button onclick="window.history.back()"
                    class="btn btn-outline-danger btn-return">
                <i class="bi bi-arrow-left"></i> Go Back
            </button>
            <a href="${pageContext.request.contextPath}/"
               class="btn btn-danger btn-return">
                <i class="bi bi-house"></i> Return Home
            </a>
            <button onclick="location.reload()"
                    class="btn btn-outline-danger btn-return">
                <i class="bi bi-arrow-clockwise"></i> Try Again
            </button>
        </div>

        <!-- Support Card -->
        <div class="support-card">
            <i class="bi bi-headset mb-3"></i>
            <h5>Need Immediate Assistance?</h5>
            <p class="mb-3">Our support team is available 24/7</p>
            <div class="d-flex justify-content-center gap-2">
                <a href="tel:1800123456" class="btn btn-sm btn-outline-danger">
                    <i class="bi bi-telephone"></i> Call Us
                </a>
                <a href="mailto:support@bank.com" class="btn btn-sm btn-outline-danger">
                    <i class="bi bi-envelope"></i> Email Support
                </a>
            </div>
        </div>

        <!-- Error Details Accordion -->
        <div class="error-details">
            <div class="accordion" id="errorAccordion">
                <div class="accordion-item">
                    <h2 class="accordion-header">
                        <button class="accordion-button collapsed" type="button"
                                data-bs-toggle="collapse" data-bs-target="#errorInfo">
                            Technical Details
                        </button>
                    </h2>
                    <div id="errorInfo" class="accordion-collapse collapse"
                         data-bs-parent="#errorAccordion">
                        <div class="accordion-body">
                                <pre class="mb-0"><code>
Error Time: ${errorTime}
Server: ${serverName}
Request Path: ${requestPath}
Error Type: ${errorType}
                                </code></pre>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script>
    // Auto-refresh countdown
    let timeLeft = 30;

    function updateCountdown() {
        const button = document.querySelector('.btn-return i.bi-arrow-clockwise');
        if (button) {
            button.parentElement.innerHTML =
                `<i class="bi bi-arrow-clockwise"></i> Try Again (${timeLeft}s)`;

            if (timeLeft <= 0) {
                location.reload();
            } else {
                timeLeft--;
                setTimeout(updateCountdown, 1000);
            }
        }
    }

    // Start countdown
    updateCountdown();

    // Report error to analytics
    function reportError() {
        // Implementation for error reporting
        console.log('Error reported:', {
            errorId: '${errorId}',
            time: new Date().toISOString(),
            url: window.location.href
        });
    }

    // Report error when page loads
    reportError();
</script>
</body>
</html>