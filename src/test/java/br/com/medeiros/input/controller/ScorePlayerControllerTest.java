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
        .when().get("/scorePlayerRounds")
        .then()
        .statusCode(200)
        .body(is(""));
  }

  @Test
  public void shouldAOneNumberInRequestGiveReturnJsonRounds() {
    final var jsonReturnAssert = new BufferedReader(
        new InputStreamReader(
            Objects.requireNonNull(getClass().getResourceAsStream("/jsonExpected/jsonPlayer.json")),
            StandardCharsets.UTF_8))
        .lines()
        .collect(Collectors.joining("\n"));
    given()
        .when().get("/scorePlayerRounds/1")
        .then()
        .statusCode(200)
        .body(is(jsonReturnAssert));
  }

  @Test
  public void shouldAFiveNumberInRequestGiveReturnJsonRounds() {
    final var jsonReturnAssert = new BufferedReader(
        new InputStreamReader(
            Objects.requireNonNull(
                getClass().getResourceAsStream("/jsonExpected/jsonPlayer5Rounds.json")),
            StandardCharsets.UTF_8))
        .lines()
        .collect(Collectors.joining("\n"));
    given()
        .when().get("/scorePlayerRounds/5")
        .then()
        .statusCode(200)
        .body(is(jsonReturnAssert));
  }

  @Test
  public void shouldANoNumberInRequestGiveAException() {
    given()
        .when().get("/scorePlayerRounds/ABC")
        .then()
        .statusCode(200)
        .body(is("It's not a number a request"));
    ;
  }

}