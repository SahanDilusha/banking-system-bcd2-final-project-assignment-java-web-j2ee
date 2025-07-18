<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="ctx" content="${pageContext.request.contextPath}">

    <title>Account Dashboard | Transfer</title>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/user_dashboard_style.css"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>

<body>
<div class="dashboard-container">
    <!-- Sidebar -->
    <jsp:include page="/WEB-INF/views/user/component/sidebar.jsp"/>
    <!-- Main Content -->
    <div class="content">
        <!-- Top Navigation -->
        <jsp:include page="/WEB-INF/views/user/component/top-navigation.jsp"/>

        <!-- Dashboard Content -->
        <div class="container-fluid p-4">
            <!-- Page Title -->
            <div class="row mb-4">
                <div class="col-12">
                    <h2>Transfer Money</h2>
                    <p class="text-muted">Send money to other accounts securely</p>
                </div>
            </div>

            <div class="row">
                <!-- BankTransfer Form Card -->
                <div class="col-12 col-lg-8 mb-4">
                    <div class="card shadow-sm">
                        <div class="card-header bg-white">
                            <h5 class="card-title mb-0">Transfer Details</h5>
                        </div>
                        <div class="card-body">
                            <form id="transferForm">
                                <!-- From Account -->
                                <div class="mb-4">
                                    <label class="form-label">From Account</label>
                                    <select class="form-select" id="fromAccount">
                                        <option selected disabled>Select source account</option>
                                        <option value="1">Savings Account (**** 1234) - $12,345.67</option>
                                        <option value="2">Checking Account (**** 5678) - $3,456.78</option>
                                    </select>
                                </div>

                                <!-- BankTransfer Type -->
                                <div class="mb-4">
                                    <label class="form-label">Transfer Type</label>
                                    <div class="btn-group w-100" role="group">
                                        <input type="radio" class="btn-check" name="transferType" id="internal" checked>
                                        <label class="btn btn-outline-primary" for="internal">
                                            <i class="bi bi-bank"></i> Internal Transfer
                                        </label>

                                        <input type="radio" class="btn-check" name="transferType" id="external">
                                        <label class="btn btn-outline-primary" for="external">
                                            <i class="bi bi-globe"></i> External Transfer
                                        </label>
                                    </div>
                                </div>

                                <!-- Recipient Details -->
                                <div class="mb-4">
                                    <label class="form-label">Recipient Details</label>
                                    <div class="card bg-light">
                                        <div class="card-body">
                                            <div class="mb-3">
                                                <label class="form-label">Account Number</label>
                                                <input type="text" class="form-control"
                                                       placeholder="Enter account number">
                                            </div>
                                            <div class="mb-3">
                                                <label class="form-label">Account Holder Name</label>
                                                <input type="text" class="form-control"
                                                       placeholder="Enter recipient name">
                                            </div>
                                            <div class="mb-0" id="bankDetails" style="display: none;">
                                                <div class="mb-3">
                                                    <label class="form-label">Bank Name</label>
                                                    <input type="text" class="form-control"
                                                           placeholder="Enter bank name">
                                                </div>
                                                <div class="mb-0">
                                                    <label class="form-label">SWIFT/BIC Code</label>
                                                    <input type="text" class="form-control"
                                                           placeholder="Enter SWIFT code">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <!-- Amount and Details -->
                                <div class="row mb-4">
                                    <div class="col-md-6 mb-3 mb-md-0">
                                        <label class="form-label">Amount</label>
                                        <div class="input-group">
                                            <span class="input-group-text">$</span>
                                            <input type="number" class="form-control" placeholder="Enter amount">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label">Transfer Date</label>
                                        <input type="date" class="form-control" value="${today}">
                                    </div>
                                </div>

                                <!-- Reference -->
                                <div class="mb-4">
                                    <label class="form-label">Reference/Note</label>
                                    <textarea class="form-control" rows="2"
                                              placeholder="Add a note (optional)"></textarea>
                                </div>

                                <!-- Submit Buttons -->
                                <div class="d-flex justify-content-between align-items-center">
                                    <button type="button" class="btn btn-outline-secondary">
                                        <i class="bi bi-arrow-left"></i> Back
                                    </button>
                                    <div>
                                        <button type="button" class="btn btn-light me-2">Save as Draft</button>
                                        <button type="submit" class="btn btn-primary" id="transferBtn">
                                            <i class="bi bi-arrow-right-circle"></i> Continue
                                        </button>
                                    </div>
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
<script src="${pageContext.request.contextPath}/resources/js/chart.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user_dashboard_script.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/user_transfer_script.js"></script>


</body>
</html>