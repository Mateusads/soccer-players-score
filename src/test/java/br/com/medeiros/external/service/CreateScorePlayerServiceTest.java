package br.com.medeiros.external.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

import br.com.medeiros.core.domain.Player;
import br.com.medeiros.external.Buffer;
import br.com.medeiros.external.PullCartolaFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateScorePlayerServiceTest {

  @Mock
  PullCartolaFile pullCartolaFile;
  @Mock
  Buffer buffer;
  @Mock
  ProcessingPlayerService processingPlayerService;


  @InjectMocks
  CreateScorePlayerService createScorePlayerService;

  @Test
  void giveAValidYearWhenCreatePlayersDataThenReturnPlayes() throws IOException {
    final var url = "csv/round-test.csv";
    final var bufferResponse = new BufferedReader(
        new FileReader("src/test/resources/csv/round-test.csv"));
    when(pullCartolaFile.createFile(0)).thenReturn(url);
    when(buffer.createBuffer(url)).thenReturn(bufferResponse);
    when(processingPlayerService.createPlayerFromLine(bufferResponse.readLine())).thenReturn(
        createPlayer());

    final var players = createScorePlayerService.create(1);

    final var playerStream  = players.stream().filter(player -> player.getNickname().equalsIgnoreCase("CR7"));

    assertThat(playerStream.findFirst()).isNotNull();
    assertThat(playerStream.findFirst().get().getName()).isEqualTo("Cristiano Ronaldo dos Santos Aveiro");

  }

  private Player createPlayer() {
    return Player.builder()
        .id(1L)
        .name("Cristiano Ronaldo dos Santos Aveiro")
        .nickname("CR7")
        .points(98D)
        .position("At")
        .build();
  }

}