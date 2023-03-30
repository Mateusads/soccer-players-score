package br.com.medeiros.external.service;

import br.com.medeiros.core.domain.Player;
import br.com.medeiros.core.domain.Team;

public class ProcessingPlayerService {

  public Player createPlayerFromLine(String line){
    line = line.replaceAll("\"", "");
    var separator = ",";
    var playerData = line.split(separator);
    Team team = Team.builder().id(Long.parseLong(playerData[3].trim())).name(playerData[17].trim()).build();
    return Player.builder()
        .id(Long.parseLong(playerData[1].trim()))
        .name(playerData[15])
        .position(playerData[4])
        .nickname(playerData[13])
        .team(team)
        .points(Double.parseDouble(playerData[6].trim()))
        .build();
  }
}
