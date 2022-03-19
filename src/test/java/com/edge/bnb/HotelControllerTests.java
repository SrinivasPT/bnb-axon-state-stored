package com.edge.bnb;

import com.edge.bnb.command.infra.error.ErrorResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class HotelControllerTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost/";
        RestAssured.port = 8081;
        RestAssured.defaultParser = Parser.JSON;
    }

    private static boolean isPalindrome(String text) {
        var cleaned = text.replaceAll("\\s+", "").toLowerCase();
        var plain = new StringBuilder(cleaned);
        var reversed = plain.reverse().toString();
        return reversed.equals(cleaned);
    }

    @Test
    void When_InvalidInputPassed_Then_CreateHotel_Should_FailWithProperErrorMessages() throws IOException {
        // Note: For test payload, create folder with in test folder, and access then with path relative to src folder
        String requestBody = new String(Files.readAllBytes(
                Paths.get("src/test/resources/Invalid_HotelRequestDTO_ToCheck_annotations.json")));

        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(requestBody)
                .when().post("/hotel")
                .then().extract().response();

        Assertions.assertEquals(400, response.statusCode());

        List<String> messages = response.as(ErrorResponse.class).getDetails();
        boolean hasErrorForAboutMe = messages.stream()
                .anyMatch(message -> message.equals("About Me must be between 10 and 200 characters"));
        Assertions.assertTrue(hasErrorForAboutMe, "About Me / Description Validation Error");

        boolean hasErrorForContact = messages.stream()
                .anyMatch(message -> message.equals("Contacts cannot be empty"));
        Assertions.assertTrue(hasErrorForContact, "Contacts Validation Error");
    }

    // Note: Following just a sample of Parameterized Test
    //    @ParameterizedTest
    //    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    //    void palindromes(String candidate) {
    //        Assertions.assertTrue(isPalindrome(candidate));
    //    }

    @Test
    void When_InValidInputPassed_Then_UpdateHotel_Should_FailWithProperErrorMessage() throws IOException {
        String requestBody = new String(Files.readAllBytes(
                Paths.get("src/test/resources/Invalid_HotelNameUpdateRequestDTO_ToCheck_Annotations.json")));

        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(requestBody)
                .when().post("/update-name")
                .then().extract().response();

        Assertions.assertEquals(400, response.statusCode());
    }

    @Test
    void When_ValidInputPassed_Then_CreateHotel_Should_Successful() throws IOException {
        String requestBody = new String(Files.readAllBytes(
                Paths.get("src/test/resources/Valid_CreateHotelInputs_Should_ProcessSuccessfully.json")));

        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(requestBody)
                .when().post("/hotel")
                .then().extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void When_ValidInputPassed_Then_UpdateHotel_Should_SuccessfullyUpdate() throws IOException {
        String requestBody = new String(Files.readAllBytes(
                Paths.get("src/test/resources/Valid_HotelNameUpdateRequestDTO_Should_ProcessSuccessfully.json")));

        String body = requestBody.replace("{id}", createHotel().toString());

        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(body)
                .when().post("/update-name")
                .then().extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    private UUID createHotel() throws IOException {
        String requestBody = new String(Files.readAllBytes(
                Paths.get("src/test/resources/Valid_CreateHotelInputs_Should_ProcessSuccessfully.json")));

        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(requestBody)
                .when().post("/hotel")
                .then().extract().response();

        Assertions.assertEquals(200, response.statusCode());

        String hotelGeneratedUUID = response.asString().replace("\"", "");

        return UUID.fromString(hotelGeneratedUUID);
    }
}
