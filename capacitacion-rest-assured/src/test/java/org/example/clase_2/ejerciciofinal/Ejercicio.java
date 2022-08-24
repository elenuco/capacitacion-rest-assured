package org.example.clase_2.ejerciciofinal;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class Ejercicio {

    @Test
    public void postUsers(){
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body("{ \"name\": \"morpheus\", \"job\": \"leader\" }")
                .when()
                    .post("https://reqres.in/api/users")
                .then()
                    .statusCode(201);
    }

    @Test
    public void putUser(){
        RestAssured
                .given()
                    .pathParams("idUsuario", "2")
                    .contentType(ContentType.JSON)
                    .body("{ \"name\": \"morpheus\", \"job\": \"leader\" }")
                .when()
                    .put("https://reqres.in/api/users/{idUsuario}")
                .then()
                    .statusCode(200);
    }


    @Test
    public void getUsers(){
        RestAssured
                .given()
                    .pathParams("idUsuario", "2")
                .when()
                    .get("https://reqres.in/api/users/{idUsuario}")
                .then()
                    .statusCode(200);
    }

    @Test
    public void deleteUsers(){
        RestAssured
                .given()
                    .pathParams("idUsuario", "2")
                .when()
                    .delete("https://reqres.in/api/users/{idUsuario}")
                .then()
                    .statusCode(204);
    }
}
