<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard - New Account</title>
    <meta name="ctx" content="${pageContext.request.contextPath}">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/image/app/bank-logo.png"/>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_style.css"/>
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body>
<div class="admin-container">
    <!-- Sidebar -->

    <jsp:include page="/WEB-INF/views/admin/component/sidebar.jsp"/>

    <!-- Main Content -->
    <div class="content">
        <!-- Top Navigation -->
        <jsp:include page="/WEB-INF/views/admin/component/top-navigation.jsp"/>

        <!-- Dashboard Content -->
        <div class="container-fluid p-4">
            <div class="row">
                <div class="col-12">
                    <div class="card shadow">
                        <div class="card-header bg-primary bg-gradient">
                            <h5 class="card-title text-white mb-0">Create New Account</h5>
                        </div>
                        <form>
                            <!-- Personal Information -->
                            <div class="row mb-4">
                                <div class="col-12">
                                    <div class="bg-light p-2 rounded mb-3">
                                        <i class="bi bi-person-fill"></i> Personal Information
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">First Name</label>
                                    <input type="text" class="form-control" placeholder="Enter first name">
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Last Name</label>
                                    <input type="text" class="form-control" placeholder="Enter last name">
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Email</label>
                                    <input type="email" class="form-control" placeholder="Enter email">
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Phone Number</label>
                                    <input type="tel" class="form-control" placeholder="Enter phone number">
                                </div>
                            </div>

                            <!-- Address Information -->
                            <div class="row mb-4">
                                <div class="col-12">
                                    <div class="bg-light p-2 rounded mb-3">
                                        <i class="bi bi-geo-alt-fill"></i> Address Information
                                    </div>
                                </div>
                                <div class="col-12 mb-3">
                                    <label class="form-label">Street Address</label>
                                    <input type="text" class="form-control" placeholder="Enter street address">
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label class="form-label">City</label>
                                    <input type="text" class="form-control" placeholder="Enter city">
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label class="form-label">State</label>
                                    <input type="text" class="form-control" placeholder="Enter state">
                                </div>
                                <div class="col-md-4 mb-3">
                                    <label class="form-label">ZIP Code</label>
                                    <input type="text" class="form-control" placeholder="Enter ZIP code">
                                </div>
                            </div>

                            <!-- Account Details -->
                            <div class="row mb-4">
                                <div class="col-12">
                                    <div class="bg-light p-2 rounded mb-3">
                                        <i class="bi bi-bank"></i> Account Details
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Account Type</label>
                                    <select class="form-select">
                                        <option selected disabled>Select Account Type</option>
                                        <option>Savings Account</option>
                                        <option>Checking Account</option>
                                        <option>Business Account</option>
                                    </select>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">Initial Deposit</label>
                                    <div class="input-group">
                                        <span class="input-group-text">$</span>
                                        <input type="number" class="form-control" placeholder="Enter amount">
                                    </div>
                                </div>
                            </div>

                            <!-- Identification -->
                            <div class="row mb-4">
                                <div class="col-12">
                                    <div class="bg-light p-2 rounded mb-3">
                                        <i class="bi bi-card-heading"></i> Identification
                                    </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">ID Type</label>
                                    <select class="form-select">
                                        <option selected disabled>Select ID Type</option>
                                        <option>Passport</option>
                                        <option>Driver's License</option>
                                        <option>National ID</option>
                                    </select>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label class="form-label">ID Number</label>
                                    <input type="text" class="form-control" placeholder="Enter ID number">
                                </div>
                                <div class="col-12">
                                    <label class="form-label">Upload ID Document</label>
                                    <input type="file" class="form-control">
                                </div>
                            </div>

                            <div class="col-12">
                                <button type="button" class="btn btn-primary me-2">
                                    <i class="bi bi-check-circle"></i> Create Account
                                </button>
                                <button type="reset" class="btn btn-secondary">
                                    <i class="bi bi-x-circle"></i> Reset
                                </button>
                            </div>
                        </form>
                        </div>
                    </div>
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

<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/admin_script.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/admin_new_account_script.js"></script>

</body>
</html>