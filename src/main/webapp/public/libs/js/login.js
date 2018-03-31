/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function () {

    document.querySelector(".sidebar-input input").focus();

    document.onkeypress = function (e) {
        if (e.which == '13') {
            $(".sidebar-btn-entrar").click();
        }
    };

    $(".sidebar-btn-entrar").click(function () {
        console.log("Clicado no btn entrar");
        ReqManager.tryToLogin();
    });

    var ReqManager = {};

    (function (ReqManager) {
        function sendPost(url, data, callbackFn, errorFn) {
            var options = {
                url: url,
                method: "post",
                data: data
            };

            if (callbackFn) {
                options.success = function (data, textStatus, jqXHR) {
                    if (data.status == 1) {
                        console.log("Sucesso na request para :" + url);
                        callbackFn();
                    } else {
                        alert("Erro:" + status.message);
                        errorFn();
                    }
                }
            }
            if (errorFn) {
                options.error = function (jqXHR, textStatus, errorThrown) {
                    errorFn();
                }
            }
            $.ajax(options);
        }
        ;
        ReqManager.sendPost = sendPost;
    })(ReqManager);



    function tryToLogin() {
        ReqManager.sendPost(
                "rest/login",
                {username: "teste", senha: "123"},
                function () {
                    location.href = "index.jsp";
                }
        );
    }

    ReqManager.tryToLogin = tryToLogin;

};