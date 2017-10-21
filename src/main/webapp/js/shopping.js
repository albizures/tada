$(function() {
    alert("hola");
    $(".add-to-cart").click(function() {
        var id = $(this).data("product");
        var price = $(this).data("price");
        ajax_("/cart", "POST", {action:"add", product: id, price: price}, function(response){
            console.log(response.responseText);
        });
    });
    
    $("#get-cart").click(function(){
        ajax_("/cart","POST",{action: "get"},function(response){
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


