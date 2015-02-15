package com.kade.apecricket.resource;

import com.kade.apecricket.bean.Player;
import com.kade.apecricket.util.Constants;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/player")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    @POST
    public Response addPlayers(Player[] players) {

        return Response.ok(Constants.playersAddedSuccessfully).build();
    }

}
