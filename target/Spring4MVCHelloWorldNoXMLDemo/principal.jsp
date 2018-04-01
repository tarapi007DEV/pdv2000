<%-- 
    Document   : login
    Created on : Mar 30, 2018, 7:54:25 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link href="public/libs/bootstrap-3.3.7/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="public/libs/css/global.css" rel="stylesheet" type="text/css"/>
        <link href="public/libs/css/principal.css" rel="stylesheet" type="text/css"/>
        <title>Pdv2000</title>
    </head>
    <body>
        <div class="ctnr">
            <div class="sidebar-ctnr">
                <div class="sidebar">
                    <div class="logo-ctnr">
                        <span class="glyphicon glyphicon-shopping-cart"></span>
                        <span class="logo-texto">PDV</span>
                    </div>
                    <ul class="modulos-list unstyled-ul">
                        <li class="btn-modulo">
                            <span class="glyphicon glyphicon glyphicon-usd"></span>
                            <span>Caixa</span>
                        </li>
                        <hr/>
                        <li class="btn-modulo">
                            <span class="glyphicon glyphicon-dashboard"></span>
                            <span>Dashboard</span>
                        </li>
                        <hr/>
                        <li class="btn-modulo">
                            <span class="glyphicon glyphicon-list"></span>
                            <span>Relatórios</span>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="corpo">
                <div class="caixa-ctnr">
                    <h1>ABERTURA DE CAIXA</h1>
                    <h4>Informe os valores disponíveis para iníciar suas operações </h4>
                    <div class="img-caixa">
                        <img src="public/libs/imgs/caixa.png" />
                    </div>
                    <div class="fundo-caixa"><input type="text" value="R$ 0,00" /></div>
                    <div class="info-disponivel text-center">DISPONÍVEL EM CAIXA</div>
                    <div class="btn-confirm-abert">
                        <button>
                            <span class="glyphicon glyphicon-ok"></span>CONFIRMAR ABERTURA
                        </button>
                    </div>
                </div>
                <div class="ad-ctnr"></div>
            </div>
        </div>
        <script src="public/libs/jQuery-2.2.4/jquery-2.2.4.min.js" type="text/javascript"></script>
        <script src="public/libs/bootstrap-3.3.7/bootstrap.min.js" type="text/javascript"></script>
        <script src="public/libs/js/login.js" type="text/javascript"></script>
    </body>
    <!--url(img/bg-login-locker.png) no-repeat 0 bottom #40a286-->
</html>
