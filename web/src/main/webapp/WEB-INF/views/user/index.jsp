<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Dashboard</title>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user_dashboard_style.css"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body>
<div class="dashboard-container">
    <!-- Sidebar -->
    <nav id="sidebar" class="sidebar">
        <div class="sidebar-header">
            <img src="${pageContext.request.contextPath}/resources/image/app/bank-logo.png" alt="Logo" class="logo">
            <h3>My Banking</h3>
        </div>

        <ul class="list-unstyled components">
            <li class="active">
                <a href="#" class="dashboard-link">
                    <i class="bi bi-speedometer2"></i> Dashboard
                </a>
            </li>
            <li>
                <a href="#" class="accounts-link">
                    <i class="bi bi-wallet2"></i> Accounts
                </a>
            </li>
            <li>
                <a href="#" class="transfer-link">
                    <i class="bi bi-arrow-left-right"></i> Transfer
                </a>
            </li>
            <li>
                <a href="#" class="payments-link">
                    <i class="bi bi-credit-card"></i> Payments
                </a>
            </li>
            <li>
                <a href="#" class="statements-link">
                    <i class="bi bi-file-text"></i> Statements
                </a>
            </li>
            <li>
                <a href="#" class="profile-link">
                    <i class="bi bi-person"></i> Profile
                </a>
            </li>
        </ul>
    </nav>

    <!-- Main Content -->
    <div class="content">
        <!-- Top Navigation -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="bi bi-list"></i>
                </button>

                <div class="d-flex align-items-center">
                    <div class="notifications me-3">
                        <a href="#" class="position-relative">
                            <i class="bi bi-bell fs-5"></i>
                            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                                3
                            </span>
                        </a>
                    </div>
                    <div class="dropdown">
                        <a href="#" class="d-flex align-items-center text-dark text-decoration-none dropdown-toggle"
                           id="userDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                            <img src="https://github.com/mdo.png" alt="User" width="32" height="32"
                                 class="rounded-circle me-2">
                            <strong>John Doe</strong>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end shadow" aria-labelledby="userDropdown">
                            <li><a class="dropdown-item" href="#"><i class="bi bi-person"></i> Profile</a></li>
                            <li><a class="dropdown-item" href="#"><i class="bi bi-gear"></i> Settings</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="#"><i class="bi bi-box-arrow-right"></i> Sign out</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>

        <!-- Dashboard Content -->
        <div class="container-fluid p-4">
            <!-- Welcome Section -->
            <div class="row mb-4">
                <div class="col-12">
                    <h2>Welcome back, John!</h2>
                    <p class="text-muted">Here's your financial overview</p>
                </div>
            </div>

            <!-- Account Summary Cards -->
            <div class="row g-4 mb-4">
                <!-- Savings Account -->
                <div class="col-12 col-md-6 col-xl-4">
                    <div class="card account-card h-100">
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div>
                                    <h6 class="card-subtitle text-muted">Savings Account</h6>
                                    <h5 class="card-title mb-0">**** 1234</h5>
                                </div>
                                <span class="badge bg-success">Active</span>
                            </div>
                            <h3 class="mb-3">$12,345.67</h3>
                            <div class="d-flex justify-content-between">
                                <button class="btn btn-sm btn-outline-primary">View Details</button>
                                <button class="btn btn-sm btn-primary">Transfer</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Checking Account -->
                <div class="col-12 col-md-6 col-xl-4">
                    <div class="card account-card h-100">
                        <div class="card-body">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div>
                                    <h6 class="card-subtitle text-muted">Checking Account</h6>
                                    <h5 class="card-title mb-0">**** 5678</h5>
                                </div>
                                <span class="badge bg-success">Active</span>
                            </div>
                            <h3 class="mb-3">$3,456.78</h3>
                            <div class="d-flex justify-content-between">
                                <button class="btn btn-sm btn-outline-primary">View Details</button>
                                <button class="btn btn-sm btn-primary">Transfer</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Quick Actions -->
                <div class="col-12 col-xl-4">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title mb-3">Quick Actions</h5>
                            <div class="d-grid gap-2">
                                <button class="btn btn-outline-primary">
                                    <i class="bi bi-arrow-left-right"></i> New Transfer
                                </button>
                                <button class="btn btn-outline-primary">
                                    <i class="bi bi-credit-card"></i> Pay Bills
                                </button>
                                <button class="btn btn-outline-primary">
                                    <i class="bi bi-file-text"></i> Download Statement
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Recent Transactions -->
            <div class="row mb-4">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="card-title mb-0">Recent Transactions</h5>
                            <a href="#" class="btn btn-sm btn-link">View All</a>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th>Date</th>
                                        <th>Description</th>
                                        <th>Type</th>
                                        <th>Amount</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>2025-07-06</td>
                                        <td>Grocery Store</td>
                                        <td>Debit</td>
                                        <td class="text-danger">-$82.45</td>
                                        <td><span class="badge bg-success">Completed</span></td>
                                    </tr>
                                    <tr>
                                        <td>2025-07-05</td>
                                        <td>Salary Deposit</td>
                                        <td>Credit</td>
                                        <td class="text-success">+$3,500.00</td>
                                        <td><span class="badge bg-success">Completed</span></td>
                                    </tr>
                                    <tr>
                                        <td>2025-07-05</td>
                                        <td>Online Transfer</td>
                                        <td>Transfer</td>
                                        <td class="text-danger">-$150.00</td>
                                        <td><span class="badge bg-warning">Pending</span></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Additional Features -->
            <div class="row">
                <!-- Upcoming Payments -->
                <div class="col-12 col-md-6 mb-4">
                    <div class="card h-100">
                        <div class="card-header">
                            <h5 class="card-title mb-0">Upcoming Payments</h5>
                        </div>
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <div>
                                        <h6 class="mb-0">Electricity Bill</h6>
                                        <small class="text-muted">Due in 3 days</small>
                                    </div>
                                    <span class="badge bg-warning rounded-pill">$75.00</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center">
                                    <div>
                                        <h6 class="mb-0">Internet Bill</h6>
                                        <small class="text-muted">Due in 5 days</small>
                                    </div>
                                    <span class="badge bg-warning rounded-pill">$45.00</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>

                <!-- Spending Analysis -->
                <div class="col-12 col-md-6 mb-4">
                    <div class="card h-100">
                        <div class="card-header">
                            <h5 class="card-title mb-0">Spending Analysis</h5>
                        </div>
                        <div class="card-body">
                            <canvas id="spendingChart"></canvas>
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
<script src="${pageContext.request.contextPath}/resources/js/chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user_dashboard_script.js"></script>

</body>
</html>