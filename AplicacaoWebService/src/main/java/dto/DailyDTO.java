package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyDTO {
    private List<String> time;
    @JsonProperty("weather_code")
    private List<Integer> codigoClima;
    @JsonProperty("temperature_2m_mean")
    private List<Double> temperaturaMedia;
    @JsonProperty("temperature_2m_max")
    private List<Double> temperaturaMaxima;
    @JsonProperty("temperature_2m_min")
    private List<Double> temperaturaMinima;
    @JsonProperty("precipitation_probability_max")
    private List<Integer> probabilidadeChuva;
    @JsonProperty("wind_speed_10m_max")
    private List<Double> velocidadeVentoMaxima;

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

    public List<Double> getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public List<Double> getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public List<Integer> getProbabilidadeChuva() {
        return probabilidadeChuva;
    }

    public List<Double> getVelocidadeVentoMaxima() {
        return velocidadeVentoMaxima;
    }

    public void setTemperaturaMaxima(List<Double> temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public void setTemperaturaMinima(List<Double> temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public void setProbabilidadeChuva(List<Integer> probabilidadeChuva) {
        this.probabilidadeChuva = probabilidadeChuva;
    }

    public void setVelocidadeVentoMaxima(List<Double> velocidadeVentoMaxima) {
        this.velocidadeVentoMaxima = velocidadeVentoMaxima;
    }

    
}