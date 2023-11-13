public class Hero {
    private int hp;
    private int attack;
    private int defence;
    private int magicSkill;

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getMagicSkill() {
        return magicSkill;
    }

    public Hero(int hp, int attack, int defence, int magicSkill) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.magicSkill = magicSkill;
//        if (magicSkill ==0 ){
//            this.magicSkill = 3;
//        }
    }

    public void info() {

        System.out.println("Рыцарь HP: " + hp + " ATT: " + attack + " DEF: " + defence + " MAG: " + magicSkill);
    }

    public void makeAttack() {

    }
    public int magicSkillAttack(){
       magicSkill--;
       return 10 + (int) (Math.random() * 15);
    }

    public void rest() {
        System.out.println("Рыцарь решли отдохнуть и залечить свои раны");
        hp += 2;
    }

    public void skipTurn() {
        System.out.println("Рыцарь решил пропустить свой ход");
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public int takeDamage(int amount) {
        int actualAttackAmount = amount - defence;
        if (actualAttackAmount < 1) {
            actualAttackAmount = 1;
        }
        hp -= actualAttackAmount;
        System.out.println("Рыцарь получил " + actualAttackAmount + " ед. урона");
        return actualAttackAmount;
    }

}
