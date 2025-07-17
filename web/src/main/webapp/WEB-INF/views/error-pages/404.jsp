<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found</title>

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

        .error-container {
            text-align: center;
            padding: 40px 20px;
        }

        .error-code {
            font-size: 120px;
            font-weight: 800;
            color: #4e73df;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.1);
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
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        .search-box {
            max-width: 400px;
            margin: 0 auto 30px;
        }

        .helpful-links {
            margin-top: 30px;
        }

        .helpful-links a {
            color: #4e73df;
            text-decoration: none;
            margin: 0 15px;
            transition: color 0.3s;
        }

        .helpful-links a:hover {
            color: #2e59d9;
        }

        /* Animation */
        @keyframes float {
            0% { transform: translateY(0px); }
            50% { transform: translateY(-20px); }
            100% { transform: translateY(0px); }
        }

        .floating {
            animation: float 3s ease-in-out infinite;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="error-container">
        <!-- Logo -->
        <img src="${pageContext.request.contextPath}/resources/image/app/bank-logo.png"
             alt="Bank Logo"
             class="mb-4"
             style="width: 60px;">

        <!-- Error Image -->
        <img src="${pageContext.request.contextPath}/resources/image/404-illustration.png"
             alt="404 Illustration"
             class="error-image floating">

        <!-- Error Details -->
        <h1 class="error-code">404</h1>
        <h2 class="error-text">Page Not Found</h2>
        <p class="error-description mx-auto">
            Oops! The page you're looking for seems to have gone on vacation.
            Don't worry, even pages need a break sometimes.
        </p>

        <!-- Search Box -->
        <div class="search-box">
            <div class="input-group mb-4">
                <input type="text"
                       class="form-control"
                       placeholder="Search for pages..."
                       aria-label="Search">
                <button class="btn btn-primary" type="button">
                    <i class="bi bi-search"></i>
                </button>
            </div>
        </div>

        <!-- Action Buttons -->
        <div class="d-flex justify-content-center gap-3 mb-4">
            <button onclick="window.history.back()"
                    class="btn btn-outline-primary btn-return">
                <i class="bi bi-arrow-left"></i> Go Back
            </button>
            <a href="${pageContext.request.contextPath}/"
               class="btn btn-primary btn-return">
                <i class="bi bi-house"></i> Return Home
            </a>
        </div>

        <!-- Helpful Links -->
        <div class="helpful-links">
            <a href="${pageContext.request.contextPath}/contact">
                <i class="bi bi-headset"></i> Contact Support
            </a>
            <a href="${pageContext.request.contextPath}/faq">
                <i class="bi bi-question-circle"></i> FAQ
            </a>
            <a href="${pageContext.request.contextPath}/sitemap">
                <i class="bi bi-map"></i> Sitemap
            </a>
        </div>
    </div>
</div>

<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>