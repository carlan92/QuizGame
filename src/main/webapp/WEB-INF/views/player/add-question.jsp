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

        <div class="card mb-3">
            <img src="imagens/add-question.svg" alt="add-question" class="add-question-img"/>
            <div class="card-body">
                <h5 class="card-title">Adicionar pergunta</h5>
                <input type="text" class="form-control" aria-label="Text input with radio button">

                <div class="input-group">
                    <div class="input-group-text">

                        <input class="form-check-input mt-0" type="radio" name="selection" checked value=""
                               aria-label="Radio button for following text input">
                    </div>
                    <input type="text" class="form-control" aria-label="Text input with radio button">
                </div>
                <div class="input-group">
                    <div class="input-group-text">

                        <input class="form-check-input mt-0" type="radio" name="selection" value=""
                               aria-label="Radio button for following text input">
                    </div>
                    <input type="text" class="form-control" aria-label="Text input with radio button">


                </div>
                <div class="input-group">
                    <div class="input-group-text">

                        <input class="form-check-input mt-0" type="radio" name="selection" value=""
                               aria-label="Radio button for following text input">
                    </div>
                    <input type="text" class="form-control" aria-label="Text input with radio button">


                </div>
                <div class="input-group">
                    <div class="input-group-text">

                        <input class="form-check-input mt-0" type="radio" name="selection" value=""
                               aria-label="Radio button for following text input">
                    </div>
                    <input type="text" class="form-control" aria-label="Text input with radio button">


                </div>
                <div>
                    <select class="form-select" aria-label="Default select example">
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <button type="button" class="btn btn-success">Success</button>
            </div>
        </div>
    </div>
</div>

<%@ include file="../components/footer.jsp" %>

</body>

</html>