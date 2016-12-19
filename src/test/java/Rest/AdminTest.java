/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import dtos.AdminDetail;
import dtos.DepartureDetail;
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
public class AdminTest {

    Gson gson;

    public AdminTest() {
    }

    @Before
    public void setUp() {
        gson = new Gson();
    }

    /**
     * Test of login method, of class Admin.
     */
    @Test
    public void testLogin() {
        String str = "{\"username\" : \"user\", \"password\": \"password\"}";
        Admin instance = new Admin();
        String result = instance.login(str);

        AdminDetail adminDetail = gson.fromJson(result, AdminDetail.class);
        String expResult = "user";
        //test that username equals user
        assertEquals(expResult, adminDetail.getUserName());
    }

    @Test
    public void testGetDeparture() {
        System.out.println("getDeparture");
        Long id = 1l;
        Admin instance = new Admin();
        
        String result = instance.getDeparture(id);
        DepartureDetail departure = gson.fromJson(result, DepartureDetail.class);
        
        int expResult = 0;
        //test that DepartureId is 0
        assertEquals(expResult, departure.getDepartureId());
   
    }

    /*
    @Test
    public void testCreateDeparture() {
        System.out.println("createDeparture");
        String str = "";
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.createDeparture(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testGetAllDepartures() {
        System.out.println("getAllDepartures");
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.getAllDepartures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
   
    @Test
    public void testUpdateDeparture() {
        System.out.println("updateDeparture");
        String str = "";
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.updateDeparture(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testDeleteDeparture() {
        System.out.println("deleteDeparture");
        Long id = null;
        Admin instance = new Admin();
        String expResult = "";
        String result = instance.deleteDeparture(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
}
