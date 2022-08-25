package br.com.medeiros.service;

import br.com.medeiros.controller.input.PullCartolaFile;
import br.com.medeiros.controller.input.ReadFile;
import br.com.medeiros.entity.Player;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CreateScorePlayer {

  private final CreateJsonService createJsonService = new CreateJsonService();
  private final PullCartolaFile pullCartolaFile = new PullCartolaFile();
  private final ProcessingPlayerService processingPlayerService = new ProcessingPlayerService();
  private final ReadFile readFile = new ReadFile(processingPlayerService);

  public String create(int numberOfround) {
    int count = 0;
    Set<Player> players = new HashSet<>();
    while (count <= numberOfround){
      try {
        var url = pullCartolaFile.createFile(count);
        var br = readFile.createPlayers(url);

        String line = br.readLine();
        while ((line = br.readLine())!= null) {
          var player = processingPlayerService.createPlayerFromLine(line);
          players.add(player);
        }
        count++;
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return createJsonService.converter(players);
  }
}
