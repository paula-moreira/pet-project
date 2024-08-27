package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;

public class BaseTests implements Constantes {

    @BeforeClass
    public static void setup() {
        //Especificando a URL original
        RestAssured.baseURI = APP_BASE_URL;

        //Especificando o tipo do arquivo JSON
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(APP_CONTENT_TYPE);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        //Especificando o tempo de TIME_OUT do retorno da API
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.requestSpecification = requestSpecBuilder.build();

        //Mostrando o LOG de cada falha dos casos de testes
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }




}
