public class Monster {
    private int hp;
    private int attack;

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public Monster(int hp, int attack) {
        this.hp = hp;
        this.attack = attack;

    }

    public void info() {
        System.out.println("Орк HP: " + hp + " ATT: " + attack);
    }

    public void makeAttack() {

    }

    public boolean isDead() {
        return hp <= 0;
    }


    public void angry(){
        System.out.println("Орк злится");
        attack++;
        System.out.println("Атака Орка становится: " + attack);
    }

    public void takeDamage(int amount) {
        if (Math.random() <0.1){
            System.out.println("Орк увернулся от атаки");
            return;
        }
        hp -= amount;
        System.out.println("Орк получил " + amount + " ед. урона");
    }
}
