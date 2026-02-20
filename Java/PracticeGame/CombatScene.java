import javax.swing.JOptionPane;

public class CombatScene {
    Character player;
    Character npc;

    CombatScene(Character player, Character npc) {
        this.player = player;
        this.npc = npc;
    }

    public Character getHero() {
        return player;
    }
    public Character getEnemy() {
        return npc;
    }

    public void play() {
        JOptionPane.showMessageDialog(null, player.showStats() + npc.showStats());
        //add choices for player here

        //attack if player chooses attack
        player.attack(npc);

        //npc will always attack on their turn
        npc.attack(player);

        JOptionPane.showMessageDialog(null, player.showStats() + npc.showStats());
    }
}
