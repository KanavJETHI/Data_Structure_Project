import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Add_Player {

    private List<String> players = new ArrayList<>();

    public void addPlayer(String playerName) {
        players.add(playerName);
        System.out.println(playerName + " is added to the tournament.");
    }

    public void displayPlayers() {
        System.out.println("Players in the tournament:");
        for (String player : players) {
            System.out.println(player);
        }
    }

    public static void main(String[] args) {
        Add_Player tournamentManager = new Add_Player();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Tournament Manager:");
            System.out.println("1. Add Player to Tournament");
            System.out.println("2. Display Players");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the player's name: ");
                    String playerName = scanner.nextLine();
                    tournamentManager.addPlayer(playerName);
                    break;
                case 2:
                    tournamentManager.displayPlayers();
                    break;
                case 3:
                    System.out.println("Exiting Tournament Manager.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
