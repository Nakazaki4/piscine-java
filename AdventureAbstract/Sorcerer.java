public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) {
        character.setCurrentHealth(character.getCurrentHealth() + healCapacity);
    }

    @Override
    public void attack(Character character) {
        this.heal(this);
        character.takeDamage(10);
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage);
        this.setCurrentHealth(this.getCurrentHealth() - actualDamage);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() <= 0) {
            return this.getName() + " is a dead sorcerer. So bad, it could heal " + this.healCapacity + " HP.";
        }
        return this.getName() + " is a sorcerer with " + this.getCurrentHealth() + " HP. It can heal "
                + this.healCapacity + " HP.";
    }
}
