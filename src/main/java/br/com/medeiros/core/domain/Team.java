package br.com.medeiros.core.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Team {

  private Long id;
  private String name;

}
