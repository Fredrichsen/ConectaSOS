<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meu Perfil - ConectaSOS</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body class="landing-bg">
<div class="landing-container" style="max-width:500px;">
    <header>
        <h1>Meu Perfil</h1>
    </header>
    <form action="PerfilServlet" method="post" class="form-main">
        <label for="nome">Nome completo</label>
        <input type="text" id="nome" name="nome" value="${usuario.nome}" required>
        <label for="email">E-mail</label>
        <input type="email" id="email" name="email" value="${usuario.email}" required readonly>
        <label for="telefone">Telefone</label>
        <input type="text" id="telefone" name="telefone" value="${usuario.telefone}">
        <label for="documento">Documento</label>
        <input type="text" id="documento" name="documento" value="${usuario.documento}">
        <label for="localizacao_padrao">Localização padrão</label>
        <input type="text" id="localizacao_padrao" name="localizacao_padrao" value="${usuario.localizacao_padrao}">
        <button type="submit" class="btn-main">Salvar Alterações</button>
    </form>
    <footer>
        <p>&copy; 2024 ConectaSOS</p>
    </footer>
</div>
</body>
</html> 