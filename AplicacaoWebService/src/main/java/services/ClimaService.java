package services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.ClimaDTO;
import dto.DailyDTO;
import dto.PrevisaoDTO;
import dto.RespostaClimaDTO;

public class ClimaService {
    public ClimaDTO buscarClima(String cidade) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                    "https://api.open-meteo.com/v1/forecast" +
                    "?latitude=-22.91" +
                    "&longitude=-43.17" +
                    "&current=temperature_2m%2Crelative_humidity_2m%2Capparent_temperature%2Cwind_speed_10m%2Cweather_code%2Cprecipitation" +
                    "&timezone=America%2FSao_Paulo"
                ))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            ObjectMapper mapper = new ObjectMapper();
            RespostaClimaDTO respostaClima = mapper.readValue(json, RespostaClimaDTO.class);
            ClimaDTO clima = respostaClima.getCurrent();

            int codigo = clima.getCodigoClima();

            if (codigo == 0) {
                clima.setIcone("☀️");
            } else if (codigo == 1) {
                clima.setIcone("🌤️");
            } else if (codigo == 2) {
                clima.setIcone("⛅");
            } else if (codigo == 3) {
                clima.setIcone("☁️");
            } else if (codigo >= 51 && codigo <= 55) {
                clima.setIcone("🌦️");
            } else if (codigo >= 61 && codigo <= 65) {
                clima.setIcone("🌧️");
            } else if (codigo >= 80 && codigo <= 82) {
                clima.setIcone("🌦️");
            } else if (codigo == 95) {
                clima.setIcone("⛈️");
            } else {
                clima.setIcone("🌡️");
            }

            return clima;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<PrevisaoDTO> buscarPrevisao() {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                    "https://api.open-meteo.com/v1/forecast" +
                    "?latitude=-22.91" +
                    "&longitude=-43.17" +
                    "&daily=weather_code%2Ctemperature_2m_mean" +
                    "&timezone=America%2FSao_Paulo" +
                    "&forecast_days=7"
                ))
                .GET()
                .build();

        HttpClient client = HttpClient.newHttpClient();

        try {

            HttpResponse<String> response =client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            ObjectMapper mapper = new ObjectMapper();
            RespostaClimaDTO respostaClima =mapper.readValue(json, RespostaClimaDTO.class);
            DailyDTO daily = respostaClima.getDaily();
            List<PrevisaoDTO> previsoes = new ArrayList<>();

            for (int i = 0; i < daily.getTime().size(); i++) {
                PrevisaoDTO previsao = new PrevisaoDTO(
                        daily.getTime().get(i),
                        daily.getTemperaturaMedia().get(i),
                        daily.getCodigoClima().get(i)
                );

                int codigo = previsao.getCodigoClima();
                if (codigo == 0) {
                    previsao.setIcone("☀️");
                } else if (codigo == 1) {
                    previsao.setIcone("🌤️");
                } else if (codigo == 2) {
                    previsao.setIcone("⛅");
                } else if (codigo == 3) {
                    previsao.setIcone("☁️");
                } else if (codigo >= 51 && codigo <= 55) {
                    previsao.setIcone("🌦️");
                } else if (codigo >= 61 && codigo <= 65) {
                    previsao.setIcone("🌧️");
                } else if (codigo >= 80 && codigo <= 82) {
                    previsao.setIcone("🌦️");
                } else if (codigo == 95) {
                    previsao.setIcone("⛈️");
                } else {
                    previsao.setIcone("🌡️");
                }

                previsoes.add(previsao);
            }

            return previsoes;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}