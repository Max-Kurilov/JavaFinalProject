import java.util.Scanner;

// Main game class that controls the game flow
public class Game {

    // Scanner used for player input
    Scanner scanner = new Scanner(System.in);

    // Creates the player object
    Player player = new Player("someone");

    // Current enemy object
    Enemy enemy;

    // Upgrade system object
    Upgrade upgrade = new Upgrade();

    // Starts a completely new game
    public void newGame() {

        System.out.println("New Game!");

        // Recursive countdown before game starts
        countdown(3);

        // Loop for 10 enemy waves
        for (int i = 1; i <= 10; i++) {

            System.out.println("Wave " + i + "!");

            // Creates a boss on the final wave
            if (i != 10){
                enemy = new Enemy();
            }else{
                enemy = new BossEnemy();

                System.out.println("Boss!");
            }

            // Gives enemies random upgrades each wave
            for(int j = 1; j < i; j++){
                enemy.randomUpgrade();
            }

            // Displays player stats
            System.out.println("=== Player Stats ===");
            System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp());
            System.out.println("Damage: " + player.getDamage());

            // Displays enemy stats
            System.out.println("=== Enemy Stats ===");
            System.out.println("HP: " + enemy.getHp() + "/" + enemy.getMaxHp());
            System.out.println("Damage: " + enemy.getDamage());

            // Main combat loop
            while (true){

                // Ends game if player dies
                if(!player.isAlive()){

                    System.out.println(player.getName() + " dead!");
                    System.out.println("Game Over!");

                    return;

                    // Ends wave if enemy dies
                }else if(!enemy.isAlive()){

                    System.out.println("Enemy " + i + " is dead!");

                    // Gives player an upgrade after winning
                    upgrade.giveUpgrade(player);

                    break;
                }

                // Resets player action states each turn
                player.resetStates();

                // Player input loop
                while (true){

                    String command = scanner.nextLine();

                    // Player attacks enemy
                    if (command.equals("attack")){

                        player.attack(enemy);

                        break;

                        // Player heals
                    }else if (command.equals("heal")){

                        if(player.useHeal()){
                            System.out.println("Heal used!");
                        }else{
                            System.out.println("Cannot heal!");
                        }

                        // Player uses defence
                    }else if (command.equals("defence")){

                        if(player.useDefence()){
                            System.out.println("Defence!");
                        }else{
                            System.out.println("Cannot defence!");
                        }

                        // Ends player turn
                    }else if (command.equals("skip")){

                        break;

                        // Stops the game
                    }else if(command.equals("stop")){

                        System.out.println("Game Finished.");

                        return;

                        // Invalid command
                    }else{

                        System.out.println("Unknow command.");

                        System.out.println();
                        System.out.println("Commands:");
                        System.out.println("attack");
                        System.out.println("heal");
                        System.out.println("defence");
                        System.out.println("skip");
                        System.out.println("stop");
                        System.out.println();
                    }
                }

                // Enemy turn
                if(enemy.isAlive()) {

                    System.out.println("Enemy turn!");

                    enemy.makeMove(player);
                }

                // Shows current health after each turn
                System.out.println("Player HP: " + player.getHp() + "/" + player.getMaxHp());
                System.out.println("Enemy HP: " + enemy.getHp() + "/" + enemy.getMaxHp());
            }
        }
    }

    // Recursive countdown method
    public void countdown(int number){

        // Base case
        if(number <= 0){

            System.out.println("Start!");

            return;
        }

        // Prints current countdown number
        System.out.println(number);

        // Recursive call
        countdown(number - 1);
    }
}