package br.com.medeiros.controller;


import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.TEXT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.Matchers.equalTo;

import java.security.InvalidParameterException;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScorePlayerControllerTest {

  @InjectMocks
  private ScorePlayerController scorePlayerController;

  @Test
  void giveAPlayerNameWhenValidParamThenReturnPlayerAndScore() {
    final var playerName = "CR7";
    final var response = scorePlayerController.playerScore(playerName);
    assertThat(response).isEqualTo("Player Name: CR7 | 98 points");

  }

  @Test
  void giveAYearWhenValidParamThenReturnListPlayersAndScores() {
    final var response = scorePlayerController.topPlayerScoreForYear("2023");
    assertThat(response).isEqualTo(List.of("Player Name: CR7 | 98 points", "Player Name: Messi | 96 points"));
  }

  @Test
  void giveAYearWhenInvalidParamThenReturnListPlayersAndScores() {
    assertThatThrownBy(() -> scorePlayerController
        .topPlayerScoreForYear("20100"))
        .hasMessage("INVALID YEAR")
        .isInstanceOf(InvalidParameterException.class);
  }

}