<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel Órgão Público - ConectaSOS</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<div class="dashboard-container">
    <header class="dashboard-header">
        <h1>Painel do Órgão Público</h1>
        <nav>
            <a href="admin_relatorios.jsp" class="btn-secondary">Relatórios</a>
            <a href="LogoutServlet" class="btn-secondary">Sair</a>
        </nav>
    </header>
    <section class="dashboard-section">
        <h2>Mapa ao Vivo</h2>
        <div style="width:100%;height:300px;margin-bottom:18px;">
            <iframe id="mapa-admin" src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d12697.3538394007!2d-46.633309!3d-23.55052!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1spt-BR!2sbr!4v1710000000000!5m2!1spt-BR!2sbr" width="100%" height="100%" style="border:0;border-radius:8px;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        </div>
        <div class="filtros-admin">
            <label for="filtro-tipo">Tipo:</label>
            <select id="filtro-tipo"><option value="">Todos</option><option>Assalto</option><option>Disparos de arma de fogo</option><option>Agressão contra mulheres</option><option>Maus-tratos a animais</option><option>Maus-tratos a crianças e idosos</option><option>Perturbação do sossego</option><option>Incêndio</option><option>Queda de árvore obstruindo via pública</option><option>Outro</option></select>
            <label for="filtro-status">Status:</label>
            <select id="filtro-status"><option value="">Todos</option><option>Aberta</option><option>Em andamento</option><option>Finalizada</option></select>
        </div>
        <div id="admin-ocorrencias-list">
            <!-- Lista dinâmica de ocorrências para o órgão -->
        </div>
    </section>
</div>
<script src="../static/js/admin_dashboard.js"></script>
</body>
</html> 