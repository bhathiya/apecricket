package com.kade.apecricket.resource;

import com.kade.apecricket.bean.Country;
import com.kade.apecricket.bean.Status;
import com.kade.apecricket.dao.CountryDao;
import com.kade.apecricket.util.Constants;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/countries")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces(MediaType.APPLICATION_JSON)
public class CountryResource {

    CountryDao countryDao = new CountryDao();

    @POST
    public Response addCountries(Country[] countries) throws Exception {
        countryDao.addCountries(countries);
        Status status = new Status(200, Constants.countriesAddedSuccessfully);
        return Response.ok(status).build();
    }

    @GET
    public Response getCountries() throws Exception {
        List<Country> countryList = countryDao.getCountries();
        Country[] countries = countryList.toArray(new Country[countryList.size()]);
        return Response.ok(countries).build();
    }

}
