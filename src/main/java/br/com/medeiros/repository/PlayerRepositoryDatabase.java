package br.com.medeiros.repository;

import br.com.medeiros.core.domain.Player;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;

public class PlayerRepositoryDatabase implements
    PlayerRepository<Player>, PanacheRepository<Player> {

  @Override
  public Player findByName(String name) {
    return find("name", name).singleResult();
  }

  @Override
  public List<Player> getAll() {
    return findAll().stream().toList();
  }

  @Override
  public void create(Player player) {
    persist(player);
  }

  @Override
  public void remove(long id) {
    delete("id", id);
  }
}
