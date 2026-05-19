public class Character {
    private String name;
    private int maxHp;
    private int hp;
    private int damage;
//    private int speed;
//    private int position;
    private boolean isAlive = true;

    public Character(){
        this("someone", 10, 2);
    }

    public Character(String name, int maxHp, int damage){
        this.name = name;
        this.maxHp = maxHp;
        this.damage = damage;
        hp = maxHp;
    }


    public void attack(Character other){
        System.out.println("Attack!!!");

        other.takeDamage(getDamage());
    }

    public void heal(int amount){
        System.out.println("Heal!");

        hp += amount;
        if(hp > maxHp){
            hp = maxHp;
        }
    }

    public void defence(){
        System.out.println("defence");
    }

    public void takeDamage(int dmg){
        hp -= Math.abs(dmg);

        if(hp<0){
            hp = 0;
        }
    }

    public void addDamage(int damage){
        this.damage += damage;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setMaxHp(int maxHp) {this.maxHp = maxHp;}
    public int getMaxHp() {return maxHp;}

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public void setDamage(int damage) { this.damage = damage; }
    public int getDamage() { return damage; }

    public boolean isAlive() { return isAlive; }
    public void setAlive(boolean alive) { isAlive = alive; }


//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
//    public void addSpeed(int speed){
//        this.speed += speed;
//    }
//
//    public int getSpeed() {
//        return speed;
//    }
//
//
//    public void addPosition(int pos){
//
//    }
//
//    public int getPosition() {
//        return position;
//    }
}
