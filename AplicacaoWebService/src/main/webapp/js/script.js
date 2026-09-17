document.addEventListener("DOMContentLoaded", function() {
    const inputCidade = document.getElementById("cidadeEscolhida");
    const botaoBuscar = document.getElementById("buscar");

    inputCidade.addEventListener("input", function() {
        const texto = inputCidade.value;
        
        if (texto.length < 2) {
            return;
        }

        const url = "https://geocoding-api.open-meteo.com/v1/search?name=" + encodeURIComponent(texto) + "&count=5&language=pt&format=json";
        fetch(url)
            .then(response => response.json())
            .then(dados => {
                const sugestoes = document.getElementById("sugestoes");
                sugestoes.innerHTML = "";
                console.log("Resultados:", dados);

                //Criar dropdown em si
                dados.results.forEach(function(cidade) {
                const opcao = document.createElement("div");
                opcao.textContent = cidade.name;
                opcao.addEventListener("click", function() {
                    inputCidade.value = cidade.name;
                    sugestoes.innerHTML = "";
                    pesquisarCidade();
                });
                sugestoes.appendChild(opcao);
            });
            });
    });

    function pesquisarCidade() {
        const cidade = inputCidade.value;
        console.log("Cidade digitada:", cidade);
        const url = "/AplicacaoWebService/clima?cidade=" + encodeURIComponent(cidade);
        console.log("URL:", url);
        window.location.href = url;
    }

    
    botaoBuscar.addEventListener("click", pesquisarCidade);

    inputCidade.addEventListener("keydown", function(event) {
        if (event.key == "Enter")
            pesquisarCidade();
    });
});