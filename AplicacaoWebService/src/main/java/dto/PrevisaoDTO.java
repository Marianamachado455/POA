package dto;

import java.time.DayOfWeek;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PrevisaoDTO {
    @JsonProperty("time")
    private String data;
    @JsonProperty("temperature_2m_mean")
    private double temperatura;
    @JsonProperty("weather_code")
    private int codigoClima;
    private String icone;
    private double temperaturaMaxima;
    private double temperaturaMinima;
    private int probabilidadeChuva;
    private double velocidadeVentoMaxima;

    //Necessário para o Jackson
    public PrevisaoDTO() {
    }

    public PrevisaoDTO(String data, double temperatura, int codigoClima,
            double temperaturaMinima,double temperaturaMaxima,int probabilidadeChuva, double velocidadeVentoMaxima) {
        this.data = data;
        this.temperatura = temperatura;
        this.codigoClima = codigoClima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaMinima = temperaturaMinima;
        this.probabilidadeChuva = probabilidadeChuva;
        this.velocidadeVentoMaxima = velocidadeVentoMaxima;
    }

    public String getDiaSemana() {
        LocalDate data = LocalDate.parse(this.data);
        DayOfWeek dia = data.getDayOfWeek();

        if (dia == DayOfWeek.MONDAY) return "Seg";
        else if (dia == DayOfWeek.TUESDAY) return "Ter";
        else if (dia == DayOfWeek.WEDNESDAY) return "Qua";
        else if (dia == DayOfWeek.THURSDAY) return "Qui";
        else if (dia == DayOfWeek.FRIDAY) return "Sex";
        else if (dia == DayOfWeek.SATURDAY) return "Sáb";
        else return "Dom";
    }

    public String getDataFormatada() {
        LocalDate data = LocalDate.parse(this.data);

        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();

        String[] meses = {
            "JAN", "FEV", "MAR", "ABR", "MAI", "JUN",
            "JUL", "AGO", "SET", "OUT", "NOV", "DEZ"
        };

        return String.format("%02d %s", dia, meses[mes - 1]);
    }

    public String getData() {
        return data;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getCodigoClima() {
        return codigoClima;
    }

    public void setCodigoClima(int codigoClima) {
        this.codigoClima = codigoClima;
    }

   
    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public int getProbabilidadeChuva() {
        return probabilidadeChuva;
    }

    public void setProbabilidadeChuva(int probabilidadeChuva) {
        this.probabilidadeChuva = probabilidadeChuva;
    }

    public double getVelocidadeVentoMaxima() {
        return velocidadeVentoMaxima;
    }

    public void setVelocidadeVentoMaxima(double velocidadeVentoMaxima) {
        this.velocidadeVentoMaxima = velocidadeVentoMaxima;
    }
}