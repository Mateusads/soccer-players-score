package br.com.medeiros.repository;

import br.com.medeiros.core.entity.Player;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;

public class PlayerRepositoryDatabase implements
    PlayerRepository<Player>, PanacheRepository<Player> {

  @Override
  public Player findByName(String name) {
    return findByName(name);
  }

  @Override
  public List<Player> getAll() {
    return findAll().stream().toList();
  }

  @Override
  public void create(Player player) {
    create(player);
  }

  @Override
  public void remove(long id) {
    remove(id);
  }
}
