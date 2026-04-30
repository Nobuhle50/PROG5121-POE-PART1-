/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrationsystem;

/**
 *
 * @author Student
 */
public class Login {
    // Username: must contain underscore AND be ≤5 characters
    public static boolean verifyUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }
    
    // Password: ≥8 chars, 1 uppercase, 1 digit, 1 special character (no regex)
    public static boolean verifyPassword(String password) {
        if (password == null || password.length() < 8) return false;
        
        boolean hasUpper = false, hasNumber = false, hasSpecial = false;
        
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasNumber = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }
        return hasUpper && hasNumber && hasSpecial;
    }
    
    // Phone: must start with +27 and have exactly 12 characters total (+27 + 9 digits)
    public static boolean checkPhone(String cellPhoneNumber) {
        if (cellPhoneNumber == null || !cellPhoneNumber.startsWith("+27")) return false;
        if (cellPhoneNumber.length() != 12) return false; // +27 = 3 chars + 9 digits
        
        for (int i = 3; i < cellPhoneNumber.length(); i++) {
            if (!Character.isDigit(cellPhoneNumber.charAt(i))) return false;
        }
        return true;
    }
    
}
