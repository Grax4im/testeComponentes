package ifrs.edu;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Conversor {

    @GET
    @Path("/lbToKg/{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public Double LbToKg(@PathParam("value") int value) {
        return value / 2.2046;
    }

    @GET
    @Path("/kgToLb/{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public Double kgToLb(@PathParam("value") int value) {
        return value * 2.2046;
    }
}