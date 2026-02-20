import javax.swing.JOptionPane;

public class PlayGame {
    public static void main(String[] args) {
        Character hero = new Character("Hero", 10, 5, 2);
        Character enemy = new Character("Enemy", 6, 3, 1);

        CombatScene scene1 = new CombatScene(hero, enemy);
        
        while(true) {
            
            scene1.play();

            if(scene1.getEnemy().getHp() <= 0) {
                JOptionPane.showMessageDialog(null, "You Win!");
                break;
            } else if (scene1.getHero().getHp() <= 0) {
                JOptionPane.showMessageDialog(null, "You Lose!");
                break;
            }
        }
        JOptionPane.showMessageDialog(null, "Game Over");
    }
}
