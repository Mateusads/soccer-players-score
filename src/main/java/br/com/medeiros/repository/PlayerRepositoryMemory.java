package br.com.medeiros.repository;

import static io.quarkus.logging.Log.log;

import br.com.medeiros.core.domain.Player;
import br.com.medeiros.external.service.CreateScorePlayerService;
import java.util.Comparator;
import java.util.List;
import lombok.Data;
import org.jboss.logging.Logger.Level;

@Data
public class PlayerRepositoryMemory implements
    PlayerRepository<Player> {

  private List<Player> players;
  private final CreateScorePlayerService createScorePlayer;

  public PlayerRepositoryMemory(List<Player> players, CreateScorePlayerService createScorePlayer) {
    this.players = players;
    this.createScorePlayer = createScorePlayer;
  }

  public PlayerRepositoryMemory(CreateScorePlayerService createScorePlayer) {
    this.createScorePlayer = createScorePlayer;
    this.players = List.of();
  }

  @Override
  public Player findByName(String name) {
    final var filterPlayersName = players.stream()
        .filter(player -> player.getName().equalsIgnoreCase(name)).toList();
    return filterPlayersName.get(0);
  }

  @Override
  public List<Player> getAll() {
    return findAll().stream().toList();
  }

  @Override
  public void create(Player player) {
    players.add(player);
  }

  @Override
  public void remove(long id) {
    try {
      final var playerResponse =
          players.stream().filter(player -> player.getId().equals(id)).toList().stream().findFirst();

      playerResponse.ifPresent(player -> players.remove(player));

    } catch (Exception e) {
      log(Level.ERROR, "Not possibility remove: " + e.getMessage());
    }
  }

  private List<Player> findAll() {
    return players;
  }

  public void loadingBufferInMemory() {
    final var players = createScorePlayer.create(23);

    this.players = players.stream()
        .sorted(Comparator.comparing(Player::getPoints))
        .toList();
  }
}
