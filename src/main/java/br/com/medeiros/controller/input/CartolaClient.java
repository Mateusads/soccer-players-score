package br.com.medeiros.controller.input;

import br.com.medeiros.entity.Player;
import br.com.medeiros.service.ProcessingPlayerService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CartolaClient {
  private final ProcessingPlayerService processingPlayerService;

  public Set<Player> readFile(final String filePath) throws IOException {
    Set<Player> players = new HashSet<>();
    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
    String line;
    while (bufferedReader.readLine()!= null) {
      line = bufferedReader.readLine();
      var player = processingPlayerService.createPlayerFromLine(line);

    }
    return players;
  }

}


