package br.com.medeiros.core.service;

import br.com.medeiros.input.mapper.PlayerMapper;
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
