package br.com.medeiros.service;

import br.com.medeiros.controller.input.PullCartolaFile;
import br.com.medeiros.controller.input.ReadFile;
import br.com.medeiros.controller.output.mapper.PlayerMapper;
import br.com.medeiros.entity.Player;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerScore {

  private final CreateScorePlayer createScorePlayer = new CreateScorePlayer();
  private final CreateJsonService createJsonService = new CreateJsonService();

  public String playerScoreList(final int numberOfRound){
    var players =  createScorePlayer.create(numberOfRound);
    var playerDTO = PlayerMapper.toDTOs(players);
    var returnJson = createJsonService.converter(playerDTO);

    return returnJson;
  }


}
