<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro - ConectaSOS</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body class="landing-bg">
<div class="landing-container">
    <header>
        <h1>Ocorreu um erro</h1>
    </header>
    <p>${mensagemErro != null ? mensagemErro : "Algo inesperado aconteceu. Tente novamente mais tarde."}</p>
    <a href="index.jsp" class="btn-main">Voltar para o início</a>
    <footer>
        <p>&copy; 2024 ConectaSOS</p>
    </footer>
</div>
</body>
</html> 