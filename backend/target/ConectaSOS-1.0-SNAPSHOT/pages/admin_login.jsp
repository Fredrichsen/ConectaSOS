<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Órgãos Públicos - ConectaSOS</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body class="landing-bg">
<div class="landing-container">
    <header>
        <h1>Acesso Órgãos Públicos</h1>
        <p>Login exclusivo para atendentes autorizados</p>
    </header>
    <form action="AdminLoginServlet" method="post" class="form-main">
        <label for="email">E-mail institucional</label>
        <input type="email" id="email" name="email" required>
        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha" required>
        <button type="submit" class="btn-main">Entrar</button>
    </form>
    <footer>
        <p>&copy; 2024 ConectaSOS</p>
    </footer>
</div>
</body>
</html> 