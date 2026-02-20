package TikTacToe.TikTacToe;

public class TikTacToe {
    public static void main(String[] args) {
        GameState game = new GameState();
        
        while(true) {
            boolean didEnd = game.turn();
            if(didEnd == true) {
                break;
            }
        }
    }
}
