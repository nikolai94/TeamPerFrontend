/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import dtos.DepartureDetail;
import dtos.DepartureIdentifier;
import entities.TravellingEntity;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nikolai
 */
public class UserTest {
      Gson gson;
    public UserTest() {
    }
    
    @Before
    public void setUp() {
        gson = new Gson();
    }
    
    @Test
    public void testGetDeparture() {
        Integer departureId = 1;
        User instance = new User();
        //String expResult = "";
        int expResult = 1;
        String result = instance.getDeparture(departureId);
        DepartureDetail departure = gson.fromJson(result, DepartureDetail.class);
        assertEquals(expResult, departure.getDepartureId());
    }
    
    @Test
    public void testGetDepartures() throws Exception {
        Integer routeIdentifier = 1;
        String departureDate = "2016-11-30";
        User instance = new User();
       
        String result = instance.getDepartures(routeIdentifier, departureDate);
        DepartureDetail[] departureDetailArray = gson.fromJson(result,  DepartureDetail[].class);
      
        //test size of array equals 1
        List<DepartureDetail> departureDetailList = Arrays.asList(departureDetailArray);
        assertEquals(1, departureDetailList.size());
        
        //test harbour destination equals SomeOtherHarbourEnd
        String harbourDestination = "SomeOtherHarbourEnd";
        assertEquals(harbourDestination, departureDetailList.get(0).getRouteSummary().getHarbourDestination());
    }
    
   /* 
    
    @Test
    public void testGetAllRouteSummaries() {
        System.out.println("getAllRouteSummaries");
        User instance = new User();
        String expResult = "";
        String result = instance.getAllRouteSummaries();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreateReservation() {
        System.out.println("createReservation");
        String str = "";
        User instance = new User();
        String expResult = "";
        String result = instance.createReservation(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTravellingEntities() {
        System.out.println("getTravellingEntities");
        User instance = new User();
        String expResult = "";
        String result = instance.getTravellingEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
