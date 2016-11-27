/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import dtos.RouteIdentifier;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.*;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author nikolai
 */
@Path("user")
public class User {
   Gson gson;
     
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public User() {
        gson = new Gson();
    }

    /*@GET
    @Path("test")
    @Produces("application/json")
    public String getJson() {
        ArrayList<Test> list = new ArrayList<Test>();
        list.add(new Test("test"));
        list.add(new Test("test1"));
        list.add(new Test("aabbcc"));
        Gson gson = new Gson();
        return gson.toJson(list);
    }*/
    
    @GET
    @Path("getDepartures/{routeIdentifier}/{departureDate}")
    @Produces("application/json")
    public String getDepartures(@PathParam("routeIdentifier") Integer routeIdentifier, @PathParam("departureDate") String departureDate) {
        //return gson.toJson("test");
        return "{\"routeIdentifier\": \""+ routeIdentifier +"\", \"departureDate\": \""+ departureDate +"\"}";
    }
    
    @GET
    @Path("getDeparture/{departureId}")
    @Produces("application/json")
    public String getDeparture(@PathParam("departureId") Integer departureId) {
        //return gson.toJson("test");
        return "{\"departureId\": \""+ departureId +"\"}";
    }
    
    @POST
    @Path("createReservation")
    @Produces("application/json")
    public String createReservation(String str){
       return str; 
    }
    
}
