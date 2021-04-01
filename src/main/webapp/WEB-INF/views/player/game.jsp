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
                                <button type="button" onclick="ajudaPublicoRequest()" id="id_ajudaPublico"
                                        class="nav-link text-black-50">
                                    <img src="/imagens/public-help.svg" alt="ranking_logo" class="header_icon"/>
                                    Ajuda do público
                                </button>
                            </li>
                            <li>
                                <button type="button" onclick="ajuda5050Request()" id="id_ajuda5050"
                                        class="nav-link text-black-50">
                                    <img src="/imagens/50-help.svg" alt="ranking_logo" class="header_icon"/>
                                    Ajuda 50/50
                                </button>
                            </li>
                            <li>
                                <button type="button" onclick="ajudaTrocaPerguntaRequest()" id="id_ajudaTrocaPergunta"
                                        class="nav-link text-black-50">
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
                                    <div id="countdown"></div>
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
                <div class="row">
                    <div class="col-12 first-col">
                        <div class="btn-group-vertical" role="group">
                            <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off"
                                   required>
                            <label class="btn btn-outline-success btn-w100" id="btnradio1label"
                                   for="btnradio1">${ronda.getPergunta().getRespostas().get(0).getTexto()}</label>

                            <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off">
                            <label class="btn btn-outline-success btn-w100" id="btnradio2label"
                                   for="btnradio2">${ronda.getPergunta().getRespostas().get(1).getTexto()}</label>

                            <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off">
                            <label class="btn btn-outline-success btn-w100" id="btnradio3label"
                                   for="btnradio3">${ronda.getPergunta().getRespostas().get(2).getTexto()}</label>

                            <input type="radio" class="btn-check" name="btnradio" id="btnradio4" autocomplete="off">
                            <label class="btn btn-outline-success btn-w100" id="btnradio4label"
                                   for="btnradio4">${ronda.getPergunta().getRespostas().get(3).getTexto()}</label>
                        </div>
                    </div>

                    <div class="col-1 second-col">
                        <div class="btn-group-vertical">
                            <span class="btn percentage">80%</span>
                            <span class="btn percentage">12%</span>
                            <span class="btn percentage">6%</span>
                            <span class="btn percentage">2%</span>
                        </div>
                    </div>
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
    function ajudaPublicoRequest() {
        document.getElementById("id_ajudaPublico").disabled = true
    }

    function ajuda5050Request() {
        document.getElementById("id_ajuda5050").disabled = true
        let oReq = new XMLHttpRequest();
        oReq.addEventListener("load", ajuda5050);
        oReq.open("GET", "/player/game/ajuda5050");
        oReq.send();
    }

    function ajuda5050() {
        let respostasEliminadasNumeros = JSON.parse(this.responseText)
        respostasEliminadasNumeros.forEach(respostaNumero => {
            let buttonId = "btnradio" + respostaNumero;
            let labelId = buttonId + "label";
            document.getElementById(labelId).style.display = "none";
            document.getElementById(buttonId).checked = false;
        });
    }

    function ajudaTrocaPerguntaRequest() {
        document.getElementById("id_ajudaTrocaPergunta").disabled = true
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

    //countdown clock
    var timeleft = ${tempo};
    var downloadTimer = setInterval(function () {
        if (timeleft <= 0) {
            clearInterval(downloadTimer);
            document.getElementById("countdown").innerHTML = "Terminou Tempo";
        } else {
            document.getElementById("countdown").innerHTML = timeleft + " segundos";
        }
        timeleft -= 1;
    }, 1000);
</script>

</html>