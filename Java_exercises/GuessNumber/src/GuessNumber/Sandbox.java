package GuessNumber;

public class Sandbox {
    public static void main(String[] args) {

        Game game1 = new Game(Dealer.numberGenerator());
        Player player1 = new Player(Dealer.numberGenerator());


        game1.Compare(player1.playerNumber, game1.gameNumber);


    }
}



























/*while (playerNumber != gameNumber) {
            if(playerNumber = gameNumber) {
                System.out.println("You won!");
            }
            else {
                return playerNumber = Dealer.numberGenerator();

        }


    }
}
*/