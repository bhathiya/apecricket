package com.kade.apecricket.resource;

import com.kade.apecricket.bean.Player;
import com.kade.apecricket.bean.Status;
import com.kade.apecricket.dao.PlayerDao;
import com.kade.apecricket.util.Constants;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/players")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    PlayerDao playerDao = new PlayerDao();

    @POST
    public Response addPlayers(Player[] players) throws Exception {
        playerDao.addPlayers(players);
        Status status = new Status(200, Constants.playersAddedSuccessfully);
        return Response.ok(status).build();
    }

    @GET
    public Response getPlayers() throws Exception {
        Player[] players = playerDao.getPlayers().toArray(new Player[0]);
        return Response.ok(players).build();
    }

}
