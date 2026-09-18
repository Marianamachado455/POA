<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PreviClima - Semana</title>
    <link rel="stylesheet" type="text/css" href="css/style.css?v=3">
    <script src="js/script.js"></script>
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
                <a href="clima?cidade=${cidade}">Hoje</a>
                <a href="clima?cidade=${cidade}&pagina=semana" class="active">Semana</a>
                <a href="clima?cidade=${cidade}&pagina=sobre">Sobre</a>
            </nav>

            <div class="search-box">
                <button id="buscar">⌕</button>
                <input type="text" placeholder="Buscar cidade" id="cidadeEscolhida"/>
                <div id="sugestoes"></div>
            </div>
        </header>

        <main class="dashboard">
            <section class="hero card">
                <div class="location-row">
                    <div>
                        <p class="label">Previsão para</p>
                        <h1>${cidade}</h1>
                    </div>
                </div>
            </section>

            <section class="forecast card">
                <div class="section-title">
                    <div>
                        <p class="label">Previsão semanal</p>
                        <h2>Próximos 5 dias</h2>
                    </div>
                </div>

                <div class="days semana">

                    <div class="day-item semana-day">
                        <div class="day-header">
                            <span class="day-name">${previsoes[0].diaSemana}</span>
                            <span class="day-date">${previsoes[0].dataFormatada}</span>
                        </div>
                        <span class="day-icon">${previsoes[0].icone}</span>
                        <div class="temperature-range">
                            <strong>${previsoes[0].temperaturaMaxima}</strong>
                            <span>Máx.</span>
                            <strong>${previsoes[0].temperaturaMinima}</strong>
                            <span>Mín.</span>
                        </div>
                        <div class="weather-details">
                            <span>💧 ${previsoes[0].probabilidadeChuva}%</span>
                            <span>💨 ${previsoes[0].velocidadeVentoMaxima} km/h</span>
                        </div>
                    </div>

                    <div class="day-item semana-day">
                        <div class="day-header">
                            <span class="day-name">${previsoes[1].diaSemana}</span>
                            <span class="day-date">${previsoes[1].dataFormatada}</span>
                        </div>
                        <span class="day-icon">${previsoes[1].icone}</span>
                        <div class="temperature-range">
                            <strong>${previsoes[1].temperaturaMaxima}</strong>
                            <span>Máx.</span>
                            <strong>${previsoes[1].temperaturaMinima}</strong>
                            <span>Mín.</span>
                        </div>
                        <div class="weather-details">
                            <span>💧 ${previsoes[1].probabilidadeChuva}%</span>
                            <span>💨 ${previsoes[1].velocidadeVentoMaxima} km/h</span>
                        </div>
                    </div>

                    <div class="day-item semana-day">
                        <div class="day-header">
                            <span class="day-name">${previsoes[2].diaSemana}</span>
                            <span class="day-date">${previsoes[2].dataFormatada}</span>
                        </div>
                        <span class="day-icon">${previsoes[2].icone}</span>
                        <div class="temperature-range">
                            <strong>${previsoes[2].temperaturaMaxima}</strong>
                            <span>Máx.</span>
                            <strong>${previsoes[2].temperaturaMinima}</strong>
                            <span>Mín.</span>
                        </div>
                        <div class="weather-details">
                            <span>💧 ${previsoes[2].probabilidadeChuva}%</span>
                            <span>💨 ${previsoes[2].velocidadeVentoMaxima} km/h</span>
                        </div>
                    </div>

                    <div class="day-item semana-day">
                        <div class="day-header">
                            <span class="day-name">${previsoes[3].diaSemana}</span>
                            <span class="day-date">${previsoes[3].dataFormatada}</span>
                        </div>
                        <span class="day-icon">${previsoes[3].icone}</span>
                        <div class="temperature-range">
                            <strong>${previsoes[3].temperaturaMaxima}</strong>
                            <span>Máx.</span>
                            <strong>${previsoes[3].temperaturaMinima}</strong>
                            <span>Mín.</span>
                        </div>
                        <div class="weather-details">
                            <span>💧 ${previsoes[3].probabilidadeChuva}%</span>
                            <span>💨 ${previsoes[3].velocidadeVentoMaxima} km/h</span>
                        </div>
                    </div>

                    <div class="day-item semana-day">
                        <div class="day-header">
                            <span class="day-name">${previsoes[4].diaSemana}</span>
                            <span class="day-date">${previsoes[4].dataFormatada}</span>
                        </div>
                        <span class="day-icon">${previsoes[4].icone}</span>
                        <div class="temperature-range">
                            <strong>${previsoes[4].temperaturaMaxima}</strong>
                            <span>Máx.</span>
                            <strong>${previsoes[4].temperaturaMinima}</strong>
                            <span>Mín.</span>
                        </div>
                        <div class="weather-details">
                            <span>💧 ${previsoes[4].probabilidadeChuva}%</span>
                            <span>💨 ${previsoes[4].velocidadeVentoMaxima} km/h</span>
                        </div>
                    </div>

                </div>
            </section>
        </main>
    </div>
</body>
</html>