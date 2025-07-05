<%--
  Created by IntelliJ IDEA.
  User: sdilu
  Date: 7/4/2025
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank System Login</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login_page_style.css"/>
</head>
<body>
<div class="login-container d-flex align-items-center justify-content-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="login-card">
                    <div class="text-center">
                        <img src="${pageContext.request.contextPath}/resources/image/app/bank-logo.png" alt="Bank Logo"
                             class="bank-logo">
                        <h2 class="login-title">Welcome Back</h2>
                    </div>

                    <form>
                        <div class="mb-3">
                            <label for="email" class="form-label">Username</label>

                            <input type="email"
                                   class="form-control"
                                   id="email"
                                   name="email"
                                   placeholder="Enter your email"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>

                            <input type="password"
                                   class="form-control"
                                   id="password"
                                   name="password"
                                   placeholder="Enter your password"
                                   required>
                        </div>

                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="rememberMe">
                            <label class="form-check-label" for="rememberMe">Remember me</label>
                        </div>

                        <button type="button" class="btn btn-primary w-100 btn-login mb-3">
                            Login
                        </button>

                        <div class="text-center">
                            <a href="/forgot-password" class="forgot-password">Forgot Password?</a>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<script src=href="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script src=href="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script src=href="${pageContext.request.contextPath}/resources/js/login_script.js"></script>

</body>
</html>
