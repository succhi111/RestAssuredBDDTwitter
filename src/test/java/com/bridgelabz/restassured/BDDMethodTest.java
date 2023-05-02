package com.bridgelabz.restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BDDMethodTest {

    @Test
    public void getPetTest() {

        String petBody = given().when().get("http://localhost:3000/posts").asPrettyString();

        System.out.println(petBody);
    }

    @Test
    public void postPetTest(){
        JSONObject json =new JSONObject();
        json.put("id",7);
        json.put("name","Jerry");
        json.put("status","available");

        given().header("Content-type","application/json").body(json.toJSONString())
                .when().post("http://localhost:3000/posts").then().statusCode(201);

    }
    @Test
    public void putPetTest(){
        JSONObject json =new JSONObject();
        json.put("id",9);
        json.put("name","Jerry");
        json.put("status","available");

        given().header("Content-type","application/json").body(json.toJSONString())
                    .when().put("http://localhost:3000/posts/7").then().statusCode(200);

    }
    @Test
    public void patchPetTest() {
        JSONObject json = new JSONObject();
        json.put("name", "johncy");

        given().header("Content-type", "application/json").body(json.toJSONString())
                .when().patch("http://localhost:3000/posts/2").then().statusCode(200);
    }

    @Test
    public void  deletePetTest(){
        given().when().delete("http://localhost:3000/posts/7").then().statusCode(200);
    }
}
