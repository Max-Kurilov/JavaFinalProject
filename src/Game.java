import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player("someone");

    Enemy enemy;

    public void newGame() {
        System.out.println("New Game!");

        for (int i = 1; i <= 10; i++) {
            System.out.println("Wave " + i + "!");

            if (i != 10){
                enemy = new Enemy();
            }else{
                enemy = new BossEnemy();
                System.out.println("Boss!");
            }

            System.out.println("=== Player Stats ===");
            System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp());
            System.out.println("Damage: " + player.getDamage());

            System.out.println("=== Enemy Stats ===");
            System.out.println("HP: " + enemy.getHp() + "/" + enemy.getMaxHp());
            System.out.println("Damage: " + enemy.getDamage());

            int round = 0;
            while (true){
                if(!player.isAlive()){
                    System.out.println(player.getName() + " dead!");
                    System.out.println("Game Over!");
                    return;
                }else if(!enemy.isAlive()){
                    System.out.println("Enemy " + i + " is dead!");
                    break;
                }

                round++;
                if(round % 2 == 1){
                    player.endDefence();
                }else if(round % 2 == 0){
                    enemy.endDefence();
                }

                player.resetStates();
                while (true){
                    String command = scanner.nextLine();

                    if (command.equals("attack")){

                        player.attack(enemy);
                        break;

                    }else if (command.equals("heal")){

                        if(player.useHeal()){
                            System.out.println("Heal used!");
                        }else{
                            System.out.println("Cannot heal!");
                        }

                    }else if (command.equals("defence")){

                        if(player.useDefence()){
                            System.out.println("Defence!");
                        }else{
                            System.out.println("Cannot defence!");
                        }

                    }else if (command.equals("skip")){

                        break;

                    }else if(command.equals("stop")){

                        System.out.println("Game Finished.");
                        return;

                    }else{
                        System.out.println("unknow command.");
                    }
                }


                System.out.println("Player HP: " + player.getHp() + "/" + player.getMaxHp());
                System.out.println("Enemy HP: " + enemy.getHp() + "/" + enemy.getMaxHp());
            }
        }

    }
}