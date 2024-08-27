package pesquisa;

import core.BaseTests;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import requests.PesquisaRequest;
import io.restassured.RestAssured.*;


public class PesquisaTest extends BaseTests {
    PesquisaRequest pesquisaTestRequest = new PesquisaRequest();

    String url = "v2/pet/{petId}";

    @Test
    public void pesquisaPorUmPetInexsitente() {
        int petId = 999999;

        ValidatableResponse response = pesquisaTestRequest.pesquisaTestRequest(petId);
        response.statusCode(404);
    }
}

