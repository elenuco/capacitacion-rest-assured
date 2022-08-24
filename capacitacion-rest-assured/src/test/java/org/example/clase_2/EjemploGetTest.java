package org.example.clase_2;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class EjemploGetTest {

    @Test
    public void testGetSimple(){
        String response =
                RestAssured
                    .when()
                        .get("https://jsonplaceholder.typicode.com/comments?postId=1")
                    .then()
                        .extract().asString();

        System.out.println(response);
    }

    @Test
    public void testGetParametros(){
        String response =
                RestAssured
                    .given() //Preparacion del llamado
                        .queryParam("postId", "2")
                    .when() //Accion -> llamado al servicio
                        .get("https://jsonplaceholder.typicode.com/comments")
                    .then() //Entonces algo....
                        .extract().asString();

        System.out.println(response);
    }
}
