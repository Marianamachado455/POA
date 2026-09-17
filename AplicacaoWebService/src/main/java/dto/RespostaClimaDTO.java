package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespostaClimaDTO {

    private ClimaDTO current;
    private DailyDTO daily;

    public ClimaDTO getCurrent() {
        return current;
    }

    public void setCurrent(ClimaDTO current) {
        this.current = current;
    }

    public DailyDTO getDaily() {
        return daily;
    }

    public void setDaily(DailyDTO daily) {
        this.daily = daily;
    }
}