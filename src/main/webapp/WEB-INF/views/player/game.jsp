<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                                <button type="button" onclick="ajudaPublico()" class="nav-link text-black-50">
                                    <img src="/imagens/public-help.svg" alt="ranking_logo" class="header_icon"/>
                                    Ajuda do público
                                </button>
                            </li>
                            <li>
                                <button type="button" onclick="ajuda5050()" class="nav-link text-black-50">
                                    <img src="/imagens/50-help.svg" alt="ranking_logo" class="header_icon"/>
                                    Ajuda 50/50
                                </button>
                            </li>
                            <li>
                                <button type="button" onclick="ajudaTrocaPergunta()" class="nav-link text-black-50">
                                    <img src="/imagens/change-help.svg" alt="ranking_logo" class="header_icon"/>
                                    Troca pergunta
                                </button>
                            </li>
                        </div>

                        <div class="nav nav-right">
                            <li class="nav-link text-black-50 ">
                                <div>
                                    <img src="/imagens/number-question.svg" alt="ranking_logo" class="header_icon"/>
                                    1/15
                                </div>
                            </li>
                            <li class="nav-link text-black-50">
                                <div>
                                    <img src="/imagens/points-icon.svg" alt="ranking_logo" class="header_icon"/>
                                    0 xp
                                </div>
                            </li>
                            <li class="nav-link text-black-50">
                                <div>
                                    <img src="/imagens/timer-icon.svg" alt="ranking_logo" class="header_icon"/>
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
                <h3 class="title_next_appt">${ronda.getPergunta().getDescricao()}</h3>
            </div>

            <div class="card-body text-center">

                <div class="btn-group-vertical" role="group">
                    <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" required>
                    <label class="btn btn-outline-success btn-w100"
                           for="btnradio1">${ronda.getPergunta().getRespostas().get(0).getTexto()}</label>

                    <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off">
                    <label class="btn btn-outline-success btn-w100"
                           for="btnradio2">${ronda.getPergunta().getRespostas().get(1).getTexto()}</label>

                    <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off">
                    <label class="btn btn-outline-success btn-w100"
                           for="btnradio3">${ronda.getPergunta().getRespostas().get(2).getTexto()}</label>

                    <input type="radio" class="btn-check" name="btnradio" id="btnradio4" autocomplete="off">
                    <label class="btn btn-outline-success btn-w100"
                           for="btnradio4">${ronda.getPergunta().getRespostas().get(3).getTexto()}</label>
                </div>


                <div>
                    <button type="button" onclick="finishGameRequest()" class="btn-green btn-w20">Sair</button>
                    <button type="button" onclick="checkAnswer()" class="btn-green btn-w20">Próxima</button>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../components/footer.jsp" %>

</body>
<script>
    function ajudaPublico() {
    }

    function ajuda5050() {
    }

    function ajudaTrocaPergunta() {
    }

    function finishGame_alternativa() {
        // send request to end game

        fetch("../player/game/terminar").then(function (response) {
            console.log(response.json());
        }).then(function (data) {
            console.log(data);
        }).catch(function () {
            console.log("Booo");
        });


        // go to player main page
        window.location.replace("/player/dashboard");
    }

    function checkAnswer() {
        // send answer

        // get reply

        // game over or new question

        // game over screen
        // show new question and update page
    }

    function finishGameRequest() {
        let oReq = new XMLHttpRequest();
        oReq.addEventListener("load", finishGame);
        oReq.open("GET", "/player/game/terminar");
        oReq.send();
    }

    function finishGame() {
        //console.log(this.responseText)
        // go to player main page
        window.location.replace("/player/dashboard");
    }
</script>

</html>