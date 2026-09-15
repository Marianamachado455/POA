package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClimaDTO {
    @JsonProperty("temperature_2m")
    private double temperatura;
    @JsonProperty ("relative_humidity_2m")
    private double umidade;
    @JsonProperty("apparent_temperature")
    private double temperaturaAparente;
    @JsonProperty("wind_speed_10m")
    private double velocidadeVento;
    @JsonProperty ("precipitation")
    private double chuva;
    @JsonProperty("weather_code")
    private int codigoClima;
    private String icone;

    //Necessário para o Jackson
    public ClimaDTO() {
    }

    public ClimaDTO(double temperatura, double umidade, double temperaturaAparente, double velocidadeVento) {
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.temperaturaAparente = temperaturaAparente;
        this.velocidadeVento = velocidadeVento;
        this.codigoClima = codigoClima;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getUmidade() {
        return umidade;
    }

    public int getCodigoClima() {
        return codigoClima;
    }

    public void setCodigoClima(int codigoClima) {
        this.codigoClima = codigoClima;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public double getTemperaturaAparente() {
        return temperaturaAparente;
    }

    public void setTemperaturaAparente(double temperaturaAparente) {
        this.temperaturaAparente = temperaturaAparente;
    }

    public double getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public double getChuva() {
        return chuva;
    }

    public void setChuva(double chuva) {
        this.chuva = chuva;
    }
}