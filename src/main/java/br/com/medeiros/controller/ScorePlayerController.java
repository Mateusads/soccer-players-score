package br.com.medeiros.controller;

import java.security.InvalidParameterException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/score")
public class ScorePlayerController {

  @GET()
  @Path("/{player_name}")
  @Produces(MediaType.TEXT_PLAIN)
  public String topPlayerScoreForRounds(@PathParam("player_name") String player_name) {
    return "Player Name: " + player_name + " | 98 points";
  }

  @GET()
  @Path("/rank/{year}")
  @Produces(MediaType.TEXT_PLAIN)
  public List<String> topPlayerScoreAllRounds(@PathParam("year") String year) {
    if (isInvalidYear(year)) {
      throw new InvalidParameterException("INVALID YEAR");
    }
    return List.of("Player Name: CR7 | 98 points", "Player Name: Messi | 96 points");
  }

  private boolean isInvalidYear(String year) {
    return !(year != null && (year.length() == 4 && year.matches("[0-9]+")));
  }
}