package br.com.medeiros.core.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Team {

  private Long id;
  private String name;

}
