package org.example.clase_3;


import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class EjemploLogAllTest {

    @Test
    public void testLogAllRequest(){
        String response =
                RestAssured
                        .given()
                        .log().all() //Log del request
                        .queryParam("postId", "2")
                        .when()
                        .get("https://jsonplaceholder.typicode.com/comments")
                        .then()
                        .extract().asString();

        //System.out.println(response);
    }

    @Test
    public void testLogAllResponse(){
        String response =
                RestAssured
                        .given()
                        .queryParam("id", "6")
                        .when()
                        .get("https://jsonplaceholder.typicode.com/comments")
                        .then()
                        .log().all() //Log del response
                        .extract().asString();

        //System.out.println(response);
    }

    @Test
    public void testLogAll(){
        String response =
                RestAssured
                        .given()
                        .log().all() //Log request
                        .queryParam("postId", "2")
                        .when()
                        .get("https://jsonplaceholder.typicode.com/comments")
                        .then()
                        .log().all() //Log del response
                        .extract().asString();

        //System.out.println(response);
    }

    @Test
    public void testLogAllIfErrorResponse(){

                RestAssured
                        .given()
                        .queryParam("postId", "2")
                        .when()
                        .get("https://jsonplaceholder.typicode.com/commentsqwq")
                        .then()
                        .log().ifError(); //Log del response


        //System.out.println(response);
    }
}
