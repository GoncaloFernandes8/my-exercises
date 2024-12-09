package GuessNumber;

public class Game {
    public int gameNumber;
    public int playerNumber;
    public boolean x = false;
    public int counter;

    public Game(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public void Compare(int gameNumber, int playerNumber) {
        this.playerNumber = playerNumber;
        this.gameNumber = gameNumber;
        while (x == false) {
            counter++;
            if (gameNumber == this.playerNumber) {
                System.out.println("Player chose: " + this.playerNumber);
                System.out.println("Game chose: " + this.gameNumber);
                System.out.println("You won! \uD83C\uDF89");
                System.out.println("You tried: " + counter + " times.");
                x = true;
            } else {
                System.out.println("Player chose: " + this.playerNumber);
                System.out.println("Game chose: " + this.gameNumber);
                System.out.println("Try again ❌");
                this.playerNumber = Dealer.numberGenerator();
            }
        }
    }
}
