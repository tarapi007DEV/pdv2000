/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
                    alert("Erro: " + data.message);
                    if (errorFn) {
                        errorFn();
                    }
                }
            };
        }
        options.error = function (jqXHR, textStatus, errorThrown) {
            if (errorFn) {
                errorFn();
            } else {
                alert("Erro: " + jqXHR.status + " Detalhes no console do navegador.");
                console.log(jqXHR);
                console.log(errorThrown);
            }
        };
        $.ajax(options);
    }

    function getInputsFrom(jElem) {
        var dados = {};
        var inputsArr = jElem.find("[name]");
        $.each(inputsArr, function (index, elem) {
            dados[elem.name] = elem.value;
        });
        return dados;
    }

    // EXPORTS
    ReqManager.sendPost = sendPost;
    ReqManager.getInputsFrom = getInputsFrom;
})(ReqManager);

var LoginMngr = {};

(function (LoginMngr) {

    function tryToLogin() {
        var username = $("[name=username]").val();
        var senha = $("[name=senha]").val();
        
        // VALIDANDO USUÁRIO E SENHA EM BRANCOS
        if (!username || username.trim() == ""
                || !senha || senha.trim() == "") {
            alert("Usuário e senha são obrigatórios.");
            return false;
        }
        var dados = ReqManager.getInputsFrom($(".sidebar-input-group"));
        
        ReqManager.sendPost(
                "login",
                dados,
                function () {
                    location.href = "principal.jsp";
//                    location.href = "index.jsp";
                }
        );
    }

    // EXPORTS
    LoginMngr.tryToLogin = tryToLogin;
})(LoginMngr);

window.onload = function () {

    document.querySelector(".sidebar-input input").focus();
    document.onkeypress = function (e) {
        if (e.which == '13') {
            LoginMngr.tryToLogin();
        }
    };

    $(".sidebar-btn-entrar").click(function () {
        console.log("Clicado no btn entrar");
        LoginMngr.tryToLogin();
    });
};
