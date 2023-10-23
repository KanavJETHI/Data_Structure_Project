import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Player {
    String name;
    int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
}

class Game {
    Player player1, player2;
    int player1Score, player2Score;
    Player winner;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1Score = 0;
        this.player2Score = 0;
        this.winner = null;
    }

    public void playGame() {
        // Simulate a game, for simplicity, we'll just assign random scores.
        player1Score = (int) (Math.random() * 21); // Score between 0 and 20
        player2Score = (int) (Math.random() * 21);

        // Ask for the winner's name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the winning player: ");
        String winnerName = scanner.nextLine();

        if (winnerName.equals(player1.name) || winnerName.equals(player2.name)) {
            winner = findPlayerByName(winnerName);
        } else {
            System.out.println("Invalid player name. No winner assigned.");
        }
    }

    private Player findPlayerByName(String name) {
        return name.equals(player1.name) ? player1 : player2;
    }
}

public class _2_Player_Game {

    private ArrayList<Player> players = new ArrayList<>();
    private Queue<Game> games = new LinkedList<>();

    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " has been added to the tournament.");
    }

    public void createGames() {
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                games.add(new Game(players.get(i), players.get(j)));
            }
        }
        System.out.println("Games have been created.");
    }

    public void playGames() {
        while (!games.isEmpty()) {
            Game game = games.poll();
            game.playGame();
            updateScores(game);
        }
    }

    private void updateScores(Game game) {
        Player winner = game.winner;
        if (winner != null) {
            winner.score++; // Increase the winner's score by 1.
        }
    }

    public void displayPlayers() {
        System.out.println("Current players in the tournament:");
        for (Player player : players) {
            System.out.println(player.name);
        }
    }

    public void displayLeaderboard() {
        players.sort((p1, p2) -> Integer.compare(p2.score, p1.score));
        System.out.println("Leaderboard:");
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.println((i + 1) + ". " + player.name + " - " + player.score + " points");
        }
    }

    public static void main(String[] args) {
        _2_Player_Game tournamentManager = new _2_Player_Game();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Tournament Manager Menu:");
            System.out.println("1. Add Player to Tournament");
            System.out.println("2. Create Games");
            System.out.println("3. Play Games");
            System.out.println("4. Display Players");
            System.out.println("5. Display Leaderboard");
            System.out.println("6. Exit");

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
                    tournamentManager.createGames();
                    break;
                case 3:
                    tournamentManager.playGames();
                    break;
                case 4:
                    tournamentManager.displayPlayers();
                    break;
                case 5:
                    tournamentManager.displayLeaderboard();
                    break;
                case 6:
                    System.out.println("Exiting Tournament Manager.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

