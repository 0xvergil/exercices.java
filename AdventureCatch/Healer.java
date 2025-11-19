public interface Healer {

   int getHealCapacity();

   void heal(Character target) throws DeadCharacterException;
}