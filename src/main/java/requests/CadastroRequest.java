package requests;

import core.BaseTests;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CadastroRequest extends BaseTests {

    public ValidatableResponse cadastroRequest(String payload) {

        ValidatableResponse cadastroResponse =
                given()
                       .body(payload)
                    .when()
                        .post("v2/store/order")
                    .then();

    return cadastroResponse;
    }



}
