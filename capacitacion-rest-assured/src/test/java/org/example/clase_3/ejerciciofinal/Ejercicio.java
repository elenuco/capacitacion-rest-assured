package org.example.clase_3.ejerciciofinal;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Ejercicio {

    @BeforeEach
    public void setupEach(){
        //Declaro la baseURI y basePath para cada test de esta clase
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "api";

        //Agrego filtros para mostrar el Request y Response
        RestAssured.filters(
                new RequestLoggingFilter(),
                new ResponseLoggingFilter()
        );
    }

    @Test
    public void getUsersPageExtrict(){
        RestAssured
                .given()
                .queryParam("page", "2") //Agrego el query param
                .when()
                .get("users") //Llamado a el con el nombre del servicio
                .then()
                .statusCode(200) //Validacion de status code
                //Resto de validaciones
                .body("per_page", Matchers.equalTo(6))
                .body("total", Matchers.greaterThan(10))
                .body("data.size()", Matchers.lessThan(15))
                .body("data", Matchers.notNullValue())
                .body("data[2].avatar", Matchers.containsStringIgnoringCase("reqres"))
                .body("data[2].email", Matchers.equalTo("tobias.funke@reqres.in"));
    }

    @Test
    public void getUsersPageNotExtrict(){
        RestAssured
                .given()
                    .queryParam("page", "2") //Agrego el query param
                .when()
                    .get("users") //Llamado a el con el nombre del servicio
                .then()
                    .statusCode(200) //Validacion de status code
                    //Resto de validaciones
                    .body(
                            "per_page", Matchers.equalTo(6),
                            "total", Matchers.greaterThan(10),
                            "data.size()", Matchers.lessThan(15),
                            "data", Matchers.notNullValue(),
                            "data[2].avatar", Matchers.containsStringIgnoringCase("reqres"),
                            "data[2].email", Matchers.equalTo("tobias.funke@reqres.in")
                    );
    }
}
