package br.com.medeiros.service;

import br.com.medeiros.controller.dto.PlayerDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CreateJsonService {

  public String converter(Set<PlayerDTO> playersDto) {
    List<PlayerDTO> arrayPlayers = new ArrayList<>(playersDto);
    arrayPlayers.sort(PlayerDTO::compareTo);
    Gson converter = new GsonBuilder().setPrettyPrinting().create();
    return converter.toJson(arrayPlayers);
  }
}

