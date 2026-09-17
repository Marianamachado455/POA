package services;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.ClimaDTO;
import dto.DailyDTO;
import dto.PrevisaoDTO;
import dto.RespostaClimaDTO;
import dto.LocalizacaoDTO;
import dto.RespostaLocalizacaoDTO;

public class ClimaService {
    public ClimaDTO buscarClima(String cidade) {
        //Procura coordenadas
        LocalizacaoDTO localizacao = buscarLocalizacao(cidade);
        if (localizacao == null) {
            return null;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                    "https://api.open-meteo.com/v1/forecast" +
                    "?latitude=" + localizacao.getLatitude() +
                    "&longitude=" + localizacao.getLongitude() +
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
                clima.setDescricao("Ensolarado");

            } else if (codigo == 1) {
                clima.setIcone("🌤️");
                clima.setDescricao("Pouco nublado");

            } else if (codigo == 2) {
                clima.setIcone("⛅");
                clima.setDescricao("Parcialmente nublado");

            } else if (codigo == 3) {
                clima.setIcone("☁️");
                clima.setDescricao("Nublado");

            } else if (codigo >= 51 && codigo <= 55) {
                clima.setIcone("🌦️");
                clima.setDescricao("Chuvisco");

            } else if (codigo >= 61 && codigo <= 65) {
                clima.setIcone("🌧️");
                clima.setDescricao("Chuva");

            } else if (codigo >= 80 && codigo <= 82) {
                clima.setIcone("🌦️");
                clima.setDescricao("Pancadas de chuva");

            } else if (codigo == 95) {
                clima.setIcone("⛈️");
                clima.setDescricao("Trovoada");

            } else {
                clima.setIcone("🌡️");
                clima.setDescricao("Condição desconhecida");
            }
            return clima;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<PrevisaoDTO> buscarPrevisao(String cidade) {
        //Procura coordenadas
        LocalizacaoDTO localizacao = buscarLocalizacao(cidade);
        if (localizacao == null) {
            return null;
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                    "https://api.open-meteo.com/v1/forecast" +
                    "?latitude=" + localizacao.getLatitude() +
                    "&longitude=" + localizacao.getLongitude() +
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

    public LocalizacaoDTO buscarLocalizacao(String cidade) {
        String cidadeCodificada = URLEncoder.encode(cidade, StandardCharsets.UTF_8);

         HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(
                "https://geocoding-api.open-meteo.com/v1/search" +
                "?name=" + cidadeCodificada +
                "&count=1" +
                "&language=pt" +
                "&format=json"
            ))
            .GET()
            .build();

        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            ObjectMapper mapper = new ObjectMapper();
            RespostaLocalizacaoDTO resposta = mapper.readValue(json, RespostaLocalizacaoDTO.class);

            if (resposta.getResults() == null ||
                resposta.getResults().isEmpty()) {

                System.out.println("Nenhuma localização encontrada!");
                return null;
            }

            return resposta.getResults().get(0);
        }

        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}