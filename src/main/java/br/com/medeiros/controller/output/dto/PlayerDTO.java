package br.com.medeiros.controller.output.dto;

import br.com.medeiros.entity.Team;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlayerDTO {

  private String name;
  private String position;
  private String nickname;
  private String teamName;
  private Double points;

}
