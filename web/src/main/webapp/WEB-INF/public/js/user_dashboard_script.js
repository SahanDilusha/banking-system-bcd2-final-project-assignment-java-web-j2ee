$(document).ready(function() {
    // Sidebar toggle
    $('#sidebarCollapse').on('click', function() {
        $('.sidebar').toggleClass('active');
        $('.content').toggleClass('active');

        // Store sidebar state
        localStorage.setItem('sidebarState',
            $('.sidebar').hasClass('active') ? 'collapsed' : 'expanded'
        );
    });

    // Load saved sidebar state
    const sidebarState = localStorage.getItem('sidebarState');
    if (sidebarState === 'collapsed') {
        $('.sidebar').addClass('active');
        $('.content').addClass('active');
    }

    // Close sidebar on mobile when clicking outside
    $(document).on('click touchstart', function(e) {
        if ($(window).width() <= 768) {
            if (!$(e.target).closest('.sidebar, #sidebarCollapse').length) {
                $('.sidebar').addClass('active');
                $('.content').addClass('active');
            }
        }
    });

    // Reset sidebar state on window resize
    $(window).resize(function() {
        if ($(window).width() > 768) {
            $('.sidebar').removeClass('active');
            $('.content').removeClass('active');
        }
    });

    // Initialize spending chart
    const ctx = document.getElementById('spendingChart').getContext('2d');
    new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: ['Shopping', 'Bills', 'Entertainment', 'Food', 'Transport'],
            datasets: [{
                data: [300, 150, 100, 200, 125],
                backgroundColor: [
                    '#4e73df',  // Primary
                    '#1cc88a',  // Success
                    '#36b9cc',  // Info
                    '#f6c23e',  // Warning
                    '#e74a3b'   // Danger
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: {
                    position: 'bottom'
                },
                title: {
                    display: true,
                    text: 'Monthly Spending Distribution'
                }
            },
            cutout: '70%'
        }
    });

    // Account card hover effects
    $('.account-card').hover(
        function() { $(this).addClass('shadow-lg'); },
        function() { $(this).removeClass('shadow-lg'); }
    );

    // Initialize tooltips
    $('[data-bs-toggle="tooltip"]').tooltip();

    // Initialize popovers
    $('[data-bs-toggle="popover"]').popover();

    // Mobile menu handling
    $('.mobile-menu-toggle').on('click', function() {
        $('.sidebar').toggleClass('mobile-active');
    });

    // Close mobile menu when clicking outside
    $(document).on('click', function(e) {
        if ($(window).width() < 768) {
            if (!$(e.target).closest('.sidebar, .mobile-menu-toggle').length) {
                $('.sidebar').removeClass('mobile-active');
            }
        }
    });

    // Transaction table search
    $('#transactionSearch').on('keyup', function() {
        var value = $(this).val().toLowerCase();
        $('#transactionTable tbody tr').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
        });
    });

    // Quick action buttons
    $('.quick-action-btn').on('click', function() {
        const action = $(this).data('action');
        switch(action) {
            case 'transfer':
                showTransferModal();
                break;
            case 'payment':
                showPaymentModal();
                break;
            case 'statement':
                downloadStatement();
                break;
        }
    });

    // Show transfer modal
    function showTransferModal() {
        $('#transferModal').modal('show');
    }

    // Show payment modal
    function showPaymentModal() {
        $('#paymentModal').modal('show');
    }

    // Download statement
    function downloadStatement() {
        // Implementation for statement download
        alert('Downloading statement...');
    }

    // Handle notifications
    $('.notifications-toggle').on('click', function(e) {
        e.preventDefault();
        $('.notifications-dropdown').toggle();
    });

    // Close notifications dropdown when clicking outside
    $(document).on('click', function(e) {
        if (!$(e.target).closest('.notifications-area').length) {
            $('.notifications-dropdown').hide();
        }
    });

    // Mark notification as read
    $('.mark-as-read').on('click', function(e) {
        e.preventDefault();
        $(this).closest('.notification-item').fadeOut();
        updateNotificationCount();
    });

    // Update notification count
    function updateNotificationCount() {
        const count = $('.notification-item:visible').length;
        $('.notification-badge').text(count);
        if (count === 0) {
            $('.notification-badge').hide();
        }
    }

    // Account balance animation
    $('.account-balance').each(function() {
        const balance = parseFloat($(this).data('balance'));
        $({ Counter: 0 }).animate({
            Counter: balance
        }, {
            duration: 1000,
            easing: 'swing',
            step: function() {
                $(this).text('$' + this.Counter.toFixed(2));
            }
        });
    });

    // Handle theme switching
    $('#themeSwitch').on('change', function() {
        if ($(this).is(':checked')) {
            $('body').addClass('dark-theme');
            localStorage.setItem('theme', 'dark');
        } else {
            $('body').removeClass('dark-theme');
            localStorage.setItem('theme', 'light');
        }
    });

    // Load saved theme
    if (localStorage.getItem('theme') === 'dark') {
        $('body').addClass('dark-theme');
        $('#themeSwitch').prop('checked', true);
    }

    // Handle window resize
    $(window).resize(function() {
        if ($(window).width() > 768) {
            $('.sidebar').removeClass('mobile-active');
        }
    });

    // Initialize date range picker for transaction filter
    if ($.fn.daterangepicker) {
        $('#transactionDateRange').daterangepicker({
            ranges: {
                'Today': [moment(), moment()],
                'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                'This Month': [moment().startOf('month'), moment().endOf('month')],
                'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
            },
            startDate: moment().subtract(29, 'days'),
            endDate: moment()
        });
    }
});