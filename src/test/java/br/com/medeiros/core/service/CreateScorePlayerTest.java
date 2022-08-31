package br.com.medeiros.core.service;


import static org.assertj.core.api.Assertions.assertThatNoException;

import br.com.medeiros.core.service.CreateScorePlayer;
import org.junit.jupiter.api.Test;

class CreateScorePlayerTest {

  @Test
  void should(){
    final CreateScorePlayer createScorePlayer = new CreateScorePlayer();
    var player = createScorePlayer.create(1);
    assertThatNoException();
  }

}