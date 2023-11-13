import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Hero hero = new Hero(50, 4, 2, 3);
    static Monster monster = new Monster(120, 3);

    static boolean exsits = false;

    public static void main(String[] args) {

        hero.info();
        monster.info();
        while (true) {
            playerTurn();
            if (exsits){
                System.out.println("Рыцарь победил");
                break;
            }
            monsterTurn();
            if (exsits){
                System.out.println("Орк победил");
                break;
            }
        }
        System.out.println("Игра завершена");
    }

    public static void monsterTurn(){
        System.out.println("Ход Орка.");
        if (Math.random() < 0.5) {
            System.out.println("Орк атаковал рыцаря");
            hero.takeDamage(monster.getAttack());
            hero.info();
            if (hero.isDead()) {
                exsits = true;
            }
        } else {
            monster.angry();
        }
        System.out.println();
    }

    public static void playerTurn() {
        System.out.println("Ход рыцаря. Выберите: 1 - атаковать, 2 - отдохнуть, 3 - воспользовать магией ");
        int heroAction = scanner.nextInt();
        if (heroAction == 1) {
            System.out.println("Рыцарь атаковал Орка, нанес ему " + hero.getAttack() + " ед. урона");
            monster.takeDamage(hero.getAttack());
            monster.info();
            if (monster.isDead()) {
                exsits = true;
//                System.out.println("Рыцарь победил");
            }
        } else if (heroAction == 2) {
            hero.rest();
        } else if (heroAction == 3) {
            if (hero.getMagicSkill() != 0) {
                int magicSkillAttack = hero.magicSkillAttack();
                System.out.println("Рыцарь использует магию и нанес орку: " + magicSkillAttack);
                monster.takeDamage(magicSkillAttack);
                System.out.println("Осталось магии: " + hero.getMagicSkill());
            } else {
                System.out.println("У вас закончилась магия. Магия: 0, сделайте другой ход");
                heroAction = scanner.nextInt();
                if (heroAction == 1) {
                    System.out.println("Рыцарь атаковал Орка, нанес ему " + hero.getAttack() + " ед. урона");
                    monster.takeDamage(hero.getAttack());
                    monster.info();
                    if (monster.isDead()) {
//                        System.out.println("Рыцарь победил");
                        exsits = true;
                    }
                } else if (heroAction == 2) {
                    hero.rest();
                }
                System.out.println("Орк HP: " + monster.getHp() + " ATT: " + monster.getAttack());
            }
        } else {
            hero.skipTurn();
        }
        System.out.println();
    }
}

