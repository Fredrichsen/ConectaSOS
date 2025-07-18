document.addEventListener('DOMContentLoaded', function() {
    // Gráfico de tipos de ocorrência
    new Chart(document.getElementById('grafico-tipos').getContext('2d'), {
        type: 'bar',
        data: {
            labels: ['Assalto', 'Incêndio', 'Perturbação', 'Agressão', 'Outro'],
            datasets: [{
                label: 'Ocorrências',
                data: [12, 7, 5, 3, 2],
                backgroundColor: ['#11998e','#38ef7d','#f9ca24','#e74c3c','#2c5364']
            }]
        },
        options: {responsive:true, plugins:{legend:{display:false}}}
    });
    // Gráfico de status
    new Chart(document.getElementById('grafico-status').getContext('2d'), {
        type: 'pie',
        data: {
            labels: ['Aberta', 'Em andamento', 'Finalizada'],
            datasets: [{
                data: [8, 6, 15],
                backgroundColor: ['#11998e','#f9ca24','#38ef7d']
            }]
        },
        options: {responsive:true}
    });
}); 