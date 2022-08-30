package org.example.clase_3;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class FiltrosTest {

    @Test
    public void FiltroRequest(){
        RestAssured.filters(new RequestLoggingFilter());

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"title\": \"Ejemplo Post\",\n" +
                        "\"body\": \"Realizamos una llamada POST mediante Rest Assured\"\n" +
                        "}\n")
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201);
    }

    @Test
    public void FiltroResponse(){
        RestAssured.filters(new ResponseLoggingFilter());

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"title\": \"Ejemplo Post\",\n" +
                        "\"body\": \"Realizamos una llamada POST mediante Rest Assured\"\n" +
                        "}\n")
                .when()
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201);
    }

    @Test
    public void FiltroError(){
        RestAssured.filters(new ErrorLoggingFilter());

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"title\": \"Ejemplo Post\",\n" +
                        "\"body\": \"Realizamos una llamada POST mediante Rest Assured\"\n" +
                        "}\n")
                .when()
                .post("https://jsonplaceholder.typicode.com/postssadas");
    }
}
