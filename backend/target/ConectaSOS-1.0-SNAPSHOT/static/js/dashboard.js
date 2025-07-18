document.addEventListener('DOMContentLoaded', function() {
    // Mock de usuário
    document.getElementById('userNome').textContent = 'Maria Silva';
    // Mock de ocorrências
    const ocorrencias = [
        {categoria:'Assalto', status:'Aberta', descricao:'Roubo na rua X', data:'2024-07-18'},
        {categoria:'Incêndio', status:'Finalizada', descricao:'Fogo em terreno', data:'2024-07-10'},
        {categoria:'Perturbação do sossego', status:'Em andamento', descricao:'Som alto', data:'2024-07-15'}
    ];
    const ocorrenciasList = document.getElementById('ocorrencias-list');
    ocorrencias.forEach(o => {
        const div = document.createElement('div');
        div.className = 'card-ocorrencia';
        div.innerHTML = `<b>${o.categoria}</b> <span class="status ${o.status.replace(' ','_')}">${o.status}</span><br><span>${o.descricao}</span><br><small>${o.data}</small>`;
        ocorrenciasList.appendChild(div);
    });
    // Mock de notificações
    const notificacoes = [
        {msg:'Sua ocorrência foi recebida.', lida:false},
        {msg:'Ocorrência finalizada.', lida:true}
    ];
    const notificacoesList = document.getElementById('notificacoes-list');
    notificacoes.forEach(n => {
        const div = document.createElement('div');
        div.className = 'card-notificacao'+(n.lida?' lida':'');
        div.textContent = n.msg;
        notificacoesList.appendChild(div);
    });
}); 