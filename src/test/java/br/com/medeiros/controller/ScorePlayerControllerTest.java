package br.com.medeiros.controller;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import br.com.medeiros.controller.dto.PlayerDTO;
import br.com.medeiros.service.PlayerScoreService;
import java.security.InvalidParameterException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ScorePlayerControllerTest {

  @InjectMocks
  private ScorePlayerController scorePlayerController;

  @Mock
  private PlayerScoreService playerScoreService;

  @Test
  void giveAPlayerNameWhenValidParamThenReturnPlayerAndScore() {
    final var playerName = "CR7";

    when(playerScoreService.getPlayerByName(playerName)).thenReturn(createPlayerDto(playerName));

    assertThatCode(() -> {
      final var response = scorePlayerController.playerScore(playerName);
      assertThat(response).isNotNull();
      assertThat(response).isEqualTo("Player Name: Cristiano Ronaldo dos Santos Aveiro | Nickname: CR7 | 98.0 points");
    }).doesNotThrowAnyException();

  }

  private PlayerDTO createPlayerDto(String playerName) {
    return PlayerDTO.builder()
        .name("Cristiano Ronaldo dos Santos Aveiro")
        .nickname(playerName)
        .points(98D)
        .build();
  }

  @Test
  void giveAYearWhenValidParamThenReturnListPlayersAndScores() {
    final var response = scorePlayerController.topPlayerScoreForYear("2023");
    assertThat(response).isEqualTo(
        List.of("Player Name: CR7 | 98 points", "Player Name: Messi | 96 points"));
  }

  @Test
  void giveAYearWhenInvalidParamThenReturnListPlayersAndScores() {
    assertThatThrownBy(() -> scorePlayerController
        .topPlayerScoreForYear("20100"))
        .hasMessage("INVALID YEAR")
        .isInstanceOf(InvalidParameterException.class);
  }

}