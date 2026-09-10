<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Double valorOriginal = (Double) session.getAttribute("valorOriginal");
Double percentualDesconto = (Double) session.getAttribute("percentualDesconto");
Double valorDescontado = (Double) session.getAttribute("valorDescontado");
Double valorFinal = (Double) session.getAttribute("valorFinal");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resultado</title>
</head>

<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; padding-top: 50px;">
    <div style="background-color: white; width: 400px; margin: auto; padding: 30px; border-radius: 10px; box-shadow: 0px 2px 10px #999;">

        <h1 style="color: #2c7a4b;">💰 Resultado</h1>

        <p>Valor original: R$ <%= valorOriginal %></p>

        <p>Desconto: <%= percentualDesconto %>%</p>

        <p>Valor descontado: R$ <%= valorDescontado %></p>

        <hr>

        <h2 style="color: #2c7a4b;">
            Valor final: R$ <%= valorFinal %>
        </h2>

        <br>

        <a href="../index.jsp"
           style="background-color: #2c7a4b; color: white; padding: 12px 20px; text-decoration: none; border-radius: 5px;">
            Calcular novamente
        </a>

    </div>
</body>
</html>