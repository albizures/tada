$(function () {
    $('.open-modal').click(function () {
       var $button = $(this);
       var $modal = $('#' + $button.data('modal'));

       $modal.addClass('is-active');
    });
    $('.close-modal').click(function () {
       var $button = $(this);
       var $modal = $('#' + $button.data('modal'));

       $modal.removeClass('is-active');
    });
});
