<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PreviClima</title>
    <link rel="stylesheet" type="text/css" href="css/style.css?v=2">
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
                <span>⌕</span>
                <input type="text" placeholder="Buscar cidade" />
            </div>
        </header>

        <main class="dashboard">
            <section class="hero card">
                <div class="location-row">
                    <div>
                        <p class="label">Localização atual</p>
                        <h1>São Paulo, SP</h1>
                    </div>
                    <span class="status-badge">Ensolarado</span>
                </div>

                <div class="weather-main">
                    <div class="temp-block">
                        <div class="icon-weather">☀️</div>
                        <div>
                            <strong>28°</strong>
                            <span>Sensação térmica 31°</span>
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
                    <strong>68%</strong>
                    <span>Estável</span>
                </article>

                <article class="card stat-card">
                    <p>Vento</p>
                    <strong>18 km/h</strong>
                    <span>NE</span>
                </article>

                <article class="card stat-card">
                    <p>Chuva</p>
                    <strong>12%</strong>
                    <span>Baixa prob.</span>
                </article>
            </section>

            <section class="forecast card">
                <div class="section-title">
                    <h2>Próximos dias</h2>
                    <a href="#">Ver previsão completa</a>
                </div>

                <div class="days">
                    <div class="day-item">
                        <span class="day-name">Seg</span>
                        <span class="day-icon">🌤️</span>
                        <strong>29°</strong>
                    </div>
                    <div class="day-item">
                        <span class="day-name">Ter</span>
                        <span class="day-icon">⛅</span>
                        <strong>27°</strong>
                    </div>
                    <div class="day-item">
                        <span class="day-name">Qua</span>
                        <span class="day-icon">🌧️</span>
                        <strong>24°</strong>
                    </div>
                    <div class="day-item">
                        <span class="day-name">Qui</span>
                        <span class="day-icon">🌦️</span>
                        <strong>26°</strong>
                    </div>
                    <div class="day-item">
                        <span class="day-name">Sex</span>
                        <span class="day-icon">☀️</span>
                        <strong>30°</strong>
                    </div>
                </div>
            </section>
        </main>
    </div>
</body>
</html>