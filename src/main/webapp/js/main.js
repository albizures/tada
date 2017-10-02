$(function () {
    $('.open-modal').click(function () {
       var $button = $(this);
       var $modal = $('#' + $button.data('modal'));

       $modal.addClass('is-active');
    });

    $('.close-modal').click(function () {
       var $button = $(this);
       var idModal = $button.data('modal');
       
       if (!idModal) {
           idModal = $button.closest('.modal').attr("id");
           $button.data('modal', idModal);
       }

       var $modal = $('#' + idModal);
       $modal.removeClass('is-active');
       location.search = '';
    });
    


});
