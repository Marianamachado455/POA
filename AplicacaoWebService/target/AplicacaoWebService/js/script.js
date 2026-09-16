document.addEventListener("DOMContentLoaded", function() {
    const inputCidade = document.getElementById("cidadeEscolhida");
    const botaoBuscar = document.getElementById("buscar");

    function pesquisarCidade() {
        const cidade = inputCidade.value;
        console.log("Cidade digitada:", cidade);
        const url = "/AplicacaoWebService/clima?cidade=" + encodeURIComponent(cidade);
        console.log("URL:", url);

        //Enviar pro backend
        const xhr = new XMLHttpRequest();
        xhr.open("GET", "clima?cidade=" + encodeURIComponent(cidade), true);
        xhr.send();
    }

    botaoBuscar.addEventListener("click", pesquisarCidade);

    inputCidade.addEventListener("keydown", function(event) {
        if (event.key == "Enter")
            pesquisarCidade();
    });
});