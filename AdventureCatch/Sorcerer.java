public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0)
            throw new DeadCharacterException(this);
    }

    @Override
    public void attack(Character character) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0)
            throw new DeadCharacterException(this);
        this.heal(this);
        int damageToDeal = this.getWeapon() != null ? this.getWeapon().getDamage() : 10;
        character.takeDamage(damageToDeal);
    }

    @Override
    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, this.getCurrentHealth() - damage);
        this.setCurrentHealth(actualDamage);
    }

    @Override
    public String toString() {
        String base;
        if (this.getCurrentHealth() <= 0) {
            base = this.getName() + " is a dead sorcerer. So bad, it could heal " + this.healCapacity + " HP.";
        } else {
            base = this.getName() + " is a sorcerer with " + this.getCurrentHealth() + " HP. It can heal "
                    + this.healCapacity + " HP.";
        }
        if (this.getWeapon() != null) {
            base = base + " He has the weapon " + this.getWeapon().toString() + ".";
        }
        return base;
    }
}
