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

    //Necessário para o Jackson
    public PrevisaoDTO() {
    }

    public PrevisaoDTO(String data, double temperatura, int codigoClima) {
        this.data = data;
        this.temperatura = temperatura;
        this.codigoClima = codigoClima;
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
}