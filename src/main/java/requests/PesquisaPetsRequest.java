package requests;

import core.BaseTests;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class PesquisaPetsRequest extends BaseTests {
    public ValidatableResponse pesquisaPetsRequest(ContentType contentType){
        ValidatableResponse pesquisaPetsRequest =
                given()
                        .contentType(contentType)
                    .when()
                        .get("v2/pet/findByStatus?status=pending")
                    .then();
        return pesquisaPetsRequest;
    }
}