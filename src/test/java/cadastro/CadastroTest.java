package cadastro;

import core.BaseTests;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import requests.CadastroRequest;

public class CadastroTest extends BaseTests {

    CadastroRequest cadastroRequest = new CadastroRequest();

    String url = "v2/store/order";


    @Test(description = "Cadastra um novo pedido de Pet com Sucesso", priority = 1) //Definindo a prioridade do teste a ser executado
    public void cadastraNovoPedidoDePetComSucesso() {
        // payload JSON sem valores definidos para certos campos
        String payload  = "{ " +
                "\"id\": null, " +
                "\"petId\": null, " +
                "\"quantity\": 1, " +
                "\"shipDate\": null, " +
                "\"status\": \"placed\", " +
                "\"complete\": true " +
                "}";
        ValidatableResponse response = cadastroRequest.cadastroRequest(payload);
        response.statusCode(200);
  }

    @Test(description = "Cadastra um novo pedido de Pet com Falha", priority = 3)
    public void cadastraNovoPedidoDePetComFalha() {
        String payload  = "{ " +
                "\"id\": \"abc\", " +
                "\"petId\": \"xyz\", " +
                "\"quantity\": -1, " +
                "\"shipDate\": \"invalid-date\", " +
                "\"status\": \"invalid-status\", " +
                "\"complete\": \"yes\" " +
                "}";
        ValidatableResponse response = cadastroRequest.cadastroRequest(payload);
        response.statusCode(400);

    }

    @Test(description = "Cadastra um novo pedido de Pet com falha, com campo faltando", priority = 2)
    public void cadastraNovoPedidoDePetComFalhaCampoFaltando() {
        // Payload JSON onde o campo "status" está faltando
        String payload  = "{ " +
                "\"id\": 12345, " +  // Campo id fornecido
                "\"petId\": 67890, " + // Campo petId fornecido
                "\"quantity\": 1, " + // Campo quantity fornecido
                "\"shipDate\": \"2024-08-26T14:30:00.000Z\", " + // Campo shipDate fornecido
                "\"complete\": true " + // Campo complete fornecido
                "}";
        ValidatableResponse response = cadastroRequest.cadastroRequest(payload);
        response.statusCode(200);

    }



}
