public class Monster extends Character {

   public Monster(String name, int maxHealth, Weapon weapon) {
      super(name, maxHealth, weapon);
   }

   @Override
   public void attack(Character target) {
      int dmg = getWeapon() != null ? getWeapon().getDamage() : 7;
      target.takeDamage(dmg);
   }

   @Override
   public void takeDamage(int damage) {
      int reduced = (int) Math.floor(damage * 0.8);
      setCurrentHealth(getCurrentHealth() - reduced);
   }

   @Override
   public String toString() {
      String base = getCurrentHealth() > 0
            ? getName() + " is a monster with " + getCurrentHealth() + " HP"
            : getName() + " is a monster and is dead";
      if (getWeapon() != null) {
         base += ". He has the weapon " + getWeapon().toString();
      }
      return base;
   }
}
