package br.com.medeiros.service;

import br.com.medeiros.controller.mapper.PlayerMapper;
import br.com.medeiros.core.service.CreateScorePlayerService;
import br.com.medeiros.repository.PlayerRepository;
import jakarta.inject.Inject;

public class PlayerScoreService {
  private final CreateJsonService createJsonService;
  private final PlayerRepository playerRepository;

  @Inject
  public PlayerScoreService(final CreateJsonService createJsonService,
      final PlayerRepository playerRepository) {
    this.createJsonService = createJsonService;
    this.playerRepository = playerRepository;
  }

  public String topPlayerScore(final int year){
    var players =  playerRepository.getAll();
    var playerDTO = PlayerMapper.toDTOs(players);
    var playersJson = createJsonService.converter(playerDTO);

    return playersJson;
  }
}
