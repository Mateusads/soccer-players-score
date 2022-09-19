package br.com.medeiros.input.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ScorePlayerControllerTest {

  @Test
  public void testScorePlayerRoundsEndpoint() {
    given()
        .when().get("/players")
        .then()
        .statusCode(200)
        .body(is(""));
  }

}