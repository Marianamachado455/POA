document.addEventListener("DOMContentLoaded", function() {
    const inputCidade = document.getElementById("cidadeEscolhida");
    const botaoBuscar = document.getElementById("buscar");

    function pesquisarCidade() {
        const cidade = inputCidade.value.trim();

        if (!cidade) {
            inputCidade.focus();
            return;
        }

        window.location.href = "clima?cidade=" + encodeURIComponent(cidade);
    }

    botaoBuscar.addEventListener("click", pesquisarCidade);

    inputCidade.addEventListener("keydown", function(event) {
        if (event.key == "Enter")
            pesquisarCidade();
    });
});