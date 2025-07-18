<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - ConectaSOS</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body class="landing-bg">
<div class="landing-container">
    <header>
        <h1>Login</h1>
        <p>Acesse sua conta para registrar ou acompanhar ocorrências</p>
    </header>
    <form action="LoginServlet" method="post" class="form-main">
        <label for="email">E-mail</label>
        <input type="email" id="email" name="email" required>
        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha" required>
        <label for="perfil">Perfil</label>
        <select id="perfil" name="perfil" required>
            <option value="cidadao">Cidadão</option>
            <option value="orgao">Órgão Público</option>
        </select>
        <button type="submit" class="btn-main">Entrar</button>
    </form>
    <a href="cadastro.jsp" class="btn-secondary">Criar nova conta</a>
    <footer>
        <p>&copy; 2024 ConectaSOS</p>
    </footer>
</div>
</body>
</html> 