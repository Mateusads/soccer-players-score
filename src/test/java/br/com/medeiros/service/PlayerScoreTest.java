package br.com.medeiros.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PlayerScoreTest {

  @Test
  void shouldReturnListPlayer(){
    final var playerScore = new PlayerScore();
    var playerScoreList = playerScore.topPlayerScoreList(1);
//    assertThat(playerScoreList).isEmpty();
  }

}