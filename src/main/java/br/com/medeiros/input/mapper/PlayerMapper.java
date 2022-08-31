package br.com.medeiros.input.mapper;

import br.com.medeiros.core.entity.Player;
import br.com.medeiros.input.dto.PlayerDTO;
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
