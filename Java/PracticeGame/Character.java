import javax.swing.JOptionPane;

public class Character {
    private String name;
    private int hp;
    private int dam;
    private int def;

    Character(String name, int hp, int dam, int def) {
        this.name = name;
        this.hp = hp;
        this.dam = dam;
        this.def = def;
    }

    public String getName() {
        return name;
    }
    
    public int getHp() {
        return hp;
    }
    public void setHp(int newHp) {
        hp = newHp;
    }

    public int getDam() {
        return dam;
    }
    public void setDam(int newDam) {
        dam = newDam;
    }

    public int getDef() {
        return def;
    }
    public void setDef(int newDef) {
        def = newDef;
    }

    public String showStats() {
        return "" + name + "\nHp: " + hp + "\nDam: " + dam + "\nDef: " + def + "\n\n";
    }

    public Character attack(Character target) {
        int damageInflicted = ((int)(Math.floor((Math.floor(dam/2)) + Math.random() * dam))) - target.getDef();
        if(damageInflicted > 0) {
            JOptionPane.showMessageDialog(null, "Damage inflicted: " + damageInflicted + " to " + target.getName());
            target.hp -= damageInflicted;
            if (target.hp < 0) {
                target.hp = 0;
            }
            return target;
        } else {
            JOptionPane.showMessageDialog(null, "No Damage");
            return target;
        }
    }
}
