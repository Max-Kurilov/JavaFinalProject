// Player class that inherits from Character
public class Player extends Character{

    // Creates a player with a custom name
    public Player(String name){
        setName(name);
    }

    // Overridden attack method with block break chance
    @Override
    public void attack(Character other){

        System.out.println(getName() + " attacks!");

        // 25% chance to ignore defence
        boolean blockBreak = Math.random() < 0.25;

        // Normal defence block
        if(other.isDefended() && !blockBreak) {

            other.setDefended(false);

            System.out.println(other.getName() + " blocked the attack!");

            return;
        }

        // Successful block break
        if(blockBreak && other.isDefended()){
            System.out.println("Block broken!");
        }

        // Critical hit system
        if(Math.random() < getCritChance()){

            System.out.println("Critical hit!");

            other.takeDamage(getDamage() * 2);

            System.out.println(other.getName() + " took " + (getDamage() * 2) + " damage!");

        } else{

            other.takeDamage(getDamage());

            System.out.println(other.getName() + " took " + getDamage() + " damage!");
        }
    }
}