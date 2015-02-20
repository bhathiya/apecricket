package com.kade.apecricket.resource;

import com.kade.apecricket.bean.Status;
import com.kade.apecricket.bean.User;
import com.kade.apecricket.dao.UserDao;
import com.kade.apecricket.util.Constants;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    UserDao userDao = new UserDao();

    @POST
    public Response registerUser(User user) throws Exception {
        userDao.registerUser(user);
        Status status = new Status(200, Constants.userAddedSuccessfully);
        return Response.ok(status).build();
    }

    @POST
    public Response loginUser(User guest) throws Exception {
        User user = userDao.loginUser(guest);
        return Response.ok(user).build();
    }

    @GET
    public Response getUser(String username) throws Exception {
        User user = userDao.getUser(username);
        return Response.ok(user).build();
    }

}
