package br.com.buscacep.classes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectaApi {
    private String url = "https://viacep.com.br/ws/%s/json/";
    private String json;
    private String itemParaBusca;

    public ConectaApi(String itemParaBusca) {
        this.itemParaBusca = itemParaBusca;

        this.url = this.url.formatted(this.itemParaBusca);

        _conectaApi(this.url);

    }

    private void _conectaApi(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

            HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonRetornada = response.body();
            this.json = jsonRetornada;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("CEP inválido");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public String getJson() {
        return json;
    }

    public String getItemParaBusca() {
        return itemParaBusca;
    }

    

}
