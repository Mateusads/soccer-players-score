package br.com.medeiros.controller;


import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.TEXT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.Matchers.equalTo;

import io.quarkus.test.junit.QuarkusTest;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ScorePlayerControllerTest {

  private ScorePlayerController scorePlayerController;

  ScorePlayerControllerTest(ScorePlayerController scorePlayerController) {
    this.scorePlayerController = scorePlayerController;
  }

  @Test
  void giveAPlayerNameWhenValidParamThenReturnPlayerAndScore() {
    given()
        .contentType(TEXT)
        .when().get("/score/CR7")
        .then()
        .statusCode(200)
        .body(equalTo("Player Name: CR7 | 98 points"));
  }

  @Test
  void giveAYearWhenValidParamThenReturnListPlayersAndScores() {
    given()
        .contentType(TEXT)
        .when().get("/score/rank/2022")
        .then()
        .statusCode(200)
        .body(equalTo("[Player Name: CR7 | 98 points, Player Name: Messi | 96 points]"));
  }

  @Test
  void giveAYearWhenInvalidParamThenReturnListPlayersAndScores() {
    assertThatThrownBy(() -> scorePlayerController
        .topPlayerScoreAllRounds("20100"))
        .hasMessage("INVALID YEAR")
        .isInstanceOf(InvalidParameterException.class);
  }

}