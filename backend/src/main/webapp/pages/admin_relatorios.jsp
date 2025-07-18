<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Relatórios - ConectaSOS</title>
    <link rel="stylesheet" href="../static/css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<div class="dashboard-container">
    <header class="dashboard-header">
        <h1>Relatórios e Estatísticas</h1>
        <nav>
            <a href="admin_dashboard.jsp" class="btn-secondary">Voltar ao Painel</a>
            <a href="LogoutServlet" class="btn-secondary">Sair</a>
        </nav>
    </header>
    <section class="dashboard-section">
        <h2>Filtros Avançados</h2>
        <form class="filtros-admin" method="get" action="AdminRelatoriosServlet">
            <label for="tipo">Tipo:</label>
            <select id="tipo" name="tipo"><option value="">Todos</option><option>Assalto</option><option>Disparos de arma de fogo</option><option>Agressão contra mulheres</option><option>Maus-tratos a animais</option><option>Maus-tratos a crianças e idosos</option><option>Perturbação do sossego</option><option>Incêndio</option><option>Queda de árvore obstruindo via pública</option><option>Outro</option></select>
            <label for="status">Status:</label>
            <select id="status" name="status"><option value="">Todos</option><option>Aberta</option><option>Em andamento</option><option>Finalizada</option></select>
            <label for="periodo">Período:</label>
            <input type="date" id="data_inicio" name="data_inicio">
            <span>a</span>
            <input type="date" id="data_fim" name="data_fim">
            <button type="submit" class="btn-main">Filtrar</button>
        </form>
    </section>
    <section class="dashboard-section">
        <h2>Gráficos Estatísticos</h2>
        <canvas id="grafico-tipos" height="120"></canvas>
        <canvas id="grafico-status" height="120"></canvas>
    </section>
    <section class="dashboard-section">
        <h2>Exportar Relatórios</h2>
        <button class="btn-main">Exportar PDF</button>
        <button class="btn-secondary">Exportar Excel</button>
    </section>
</div>
<script src="../static/js/admin_relatorios.js"></script>
</body>
</html> 