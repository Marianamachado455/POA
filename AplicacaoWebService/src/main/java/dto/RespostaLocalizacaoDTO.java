package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaLocalizacaoDTO {

    private List<LocalizacaoDTO> resultados;

    public List<LocalizacaoDTO> getResults() {
        return resultados;
    }

    public void setResults(List<LocalizacaoDTO> resultados) {
        this.resultados = resultados;
    }
}