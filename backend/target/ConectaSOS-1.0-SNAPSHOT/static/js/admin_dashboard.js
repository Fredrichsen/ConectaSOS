document.addEventListener('DOMContentLoaded', function() {
    // Mock de ocorrências
    const ocorrencias = [
        {categoria:'Assalto', status:'Aberta', descricao:'Roubo em loja', data:'2024-07-18'},
        {categoria:'Incêndio', status:'Em andamento', descricao:'Incêndio em galpão', data:'2024-07-17'},
        {categoria:'Queda de árvore obstruindo via pública', status:'Finalizada', descricao:'Árvore caída na Av. Central', data:'2024-07-15'}
    ];
    const list = document.getElementById('admin-ocorrencias-list');
    ocorrencias.forEach(o => {
        const div = document.createElement('div');
        div.className = 'card-admin-ocorrencia';
        div.innerHTML = `<b>${o.categoria}</b> <span class="status ${o.status.replace(' ','_')}">${o.status}</span><br><span>${o.descricao}</span><br><small>${o.data}</small><div class='acoes'><button class='btn-aceitar'>Aceitar</button><button class='btn-recusar'>Recusar</button><button class='btn-delegar'>Delegar</button></div>`;
        list.appendChild(div);
    });
    // Filtros (mock)
    document.getElementById('filtro-tipo').addEventListener('change', function() { alert('Filtro por tipo (mock)'); });
    document.getElementById('filtro-status').addEventListener('change', function() { alert('Filtro por status (mock)'); });
}); 