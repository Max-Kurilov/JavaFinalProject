public class Character {
    private String name;
    private int maxHp;
    private int hp;
    private int damage;
//    private int speed;
//    private int position;


    public Character(){
        this("someone", 10, 5);
    }

    public Character(String name, int maxHp, int damage){
        this.name = name;
        this.maxHp = maxHp;
        this.damage = damage;
        hp = maxHp;
    }


    public void attack(){
        System.out.println("Attack!!!");
    }

    public void heal(){
        System.out.println("Heal!");
    }

    public void defence(){
        System.out.println("defence");
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setMaxHp(int maxHp) {this.maxHp = maxHp;}
    public void addHp(int hp){
        this.maxHp += hp;
    }
    public int getMaxHp() {return maxHp;}

    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getHp() {
        return hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void addDamage(int damage){
        this.damage += damage;
    }
    public int getDamage() {
        return damage;
    }


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
