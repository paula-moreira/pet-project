package atualiza;

import core.BaseTests;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import requests.AtualizaRequest;

import static io.restassured.RestAssured.given;

public class AtualizaTest extends BaseTests {

    AtualizaRequest atualizaRequest = new AtualizaRequest();

    String url = "v2/pet";

    @Test(description = "Atualiza os dados de um Pet existente", priority = 1)
    public void atualizaDadosDeUmPetExistente() {
        // Dados do pet que será atualizado
        String payload = "{\n" +
                "  \"id\": 123456789,\n" +
                "  \"name\": \"Pipoca\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Dogs\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://premierpet.com.br/wp-content/webp-express/webp-images/uploads/2023/12/MicrosoftTeams-image-1536x425.jpg.webp\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Tag1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        ValidatableResponse response = atualizaRequest.atualizaRequest(payload);
        response.statusCode(200);
    }

    @Test(description = "Atualiza os dados de um Pet existente com falha", priority = 2)
    public void atualizaDadosDeUmPetExistenteComFalha() {
        // Dados do pet com campo "name" omitido para gerar erro
        String payloadInvalido = "{\n" +
                "  \"id\": 123456789,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Dogs\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://premierpet.com.br/wp-content/webp-express/webp-images/uploads/2023/12/MicrosoftTeams-image-1536x425.jpg.webp\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Tag1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        ValidatableResponse response = atualizaRequest.atualizaRequest1(payloadInvalido);
        response.statusCode(400);
    }

    @Test(description = "Atualiza os dados de um Pet existente com método não permitido", priority = 3)
    public void atualizaDadosDeUmPetExistenteComMetodoNaoPermitido() {
        // Dados do pet a ser atualizado
        String payloadInvalido2 = "{\n" +
                "  \"id\": 123456789,\n" +
                "  \"name\": \"Pipoca\",\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Dogs\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://premierpet.com.br/wp-content/webp-express/webp-images/uploads/2023/12/MicrosoftTeams-image-1536x425.jpg.webp\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Tag1\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        ValidatableResponse response = atualizaRequest.atualizaRequest2(payloadInvalido2);
        response.statusCode(405);
    }






}
