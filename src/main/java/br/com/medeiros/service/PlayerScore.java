package br.com.medeiros.service;

import br.com.medeiros.controller.input.PullCartolaFile;
import br.com.medeiros.controller.input.ReadFile;
import br.com.medeiros.entity.Player;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlayerScore {

  private final CreateScorePlayer createScorePlayer = new CreateScorePlayer();

  public String topPlayerScoreList(final int numberOfround){
    return createScorePlayer.create(numberOfround);
  }


}
