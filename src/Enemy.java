import java.util.Random;

// Enemy class controlled by simple AI
public class Enemy extends Character {

    // Used for random enemy decisions
    private Random random = new Random();

    // Enemy constructor
    public Enemy() {

        super("Enemy", 6, 1, 1, 1, 2);

        System.out.println("New Enemy!");
    }

    // Enemy AI turn logic
    public void makeMove(Player player) {

        // Enemy may heal at low HP
        if(getHp() <= getMaxHp() / 3) {

            int healChance = random.nextInt(100);

            if(healChance < 50) {

                if(useHeal()) {

                    System.out.println(getName() + " used heal!");

                    return;
                }
            }
        }

        // Enemy may defend
        int defenceChance = random.nextInt(100);

        if(defenceChance < 25) {

            if(useDefence()) {

                System.out.println(getName() + " defended!");

                return;
            }
        }

        // Enemy attacks player
        attack(player);
    }

    // Gives enemy a random upgrade
    public void randomUpgrade() {

        Random random = new Random();

        int buff = random.nextInt(5);

        switch (buff){

            case 0:
                setDamage(getDamage() + 1);
                break;

            case 1:
                setMaxHp(getMaxHp() + 2);
                setHp(getMaxHp());
                break;

            case 2:
                setDefensesLeft(getDefensesLeft() + 1);
                break;

            case 3:
                setHealsLeft(getHealsLeft() + 1);
                break;

            case 4:
                setHealPower(getHealPower() + 1);
                break;
        }
    }
}