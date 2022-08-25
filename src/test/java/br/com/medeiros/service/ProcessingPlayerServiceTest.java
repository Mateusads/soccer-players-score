package br.com.medeiros.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import org.junit.jupiter.api.Test;

class ProcessingPlayerServiceTest {
  private ProcessingPlayerService processingPlayerService = new ProcessingPlayerService();

  private final String lineData = "\"56\",86143,1,373,\"zag\",\"7\",0,3,0,0,0,1.41,\"wanderson\",\"Wanderson\",\"Wanderson\",\"Wanderson Santos Pereira\",\"https://s.glbimg.com/es/sde/f/2022/03/03/e4318c57015f1d5169d4e83fc7af4813_FORMATO.png\",\"Atlético-GO\"";

  @Test
  void givenARowShouldReturnAPlayer(){
    var player = processingPlayerService.createPlayerFromLine(lineData);

    assertThat(86143L).isEqualTo(player.getId());
    assertThat("zag").isEqualTo(player.getPosition());
    assertThat("Wanderson Santos Pereira").isEqualTo(player.getName());
    assertThat("Wanderson").isEqualTo(player.getNickname());
    assertThat(373L).isEqualTo(player.getTeam().getId());
    assertThat("Atlético-GO").isEqualTo(player.getTeam().getName());

  }

}