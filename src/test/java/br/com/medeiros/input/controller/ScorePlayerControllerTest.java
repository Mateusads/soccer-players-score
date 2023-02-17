package br.com.medeiros.input.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import br.com.medeiros.players.score.domain.entity.Player;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ScorePlayerControllerTest {

  @Test
  public void givenEndPointPlayersWhenTopPlayersThenReturnPlayersTopScore() {
    var player = Player.builder().id(7L).name("Cristiano Ronaldo dos Santos Aveiro").build();
    given()
        .when().get("/players/top")
        .then()
        .statusCode(200)
        .body(is(player.toString()));
  }

}