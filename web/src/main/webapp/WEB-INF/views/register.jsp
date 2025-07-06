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
    <title>Bank System Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="ctx" content="${pageContext.request.contextPath}">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login_page_style.css"/>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/image/app/bank-logo.png"/>

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
                        <h2 class="login-title">Bank System Register</h2>
                    </div>

                    <form id=register-form">

                        <div class="mb-3">
                            <label for="account-number" class="form-label">Account Number</label>

                            <input type="number"
                                   class="form-control"
                                   id="account-number"
                                   name="account-number"
                                   placeholder="Enter your account number"
                                   required>
                        </div>


                        <button type="button" class="btn btn-primary w-100 btn-login mb-3" id="register-btn">
                            Register
                        </button>

                        <div class="mt-4 text-center">
                            <p class="mb-0">Do you have an account?
                                <a href="${pageContext.request.contextPath}/" class="text-primary">Login</a>
                            </p>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="model" tabindex="-1" aria-labelledby="model-title" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="modal-title">Modal title</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" id="modal-body">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/login_script.js"></script>

</body>
</html>
