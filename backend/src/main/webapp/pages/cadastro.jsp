<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro - ConectaSOS</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body class="landing-bg">
<div class="landing-container">
    <header>
        <h1>Cadastro</h1>
        <p>Crie sua conta para registrar e acompanhar ocorrências</p>
    </header>
    <form action="CadastroServlet" method="post" class="form-main">
        <label for="nome">Nome completo</label>
        <input type="text" id="nome" name="nome" required>
        <label for="email">E-mail</label>
        <input type="email" id="email" name="email" required>
        <label for="telefone">Telefone</label>
        <input type="text" id="telefone" name="telefone">
        <label for="documento">Documento</label>
        <input type="text" id="documento" name="documento">
        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha" required>
        <label for="perfil">Perfil</label>
        <select id="perfil" name="perfil" required>
            <option value="cidadao">Cidadão</option>
            <option value="orgao">Órgão Público</option>
        </select>
        <button type="submit" class="btn-main">Cadastrar</button>
    </form>
    <a href="login.jsp" class="btn-secondary">Já tenho conta</a>
    <footer>
        <p>&copy; 2024 ConectaSOS</p>
    </footer>
</div>
</body>
</html> 