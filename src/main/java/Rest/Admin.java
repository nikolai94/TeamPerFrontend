/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author nikolai
 */
@Path("admin")
public class Admin {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public Admin() {
    }

     @GET
    @Path("test")
    @Produces("application/json")
    public String getJson() {
        ArrayList<Test> list = new ArrayList<Test>();
        list.add(new Test("a"));
        list.add(new Test("b"));
        list.add(new Test("c"));
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
