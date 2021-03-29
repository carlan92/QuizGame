<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>
    <%@ include file="../components/sidenav-login.jsp" %>

    <div class="main">
        <div class="white_box box-align-left">

            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="perfil-row">
                        <img src="\imagens\fill_form.svg" alt="fill form" class="img-fill-form" />
                    </div>

                    <div class="perfil-row">
                        <h3 class="registo">Registo de Utente</h3>
                    </div>
                </div>
            </div>


            <form class="registration-form" action="/public/register-user" method="post" enctype="multipart/form-data">

                <div class="perfil-main-col">

                    <div class="perfil-row">
                        <div class="cell-row cell-morada">
                            <label for="nome_id">Nome Completo *</label>
                            <input id="nome_id" type="text" class="form-input" value="${user.getName()}" name="name"
                                required placeholder="O seu nome completo" />
                            <p class="msg-error">${errorMsgName}</p>
                        </div>
                    </div>


                    <div class="perfil-row">
                        <div class="cell-row">
                            <label for="localidade_id">Localidade *</label>
                            <input id="localidade_id" type="text" class="form-input" value="${user.getCity()}"
                                name="city" required placeholder="A sua localidade" />
                            <p class="msg-error">${errorMsgCity}</p>
                        </div>
                    </div>



                    <div class="perfil-row">

                        <div class="cell-row">
                            <label for="e-mail_id">E-mail *</label>
                            <input id="e-mail_id" type="email" class="form-input" value="${user.getEmail()}"
                                name="email" required placeholder="O seu e-mail" />
                            <p class="msg-error">${errorMsgEmail}</p>
                        </div>
                    </div>

                    <div class="perfil-row">
                        <div class="cell-row">
                            <label for="username_id">Username *</label>
                            <input id="username_id" type="text" class="form-input" name="username" required
                                placeholder="Introduza o username" value="${user.getUsername()}" />
                            <p class="msg-error">${errorMsgUsername}</p>
                        </div>

                    </div>

                    <div class="perfil-row">
                        <div class="cell-row">
                            <label for="password_id">Palavra-Passe *</label>
                            <input id="password_id" type="password" class="form-input" minlength="1" maxlength="15"
                                value="${user.getPassword()}" name="password" required placeholder="Palavra-passe" />
                            <p class="msg-error">${errorMsgPassword}</p>
                        </div>
                        <div class="cell-row">
                            <label for="confirmarPassword_id">Confirmar Palavra-Passe *</label>
                            <input id="confirmarPassword_id" type="password" class="form-input" minlength="1"
                                maxlength="15" name="confirmarPassword2" required placeholder="Repetir palavra-passe" />
                            <p class="msg-error">${errorMsgPassword2}</p>
                        </div>
                    </div>


                </div>
                <button type="submit" class="btn btn-blue">Criar Conta</button>
            </form>


        </div>
    </div>

</body>

</html>