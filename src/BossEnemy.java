// Boss enemy with stronger stats
public class BossEnemy extends Enemy {

    // Boss constructor
    public BossEnemy(){

        setName("Boss");

        setMaxHp(50);
        setHp(50);

        setDamage(6);

        setHealsLeft(2);
        setDefensesLeft(2);

        setHealPower(5);

        System.out.println("Boss appeared!");
    }
}