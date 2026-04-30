/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package registrationsystem;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Student
 */
public class RegistrationSystemTest {
    
    private User user;
    
    @Before
    public void setUp() {
        user = new User("test_user", "SecureP@ss1", "+27821234567", "Alice", "Wonder");
    }
    
    @Test
    public void testUserConstructor_SetsAllFields() {
        assertEquals("Username should match constructor value", 
                     "test_user", user.getStoredUsername());
        assertEquals("Password should match constructor value", 
                     "SecureP@ss1", user.getStoredPassword());
        assertEquals("Phone should match constructor value", 
                     "+27821234567", user.getStoredPhone());
        assertEquals("First name should match constructor value", 
                     "Alice", user.getFirstName());
        assertEquals("Last name should match constructor value", 
                     "Wonder", user.getLastName());
    }
    
    @Test
    public void testSetters_UpdateFields() {
        user.setStoredUsername("new_user");
        user.setStoredPassword("NewP@ss2!");
        user.setStoredPhone("+27711112222");
        user.setFirstName("Bob");
        user.setLastName("Builder");
        
        assertEquals("Username should be updated", "new_user", user.getStoredUsername());
        assertEquals("Password should be updated", "NewP@ss2!", user.getStoredPassword());
        assertEquals("Phone should be updated", "+27711112222", user.getStoredPhone());
        assertEquals("First name should be updated", "Bob", user.getFirstName());
        assertEquals("Last name should be updated", "Builder", user.getLastName());
    }
    
    @Test
    public void testUser_DefaultConstructor_CreatesEmptyUser() {
        User emptyUser = new User();
        
        assertNull("Default username should be null", emptyUser.getStoredUsername());
        assertNull("Default password should be null", emptyUser.getStoredPassword());
        assertNull("Default phone should be null", emptyUser.getStoredPhone());
        assertNull("Default firstName should be null", emptyUser.getFirstName());
        assertNull("Default lastName should be null", emptyUser.getLastName());
    }
}
