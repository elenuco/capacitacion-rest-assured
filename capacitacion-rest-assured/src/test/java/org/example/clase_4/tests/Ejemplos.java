package org.example.clase_4.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.clase_4.helpers.HelperMapper;
import org.example.clase_4.modelos.RequestPost;
import org.example.clase_4.modelos.ResponseJson;
import org.junit.jupiter.api.Assertions;
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

    @Test
    public void objetoMapeadoJson(){
        RequestPost request = HelperMapper.loadRequestPost();
        request.setTitle("Aprendiendo desde un mapper");

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


    @Test
    public void responseResponseBodyAClase(){
        Response response =
                RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body(HelperMapper.loadRequestPost())
                    //.log().all()
                .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                    //.log().all()
                    .statusCode(201)
                    .extract().response();

        ResponseJson responseJson = response.as(ResponseJson.class);

        System.out.println(responseJson);
    }


    @Test
    public void responseJsonAClase(){
        ResponseJson responseJson =
                RestAssured
                        .given()
                            .contentType(ContentType.JSON)
                            .body(HelperMapper.loadRequestPost())
                        //.log().all()
                        .when()
                            .post("https://jsonplaceholder.typicode.com/posts")
                        .then()
                        //.log().all()
                            .statusCode(201)
                            .extract().as(ResponseJson.class);

        System.out.println(responseJson);
    }
}
