package br.com.medeiros.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CreateScorePlayerTest {

  @Test
  void should(){
    final CreateScorePlayer createScorePlayer = new CreateScorePlayer();
    var player = createScorePlayer.create(1);
    assertThat(player).isEqualTo("");
  }

}