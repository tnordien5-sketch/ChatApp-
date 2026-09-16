import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // Create a Login object to test
    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login();
        // We pre-register a user to test the login functionality later
        login.setFirstName("John");
        login.setLastName("Doe");
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
    }

    // --- assertEquals Tests ---

    @Test
    public void testUsernameCorrectlyFormatted() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        // The system returns the success message
        assertEquals("Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.", result);
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        String result = login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        // The system returns the error message for username
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testPasswordMeetsComplexity() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        // The system returns the success message
        assertEquals("Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.", result);
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        String result = login.registerUser("kyl_1", "password", "+27838968976");
        // The system returns the error message for password
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        // The system returns the success message
        assertEquals("Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.", result);
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        String result = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553");
        // The system returns the error message for cell number
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.", result);
    }

    // --- assertTrue / assertFalse Tests ---

    @Test
    public void testLoginSuccessful() {
        // Using the pre-registered user from setUp()
        boolean isLoggedIn = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(isLoggedIn);
    }

    @Test
    public void testLoginFailed() {
        // Using incorrect credentials
        boolean isLoggedIn = login.loginUser("kyl_1", "wrongPassword");
        assertFalse(isLoggedIn);
    }

    @Test
    public void testUsernameCorrectFormat() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectFormat() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordCorrectFormat() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordIncorrectFormat() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneCorrectFormat() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectFormat() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}
