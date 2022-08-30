package br.com.medeiros.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
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
