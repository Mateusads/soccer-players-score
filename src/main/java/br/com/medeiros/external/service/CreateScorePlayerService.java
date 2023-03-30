package br.com.medeiros.external.service;

import br.com.medeiros.core.domain.Player;
import br.com.medeiros.external.Buffer;
import br.com.medeiros.external.PullCartolaFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateScorePlayerService {
  private final PullCartolaFile pullCartolaFile = new PullCartolaFile();
  private final ProcessingPlayerService processingPlayerService = new ProcessingPlayerService();
  private final Buffer buffer = new Buffer();

  public Set<Player> create(int numberOfRound) {
    int count = 0;
    Set<Player> playersSet = new HashSet<>();
    Map<Long, Player> playersMap = new HashMap();
    while (count <= numberOfRound) {
      try {
        var url = pullCartolaFile.createFile(count);
        var br = buffer.createBuffer(url);

        String line = br.readLine();
        while ((line = br.readLine()) != null) {
          var player = processingPlayerService.createPlayerFromLine(line);
          if (playersMap.containsKey(player.getId())) {
            playersMap.get(player.getId()).addPoint(player.getPoints());
          } else {
            playersMap.put(player.getId(), player);
          }
        }
        count++;
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    playersSet.addAll(playersMap.values());
    return playersSet;
  }
}
