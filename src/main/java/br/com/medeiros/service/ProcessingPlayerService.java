package br.com.medeiros.service;

import br.com.medeiros.entity.Player;
import br.com.medeiros.entity.Team;

public class ProcessingPlayerService {

  public Player createPlayerFromLine(String line){
    line = line.replaceAll("\"", "");
    var separator = ",";
    var playerData = line.split(separator);
    Team team = Team.builder().id(Long.parseLong(playerData[3])).name(playerData[17]).build();
    return Player.builder()
        .id(Long.parseLong(playerData[1]))
        .team(team)
        .position(playerData[4])
        .nickname(playerData[14])
        .name(playerData[15])
        .build();
  }

}
