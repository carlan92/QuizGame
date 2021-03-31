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
                <img src="#" alt="#" class="#" />
                <h3 class="#">Ranking</h3>
            </div>

            <div class="row">

                <section class="content-area middle-row">
                    <table class="table">

                        <thead>
                            <tr class="ranking-table-title">
                                <th>Posição</th>
                                <th>Username</th>
                                <th>Score</th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- For -->
                            <c:forEach var="jogo" items="${jogos}">
                                <tr class="ranking-table-details">
                                    <td>posição</td>
                                    <td>${jogo.getUser().getUsername()}</td>
                                    <td>${jogo.getGameScore()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>
            </div>
        </div>
    </div>

    <%@ include file="../components/footer.jsp" %>

</body>

</html>