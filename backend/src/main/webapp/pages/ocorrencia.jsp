<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nova Ocorrência - ConectaSOS</title>
    <link rel="stylesheet" href="../static/css/style.css">
</head>
<body class="landing-bg">
<div class="landing-container" style="max-width:600px;">
    <header>
        <h1>Nova Ocorrência</h1>
        <p>Preencha os dados para registrar uma nova ocorrência</p>
    </header>
    <form action="OcorrenciaServlet" method="post" enctype="multipart/form-data" class="form-main">
        <label for="categoria">Categoria</label>
        <select id="categoria" name="categoria" required>
            <option value="Assalto">Assalto</option>
            <option value="Disparos de arma de fogo">Disparos de arma de fogo</option>
            <option value="Agressão contra mulheres">Agressão contra mulheres</option>
            <option value="Maus-tratos a animais">Maus-tratos a animais</option>
            <option value="Maus-tratos a crianças e idosos">Maus-tratos a crianças e idosos</option>
            <option value="Perturbação do sossego">Perturbação do sossego (som alto)</option>
            <option value="Incêndio">Incêndio</option>
            <option value="Queda de árvore obstruindo via pública">Queda de árvore obstruindo via pública</option>
            <option value="Outro">Outro</option>
        </select>
        <label for="descricao">Descrição do incidente</label>
        <textarea id="descricao" name="descricao" rows="4" required></textarea>
        <label for="localizacao">Localização</label>
        <input type="text" id="localizacao" name="localizacao" placeholder="Digite o endereço ou use o mapa" required>
        <div style="margin:10px 0;">
            <iframe id="mapa" src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d12697.3538394007!2d-46.633309!3d-23.55052!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1spt-BR!2sbr!4v1710000000000!5m2!1spt-BR!2sbr" width="100%" height="180" style="border:0;border-radius:8px;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
        </div>
        <label for="anexos">Anexos (fotos, vídeos, áudios)</label>
        <input type="file" id="anexos" name="anexos" multiple accept="image/*,video/*,audio/*">
        <div style="margin:10px 0;">
            <input type="checkbox" id="termo" name="termo" required>
            <label for="termo" style="display:inline;">Declaro que as informações são verdadeiras e estou ciente das penalidades legais.</label>
        </div>
        <button type="submit" class="btn-main">Registrar Ocorrência</button>
    </form>
    <footer>
        <p>&copy; 2024 ConectaSOS</p>
    </footer>
</div>
</body>
</html> 