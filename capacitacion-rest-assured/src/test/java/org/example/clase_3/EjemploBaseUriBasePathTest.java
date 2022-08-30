package org.example.clase_3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EjemploBaseUriBasePathTest {

    @BeforeEach
    public void setupEach(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "comments";

        System.out.println("Llamado @BeforeEach");
    }


    @Test
    public void test01(){
        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        //RestAssured.basePath = "comments";


        RestAssured
                .given().log().all()
                .queryParam("postId", "1")
                .when()
                .get();


    }

    @Test
    public void test02(){
        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        RestAssured
                .when()
                .get("/comments?postId=1");
    }

    @Test
    public void test03(){
        //RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        RestAssured
                .when()
                .get("/comments?postId=1");
    }

}
