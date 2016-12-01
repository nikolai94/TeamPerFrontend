/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dtos.PersonDetail;
import dtos.RouteIdentifier;
import entities.TravellingEntity;
import etos.InvalidReservationException;
import etos.NoAvailableDateException;
import etos.UnexpectedErrorException;
import mock.UserMock;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DateFormatter;
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
    UserMock user;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public User() {

        gson = new Gson();
        user = new UserMock();
    }

    @GET
    @Path("getDepartures/{routeIdentifier}/{departureDate}")
    @Produces("application/json")
    public String getDepartures(@PathParam("routeIdentifier") Integer routeIdentifier, @PathParam("departureDate") String departureDate) throws ParseException {

        //Date
        Locale locale = new Locale("da", "DK");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(locale);
        //LocalDate date = LocalDate.parse("2005-nov-12", formatter);
        LocalDate date = LocalDate.parse(departureDate, formatter);

        RouteIdentifier route = new RouteIdentifier(routeIdentifier);

        String toJson = null;
        try {
            toJson = gson.toJson(user.getDepartures(date, route));
        } catch (NoAvailableDateException | UnexpectedErrorException e) {
            e.printStackTrace();
        }
        return toJson;

        //return "{\"routeIdentifier\": \""+ routeIdentifier +"\", \"departureDate\": \""+ departureDate +"\"}";
    }

    private static String ErrorMsgInJson() {
        return null;
    }

    @GET
    @Path("getDeparture/{departureId}")
    @Produces("application/json")
    public String getDeparture(@PathParam("departureId") Integer departureId) {
        String toJson = null;
        try {
            toJson = gson.toJson(user.getDeparture(departureId));
        } catch (etos.NotFoundException | UnexpectedErrorException ex) {
            ex.printStackTrace();
        }
        return toJson;
    }
    
    @GET
    @Path("getAllRouteSummaries")
    @Produces("application/json")
    public String getAllRouteSummaries() {
        String toJson = null;
        try {
          toJson = gson.toJson(user.getAllRouteSummaries());
        } catch (UnexpectedErrorException ex) {
            ex.printStackTrace();
        }
        return toJson;
    }

    @POST
    @Path("createReservation")
    @Produces("application/json")
    public String createReservation(String str) {
        //!!! Not working in backend dummy
        
        
        /*JsonObject jsonObject = gson.fromJson(str, JsonObject.class);

        PersonDetail personDetail = gson.fromJson(jsonObject.get("personDetail"), PersonDetail.class);
        long departureId = Long.parseLong(jsonObject.get("departureId").toString());

        TravellingEntity[] travellingEntityArray = gson.fromJson(jsonObject.get("travellingEntity"), TravellingEntity[].class);
        List<TravellingEntity> travellingEntityList = Arrays.asList(travellingEntityArray);
        try {
            user.createReservation(personDetail, departureId, travellingEntityList);
        } catch (InvalidReservationException | UnexpectedErrorException ex) {
            ex.printStackTrace();
        }

        return str;*/
        return "Not working";
    }
    
    
    @GET
    @Path("getTravellingEntities")
    @Produces("application/json")
    public String getTravellingEntities() {
        //!!! Not working in backend dummy
       
        /*String toJson = null;
        try {
           System.out.println(user.getTravellingEntities().toString());
           toJson = gson.toJson(user.getTravellingEntities());
        } catch (UnexpectedErrorException ex) {
            ex.printStackTrace();
        }
        return toJson;*/
        return "Not working";
    }
    

}
