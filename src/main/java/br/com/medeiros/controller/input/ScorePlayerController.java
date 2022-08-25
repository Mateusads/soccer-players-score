package br.com.medeiros.controller.input;

import br.com.medeiros.service.PlayerScore;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/topScore")
public class ScorePlayerController {

    private final PlayerScore playerScore;

    public ScorePlayerController(PlayerScore playerScore) {
        this.playerScore = playerScore;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String topPlayerScore(final int numberOfround) {
        var topPlayer = playerScore.topPlayerScoreList(numberOfround);
        return topPlayer;
    }
}