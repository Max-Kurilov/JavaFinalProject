import java.util.Objects;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Player player = new Player();

    public void newGame() {
        System.out.println("New Game!");

        for (int i = 1; i <= 10; i++) {
            System.out.println("Round " + i + "!");

            if (i != 10){
                Enemy enemy = new Enemy();
            }else{
                BossEnemy boss = new BossEnemy();
                System.out.println("Boss!");
            }

            while (true){
                String command = scanner.nextLine();

                if (command.equals("attack")){

                    System.out.println("Attack!");

                }else if (command.equals("heal")){

                    System.out.println("Heal!");

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