$(document).ready(function () {
    // Handle transfer type change
    $('input[name="transferType"]').change(function () {
        if ($(this).attr('id') === 'external') {
            $('#bankDetails').slideDown();
        } else {
            $('#bankDetails').slideUp();
        }
    });

    // Form validation
    $('#transferForm').on('submit', function (e) {
        e.preventDefault();
    });
});