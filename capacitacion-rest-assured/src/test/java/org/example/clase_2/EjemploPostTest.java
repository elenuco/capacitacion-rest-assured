package org.example.clase_2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.net.UnknownHostException;

public class EjemploPostTest {

    @Test
    public void testPost(){
        String response = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "\"title\": \"Ejemplo Post\",\n" +
                            "\"body\": \"Realizamos una llamada POST mediante Rest Assured\"\n" +
                            "}\n")
                .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .extract().asString();

        System.out.println(response);
    }

    @Test
    public void testPostStatusCode()
    {
        String response = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "\"title\": \"Ejemplo Post\",\n" +
                            "\"body\": \"Realizamos una llamada POST mediante Rest Assured\"\n" +
                            "}\n")
                .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                        .statusCode(201)
                        .extract().asString();

        System.out.println(response);
    }
}
