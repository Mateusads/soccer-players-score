package br.com.medeiros.players.score.domain.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(of = {"id", "name"})
public class Player {

  private Long id;
  private String name;
  private String position;
  private String nickname;
  private Team team;
  private Double points;

  public void addPoint(Double points){

    this.points += points;
  }

}
