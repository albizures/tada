function ajax_(url, method, data, callback) {
    $.ajax({
        url: url,
        method: method,
        data: data
    }).done(function (data,textStatus, jqXHR) {
        callback(jqXHR);
    }).fail(function (jqXHR, textStatus,errorThrown) {
        callback(jqXHR);
    });
}

function saludar(){
    alert("hola");
}
