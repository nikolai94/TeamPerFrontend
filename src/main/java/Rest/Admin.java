/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dtos.DepartureDetail;
import dtos.DepartureIdentifier;
import dtos.PersonDetail;
import dtos.RouteIdentifier;
import dtos.RouteSummary;
import etos.LoginException;
import etos.NotFoundException;
import etos.UnexpectedErrorException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mock.AdminMock;

/**
 * REST Web Service
 *
 * @author nikolai
 */
@Path("admin")
public class Admin {

    Gson gson;
    AdminMock admin;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public Admin() {
        gson = new Gson();
        admin = new AdminMock();
    }


    //e.g json {"username" : "user", "password": "password"}
    @POST
    @Path("login")
    @Produces("application/json")
    public String login(String str) {
        JsonObject jsonObject = gson.fromJson(str, JsonObject.class);
        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("password").getAsString();

        String toJson = errorMsg("Maybe wrong username or password");
        try {
            toJson = gson.toJson(admin.login(username, password));
        } catch (LoginException | UnexpectedErrorException ex) {
            ex.printStackTrace();
        }
        return toJson;
    }
    
    //json e.g. = {"routeIdentifier" : {"routeId": "1"}, "localDateTime": "2016-11-30 12:30"}
    @POST
    @Path("createDeparture")
    @Produces("application/json")
    public String createDeparture(String str) {
        //!!! Not working in backend dummy
       
        /*JsonObject jsonObject = gson.fromJson(str, JsonObject.class);
        
        RouteIdentifier routeIdentifier = gson.fromJson(jsonObject.get("routeIdentifier"), RouteIdentifier.class);
        
        //Date
        Locale locale = new Locale("da", "DK");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        formatter = formatter.withLocale(locale);
        //LocalDate date = LocalDate.parse(jsonObject.get("localDateTime").getAsString(), formatter);
        LocalDateTime date = LocalDateTime.parse(jsonObject.get("localDateTime").getAsString(), formatter);
        
        String toJson = errorMsg("Error");
        
        try {
            toJson = gson.toJson(admin.createDeparture(routeIdentifier, date));
        } catch (UnexpectedErrorException ex) {
            ex.printStackTrace();
        }
        
        return toJson;*/
        
        return "Not working";
    }
    
    @GET
    @Path("getAllDepartures")
    @Produces("application/json")
    public String getAllDepartures() {
       
        String toJson = errorMsg("Error");    
        try {
            toJson = gson.toJson(admin.getAllDepartures());
        } catch (UnexpectedErrorException ex) {
          ex.printStackTrace();
        }
        
        return toJson;
    }
    
    @GET
    @Path("getDeparture/{id}")
    @Produces("application/json")
    public String getDeparture(@PathParam("id") Long id) {
        long longId = new Long(id);
       
        String toJson = errorMsg("Error");    
        try {
            toJson = gson.toJson(admin.getDeparture(longId));
        } catch (NotFoundException | UnexpectedErrorException ex) {
            ex.printStackTrace();
        } 
        
        return toJson;
    }
    
    @PUT
    @Path("updateDeparture")
    @Produces("application/json")
    public String updateDeparture(String str) {
        //DepartureDetail DepartureDetail = gson.fromJson(str, DepartureDetail.class);
        JsonObject jsonObject = gson.fromJson(str, JsonObject.class);
        //RouteSummary
        RouteSummary routeSummary = gson.fromJson(jsonObject.get("routeSummary"), RouteSummary.class);
       
        //departureId
        Long departureId = new Long(jsonObject.get("departureId").getAsString());
        
        //Date
        Locale locale = new Locale("da", "DK");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        formatter = formatter.withLocale(locale);
        LocalDateTime date = LocalDateTime.parse(jsonObject.get("departureTime").getAsString(), formatter);
         
       
        //DepartureDetail
        DepartureDetail departureDetail = new DepartureDetail(date, routeSummary, departureId);
        
        String toJson = errorMsg("Error");
        try {
           toJson = gson.toJson(admin.updateDeparture(departureDetail));
        } catch (NotFoundException | UnexpectedErrorException ex) {
            ex.printStackTrace();
        } 
        
        return toJson;
    }
    
    @DELETE
    @Path("deleteDeparture/{id}")
    @Produces("application/json")
    public String deleteDeparture(@PathParam("id") Long id) {
        long longId = new Long(id);
        String toJson = errorMsg("Error");
        try {
            toJson = gson.toJson(admin.deleteDeparture(longId));
        } catch (NotFoundException | UnexpectedErrorException ex) {
            ex.printStackTrace();
        } 
        return toJson;
    }
    
    

    private static String errorMsg(String errorMsg) {
        JsonObject innerObject = new JsonObject();
        innerObject.addProperty("errorMsg", errorMsg);
        return innerObject.toString();
    }
}
