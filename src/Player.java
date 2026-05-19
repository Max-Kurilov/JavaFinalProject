public class Player extends Character{
    private int level;
    private int numAbilities;
    private int healsLeft;

    private int healPower = 2;

    public Player(String name){
        setName(name);

        level = 0;
        numAbilities = 0;
        healsLeft = 1;
    }

    public void useHeal(){
        if(healsLeft > 0){
            heal(healPower);
        }
    }
}
