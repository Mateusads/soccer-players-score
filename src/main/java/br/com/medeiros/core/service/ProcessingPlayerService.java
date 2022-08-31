package br.com.medeiros.core.service;

import br.com.medeiros.core.entity.Player;
import br.com.medeiros.core.entity.Team;

public class ProcessingPlayerService {

  public Player createPlayerFromLine(String line){
    line = line.replaceAll("\"", "");
    var separator = ",";
    var playerData = line.split(separator);
    Team team = Team.builder().id(Long.parseLong(playerData[3])).name(playerData[17]).build();
    return Player.builder()
        .id(Long.parseLong(playerData[1]))
        .name(playerData[15])
        .position(playerData[4])
        .nickname(playerData[13])
        .team(team)
        .points(Double.parseDouble(playerData[6]))
        .build();
  }
}
