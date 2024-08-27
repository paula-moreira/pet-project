package requests;

import core.BaseTests;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class PesquisaRequest  extends BaseTests {

    public ValidatableResponse pesquisaTestRequest(int petId) {

        ValidatableResponse pesquisaTestRequest =
                given()
                        .pathParam("petId", petId)
                        .when()
                        .get("v2/pet/{petId}")
                        .then();

        return pesquisaTestRequest;
    }
}









