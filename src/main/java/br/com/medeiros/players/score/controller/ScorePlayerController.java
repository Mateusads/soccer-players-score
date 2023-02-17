package br.com.medeiros.players.score.controller;

import br.com.medeiros.players.score.domain.entity.Player;
import br.com.medeiros.players.score.domain.entity.Team;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/players")
public class ScorePlayerController {

    public ScorePlayerController(){}

    @GET()
    @Path("/top")
    @Produces(MediaType.TEXT_PLAIN)
    public String topPlayerScoreAllRounds() {
        var topPlayer = Player.builder()
            .id(7L)
            .name("Cristiano Ronaldo dos Santos Aveiro")
            .nickname("CR7")
            .team(Team.builder().id(1L).name("Manchester United").build())
            .points(100D)

            .build();
        return topPlayer.toString();
    }

}