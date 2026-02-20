package TikTacToe.TikTacToe2;

public class TikTacToe2 {
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
