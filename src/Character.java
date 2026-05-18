public class Character {
    private String name;
    private int maxHp;
    private int hp;
    private int damage;
//    private int speed;
//    private int position;


    public Character(){
        this("someone", 10, 5, 10);
    }

    public Character(String name, int hp, int damage, int speed){
        this.name = name;
        this.hp = hp;
        this.damage = damage;

    }

    public void attack(){}
    public void heal(){}
    public void defence(){}

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    public void addHp(int hp){
        this.hp += hp;
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
