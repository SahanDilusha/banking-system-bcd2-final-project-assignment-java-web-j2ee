<nav id="sidebar" class="sidebar">
    <div class="sidebar-header">
        <img src="${pageContext.request.contextPath}/resources/image/app/bank-logo.png" alt="Logo" class="logo">
        <h3>Admin Panel</h3>
    </div>

    <ul class="list-unstyled components">
        <li class="active">
            <a href="#" class="dashboard-link">
                <i class="bi bi-speedometer2"></i> Dashboard
            </a>
        </li>
        <li>
            <a href="#userSubmenu" data-bs-toggle="collapse" class="dropdown-toggle">
                <i class="bi bi-people"></i> Users
            </a>
            <ul class="collapse list-unstyled" id="userSubmenu">
                <li>
                    <a href="#"><i class="bi bi-person-plus"></i> Add User</a>
                </li>
                <li>
                    <a href="#"><i class="bi bi-person-lines-fill"></i> Manage Users</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#accountSubmenu" data-bs-toggle="collapse" class="dropdown-toggle">
                <i class="bi bi-bank"></i> Accounts
            </a>
            <ul class="collapse list-unstyled" id="accountSubmenu">
                <li>
                    <a href="#"><i class="bi bi-plus-circle"></i> New Account</a>
                </li>
                <li>
                    <a href="#"><i class="bi bi-list-check"></i> Account List</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="#">
                <i class="bi bi-currency-exchange"></i> Transactions
            </a>
        </li>
        <li>
            <a href="#">
                <i class="bi bi-gear"></i> Settings
            </a>
        </li>
    </ul>
</nav>