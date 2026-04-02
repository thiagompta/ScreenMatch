package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaGemini {
    private static final String API_KEY = System.getenv("GEMINI_API_KEY");
    public static String obterTraducao(String texto) {
        try {
            String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                    + System.getenv("GEMINI_API_KEY");

            String body = """
                    {
                      "contents": [{
                        "parts": [{
                          "text": "Traduza o texto a seguir para português. Responda APENAS com a tradução, sem explicações, sem variações, sem texto extra: %s"
                        }]
                      }]
                    }
                    """.formatted(texto);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response.body());

            return json
                    .get("candidates")
                    .get(0)
                    .get("content")
                    .get("parts")
                    .get(0)
                    .get("text")
                    .asText();

        } catch (Exception e) {
                e.printStackTrace(); // 👈 MOSTRA O ERRO REAL
                return "Erro na tradução";
            }
    }
}