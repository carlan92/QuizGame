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
                                    <span id="id_ronda">1</span>/15
                                </div>
                            </li>
                            <li class="nav-link text-black-50">
                                <div>
                                    <img src="/imagens/points-icon.svg" alt="ranking_logo" class="header_icon"/>
                                    <span id="id_xp">0</span> xp
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
                <h3 class="title_next_appt" id="idPergunta">${ronda.getPergunta().getDescricao()}</h3>
            </div>

            <div class="card-body text-center">
                <div class="row">
                    <div class="col-12 first-col">
                        <div class="btn-group-vertical" role="group">
                            <input type="radio" class="btn-check" name="btnradio" value="1" id="btnradio1"
                                   autocomplete="off" required>
                            <label class="btn btn-outline-success btn-w100" id="btnradio1label"
                                   for="btnradio1">${ronda.getPergunta().getRespostas().get(0).getTexto()}</label>

                            <input type="radio" class="btn-check" name="btnradio" value="2" id="btnradio2"
                                   autocomplete="off">
                            <label class="btn btn-outline-success btn-w100" id="btnradio2label"
                                   for="btnradio2">${ronda.getPergunta().getRespostas().get(1).getTexto()}</label>

                            <input type="radio" class="btn-check" name="btnradio" value="3" id="btnradio3"
                                   autocomplete="off">
                            <label class="btn btn-outline-success btn-w100" id="btnradio3label"
                                   for="btnradio3">${ronda.getPergunta().getRespostas().get(2).getTexto()}</label>

                            <input type="radio" class="btn-check" name="btnradio" value="4" id="btnradio4"
                                   autocomplete="off">
                            <label class="btn btn-outline-success btn-w100" id="btnradio4label"
                                   for="btnradio4">${ronda.getPergunta().getRespostas().get(3).getTexto()}</label>
                        </div>
                    </div>

                    <div class="col-1 second-col">
                        <div class="btn-group-vertical">
                            <span class="btn percentage" id="percentageSpan1"></span>
                            <span class="btn percentage" id="percentageSpan2"></span>
                            <span class="btn percentage" id="percentageSpan3"></span>
                            <span class="btn percentage" id="percentageSpan4"></span>
                        </div>
                    </div>
                </div>

                <div>
                    <button type="button" onclick="finishGameRequest()" class="btn-green btn-w20">Sair</button>
                    <button type="button" onclick="checkAnswerRequest()" class="btn-green btn-w20">Próxima</button>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../components/footer.jsp" %>

</body>
<script>
    function ajudaPublicoRequest() {
        document.getElementById("id_ajudaPublico").disabled = true;
        let oReq = new XMLHttpRequest();
        oReq.addEventListener("load", ajudaPublico);
        oReq.open("GET", "/player/game/ajudaPublico");
        oReq.send();
    }

    function ajudaPublico() {
        let percentages = JSON.parse(this.responseText);

        for (let i = 0; i < 4; i++) {
            document.getElementById("percentageSpan" + (i + 1)).innerHTML = (percentages[i] * 100).toFixed(1) + "%";
        }
    }

    function ajuda5050Request() {
        document.getElementById("id_ajuda5050").disabled = true;
        let oReq = new XMLHttpRequest();
        oReq.addEventListener("load", ajuda5050);
        oReq.open("GET", "/player/game/ajuda5050");
        oReq.send();
    }

    function ajuda5050() {
        let respostasEliminadasNumeros = JSON.parse(this.responseText);
        respostasEliminadasNumeros.forEach(respostaNumero => {
                let buttonId = "btnradio" + respostaNumero;
                let labelId = buttonId + "label";
                let spanId = "percentageSpan" + respostaNumero;
                document.getElementById(spanId).style.display = "none";
                document.getElementById(labelId).style.display = "none";
                document.getElementById(buttonId).checked = false;
            }
        );
    }

    function ajudaTrocaPerguntaRequest() {
        document.getElementById("id_ajudaTrocaPergunta").disabled = true;
        let oReq = new XMLHttpRequest();
        oReq.addEventListener("load", ajudaTrocaPergunta);
        oReq.open("GET", "/player/game/ajudaTrocaPergunta");
        oReq.send();
    }

    function ajudaTrocaPergunta() {
        let perguntaParts = JSON.parse(this.responseText);

        document.getElementById("idPergunta").innerHTML = perguntaParts[0];

        for (let i = 1; i < perguntaParts.length; i++) {
            document.getElementById("btnradio" + i + "label").innerHTML = perguntaParts[i];
            document.getElementById("btnradio" + i + "label").style.display = "";

            document.getElementById("percentageSpan" + i).innerHTML = "";
            document.getElementById("percentageSpan" + i).style.display = "";
        }
    }

    function checkAnswerRequest() {
        // send answer
        try {
            let perguntaEscolhida = Array.from(document.getElementsByName("btnradio")).find(r => r.checked).value;
            let oReq = new XMLHttpRequest();
            oReq.addEventListener("load", checkAnswer);
            oReq.open("GET", "/player/game/verificar-resposta/" + perguntaEscolhida);
            oReq.send();
        } catch (e) {
            return;
            // não existe resposta escolhida
        }
    }

    function checkAnswer() {
        // get reply
        let reply = JSON.parse(this.responseText);
        console.log(reply)
        console.log(reply.respostaCorrecta)

        // game over or new question
        if(reply.respostaCorrecta.toLowerCase() === "false"){
            // game over screen // TODO
            finishGameRequest()
        }


        // show new question and update page
        for (let i = 1; i < 5; i++) {
            document.getElementById("btnradio" + i + "label").style.display = "";

            document.getElementById("percentageSpan" + i).innerHTML = "";
            document.getElementById("percentageSpan" + i).style.display = "";
        }

        document.getElementById("idPergunta").innerHTML = reply.pergunta;
        document.getElementById("btnradio1label").innerHTML = reply.resposta1;
        document.getElementById("btnradio2label").innerHTML = reply.resposta2;
        document.getElementById("btnradio3label").innerHTML = reply.resposta3;
        document.getElementById("btnradio4label").innerHTML = reply.resposta4;
        document.getElementById("id_ronda").innerHTML = reply.rondaNr;
        document.getElementById("id_xp").innerHTML = reply.pontos;
        document.getElementById("countdown").innerHTML = reply.rondaTempo; //TODO
    }

    function finishGameRequest() {
        let oReq = new XMLHttpRequest();
        oReq.addEventListener("load", finishGame);
        oReq.open("GET", "/player/game/terminar");
        oReq.send();
    }

    function finishGame() {
        // go to player main page
        window.location.replace("/player/dashboard");
    }

    //countdown clock
    let timeleft = ${tempo};
    let downloadTimer = setInterval(function () {
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