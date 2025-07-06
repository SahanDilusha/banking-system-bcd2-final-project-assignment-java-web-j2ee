<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
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
            <!-- Stats Cards -->
            <div class="row g-4 mb-4">
                <div class="col-12 col-sm-6 col-xl-3">
                    <div class="card stat-card">
                        <div class="card-body">
                            <div class="d-flex align-items-center">
                                <div class="stat-icon bg-primary">
                                    <i class="bi bi-people"></i>
                                </div>
                                <div class="ms-3">
                                    <h5 class="card-title mb-0">Total Users</h5>
                                    <h2 class="mt-2 mb-0">1,234</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-xl-3">
                    <div class="card stat-card">
                        <div class="card-body">
                            <div class="d-flex align-items-center">
                                <div class="stat-icon bg-success">
                                    <i class="bi bi-currency-dollar"></i>
                                </div>
                                <div class="ms-3">
                                    <h5 class="card-title mb-0">Total Balance</h5>
                                    <h2 class="mt-2 mb-0">$5.2M</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-xl-3">
                    <div class="card stat-card">
                        <div class="card-body">
                            <div class="d-flex align-items-center">
                                <div class="stat-icon bg-warning">
                                    <i class="bi bi-arrow-left-right"></i>
                                </div>
                                <div class="ms-3">
                                    <h5 class="card-title mb-0">Transactions</h5>
                                    <h2 class="mt-2 mb-0">856</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-xl-3">
                    <div class="card stat-card">
                        <div class="card-body">
                            <div class="d-flex align-items-center">
                                <div class="stat-icon bg-danger">
                                    <i class="bi bi-exclamation-triangle"></i>
                                </div>
                                <div class="ms-3">
                                    <h5 class="card-title mb-0">Alerts</h5>
                                    <h2 class="mt-2 mb-0">3</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Recent Activities -->
            <div class="row">
                <div class="col-12 col-xl-8 mb-4">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-title mb-0">Recent Transactions</h5>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>User</th>
                                        <th>Type</th>
                                        <th>Amount</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>#12345</td>
                                        <td>John Doe</td>
                                        <td>Transfer</td>
                                        <td>$1,200</td>
                                        <td><span class="badge bg-success">Completed</span></td>
                                    </tr>
                                    <tr>
                                        <td>#12346</td>
                                        <td>Jane Smith</td>
                                        <td>Withdrawal</td>
                                        <td>$500</td>
                                        <td><span class="badge bg-warning">Pending</span></td>
                                    </tr>
                                    <!-- Add more rows as needed -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-xl-4 mb-4">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-title mb-0">System Notifications</h5>
                        </div>
                        <div class="card-body">
                            <div class="notification-item">
                                <div class="icon bg-info">
                                    <i class="bi bi-info-circle"></i>
                                </div>
                                <div class="details">
                                    <h6>System Update</h6>
                                    <p>System maintenance scheduled for tonight</p>
                                    <small>2 hours ago</small>
                                </div>
                            </div>
                            <div class="notification-item">
                                <div class="icon bg-warning">
                                    <i class="bi bi-exclamation-circle"></i>
                                </div>
                                <div class="details">
                                    <h6>Server Load</h6>
                                    <p>High server load detected</p>
                                    <small>5 hours ago</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- JavaScript -->
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/admin_script.js"></script>
</body>
</html>