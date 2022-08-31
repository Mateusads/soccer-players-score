package br.com.medeiros.input.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlayerDTO implements Comparable<PlayerDTO> {

  private String name;
  private String position;
  private String nickname;
  private String teamName;
  private Double points;

  @Override
  public int compareTo(PlayerDTO otherPlayerDTO) {
    if (otherPlayerDTO.getPoints().compareTo(this.points) == 0) {
      return this.getName().compareTo(otherPlayerDTO.getName());
    }
    return otherPlayerDTO.getPoints().compareTo(this.points);
  }
}
