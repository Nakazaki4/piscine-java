public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public String toString() {
        String base;
        if (this.getCurrentHealth() > 0) {
            base = String.format("%s is a monster with %d HP", this.getName(), this.getCurrentHealth());
        } else {
            base = String.format("%s is a monster and is dead", this.getName());
        }

        if (this.weapon != null) {
            base = base + " He has the weapon " + this.weapon.toString() + ".";
        }
        return base;
    }

    @Override
    public void takeDamage(int damage) {
        int realDamage = (int) (damage * 0.8);
        this.setCurrentHealth(Math.max(0, this.getCurrentHealth() - realDamage));
    }

    @Override
    public void attack(Character character) {
        int damageToDeal = this.weapon != null ? this.weapon.getDamage() : 7;
        character.takeDamage(damageToDeal);
    }
}
