public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0)
            throw new DeadCharacterException(this);
        int newHealth = Math.min(character.getMaxHealth(), character.getCurrentHealth() + this.healCapacity);

        character.setCurrentHealth(newHealth);
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public String toString() {
        String base;
        if (this.getCurrentHealth() <= 0) {
            base = this.getName() + " has been beaten, even with its " + this.shield + " shield. So bad, it could heal "
                    + this.healCapacity + " HP.";
        } else {
            base = this.getName() + " is a strong Templar with " + this.getCurrentHealth() + " HP. It can heal "
                    + this.healCapacity + " HP and has a shield of " + this.shield + ".";

        }
        if (this.getWeapon() != null) {
            base = base + " He has the weapon " + this.getWeapon().toString() + ".";
        }
        return base;
    }

    @Override
    public void attack(Character character) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0)
            throw new DeadCharacterException(this);
        this.heal(this);
        int damageToDeal = this.getWeapon() != null ? this.getWeapon().getDamage() : 6;
        character.takeDamage(damageToDeal);
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0)
            throw new DeadCharacterException(this);
        int actualDamage = Math.max(0, damage - this.shield);

        this.setCurrentHealth(Math.max(0, this.getCurrentHealth() - actualDamage));
    }

}