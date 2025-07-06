$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
        $('.content').toggleClass('active');

        // Save state to localStorage
        localStorage.setItem('sidebarState',
            $('#sidebar').hasClass('active') ? 'collapsed' : 'expanded');
    });

    // Load saved sidebar state
    const sidebarState = localStorage.getItem('sidebarState');
    if (sidebarState === 'collapsed') {
        $('#sidebar').addClass('active');
        $('.content').addClass('active');
    }

    // Active link handling
    $('.sidebar .components a').on('click', function () {
        $('.sidebar .components li').removeClass('active');
        $(this).closest('li').addClass('active');
    });

    // Dropdown menu handling
    $('.dropdown-toggle').on('click', function (e) {
        e.preventDefault();
        $(this).next('.collapse').collapse('toggle');
    });

    // Theme switcher
    $('#themeSwitch').on('change', function () {
        $('body').toggleClass('dark-theme');
        localStorage.setItem('theme', $('body').hasClass('dark-theme') ? 'dark' : 'light');
    });

    // Load saved theme
    if (localStorage.getItem('theme') === 'dark') {
        $('body').addClass('dark-theme');
        $('#themeSwitch').prop('checked', true);
    }

    // Responsive table handling
    function checkTableResponsiveness() {
        if ($(window).width() < 768) {
            $('.table-responsive').addClass('table-mobile');
        } else {
            $('.table-responsive').removeClass('table-mobile');
        }
    }

    // Check table responsiveness on window resize
    $(window).resize(checkTableResponsiveness);
    checkTableResponsiveness();

    // Initialize tooltips
    $('[data-bs-toggle="tooltip"]').tooltip();

    // Initialize popovers
    $('[data-bs-toggle="popover"]').popover();

    // Card hover effects
    $('.stat-card').hover(
        function () {
            $(this).addClass('card-hover');
        },
        function () {
            $(this).removeClass('card-hover');
        }
    );

    // Notification item hover effect
    $('.notification-item').hover(
        function () {
            $(this).addClass('notification-hover');
        },
        function () {
            $(this).removeClass('notification-hover');
        }
    );

    // Table row hover effect
    $('.table-hover tr').hover(
        function () {
            $(this).addClass('row-hover');
        },
        function () {
            $(this).removeClass('row-hover');
        }
    );

    // Mobile menu handling
    $('.mobile-menu-toggle').on('click', function () {
        $('.sidebar').toggleClass('mobile-active');
    });

    // Close mobile menu when clicking outside
    $(document).on('click', function (e) {
        if ($(window).width() < 768) {
            if (!$(e.target).closest('.sidebar, .mobile-menu-toggle').length) {
                $('.sidebar').removeClass('mobile-active');
            }
        }
    });

    // Smooth scroll to top
    $('.scroll-to-top').on('click', function () {
        $('html, body').animate({scrollTop: 0}, 'slow');
    });

    // Show/hide scroll to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.scroll-to-top').fadeIn();
        } else {
            $('.scroll-to-top').fadeOut();
        }
    });

    // Card collapse functionality
    $('.card-header .collapse-icon').on('click', function () {
        $(this).closest('.card').find('.card-body').collapse('toggle');
        $(this).toggleClass('collapsed');
    });

    // Sidebar minimize for desktop
    $('.minimize-sidebar').on('click', function () {
        $('.admin-container').toggleClass('sidebar-mini');
        localStorage.setItem('sidebarState',
            $('.admin-container').hasClass('sidebar-mini') ? 'mini' : 'full');
    });

    // Load saved sidebar state
    if (localStorage.getItem('sidebarState') === 'mini') {
        $('.admin-container').addClass('sidebar-mini');
    }

    // Handle dropdown menu positioning
    $('.dropdown-toggle').on('show.bs.dropdown', function () {
        var dropdown = $(this).find('.dropdown-menu');
        var position = dropdown.offset();
        var windowHeight = $(window).height();
        var dropdownHeight = dropdown.height();

        if (position.top + dropdownHeight > windowHeight) {
            dropdown.css('top', 'auto').css('bottom', '100%');
        }
    });

    // Add fade effect to alerts
    $('.alert').fadeIn('slow');

    // Auto hide alerts after 5 seconds
    setTimeout(function () {
        $('.alert').fadeOut('slow');
    }, 5000);
});