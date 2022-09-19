package br.com.medeiros.input.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ScorePlayerControllerTest {

  @Test
  public void shouldAEndPointPlayersReturnPlayersScore() {
    given()
        .when().get("/players")
        .then()
        .statusCode(200)
        .body(is("Ronaldo"));
  }

}