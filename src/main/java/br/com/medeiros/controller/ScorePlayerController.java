package br.com.medeiros.controller;

import br.com.medeiros.service.PlayerScoreService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.security.InvalidParameterException;
import java.util.List;

@Path("/score")
public class ScorePlayerController {

  private final PlayerScoreService playerScoreService;

  @Inject
  public ScorePlayerController(final PlayerScoreService playerScoreService) {
    this.playerScoreService = playerScoreService;
  }

  @GET()
  @Path("/{player_name}")
  @Produces(MediaType.TEXT_PLAIN)
  public String playerScore(@PathParam("player_name") final String playerName) {
    final var playerDto = playerScoreService.getPlayerByName(playerName);
    return "Player Name: " + playerDto.getName() + " | " +  "Nickname: " + playerDto.getNickname() + " | " + playerDto.getPoints() + " points";
  }

  @GET()
  @Path("/rank/{year}")
  @Produces(MediaType.TEXT_PLAIN)
  public List<String> topPlayerScoreForYear(@PathParam("year") final String year) {
    if (isInvalidYear(year)) {
      throw new InvalidParameterException("INVALID YEAR");
    }
    return List.of("Player Name: CR7 | 98 points", "Player Name: Messi | 96 points");
  }

  private boolean isInvalidYear(final String year) {
    return !(year != null && (year.length() == 4 && year.matches("[0-9]+")));
  }
}