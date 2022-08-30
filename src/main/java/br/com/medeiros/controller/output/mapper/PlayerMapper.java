package br.com.medeiros.controller.output.mapper;

import br.com.medeiros.controller.output.dto.PlayerDTO;
import br.com.medeiros.entity.Player;
import java.text.DecimalFormat;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlayerMapper {

  public static PlayerDTO toDTO(final Player player) {
    DecimalFormat df = new DecimalFormat();
    df.applyPattern("00,00");

    return PlayerDTO.builder()
        .name(player.getName())
        .nickname(player.getNickname())
        .teamName(player.getTeam().getName())
        .position(player.getPosition())
        .points(Double.valueOf(df.format(player.getPoints())))
        .build();
  }

  public static Set<PlayerDTO> toDTOs(final Set<Player> players){
    return players.stream()
        .map(PlayerMapper::toDTO)
        .collect(Collectors.toSet());
  }
}
