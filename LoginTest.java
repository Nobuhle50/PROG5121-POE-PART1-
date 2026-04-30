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
public class LoginTest {
    
   

    // USERNAME VALIDATION TESTS 
    
    @Test
    public void testVerifyUserName_Valid_WithUnderscoreAndShort() {
        assertTrue("Username with underscore and length ≤5 should be valid", 
                   Login.verifyUserName("ab_c"));
    }
    
    @Test
    public void testVerifyUserName_Valid_MinimumLength() {
        assertTrue("Username 'a_b' (3 chars, has underscore) should be valid", 
                  Login.verifyUserName("a_b"));
    }
    
    @Test
    public void testVerifyUserName_Invalid_NoUnderscore() {
        assertFalse("Username without underscore should be invalid", 
                   Login.verifyUserName("abcde"));
    }
    
    @Test
    public void testVerifyUserName_Invalid_TooLong() {
       
        assertFalse("Username with 6 chars should be invalid", 
                    Login.verifyUserName("abc_def"));
    }
    
    @Test
    public void testVerifyUserName_Invalid_NullInput() {
        assertFalse("Null username should be invalid", 
                   Login.verifyUserName(null));
    }
    
    @Test
    public void testVerifyUserName_Invalid_EmptyString() {
        assertFalse("Empty username should be invalid", 
                   Login.verifyUserName(""));
    }

    // PASSWORD VALIDATION TESTS 
    
    @Test
    public void testVerifyPassword_Valid_MeetsAllCriteria() {
        assertTrue("Password with uppercase, digit, special char, length≥8 should be valid", 
                  Login.verifyPassword("Passw0rd!"));
    }
    
    @Test
    public void testVerifyPassword_Valid_MultipleSpecialChars() {
        assertTrue("Password with multiple special chars should be valid", 
                   Login.verifyPassword("Test@123#"));
    }
    
    @Test
    public void testVerifyPassword_Invalid_TooShort() {
        assertFalse("Password shorter than 8 chars should be invalid", 
                    Login.verifyPassword("Pass1!"));
    }
    
    @Test
    public void testVerifyPassword_Invalid_NoUppercase() {
        assertFalse("Password without uppercase should be invalid", 
                   Login.verifyPassword("password1!"));
    }
    
    @Test
    public void testVerifyPassword_Invalid_NoDigit() {
        assertFalse("Password without digit should be invalid", 
                    Login.verifyPassword("Password!"));
    }
    
    @Test
    public void testVerifyPassword_Invalid_NoSpecialChar() {
        assertFalse("Password without special character should be invalid", 
                    Login.verifyPassword("Password1"));
    }
    
    @Test
    public void testVerifyPassword_Invalid_NullInput() {
        assertFalse("Null password should be invalid", 
                    Login.verifyPassword(null));
    }
    
    @Test
    public void testVerifyPassword_Invalid_EmptyString() {
        assertFalse("Empty password should be invalid", 
                    Login.verifyPassword(""));
    }
    
    @Test
    public void testVerifyPassword_Invalid_OnlySpaces() {
        assertFalse("Password with only spaces should be invalid", 
                   Login.verifyPassword("        "));
    }

    // PHONE NUMBER VALIDATION TESTS
    
    @Test
    public void testCheckPhone_Valid_CorrectFormat() {
        assertTrue("Phone +27123456789 (12 chars total) should be valid", 
                  Login.checkPhone("+27123456789"));
    }
    
    @Test
    public void testCheckPhone_Valid_DifferentNumber() {
        assertTrue("Phone +27821234567 should be valid", 
                  Login.checkPhone("+27821234567"));
    }
    
    @Test
    public void testCheckPhone_Invalid_WrongCountryCode() {
        assertFalse("Phone not starting with +27 should be invalid", 
                   Login.checkPhone("+26123456789"));
    }
    
    @Test
    public void testCheckPhone_Invalid_TooShort() {
        assertFalse("Phone shorter than 12 chars should be invalid", 
                   Login.checkPhone("+2712345678")); // 11 chars
    }
    
    @Test
    public void testCheckPhone_Invalid_TooLong() {
        assertFalse("Phone longer than 12 chars should be invalid", 
                    Login.checkPhone("+271234567890")); // 13 chars
    }
    
    @Test
    public void testCheckPhone_Invalid_NonDigitAfterPrefix() {
        assertFalse("Phone with letter after +27 should be invalid", 
                    Login.checkPhone("+2712345678a"));
    }
    
    @Test
    public void testCheckPhone_Invalid_SpecialCharInNumber() {
        assertFalse("Phone with special char after +27 should be invalid", 
                    Login.checkPhone("+27123-45678"));
    }
    
    @Test
    public void testCheckPhone_Invalid_NullInput() {
        assertFalse("Null phone number should be invalid", 
                    Login.checkPhone(null));
    }
    
    @Test
    public void testCheckPhone_Invalid_EmptyString() {
        assertFalse("Empty phone number should be invalid", 
                    Login.checkPhone(""));
    }
    
}
