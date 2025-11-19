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
   public void heal(Character target) {
      int newHealth = target.getCurrentHealth() + healCapacity;
      if (newHealth > target.getMaxHealth())
         newHealth = target.getMaxHealth();
      target.setCurrentHealth(newHealth);
   }

   @Override
   public int getShield() {
      return shield;
   }

   @Override
   public void attack(Character target) {
      heal(this);
      int dmg = getWeapon() != null ? getWeapon().getDamage() : 6;
      target.takeDamage(dmg);
   }

   @Override
   public void takeDamage(int damage) {
      int reduced = damage - shield;
      if (reduced < 0)
         reduced = 0;
      setCurrentHealth(getCurrentHealth() - reduced);
   }

   @Override
   public String toString() {
      String base = getCurrentHealth() > 0
            ? getName() + " is a strong Templar with " + getCurrentHealth() +
                  " HP. It can heal " + healCapacity + " HP and has a shield of " + shield + "."
            : getName() + " has been beaten, even with its " + shield +
                  " shield. So bad, it could heal " + healCapacity + " HP.";
      if (getWeapon() != null) {
         base += " He has the weapon " + getWeapon().toString();
      }
      return base;
   }
}
