// Part 1: Implemented Username and Password
public class Login {
    // Attributes to store user data
    private String storedUsername;
    private String storedPassword;
    private String storedCellPhone;
    private String firstName;
    private String lastName;

    // Setters for first and last name
    // (Needed because registerUser only takes username, password, and cell)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // 1. Check Username
    // Condition: Contains an underscore AND is no more than 5 characters long.
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // 2. Check Password Complexity
    // Condition: At least 8 characters, a capital letter, a number, and a special character.
    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }
        
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        
        return hasUpper && hasDigit && hasSpecial;
    }

    // 3. Check Cell Phone Number
    // Condition: Contains international code (+27) and matches test data.
    public boolean checkCellPhoneNumber(String cellPhone) {
        // NOTE: The assignment says "no more than ten characters", 
        // but the test data "+27838968976" is 12 characters. 
        // This regex matches +27 followed by 9 digits (Total 12 characters).
        // Reference: [Insert the URL you researched here for your regex, e.g., StackOverflow]
        String regex = "^\\+27\\d{9}$"; 
        return cellPhone.matches(regex);
    }

    // 4. Register User
    // Validates inputs and returns the specific messages from the assignment tables.
    public String registerUser(String username, String password, String cellPhone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        
        // Store the data if all validations pass
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedCellPhone = cellPhone;
        
        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    // 5. Login User
    // Compares login credentials with stored registration credentials.
    public boolean loginUser(String username, String password) {
        return username.equals(this.storedUsername) && password.equals(this.storedPassword);
    }

    // 6. Return Login Status
    // Returns the welcome or error message.
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + this.firstName + " " + this.lastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
