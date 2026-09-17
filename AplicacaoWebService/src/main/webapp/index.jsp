<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<html lang="pt-BR"> 
<head> 
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>PreviClima</title> 
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
                <a href="#" class="active">Hoje</a>  
                <a href="#">Semana</a>  
                <a href="#">Detalhes</a>  
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
                        <p class="label">Localização atual</p>  
                        <h1>${cidade}</h1>
                    </div>  
                    <span class="status-badge">${clima.descricao}</span>  
                </div>  
  
                <div class="weather-main">  
                    <div class="temp-block">  
                        <div class="icon-weather">${clima.icone}</div> 
                        <div>  
                            <strong>${clima.temperatura}°</strong>  
                            <span>Sensação térmica ${clima.temperaturaAparente}°</span>  
                        </div>  
                    </div>  
  
                    <div class="weather-meta">  
                        <div>  
                            <span>Máx.</span>  
                            <strong>31°</strong>  
                        </div>  
                        <div>  
                            <span>Mín.</span>  
                            <strong>22°</strong>  
                        </div>  
                    </div>  
                </div>  
            </section>  
  
            <section class="info-grid">  
                <article class="card stat-card">  
                    <p>Umidade</p>  
                    <strong>${clima.umidade}%</strong>  
                    <span>Atual</span>  
                </article>  
  
                <article class="card stat-card">  
                    <p>Vento</p>  
                    <strong>${clima.velocidadeVento} km/h</strong>  
                    <span>Atual</span>  
                </article>  
  
                <article class="card stat-card">  
                    <p>Chuva</p>  
                    <strong>${clima.chuva} mm</strong>  
                    <span>Atual</span>  
                </article>  
            </section>  
  
            <section class="forecast card">  
                <div class="section-title">  
                    <h2>Próximos dias</h2>  
                    <a href="#">Ver previsão completa</a>  
                </div>  
  
                <div class="days">  
                    <div class="day-item">  
                        <span class="day-name">${previsoes[0].diaSemana}</span>  
                        <span class="day-icon">${previsoes[0].icone}</span>  
                        <strong>${previsoes[0].temperatura}</strong>  
                    </div>  
                    <div class="day-item">  
                        <span class="day-name">${previsoes[1].diaSemana}</span>  
                        <span class="day-icon">${previsoes[1].icone}</span>  
                        <strong>${previsoes[1].temperatura}°</strong>  
                    </div>  
                    <div class="day-item">  
                        <span class="day-name">${previsoes[2].diaSemana}</span>  
                        <span class="day-icon">${previsoes[2].icone}</span>  
                        <strong>${previsoes[2].temperatura}°</strong>  
                    </div>  
                    <div class="day-item">  
                        <span class="day-name">${previsoes[3].diaSemana}</span>  
                        <span class="day-icon">${previsoes[3].icone}</span>  
                        <strong>${previsoes[3].temperatura}°</strong>  
                    </div>  
                    <div class="day-item">  
                        <span class="day-name">${previsoes[4].diaSemana}</span>  
                        <span class="day-icon">${previsoes[4].icone}</span>  
                        <strong>${previsoes[4].temperatura}°</strong>  
                    </div>  
                </div>  
            </section>  
        </main>  
    </div>  
</body>
</html>