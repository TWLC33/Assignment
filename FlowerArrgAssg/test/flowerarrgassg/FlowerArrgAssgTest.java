/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flowerarrgassg;

import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class FlowerArrgAssgTest {
    
    public FlowerArrgAssgTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of validate method, of class FlowerArrgAssg.
     */
//    @Test
//    public void testValidate() {
//        System.out.println("validate");
//        Scanner UserInput = null;
//        int loginInput = 0;
//        int expResult = 0;
//        int result = FlowerArrgAssg.validate(UserInput, loginInput);
//        assertEquals(expResult, result);
//         //TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of login method, of class FlowerArrgAssg.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        CustomizedFloral.login();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of StaffMenu method, of class FlowerArrgAssg.
     */
    @Test
    public void testStaffMenu() {
        System.out.println("StaffMenu");
        CustomizedFloral.StaffMenu();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ConsumerMenu method, of class FlowerArrgAssg.
     */
    @Test
    public void testConsumerMenu() {
        System.out.println("ConsumerMenu");
        CustomizedFloral.ConsumerMenu();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CustomizedPickUpPriority method, of class FlowerArrgAssg.
     */
    @Test
    public void testCustomizedPickUpPriority() throws Exception {
        System.out.println("CustomizedPickUpPriority");
        String expResult = "express (highest priority)|15.0";
        String result = CustomizedFloral.CustomizedPickUpPriority();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CustomizedFlowerArrangementsStyle method, of class FlowerArrgAssg.
     */
    @Test
    public void testCustomizedFlowerArrangementsStyle() throws Exception {
        System.out.println("CustomizedFlowerArrangementsStyle");
        String expResult = "Elliptical flower arrangement|17.0";
        String result = CustomizedFloral.CustomizedFlowerArrangementsStyle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CustomizedFlowerSize method, of class FlowerArrgAssg.
     */
    @Test
    public void testCustomizedFlowerSize() throws Exception {
        System.out.println("CustomizedFlowerSize");
        String expResult = "Extra small Size|5.0";
        String result = CustomizedFloral.CustomizedFlowerSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CustomizedFlowerSelection method, of class FlowerArrgAssg.
     */
    @Test
    public void testCustomizedFlowerSelection() throws Exception {
        System.out.println("CustomizedFlowerSelection");
        ListInterface expResult = new ArrayList1<>();
        expResult.add("Stock|10.0");
        ListInterface<String> result = CustomizedFloral.CustomizedFlowerSelection();
        assertEquals(expResult.get(0), result.get(0));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CustomizedAccessoriesSelection method, of class FlowerArrgAssg.
     */
    @Test
    public void testCustomizedAccessoriesSelection() throws Exception {
        System.out.println("CustomizedAccessoriesSelection");
        ListInterface<String> expResult = new ArrayList1<>();
        expResult.add("Grapevine Wreath|10.0");
        ListInterface<String> result = CustomizedFloral.CustomizedAccessoriesSelection();
        assertEquals(expResult.get(0), result.get(0));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
