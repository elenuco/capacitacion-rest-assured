package org.example.clase_4.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.example.clase_4.modelos.RequestPost;
import org.junit.jupiter.api.Test;

public class Ejemplos {


    @Test
    public void objetoJson(){
        RequestPost request = new RequestPost();
        request.setTitle("Aprendiendo rest assured");
        request.setBody("Junto con incluit");

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(request)
                    .log().all()
                .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .log().all()
                    .statusCode(201);
    }
}
