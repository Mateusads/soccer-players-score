package br.com.medeiros.service;

import br.com.medeiros.entity.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Set;

public class CreateJsonService {

  public String converter(Set<Player> players) {
    Gson converter = new GsonBuilder().create();
    return converter.toJson(players);
  }
}

