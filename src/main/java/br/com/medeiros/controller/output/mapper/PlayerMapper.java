package br.com.medeiros.controller.output.mapper;

import br.com.medeiros.controller.output.dto.PlayerDTO;
import br.com.medeiros.entity.Player;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlayerMapper {

  public static PlayerDTO toPlayerDTO(final Player player) {
    return PlayerDTO.builder()
        .name(player.getName())
        .nickname(player.getNickname())
        .teamName(player.getTeam().getName())
        .position(player.getPosition())
        .build();
  }
}
