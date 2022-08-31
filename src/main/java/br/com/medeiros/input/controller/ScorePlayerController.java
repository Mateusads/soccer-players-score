package br.com.medeiros.input.controller;

import br.com.medeiros.core.service.PlayerScore;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/scorePlayerRounds")
public class ScorePlayerController {

    private final PlayerScore playerScore;

    public ScorePlayerController(PlayerScore playerScore) {
        this.playerScore = playerScore;
    }

    @GET()
    @Produces(MediaType.TEXT_PLAIN)
    public String topPlayerScoreAllRounds() {
        var topPlayer = "";
        return topPlayer;
    }

    @GET()
    @Path("/{number}")
    @Produces(MediaType.TEXT_PLAIN)
    public String topPlayerScoreForRounds(@PathParam("number") String number) {
        if(!number.matches("[0-9]*")){
            return "It's not a number a request";
        }
        var numberOfRound = Integer.parseInt(number);
        var topPlayer = playerScore.playerScoreList(numberOfRound);
        return topPlayer;
    }
}