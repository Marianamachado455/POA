document.addEventListener("DOMContentLoaded", function() {
    const inputCidade = document.getElementById("cidadeEscolhida");
    const botaoBuscar = document.getElementById("buscar");
    const searchBox = document.querySelector(".search-box");
    const sugestoes = document.getElementById("sugestoes");

    inputCidade.addEventListener("input", function() {
        const texto = inputCidade.value;
        searchBox.classList.add("ativo");
        
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
                opcao.textContent = cidade.name + ", " + cidade.admin1 + " - " + cidade.country;
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
        const cidade = inputCidade.value.trim();

        if (!cidade) {
            inputCidade.focus();
            return;
        }

        const url = "/AplicacaoWebService/clima?cidade=" + encodeURIComponent(cidade);
        window.location.href = url;
    }

    
    botaoBuscar.addEventListener("click", function() {
        searchBox.classList.add("ativo");
        inputCidade.focus();
    });

    inputCidade.addEventListener("keydown", function(event) {
        if (event.key == "Enter")
            pesquisarCidade();

        if (event.key == "Escape") {
            cancelarPesquisa();
        }
    });

    //Sair do input de pesquisar
    document.addEventListener("click", function(event) {
        if (!searchBox.contains(event.target)) {
            cancelarPesquisa();
        }
    });


    function cancelarPesquisa() {
        sugestoes.innerHTML = "";
        searchBox.classList.remove("ativo");
        inputCidade.blur();
    }
});