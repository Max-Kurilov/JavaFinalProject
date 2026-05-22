public class Character {
    private String name;
    private int maxHp;
    private int hp;
    private int damage;

    private int healsLeft;
    private int defensesLeft;
    private int healPower;

    private boolean isAlive;
    private boolean defended;
    private boolean usedHeal;
    private boolean usedDefence;

    public Character(){
        this("Nobody", 10, 2, 1, 1, 2);
    }

    public Character(String name, int maxHp, int damage, int healsLeft, int defensesLeft, int healPower){
        this.name = name;
        this.maxHp = maxHp;
        this.damage = damage;

        this.healsLeft = healsLeft;
        this.defensesLeft = defensesLeft;
        this.healPower = healPower;

        hp = maxHp;
        isAlive = true;
        defended = false;
        usedHeal = false;
        usedDefence = false;
    }


    public void attack(Character other){
        System.out.println("Attack!!!");

        if(!other.defended) {
            other.takeDamage(getDamage());
        }
    }

    public void takeDamage(int dmg){
        hp -= Math.abs(dmg);

        if(hp<=0){
            hp = 0;
            setAlive(false);
        }
    }

    public void heal(){
        System.out.println("Heal!");

        hp += healPower;
        if(hp > maxHp){
            hp = maxHp;
        }
    }

    public void defence(){
        System.out.println("defence");

        setDefended(true);
    }

    public void endDefence(){
        if (defended){
            setDefended(false);
        }
    }

    public void resetStates(){
        usedHeal = false;
        usedDefence = false;
    }


    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setMaxHp(int maxHp) {this.maxHp = maxHp;}
    public int getMaxHp() {return maxHp;}

    public void setHp(int hp) { this.hp = hp; }
    public int getHp() { return hp;}

    public void setDamage(int damage) { this.damage = damage; }
    public int getDamage() { return damage; }

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
