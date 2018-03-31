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
        <title>Login Pdv2000</title>
        <link href="public/libs/bootstrap-3.3.7/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="public/libs/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="ctnr">
            <div class="topbar vert-ctnr">
                <div class="vert-item">
                    <div class="logo-ctnr">
                        <span class="glyphicon glyphicon-shopping-cart"></span>
                        <span class="logo-texto">PDV</span>
                    </div>
                </div>
            </div>
            <div class="sidebar-ctnr">
                <div class="sidebar">
                    <div class="sidebar-text"> 
                        <h2>Identificação</h2> 
                        <p>Informe seu usuário e senha para acessar a conta de sua empresa no MarketUP. Caso ainda não possua uma conta, cadastre-se!</p> 
                    </div>

                    <div class="sidebar-input-group">
                        <div class="sidebar-input vert-ctnr">
                            <span class="glyphicon glyphicon-user vert-item"></span>
                            <input name="usuario">
                        </div>
                        <div class="sidebar-input vert-ctnr">
                            <span class="glyphicon glyphicon-lock vert-item"></span>
                            <input name="senha">
                        </div>
                        <div class="sidebar-esqueci">
                            <a class="sidebar-esqueci" href="javascript:void(0)">Esqueci minha senha</a>
                        </div>
                    </div>

                    <div class="sidebar-btn-entrar vert-ctnr">
                        <span class="vert-item">Entrar</span>
                    </div>
                </div>
            </div>
            <div class="corpo">

            </div>
        </div>
        <script src="public/libs/jQuery-2.2.4/jquery-2.2.4.min.js" type="text/javascript"></script>
        <script src="public/libs/bootstrap-3.3.7/bootstrap.min.js" type="text/javascript"></script>
        <script src="public/libs/js/login.js" type="text/javascript"></script>
    </body>
    <!--url(img/bg-login-locker.png) no-repeat 0 bottom #40a286-->
</html>
