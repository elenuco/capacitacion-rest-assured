package org.example.clase_3;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class EjemplosHamcrestTest {

    @Test
    public void hamcrestNumeros(){
                RestAssured
                        .given()
                        .queryParam("id", "6")
                        .when()
                        .get("https://jsonplaceholder.typicode.com/comments")
                        .then()
                        .body("[0].postId", Matchers.equalTo(2));
    }


    @Test
    public void hamcrestCadenas(){
        RestAssured
                .given()
                .queryParam("id", "6")
                .when()
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .body("[0].email", Matchers.containsStringIgnoringCase("Myrl.com"));
    }


    @Test
    public void hamcrestCollection(){
        RestAssured
                .given()
                .queryParam("id", "6")
                .when()
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                //.body("[0].email", Matchers.not(Matchers.nullValue()));
                .body("[0].email", Matchers.is(Matchers.notNullValue()));
    }


    @Test
    public void validacionExtricta(){
        RestAssured
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                //.log().all()
                .statusCode(200)
                .body("userId", Matchers.notNullValue()) //OK
                .body("id", Matchers.equalTo(112)) //NO OK
                .body("title", Matchers.containsString("nelson")); //NO OK
    }

    @Test
    public void validacionNoExtricta(){
        RestAssured
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                //.log().all()
                .statusCode(200)
                .body(
                        "userId", Matchers.notNullValue(), //OK
                        "id", Matchers.equalTo(112), //NO OK
                        "title", Matchers.containsString("nelson") //NO OK
                );
    }
}
