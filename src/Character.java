// Base character class used by players and enemies
public class Character {

    private String name;

    private int maxHp;
    private int hp;
    private int damage;

    // Critical hit chance
    private double critChance;

    private int healsLeft;
    private int defensesLeft;
    private int healPower;

    private boolean isAlive;
    private boolean defended;

    // Prevents multiple heals/defences in one turn
    private boolean usedHeal;
    private boolean usedDefence;

    // Default constructor
    public Character(){
        this("Nobody", 10, 2, 1, 1, 2);
    }

    // Main constructor
    public Character(String name, int maxHp, int damage, int healsLeft, int defensesLeft, int healPower){

        this.name = name;

        this.maxHp = maxHp;
        this.damage = damage;

        // Default crit chance is 10%
        this.critChance = 0.1;

        this.healsLeft = healsLeft;
        this.defensesLeft = defensesLeft;
        this.healPower = healPower;

        hp = maxHp;

        isAlive = true;
        defended = false;

        usedHeal = false;
        usedDefence = false;
    }

    // Basic attack method
    public void attack(Character other){

        System.out.println("Attack!!!");

        // Blocks attack if defending
        if(other.isDefended()) {

            other.setDefended(false);

            return;
        }

        // Critical hit system
        if(Math.random() < critChance){

            other.takeDamage(getDamage() * 2);

        } else{

            other.takeDamage(getDamage());
        }
    }

    // Reduces hp when taking damage
    public void takeDamage(int dmg){

        hp -= Math.abs(dmg);

        // Character dies at 0 hp
        if(hp<=0){

            hp = 0;

            setAlive(false);
        }
    }

    // Heals character hp
    public void heal(){

        System.out.println("Heal!");

        hp += healPower;

        // Prevents hp going above max hp
        if(hp > maxHp){
            hp = maxHp;
        }
    }

    // Enables defence state
    public void defence(){

        System.out.println("defence");

        setDefended(true);
    }

    // Uses one heal action
    public boolean useHeal(){

        if(getHealsLeft() <= 0 || getHp() >= getMaxHp() || isUsedHeal()){
            return false;
        }

        heal();

        setHealsLeft(getHealsLeft()-1);
        setUsedHeal(true);

        return true;
    }

    // Uses one defence action
    public boolean useDefence(){

        if(getDefensesLeft() <= 0 || isDefended() || isUsedDefence()){
            return false;
        }

        defence();

        setDefensesLeft(getDefensesLeft()-1);
        setUsedDefence(true);

        return true;
    }

    // Resets turn action states
    public void resetStates(){

        usedHeal = false;
        usedDefence = false;
    }

    // Getters and setters below
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setMaxHp(int maxHp) {this.maxHp = maxHp;}
    public int getMaxHp() {return maxHp;}

    public void setHp(int hp) { this.hp = hp; }
    public int getHp() { return hp;}

    public void setDamage(int damage) { this.damage = damage; }
    public int getDamage() { return damage; }

    public void setCritChance(double critChance) { this.critChance = critChance; }
    public double getCritChance() { return critChance; }

    public void setHealsLeft(int healsLeft) {this.healsLeft = healsLeft; }
    public int getHealsLeft() { return healsLeft; }

    public void setDefensesLeft(int defensesLeft) { this.defensesLeft = defensesLeft;}
    public int getDefensesLeft() { return defensesLeft; }

    public void setHealPower(int healPower) { this.healPower = healPower; }
    public int getHealPower() { return healPower; }

    public void setAlive(boolean alive) { isAlive = alive; }
    public boolean isAlive() { return isAlive; }

    public void setDefended(boolean defended) {this.defended = defended; }
    public boolean isDefended() { return defended; }

    public void setUsedHeal(boolean usedHeal) { this.usedHeal = usedHeal; }
    public boolean isUsedHeal(){ return usedHeal; }

    public void setUsedDefence(boolean usedDefence) { this.usedDefence = usedDefence; }
    public boolean isUsedDefence(){ return usedDefence; }
}
