public class Player extends Character{
    private int level;
    private int numAbilities;
    private int healsLeft;
    private int defensesLeft;

    private int healPower = 2;

    public Player(String name){
        setName(name);

        level = 0;
        numAbilities = 0;
        healsLeft = 1;
        defensesLeft = 1;
    }

    public void useHeal(){
        if(healsLeft > 0 && getHp() < getMaxHp()){
            heal(healPower);
            healsLeft--;
        }
    }

    public void useDefence(){
        if(defensesLeft > 0 && !getDefended()){
            defence();
            defensesLeft--;
        }
    }
}
