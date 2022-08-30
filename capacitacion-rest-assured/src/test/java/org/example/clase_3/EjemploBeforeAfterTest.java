package org.example.clase_3;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EjemploBeforeAfterTest {

    @BeforeAll
    public void setup(){
        System.out.println("Ejecucion @BeforeAll");
    }

    @BeforeEach
    public void setupEach(){
        System.out.println("Ejecucion @BeforeEach");
    }

    @Test
    public void test01(){ System.out.println("Ejecucion test 01"); }

    @Test
    public void test02(){ System.out.println("Ejecucion test 02"); }

    @Test
    public void test03(){ System.out.println("Ejecucion test 03"); }


    @AfterEach
    public void tearEach(){
        System.out.println("Ejecucion @AfterEach");
    }

    @AfterAll
    public void tear(){
        System.out.println("Ejecucion @AfterAll");
    }
}
