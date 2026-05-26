import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Handles player upgrades between waves
public class Upgrade {

    // Random object for upgrade selection
    private Random random = new Random();

    // Scanner for player input
    private Scanner scanner = new Scanner(System.in);

    // Upgrade levels
    private int damageLevel = 0;
    private int critLevel = 0;
    private int hpLevel = 0;
    private int defenceLevel = 0;
    private int healLevel = 0;
    private int healPowerLevel = 0;

    // Gives player 3 random upgrades
    public void giveUpgrade(Player player) {

        // Dynamic list of possible upgrades
        ArrayList<String> upgrades = new ArrayList<>();

        // Adds upgrades below max level
        if(damageLevel < 3){
            upgrades.add("damage");
        }

        if(critLevel < 3){
            upgrades.add("crit chance");
        }

        if(hpLevel < 3){
            upgrades.add("max hp");
        }

        if(defenceLevel < 3){
            upgrades.add("defence");
        }

        if(healLevel < 3){
            upgrades.add("heal");
        }

        if(healPowerLevel < 3){
            upgrades.add("heal power");
        }

        // Randomly selects 3 upgrades
        String upgrade1 = upgrades.get(random.nextInt(upgrades.size()));
        String upgrade2 = upgrades.get(random.nextInt(upgrades.size()));
        String upgrade3 = upgrades.get(random.nextInt(upgrades.size()));

        // Upgrade selection menu
        System.out.println("Choose upgrade:");

        System.out.println("1. " + upgrade1);
        System.out.println("2. " + upgrade2);
        System.out.println("3. " + upgrade3);

        int choice = scanner.nextInt();

        String selectedUpgrade;

        // Determines chosen upgrade
        if(choice == 1){

            selectedUpgrade = upgrade1;

        }else if(choice == 2){

            selectedUpgrade = upgrade2;

        }else{

            selectedUpgrade = upgrade3;
        }

        // Applies selected upgrade
        applyUpgrade(player, selectedUpgrade);
    }

    // Applies selected upgrade effects
    public void applyUpgrade(Player player, String upgrade){

        switch (upgrade){

            case "damage":

                damageLevel++;

                player.setDamage(
                        player.getDamage() + damageLevel + 1
                );

                break;

            case "crit chance":

                critLevel++;

                player.setCritChance(
                        player.getCritChance() + 0.05
                );

                break;

            case "max hp":

                hpLevel++;

                player.setMaxHp(
                        player.getMaxHp() + hpLevel + 1
                );

                player.setHp(player.getMaxHp());

                break;

            case "defence":

                defenceLevel++;

                player.setDefensesLeft(
                        player.getDefensesLeft() + defenceLevel
                );

                break;

            case "heal":

                healLevel++;

                player.setHealsLeft(
                        player.getHealsLeft() + healLevel
                );

                break;

            case "heal power":

                healPowerLevel++;

                player.setHealPower(
                        player.getHealPower() + healPowerLevel + 1
                );

                break;
        }
    }
}