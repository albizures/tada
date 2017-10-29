$(function() {
    $(".add-to-cart").click(function() {
        var id = $(this).data("product");
        var price = $(this).data("price");
        var name = $(this).data("name");
        ajax_("/cart", "POST", {action:"add", product: id, price: price, name: name}, function(response){
            console.log(response.responseText);
        });
    });
    
    $(".remove-cart-item").click(function(){
        $(this).closest("tr").remove().fadeOut();
        ajax_("/cart","POST",{action: "remove",index: $(this).data("index")},function(response){
           console.log(response.responseText); 
        });
    });
});


