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
    <div class="row middle-row3">
        <div class="col-md-4">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>127</span>
                        </h2>

                        <h3>Jogadores registados</h3>
                        <img src="imagens/icon-player.svg" alt="controller_logo" class="dash_icon"/>

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
                        <img src="imagens/icon-question.svg" alt="question_logo" class="dash_icon"/>

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
                        <img src="imagens/icon-trophy.svg" alt="trophy_logo" class="dash_icon"/>

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