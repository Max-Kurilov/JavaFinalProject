import java.util.Objects;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player("someone");

    Enemy enemy;

    public void newGame() {
        System.out.println("New Game!");

        for (int i = 1; i <= 10; i++) {
            System.out.println("Round " + i + "!");

            if (i != 10){
                enemy = new Enemy();
            }else{
                enemy = new BossEnemy();
                System.out.println("Boss!");
            }

            while (true){
                String command = scanner.nextLine();

                if(!player.getIsAlive()){
                    System.out.println(player.getName() + " dead!");
                    System.out.println("Game Over!");
                    return;
                }else if(!enemy.getIsAlive()){
                    System.out.println("Enemy " + i + " is dead!");
                    break;
                }

                if (command.equals("attack")){

                    player.attack(enemy);

                }else if (command.equals("heal")){

                    player.useHeal();

                }else if (command.equals("defence")){

                    System.out.println("Defence!");

                }else if (command.equals("skip")){

                    break;

                }else if(command.equals("stop")){

                    System.out.println("Game Finished.");
                    return;

                }else{
                    System.out.println("unknow command.");
                }
            }
        }

    }

//    public void commands(String command){
//        if(command.equals("attack")){
//
//        }else if(command.equals("defence")){
//
//        }else if(command.equals("heal")){
//
//        }else if(command.equals("stop")){
//
//        }else{
//
//        }
//    }
}