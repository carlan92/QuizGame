<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<header class="px-3 py-2 bg-dark text-black">
    <div class="container">
        <div class="d-flex align-items-center justify-content-center justify-content-lg-start">
            <a href="/player/dashboard" class="text-black-50 text-decoration-none header_logo">
                <img src="/imagens/logo_quiz.svg" alt="quiz_logo" class="logo" />

            </a>
            <ul class="nav text-small header_buttons">
                <li>
                    <a href="/player/game" class="nav-link text-white">
                        <img src="/imagens/icon_play.svg" alt="start_logo" class="header_icon" />
                        Start
                    </a>
                </li>
                <li>
                    <a href="/player/ranking" class="nav-link text-white">
                        <img src="/imagens/icon_ranking.svg" alt="ranking_logo" class="header_icon" />
                        Ranking
                    </a>
                </li>
                <li>
                    <a href="/player/add-question" class="nav-link text-white">
                        <img src="/imagens/patch-question.svg" alt="question_logo" class="header_icon" />
                        Adicionar pergunta
                    </a>
                </li>
                <li>
                    <a href="/logout" class="nav-link text-white">
                        <img src="/imagens/icon_logout.svg" alt="logout_logo" class="header_icon" />
                        Terminar Sessão
                    </a>
                </li>
            </ul>
        </div>
    </div>
</header>