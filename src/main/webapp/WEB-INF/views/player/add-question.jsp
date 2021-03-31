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
    <div class="white_box ">

        <div class="perfil-row">
            <img src="/imagens/add-question.svg" alt="add-question" class="add-question-img" />
            <h3 class="title_next_appt">Adicionar pergunta</h3>

        </div>

        <div class="card-body">
            <input type="text" class="form-control" placeholder="Pergunta">

            <div class="input-group">
                <div class="input-group-text">

                    <input class="form-check-input mt-0" type="radio" name="selection" checked value=""
                           aria-label="Radio button for following text input">
                </div>
                <input type="text" class="form-control" placeholder="Resposta 1">

            </div>
            <div class="input-group">
                <div class="input-group-text">

                    <input class="form-check-input mt-0" type="radio" name="selection" value=""
                           aria-label="Radio button for following text input">
                </div>
                <input type="text" class="form-control" placeholder="Resposta 2">


            </div>
            <div class="input-group">
                <div class="input-group-text">

                    <input class="form-check-input mt-0" type="radio" name="selection" value=""
                           aria-label="Radio button for following text input">
                </div>
                <input type="text" class="form-control" placeholder="Resposta 3">


            </div>
            <div class="input-group">
                <div class="input-group-text">

                    <input class="form-check-input mt-0" type="radio" name="selection" value=""
                           aria-label="Radio button for following text input">
                </div>
                <input type="text" class="form-control" placeholder="Resposta 4">


            </div>
            <div>
                <select class="form-select" aria-label="Default select example">
                    <option selected>Escolha o nível de dificuldade</option>
                    <option value="1">Fácil</option>
                    <option value="2">Intermédia</option>
                    <option value="3">Díficl</option>
                </select>
            </div>
            <button type="button" class="btn btn-green">Guardar</button>
        </div>
    </div>
</div>

<%@ include file="../components/footer.jsp" %>

</body>

</html>