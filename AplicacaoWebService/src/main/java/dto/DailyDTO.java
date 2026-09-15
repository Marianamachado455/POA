package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyDTO {

    private List<String> time;

    @JsonProperty("weather_code")
    private List<Integer> codigoClima;

    @JsonProperty("temperature_2m_mean")
    private List<Double> temperaturaMedia;

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Integer> getCodigoClima() {
        return codigoClima;
    }

    public void setCodigoClima(List<Integer> codigoClima) {
        this.codigoClima = codigoClima;
    }

    public List<Double> getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(List<Double> temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }
}