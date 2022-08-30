package br.com.medeiros.service;


import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Test;

class CreateScorePlayerTest {

  @Test
  void should(){
    final CreateScorePlayer createScorePlayer = new CreateScorePlayer();
    var player = createScorePlayer.create(1);
    assertThatNoException();
  }

}