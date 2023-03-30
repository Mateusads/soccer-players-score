package br.com.medeiros.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.security.InvalidParameterException;
import java.util.List;

@Path("/score")
public class ScorePlayerController {

  @GET()
  @Path("/{player_name}")
  @Produces(MediaType.TEXT_PLAIN)
  public String playerScore(@PathParam("player_name") String player_name) {
    return "Player Name: " + player_name + " | 98 points";
  }

  @GET()
  @Path("/rank/{year}")
  @Produces(MediaType.TEXT_PLAIN)
  public List<String> topPlayerScoreForYear(@PathParam("year") String year) {
    if (isInvalidYear(year)) {
      throw new InvalidParameterException("INVALID YEAR");
    }
    return List.of("Player Name: CR7 | 98 points", "Player Name: Messi | 96 points");
  }

  private boolean isInvalidYear(String year) {
    return !(year != null && (year.length() == 4 && year.matches("[0-9]+")));
  }
}