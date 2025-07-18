<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel do Cidadão - ConectaSOS</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body>
<div class="dashboard-container">
    <header class="dashboard-header">
        <h1>Bem-vindo(a), <span id="userNome">Usuário</span></h1>
        <nav>
            <a href="ocorrencia.jsp" class="btn-main">Nova Ocorrência</a>
            <a href="perfil.jsp" class="btn-secondary">Meu Perfil</a>
            <a href="LogoutServlet" class="btn-secondary">Sair</a>
        </nav>
    </header>
    <section class="dashboard-section">
        <h2>Minhas Ocorrências</h2>
        <div id="ocorrencias-list">
            <!-- Lista dinâmica de ocorrências do usuário -->
        </div>
    </section>
    <section class="dashboard-section">
        <h2>Notificações</h2>
        <div id="notificacoes-list">
            <!-- Lista dinâmica de notificações -->
        </div>
    </section>
</div>
<script src="../static/js/dashboard.js"></script>
</body>
</html> 