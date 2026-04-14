import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.name = name;
        allCharacters.add(this);
    }

    public static String printStatus() {
        StringBuilder s = new StringBuilder();
        if (allCharacters.isEmpty()) {
            s.append("------------------------------------------\n");
            s.append("Nobody's fighting right now !\n");
            s.append("------------------------------------------\n");
            return s.toString();
        }
        s.append("------------------------------------------\n");
        s.append("Characters currently fighting :\n");
        for (Character character : allCharacters) {
            s.append(String.format(" - %s\n", character.toString()));
        }
        s.append("------------------------------------------\n");
        return s.toString();
    }

    public static Character fight(Character c1, Character c2) {
        while (c1.currentHealth > 0 && c2.currentHealth > 0) {
            c1.attack(c2);
            if (c2.currentHealth <= 0) {
                break;
            }
            c2.attack(c1);
        }
        return c1.currentHealth > 0 ? c1 : c2;
    }

    @Override
    public String toString() {
        if (this.currentHealth <= 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    protected void setCurrentHealth(int newHealth) {
        this.currentHealth = Math.min(maxHealth, newHealth);
    }

    public abstract void takeDamage(int damage);

    public abstract void attack(Character character);
}