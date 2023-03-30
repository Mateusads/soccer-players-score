package br.com.medeiros.repository;

import java.util.List;

public interface PlayerRepository<Player> {
  Player findByName(String name);
  List<Player> getAll();
  void create(Player player);
  void remove(long id);

}
