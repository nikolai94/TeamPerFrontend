/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import mock.AdminMock;
import mogper.test.AdminInterfaceTest;
import mogper.test.BackendHolder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Ms
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AdminInterfaceTest.class})
public class ContractTests {

@BeforeClass
public static void setupClass(){
    BackendHolder.adminInterface = new AdminMock();
}
    
}
