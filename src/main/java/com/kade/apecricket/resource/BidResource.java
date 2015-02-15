package com.kade.apecricket.resource;

import com.kade.apecricket.bean.Player;
import com.kade.apecricket.util.Constants;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bid")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces(MediaType.APPLICATION_JSON)
public class BidResource {

    @POST
    public Response setHighestScoredBatsmen(Player[] players) {
        return Response.ok(players).build();
    }

    @GET
    public Response getHighestScoredBatsmen() {
        return Response.ok("All players").build();
    }

}
