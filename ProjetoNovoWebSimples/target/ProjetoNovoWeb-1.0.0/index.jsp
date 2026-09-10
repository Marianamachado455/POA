<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Simulador de descontos</title>
</head>

<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; padding-top: 50px;">
    <div style="background-color: white; width: 400px; margin: auto; padding: 30px; border-radius: 10px; box-shadow: 0px 2px 10px #999;">
        <h1 style="color: #2c7a4b;">💰 Simulador de descontos</h1>
        <form action="LServlet" method="post">

            <label for="valor">Valor original:</label>
            <br>
            <input 
                type="text" 
                id="valor" 
                name="valor"
                style="width: 250px; padding: 10px; margin-top: 5px; border: 1px solid #ccc; border-radius: 5px;"
            >

            <br><br>

            <label for="desconto">Desconto (%):</label>
            <br>
            <input 
                type="text" 
                id="desconto" 
                name="desconto"
                style="width: 250px; padding: 10px; margin-top: 5px; border: 1px solid #ccc; border-radius: 5px;"
            >

            <br><br>

            <input 
                type="submit" 
                value="Calcular"
                style="background-color: #2c7a4b; color: white; border: none; padding: 12px 30px; border-radius: 5px; cursor: pointer; font-size: 16px;"
            >
        </form>
    </div>
</body>
</html>