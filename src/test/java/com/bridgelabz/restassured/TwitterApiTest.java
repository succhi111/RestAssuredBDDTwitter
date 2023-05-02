package com.bridgelabz.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TwitterApiTest {

    @Test
    public void postTweetTest() {

        // oauth("API Key", "API Secret","Acess token", "Access secret"
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("text", "hello world");

        RequestSpecification requestSpecification = RestAssured.given().auth().
                oauth("3SHZCBOHlOvcNufWzIU7HhGDx",
                        "EOcv0TLzeSdjnIIXPT7IXvgAFq0VttGLvebdfM7BHwXz4s2Zha",
                        "1552058202-NN4r4GQ0OiT2DCRpW4RJlvXZ1MgiWzMrt4zXgYx",
                        "jzv6vSB8b1ODaj5AnFsKiHv6F6gTd1b7awUgLJ837xn5K");
        requestSpecification.header("Content-Type","application/json");
        requestSpecification.body(jsonObject.toJSONString());
        Response response=requestSpecification.post("https://api.twitter.com/2/tweets");


        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }

    @Test
    public void retweetTweetTest() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("tweet_id", "1651797368252030978");

        // oauth("API Key", "API Secret","Acess token", "Access secret"
        RequestSpecification requestSpecification = RestAssured.given().auth().
                oauth("FOjNko76J7m9e4tb4PDEqA024",
                        "q4iNbeBs4XKVNtNJ6DGjxmLKgJ64U7As7lauEiQjLyqTzkFJKm",
                        "1552058202-O9uC5xkPOeMw5UaILoZ4PA49pOEAr63neo3nOfX",
                        "APPuh3XhIyDsbCJoecu1HuzoHJotrzdCyhE4xy2slhaxO");
      //  requestSpecification.header("Content-Type","application/json");
        //requestSpecification.body(jsonObject.toJSONString());
        Response response=requestSpecification.post("https://api.twitter.com/1.1/statuses/retweet/1651797368252030978.json");

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }

    @Test
    public void undoretweetTweetTest() {

        // oauth("API Key", "API Secret","Acess token", "Access secret"

        RequestSpecification requestSpecification = RestAssured.given().auth().
                oauth("FOjNko76J7m9e4tb4PDEqA024",
                        "q4iNbeBs4XKVNtNJ6DGjxmLKgJ64U7As7lauEiQjLyqTzkFJKm",
                        "1552058202-O9uC5xkPOeMw5UaILoZ4PA49pOEAr63neo3nOfX",
                        "APPuh3XhIyDsbCJoecu1HuzoHJotrzdCyhE4xy2slhaxO");
        Response response=requestSpecification.post("https://api.twitter.com/1.1/statuses/unretweet/1651797368252030978.json");

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }

    @Test
    public void deleteTweetTest() {
        // oauth("API Key", "API Secret","Acess token", "Access secret"

        RequestSpecification requestSpecification = RestAssured.given().auth().
                oauth("3SHZCBOHlOvcNufWzIU7HhGDx",
                        "EOcv0TLzeSdjnIIXPT7IXvgAFq0VttGLvebdfM7BHwXz4s2Zha",
                        "1552058202-NN4r4GQ0OiT2DCRpW4RJlvXZ1MgiWzMrt4zXgYx",
                        "jzv6vSB8b1ODaj5AnFsKiHv6F6gTd1b7awUgLJ837xn5K");
        Response response=requestSpecification.delete("https://api.twitter.com/2/tweets/1651471282326626304");

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }
}