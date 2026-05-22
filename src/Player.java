public class Player extends Character{

    public Player(String name){
        setName(name);

    }

    public boolean useHeal(){
        if(getHealsLeft() <= 0 || getHp() >= getMaxHp() || isUsedHeal()){
            return false;
        }

        heal();

        setHealsLeft(getHealsLeft()-1);
        setUsedHeal(true);

        return true;
    }

    public boolean useDefence(){
        if(getDefensesLeft() <= 0 || isDefended() || isUsedDefence()){
            return false;
        }

        defence();

        setDefensesLeft(getDefensesLeft()-1);
        setUsedDefence(true);

        return true;
    }
}
