package br.com.medeiros.service;

import br.com.medeiros.controller.input.PullCartolaFile;
import br.com.medeiros.controller.input.ReadFile;
import br.com.medeiros.entity.Player;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateScorePlayer {
  private final PullCartolaFile pullCartolaFile = new PullCartolaFile();
  private final ProcessingPlayerService processingPlayerService = new ProcessingPlayerService();
  private final ReadFile readFile = new ReadFile();

  public Set<Player> create(int numberOfRound) {
    int count = 0;
    Set<Player> playersSet = new HashSet<>();
    Map<Long, Player> playersMap = new HashMap();
    while (count <= numberOfRound){
      try {
        var url = pullCartolaFile.createFile(count);
        var br = readFile.createPlayers(url);

        String line = br.readLine();
        while ((line = br.readLine())!= null) {
          var player = processingPlayerService.createPlayerFromLine(line);
          if(playersMap.containsKey(player.getId())){
            playersMap.get(player.getId()).addPoint(player.getPoints());
          }else {
            playersMap.put(player.getId(), player);
          }
        }
        count++;
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    playersSet.addAll(playersMap.values());
    return playersSet;
  }
}
