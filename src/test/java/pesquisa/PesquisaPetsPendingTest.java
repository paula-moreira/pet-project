package pesquisa;
import core.BaseTests;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import requests.PesquisaPetsRequest;
import requests.PesquisaRequest;


public class PesquisaPetsPendingTest  extends BaseTests {

    PesquisaPetsRequest pesquisaPetsRequest = new PesquisaPetsRequest();
    String url = "v2/pet/findByStatus?status=pending";

    @Test (description = "Pesquisar Pets com status Pendente")
    public void pesquisaPorPetsComStatusPending() {
        ValidatableResponse response = pesquisaPetsRequest.pesquisaPetsRequest(ContentType.JSON);
        response.statusCode(200);
    }
}