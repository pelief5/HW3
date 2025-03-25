/**
 * HW3.java
 *
 * This file contains example classes and tests for:
 * 1. Navigation
 * 2. User Registration
 * 3. Calculation Accuracy
 * 4. Password Strength
 * 5. Data Persistence
 *
 * Run this file in Eclipse to execute all tests from the main method.
 *
 * Author: <Your Name>
 * Date:   <Date>
 */


/**
 * The Navigation class simulates moving between pages.
 */
class Navigation {

    /**
     * Simulates navigating to a given page.
     * @param pageName The name of the page to navigate to.
     * @return The page name, if navigation is successful.
     */
    public String navigateTo(String pageName) {
       
        return pageName;
    }
}


/**
 * The UserRegistration class simulates creating a new user account.
 */
class UserRegistration {

   
    private static java.util.Map<String, String> userDatabase = new java.util.HashMap<>();

    /**
     * Registers a user with a username and password.
     * @param username The chosen username.
     * @param password The chosen password.
     * @return true if registration is successful, false otherwise.
     */
    public boolean registerUser(String username, String password) {
      
        if (userDatabase.containsKey(username)) {
            return false;
        }
        
        userDatabase.put(username, password);
        return true;
    }

    /**
     * Checks if a user is already registered.
     * @param username The username to check.
     * @return true if the user exists, false otherwise.
     */
    public boolean isUserRegistered(String username) {
        return userDatabase.containsKey(username);
    }
}


/**
 * The Calculation class simulates simple arithmetic operations.
 */
class Calculation {

    /**
     * Adds two numbers and returns the result.
     * @param a First number.
     * @param b Second number.
     * @return The sum of a and b.
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Multiplies two numbers and returns the result.
     * @param a First number.
     * @param b Second number.
     * @return The product of a and b.
     */
    public int multiply(int a, int b) {
        return a * b;
    }
}


/**
 * The PasswordChecker class checks if a password is strong enough.
 */
class PasswordChecker {

    /**
     * Checks if the password meets the required rules.
     * For this example: 
     *   - At least 8 characters 
     *   - Contains letters and numbers
     * @param password The password to check.
     * @return true if the password is considered strong, false otherwise.
     */
    public boolean isPasswordStrong(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLetter = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }

        return hasLetter && hasDigit;
    }
}


/**
 * The DataStorage class simulates saving and retrieving data.
 */
class DataStorage {

    
    private static java.util.Map<String, String> dataMap = new java.util.HashMap<>();

    /**
     * Saves data with a key and value.
     * @param key The unique key for the data.
     * @param value The value to store.
     */
    public void saveData(String key, String value) {
        dataMap.put(key, value);
    }

    /**
     * Retrieves data by its key.
     * @param key The unique key used to store the data.
     * @return The stored value, or null if not found.
     */
    public String retrieveData(String key) {
        return dataMap.get(key);
    }
}


/**
 * The HW3 class contains the main method to run all tests.
 */
public class HW3 {

    public static void main(String[] args) {
       
        testNavigation();
        testUserRegistration();
        testCalculationAccuracy();
        testPasswordStrength();
        testDataPersistence();
    }

    
    /**
     * Tests if navigation to a page works correctly.
     * In a real app, we'd verify that the user is on the correct page.
     */
    public static void testNavigation() {
        Navigation navigation = new Navigation();
        String pageName = "HomePage";

        
        String result = navigation.navigateTo(pageName);

        if (pageName.equals(result)) {
            System.out.println("[PASS] Navigation Test: Successfully navigated to " + pageName);
        } else {
            System.out.println("[FAIL] Navigation Test: Expected " + pageName + ", but got " + result);
        }
    }

   
    /**
     * Tests user registration by creating a new user and checking if they exist.
     */
    public static void testUserRegistration() {
        UserRegistration userReg = new UserRegistration();

        String username = "testUser";
        String password = "testPassword123";

        boolean registrationResult = userReg.registerUser(username, password);

        if (registrationResult && userReg.isUserRegistered(username)) {
            System.out.println("[PASS] User Registration Test: " + username + " registered successfully.");
        } else {
            System.out.println("[FAIL] User Registration Test: Could not register " + username);
        }

       
        boolean secondTry = userReg.registerUser(username, password);
        if (!secondTry) {
            System.out.println("[PASS] User Registration Test: Duplicate registration blocked.");
        } else {
            System.out.println("[FAIL] User Registration Test: Duplicate registration was not blocked.");
        }
    }

   
    /**
     * Tests calculation methods (addition, multiplication) for correct results.
     */
    public static void testCalculationAccuracy() {
        Calculation calc = new Calculation();

        int addResult = calc.add(5, 7);
        if (addResult == 12) {
            System.out.println("[PASS] Calculation Accuracy Test (Add): 5 + 7 = 12");
        } else {
            System.out.println("[FAIL] Calculation Accuracy Test (Add): Expected 12, got " + addResult);
        }

        int multiplyResult = calc.multiply(3, 4);
        if (multiplyResult == 12) {
            System.out.println("[PASS] Calculation Accuracy Test (Multiply): 3 * 4 = 12");
        } else {
            System.out.println("[FAIL] Calculation Accuracy Test (Multiply): Expected 12, got " + multiplyResult);
        }
    }

   
    /**
     * Tests the password checker to ensure it enforces the minimum rules.
     */
    public static void testPasswordStrength() {
        PasswordChecker checker = new PasswordChecker();

        String weakPassword = "abc";            
        String strongPassword = "abc12345";     

        boolean weakResult = checker.isPasswordStrong(weakPassword);
        boolean strongResult = checker.isPasswordStrong(strongPassword);

        if (!weakResult) {
            System.out.println("[PASS] Password Strength Test: Weak password was correctly rejected.");
        } else {
            System.out.println("[FAIL] Password Strength Test: Weak password was incorrectly accepted.");
        }

        if (strongResult) {
            System.out.println("[PASS] Password Strength Test: Strong password was correctly accepted.");
        } else {
            System.out.println("[FAIL] Password Strength Test: Strong password was incorrectly rejected.");
        }
    }

    
    /**
     * Tests saving and retrieving data to ensure no information is lost.
     */
    public static void testDataPersistence() {
        DataStorage storage = new DataStorage();

        String key = "greeting";
        String value = "Hello, World!";

      
        storage.saveData(key, value);

        
        String retrieved = storage.retrieveData(key);

        if (value.equals(retrieved)) {
            System.out.println("[PASS] Data Persistence Test: Data was saved and retrieved correctly.");
        } else {
            System.out.println("[FAIL] Data Persistence Test: Expected '" + value + "', got '" + retrieved + "'");
        }
    }
}

