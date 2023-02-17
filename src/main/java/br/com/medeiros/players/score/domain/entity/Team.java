package br.com.medeiros.players.score.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Team {

  private Long id;
  private String name;

}
