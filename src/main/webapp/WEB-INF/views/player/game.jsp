<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>
<%@ include file="../components/header.jsp" %>
<div class="main">
    <div class="white_box game-box">
        <div class="px-3 py-2 bg-white text-black">
            <div class="container">
                <div class="d-flex align-items-center justify-content-center justify-content-lg-start">

                    <ul class="nav text-small status-bar">

                        <div class="nav">
                            <li>
                                <a href="#" class="nav-link text-black-50">
                                    <img src="imagens/public-help.svg" alt="ranking_logo" class="header_icon" />
                                    Ajuda do público
                                </a>
                            </li>
                            <li>
                                <a href="#" class="nav-link text-black-50">
                                    <img src="imagens/50-help.svg" alt="ranking_logo" class="header_icon" />
                                    Ajuda 50/50
                                </a>
                            </li>
                            <li>
                                <a href="#" class="nav-link text-black-50">
                                    <img src="imagens/change-help.svg" alt="ranking_logo" class="header_icon" />
                                    Troca pergunta
                                </a>
                            </li>
                        </div>

                        <div class="nav nav-right">
                            <li class="nav-link text-black-50 ">
                                <div>
                                    <img src="imagens/number-question.svg" alt="ranking_logo" class="header_icon" />
                                    1/15
                                </div>
                            </li>
                            <li class="nav-link text-black-50">
                                <div>
                                    <img src="imagens/points-icon.svg" alt="ranking_logo" class="header_icon" />
                                    0 xp
                                </div>
                            </li>
                            <li class="nav-link text-black-50">
                                <div>
                                    <img src="imagens/timer-icon.svg" alt="ranking_logo" class="header_icon" />
                                    00:10
                                </div>
                            </li>
                        </div>

                    </ul>
                </div>
            </div>
        </div>
        <div class="white_box ">

            <div class="perfil-row text-center">
                <h3 class="title_next_appt">Qual a capital de Portugal?</h3>
            </div>

            <div class="card-body text-center">

                <div class="btn-group-vertical" role="group">
                    <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" checked>
                    <label class="btn btn-outline-success btn-w100" for="btnradio1">Lisboa</label>

                    <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off">
                    <label class="btn btn-outline-success btn-w100" for="btnradio2">Porto</label>

                    <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off">
                    <label class="btn btn-outline-success btn-w100" for="btnradio3">Algarve</label>

                    <input type="radio" class="btn-check" name="btnradio" id="btnradio4" autocomplete="off">
                    <label class="btn btn-outline-success btn-w100" for="btnradio4">Coimbra</label>
                </div>


                <div>
                    <button type="button" class="btn-green btn-w20">Sair</button>
                    <button type="button" class="btn-green btn-w20">Próxima </button>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../components/footer.jsp" %>

</body>

</html>