<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sobre - PreviClima</title>
    <link rel="stylesheet" type="text/css" href="css/style.css?v=4">
</head>
<body>
<div class="page-shell">
    <header class="topbar">
        <div class="brand">
            <div class="brand-mark">☀</div>
            <div>
                <span class="brand-name">PreviClima</span>
                <small>Previsão do tempo</small>
            </div>
        </div>
        <nav class="topbar-nav">
            <a href="clima">Hoje</a>
            <a href="clima?pagina=semana">Semana</a>
            <a href="clima?pagina=sobre" class="active">Sobre</a>
        </nav>
    </header>

    <main class="sobre">
        <section class="sobre-intro">
            <p class="label">SOBRE O SISTEMA</p>
            <h1>PreviClima</h1>
            <p>O PreviClima é um sistema de consulta e previsão do tempo desenvolvido para apresentar informações meteorológicas de forma simples e organizada.</p>
            <p>Para obter essas informações, o sistema realiza requisições a serviços externos. A API de <strong>Geocoding</strong> é utilizada para localizar a cidade pesquisada, retornando opções de regiões e suas respectivas coordenadas geográficas. Essas coordenadas são então utilizadas nas requisições da API de <strong>Clima</strong>, responsável por fornecer os dados meteorológicos apresentados pelo sistema.</p>
        </section>

        <section class="sobre-section">
            <h2>Como funciona</h2>
            <div class="sobre-grid">
                <div class="sobre-item">
                    <span class="sobre-numero">01</span>
                    <div>
                        <h3>Pesquisa da cidade</h3>
                        <p>O usuário informa o nome de uma cidade no campo de pesquisa e o sistema busca localidades correspondentes.</p>
                    </div>
                </div>
                <div class="sobre-item">
                    <span class="sobre-numero">02</span>
                    <div>
                        <h3>Localização</h3>
                        <p>A API de Geocoding retorna opções de regiões, juntamente com suas coordenadas de latitude e longitude.</p>
                    </div>
                </div>
                <div class="sobre-item">
                    <span class="sobre-numero">03</span>
                    <div>
                        <h3>Previsão do tempo</h3>
                        <p>As coordenadas selecionadas são utilizadas para consultar os dados meteorológicos da cidade.</p>
                    </div>
                </div>
            </div>
        </section>

        <section class="sobre-section">
            <h2>Funcionalidades</h2>
            <div class="sobre-lista">
                <div>
                    <strong>Hoje</strong>
                    <span>Visualização das condições climáticas atuais.</span>
                </div>
                <div>
                    <strong>Semana</strong>
                    <span>Previsão meteorológica para os próximos dias.</span>
                </div>
                <div>
                    <strong>Pesquisa de cidades</strong>
                    <span>Busca de localidades e seleção entre opções encontradas.</span>
                </div>
            </div>
        </section>

        <section class="sobre-section">
            <h2>Tecnologias utilizadas</h2>
            <div class="tecnologias">
                <span>Java</span>
                <span>JSP</span>
                <span>Servlets</span>
                <span>Maven</span>
                <span>Tomcat</span>
                <span>Jackson</span>
                <span>Open-Meteo</span>
            </div>
        </section>

        <section class="sobre-autores">
            <p class="label">DESENVOLVIDO POR</p>
            <div class="autores">
                <strong>Henrique Campbell</strong>
                <strong>MarianaMachado</strong>
            </div>
        </section>
    </main>
</div>
</body>
</html>