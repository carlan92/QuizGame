<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
</head>

<body>
<header class="px-3 py-2 bg-dark text-black">
    <div class="container">
        <div class="d-flex align-items-center justify-content-center justify-content-lg-start">
            <a href="#" class="text-black-50 text-decoration-none header_logo">
                <img src="imagens/logo_quiz.svg" alt="quiz_logo" class="logo" />

            </a>
            <ul class="nav text-small header_buttons">
                <li>
                    <a href="#" class="nav-link text-white">
                        <img src="imagens/icon_play.svg" alt="start_logo" class="header_icon" />
                        Start
                    </a>
                </li>
                <li>
                    <a href="#" class="nav-link text-white">
                        <img src="imagens/icon_ranking.svg" alt="ranking_logo" class="header_icon" />
                        Ranking
                    </a>
                </li>
                <li>
                    <a href="#" class="nav-link text-white">
                        <img src="imagens/patch-question.svg" alt="question_logo" class="header_icon" />
                        Adicionar pergunta
                    </a>
                </li>
                <li>
                    <a href="#" class="nav-link text-white">
                        <img src="imagens/icon_logout.svg" alt="logout_logo" class="header_icon" />
                        Terminar Sessão
                    </a>
                </li>
            </ul>
        </div>
    </div>
</header>

<div class="main">
    <div class="row middle-row3">
        <div class="col-md-4">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>127</span>
                        </h2>
                        <h3>Jogadores registados</h3>
                        <img src="imagens/controller.svg" alt="controller_logo" class="dash_icon" />
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>100</span>
                        </h2>
                        <h3>Perguntas registadas</h3>
                        <img src="imagens/question-circle-solid.svg" alt="question_logo" class="dash_icon" />
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>#2</span>
                        </h2>
                        <h3>Posição actual no ranking
                        </h3>
                        <img src="imagens/trophy-solid.svg" alt="trophy_logo" class="dash_icon" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="bg-dark text-center text-white">
    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2021 Copyright: Grupo 2 turma B Java
    </div>
    <!-- Copyright -->
</footer>
</body>
</html>