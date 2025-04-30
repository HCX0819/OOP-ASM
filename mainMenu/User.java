package mainMenu;
import java.util.Scanner;

public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void updatePersonalInfo(Scanner scanner) {
        System.out.print("Enter new name: ");
        this.name = scanner.nextLine();

        System.out.print("Enter new email: ");
        this.email = scanner.nextLine();

        System.out.println("Personal information updated successfully!");
    }

    public String getName() {
        return name;
    }
}
