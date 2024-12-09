public class Game {
        public String difficulty;

        public Game(String difficulty){
                this.difficulty = difficulty;
                Grid grid = new Grid(difficulty);

        }
}
