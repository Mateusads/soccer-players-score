package br.com.medeiros.core.service;

import static org.assertj.core.api.Assertions.assertThat;

import br.com.medeiros.service.PlayerScore;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class PlayerScoreTest {

  @Test
  void shouldReturnListPlayer(){
    final var playerScore = new PlayerScore();
    var playerScoreList = playerScore.playerScoreList(1);
    final var jsonReturnAssert = new BufferedReader(
        new InputStreamReader(
            Objects.requireNonNull(getClass().getResourceAsStream("/jsonExpected/jsonPlayer.json")),
            StandardCharsets.UTF_8))
        .lines()
        .collect(Collectors.joining("\n"));
    assertThat(playerScoreList).isEqualTo(jsonReturnAssert);
  }

  @Test
  void shouldReturnListPlayerAfterFiveRounds() {
    final var playerScore = new PlayerScore();
    var playerScoreList = playerScore.playerScoreList(5);
    final var jsonReturnAssert = new BufferedReader(
        new InputStreamReader(
            Objects.requireNonNull(getClass().getResourceAsStream("/jsonExpected/jsonPlayer5Rounds.json")),
            StandardCharsets.UTF_8))
        .lines()
        .collect(Collectors.joining("\n"));
    assertThat(playerScoreList).isEqualTo(jsonReturnAssert);
    assertThat(playerScoreList).isEqualTo(jsonReturnAssert);
  }

}