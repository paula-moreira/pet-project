package requests;

import core.BaseTests;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class AtualizaRequest  extends BaseTests {

    public ValidatableResponse atualizaRequest(String payload) {

        ValidatableResponse atualizaRequest =
                given()
                        .body(payload)
                    .when()
                        .put("v2/pet")
                    .then();

    return atualizaRequest;
    }

    public ValidatableResponse atualizaRequest1(String payloadInvalido) {

        ValidatableResponse atualizaRequest1 =
                given()
                        .body(payloadInvalido)
                        .when()
                        .put("v2/pet")
                        .then();

    return atualizaRequest1;
    }

    public ValidatableResponse atualizaRequest2(String payloadInvalido2) {

        ValidatableResponse atualizaRequest2 =
                given()
                        .body(payloadInvalido2)
                        .when()
                        .put("v2/pet")
                        .then();

        return atualizaRequest2;
    }


}
