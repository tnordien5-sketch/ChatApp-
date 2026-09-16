import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        System.out.println("=== Welcome to the Chat App ===");
        System.out.println("\n--- Registration ---");
        
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your South African cell phone number (e.g., +27838968976): ");
        String cellPhone = scanner.nextLine();

        loginSystem.setFirstName(firstName);
        loginSystem.setLastName(lastName);

        String registrationMessage = loginSystem.registerUser(username, password, cellPhone);
        System.out.println("\n" + registrationMessage);

        System.out.println("\n--- Login ---");
        System.out.print("Enter your username to log in: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter your password to log in: ");
        String loginPassword = scanner.nextLine();

        boolean isLoggedIn = loginSystem.loginUser(loginUsername, loginPassword);
        String loginStatusMessage = loginSystem.returnLoginStatus(isLoggedIn);
        System.out.println("\n" + loginStatusMessage);

        scanner.close();
    }
}
